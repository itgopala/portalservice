package com.itgopala.portalservice.dto;

import com.itgopala.portalservice.common.data.Topic;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseResponse {
    private String id;
    private String name;
    private List<Topic> topics;
}
