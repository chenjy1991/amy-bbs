package cn.chenjy.java.amybbs.mapper.common;

import cn.chenjy.java.amybbs.model.entity.UserSecret;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserSecretMapper {
    int insertSelective(UserSecret record);

    UserSecret selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserSecret record);

    UserSecret getOneByUserIdAndSecretTypeAndSecretId(@Param("userId") Integer userId, @Param("secretType") String secretType, @Param("secretId") String secretId);

    int updateSecretKeyById(@Param("updatedSecretKey") String updatedSecretKey, @Param("id") Long id);

    int updateSecretKeyByUserIdAndSecretTypeAndSecretId(@Param("updatedSecretKey") String updatedSecretKey, @Param("userId") Integer userId, @Param("secretType") String secretType, @Param("secretId") String secretId);


}