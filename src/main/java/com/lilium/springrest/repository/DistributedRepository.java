package com.lilium.springrest.repository;

import com.lilium.springrest.entity.DistributedEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @param <ENTITY> Type of our entity.
 */
public interface DistributedRepository<ENTITY extends DistributedEntity> extends CrudRepository<ENTITY, Integer> {
}
