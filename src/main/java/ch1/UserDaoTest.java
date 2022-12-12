package ch1;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

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

//        ApplicationContext ac =
//                new AnnotationConfigApplicationContext(DaoFactory.class);
//        UserDao userDao1 = ac.getBean("userDao", UserDao.class);
//        UserDao userDao2 = ac.getBean("userDao", UserDao.class);
//        System.out.println("userDao1 = " + userDao1);
//        System.out.println("userDao1 = " + userDao1);//서로같은 객체 싱글톤 보장

        //CountingConnectionMaker 사용
//        AnnotationConfigApplicationContext ac =
//                new AnnotationConfigApplicationContext(CountingDaoFactory.class);
//        UserDao userDao = ac.getBean("userDao", UserDao.class);
//        User user1 = new User("1","jun","1234");
//        User user2 = new User("2","jun","1234");
//        User user3 = new User("3","jun","1234");
//        userDao.add(user1);
//        userDao.add(user2);
//        userDao.add(user3);
//        User user = userDao.get("1");
//        User user4 = userDao.get("2");
//        User user5 = userDao.get("3");
//        System.out.println("user = " + user);
//        System.out.println("user4 = " + user4);
//        System.out.println("user5 = " + user5);
//        CountingConnectionMaker ccm = ac.getBean("connectionMarker", CountingConnectionMaker.class);
//        System.out.println(ccm.getCount());


        //jdbc 템플릿


    }
}
