package javapro.model;

import javapro.model.view.PostCommentView;
import javapro.model.view.PostView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "post_like")
public class PostLike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "time", nullable = false)
    private Date time;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "FK_person_id"))
    private Person person;

    @ManyToOne
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "FK_post_id"))
    private PostView post;

    @ManyToOne
    @JoinColumn(name = "comment_id", foreignKey = @ForeignKey(name = "FK_comment_id"))
    private PostCommentView comment;
}