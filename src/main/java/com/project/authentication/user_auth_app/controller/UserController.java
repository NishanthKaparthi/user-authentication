package com.project.authentication.user_auth_app.controller;

import com.project.authentication.user_auth_app.model.dto.UserRequestDto;
import com.project.authentication.user_auth_app.service.UserService;
import com.project.authentication.user_auth_app.util.MessageConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody UserRequestDto userRequestDto) {
        boolean isUserCreated = this.userService.createUser(userRequestDto);

        if(isUserCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.SIGNUP_SUCCESS);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.USER_ALREADY_EXIST);
    }

}
