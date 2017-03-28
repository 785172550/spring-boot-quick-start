package Kenneth.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/26.
 *
 *  entity类
 */


@Entity
@Table(name = "post")
public class Post {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // 自增
    private long id;
    private String title;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date create;

    public Post(){

    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.create = new Date();//创建时
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create=" + create +
                '}';
    }
}
