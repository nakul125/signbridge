package com.signbridge.backend.repository;

import com.signbridge.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findByRole(User.Role role);

    List<User> findByIsActiveTrue();

    List<User> findByNameContainingIgnoreCase(String name);

    @Query(
            "SELECT u FROM User u WHERE u.email = :email" +
                    " AND u.isActive = true"
    )
    Optional<User> findActiveUserByEmail(@Param("email") String email,@Param("isActive") boolean isActive);

    @Query("SELECT COUNT(u) FROM User u WHERE u.role = 'ADMIN'")
    long countAdmins();
}
