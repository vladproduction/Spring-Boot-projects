package com.vladproduction.jpabasic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by vladproduction on 14-Apr-24
 */

@Data
@AllArgsConstructor
@Builder
public class DepartmentDto {

    private String name;
    private String contactPhone;
    private String location;

}
