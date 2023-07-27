package com.lilium.springrest.dto;

import java.time.LocalDateTime;

/**
 * Base abstract DTO class for all of our DTOs.
 */
public abstract class BaseDTO {
    private Integer id;
    private LocalDateTime createdTimestamp;
    private LocalDateTime modifiedTimestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public LocalDateTime getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public void setModifiedTimestamp(LocalDateTime modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }
}
