package domain;
import dao.UserDao;
import org.junit.Test;

public class texttt {
    @Test
    public void s(){
        User user = new User();
        user.setUsername("ls");
        user.setPassword("123");
        UserDao dao = new UserDao();
        User login = dao.login(user);
        System.out.println(login);
    }
}
