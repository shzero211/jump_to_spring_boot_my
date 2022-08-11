package com.example.sh.Question;

import com.example.sh.Answer.Answer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

@Column(length = 200)
    private String subject;

@Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE)
    private List<Answer> answerList=new ArrayList<>();

    public Question(String subject, String content, LocalDateTime createDate) {
    this.subject=subject;
    this.content=content ;
    this.createDate=createDate;
    }
}
