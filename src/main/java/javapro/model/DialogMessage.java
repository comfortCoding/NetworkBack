package javapro.model;

import javapro.model.enums.ReadStatus;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "dialog_message")
public class DialogMessage implements Comparable<DialogMessage> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "time", nullable = false)
    private Date time;

    @ManyToOne
    @JoinColumn(name = "dialog_id", nullable = false, foreignKey = @ForeignKey(name = "fk_dialog_message_id"))
    private Dialog dialog;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(name = "fk_dialog_author_id"))
    private Person authorId;

    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false, foreignKey = @ForeignKey(name = "fk_dialog_recipient_id"))
    private Person recipientId;

    @Column(name = "message_text", nullable = false)
    private String messageText;

    @Enumerated(EnumType.STRING)
    @Column(name = "read_status", nullable = false)
    private ReadStatus readStatus;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(@NotNull DialogMessage o) {
        return time.compareTo(o.getTime());
    }
}
