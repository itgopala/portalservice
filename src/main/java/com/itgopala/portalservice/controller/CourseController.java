package com.itgopala.portalservice.controller;

import com.itgopala.portalservice.dto.CourseRequest;
import com.itgopala.portalservice.dto.CourseResponse;
import com.itgopala.portalservice.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

    private CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseResponse> addCourse(@RequestBody @NotNull @Valid CourseRequest request) {
        return new ResponseEntity<>(service.addCourse(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable @NotNull String id) {
        return new ResponseEntity<>(service.getCourse(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable @NotNull String id) {
        return new ResponseEntity<>(service.deleteCourse(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> updateCourse(@PathVariable @NotNull String id,
                                                       @RequestBody @NotNull @Valid CourseRequest request) {
        return new ResponseEntity<>(service.updateCourse(id, request), HttpStatus.ACCEPTED);
    }
}
