package cn.hpu.yuan.ssm.model.base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by yuan on 16-3-30.
 * 用户基础对象
 */
@Entity
public class User {
    private Integer id;
    private String unum;
    private String head;
    private String nick;
    private String pass;
    private Integer sex;
    private Integer status;

    public void setId(int id) {
        this.id = id;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "unum")
    public String getUnum() {
        return unum;
    }

    public void setUnum(String unum) {
        this.unum = unum;
    }

    @Basic
    @Column(name = "head")
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Basic
    @Column(name = "nick")
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Basic
    @Column(name = "pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (unum != null ? !unum.equals(user.unum) : user.unum != null) return false;
        if (head != null ? !head.equals(user.head) : user.head != null) return false;
        if (nick != null ? !nick.equals(user.nick) : user.nick != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (unum != null ? unum.hashCode() : 0);
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", unum='" + unum + '\'' +
                ", head='" + head + '\'' +
                ", nick='" + nick + '\'' +
                ", pass='" + pass + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                '}';
    }
}
