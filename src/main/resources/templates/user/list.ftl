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
                            <th>用户id</th>
                            <th>用户账户名</th>
                            <th>用户描述</th>
                            <th>用户昵称</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list users.getContent() as user>
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.description}</td>
                            <td>${user.nickname}</td>
                            <td>
                                <a href="#">冻结</a>
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
                        <li><a href="/view/users/list?page=${page - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..users.getTotalPages() as index>
                        <#if page+1 == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/view/users/list?page=${index-1}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if page+1 gte users.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/view/users/list?page=${page + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>