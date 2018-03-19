package ro.schedulerbot.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.schedulerbot.persistence.model.Subscriber;

public interface SubscriberRepo extends JpaRepository<Subscriber, Long>{

}
