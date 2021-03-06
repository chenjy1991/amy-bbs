package cn.chenjy.java.amybbs.mapper.common;
import org.apache.ibatis.annotations.Param;

import cn.chenjy.java.amybbs.model.entity.BbsConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsConfigMapper {
    int insertSelective(BbsConfig record);

    BbsConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbsConfig record);

    BbsConfig getOneByKey(@Param("key")String key);


}