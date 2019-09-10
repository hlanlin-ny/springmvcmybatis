<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="edit-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label" aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="edit-modal-label">添加</h4>
            </div>

            <!-- form start -->
            <form id="edit-form" name="edit-form" class="form-horizontal">

                <div class="modal-body">
                    <input type="hidden" class="form-control" id="id" name="id">

                                                        
                    <div class="form-group">
                        <label for="areaId" class="col-sm-2 control-label">行政区划编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="areaId" name="areaId" placeholder="行政区划编号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="businessTypeId" class="col-sm-2 control-label">情报业务分类ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="businessTypeId" name="businessTypeId" placeholder="情报业务分类ID">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="fileType" class="col-sm-2 control-label">文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fileType" name="fileType" placeholder="文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="detailsUrl" class="col-sm-2 control-label">详情页面url</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="detailsUrl" name="detailsUrl" placeholder="详情页面url">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="collectTime" class="col-sm-2 control-label">收集时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="collectTime" name="collectTime" placeholder="收集时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="esIndexName" class="col-sm-2 control-label">插入es的时候用的es的索引名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="esIndexName" name="esIndexName" placeholder="插入es的时候用的es的索引名称">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="userId" class="col-sm-2 control-label">所属用户编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userId" name="userId" placeholder="所属用户编号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="medicalType" class="col-sm-2 control-label">医疗类型</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="medicalType" name="medicalType" placeholder="医疗类型">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="medicalTypeCode" class="col-sm-2 control-label">医疗类型代码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="medicalTypeCode" name="zmedicalTypeCode" placeholder="医疗类型代码">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="cost" class="col-sm-2 control-label">医疗费用金额</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cost" name="cost" placeholder="医疗费用金额">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="hospitalizationDatetime" class="col-sm-2 control-label">住院时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="hospitalizationDatetime" name="hospitalizationDatetime" placeholder="住院时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="leavehospitalDatetime" class="col-sm-2 control-label">出院时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="leavehospitalDatetime" name="leavehospitalDatetime" placeholder="出院时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="hospitalizationIllness" class="col-sm-2 control-label">入院疾病</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="hospitalizationIllness" name="hospitalizationIllness" placeholder="入院疾病">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="diagnosisHospitalization" class="col-sm-2 control-label">确诊疾病</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="diagnosisHospitalization" name="diagnosisHospitalization" placeholder="确诊疾病">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="complicationDetail" class="col-sm-2 control-label">并发症简要情况</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="complicationDetail" name="complicationDetail" placeholder="并发症简要情况">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="leavehospitalReason" class="col-sm-2 control-label">出院原因</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="leavehospitalReason" name="leavehospitalReason" placeholder="出院原因">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="doctor" class="col-sm-2 control-label">医生姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="doctor" name="doctor" placeholder="医生姓名">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="hospitalizationNo" class="col-sm-2 control-label">住院号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="hospitalizationNo" name="hospitalizationNo" placeholder="住院号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="hospitalizationDepartment" class="col-sm-2 control-label">住院科室</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="hospitalizationDepartment" name="hospitalizationDepartment" placeholder="住院科室">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="takeDatetime" class="col-sm-2 control-label">办理日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="takeDatetime" name="takeDatetime" placeholder="办理日期">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="responsiblePersonName" class="col-sm-2 control-label">经办人姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="responsiblePersonName" name="responsiblePersonName" placeholder="经办人姓名">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="hospitalNumber" class="col-sm-2 control-label">医院编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="hospitalNumber" name="hospitalNumber" placeholder="医院编号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="personNumber" class="col-sm-2 control-label">个人编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="personNumber" name="personNumber" placeholder="个人编号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="organizationNumber" class="col-sm-2 control-label">单位编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="organizationNumber" name="organizationNumber" placeholder="单位编号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="reimbursementSign" class="col-sm-2 control-label">报销标志</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="reimbursementSign" name="reimbursementSign" placeholder="报销标志">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="reimbursementSignDetail" class="col-sm-2 control-label">报销标志_简要情况</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="reimbursementSignDetail" name="reimbursementSignDetail" placeholder="报销标志_简要情况">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="accountEndStatus" class="col-sm-2 control-label">结算状态</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="accountEndStatus" name="accountEndStatus" placeholder="结算状态">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="accountEndStatusDetail" class="col-sm-2 control-label">结算状态_简要情况</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="accountEndStatusDetail" name="accountEndStatusDetail" placeholder="结算状态_简要情况">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="remark" name="remark" placeholder="备注">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="isDeleted" class="col-sm-2 control-label">删除状态  0：正常   1：已删除</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="isDeleted" name="isDeleted" placeholder="删除状态  0：正常   1：已删除">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="createdTime" class="col-sm-2 control-label">创建时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="createdTime" name="createdTime" placeholder="创建时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="createdBy" class="col-sm-2 control-label">创建人</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="createdBy" name="createdBy" placeholder="创建人">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="createdIp" class="col-sm-2 control-label">创建IP</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="createdIp" name="createdIp" placeholder="创建IP">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="modificationTime" class="col-sm-2 control-label">修改时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="modificationTime" name="modificationTime" placeholder="修改时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="modificationBy" class="col-sm-2 control-label">修改人</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="modificationBy" name="modificationBy" placeholder="修改人">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="modificationIp" class="col-sm-2 control-label">修改人IP</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="modificationIp" name="modificationIp" placeholder="修改人IP">
                        </div>
                    </div>
                            
                </div>

                <div class="modal-footer">
                    <div class="pull-right">
                        <button id="btn-submit" type="submit" class="btn btn-primary"><i
                                class="glyphicon glyphicon-ok"></i> 确 定
                        </button>
                        <button id="btn-cancel" type="button" class="btn btn-default" data-dismiss="modal"><i
                                class="glyphicon glyphicon-remove"></i> 取 消
                        </button>
                    </div>
                </div>

            </form>

        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>