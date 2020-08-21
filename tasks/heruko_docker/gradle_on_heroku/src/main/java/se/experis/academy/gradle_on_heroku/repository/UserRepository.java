package se.experis.academy.gradle_on_heroku.repository;

import org.springframework.data.repository.CrudRepository;
import se.experis.academy.gradle_on_heroku.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
