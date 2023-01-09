package ch1;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao{

    private JdbcContext jdbcContext;

    private JdbcTemplate jdbcTemplate;
//    public void setJdbcContext(JdbcContext jdbcContext){
//        this.jdbcContext = jdbcContext;
//    }

    public UserDao(){

    }
    private ConnectionMarker connectionMarker;

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public UserDao(ConnectionMarker connectionMarker) {
        this.connectionMarker = connectionMarker;
    }
//    public void setConnectionMaker(ConnectionMarker connectionMarker){
//        this.connectionMarker = connectionMarker;
//    }
    public int getCount() throws SQLException, ClassNotFoundException {
//        Connection c = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try{
//            c = dataSource.getConnection();
//            ps = c.prepareStatement("select count(*) from users");
//            rs = ps.executeQuery();
//            rs.next();
//            return rs.getInt(1);
//        }catch (Exception e){
//            throw e;
//        }finally {
//            if(rs != null){
//                try {
//                    rs.close();
//                }catch (SQLException e){
//
//                }
//            }
//            if(ps != null){
//                try {
//                    ps.close();
//                }catch (SQLException e){
//
//                }
//            }
//            if(c != null){
//                try {
//                    c.close();
//                }catch (SQLException e){
//
//                }
//            }
//        }
        Integer count = this.jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareStatement("select count(*) from users");
            }
        }, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                rs.next();
                return rs.getInt(1);
            }
        });

        return count;
    }
    
    public void deleteAll() throws SQLException{
//        jdbcContext.executeSql("delete from users");
        this.jdbcTemplate.update("delete from users");
    }
    private void executeSql(final String query) throws SQLException {
        jdbcContext.workWithStatementStrategy(c->{
            return c.prepareStatement(query);
        });
    }

//    abstract protected PreparedStatement makeStatement(Connection c) throws SQLException;

    public void add(final User user) throws SQLException {
        //inner class
//         class AddStatement implements StatementStrategy{
//            @Override
//            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
//                PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
//                ps.setString(1,user.getId());
//                ps.setString(2,user.getName());
//                ps.setString(3,user.getPassword());
//                return ps;
//            }
//        }
//        StatementStrategy stm = new AddStatement();
//        jdbcContextWithStatementStrategy(stm);
        //anonymous inner class
//        this.jdbcContext.workWithStatementStrategy(c -> {
//            PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
//            ps.setString(1,user.getId());
//            ps.setString(2,user.getName());
//            ps.setString(3,user.getPassword());
//            return ps;
//        });
        this.jdbcTemplate.update("insert into users(id,name,password) values(?,?,?)",user.getId(),user.getName(),user.getPassword());

    }
    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }
        rs.close();
        ps.close();
        c.close();
        if(user == null){
            throw new EmptyResultDataAccessException(1);
        }
        return user;
    }
    public int getConnection() throws  SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dataSource.getConnection();
            ps = c.prepareStatement("select count(*) from users");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            throw e;
        }finally {
            if(rs != null){
                try {
                    rs.close();
                }catch (SQLException e){

                }
            }
            if(ps != null){
                try{
                    ps.close();
                }catch (SQLException e){

                }
            }
            if(c != null){
                try {
                    c.close();
                }catch (SQLException e){

                }
            }
        }
    }
    public void jdbcContextWithStatementStrategy(StatementStrategy smt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = dataSource.getConnection();
            ps = smt.makePreparedStatement(c);
            ps.executeUpdate();
        }catch(SQLException e){
            throw e;
        }finally {
            if(ps != null){
                try {
                    ps.close();
                }catch (SQLException e){

                }
            }
            if(c != null){
                try {
                    c.close();
                }catch (SQLException e){

                }
            }
        }
    }
}
