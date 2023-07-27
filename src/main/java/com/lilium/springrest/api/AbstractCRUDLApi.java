package com.lilium.springrest.api;

import com.lilium.springrest.dto.BaseDTO;
import com.lilium.springrest.entity.DistributedEntity;

/**
 * Abstract CRUDL api containing base methods for handling of CRUDL operations.
 *
 * @param <ENTITY> Entity class.
 * @param <DTO> DTO class.
 */
public interface AbstractCRUDLApi<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    /**
     * Saves forwarded DTO. Saving (converts dto to an entity and saves that entity via repository,
     * then converts saved entity back to dto) and returning a DTO.
     * Very useful if we are immediately converts while saving.
     *
     * @param dto DTO that we are converting.
     * @return DTO to which we converted.
     */
    DTO save(DTO dto);

    /**
     * Finds DTO by forwarded ID.
     *
     * @param id ID used for searching.
     * @return Returns found DTO otherwise null.
     */
    DTO getById(Integer id);
}
