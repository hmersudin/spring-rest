package com.lilium.springrest.converter;

import com.lilium.springrest.dto.BaseDTO;
import com.lilium.springrest.entity.DistributedEntity;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract converter used to convert from ENTITY to DTO.
 *
 * @param <ENTITY> Entity to convert.
 * @param <DTO> DTO in which we are converting.
 */
public abstract class AbstractDTOConverter<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    /**
     * Force us to always convert class specific properties.
     * Converts forwarded entity to forwarded DTO.
     *
     * @param entity Entity to convert.
     * @return Converted entity as a DTO.
     */
    public abstract DTO convert(final ENTITY entity);

    /**
     * Converts forwarded entity to forwarded DTO.
     *
     * @param entity Entity to convert.
     * @param dto DTO in which we are converting.
     */
    public void convert(final ENTITY entity, final DTO dto) {
        // All properties that we have in entity set to dto
        // Fetch entity from db and convert it to dto (forwarded to the FE)
        dto.setId(entity.getId());
        dto.setCreatedTimestamp(entity.getCreatedTimestamp());
        dto.setModifiedTimestamp(entity.getModifiedTimestamp());
    }

    /**
     * Converts forwarded entities to list of DTOs.
     *
     * @param entities Entities to convert.
     * @return List of converted DTOs.
     */
    public List<DTO> convertList(ArrayList<ENTITY> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }

        return entities.stream()
                .map(this::convert)
                .toList();
    }
}
