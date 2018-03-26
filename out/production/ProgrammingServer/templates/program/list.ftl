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
                            <th>作品id</th>
                            <th>标题</th>
                            <th>作者</th>
                            <th>内容</th>
                            <th>类目</th>
                            <th>是否下架</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list programs.getContent() as program>
                        <tr>
                            <td>${program.id}</td>
                            <td>${program.title}</td>
                            <td>${program.author}</td>
                            <td>${program.content}</td>
                            <td>${program.categoryName}</td>
                            <td><#if program.deleted>
                                解除冻结
                            <#else>
                                    冻结
                            </#if>
                            </td>
                            <td>
                                <#if program.deleted>
                                    <a href="#">解除冻结</a>
                                <#else>
                                    <a href="#">冻结</a>
                                </#if>
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
                        <li><a href="/view/programs/list?page=${page - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..programs.getTotalPages() as index>
                        <#if page+1 == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/view/programs/list?page=${index-1}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if page+1 gte programs.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/view/programs/list?page=${page + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>