package com.itgopala.portalservice.entity;

import com.itgopala.portalservice.common.data.Topic;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document("CourseEntity")
@Value
public class CourseEntity extends CommonDBProperties{
    @Id
    private String id;
    private String name;
    private List<Topic> topics;

    @Builder
    public CourseEntity(Instant createTime,
                        Instant updateTime, String createdBy, String updatedBy, String id,
                        String name, List<Topic> topics) {
        super(createTime, updateTime, createdBy, updatedBy);
        this.id = id;
        this.name = name;
        this.topics = topics;
    }
}
