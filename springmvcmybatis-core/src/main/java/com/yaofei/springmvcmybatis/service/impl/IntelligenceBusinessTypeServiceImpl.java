package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.IntelligenceBusinessType;
import com.yaofei.springmvcmybatis.entity.IntelligenceSharePermission;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.IntelligenceBusinessTypeRepository;
import com.yaofei.springmvcmybatis.service.IntelligenceBusinessTypeService;
import com.yaofei.springmvcmybatis.service.IntelligenceSharePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("intelligenceBusinessTypeService")
public class IntelligenceBusinessTypeServiceImpl extends AbstractBaseService<IntelligenceBusinessType> implements IntelligenceBusinessTypeService {
    @Autowired
    private IntelligenceBusinessTypeRepository intelligenceBusinessTypeRepository;
    @Autowired
    private IntelligenceSharePermissionService intelligenceSharePermissionService;

    @Override
    public List<IntelligenceBusinessType> queryListOrderByOrderNum(Long areaId) {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        if (areaId != null) {
            extraSearch.put("areaId", areaId.toString());
        }
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("order_num ASC,id DESC");
        return intelligenceBusinessTypeRepository.queryList(dataTablesRequest);
    }

    @Override
    public String getParentString(Long businessTypeId) {
        List<IntelligenceBusinessType> intelligenceBusinessTypes = intelligenceBusinessTypeRepository.getParentList(businessTypeId);
        String parentString = "";
        for (IntelligenceBusinessType intelligenceBusinessType : intelligenceBusinessTypes) {
            parentString += intelligenceBusinessType.getName() + " > ";
        }
        if (parentString.length() > 3) {
            parentString = parentString.substring(0, parentString.length() - 3);
        }
        return parentString;
    }

    @Override
    public List<IntelligenceBusinessType> queryAllRightIntelligenceBusinessType(Long areaId) {
        //先得到自己行政区划的分类
        List<IntelligenceBusinessType> intelligenceBusinessTypes = this.queryListOrderByOrderNum(areaId);
        //再得到其他行政区划授权的分类
        //获取其他区域权限
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        extraSearch.put("shareToAreaId", areaId.toString());
        dataTablesRequest.setExtraSearch(extraSearch);
        List<IntelligenceSharePermission> intelligenceSharePermissions = intelligenceSharePermissionService.queryList(dataTablesRequest);
        if (intelligenceSharePermissions != null && intelligenceSharePermissions.size() > 0) {
            for (IntelligenceSharePermission intelligenceSharePermission : intelligenceSharePermissions) {
                intelligenceBusinessTypes.add(super.queryObject(intelligenceSharePermission.getIntelligenceBusinessTypeId()));
            }
        }
        return intelligenceBusinessTypes;
    }

    //@Override
    //public Map querySysUserDepartmentIdNameMap() {
    //	Map<Long, String> map = new HashMap<>();
    //	List<IntelligenceBusinessType> intelligenceBusinessTypes = queryListOrderByOrderNum();
    //	for (IntelligenceBusinessType intelligenceBusinessType : intelligenceBusinessTypes) {
    //		map.put(intelligenceBusinessType.getId(), intelligenceBusinessType.getName());
    //	}
    //	return map;
    //}
    @Override
    public IntelligenceBusinessType queryBusinessTypeName(Long typeId) {

        return intelligenceBusinessTypeRepository.queryBusinessTypeName(typeId);
    }
}
