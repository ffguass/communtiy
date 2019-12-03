package com.community1.springbootcommunity.mapper;

import com.community1.springbootcommunity.model.Question;



public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    }
