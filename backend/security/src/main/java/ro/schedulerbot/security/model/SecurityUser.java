package ro.schedulerbot.security.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class SecurityUser {
  
  /** The SecurityUser's id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** The SecurityUser's username. */
  @Column(name = "username")
  private String username;

  /** The SecurityUser's password. */
  @Column(name = "password")
  private String password;

  /** The SecurityUser's enabled status. */
  @Column(name = "enabled")
  private Boolean enabled;
}
