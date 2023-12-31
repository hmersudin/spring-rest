package com.lilium.springrest.service;

import com.google.common.collect.Lists;
import com.lilium.springrest.api.AbstractCRUDLApi;
import com.lilium.springrest.converter.AbstractDTOConverter;
import com.lilium.springrest.dto.BaseDTO;
import com.lilium.springrest.entity.DistributedEntity;
import com.lilium.springrest.repository.DistributedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class AbstractCRUDLService<ENTITY extends DistributedEntity, DTO extends BaseDTO>
        implements AbstractCRUDLApi<ENTITY, DTO> {

    // region Members
    private static final Logger LOG = LoggerFactory.getLogger(AbstractCRUDLService.class);
    private DistributedRepository<ENTITY> repository;
    private AbstractDTOConverter<ENTITY, DTO> converter;
    private Class<ENTITY> entityClass;
    // endregion

    // region Constructor
    public AbstractCRUDLService(final DistributedRepository<ENTITY> repository,
                                final AbstractDTOConverter<ENTITY, DTO> converter) {
        this.repository = repository;
        this.converter = converter;

        Class<?>[] params = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractCRUDLService.class);
        entityClass = (Class<ENTITY>) params[0]; //taking param ENTITY
    }
    // endregion

    // region Implementation
    @Override
    public DTO save(DTO dto) {
        final ENTITY entity;
        if (dto.isNew()) { // Save for the first time
            entity = initEntity();
        } else { // Update existing entity
            entity = repository.findById(dto.getId()).orElse(null);
        }

        if (entity == null) {
            LOG.error("Failed to save an entity of class '{}'", entity.getClass().getSimpleName());
            return null;
        }

        entity.setModifiedTimestamp(LocalDateTime.now());

        // map dto to entity
        updateEntity(entity, dto);

        // Saved entity to db
        final ENTITY savedEntity = repository.save(entity);

        // Convert savedEntity and return DTO
        return converter.convert(savedEntity);
    }

    @Override
    public DTO getById(Integer id) {
        final ENTITY entity = repository.findById(id).orElse(null);
        if (entity == null) {
            LOG.error("Failed to find entity with id '{}'", id);
            return null;
        }

        return converter.convert(entity);
    }

    @Override
    public List<DTO> list() {
        ArrayList<ENTITY> entities = Lists.newArrayList(repository.findAll());
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return converter.convertList(entities);
    }

    // To update class specific entity properties
    protected abstract void updateEntity(final ENTITY entity, final DTO dto);
    // endregion

    // region Helper
    private ENTITY initEntity() {
        try {
            final ENTITY entity = entityClass.newInstance();
            entity.setCreatedTimestamp(LocalDateTime.now());

            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }
    // endregion
}
