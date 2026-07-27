package io.github.joseGuilhermeG.libraryapi.services;

import io.github.joseGuilhermeG.libraryapi.dto.users.CreateUserDTO;
import io.github.joseGuilhermeG.libraryapi.exceptions.AlreadyExistsException;
import io.github.joseGuilhermeG.libraryapi.mappers.UserMapper;
import io.github.joseGuilhermeG.libraryapi.models.User;
import io.github.joseGuilhermeG.libraryapi.repositories.RoleRepository;
import io.github.joseGuilhermeG.libraryapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public User createUser(User user){
        existsUserWithThisName(user.getUsername());
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public void existsUserWithThisName(String username){
        if(repository.existsByUsername(username)) throw new AlreadyExistsException("An user with this username already exists");
    }
}
