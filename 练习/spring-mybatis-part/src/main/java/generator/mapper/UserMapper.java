package generator.mapper;

import generator.com.atguigu.pojo.User;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-05-26 17:31:54
* @Entity generator.com.atguigu.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
