package cn.chenjy.java.amybbs.mapper.common;
import org.apache.ibatis.annotations.Param;

import cn.chenjy.java.amybbs.model.entity.UserBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBaseMapper {
    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBase record);

    UserBase getOneByEmail(@Param("email")String email);


}