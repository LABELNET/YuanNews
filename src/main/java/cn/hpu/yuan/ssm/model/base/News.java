package cn.hpu.yuan.ssm.model.base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by yuan on 16-3-30.
 * 新闻基础对象
 */
@Entity
public class News {

    private Integer id;
    private String title;
    private String content;
    private String dt;
    private String img;
    private Integer rnum;
    private Integer cid;
    private Integer sid;

    public void setId(int id) {
        this.id = id;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "source")
    public Integer getSource() {
        return sid;
    }

    public void setSource(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "dt")
    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Basic
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "rnum")
    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != null ? !id.equals(news.id) : news.id != null) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (sid != null ? !sid.equals(news.sid) : news.sid != null) return false;
        if (content != null ? !content.equals(news.content) : news.content != null) return false;
        if (dt != null ? !dt.equals(news.dt) : news.dt != null) return false;
        if (img != null ? !img.equals(news.img) : news.img != null) return false;
        if (rnum != null ? !rnum.equals(news.rnum) : news.rnum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (dt != null ? dt.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (rnum != null ? rnum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", source='" + sid + '\'' +
                ", content='" + content + '\'' +
                ", dt='" + dt + '\'' +
                ", img='" + img + '\'' +
                ", rnum=" + rnum +
                ", cid=" + cid +
                '}';
    }
}
