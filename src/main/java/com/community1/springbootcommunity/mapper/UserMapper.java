package com.community1.springbootcommunity.mapper;


import com.community1.springbootcommunity.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);/*将获取的token插入数据库*/

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);/*将token与数据库的比较，找到一致的*/


}
