package com.lilium.springrest.service;

import com.lilium.springrest.api.AbstractCRUDLApi;
import com.lilium.springrest.dto.BaseDTO;
import com.lilium.springrest.entity.DistributedEntity;

public class AbstractCRUDLService<ENTITY extends DistributedEntity, DTO extends BaseDTO> implements AbstractCRUDLApi {

    @Override
    public BaseDTO save(BaseDTO dto) {
        return null;
    }

    @Override
    public DTO findById(Integer id) {
        return null;
    }
}
