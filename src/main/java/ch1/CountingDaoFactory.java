package ch1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {

    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMarker());
    }
    @Bean
    public ConnectionMarker connectionMarker(){
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMarker realConnectionMaker(){
        return new DConnectionMaker();
    }

}
