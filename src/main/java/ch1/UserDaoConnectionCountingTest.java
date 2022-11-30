package ch1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("qwee");
        user.setName("jun");
        user.setPassword("1234");
        userDao.add(user);
        User user1 = userDao.get("qwee");
        User user2 = userDao.get("qwee");
        User user3 = userDao.get("qwee");
        User user4 = userDao.get("qwee");
        CountingConnectionMaker ccm = ac.getBean(CountingConnectionMaker.class);
        System.out.println(ccm.getCount());
    }
}
