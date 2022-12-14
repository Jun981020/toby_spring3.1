package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserDaoTest {
//    @InjectMocks
//    private UserDao dao;
//    @Mock
//    private ApplicationContext context;

    @Autowired
    private UserDao dao;
    @BeforeEach
    public void setUp(){
//        System.out.println(this.context);
//        System.out.println(this);
//        this.dao= context.getBean("userDao", UserDao.class);
    }


    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user1 = new User("qwer1","준형","1234");
        User user2 = new User("qwer2", "준형", "1234");
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        User userGet1 = userDao.get(user1.getId());
        assertThat(userGet1.getName()).isEqualTo(user1.getName());
        assertThat(userGet1.getPassword()).isEqualTo(user1.getPassword());
        User userGet2 = userDao.get(user2.getId());
        assertThat(userGet2.getName()).isEqualTo(userGet2.getName());
        assertThat(userGet2.getPassword()).isEqualTo(userGet2.getPassword());
    }
    @Test
    public void getCountTest() throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);
        User u1 = new User("1", "kk", "1234");
        userDao.add(u1);
        assertThat(userDao.getCount()).isEqualTo(1);
        User u2 = new User("2", "jj", "1234");
        userDao.add(u2);
        assertThat(userDao.getCount()).isEqualTo(2);
        User u3 = new User("3", "qq", "1234");
        userDao.add(u3);
        assertThat(userDao.getCount()).isEqualTo(3);
    }
    @Test
    public void getUserFailure() throws SQLException, ClassNotFoundException {
        UserDao dao = getBeanM();
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        Assertions.assertThrows(EmptyResultDataAccessException.class, () ->
            {
                    dao.get("unknow_id");
            }
        );
    }
    public static AnnotationConfigApplicationContext getAc(){
        return new AnnotationConfigApplicationContext(DaoFactory.class);
    }
    public static UserDao getBeanM(){
        AnnotationConfigApplicationContext ac = getAc();
        return ac.getBean("userDao",UserDao.class);
    }
    @Test
    public void addJdbc() throws SQLException, ClassNotFoundException {
        UserDao dao = getBeanM();
        User user = new User("ad", "spring", "book");
        dao.add(user);
        User user1 = dao.get(user.getId());
        assertThat(user1.getName()).isEqualTo(user.getName());
    }
    @Test
    public void getAll() throws SQLException {
        UserDao dao = getBeanM();
        dao.deleteAll();

        List<User> users0 = dao.getAll();
        assertThat(users0.size()).isEqualTo(0);

        User user1 = new User("userA", "asd", "1234");
        dao.add(user1);
        List<User> users1 = dao.getAll();
        assertThat(users1.size()).isEqualTo(1);
        checkSameUser(user1,users1.get(0));

        User user2 = new User("userB", "qwe", "1234");
        dao.add(user2);
        List<User> users2 = dao.getAll();
        assertThat(users2.size()).isEqualTo(2);
        checkSameUser(user1,users1.get(0));
        checkSameUser(user2,users2.get(1));

        User user3 = new User("userC", "zxc", "1234");
        dao.add(user3);
        List<User> users3 = dao.getAll();
        assertThat(users3.size()).isEqualTo(3);
        checkSameUser(user1,users1.get(0));
        checkSameUser(user2,users2.get(1));
        checkSameUser(user3,users3.get(2));




    }
    private void checkSameUser(User user1,User user2){
        assertThat(user1.getId()).isEqualTo(user2.getId());
        assertThat(user1.getName()).isEqualTo(user2.getName());
        assertThat(user1.getPassword()).isEqualTo(user2.getPassword());
    }
}