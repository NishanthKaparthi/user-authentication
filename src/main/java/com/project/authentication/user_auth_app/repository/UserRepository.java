package com.project.authentication.user_auth_app.repository;

import com.project.authentication.user_auth_app.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    boolean existsByEmail(String email);

    User save(User user);


}
