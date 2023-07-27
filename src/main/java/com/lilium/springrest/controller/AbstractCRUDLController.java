package com.lilium.springrest.controller;

import com.lilium.springrest.api.AbstractCRUDLApi;
import com.lilium.springrest.dto.BaseDTO;
import com.lilium.springrest.entity.DistributedEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AbstractCRUDLController<ENTITY extends DistributedEntity, DTO extends BaseDTO> {
    private AbstractCRUDLApi<ENTITY, DTO> api;

    public AbstractCRUDLController(AbstractCRUDLApi<ENTITY, DTO> api) {
        this.api = api;
    }

    @PostMapping
    public void save(@RequestBody DTO dto) {
        api.save(dto);
    }
    @GetMapping("{id}")
    public DTO getById(@PathVariable Integer id) {
        return api.getById(id);
    }
}
