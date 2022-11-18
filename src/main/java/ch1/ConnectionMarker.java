package ch1;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMarker {

    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
