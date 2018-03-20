package ro.schedulerbot.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.simple.JSONObject;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Getter;
import lombok.Setter;

@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
@Table(name = "scheduler_config")
public class SchedulerConfig {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "business_type", nullable = false)
	private String businessType;
	
	@Getter
	@Setter
	@Type(type = "jsonb")
	@Column(name = "availability", nullable = false, columnDefinition = "jsonb")
	private JSONObject availability;
	
	@Getter
	@Setter
	@Type(type = "jsonb")
	@Column(name = "appointment_types", nullable = false, columnDefinition = "jsonb")
	private JSONObject appointmentTypes;
}
