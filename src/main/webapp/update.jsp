<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.4.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <!--  隐藏域 提交id-->
        <input type="hidden" name="id" value="${user.id}">

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly="readonly"
                   placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.sex == '男'}">
                <input type="radio" name="sex" value="男" checked/>男
                <input type="radio" name="sex" value="女"/>女
            </c:if>

            <c:if test="${user.sex == '女'}">
                <input type="radio" name="sex" value="男"/>男
                <input type="radio" name="sex" value="女" checked/>女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age" name="age" placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control">
                <c:if test="${user.address == '中国'}">
                    <option value="中国" selected>中国</option>
                    <option value="日本">日本</option>
                    <option value="美国">美国</option>
                    <option value="法国">法国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '日本'}">
                    <option value="中国">中国</option>
                    <option value="日本" selected>日本</option>
                    <option value="美国">美国</option>
                    <option value="法国">法国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '美国'}">
                    <option value="中国">中国</option>
                    <option value="日本">日本</option>
                    <option value="美国" selected>美国</option>
                    <option value="法国">法国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '法国'}">
                    <option value="中国">中国</option>
                    <option value="日本">日本</option>
                    <option value="美国">美国</option>
                    <option value="法国" selected>法国</option>
                    <option value="英国">英国</option>
                </c:if>

                <c:if test="${user.address == '英国'}">
                    <option value="中国">中国</option>
                    <option value="日本">日本</option>
                    <option value="美国">美国</option>
                    <option value="法国">法国</option>
                    <option value="英国" selected>英国</option>
                </c:if>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" value="${user.qq}" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${user.email}" name="email"
                   placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <a class="btn btn-default" href="${pageContext.request.contextPath}/findUserByPageServlet" role="button">返回</a>
        </div>
    </form>
</div>
</body>
</html>