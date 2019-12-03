package com.community1.springbootcommunity.mapper;

import com.community1.springbootcommunity.model.Question;

import java.util.List;


public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);
    }
