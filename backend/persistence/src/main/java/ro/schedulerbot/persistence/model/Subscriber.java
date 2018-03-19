package ro.schedulerbot.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subscriber")
public class Subscriber {
	
	@Getter
	@Setter
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "name", nullable = false)
	private String name;

}
