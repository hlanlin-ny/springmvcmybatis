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

<!-- 本页面用到的js -->
<script type="text/javascript">

    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });


    $().ready(function () {

        $("#li_tab_1").on("click", function () {
            $("#datasourceType").val("1");
        });

        $("#li_tab_2").on("click", function () {
            $("#datasourceType").val("2");
        });

        $("#li_tab_3").on("click", function () {
            $("#datasourceType").val("3");
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

        //加载搜索历史
        $.get("${ctxPath}/admin/searchlog/querySearchHistory", function (data) {
            $.each(data.result,
                function (index, value) {
                    $('#search-history-ul').append("<li><a href='${ctxPath}/admin/search/searchresult.html?d=" + value['datasourceType'] + '&k=' + encodeURI(encodeURI(value['keyword'])) + "&p=1'>" + value['keyword'] + "</a></li>");
                });
        });

        //加载推荐信息
        $.get("${ctxPath}/admin/search/queryRecommendSearchResult", function (data) {
            var content = "<tr><th>类型</th><th>姓名1</th><th>身份证号1</th><th>地点1</th><th>时间</th><th>姓名2</th><th>身份证号2</th><th>地点2</th><th width='30%'>详细内容</th></tr>";
            $('#recommend-search-result-list').append(content);
            if(data.result && data.result.hitDatas){
                $.each(data.result.hitDatas,
                    function (index, value) {
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

                        $('#recommend-search-result-list').append(content);
                    });
            }
        });

        //加载常用工具
        $.get("${ctxPath}/admin/commontool/queryAllByAreaId", function (data) {
            $.each(data.result,
                function (index, value) {
                    $('#common-tool-ul').append("<li><a href='" + value['url'] + "' target='_blank'>" + value['name'] + "</a></li>");
                });
        });

        //加载搜索热词
        $.get("${ctxPath}/admin/searchlog/queryHotSearchList", function (data) {
            $.each(data.result,
                function (index, value) {
                    $('#hot-search-ul').append("<li><a href='${ctxPath}/admin/search/searchresult.html?d=" + value['datasourceType'] + '&k=' + encodeURI(encodeURI(value['keyword'])) + "&p=1'>" + value['keyword'] + "</a></li>");
                });
        });

    });

</script>