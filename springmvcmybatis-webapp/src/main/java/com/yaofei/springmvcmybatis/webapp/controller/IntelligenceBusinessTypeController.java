package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.IntelligenceBusinessType;
import com.yaofei.springmvcmybatis.entity.SysArea;
import com.yaofei.springmvcmybatis.service.IntelligenceBusinessTypeService;
import com.yaofei.springmvcmybatis.service.SysAreaService;
import com.yaofei.springmvcmybatis.webapp.dto.TreeNode;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 情报业务类型
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-01 08:56:47
 */
@Controller
@RequestMapping("/admin/intelligencebusinesstype")
public class IntelligenceBusinessTypeController extends BaseCRUDController<IntelligenceBusinessType> {
    @Autowired
    private IntelligenceBusinessTypeService intelligenceBusinessTypeService;
    @Autowired
    private SysAreaService sysAreaService;

    @ResponseBody
    @RequestMapping(value = "/queryAllNodes", method = RequestMethod.GET)
    public JsonResult queryAllNodes(ServletRequest request) {
        //查询列表数据
        System.out.println(super.getAreaId());
        List<IntelligenceBusinessType> intelligenceBusinessTypes = intelligenceBusinessTypeService.queryListOrderByOrderNum(super.getAreaId());

        List<TreeNode> treeNodes = new ArrayList<>();
        //添加顶级菜单
        TreeNode node = new TreeNode(0L, -1L, "根", false, true);
        treeNodes.add(node);
        for (IntelligenceBusinessType intelligenceBusinessType : intelligenceBusinessTypes) {
            node = new TreeNode(intelligenceBusinessType.getId(), intelligenceBusinessType.getParentId(), intelligenceBusinessType.getName(), false, true);
            treeNodes.add(node);
        }
        return JsonResult.ok().addResult(JSON.toJSON(treeNodes));
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllRightIntelligenceBusinessType", method = RequestMethod.GET)
    public JsonResult queryAllRightIntelligenceBusinessType(ServletRequest request) {
        //查询列表数据
            List<IntelligenceBusinessType> intelligenceBusinessTypes = intelligenceBusinessTypeService.queryAllRightIntelligenceBusinessType(super.getAreaId());

        List<TreeNode> treeNodes = new ArrayList<>();
        //添加顶级菜单
        TreeNode node = new TreeNode(0L, 0L, "根", false, true);
        treeNodes.add(node);
        for (IntelligenceBusinessType intelligenceBusinessType : intelligenceBusinessTypes) {
            boolean hasParent = false;
            //如果treeNodes中没有包括父亲节点，则添加行政区划
            for (TreeNode treeNode : treeNodes) {
                if (treeNode.getId().equals(intelligenceBusinessType.getParentId()) ) {
                    hasParent = true;
                    break;
                }
            }
            if (hasParent) {
                node = new TreeNode(intelligenceBusinessType.getId(), intelligenceBusinessType.getParentId(), intelligenceBusinessType.getName(), false, true);
                treeNodes.add(node);
            } else {
                //加一个行政区划 的同时 加 类别
                SysArea sysArea = sysAreaService.queryObject(intelligenceBusinessType.getAreaId());
                Long parnetId = 0 - sysArea.getId();
                node = new TreeNode(parnetId, 0L, sysArea.getName(), false, true);
                treeNodes.add(node);
                node = new TreeNode(intelligenceBusinessType.getId(), parnetId, intelligenceBusinessType.getName(), false, true);
                treeNodes.add(node);
            }
        }
        return JsonResult.ok().addResult(JSON.toJSON(treeNodes));
    }
}