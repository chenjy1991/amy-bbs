package cn.chenjy.java.amybbs.controller;

import cn.chenjy.java.amybbs.framework.annotation.Auth;
import cn.chenjy.java.amybbs.framework.annotation.RoleType;
import cn.chenjy.java.amybbs.mapper.common.BbsConfigMapper;
import cn.chenjy.java.amybbs.mapper.common.SiteLinkMapper;
import cn.chenjy.java.amybbs.model.constant.ConfigKeyConst;
import cn.chenjy.java.amybbs.model.entity.BbsConfig;
import cn.chenjy.java.amybbs.model.entity.SiteLink;
import cn.chenjy.java.amybbs.model.request.sys.LinksSave;
import cn.chenjy.java.amybbs.model.response.CommonResult;
import cn.chenjy.java.amybbs.model.response.sys.ConfigResult;
import cn.chenjy.java.amybbs.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ChenJY
 * @create 2021/3/9 12:06 上午
 * @DESCRIPTION
 */
@RestController
@RequestMapping("sys")
public class SysController {
    private static final Logger LOG = LoggerFactory.getLogger(SysController.class);
    private static final String TAG = "SysController";

    @Autowired
    BbsConfigMapper bbsConfigMapper;
    @Autowired
    SiteLinkMapper siteLinkMapper;
    @Autowired
    SysService sysService;

    /**
     * 获取所有系统配置
     *
     * @return
     */
    @GetMapping("configs")
    @Auth(role = RoleType.OWNER)
    public CommonResult listAllBbsConfig() {
        List<BbsConfig> list = bbsConfigMapper.listAll();
        return CommonResult.OK(list);
    }

    /**
     * 修改系统配置
     *
     * @param data
     * @return
     */
    @PostMapping("configs/modify")
    @Auth(role = RoleType.OWNER)
    public CommonResult saveConifgs(@RequestBody BbsConfig data) {
        if (StringUtils.isEmpty(data.getKey()) || StringUtils.isEmpty(data.getValue())) {
            return ConfigResult.EmptyParams();
        }
        if (!ConfigKeyConst.KEYS.contains(data.getKey())) {
            return ConfigResult.NotAllowParams();
        }
        bbsConfigMapper.updateByKey(data, data.getKey());
        return CommonResult.OK();
    }

    /**
     * 获取所有友情链接
     *
     * @return
     */
    @GetMapping("links")
    @Auth(role = RoleType.OWNER)
    public CommonResult listAllSiteLinks() {
        List<SiteLink> list = siteLinkMapper.findAllByIsDeleted(false);
        return CommonResult.OK(list);
    }

    /**
     * 保存友情链接
     *
     * @param data
     * @return
     */
    @PostMapping("links/save")
    @Auth(role = RoleType.OWNER)
    public CommonResult saveSiteLinks(@RequestBody LinksSave data) {
        if (StringUtils.isEmpty(data.getTitle()) || StringUtils.isEmpty(data.getUrl())) {
            return ConfigResult.EmptyParams();
        }
        return sysService.saveSiteLinks(data);
    }

    /**
     * 删除友情链接
     *
     * @param data
     * @return
     */
    @PostMapping("links/remove")
    @Auth(role = RoleType.OWNER)
    public CommonResult removeSiteLinks(@RequestBody LinksSave data) {
        if (data.getId() == null || data.getId() == 0) {
            return ConfigResult.EmptyParams();
        }
        siteLinkMapper.updateIsDeletedById(true, data.getId());
        return CommonResult.OK();
    }
}
