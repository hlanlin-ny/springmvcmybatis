<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listjs.jsp" %>
<!-- 本页面用到的js -->
<script type="text/javascript">
    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });
    //添加、修改异步提交地址
    var url = "";
    var tables = "";
    var deleteToOperateConfirmFlag = "delete";
    var batchDeleteToOperateConfirmFlag = "batch-delete";
    function Time(e){
        $(e).datetimepicker({
            dateFormat: "yy-mm-dd",
            showSecond: true,
            autoclose: true,
            timeFormat: 'hh:mm:ss',
            stepHour: 1,
            stepMinute: 1,
            stepSecond: 1,
            language: "zh-CN",
            pickerPosition:'top-right',
            onSelect: function(dateText, inst){
                console.log(dateText);
            }
        });

    }
    $().ready(function () {
        $('.modal').on('shown.bs.modal', function () {
            $(this).find('input:text:visible:first').focus();
        });

        // 提交时验证表单
        var validator = $("#edit-form").validate();

        $("#btn-cancel").on("click", function () {
            validator.resetForm();
        });

        tables = $("#data-table")
                .dataTable({
                    serverSide: true,
                    paging: true,
                    processing: true,
                    pageLength: 10,
                    ordering: true,
                    pagingType: "full_numbers",
                    stateSave: true,
                    searching: false,
                    ajax: {
                        type: "post",
                        url: "${ctxPath}/admin/warningdispostion/queryList",
                        dataSrc: function (json) {
                            json.draw = json.result.draw;
                            json.recordsTotal = json.result.recordsTotal;
                            json.recordsFiltered = json.result.recordsFiltered;
                            return json.result.data;
                        },
                        data: function (d) {
                            var formData = $("#query-form").serializeArray();
                            formData.forEach(function (e) {
                                d[e.name] = e.value;
                            });
                            return d;
                        }
                    },
                    columns: [
                        {"data": "name", defaultContent: ""},
                        {"data": "idCardNo", defaultContent: ""},
                        {"data": "warningPersonType", defaultContent: ""},
                        {"data": "informationType", defaultContent: ""},
                        {"data": "warningTime", defaultContent: ""},
                        {"data": "issueProvider", defaultContent: ""},
                        {"data": "acceptProvider", defaultContent: ""},
                        {"data": "dispositionTime", defaultContent: ""},
                        {
                            "data": "claimStatus",
                            "render": function (data, type, full, callback) {
                                if (data == "未签收") {
                                    return "<span class='label label-danger'>未签收</span>";
                                }else if(data == "已签收"){
                                    return "<span class='label label-success'>已签收</span>";
                                }
                            }
                        },
                        {
                            "data": "dispositionStatus",
                            "render": function (data, type, full, callback) {
                                if (data == "未处置") {
                                    return "<span class='label label-danger'>未处置</span>";
                                }else if(data == "处置完成"){
                                    return "<span class='label label-success'>处置完成</span>";
                                }
                            }
                        }
                        <myshiro:hasAnyPermission permissions="warningdispostion:dispostion,warningdispostion:delete">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <myshiro:hasAnyPermission permissions="warningdispostion:dispostion,warningdispostion:result">
                        {
                            targets: -1,
                            "data":"dispositionStatus",
                            "render": function (data, type, full) {
                                if (data.claimStatus == "未签收") {
                                    return "<div class='btn-group'>" +
                                            <shiro:hasPermission name="warningdispostion:claim">
                                            "<button type='button' id='btn-claim-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='签 收'><i class='fa fa-paint-brush'></i></button>" +
                                            </shiro:hasPermission>
                                            "</div>";
                                }else if(data.claimStatus == "已签收"){
                                    if(data.dispositionStatus == "未处置"){
                                        return "<div class='btn-group'>" +
                                                <shiro:hasPermission name="warningdispostion:dispostion">
                                                "<button type='button' id='btn-disposition-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='处 置'><i class='fa fa-wrench'></i></button>" +
                                                </shiro:hasPermission>
                                                "</div>";
                                    }else if(data.dispositionStatus == "处置完成"){
                                        return "<div class='btn-group'>" +
                                                <shiro:hasPermission name="warningdispostion:feedBack">
                                                "<button type='button' id='btn-feedBack-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='反 馈'><i class='fa fa-edit'></i></button>" +
                                                </shiro:hasPermission>
                                                "</div>";
                                    }

                                }
                            },
                            bSortable: false
                        }
                        </myshiro:hasAnyPermission>
                    ],
                    language: {
                        url: "${ctxPath}/resources/plugins/datatables/i18n/Chinese.json"
                    },
                    "fnInitComplete": function () {
                        this.width("100%");
                        this.fnAdjustColumnSizing();//重置列宽
                        this.fnDraw();//重新绘制
                    }
                });

        //查询按钮
        $("#btn-search").on("click", function () {
            tables.fnDraw();
            return false;
        });

        //刷新
        $("#btn-refresh").on("click", function () {
            tables.fnDraw(false);
        });

         //签收
        $("#data-table tbody").on("click", "#btn-claim-row", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            url = "${ctxPath}/admin/warningdispostion/claim";
            $.ajax({
                url:url,
                data:{id:data.id},
                type:"post",
                success:function(data){
                    if(data.code==0){
                        $.toaster("签收成功");
                        tables.fnDraw(false);
                    }else{
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                }
            });
        });

        //处置措施
        $("#data-table tbody").on("click", "#btn-disposition-row", function () {
            url = "${ctxPath}/admin/warningdispostion/disposition";
            $("#edit-modal-label").html("处置措施");
            var data = tables.api().row($(this).parents("tr")).data();
            data = {relateId:data.relateId};
            $.post(url,data,function(info){
                if (info.code == 0) {
                    var result = info.result;
                    //活动发生详情
                    var activity = result[0];
                    alert("----------------");
                    console.log(info);
                    $("#relateId").val(activity.id);
                    $("#occurTime").html(activity.occurTime);
                    $("#acceptProvider").html(activity.acceptProvider);
                    $("#warningLevel").html(activity.warningLevel);
                    $("#warningTime").html(activity.warningTime);
                    $("#areaName").html(activity.areaName);
                    $("#providerAddress").html(activity.providerAddress);
                    $("#informationProvider").html(activity.informationProvider);
                    $("#policeOffice").html(activity.policeOffice);
                    $("#activityInformation").html(activity.activityInformation);
                    $("#registerName").html(activity.registerName);
                    $("#registerIDcardNo").html(activity.registerIDcardNo);
                    $("#registerBornDate").html(activity.registerBornDate);
                    $("#dynamicInformationType").html(activity.dynamicInformationType);
                    $("#dynamicInformationProvider").html(activity.dynamicInformationProvider);
                    //预警人员信息
                    if(result[2]=="重点人员"){
                        var impotantPerson = result[1];
                        $("#name").html(impotantPerson.name);
                        $("#idcardNo").html(impotantPerson.idCardNo);
                        $("#sex").html(impotantPerson.sex);
                        $("#nation").html(impotantPerson.nation);
                        $("#bornTime").html(impotantPerson.bornTime);
                        $("#personAddress").html(impotantPerson.address);
                        $("#controlName").html(impotantPerson.controlName);
                        $("#controlPersonUnit").html(impotantPerson.controlPersonUnit);
                        $("#controlUnit").html(impotantPerson.controlUnit);
                        $("#controlContact").html(impotantPerson.controlTel);
                        $("#personType").html(impotantPerson.personType);
                    }else{
                        var controlPerson = result[1];
                        $("#name").html(controlPerson.controlByName);
                        $("#idcardNo").html(controlPerson.cardNumber);
                        $("#sex").html(controlPerson.sex);
                        $("#nation").html(controlPerson.nation);
                        $("#bornTime").html(controlPerson.bornTime);
                        $("#personAddress").html(controlPerson.address);
                        $("#controlName").html(controlPerson.applyName);
                        $("#controlPersonUnit").html(controlPerson.applyUnit);
                        $("#controlUnit").html(controlPerson.controlUnit);
                        $("#controlContact").html(controlPerson.feedBackContact);
                        $("#personType").html("临时布控");
                    }
                } else {
                    console.log("服务异常:" + data);
                    $.toaster("异常信息:" + data.message, "服务异常", "danger");
                }
            });
            $("#disposition-all-modal").modal("show");
            $('#disposition_model').show();
            $("#result-close").hide();
            $("#disposition-tools").show();
        });

        //提交措施信息
        $("#disposition-all-modal").on("click","#btn-submit-info",function(){
            url="${ctxPath}/admin/warningdispostion/disposition/add";
            var issuerName = $("#issuerName").val();
            var dispositionTime = $("#dispositionTime").val();
            var issueProvider = $("#issueProvider").val();
            var remark = $("#remark").val();
            var result = $("#result").val();
            data = {issuerName:issuerName,dispositionTime:dispositionTime,
                issueProvider:issueProvider, remark:remark,
               result:result,
                relateId:$("#relateId").val()};
            $.ajax({
                type: "post",
                url: url,
                data: data,
                dataType: "json",
                success: function (result) {
                    $.toaster("处置成功","系统提醒");
                    $("#disposition-all-modal").modal("hide");
                    tables.fnDraw(false);
                    $('#disposition_model').hide();
                    $("#disposition-tools").hide();
                },
                error: function (result) {
                    $.toaster("请求异常:" + data, "请求异常", "danger");
                }
            });
        });

        //处置结果
        $("#data-table tbody").on("click", "#btn-feedBack-row", function () {
            url = "${ctxPath}/admin/warningdispostion/feedBack";
            $("#edit-modal-label").html("处置结果");
            var data = tables.api().row($(this).parents("tr")).data();
            data = {relateId:data.relateId};
            $.post(url,data,function(info){
                if (info.code == 0) {
                    var result = info.result;
                    //活动发生详情
                    var activity = result[0];
                    $("#relateId").val(activity.id);
                    $("#occurTime").html(activity.occurTime);
                    $("#acceptProvider").html(activity.acceptProvider);
                    $("#warningLevel").html(activity.warningLevel);
                    $("#warningTime").html(activity.warningTime);
                    $("#areaName").html(activity.areaName);
                    $("#providerAddress").html(activity.providerAddress);
                    $("#informationProvider").html(activity.informationProvider);
                    $("#policeOffice").html(activity.policeOffice);
                    $("#activityInformation").html(activity.activityInformation);
                    $("#registerName").html(activity.registerName);
                    $("#registerIDcardNo").html(activity.registerIDcardNo);
                    $("#registerBornDate").html(activity.registerBornDate);
                    $("#dynamicInformationType").html(activity.dynamicInformationType);
                    $("#dynamicInformationProvider").html(activity.dynamicInformationProvider);
                    //预警人员信息
                    if(result[2]=="重点人员"){
                        var impotantPerson = result[1];
                        $("#name").html(impotantPerson.name);
                        $("#idcardNo").html(impotantPerson.idCardNo);
                        $("#sex").html(impotantPerson.sex);
                        $("#nation").html(impotantPerson.nation);
                        $("#bornTime").html(impotantPerson.bornTime);
                        $("#personAddress").html(impotantPerson.address);
                        $("#controlName").html(impotantPerson.controlName);
                        $("#controlPersonUnit").html(impotantPerson.controlPersonUnit);
                        $("#controlUnit").html(impotantPerson.controlUnit);
                        $("#controlContact").html(impotantPerson.controlTel);
                        $("#personType").html(impotantPerson.personType);
                    }else{
                        var controlPerson = result[1];
                        $("#name").html(controlPerson.controlByName);
                        $("#idcardNo").html(controlPerson.cardNumber);
                        $("#sex").html(controlPerson.sex);
                        $("#nation").html(controlPerson.nation);
                        $("#bornTime").html(controlPerson.bornTime);
                        $("#personAddress").html(controlPerson.address);
                        $("#controlName").html(controlPerson.applyName);
                        $("#controlPersonUnit").html(controlPerson.applyUnit);
                        $("#controlUnit").html(controlPerson.controlUnit);
                        $("#controlContact").html(controlPerson.feedBackContact);
                        $("#personType").html("临时布控");
                    }
                    var dispostion = result[3];
                    $("#method_name").html(dispostion.issuerName);
                    $("#method_time").html(dispostion.dispositionTime);
                    $("#method_unit").html(dispostion.issuerProvider);
                    $("#method_request").html(dispostion.instructReuqest);
                    $("#method_result").html(dispostion.result);
                } else {
                    console.log("服务异常:" + data);
                    $.toaster("异常信息:" + data.message, "服务异常", "danger");
                }
            });
            $("#disposition-all-modal").modal("show");
            $('#result_model').show();
            $('#disposition_model').hide();
            $("#result-close").show();
            $("#dispostion_table").show();
            $("#disposition-tools").hide();
        });

        $('#disposition-all-modal').on("click", "#btn-cancel1", function () {
            $("#disposition-all-modal").modal("hide");
        });




        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                    + " " + date.getHours() + seperator2 + date.getMinutes();
            +seperator2 + date.getSeconds();
            return currentdate;
        };

        $("#dispositionTime").datetimepicker({
            showSecond: true,
            weekStart: 1,
            todayHighlight: 1,
            startView: 2,
            stepHour: 1,
            forceParse: 0,
            stepMinute: 1,
            stepSecond: 1,
            todayBtn:  true,
            language: "zh-CN",
            pickerPosition:'top-right',
            autoclose:"true",
            showMeridian: 1,
            format: 'yyyy-mm-dd hh:ii:ss'

        });
        $("#add-dispositionTime").datetimepicker({
            showSecond: true,
            weekStart: 1,
            todayHighlight: 1,
            startView: 2,
            stepHour: 1,
            forceParse: 0,
            stepMinute: 1,
            stepSecond: 1,
            todayBtn:  true,
            language: "zh-CN",
            autoclose:"true",
            showMeridian: 1,
            format: 'yyyy-mm-dd hh:ii:ss'

        });
        //Date range picker
        $('#extra-search-warning').daterangepicker(
                {
                    locale: {
                        format: 'YYYY-MM-DD', //控件中from和to 显示的日期格式
                        applyLabel: '确定',
                        cancelLabel: '取消',
                        fromLabel: '起始时间',
                        toLabel: '结束时间',
                        customRangeLabel: '自定义',
                        daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
                        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月',
                            '七月', '八月', '九月', '十月', '十一月', '十二月'],
                        firstDay: 1
                    },
                    startDate: moment().subtract(7, 'days'),
                    endDate: moment()
                }
        ).val("");

        //选择时间后触发重新加载的方法
        $("#extra-search-warning").on('hide.daterangepicker', function (ev, picker) {
            $('#extra-search-warningTimeBegin').val(picker.startDate.format('YYYY-MM-DD'));
            $('#extra-search-warningTimeEnd').val(picker.endDate.format('YYYY-MM-DD'));
        });

    });


</script>