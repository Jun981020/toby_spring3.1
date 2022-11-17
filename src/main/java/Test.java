import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();
        User user = new User("1","jun","1234");
        dao.add(user);
        User user1 = dao.get(user.id);
        System.out.println("user1 = " + user1);

    }
}
