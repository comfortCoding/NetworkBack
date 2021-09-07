package javapro.model.view;

import javapro.model.Person;
import javapro.model.PostLike;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vi_post_comment")
public class PostCommentView implements Serializable, Comparable<PostCommentView> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "time", nullable = false)
    private Date time;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false, foreignKey = @ForeignKey(name = "FK_post_id"))
    private PostView post;

    @ManyToOne
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "FK_parent_comment_id"))
    private PostCommentView parentComment;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(name = "FK_author_id"))
    private Person author;

    @Column(name = "comment_text", nullable = false)
    private String commentText;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "is_blocked", nullable = false)
    private boolean isBlocked;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<PostLike> commentLikeList = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(PostCommentView comment) {
        return comment.getTime().compareTo(this.getTime());
    }

}
