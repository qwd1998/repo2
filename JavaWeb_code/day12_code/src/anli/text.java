package anli;

import org.junit.Test;

public class text {
    @Test
    public void z(){
        User u = new User();
        u.setUsername("ls");
        u.setPassword("123");
        Userd d= new Userd();
        User loguser = d.loguser(u);
        System.out.println(loguser);

    }
}
