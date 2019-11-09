package com.community1.springbootcommunity.mapper;

import com.community1.springbootcommunity.model.Question;
import com.community1.springbootcommunity.model.User;
import com.community1.springbootcommunity.model.UserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
}