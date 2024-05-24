package com.vladproduction.filtercriteriaapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationInputSortPaging {

    private String columnName;
    private String value;
    private String sortColumn;
    private String sortOrder;
    private Integer pageNumber;
    private Integer pageSize;


}
