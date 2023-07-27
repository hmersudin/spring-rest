package com.lilium.springrest.repository;

import com.lilium.springrest.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends DistributedRepository<User> {
}
