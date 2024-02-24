package com.vladproduction.springbootcinemabookingservice.service.impl;


import com.vladproduction.springbootcinemabookingservice.exception.UserAlreadyExistException;
import com.vladproduction.springbootcinemabookingservice.exception.UserNotFoundException;
import com.vladproduction.springbootcinemabookingservice.model.impl.User;
import com.vladproduction.springbootcinemabookingservice.repository.UserRepository;
import com.vladproduction.springbootcinemabookingservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(long id) {
        log.info("find user by id {} ", id);
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user was not found, id " + id));
        log.info("user with id {} was found", id);
        return user;
    }

    @Override
    @Transactional
    public User create(User user) {
        log.info("creating User");
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistException("User with {} id: is already exist" + user.getId());
        }
        User persistedUser = userRepository.save(user);
        log.info("User was created");
        return persistedUser;
    }

    @Override
    @Transactional
    public User updateById(long id, User userDto) {
        log.info("updating User");
        User persistedUser = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("user with id {} does not exist" + id));
        User updatedUser = mapPresentUserFieldsUserDtoFields(persistedUser, userDto);
        log.info("user was updated");
        return updatedUser;
    }

    private User mapPresentUserFieldsUserDtoFields(User persistedUser, User userDto) {
        log.info("Started updating user ");
        String email = userDto.getEmail();
        if (Objects.nonNull(email)) {
            persistedUser.setEmail(email);
        }
        String name = userDto.getName();
        if (Objects.nonNull(name)) {
            persistedUser.setName(name);
        }
        log.info("User fields updated");
        return persistedUser;
    }

    @Override
    @Transactional
    public boolean deleteById(long id) {
        log.info("deleteUser with id {}", id);
        User persistedUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not exist it could not be deleted"));
        userRepository.delete(persistedUser);
        if (!userRepository.existsById(id)) {
            log.info("user with id {} was deleted successfully", id);
            return true;
        } else {
            log.info("user with id {} was not deleted ", id);
            return false;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        log.info("Finding user by email");
        User persistedUser = userRepository
                .getUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("user with email {} was not found" + email));
        log.info("User with  email {} was found: " + email);
        return persistedUser;
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
       log.info("get users by name");
        Pageable pageable = (Pageable) PageRequest.of(pageSize,pageNum);
        List<User> usersByName = userRepository.getUsersByName(name);
        log.info("users by name {} were found", name);
        return usersByName;
    }
}
