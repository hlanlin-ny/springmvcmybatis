<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/basejs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/listjs.jsp" %>
<% String confId = (String) request.getAttribute("confId");%>
<!-- AdminLTE for demo purposes -->
<script src="${ctxPath}/resources/dist/js/demo.js"></script>
<%-- jQuery validation --%>
<script src="${ctxPath}/resources/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="${ctxPath}/resources/plugins/jquery-validation/localization/messages_zh.js"></script>
<%-- jQuery serializeObject --%>
<script src="${ctxPath}/resources/plugins/serializeobject/jquery.serialize-object.min.js"></script>
<%-- PACE --%>
<script src="${ctxPath}/resources/plugins/pace/pace.min.js"></script>
<%-- jQuery Toaster --%>
<script src="${ctxPath}/resources/plugins/toaster/jquery.toaster.js"></script>
<%-- bootstrap3 typeahead --%>
<script src="${ctxPath}/resources/plugins/typeahead/bootstrap3-typeahead.min.js"></script>
<%-- date-range-picker --%>
<script src="${ctxPath}/resources/plugins/moment/moment.min.js"></script>
<script src="${ctxPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
<%-- iCheck 1.0.1 --%>
<script src="${ctxPath}/resources/plugins/iCheck/icheck.min.js"></script>
<%-- jQuery Toaster --%>
<script src="${ctxPath}/resources/plugins/toaster/jquery.toaster.js"></script>
<%-- jQuery validation --%>
<script src="${ctxPath}/resources/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="${ctxPath}/resources/plugins/jquery-validation/localization/messages_zh.js"></script>
<%-- zTree --%>
<script src="${ctxPath}/resources/plugins/zTree/js/jquery.ztree.all.min.js"></script>
<%-- jqPaginator --%>
<script src="${ctxPath}/resources/plugins/jqPaginator/jqPaginator.min.js"></script>

