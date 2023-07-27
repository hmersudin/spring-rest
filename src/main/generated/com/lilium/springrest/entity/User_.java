package com.lilium.springrest.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.lilium.springrest.entity.DistributedEntity_ {

	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> username;

	public static final String NAME = "name";
	public static final String USERNAME = "username";

}

