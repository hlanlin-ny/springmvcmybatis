<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- tableExport --%>
<script src="${ctxPath}/resources/plugins/tableExport/tableExport.js"></script>
<script src="${ctxPath}/resources/plugins/tableExport/jquery.base64.js"></script>
<script src="${ctxPath}/resources/plugins/tableExport/jspdf/libs/sprintf.js"></script>
<script src="${ctxPath}/resources/plugins/tableExport/jspdf/jspdf.js"></script>
<script src="${ctxPath}/resources/plugins/tableExport/jspdf/libs/base64.js"></script>
<script src="${ctxPath}/resources/plugins/tableExport/html2canvas.js"></script>

<script type="text/javascript">

    function exportTable(fileType) {
        var tableColumnCount = $("#data-table").find("tr").find("td").length;
        var lastColumnIndex = tableColumnCount / 10 - 1;
        $('#data-table').tableExport({
            type: fileType,
            escape: 'false'
//            ,
//            ignoreColumn: [0, lastColumnIndex]
        });
    }

    $().ready(function () {

        $("#btn-export").on("click", function () {
            exportTable("excel");
        });

//        $("#btn-export-excel").on("click", function () {
//            exportTable("excel");
//        });
//
//        $("#btn-export-pdf").on("click", function () {
//            exportTable("pdf");
//        });

//        $("#btn-export-png").on("click", function () {
//            exportTable("png");
//        });
//
//        $("#btn-export-word").on("click", function () {
//            exportTable("doc");
//        });
//
//        $("#btn-export-powerpoint").on("click", function () {
//            exportTable("powerpoint");
//        });
//
//        $("#btn-export-csv").on("click", function () {
//            exportTable("csv");
//        });
//
//        $("#btn-export-txt").on("click", function () {
//            exportTable("txt");
//        });
    });
</script>