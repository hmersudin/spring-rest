package com.lilium.springrest.api;

import com.lilium.springrest.dto.UserDTO;
import com.lilium.springrest.entity.User;

public interface UserApi extends AbstractCRUDLApi<User, UserDTO> {
}
