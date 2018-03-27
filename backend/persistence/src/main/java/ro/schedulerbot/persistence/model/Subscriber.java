package ro.schedulerbot.persistence.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.util.List;

@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
@Table(name = "subscriber")
public class Subscriber {

    //id
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    /**
     * The SecurityUser's password.
     */
    //password
    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    //enabled
    /**
     * The SecurityUser's enabled status.
     */
    @Getter
    @Setter
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    //name
    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    //email
    @Getter
    @Setter
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    //facebook shit
    @Getter
    @Setter
    @Type(type = "jsonb")
    @Column(name = "facebook_conn", columnDefinition = "jsonb")
    private JSONObject facebookConn;

    //google shit
    @Getter
    @Setter
    @Type(type = "jsonb")
    @Column(name = "google_calendar_conn", columnDefinition = "jsonb")
    private JSONObject googleCalendarConn;

    //subscriptions
    @Getter
    @Setter
    @OneToMany(mappedBy = "subscriber")
    private List<Subscription> subscriptions;
}
