package com.vladproduction.jpabasic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vladproduction on 13-Apr-24
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "degree",
                column = @Column(name = "degree_level")
        ),
        @AttributeOverride(
                name = "value",
                column = @Column(name = "total_efficiency")
        )
})
public class AcademicPerformance {

    @Enumerated(
            value = EnumType.STRING
    )
    private Degree degree;
    private double value;
}
