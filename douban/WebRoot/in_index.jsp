<%@ page language="java" import="java.util.*,com.neu.cxl.Entity.User" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${movielist==null}">
<c:redirect url="SelectMovieByReviewServlet"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="description" content="Magz is a HTML5 & CSS3 magazine template is based on Bootstrap 3.">
		
		<meta name="keyword" content="magz, html5, css3, template, magazine template">
		
		<title>Magz &mdash; Responsive HTML5 &amp; CSS3 Magazine Template</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
		<link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<!-- IonIcons -->
		<link rel="stylesheet" href="scripts/ionicons/css/ionicons.min.css">
		<!-- Toast -->
		<link rel="stylesheet" href="scripts/toast/jquery.toast.min.css">
		<!-- OwlCarousel -->
		<link rel="stylesheet" href="scripts/owlcarousel/dist/assets/owl.carousel.min.css">
		<link rel="stylesheet" href="scripts/owlcarousel/dist/assets/owl.theme.default.min.css">
		<!-- Magnific Popup -->
		<link rel="stylesheet" href="scripts/magnific-popup/dist/magnific-popup.css">
		<link rel="stylesheet" href="scripts/sweetalert/dist/sweetalert.css">
		<!-- Custom style -->
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/skins/all.css">
		<link rel="stylesheet" href="css/demo.css">
	</head>

<style>
.new1{
	position: absolute;
	top: 269px;
	left: 1000px;
	
}	

</style>

