package aptika.example.laporpak.service;

import aptika.example.laporpak.exception.NotFoundException;
import aptika.example.laporpak.model.UserModel;
import aptika.example.laporpak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service // penanda kalau ini adalah class service

public class UserService {
    @Autowired // ambil kelas lain seperti dibawah, pakai ini
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // for saving the updatedTime later
    LocalDateTime currentTime = LocalDateTime.now();

    public List<UserModel> getAllUserData() {
        List<UserModel> data = userRepository.findAllUserData();
        return data;
    }

    public Optional<UserModel> getUserById(String userId) {
        Optional<UserModel> data = userRepository.findByUserId(userId);
        return data;
    }

    // for creating the user, validate user first
    private void validateUser(UserModel user) {
        if (!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new RuntimeException("Invalid Email Format");
        }
        if (!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            throw new RuntimeException("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
        }
    }

    public UserModel createUser(UserModel user) {
        //validate user input
        validateUser(user);

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email Already Exist");
        }

        // make the time when save the user are the current time when hit the enter
        user.setCreatedAt(currentTime);
        user.setUpdatedAt(currentTime);

        // encode the password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // save password to the database before saving
        return userRepository.save(user);
    }

    // for update the user

    public UserModel updateUser(String userId, UserModel updatedUser) {
        Optional<UserModel> optionalUser = userRepository.findByUserId(userId);
        if (optionalUser.isPresent()) {
            UserModel existingUser = optionalUser.get();
            if (updatedUser.getFullName() != null) {
                existingUser.setFullName(updatedUser.getFullName());
            }
            if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }
            if (updatedUser.getJobRole() != null) {
                existingUser.setJobRole(updatedUser.getJobRole());
            }
            existingUser.setUpdatedAt(currentTime);
            return userRepository.save(existingUser);
        } else {
            throw new NotFoundException("User not found with id: " + userId);
        }
    }

    // delete user by Id
    public void deleteUserById(String userId) {
        Optional<UserModel> optionalUser = userRepository.findByUserId(userId);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
        } else {
            throw new NotFoundException("User Not Found with Id" + userId);
        }
    }
}
