package com.codeforges.common.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByGoogleUserId(String googleUserId);

    User findByName(String name);
}
