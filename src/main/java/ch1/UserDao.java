package ch1;

import java.sql.*;

public class UserDao{

    private ConnectionMarker connectionMarker;

    public UserDao(ConnectionMarker connectionMarker) {
        this.connectionMarker = connectionMarker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMarker.makeConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());
        ps.executeUpdate();
        ps.close();
        c.close();
    }
    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMarker.makeConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        rs.close();
        ps.close();
        c.close();
        return user;
    }
//    private  Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost/toby_spring","root","qwer12345"
//        );
//        return c;
//    }
}