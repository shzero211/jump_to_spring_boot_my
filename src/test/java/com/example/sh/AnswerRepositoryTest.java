package com.example.sh;

import com.example.sh.Answer.Answer;
import com.example.sh.Answer.AnswerRepository;
import com.example.sh.Question.Question;
import com.example.sh.Question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

@SpringBootTest
public class AnswerRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Test
    @Transactional
    public void saveAndFindById(){
        Question q1=new Question("subject1","content1", LocalDateTime.now());
        questionRepository.save(q1);
        Answer a1=new Answer("content1",LocalDateTime.now(),q1);
        answerRepository.save(a1);

        Answer a2=answerRepository.findById(1).get();
        assertThat(a1.getId()).isEqualTo(a2.getId());
    }
}
