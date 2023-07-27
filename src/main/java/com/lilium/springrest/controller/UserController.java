package com.lilium.springrest.controller;

import com.lilium.springrest.api.UserApi;
import com.lilium.springrest.dto.UserDTO;
import com.lilium.springrest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/" + UserController.ENDPOINT)
public class UserController extends AbstractCRUDLController<User, UserDTO> {
    public static final String ENDPOINT = "users";
    private UserApi api;

    @Autowired
    public UserController(UserApi api) {
        super(api);
    }
}
