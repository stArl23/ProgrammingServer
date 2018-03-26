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
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>课名</label>
                            <input name="name" type="text" class="form-control"
                                   value="${(productInfo.productName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>课程内容</label>
                            <input name="content" type="text" class="form-control"
                                   value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>课程描述</label>
                            <input name="description" type="text" class="form-control"
                                   value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <option selected="selected">python</option>
                                <option>javascript</option>
                                <option>blockly</option>
                            </select>
                        </div>
                        <input hidden type="text" name="id">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>