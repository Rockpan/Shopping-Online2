<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>购物车 | 炉边商城 |</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- 引入 Bootstrap -->
		<link href="<%=basePath%>resource/css/bootstrap.min.css"
			rel="stylesheet">
			<script src="<%=basePath%>resource/js/jquery.min.js"></script>
			<script src="<%=basePath%>resource/js/bootstrap.js"></script>
			<script src="<%=basePath%>resource/js/bootstrap.min.js"></script>
			<script type="text/javascript" src="<%=basePath%>resource/js/etao.js"></script>
			<script type="text/javascript" src="<%=basePath%>resource/js/cart.js"></script>
			<link href="<%=basePath%>resource/css/cart.css" media="screen"
				rel="stylesheet" type="text/css" />
			<title>购物车</title>
</head>
<body>
	<!-- <script type="text/javascript">
		function click() {
			var names = document.getElementById('checkboxid');
			//alert("names.length:"+names.value.length);
			 for(var i = 0;names.value.length;i++){
				if (document.getElementById("checkboxid").checked) {
					var a = names[i].value;
				}

			}
			alert(a);
			//window.location.href='http://localhost:8080/s_and_m/CarsBalance?id='+a;
		}
	</script> -->
	
	<div class="container-fluid">
		<div class="well well-sm" style="height: 5%;">
			<div class="row">
				<div class="col-md-8">
					<ul class="nav nav-pills">
						<li><a class="text-muted none-padding-top" href="index.html">欢迎来到炉边电子商城</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul class="nav nav-pills">
						<li><a class="text-muted none-padding-top" href="login.html">[请登录]</a></li>
						<li><a class="text-muted none-padding-top"
							href="register.html">[免费注册]</a></li>
						<li><a class="text-muted none-padding-top" href="#">我的购物车</a></li>
						<li><a class="text-muted none-padding-top" href="#">我的订单</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<form action="${path}/s_and_m/CarsBalance " method="get" id="carForm">
		<div class="container">
			<h2 style="font-weight: 700; margin-bottom: 30px;">购物车</h2>
			<div class="cart-wrap">
				<table id="cartTable" class="cart table table-condensed">
					<thead>
						<tr>
							<th style="width: 60px;"><label><input
									class="check-all check" type="checkbox" /></label></th>
							<th><label>商品</label></th>
							<th style="width: 100px;"><label>单价</label></th>
							<th style="width: 120px;"><label>数量</label></th>
							<th style="width: 100px;"><label>小计</label></th>
							<th style="width: 40px;"><label>操作</label></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${car}" var="cars" varStatus="status">
							<tr>
								<td><input class="check-one check" type="checkbox"
									id="carid" name="carid" value="${cars.id}"/></td>
								<td class="goods"><a href="#">${cars.name}</a></td>
								<td class="selling-price number" data-bind="${cars.price}">${cars.price}</td>
								<td>
									<div class="input-group input-group-sm">
										<span class="input-group-addon minus">-</span> <input
											type="text" class="number form-control input-sm"
											value="${cars.count}" /> <span
											class="input-group-addon plus">+</span>
									</div>
								</td>
								<td class="subtotal number "></td>
								<td class="operation"><span class="delete" id="delete"><a
										href="${path}/s_and_m/${cars.id}/CarsDelete"
										class="btn btn-xs btn-primary">删除</a></span></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

				<div class="row">
					<div class="col-md-12 col-lg-12 col-sm-12">
						<div class="cart-summary"
							style="border-top: 1px solid gray; padding: 4px 10px;">
							<div style="margin-left: 2rem;" class="pull-right">
								<!-- <a id="btn_settlement" type="button" href="javascript:click()"
									class="btn btn-primary">去结算</a> -->
								<input id="btn_settlement" class="btn btn-primary" type="submit" value="结算" disabled="disabled"/>
							</div>
							<div style="margin-left: 1rem; margin-top: 0.4rem;"
								class="pull-right total">
								<label>金额合计:<span class="currency">￥</span><span
									id="priceTotal" class="price-total ">0.00</span></label>
							</div>
							<div style="margin-top: 4px;" class="pull-right">
								<label>已选商品<span id="qtyCount" style="margin: 0 4px;"></span>件
								</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div></form>
		<div class="footer">
			<div class="row center-block" style="margin-left: 4%;">
				<dl class="pull-left">
					<dt>新手指南</dt>
					<dd>注册登录</dd>
					<dd>选购商品</dd>
					<dd>订单支付</dd>
					<dd>收货退款</dd>
				</dl>
				<dl class="pull-left">
					<dt>售后服务</dt>
					<dd>退换货政策</dd>
					<dd>退换货流程</dd>
					<dd>退款方式</dd>
					<dd>投诉建议</dd>
				</dl>
				<dl class="pull-left">
					<dt>商家支持</dt>
					<dd>商家入驻</dd>
					<dd>商家规则</dd>
					<dd>物流查询</dd>
					<dd>帮助中心</dd>
				</dl>
				<dl class="pull-left">
					<dt id="ss" value="sd">炉边商城</dt>
					<dd>关于我们</dd>
					<dd>联系我们</dd>
					<dd>加入我们</dd>
					<dd>用户反馈</dd>
				</dl>
			</div>
			<div class="center-block" style="margin-top: 50px;">
				<p class="text-center">版权所有 © 2013-2017 炉边电子商城有限公司</p>
				<br> <br>
			</div>
		</div>
	</div>
	
</body>
</html>