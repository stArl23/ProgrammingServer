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
                            <th>评论id</th>
                            <th>用户</th>
                            <th>日期</th>
                            <th>评分</th>
                            <th>内容</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list comments.getContent() as comment>
                        <tr>
                            <td>${comment.id}</td>
                            <td>${comment.user.getNickname()}</td>
                            <td>${comment.date}</td>
                            <td>${comment.rating}</td>
                            <td>${comment.content}</td>
                            <td>
                                <a href="#">删除</a>
                            </td>
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
                        <li><a href="/view/comments/list?page=${page - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..comments.getTotalPages() as index>
                        <#if page+1 == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/view/comments/list?page=${index-1}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if page+1 gte comments.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/view/comments/list?page=${page + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>