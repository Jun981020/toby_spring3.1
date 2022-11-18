package ch1;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ConnectionMarker connectionMarker = new DConnectionMaker();
//        UserDao dao = new UserDao(connectionMarker);
//        User user = new User("1","jun","1234");
//        dao.add(user);
//        User user1 = dao.get(user.id);
//        System.out.println("user1 = " + user1);
        UserDao dao = new DaoFactory().userDao();
        User user = new User("1","jun","1234");
        dao.add(user);
        User user1 = dao.get(user.id);
        System.out.println("user1 = " + user1);

    }
}
