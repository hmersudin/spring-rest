package com.lilium.springrest;

import com.lilium.springrest.dto.UserDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class UserRestTest {
    private final static RestTemplate REST_TEMPLATE = new RestTemplate();
    private final static String URL = "http://localhost:7071/api/users";
    @Test
    void testUserCRUDL() {
        final UserDTO dto = new UserDTO();
        dto.setUsername("Username"+ UUID.randomUUID());
        dto.setName("Name"+ UUID.randomUUID());

        UserDTO savedDTO = REST_TEMPLATE.postForObject(URL, dto, UserDTO.class);
        verifyUserDTO(dto, savedDTO);

        final UserDTO byId = REST_TEMPLATE.getForObject(URL + "/" + savedDTO.getId(), UserDTO.class);
        verifyUserDTO(dto, byId);
    }

    private static void verifyUserDTO(UserDTO expected, UserDTO actual) {
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getCreatedTimestamp()).isNotNull();
        assertThat(actual.getModifiedTimestamp()).isNotNull();
        assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }
}
