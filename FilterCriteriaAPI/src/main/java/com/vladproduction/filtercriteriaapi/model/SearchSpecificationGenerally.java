package com.vladproduction.filtercriteriaapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchSpecificationGenerally {

    private String columnName;
    private String value;
    private String operation;
    private String joinTable;

}
