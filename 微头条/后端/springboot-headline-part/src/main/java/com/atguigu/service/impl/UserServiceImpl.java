package com.atguigu.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.MD5Util;
import com.atguigu.utils.Result;
import com.atguigu.utils.ResultCodeEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
* @author Administrator
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-06-14 13:21:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;
    /**
     * 登录业务
     * 1. 根据用户查询对象
     * 2. 如果对象为null登录失败 501
     * 3. 如果信息错误登录失败 503 成功 200
     * 4. 成功生成一个token
     * @param user
     * @return
     */

    @Override
    public Result login(User user) {
        //根据账号查找数据库
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);

        System.out.println("loginUser = " + loginUser);

        //查询不到用户名就返回用户名错误
        if(loginUser == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        //对比密码
        if(!StringUtils.isEmpty(user.getUserPwd())
                && MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())) {
            //登录成功
            //根据用户di生成token
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            //将token封装到result中
            HashMap<String, String> data = new HashMap<>();
            data.put("token", token);

            return Result.ok(data);
        }

        //密码错误
        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }

    /**
     * 根据token获取用户数据
     * 1. token 有效性，是否在有效期
     * 2. 根据token来解析出用户id
     * 3. 根据用户id查询用户信息
     * 4. 去掉密码，封装result结果返回即可
     * @param token
     * @return
     */
    @Override
    public Result getUserInfo(String token) {
        boolean expiration = jwtHelper.isExpiration(token);
        if(expiration){
            //token失效未登录
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }

        int userId = jwtHelper.getUserId(token).intValue();

        //置空密码返回
        User user=userMapper.selectById(userId);
        user.setUserPwd("");

        HashMap<String, User> data = new HashMap<>();
        data.put("loginUser", user);

        return Result.ok(data);
    }

    /**
     * 检查用户名是否占用
     * 1. 检查账号是否占用，进行count查询
     * 2. 如果count大于0，用户名占用，不可用
     *
     * @param username
     * @return
     */
    @Override
    public Result checkUserName(String username) {

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername,username);
        Long count = userMapper.selectCount(userLambdaQueryWrapper);

        if (count == 0){
            return Result.ok(null);
        }else {
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
    }

    /**
     * 注册业务
     * 1. 依然检查账号是否已经被注册
     * 2. 密码加密处理
     * 3. 账号数据保存
     * 4. 返回结果
     * @param user
     * @return
     */
    @Override
    public Result regist(User user) {
        LambdaUpdateWrapper<User> queryWrapper = new LambdaUpdateWrapper<User>();
        queryWrapper.eq(User::getUsername,user.getUsername());

        Long count = userMapper.selectCount(queryWrapper);

        //如果用户名已经存在返回用户名被使用
        if(count>0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        //密码加密后存入数据库
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));

        int insert = userMapper.insert(user);

        return Result.ok(null);
    }
}




