package cn.chenjy.java.amybbs.mapper.common;

import cn.chenjy.java.amybbs.model.entity.UserBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserBaseMapper {
    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBase record);

    UserBase getOneByEmail(@Param("email") String email);

    Integer countByEmail(@Param("email") String email);

    Integer countByNickname(@Param("nickname") String nickname);

    int updateIsActivatedById(@Param("updatedIsActivated") Boolean updatedIsActivated, @Param("id") Integer id);


}