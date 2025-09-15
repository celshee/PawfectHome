package com.savePet.PawfectHome.user;
import com.savePet.PawfectHome.exception.UserAlreadyExistsException;
import com.savePet.PawfectHome.exception.UserNotFoundException;
import com.savePet.PawfectHome.petPosting.PetPosting;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {


    private UserRepository repo;

    private UserMapper mapper;

    public UserService(UserRepository repo,UserMapper mapper){
        this.repo = repo;
        this.mapper=mapper;
    }

    public UserResponseDTO registerUser(UserRequestDTO data) {
        if (repo.existsByEmail(data.getEmail())) {
            throw new UserAlreadyExistsException(data.getEmail());
        }

        User user = mapper.toEntity(data);
        user.setRole(Role.USER);
        System.out.println(user.toString());
        return mapper.toDto(repo.save(user));
    }
    public String login(String email, String password) {
        // TODO: implement BCrypt + JWT
        return "dummy-token";
    }
    public List<UserResponseDTO> getAllUsers() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    public Optional<User> getUserById(int id){
        return repo.findById(id);
    }

    public UserResponseDTO updateUser(int id,@Valid UserRequestDTO dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(dto.getPasswordHash());
        user.setPhoneNo(dto.getPhoneNo());
        return mapper.toDto(repo.save(user));
    }


    public void deleteUser(int id) {
        if (!repo.existsById(id)) throw new UserNotFoundException(id);
        repo.deleteById(id);
    }

    public UserResponseDTO getUser(int id) {
        User user = repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return mapper.toDto(user);
    }

//    public Set<PetPosting> getPostings(int id) {
//        Set<PetPosting> set = new HashSet<>();
//        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//         set = user.getPetPostings();
//         return set;
//    }
}






//void changePassword(Long id, String oldPassword, String newPassword);