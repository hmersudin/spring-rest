package com.lilium.springrest.service;

import com.lilium.springrest.api.UserApi;
import com.lilium.springrest.converter.UserDTOConverter;
import com.lilium.springrest.dto.UserDTO;
import com.lilium.springrest.entity.User;
import com.lilium.springrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCRUDLService<User, UserDTO> implements UserApi {
    private UserRepository userRepository;
    private UserDTOConverter userDTOConverter;

    @Autowired
    public UserService(final UserRepository userRepository, final UserDTOConverter userDTOConverter) {
        super(userRepository, userDTOConverter);
        this.userRepository = userRepository;
        this.userDTOConverter = userDTOConverter;
    }

    @Override
    protected void updateEntity(User entity, UserDTO dto) {
        entity.setUsername(dto.getUsername());
        entity.setName(dto.getName());
    }
}
