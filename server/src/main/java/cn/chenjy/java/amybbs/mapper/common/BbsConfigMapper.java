package cn.chenjy.java.amybbs.mapper.common;

import cn.chenjy.java.amybbs.model.entity.BbsConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BbsConfigMapper {
    int insertSelective(BbsConfig record);

    BbsConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbsConfig record);

    BbsConfig getOneByKey(@Param("key") String key);

    List<BbsConfig> listAll();

    int updateByKey(@Param("updated") BbsConfig updated, @Param("key") String key);


}