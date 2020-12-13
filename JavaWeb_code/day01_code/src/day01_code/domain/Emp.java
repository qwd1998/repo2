package day01_code.domain;

import java.util.Date;

/*
封装emp表数据的javabean
 */
public class Emp {
    private Integer id;
    private String ename;
    private Integer job_id;
    private Integer mgr;
    private Date joindate;
    private Double bonus;
    private Double salary;
    private Integer dept_id;

    public Emp() {

    }

    public Emp(Integer id, String ename, Integer job_id, Integer mgr, Date joindate, Double bonus, Double salary, Integer dept_id) {
        this.id = id;
        this.ename = ename;
        this.job_id = job_id;
        this.mgr = mgr;
        this.joindate = joindate;
        this.bonus = bonus;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", joindate=" + joindate +
                ", bonus=" + bonus +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                '}';
    }
}
