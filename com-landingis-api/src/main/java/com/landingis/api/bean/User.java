package com.landingis.api.bean;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    @Size(min=2, message = "Name should have at least 2 characters")
    String name;

    @NotNull
    @Past(message = "Birth Date should be in the past")
    Date birthday;

    @NotNull
    @OneToMany(mappedBy = "user")
    List<Post> posts;
}
