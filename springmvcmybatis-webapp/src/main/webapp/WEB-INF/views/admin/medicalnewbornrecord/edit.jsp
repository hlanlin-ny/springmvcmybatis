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
                        <label for="sex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sex" name="sex" placeholder="性别">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="sexDetail" class="col-sm-2 control-label">性别描述</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sexDetail" name="sexDetail" placeholder="性别描述">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="bornTime" class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bornTime" name="bornTime" placeholder="出生日期">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="idCardNum" class="col-sm-2 control-label">身份证号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="idCardNum" name="idCardNum" placeholder="身份证号码">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="deliverOrganization" class="col-sm-2 control-label">接生机构名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="deliverOrganization" name="deliverOrganization" placeholder="接生机构名称">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="address" class="col-sm-2 control-label">家庭地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address" name="address" placeholder="家庭地址">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="checkInDatetime" class="col-sm-2 control-label">信息登记时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="checkInDatetime" name="checkInDatetime" placeholder="信息登记时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="motherName" class="col-sm-2 control-label">母亲姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="motherName" name="motherName" placeholder="母亲姓名">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="motherNation" class="col-sm-2 control-label">母亲民族</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="motherNation" name="motherNation" placeholder="母亲民族">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="motherNationDetail" class="col-sm-2 control-label">母亲民族描述</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="motherNationDetail" name="motherNationDetail" placeholder="母亲民族描述">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="motherIdcardnum" class="col-sm-2 control-label">母亲身份证号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="motherIdcardnum" name="motherIdcardnum" placeholder="母亲身份证号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="motherPhone" class="col-sm-2 control-label">母亲联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="motherPhone" name="motherPhone" placeholder="母亲联系电话">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="fatherName" class="col-sm-2 control-label">父亲姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fatherName" name="fatherName" placeholder="父亲姓名">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="fatherNation" class="col-sm-2 control-label">父亲民族</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fatherNation" name="fatherNation" placeholder="父亲民族">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="fatherNationDetail" class="col-sm-2 control-label">父亲民族描述</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fatherNationDetail" name="fatherNationDetail" placeholder="父亲民族描述">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="fatherIdcardnum" class="col-sm-2 control-label">父亲身份证号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fatherIdcardnum" name="fatherIdcardnum" placeholder="父亲身份证号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="fatherPhone" class="col-sm-2 control-label">父亲联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fatherPhone" name="fatherPhone" placeholder="父亲联系电话">
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