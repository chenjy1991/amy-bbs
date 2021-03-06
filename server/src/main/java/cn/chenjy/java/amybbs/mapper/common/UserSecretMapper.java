package cn.chenjy.java.amybbs.mapper.common;
import org.apache.ibatis.annotations.Param;

import cn.chenjy.java.amybbs.model.entity.UserSecret;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSecretMapper {
    int insertSelective(UserSecret record);

    UserSecret selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserSecret record);

    UserSecret getOneByUserIdAndSecretTypeAndSecretId(@Param("userId")Integer userId,@Param("secretType")String secretType,@Param("secretId")String secretId);


}