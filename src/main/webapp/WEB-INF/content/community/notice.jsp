<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>公告区</title>
    <jsp:include page="../templates/base-lib.jsp"/>
    <style>
        .headr{
            width:100%;
            height:auto;
            margin:0;
            padding-right: 0px;
            padding-top: 50px;
        }
        .wenzi{
            font-size: 25px;
            font-family: 微软雅黑;
            color: black;

        }
        .img{
            background-image: url('/static/img/community/1.jpg');
            background-size: 100% 100%;
            background-repeat:no-repeat;
            background-attachment:fixed;
        }
        .img1{
            font-family:华文行楷;
            font-size: 58px;;
            background-image: url('/static/img/community/1副本.png');
            width: 533px;
            height: 93px;
            background-repeat:no-repeat;
        }
        .img2 li{
            background-color: white;
            filter: alpha(opacity=50);moz-opacity:0.5;opacity: 0.7;);
        }
    </style>
</head>
<body class="img">
<jsp:include page="../templates/navbar.jsp"/>
<div class="container">

        <p class="img1">剑网三公告区</p>

           <ul class="nav nav-tabs"  role="tablsit" >
               <li role="presentation" class="active"><a class="wenzi" href="#latest" aria-controls="home" role="tab" data-toggle="tab">最新</a></li>
               <li role="presentation"><a class="wenzi" href="#news" aria-controls="profile" role="tab" data-toggle="tab">新闻</a></li>
               <li role="presentation"><a class="wenzi" href="#active" aria-controls="messages" role="tab" data-toggle="tab">活动</a></li>
               <li role="presentation"><a class="wenzi" href="#renew" aria-controls="settings" role="tab" data-toggle="tab">更新</a></li>
           </ul>
    <div class="tab-content">
        <div  role="tabpanel" class="tab-pane active" id="latest">
            <div class="panel-primary">
                <div class="panel-heading">
                    <h3>最新</h3>
                </div>
                <div class="panel-body">
                    <ul class="list-group img2">
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                    </ul>
                </div>
            </div>
            <div align="center">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="news">
            <div class="panel-success">
                    <div class="panel-heading">
                        <h3>新闻</h3>
                    </div>
                    <div class="panel-body">
                        <ul class="list-group img2">
                            <li class="list-group-item">实例2</li>
                            <li class="list-group-item">实例2</li>
                            <li class="list-group-item">实例2</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                            <li class="list-group-item">实例1</li>
                        </ul>
                    </div>
                </div>
            <div align="center">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="active">
            <div class="panel-info">
                <div class="panel-heading">
                    <h3>活动</h3>
                </div>
                <div class="panel-body">
                    <ul class="list-group img2">
                        <li class="list-group-item">实例3</li>
                        <li class="list-group-item">实例3</li>
                        <li class="list-group-item">实例3</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                    </ul>
                </div>
            </div>
            <div align="center">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="renew">
            <div class="panel-danger">
                <div class="panel-heading">
                    <h3>更新</h3>
                </div>
                <div class="panel-body">
                    <ul class="list-group img2">
                        <li class="list-group-item">实例4</li>
                        <li class="list-group-item">实例4</li>
                        <li class="list-group-item">实例4</li>
                        <li class="list-group-item">实例4</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                        <li class="list-group-item">实例1</li>
                    </ul>
                </div>
            </div>
            <div align="center">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
