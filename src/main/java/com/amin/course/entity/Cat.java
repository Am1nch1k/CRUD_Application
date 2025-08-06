package com.amin.course.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Cat {
    String name;
    int age;
    String color;
    String description;

}
