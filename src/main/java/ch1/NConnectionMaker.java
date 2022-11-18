package ch1;

import java.sql.Connection;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMarker{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        //N 사의 독자적인 DB Connection 코드;
        return null;
    }
}
