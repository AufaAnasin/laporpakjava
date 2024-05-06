package aptika.example.laporpak.repository;

import aptika.example.laporpak.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    // query semua item di dalam table User
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserModel> findAllUserData();

    //     query user berdasarkan id
    @Query(value = "SELECT u FROM UserModel u WHERE u.userId = :userId")
    Optional<UserModel> findByUserId(String userId);

    boolean existsByEmail(String email);

}
