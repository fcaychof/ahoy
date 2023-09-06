package com.ahoy.ccee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileDto {

    private long id;
    private String name;
    private String status;
}
