package ms.entity;

import java.util.Date;

/**
 * Created by Raymond on 2018/11/25.
 */
public class Staff {
    private Integer id;
    private String account;
    private String password;
    private String status;
    private String IDCard;
    private Integer departmentId;
    private String name;
    private String sex;
    private Date workTime;
    private Date leaveTime;
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", IDCard='" + IDCard + '\'' +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", workTime=" + workTime +
                ", leaveTime=" + leaveTime +
                ", department=" + department +
                ", info='" + info + '\'' +
                '}';
    }
}
