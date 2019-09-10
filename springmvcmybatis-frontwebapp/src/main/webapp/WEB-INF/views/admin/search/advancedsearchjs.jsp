<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/basejs.jsp" %>
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

    var ztree;

    $().ready(function () {

        $("#keyword1").typeahead({
            source: function (query, process) {
                //query是输入的值
                $.get("${ctxPath}/admin/search/querySearchSuggestion?k=" + query, function (data) {
                    var array = [];
                    $.each(data.result,
                            function (index, value) {
                                array.push(value);
                            });
                    process(array);
                });
            },
            items: 20,
            afterSelect: function (item) {
//                console.log(name2Id[item]);//打印对应的id
            },
            delay: 500
        });

        $("#keyword2").typeahead({
            source: function (query, process) {
                //query是输入的值
                $.get("${ctxPath}/admin/search/querySearchSuggestion?k=" + query, function (data) {
                    var array = [];
                    $.each(data.result,
                            function (index, value) {
                                array.push(value);
                            });
                    process(array);
                });
            },
            items: 20,
            afterSelect: function (item) {
//                console.log(name2Id[item]);//打印对应的id
            },
            delay: 500
        });

        $("#keyword3").typeahead({
            source: function (query, process) {
                //query是输入的值
                $.get("${ctxPath}/admin/search/querySearchSuggestion?k=" + query, function (data) {
                    var array = [];
                    $.each(data.result,
                            function (index, value) {
                                array.push(value);
                            });
                    process(array);
                });
            },
            items: 20,
            afterSelect: function (item) {
//                console.log(name2Id[item]);//打印对应的id
            },
            delay: 500
        });


        //Date range picker
        $('#reservation').daterangepicker(
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
        $("#reservation").on('hide.daterangepicker', function (ev, picker) {
            $('#startTime').val(picker.startDate.format('YYYY-MM-DD'));
            $('#endTime').val(picker.endDate.format('YYYY-MM-DD'));
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
        });

        $("#keyword1").focus();

        //重置
        $("#btn-reset").on("click", function () {
            $("#keyword1").val("");
            $("#keyword2").val("");
            $("#keyword3").val("");
            $("#reservation").val("");
            $("#startTime").val("");
            $("#endTime").val("");
            $("#datasourceType").val("1");
            $("#pageIndex").val("1");
            $("#pageSize").val("10");
            $("input[name='fileType']:checkbox").iCheck("uncheck");
            $("input[name='preciseQuery']:checkbox").iCheck("uncheck");

            ztree.checkAllNodes(false);
            $("#searchResultList").html("");
            $("#totalHits").html("");
            $('#pagination1').empty();
        });

        //查询按钮
        $("#btn-search").on("click", function () {
            getSearchData();
            return false;
        });

        function getSearchData() {
            var keyword = "";
            //关键字
            var keyword1 = $("#keyword1").val();
            keyword = keyword + keyword1;
            var keyword2 = $("#keyword2").val();
            if (keyword2.length > 0) {
                keyword = keyword + ",";
                var arr = keyword2.split(" ");
                for (var i = 0; i < arr.length; i++) {
                    keyword = keyword + " |" + arr[i];
                }
            }
            var keyword3 = $("#keyword3").val();
            if (keyword3.length > 0) {
                keyword = keyword + ",";
                var arr = keyword3.split(" ");
                for (var i = 0; i < arr.length; i++) {
                    keyword = keyword + " -" + arr[i];
                }
            }
            $("#keyword").val(keyword);

            if (keyword.length < 1) {
                return false;
            }

            //获取选择的情报分类
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
            //获取文件类型
            var fileTypes = new Array();
            $("input[name='fileType']:checkbox").each(function () {
                if (true == $(this).is(":checked")) {
                    fileTypes.push($(this).val());
                }
            });
            console.log(fileTypes);
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
            data = JSON.stringify(data);
            $.ajax({
                cache: false,
                type: "POST",
                url: "${ctxPath}/admin/search/querySearchResult",
                data: data,
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    console.log(data);
                    if (data.code == 0) {
                        $('#searchResultList').html("");
                        var content = "<tr><th>类型</th><th>姓名1</th><th>身份证号1</th><th>地点1</th><th>时间</th><th>姓名2</th><th>身份证号2</th><th>地点2</th><th width='30%'>详细内容</th></tr>";
                        $('#searchResultList').append(content);
                        $("#totalHits").html("相关结果约" + parseFormatNum(data.result.totalHits, 0) + "条");
                        $.each(data.result.hitDatas,
                                function (index, value) {
                                    var content = "";
//                                if ($("#datasourceType").val() == "2") {

                                    if (value['fileType'] == "8") {
                                        content = "<tr><td colspan=\"9\"><dl><dt><a href='" + value['url'] + "' target='_blank'>" + value['name1'] + "</a><dt/>";
                                        content += "<dd><a href='" + value['url'] + "' target='_blank'>" + "<img src='" + value['url'] + "' height='150px' style='margin:5px'></a><dd/> ";
                                        content += "<dd>" + value['content'] + " <dd/> ";
                                        content += "<small class='pull-right'>更新时间：" + value['collectTime'] + "&nbsp;&nbsp;业务类型：" + value['businessTypeName'] + "&nbsp;&nbsp;&nbsp;&nbsp;行政区划：" + value['areaName'] + "&nbsp;</small></dl></td></tr>";
                                    } else if (value['fileType'] == "9") {
                                        content = "<tr><td colspan=\"9\"><dl><dt><a href='" + value['url'] + "' target='_blank'>" + value['name1'] + "</a><dt/>";
                                        content += "<dd><audio controls style='width: 100%'><source src='" + value['url'] + "' type='audio/mpeg'></audio><dd/> ";
                                        content += "<dd>" + value['content'] + " <dd/> ";
                                        content += "<small class='pull-right'>更新时间：" + value['collectTime'] + "&nbsp;&nbsp;业务类型：" + value['businessTypeName'] + "&nbsp;&nbsp;&nbsp;&nbsp;行政区划：" + value['areaName'] + "&nbsp;</small></dl></td></tr>";
                                    } else if (value['fileType'] == "10") {
                                        content = "<tr><td colspan=\"9\"><dl><dt><a href='" + value['url'] + "' target='_blank'>" + value['name1'] + "</a><dt/>";
                                        content += "<dd><video width='320' height='240' controls><source src='" + value['url'] + "' type='video/mp4'></video><dd/> ";
                                        content += "<dd>" + value['content'] + " <dd/> ";
                                        content += "<small class='pull-right'>更新时间：" + value['collectTime'] + "&nbsp;&nbsp;业务类型：" + value['businessTypeName'] + "&nbsp;&nbsp;&nbsp;&nbsp;行政区划：" + value['areaName'] + "&nbsp;</small></dl></td></tr>";
                                    } else {
                                        content = "<tr><td>" + value['businessTypeName'] + "</td><td><a href='" + value['url'] + "' target='_blank'>" + value['name1'] + "</a></td><td>" + value['idCardNum1'] + "</td><td>" + value['location1'] + "</td><td>" + value['dtTime'] + "</td><td>" + value['name2'] + "</td><td>" + value['idCardNum2'] + "</td><td>" + value['location2'] + "</td><td>" + value['content'] + "</td></tr>";
                                    }

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