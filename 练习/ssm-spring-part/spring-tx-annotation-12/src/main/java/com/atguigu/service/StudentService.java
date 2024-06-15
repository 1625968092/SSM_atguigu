package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

   @Autowired
   private StudentDao studentDao;


    /**
     * 添加事务：
     *   @Transactional
     *   位置： 方法 或 类 上
     *   方法：当前方法有事务
     *   类上：类下的所有方法都有事务
     *
     * 1. 只读模式
     *      只读模式可以提升查询事务的效率！如果只有查询事务推荐使用只读模式
     *      @Transactional(readOnly = true)
     *      一般在类上添加事务默认不是只读，给查询的方法单独设置只读。
     * 2. 超时时间
     *      默认永远不超时 值为-1
     *      设置 timeout= 时间 秒数 超过时间就会回滚事务和释放 TransactionTimedOutException 异常
     *
     * 3. 指定异常回滚和指定异常不回滚
     *      默认情况下，指定发生运行时异常事务才会回滚
     *      我们指定Exception异常来控制所有异常都回滚
     *      rollbackFor = Exception.class
     *      指定异常不回滚
     *      noRollbackFor = Exception.class
     *
     *  4. 隔离级别设置
     *      推荐设置第二个隔离级别
     *      isolation = Isolation.READ_COMMITTED
     *
     *  5. 事务的传播行为（调用子事务是否独立成为事务）
     *      propagation = Propagation.REQUIRED
     *      默认为Propagation.REQUIRED，
     *      父事务调用子事务，默认会让子事务加入，没有父事务子事务独立成为事务，推荐使用
     */


   @Transactional(readOnly = false,timeout = 3,rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
   public void changeInfo(){
       studentDao.updateAgeById(66,1);
//       int i=1/0;
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       System.out.println("-----------");
       studentDao.updateNameById("test2",1);
   }
}