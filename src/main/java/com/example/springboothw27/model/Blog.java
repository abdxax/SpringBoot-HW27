package com.example.springboothw27.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "user title be null")
    private String title;
    @NotEmpty(message = "user body be null")
    private String body ;
    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    @JsonIgnore
    private MyUser user;

}
