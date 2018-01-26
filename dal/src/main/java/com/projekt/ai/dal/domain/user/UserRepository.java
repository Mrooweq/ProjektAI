package com.projekt.ai.dal.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsernameAndPassword(String username, String password);
    User getUserByEmail(String email);
    User getUserByUsername(String ssername);
}
