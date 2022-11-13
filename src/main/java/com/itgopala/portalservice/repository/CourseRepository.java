package com.itgopala.portalservice.repository;

import com.itgopala.portalservice.entity.CourseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<CourseEntity, String> {
}
