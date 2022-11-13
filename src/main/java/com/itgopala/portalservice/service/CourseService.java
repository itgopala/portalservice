package com.itgopala.portalservice.service;

import com.itgopala.portalservice.dto.CourseRequest;
import com.itgopala.portalservice.dto.CourseResponse;
import com.itgopala.portalservice.entity.CourseEntity;
import com.itgopala.portalservice.exceptions.ResourceNotFoundException;
import com.itgopala.portalservice.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository repository;

    public List<CourseResponse> getAllCourses() {
        return repository.findAll().stream().map(this::mapEntityToResponse).collect(Collectors.toList());
    }

    private CourseResponse mapEntityToResponse(CourseEntity entity) {
        return CourseResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .topics(entity.getTopics())
                .build();
    }

    public CourseResponse addCourse(CourseRequest request) {
        return Optional.of(repository.save(CourseEntity.builder()
                .createTime(Instant.now())
                .updateTime(Instant.now())
                .createdBy(request.getUserName())
                .updatedBy(request.getUserName())
                .name(request.getName())
                .topics(request.getTopics())
                .build())).map(this::mapEntityToResponse).get();
    }

    public CourseResponse getCourse(String id) {
        return repository.findById(id).map(this::mapEntityToResponse).orElseThrow(() -> new ResourceNotFoundException(
                String.format("With given id: %s there is not course available", id)
        ));
    }

    public String deleteCourse(String id) {
        repository.deleteById(id);
        return "Course deleted";
    }

    public CourseResponse updateCourse(String id, @NotNull @Valid CourseRequest request) {
        CourseEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("With given id: %s there is not course available", id)
        ));
        return Optional.of(repository.save(CourseEntity.builder()
                .id(entity.getId())
                .name(request.getName())
                .topics(request.getTopics())
                .updatedBy(request.getUserName())
                .updateTime(Instant.now())
                .createdBy(entity.getCreatedBy())
                .createTime(entity.getCreateTime())
                .build())).map(this::mapEntityToResponse).get();
    }
}