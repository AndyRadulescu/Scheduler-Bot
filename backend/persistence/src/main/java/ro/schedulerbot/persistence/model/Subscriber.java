package ro.schedulerbot.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.simple.JSONObject;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Getter;
import lombok.Setter;

@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
@Table(name = "subscriber")
public class Subscriber {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	  /** The SecurityUser's username. */
	@Column(name = "username", nullable = false)
    private String username;
	
    /** The SecurityUser's password. */
    @Column(name = "password")
    private String password;

    /** The SecurityUser's enabled status. */
    @Column(name = "enabled")
	private Boolean enabled;
	
	@Getter
	@Setter
	@Column(name = "name", nullable = false)
	private String name;
	
	@Getter
	@Setter
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Getter
	@Setter
	@Type(type = "jsonb")
	@Column(name = "facebook_conn", nullable = false, columnDefinition = "jsonb")
	private JSONObject facebookConn;
	
	@Getter
	@Setter
	@Type(type = "jsonb")
	@Column(name = "google_calendar_conn", nullable = false, columnDefinition = "jsonb")
	private JSONObject googleCalendarConn;
	
	@Getter
	@Setter
	@OneToMany(mappedBy ="subscriber")
	private List<Subscription> subscriptions;
	
}
