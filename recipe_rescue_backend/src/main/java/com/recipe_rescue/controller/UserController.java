package com.recipe_rescue.controller;

import com.recipe_rescue.domain.model.ResponseDto;
import com.recipe_rescue.domain.model.UserDto;
import com.recipe_rescue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        try {
            List<UserDto> userList = userService.getAllUsers();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userList);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of());
        }
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto user) {
        ResponseDto response = new ResponseDto();
        try {
            if (null != user && null != user.getUsername()) {
                boolean success = userService.createUser(user);
                if (success) {
                    response.setStatusCode("200");
                    response.setStatusMsg("Successfully created a new user");
                    return ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body(response);
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            response.setStatusCode("500");
            response.setStatusMsg("Something went wrong");
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }

    }

    @PatchMapping("/user")
    public ResponseEntity<ResponseDto> updateUser(
            @RequestParam(required = true) Long userId,
            @RequestBody (required = true) UserDto user) {
        ResponseDto response = new ResponseDto();
        UserDto current_user = userService.findById(userId);
        try {
            if (current_user != null) {
                userService.updateUser(current_user, user);
                response.setStatusCode("200");
                response.setStatusMsg("Successfully updated user");
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(response);
            } else {
                response.setStatusCode("400");
                response.setStatusMsg("User not found");
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(response);
            }
        } catch (Exception e) {
            response.setStatusCode("500");
            response.setStatusMsg("Something went wrong");
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }
}
