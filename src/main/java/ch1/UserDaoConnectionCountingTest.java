package ch1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        AnnotationConfigApplicationContext ac
//                = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
//        UserDao userDao = ac.getBean("userDao", UserDao.class);
//        User user = new User();
//        user.setId("qwee");
//        user.setName("jun");
//        user.setPassword("1234");
//        userDao.add(user);
//        User user1 = userDao.get("qwee");
//        User user2 = userDao.get("qwee");
//        User user3 = userDao.get("qwee");
//        User user4 = userDao.get("qwee");
//        CountingConnectionMaker ccm = ac.getBean(CountingConnectionMaker.class);
//        System.out.println(ccm.getCount());
//        AnnotationConfigApplicationContext ac
//                = new AnnotationConfigApplicationContext(DaoFactory.class);
//        UserDao userDao = ac.getBean("userDao", UserDao.class);
//        User user = new User();
//        user.setId("qwer");
//        user.setName("jun");
//        user.setPassword("1234");
//        userDao.add(user);
//        User user2 = userDao.get("qwer");
//        if(!user.getName().equals(user2.getName())){
//            System.out.println("테스트 실패 (name)");
//        }else if(!user.getPassword().equals(user2.getPassword())){
//            System.out.println("테스트 실패 (password)");
//        }else{
//            System.out.println("테스트 조회 성공");
//        }
    }
}
