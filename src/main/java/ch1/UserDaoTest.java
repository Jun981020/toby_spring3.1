package ch1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


//        ConnectionMarker connectionMarker = new DConnectionMaker();
//        UserDao dao = new UserDao(connectionMarker);
//        User user = new User("1","jun","1234");
//        dao.add(user);
//        User user1 = dao.get(user.id);
//        System.out.println("user1 = " + user1);


//        UserDao dao = new DaoFactory().userDao();
//        User user = new User("1","jun","1234");
//        dao.add(user);
//        User user1 = dao.get(user.id);
//        System.out.println("user1 = " + user1);

        //ApplicationContext 사용 동일한 결과 리턴
//        ApplicationContext ac =
//                new AnnotationConfigApplicationContext(DaoFactory.class);
//
//        UserDao userDao = ac.getBean(UserDao.class);
//        User user = new User("1","jun","1234");
//        userDao.add(user);
//        User user1 = userDao.get("1");
//        System.out.println("user1 = " + user1);

        //싱글톤 테스트
//        ApplicationContext ac =
//                new AnnotationConfigApplicationContext(DaoFactory.class);
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao2 = daoFactory.userDao();
//        UserDao userDao1 = daoFactory.userDao();
//        System.out.println("userDao1 = " + userDao1);
//        System.out.println("userDao1 = " + userDao2); 서로다른객체

        ApplicationContext ac =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao1 = ac.getBean("userDao", UserDao.class);
        UserDao userDao2 = ac.getBean("userDao", UserDao.class);
        System.out.println("userDao1 = " + userDao1);
        System.out.println("userDao1 = " + userDao1);//서로같은 객체 싱글톤 보장


    }
}
