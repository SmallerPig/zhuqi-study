package com.zhuqi.study.zhuqistudymybatis.Mapper;

import com.zhuqi.study.zhuqistudymybatis.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * findOne
     *
     * @param id
     * @return
     */
    @Select(value = "select *from boot_user where id=#{id}")
    UserInfo findOne(int id);

    /**
     * findAll
     *
     * @return
     */
    List<UserInfo> findAll();


    /**
     * insert
     *
     * @return
     */
    @Insert(value = "INSERT boot_user (name, tel, create_time) VALUES(#{name}, #{tel}, #{createTime} )")
    void insert(UserInfo userInfo);
}
