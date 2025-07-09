package com.recipe_rescue.service;

import com.recipe_rescue.domain.model.UserDto;
import com.recipe_rescue.persistence.entities.UserEntity;
import com.recipe_rescue.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean createUser(UserDto user) {
        UserEntity savedUser = userRepository.save(buildUserEntity(user));
        if (null != savedUser && savedUser.getId() > 0) {
            return true;
        }
        return false;
    }

    private UserDto buildUser(UserEntity userEntity) {
        UserDto user = new UserDto();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setDifficultyId(userEntity.getDifficultyId());
        user.setServingSizeId(userEntity.getServingSizeId());
        user.setPrepTimeId(userEntity.getPrepTimeId());
        user.setCuisineId(userEntity.getCuisineId());
        user.setCreatedAt(userEntity.getCreatedAt());
        user.setUpdatedAt(userEntity.getUpdatedAt());
        return user;
    }


    private UserEntity buildUserEntity(UserDto user) {
        UserEntity userEntity = new UserEntity();
        if (user.getId() != null) {
            userEntity.setId(user.getId());
        }
        userEntity.setUsername(user.getUsername());
        userEntity.setDifficultyId(user.getDifficultyId());
        userEntity.setServingSizeId(user.getServingSizeId());
        userEntity.setPrepTimeId(user.getPrepTimeId());
        userEntity.setCuisineId(user.getCuisineId());
        userEntity.setCreatedAt(user.getCreatedAt());
        return userEntity;
    }

    public UserDto findById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        return buildUser(userEntity);
    }

    public boolean updateUser(UserDto currentUser, UserDto user) {
        if (null != currentUser) {
            if (user.getUsername() != null) {
                currentUser.setUsername(user.getUsername());
            }
            if (user.getDifficultyId() != null) {
                currentUser.setDifficultyId(user.getDifficultyId());
            }
            if (user.getServingSizeId() != null) {
                currentUser.setServingSizeId(user.getServingSizeId());
            }
            if (user.getPrepTimeId() != null) {
                currentUser.setPrepTimeId(user.getPrepTimeId());
            }
            if (user.getCuisineId() != null) {
                currentUser.setCuisineId(user.getCuisineId());
            }
            userRepository.save(buildUserEntity((currentUser)));
            return true;
        }
        return false;
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntityList =  userRepository.findAll();
        List<UserDto> userList = userEntityList.stream().map(user -> {
            return buildUser(user);
        }).collect(Collectors.toList());
        return userList;
    }
}
