package cn.chenjy.java.amybbs.mapper.common;

import cn.chenjy.java.amybbs.model.entity.SiteLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteLinkMapper {
    int insertSelective(SiteLink record);

    SiteLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiteLink record);

    List<SiteLink> findAllByIsDeleted(@Param("isDeleted") Boolean isDeleted);

    int updateIsDeletedById(@Param("updatedIsDeleted") Boolean updatedIsDeleted, @Param("id") Integer id);


}