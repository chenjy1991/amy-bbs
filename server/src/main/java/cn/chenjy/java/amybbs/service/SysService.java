package cn.chenjy.java.amybbs.service;

import cn.chenjy.java.amybbs.model.request.sys.LinksSave;
import cn.chenjy.java.amybbs.model.response.CommonResult;

public interface SysService {

    CommonResult saveSiteLinks(LinksSave data);
}
