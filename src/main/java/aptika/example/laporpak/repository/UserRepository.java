package aptika.example.laporpak.repository;

import aptika.example.laporpak.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    // query semua item di dalam table User
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserModel> findAllUserData();
}
