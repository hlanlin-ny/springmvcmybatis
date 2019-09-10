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
<%-- jqPaginator --%>
<script src="${ctxPath}/resources/plugins/jqPaginator/jqPaginator.min.js"></script>
<%-- bootstrap3 typeahead --%>
<script src="${ctxPath}/resources/plugins/typeahead/bootstrap3-typeahead.min.js"></script>

<!-- 本页面用到的js -->
<script type="text/javascript">
    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });

    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]);
        return ""; //返回参数值
    }

    function getSearchData() {
        console.log();
        $.ajax({
            cache: false,
            type: "POST",
            url: "${ctxPath}/admin/search/querySearchResult",
            data: $("#dataSearchForm").serializeJSON(),
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
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
                    }

                    if ($("#pageIndex").val() == "1") {
                        querySearchHistory();
                        queryRelatedSearchHistory();
                    }

                } else {
                    console.log("服务异常:" + data);
                    $.toaster("异常信息:" + data.message, "服务异常", "danger");
                }
            },
            error: function (data) {
                console.log("请求异常:" + data);
                $.toaster("请求异常:" + data, "请求异常", "danger");
            }
        });
    }

    function getSearchDataTimeline() {
        $.ajax({
            cache: false,
            type: "POST",
            url: "${ctxPath}/admin/search/querySearchResultTimeline",
            data: $("#dataSearchForm").serializeJSON(),
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                console.log(data);
                if (data.code == 0) {
                    $('#searchResultList').html("");
                    $("#totalHits").html("相关结果约" + parseFormatNum(data.result.totalHits, 0) + "条");
                    $.each(data.result.commonIndexDates,
                            function (index, value) {
                                var content = "<ul class='timeline'>";
                                content += "<li class='time-label'><span class='"+value['dateBackgroundColor']+"'>";
                                content += value['date'];
                                content += "</span></li>";

                                $.each(value['hitDatas'],
                                        function (index2, value2) {
                                            content += "<li><i class='"+value2['timelineItemIconClass']+"'></i><div class='timeline-item'>";
                                            content += "<span class='time'><i class='fa fa-clock-o'></i> ";
                                            content += value2['createdTime'].substring(10, 19);
                                            content += "</span>";
                                            content += "<h3 class='timeline-header'><a href='" + value2['url'] + "' target='_blank'>" + value2['name1'] + "</a></h3>";
                                            content += "<div class='timeline-body'>" + value2['content'] + "</div>";
                                            content += "</div></li>";
                                        });

                                content += "</ul>";

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
                                    getSearchDataTimeline();
                                }
                            }
                        });
                    }

                    if ($("#pageIndex").val() == "1") {
                        querySearchHistory();
                        queryRelatedSearchHistory();
                    }

                } else {
                    console.log("服务异常:" + data);
                    $.toaster("异常信息:" + data.message, "服务异常", "danger");
                }
            },
            error: function (data) {
                console.log("请求异常:" + data);
                $.toaster("请求异常:" + data, "请求异常", "danger");
            }
        });
    }

    function querySearchHistory() {
        //加载搜索历史
        $.get("${ctxPath}/admin/searchlog/querySearchHistory", function (data) {
            $('#search-history-ul').html("");
            $.each(data.result,
                    function (index, value) {
                        $('#search-history-ul').append("<li><a href='${ctxPath}/admin/search/searchresult.html?d=" + value['datasourceType'] + '&k=' + encodeURI(encodeURI(value['keyword'])) + "&p=1'>" + value['keyword'] + "</a></li>");
                    });
        });
    }

    function queryRelatedSearchHistory() {
        //加载相关搜索历史
        $.get("${ctxPath}/admin/searchlog/queryRelatedSearchHistory?k=" + $("#keyword").val(), function (data) {
            $('#related-search-history-ul').html("");
            $.each(data.result,
                    function (index, value) {
                        $('#related-search-history-ul').append("<li><a href='${ctxPath}/admin/search/searchresult.html?d=" + value['datasourceType'] + '&k=' + encodeURI(encodeURI(value['keyword'])) + "&p=1' target='_blank'>" + value['keyword'] + "</a></li>");
                    });
        });
    }

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

    function checkAndGetSearchData() {
        if ($("#keyword").val() == "") {
            $("#keyword").focus();
            return false;
        } else {
            getSearchData();
        }
    }

    function firstGetSearchData() {
        if ($("#keyword").val() == "") {
            $("#keyword").focus();
            return false;
        } else {
            getSearchData();
            querySearchHistory();
            queryRelatedSearchHistory();
        }
    }

    function firstGetSearchDataTimeline() {
        if ($("#keyword").val() == "") {
            $("#keyword").focus();
            return false;
        } else {
            getSearchDataTimeline();
            querySearchHistory();
            queryRelatedSearchHistory();
        }
    }


    $().ready(function () {
        $("#datasourceType").val(getUrlParam("d"));
        $("#pageIndex").val(getUrlParam("p"));
        $("#intelligenceBusinessTypeId").val(getUrlParam("i"));
        $("#keyword").val(decodeURI(getUrlParam("k")));
        $("#fileType").val(getUrlParam("t"));
        $("#preciseQuery").val(getUrlParam("pq"));

        $("#li_tab_1").removeClass("active");
        $("#li_tab_2").removeClass("active");
        $("#li_tab_3").removeClass("active");
        var d = getUrlParam("d");

        if (d == "1") {
            $("#li_tab_1").addClass("active");
            $("#div-export").hide();
            $("#keyword").focus();
        } else if (d == "2") {
            $("#li_tab_2").addClass("active");
            $("#div-export").show();
            $("#keyword").focus();
        } else {
            $("#li_tab_3").addClass("active");
            $("#div-export").hide();
            $("#keyword").focus();
        }

        $("#li_tab_1").on("click", function () {
            $("#datasourceType").val("1");
            $("#div-export").hide();
            checkAndGetSearchData();
        });

        $("#li_tab_2").on("click", function () {
            $("#datasourceType").val("2");
            $("#div-export").show();
            checkAndGetSearchData();
        });

        $("#li_tab_3").on("click", function () {
            $("#datasourceType").val("3");
            $("#div-export").hide();
            checkAndGetSearchData();
        });

        firstGetSearchData();

        $("#btn-submit-search").on("click", function () {
            firstGetSearchData();
            return false;
        });

        $("#keyword").bind('keydown', function (event) {
            if (event.keyCode == "13") {
                firstGetSearchData();
            }
        });

        $("#keyword").typeahead({
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

        $("#cb_precise_query").on("click", function () {
            if ($('#cb_precise_query').prop('checked')) {
                $("#preciseQuery").val("true");
            } else {
                $("#preciseQuery").val("false");
            }
            checkAndGetSearchData();
        });

        $("#btn-export").on("click", function () {
            //生成文件
            $.ajax({
                cache: false,
                type: "POST",
                url: "${ctxPath}/admin/search/genQuerySearchResult",
                data: $("#dataSearchForm").serializeJSON(),
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.code == 0) {
                        //下载文件
                        var fileName = data.result;
                        var url = "${ctxPath}/admin/search/exprotQuerySearchResult";
                        var form = $("<form></form>").attr("action", url).attr("method", "post");
                        form.append($("<input/>").attr("name", "fileName").attr("value", fileName));
                        form.appendTo('body').submit().remove();
                    } else {
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                },
                error: function (data) {
                    console.log("请求异常:" + data);
                    $.toaster("请求异常:" + data, "请求异常", "danger");
                }
            });
        });

        $("#btn-searchresult-list").on("click", function () {
            getSearchData();
        });

        $("#btn-searchresult-timeline").on("click", function () {
            getSearchDataTimeline();
        });

    });
</script>