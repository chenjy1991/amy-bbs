package cn.chenjy.java.amybbs.service.impl;

import cn.chenjy.java.amybbs.mapper.common.SiteLinkMapper;
import cn.chenjy.java.amybbs.model.entity.SiteLink;
import cn.chenjy.java.amybbs.model.request.sys.LinksSave;
import cn.chenjy.java.amybbs.model.response.CommonResult;
import cn.chenjy.java.amybbs.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenJY
 * @create 2021/3/9 5:31 下午
 * @DESCRIPTION
 */
@Service
public class SysServiceImpl implements SysService {
    private static final Logger LOG = LoggerFactory.getLogger(SysServiceImpl.class);
    private static final String TAG = "SysServiceImpl";

    @Autowired
    SiteLinkMapper siteLinkMapper;

    @Override
    public CommonResult saveSiteLinks(LinksSave data) {
        if (data.getId() != null && data.getId() != 0) {
            //修改
            siteLinkMapper.updateByPrimaryKeySelective(new SiteLink(data));
        } else {
            //新增
            siteLinkMapper.insertSelective(new SiteLink(data));
        }
        return CommonResult.OK();
    }
}
