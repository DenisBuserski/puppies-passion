package com.puppiespassion.service;

import com.puppiespassion.model.User;
import com.puppiespassion.model.dto.UserRegistrationDTO;
import com.puppiespassion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void register(UserRegistrationDTO userRegistrationDTO) {

        User user = User.builder()
                .username(userRegistrationDTO.getUsername())
                .password(userRegistrationDTO.getPassword())
                .email(userRegistrationDTO.getEmail())
                .firstName(userRegistrationDTO.getFirstName())
                .lastName(userRegistrationDTO.getLastName())
                .gender(userRegistrationDTO.getGender())
                .createDate(LocalDateTime.now())
                .modificationDate(null)
                .build();
        this.userRepository.save(user);


    }
}
