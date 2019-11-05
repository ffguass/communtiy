package com.community1.springbootcommunity.mapper;


import com.community1.springbootcommunity.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);/*将获取的token插入数据库*/

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);/*将token与数据库的比较，找到一致的*/

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_Id = #{accountId}")
    User findByAccountId(@Param("accountId") String account_Id);

    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(User user);
}
