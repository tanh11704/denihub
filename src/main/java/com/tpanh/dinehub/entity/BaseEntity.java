package com.tpanh.dinehub.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("created_at")
    private Date createdAt;

    @PrePersist
    void onCreate() {
        this.setCreatedAt(new Timestamp((new Date()).getTime()));
        this.setUpdatedAt(new Timestamp((new Date()).getTime()));
    }

    @PreUpdate
    void onPersist() {
        this.setUpdatedAt(new Timestamp((new Date()).getTime()));
    }
}
