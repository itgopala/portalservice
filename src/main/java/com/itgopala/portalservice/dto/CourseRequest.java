package com.itgopala.portalservice.dto;

import com.itgopala.portalservice.common.data.Topic;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Value
public class CourseRequest {
    @NotBlank
    private String name;
    @NotEmpty
    private List<Topic> topics;
    @NotBlank
    private String userName;
}
