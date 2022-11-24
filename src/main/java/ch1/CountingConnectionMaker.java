package ch1;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMarker{

    int count = 0;
    private ConnectionMarker realConnectionMaker;

    public CountingConnectionMaker(ConnectionMarker realConnectionMaker){
        this.realConnectionMaker = realConnectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.count++;
        return realConnectionMaker.makeConnection();
    }

    public int getCount(){
        return this.count;
    }
}
