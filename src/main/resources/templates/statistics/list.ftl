<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
    <#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>记录id</th>
                            <th>用户id</th>
                            <th>问题id</th>
                            <th>创建时间</th>
                            <th>用户答案</th>
                            <th>满分</th>
                            <th>实际分数</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list statisticses.getContent() as statistics>
                        <tr>
                            <td>${statistics.id}</td>
                            <td>${(statistics.UId)}</td>
                            <td>${statistics.QId}</td>
                            <td>${statistics.createTime}</td>
                            <td>${statistics.answers}</td>
                            <td>${statistics.totalMarks}</td>
                            <td>${statistics.currentMarks}</td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if page lte 0>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/view/statisticses/list?page=${page - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..statisticses.getTotalPages() as index>
                        <#if page+1 == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/view/statisticses/list?page=${index-1}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if page+1 gte statisticses.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/view/statisticses/list?page=${page + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>