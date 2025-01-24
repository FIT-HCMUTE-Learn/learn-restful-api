package com.landingis.api.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonFilter("SomeBeanFilter")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SomeBean {
    String field1;
    String field2;
    String field3;
}
