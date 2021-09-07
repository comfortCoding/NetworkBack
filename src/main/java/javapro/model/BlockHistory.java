package javapro.model;

import javapro.model.view.PostCommentView;
import javapro.model.view.PostView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "block_history")
public class BlockHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "time", nullable = false)
    private Date time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "FK_person_id"))
    private Person personId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "FK_post_id"))
    private PostView postViewId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id", foreignKey = @ForeignKey(name = "FK_comment_id"))
    private PostCommentView commentId;

    @Column(name = "is_blocked", nullable = false)
    private boolean isBlocked;


}
