package cn.chenjy.java.amybbs.mapper.common;

import cn.chenjy.java.amybbs.model.entity.UserToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserTokenMapper {
    int insertSelective(UserToken record);

    UserToken selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserToken record);

    UserToken getOneByUserId(@Param("userId") Integer userId);


}