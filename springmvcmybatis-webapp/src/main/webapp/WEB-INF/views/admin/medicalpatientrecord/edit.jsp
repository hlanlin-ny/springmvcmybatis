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
                        <label for="name" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" placeholder="姓名">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="nameSpell" class="col-sm-2 control-label">姓名拼音</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nameSpell" name="nameSpell" placeholder="姓名拼音">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="sex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sex" name="sex" placeholder="性别">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="sexCode" class="col-sm-2 control-label">性别代码1 - 男性2 - 女性</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sexCode" name="sexCode" placeholder="性别代码1 - 男性2 - 女性">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="bornTime" class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bornTime" name="bornTime" placeholder="出生日期">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="age" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="age" name="age" placeholder="年龄">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="idCardNum" class="col-sm-2 control-label">身份证号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="idCardNum" name="idCardNum" placeholder="身份证号码">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="address" class="col-sm-2 control-label">家庭地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address" name="address" placeholder="家庭地址">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="联系电话">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="contactPerson" class="col-sm-2 control-label">联系人</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="contactPerson" name="contactPerson" placeholder="联系人">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="contactPersonSpell" class="col-sm-2 control-label">联系人姓名拼音</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="contactPersonSpell" name="contactPersonSpell" placeholder="联系人姓名拼音">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="contactCardCode" class="col-sm-2 control-label">常用证件代码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="contactCardCode" name="contactCardCode" placeholder="常用证件代码">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="contactCardName" class="col-sm-2 control-label">常用证件名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="contactCardName" name="contactCardName" placeholder="常用证件名称">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="contactCardNumber" class="col-sm-2 control-label">常用证件号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="contactCardNumber" name="contactCardNumber" placeholder="常用证件号码">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="contactAddress" class="col-sm-2 control-label">联系人现居地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="contactAddress" name="contactAddress" placeholder="联系人现居地址">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="contactPhone" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="contactPhone" name="contactPhone" placeholder="联系电话">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="relation" class="col-sm-2 control-label">与患者的关系</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="relation" name="relation" placeholder="与患者的关系">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="hospitalUnitName" class="col-sm-2 control-label">医院单位名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="hospitalUnitName" name="hospitalUnitName" placeholder="医院单位名称">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="bloodType" class="col-sm-2 control-label">血型</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bloodType" name="bloodType" placeholder="血型">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="bloodTypeCode" class="col-sm-2 control-label">血型代码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bloodTypeCode" name="bloodTypeCode" placeholder="血型代码">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="hospitalizedReason" class="col-sm-2 control-label">住院原因</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="hospitalizedReason" name="hospitalizedReason" placeholder="住院原因">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="hospitalizedDatetime" class="col-sm-2 control-label">住院日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="hospitalizedDatetime" name="hospitalizedDatetime" placeholder="住院日期">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="leavehospitalDatetime" class="col-sm-2 control-label">出院时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="leavehospitalDatetime" name="leavehospitalDatetime" placeholder="出院时间">
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