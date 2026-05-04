package org.example._0_proeun_phatsa_spring_homework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posts  {
    private long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private String tags;

}