<!-- 本页面用到的js -->
<script type="text/javascript">

    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });

    Date.prototype.toHyphenDateString = function() {
        var year = this.getFullYear();
        var month = this.getMonth() + 1;
        var date = this.getDate();
        if (month < 10) { month = "0" + month; }
        if (date < 10) { date = "0" + date; }
        return year + "-" + month + "-" + date;
    };

    var ztree;

    $().ready(function () {

        //Date range picker
        $('#startTime').datetimepicker({
            startView: 2,
            minView: 2,
            weekStart: 1,
            autoclose: true,
            todayBtn: "linked",
            language: "zh-CN",
            todayHighlight: true,
            format: 'yyyy-mm-dd'
        });

        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            check: {
                enable: true,
                nocheckInherit: true
            }
        };

        //加载菜单树
        $.get("${ctxPath}/admin/intelligencebusinesstype/queryAllRightIntelligenceBusinessType", function (data) {
            ztree = $.fn.zTree.init($("#menuTree"), setting, data.result);
            //展开所有节点
            ztree.expandAll(true);

            //初始化form表单数据
            $.get("${ctxPath}/admin/syssearchwarninglog/foundConfObj?confId=<%=confId%>", function (res) {

                var data = res.result;
                //$("input[name='filetype']:checkbox").iCheck("uncheck");
                ztree.checkAllNodes(false);
                $("input[name='fileType']:checkbox").iCheck("uncheck");
                $("#keyword").val(data.keywords);
                $("#startTime").val(data.startTime);

                if(data.isExactMatching){
                    $("input[name='preciseQuery'][value='1']").iCheck("check");
                }else {
                    $("input[name='preciseQuery']:checkbox").iCheck("uncheck");
                }
                //情报类型回显
                var nodesId = eval(data.businesstypeid);
                if(nodesId!=null&&nodesId.length>0) {
                    $.each(nodesId, function (index, value) {
                        var node = ztree.getNodeByParam("id", value);
                        if (node) {
                            ztree.checkNode(node);
                        }
                    });
                }
                //文件类型回显
                var checkList = eval(data.filetype);
                if(checkList!=null&&checkList.length>0) {
                    $.each(checkList, function (index, d) {
                        $("input[name='fileType'][value='"+d+"']").iCheck("check");
                    });
                }
                //查询
                getSearchData();
            });
        });

        $("#keyword").focus();

        //重置
        $("#btn-reset").on("click", function () {
            $("#query-form :input").val("");
            $("input[name='fileType']:checkbox").iCheck("uncheck");
            $("input[name='preciseQuery']:checkbox").iCheck("uncheck");
            ztree.checkAllNodes(false);
        });

        //查询按钮
        $("#btn-search").on("click", function () {
            getSearchData();
            return false;
        });

        function getSearchData() {
            var keyword = $("#keyword").val();
            //关键字
            if (keyword==null||keyword=='') {
                return false;
            }

            //获取选择的菜单
            var nodes = ztree.getCheckedNodes(true);
            var intelligenceBusinessTypeIds = new Array();
            for (var i = 0; i < nodes.length; i++) {
                if (nodes[i].id > 0) {
                    intelligenceBusinessTypeIds.push(nodes[i].id);
                }
            }
            if (intelligenceBusinessTypeIds.length > 0) {
                $("#intelligenceBusinessTypeIds").val(JSON.stringify(intelligenceBusinessTypeIds));
            }

            var fileTypes = new Array();
            $("input[name='fileType']:checkbox").each(function () {
                if (true == $(this).is(":checked")) {
                    fileTypes.push($(this).val());
                }
            });

            if (fileTypes.length > 0) {
                $("#fileTypes").val(JSON.stringify(fileTypes));
            }

            var data = JSON.parse($("#query-form").serializeJSON());
            data.intelligenceBusinessTypeIds = intelligenceBusinessTypeIds;
            data.fileTypes = fileTypes;
            if(data.preciseQuery=="1") {
                data.preciseQuery = "true";
            }else{
                data.preciseQuery = "false";
            }
            var date = new Date();
            date.setTime(date.getTime()+24*60*60*1000)
            data.endTime = date.toHyphenDateString();
            data = JSON.stringify(data);
            $.ajax({
                cache: false,
                type: "POST",
                url: "${ctxPath}/admin/syssearchwarninglog/querySearchResult",
                data: data,
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.code == 0) {
                        $('#searchResultList').html("");
                        $("#totalHits").html("相关结果约" + parseFormatNum(data.result.totalHits, 0) + "条");
                        $.each(data.result.hitDatas,
                                function (index, value) {
                                    var content = "";
//                                if ($("#datasourceType").val() == "2") {
                                    content = "<dl><dt><a href='" + value['url'] + "' target='_blank'>" + value['title'] + "</a><dt/>";
                                    if (value['fileType'] == "8") {
                                        content += "<dd><a href='" + value['url'] + "' target='_blank'>" + "<img src='" + value['url'] + "' height='150px' style='margin:5px'></a><dd/> ";
                                    } else if (value['fileType'] == "9") {
                                        content += "<dd><audio controls><source src='" + value['url'] + "' type='audio/mpeg'></audio><dd/> ";
                                    } else if (value['fileType'] == "10") {
                                        content += "<dd><video width='320' height='240' controls><source src='" + value['url'] + "' type='video/mp4'></video><dd/> ";
                                    }
                                    content += "<dd>" + value['content'] + " <dd/> ";
                                    content += "<small class='pull-right'>更新时间：" + value['collectTime'] + "&nbsp;&nbsp;业务类型：" + value['businessTypeName'] + "&nbsp;&nbsp;&nbsp;&nbsp;行政区划：" + value['areaName'] + "&nbsp;</small></dl>";
//                                } else {
//
//                                }
                                    $('#searchResultList').append(content);
                                });


                        //页面分页
                        $('#pageIndex').val(data.result.pageIndex);
                        var totalCounts = data.result.totalHits;
                        var pageIndex = data.result.pageIndex;

                        if (totalCounts > 0) {
                            $('#pagination1').jqPaginator({
                                totalCounts: totalCounts,
                                pageSize: 10,
                                visiblePages: 10,
                                currentPage: pageIndex,
                                onPageChange: function (num, type) {
                                    $('#pageIndex').val(num);
                                    if (type == 'change') {
                                        getSearchData();
                                    }
                                }
                            });
                        }else{
                            $("#searchResultList").html("无相关数据");
                            $('#pagination1').empty();
                        }
                    } else {
                        $('#pagination1').empty();
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                },
                error: function (data) {
                    $('#pagination1').empty();
                    console.log("请求异常:" + data);
                    $.toaster("请求异常:" + data, "请求异常", "danger");
                }
            });
        };

        //数字加逗号
        function parseFormatNum(number, n) {
            if (n != 0) {
                n = (n > 0 && n <= 20) ? n : 2;
            }
            number = parseFloat((number + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
            var sub_val = number.split(".")[0].split("").reverse();
            var sub_xs = number.split(".")[1];

            var show_html = "";
            for (i = 0; i < sub_val.length; i++) {
                show_html += sub_val[i] + ((i + 1) % 3 == 0 && (i + 1) != sub_val.length ? "," : "");
            }
            if (n == 0) {
                return show_html.split("").reverse().join("");
            } else {
                return show_html.split("").reverse().join("") + "." + sub_xs;
            }
        }

    });

</script>