package day01_code.JdbcTemplate;

import day01_code.data工具包.JDBCUtils;
import day01_code.data工具包.JDBCUtils03;
import day01_code.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.net.ssl.SSLContext;
import java.lang.annotation.Target;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/*
1.修改1号数据，salary为10000；
2.添加一条记录
3.删除刚才添加的记录
4.查询id为1的记录，将其封装为map集合
    queryForMap();
5.查询所有记录，封装为list
    注意：将每一条记录封装为map集合，再将map集合封装到list集合中
    queryForList();
6.查询所有记录，封装为emp对象的list集合
7.查询总记录数
 */
public class Demo02 {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils03.getDataSours());

    @Test
    public void test1() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils03.getDataSours());
        String sql = "update emp set salary =10000 where id= 1001";
        int update = template.update(sql);
        System.out.println(update);
    }

    @Test
    public void test2() {
        String sql = "insert into emp(id,ename) values (?,?) ";
        int update = template.update(sql, 2001, "守望先锋");
        System.out.println(update);
    }

    @Test
    public void test3() {
        String sql = "delete from emp where id=? or id = ?";
        template.update(sql, 2000, 2001);
    }

    /*
    4.查询id为1的记录，将其封装为map集合
    这个方法查询的结果集长度只能是1，列为key，内容为value
     */
    @Test
    public void test4() {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    @Test
    public void test5() {
        String sql = "select *from emp where id = ? or id = ? or id= ?";
        List<Map<String, Object>> maps = template.queryForList(sql, 1001, 1002, 1003);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void test6() {
        String sql = "select *from emp";
    /*    List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {

                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double bonus = rs.getDouble("bonus");
                double salary = rs.getDouble("salary");
                int dept_id = rs.getInt("dept_id");
                Emp emp = new Emp(id,ename,job_id,mgr,joindate,bonus,salary,dept_id);
                return emp;
            }
        });*/
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long aLong = template.queryForObject(sql, long.class);
        System.out.println(aLong);
    }
    @Test
    public void test8(){
        String sql = "select sum(salary) from emp";
        Long aLong = template.queryForObject(sql,long.class);
        System.out.println(aLong);
    }
}
