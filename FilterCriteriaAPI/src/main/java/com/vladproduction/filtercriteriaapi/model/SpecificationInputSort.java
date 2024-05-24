package com.vladproduction.filtercriteriaapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationInputSort {

    private String columnName;
    private String value;
    private String sortColumn;
    private String sortOrder;


}
