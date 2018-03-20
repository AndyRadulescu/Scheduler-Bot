package ro.schedulerbot.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
public class Client {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "name", nullable = false)
	private String name;
	
	@Getter
	@Setter
	@Column(name = "email")
	private String email;
	
	@Getter
	@Setter
	@Column(name = "facebook_id")
	private String facebookId;
	
	@Getter
	@Setter
	@Column(name = "phone_nr")
	private String phoneNr;
	
	@Getter
	@Setter
	@OneToMany(mappedBy ="client")
	private List<Subscription> subscriptions;
}
