package com.gunerakin.bcows.repository;

import com.gunerakin.bcows.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u.userId from  User u where u.userName=?1")
    Long findExistUserId(String userName);
}