<script>
function show(){

var session="<%=session.getAttribute("username")%>"
//alert(session)
if(session=="null")
{
	document.getElementById("div_user").innerHTML="<div  class='col-md-3 col-sm-12 text-right'><ul class='nav-icons'><li><a href='register.html'><i class='ion-person-add'></i> <div> 注册</div></a></li><li><a href='login.html'><i class='ion-person'></i><div>登录</div></a></li></ul></div>"
	document.getElementById("li_user").style.display="none"
}
else
{
	document.getElementById("div_user").innerHTML="<div  class='col-md-3 col-sm-12 text-right'><ul class='nav-icons'><li><img class='img-circle' src='images/img01.jpg' width='45px'/></li><li><a href='single.jsp'><div>${sessionScope.user.getUserName()}</div></a></li></ul></div>"
}

}
</script>
	<body onload="show()" class="skin-orange">
		<header class="primary">
			<div class="firstbar">
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-sm-12">
							<div class="brand">
								<a href="in_index.jsp">
									<img src="images/logo.png" alt="Magz Logo">
								</a>
							</div>						
						</div>
						<div class="col-md-6 col-sm-12">
							
								<form class="search" autocomplete="off" action="SelectMovieServletByUser">
							
								<div class="form-group">
									<div class="input-group">
										<input type="text" name="keyword" class="form-control" placeholder="输入电影">									
										<div class="input-group-btn">
										<button  class="btn btn-primary" ><i class="ion-search"></i></button>
										</div>
									
									</div>
								</div>
							
								<div class="help-block">
								<input type="radio" name="type" value="moviename" checked="checked">按名称
								<input type="radio" name="type" value="movieyear" >按年份
								<input type="radio" name="type" value="avgscore" >按评分
								<input type="radio" name="type" value="movieactorid" >按演员
								<input type="radio" name="type" value="movietype" >按类型
							
								<!--  	<div>热门:</div>
									<ul>
										<li><a href="#">侏罗纪世界2</a></li>
										<li><a href="#">我不是药神</a></li>
										<li><a href="#">邪不压正</a></li>
										<li><a href="#">犬之岛</a></li>
										<li><a href="#">摩天营救</a></li>
									</ul>-->
								</div>
							</form>											
						</div>
						<div id="div_user" >
						
						
						
						</div>
						
					</div>
				</div>
			</div>

		<!-- Start nav -->
			<nav class="menu">
				<div class="container">
					<div class="brand">
						<a href="#">
							<img src="images/logo.png" alt="Magz Logo">
						</a>
					</div>
					<div class="mobile-toggle">
						<a href="#" data-toggle="menu" data-target="#menu-list"><i class="ion-navicon-round"></i></a>
					</div>
					<div class="mobile-toggle">
						<a href="#" data-toggle="sidebar" data-target="#sidebar"><i class="ion-ios-arrow-left"></i></a>
					</div>
					<div id="menu-list">
						<ul class="nav-list">
							<li class="for-tablet nav-title"><a>Menu</a></li>
							<li class="for-tablet"><a href="login.html">Login</a></li>
							<li class="for-tablet"><a href="register.html">Register</a></li>
							
							<li class="dropdown magz-dropdown">
								<a href="in_index.jsp">主页 </a>
								<ul class="dropdown-menu">
								
									<li><a href="in_index.jsp">主页</a></li>
									<li><a href="moviesearch.jsp">电影</a></li>
									
								
									<li><a href="#">更多</a></li>
									
								</ul>
							</li>
							<li class="dropdown magz-dropdown"><a href="#">关于抽象
							</a>
								<ul class="dropdown-menu">
									<li><a href="category.html">加入我们</a></li>
									<li class="dropdown magz-dropdown"><a href="category.html">公司部门 <i class="ion-ios-arrow-right"></i></a>
										<ul class="dropdown-menu">
											<li><a href="category.html">市场部</a></li>
											<li class="dropdown magz-dropdown"><a href="category.html">事业部 <i class="ion-ios-arrow-right"></i></a>
												<ul class="dropdown-menu">
													<li><a href="category.html">抽象影业</a></li>
													<li><a href="category.html">抽象传媒</a></li>
													<li><a href="category.html">抽象娱乐</a></li>
												</ul>
											</li>
											<li><a href="category.html">财务部</a>
										</ul>
									</li>
									<li><a href="category.html">抽象周报</a></li>
									
								</ul>
							</li>
							<li class="dropdown magz-dropdown magz-dropdown-megamenu"><a href="#">热门电影  </a>
								<div class="dropdown-menu megamenu">
									<div class="megamenu-inner">
										<div class="row">
											<a href="www.baidu.com"><div class="col-md-3">
												<div class="row">
													<div class="col-md-12">
														<h2 class="megamenu-title">电影分类</h2>
													</div>
												</div>
												<ul class="vertical-menu">
													<li><a href="SelectMovieServletByUser?type=avgscore&keyword=9"><i class="ion-ios-circle-outline"></i> 高分电影</a></li>
													<li><a href="#"><i class="ion-ios-circle-outline"></i> 热门影评</a></li>
													
													<li><a href="#"><i class="ion-ios-circle-outline"></i> 正在上映</a></li>
													
												</ul>
											</div></a>
											<div class="col-md-9">
												<div class="row">
													<div class="col-md-12">
														<h2 class="megamenu-title">热门电影</h2>
													</div>
												</div>
												<div class="row">
													<article class="article col-md-4 mini">
														<div class="inner">
															<figure>
																<a href="single.html">
																	<img src="images/yao.jpg" alt="Sample Article">
																</a>
															</figure>
															<div class="padding">
																<div class="detail">
																	<div class="time">December 10, 2018</div>
																	<div class="category"><a href="category.html">了解详情</a></div>
																</div>
																<h2><a href="single.html">我不是药神</a></h2>
															</div>
														</div>
													</article>
													<article class="article col-md-4 mini">
														<div class="inner">
															<figure>
																<a href="single.html">
																	<img src="images/ran.jpg" alt="Sample Article">
																</a>
															</figure>
															<div class="padding">
																<div class="detail">
																	<div class="time">December 11, 1996</div>
																	<div class="category"><a href="category.html">了解详情</a></div>
																</div>
																<h2><a href="moviepage.html">燃烧烈爱</a></h2>
															</div>
														</div>
													</article>
													<article class="article col-md-4 mini">
														<div class="inner">
															<figure>
																<a href="single.html">
																	<img src="images/yourname.jpg" alt="Sample Article"ur>
																</a>
															</figure>
															<div class="padding">
																<div class="detail">
																	<div class="time">June 14, 2016</div>
																	<div class="category"><a href="category.html">了解详情</a></div>
																</div>
																<h2><a href="single.html">你的名字</a></h2>
															</div>
														</div>
													</article>
												</div>
											</div>
										</div>								
									</div>
								</div>
							</li>
							
							<li id="li_user" class="dropdown magz-dropdown"><a href="#">个人中心 <i class="ion-ios-arrow-right"></i></a>
								<ul class="dropdown-menu">
									<li><a href="single.jsp"><i class="icon ion-person"></i>我的主页</a></li>
									
									<li><a href="single.jsp"><i class="icon ion-chatbox"></i> 我的评论</a></li>				
									<li><a href="passwordchange.html"><i class="icon ion-chatbox"></i> 重置密码</a></li>		
									<li><a href="RemoveServlet"><i class="icon ion-log-out"></i> 注销</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- End nav -->
		</header>

		<section class="home">
		
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-sm-12 col-xs-12">
						<div class="headline">
							<div class="nav" id="headline-nav">
								<a class="left carousel-control" role="button" data-slide="prev">
									<span class="ion-ios-arrow-left" aria-hidden="true"></span>
									<span class="sr-only">Previous</span>
								</a>
								<a class="right carousel-control" role="button" data-slide="next">
									<span class="ion-ios-arrow-right" aria-hidden="true"></span>
									<span class="sr-only">Next</span>
								</a>
							</div>
							<div class="owl-carousel owl-theme" id="headline">							
								<div class="item">
									<a href="#"><div class="badge">新闻</div>抽象电影网美国达克斯上市</a>
								</div>
								<div class="item">
									<a href="#"><div class="badge">动态</div>抽象掌门人任龙飞退出董事会</a>
								</div>
							</div>
						</div>
						<div class="owl-carousel owl-theme slide" id="featured">
							<div class="item">
								<article class="featured">
									<div class="overlay"></div>
									
									<figure>
									<img src="images/news/img04.jpg" alt="Sample Article">
									</figure>
									
									<div class="details">
										<div class="category"><a href="category.html">了解更多</a></div>
										<h1><a href="SelectMoviePageServlet?movieid=241">我不是药神大卖，票房接近30亿</a></h1>
										<div class="time">2018 7 8</div>
									</div>
								</article>
							</div>
							<div class="item">
								<article class="featured">
									<div class="overlay"></div>
									<figure>
										<img src="images/news/img14.jpg" alt="Sample Article">
									</figure>
									<div class="details">
										<div class="category"><a href="category.html">Travel</a></div>
										<h1><a href="single.jsp">Class aptent taciti sociosqu ad litora torquent per conubia nostra</a></h1>
										<div class="time">December 10, 2016</div>
									</div>
								</article>
							</div>
							<div class="item">
								<article class="featured">
									<div class="overlay"></div>
									<figure>
										<img src="images/news/img13.jpg" alt="Sample Article">
									</figure>
									<div class="details">
										<div class="category"><a href="category.html">International</a></div>
										<h1><a href="single.jsp">Maecenas accumsan tortor ut velit pharetra mollis</a></h1>
										<div class="time">October 12, 2016</div>
									</div>
								</article>
							</div>
							<div class="item">
								<article class="featured">
									<div class="overlay"></div>
									<figure>
										<img src="images/news/img05.jpg" alt="Sample Article">
									</figure>
									<div class="details">
										<div class="category"><a href="category.html">Lifestyle</a></div>
										<h1><a href="single.jsp">Mauris elementum libero at pharetra auctor Fusce ullamcorper elit</a></h1>
										<div class="time">November 27, 2016</div>
									</div>
								</article>
							</div>
						</div>
						
							
								
							</div>
						</div>
						
						
			
				
						<div class="new1">
								<h1 class="title-col">热度排行榜</h1>
								<div class="body-col">
									<ol class="tags-list">
									<c:forEach var="m" items="${requestScope.movielist}" varStatus="status">
  		 
  		 						<li><a href="SelectMoviePageServlet?movieid=${m.getMovieId()}">${m.getMovieName()}</a></li>

  								 </c:forEach>
										
									</ol>
								</div>
							</div>
									<div class="new1">
						
						
						
						
						
						
					
					</div>
					<!-- <div class="col-xs-6 col-md-4 sidebar" id="sidebar">
						<div class="sidebar-title for-tablet">Sidebar</div>
						<h1 class="title-col">最近上映</h1>
						<aside>
						
							<div class="aside-body">
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/pic1.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">《我不是药神》 口碑大获好评，徐峥：“将选出一部分票房给患病病人”</a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/pic2.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">侏罗纪公园2昨日上映，首日票房破4000W领跑暑期档</a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/pic3.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">#欢乐暑期档# #狄仁杰四大天王#北京LUEX激光巨幕3D版免费观看，报名方式...</a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/pic4.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">由王家卫执导，张国荣、张曼玉、刘德华主演的《阿飞正传》今日登陆内地大荧幕重映
							</a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/pic5.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">动画喜剧电影《淘气大侦探》将于明日（20日）在内地公映，影片由约翰德普、艾米莉布朗特配音</a></h1>
										</div>
									</div>
								</article>
							
							</div>
						</aside>
					
						-->
					
					
					</div>
				</div>
			</div>
		</section>

		

		
		<!-- JS -->
		<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script src="js/jquery.migrate.js"></script>
		<script src="scripts/bootstrap/bootstrap.min.js"></script>
		<script>var $target_end=$(".best-of-the-week");</script>
		<script src="scripts/jquery-number/jquery.number.min.js"></script>
		<script src="scripts/owlcarousel/dist/owl.carousel.min.js"></script>
		<script src="scripts/magnific-popup/dist/jquery.magnific-popup.min.js"></script>
		<script src="scripts/easescroll/jquery.easeScroll.js"></script>
		<script src="scripts/sweetalert/dist/sweetalert.min.js"></script>
		<script src="scripts/toast/jquery.toast.min.js"></script>
		<script src="js/demo.js"></script>
		<script src="js/e-magz.js"></script>
	</body>
</html>