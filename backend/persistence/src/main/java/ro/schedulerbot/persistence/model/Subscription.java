package ro.schedulerbot.persistence.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.simple.JSONObject;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Getter;
import lombok.Setter;

@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
@Table(name = "subscription")
public class Subscription {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Getter
	@Setter
	@JoinColumn(name="client_id")
    @ManyToOne
	private Client client;
	
	@Getter
	@Setter
	@JoinColumn(name="subscription_id")
    @ManyToOne
	private Subscriber subscriber;
	
	@Setter
	@Getter
    @Column(name = "date_of_subscription", nullable = false)
	private LocalDate dateOfSubscription;
	
	@Setter
	@Getter
    @Column(name = "start_service", nullable = false)
	private LocalTime startService;
	
	@Setter
	@Getter
    @Column(name = "end_service", nullable = false)
	private LocalTime endService;
	
	@Setter
	@Getter
	@Type(type = "jsonb")
	@Column(name = "appointment_description", nullable = false, columnDefinition = "jsonb")
	private JSONObject appointmentDescription;
	
	@Setter
	@Getter
	@Column(name = "status")
	private String status;
}
