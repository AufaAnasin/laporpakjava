package aptika.example.laporpak.service;

import aptika.example.laporpak.model.UserModel;
import aptika.example.laporpak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // penanda kalau ini adalah class service

public class UserService {
    @Autowired // ambil kelas lain seperti dibawah, pakai ini
    private UserRepository userRepository;

    public List<UserModel> getAllUserData() {
        List<UserModel> data = userRepository.findAllUserData();
        return data;
    }
}
