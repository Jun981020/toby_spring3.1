package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.web.servlet.MockMvcExtensionsKt;
import org.testng.annotations.Test;
import org.testng.junit.JUnit3TestClass;
import org.testng.junit.JUnitTestRunner;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTestTest {

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("qwer");
        user.setName("jun");
        user.setPassword("1234");
        userDao.add(user);
        User user2 = userDao.get("qwer");
        assertThat(user.getName()).isEqualTo(user2.getName());
        assertThat(user.getPassword()).isEqualTo(user2.getPassword());

    }
}