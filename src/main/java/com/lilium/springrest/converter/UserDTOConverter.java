package com.lilium.springrest.converter;

import com.lilium.springrest.dto.UserDTO;
import com.lilium.springrest.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter extends AbstractDTOConverter<User, UserDTO> {
    @Override
    public UserDTO convert(User entity) {
        final UserDTO dto = new UserDTO();
        super.convert(entity, dto);

        // User specific properties
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());

        return dto;
    }
}
