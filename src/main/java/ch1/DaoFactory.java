package ch1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao(){
        return new UserDao(getConnection());
    }

    @Bean
    public DConnectionMaker getConnection(){
        return new DConnectionMaker();
    }
}
