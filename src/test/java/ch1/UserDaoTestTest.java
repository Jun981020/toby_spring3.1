package ch1;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTestTest {

    @Test
    public void addAndGet(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
    }
}