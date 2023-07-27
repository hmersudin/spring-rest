package com.lilium.springrest.converter;

import com.lilium.springrest.dto.BaseDTO;
import com.lilium.springrest.entity.DistributedEntity;

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
}
