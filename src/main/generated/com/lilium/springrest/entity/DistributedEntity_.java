package com.lilium.springrest.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DistributedEntity.class)
public abstract class DistributedEntity_ {

	public static volatile SingularAttribute<DistributedEntity, LocalDateTime> createdTimestamp;
	public static volatile SingularAttribute<DistributedEntity, LocalDateTime> modifiedTimestamp;
	public static volatile SingularAttribute<DistributedEntity, Integer> id;

	public static final String CREATED_TIMESTAMP = "createdTimestamp";
	public static final String MODIFIED_TIMESTAMP = "modifiedTimestamp";
	public static final String ID = "id";

}

