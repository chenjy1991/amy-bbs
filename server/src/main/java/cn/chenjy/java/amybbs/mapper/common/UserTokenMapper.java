package cn.chenjy.java.amybbs.mapper.common;
import org.apache.ibatis.annotations.Param;

import cn.chenjy.java.amybbs.model.entity.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenMapper {
    int insertSelective(UserToken record);

    UserToken selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserToken record);

    UserToken getOneByUserId(@Param("userId")Integer userId);


}