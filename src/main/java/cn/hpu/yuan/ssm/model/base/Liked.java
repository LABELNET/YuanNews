package cn.hpu.yuan.ssm.model.base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by yuan on 16-4-3.
 */
@Entity
public class Liked {
    private int id;
    private int status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Liked liked = (Liked) o;

        if (id != liked.id) return false;
        if (status != liked.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "Liked{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
