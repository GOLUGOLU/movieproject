<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


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
		<link rel="stylesheet"  href="css/moviepage.css" >
	</head>
<script>
function show(){

var session="<%=session.getAttribute("username")%>"
//alert(session)
if(session=="null")
{
	document.getElementById("div_user").innerHTML="<div  class='col-md-3 col-sm-12 text-right'><ul class='nav-icons'><li><a href='register.html'><i class='ion-person-add'></i> <div> 注册</div></a></li><li><a href='login.html'><i class='ion-person'></i><div>登录</div></a></li></ul></div>"

}
else
{
	document.getElementById("div_user").innerHTML="<div  class='col-md-3 col-sm-12 text-right'><ul class='nav-icons'><li><img class='img-circle' src='images/img01.jpg' width='45px'/></li><li><a href='single.jsp'><div>${sessionScope.user.getUserName()}</div></a></li></ul></div>"
}

}
</script>
	<body onload="show()">
			<div class="firstbar">
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
						<div id="div_user"></div>
					</div>
				</div>
			</div>

		
		</header>
		
		
	<section class="not-found">
			<div class="container">
    <div id="wrapper">
        

        
    <div id="content">
        
    <h1>选电影</h1>

        <div class="grid-16-8 clearfix">
            
            
            <div class="article">
                
    
    
<div class="gaia">
    <div class="detail-pop"></div>

    <div class="fliter-wp">
        
         <form action="SelectMovieServletByUser" class="gaia_frm" autocomplete="off">
        <input type="hidden" name="type" value="moviename">
          <div class="form-group">
							<div class="input-group">
							
										<input type="text" name="keyword" class="form-control" placeholder="输入你想要的电影信息"  size="px">	
											<div class="input-group-btn">
											<button class="btn btn-primary"><i class="ion-search"></i></button>
										</div>

									</div>
								</div>
        <div class="tool">
            <div class="sort">
                <label>
                    <input type="radio" name="sort" value="moviereviewnumber" checked="checked">按热度排序
                </label>
                <label>
                    <input type="radio" name="sort" value="movieyear">按时间排序
                </label>
                <label>
                    <input type="radio" name="sort" value="avgscore">按评分排序
                </label>
            </div>
			</div>
          </form>
        
        		
        
   
        
        <div class="tag-list">
        <a href="SelectMovieByType?type=爱情" > <label class="select"><input type="button" name="tag" value="爱情"> </label></a>
         <a href="SelectMovieByType?type=惊悚" >	<label class="select"><input type="button" name="tag" value="惊悚"> </label></a>
         <a href="SelectMovieByType?type=动作" >	<label class="select"><input type="button" name="tag" value="动作"> </label></a>
         <a href="SelectMovieByType?type=灾难" >	<label class="select"><input type="button" name="tag" value="灾难"> </label></a>
         <a href="SelectMovieByType?type=历史" >	<label class="select"><input type="button" name="tag" value="历史"> </label></a>
         <a href="SelectMovieByType?type=战争" >	<label class="select"><input type="button" name="tag" value="战争"> </label></a>
         <a href="SelectMovieByType?type=喜剧" >	<label class="select"><input type="button" name="tag" value="喜剧"> </label></a>
         <a href="SelectMovieByType?type=犯罪" >	<label class="select"><input type="button" name="tag" value="犯罪"> </label></a>
         <a href="SelectMovieByType?type=科幻" >	<label class="select"><input type="button" name="tag" value="科幻"> </label></a>
        <a href="SelectMovieByType?type=悬疑" >    <label class="select"><input type="button" name="tag" value="悬疑"> </label></a>
        </div>
        	
        
        
        
        
<div class="filter">
   
            <input type="hidden" name="page_limit" value="20">
            <input type="hidden" name="page_start" value="0">
        </div>
        
        
        
 
        	
   
 
        	
     <div class="moviepic">
    <c:forEach var="movie" items="${requestScope.movielist}" varStatus="status">
    <div class="pic" width="200" >
    <a href="SelectMoviePageServlet?movieid=${movie.getMovieId()}">
    <img src="${movie.getMovieImgUrl()}" height="218" width="180"><br>
    <span>${movie.getMovieName()}</span><br>
	<span>${movie.getAvgScore()}</span>
    </a>
    </div>
    </c:forEach>
    </div>
        </div>
        </div>
     </div>
     </div>
     </div>
     </div>
     </div>

     </div>
     
    <div id="footer">
            <div class="footer-extra"></div>
         <div class="col-md-12 text-center">
		            <ul class="pagination">
		              <li class="prev"><a href="#"><i class="ion-ios-arrow-left"></i></a></li>
		              <li class="active"><a href="#">1</a></li>
		              <li><a href="#">2</a></li>
		              <li><a href="#">3</a></li>
		              <li><a href="#">...</a></li>
		              <li><a href="#">97</a></li>
		              <li class="next"><a href="#"><i class="ion-ios-arrow-right"></i></a></li>
		            </ul>
		            <div class="pagination-help-text">
		            	
		            </div>
		          </div>
		          </div>
		          
</section>
		

		<!-- Start footer -->
		<footer class="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="block">
							<h1 class="block-title">Company Info</h1>
							<div class="block-body">
								<figure class="foot-logo">
									<img src="images/logo-light.png" class="img-responsive" alt="Logo">
								</figure>
								<p class="brand-description">
									Magz is a HTML5 &amp; CSS3 magazine template based on Bootstrap 3.
								</p>
								<a href="page.html" class="btn btn-magz white">About Us <i class="ion-ios-arrow-thin-right"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="block">
							<h1 class="block-title">Popular Tags <div class="right"><a href="#">See All <i class="ion-ios-arrow-thin-right"></i></a></div></h1>
							<div class="block-body">
								<ul class="tags">
									<li><a href="#">HTML5</a></li>
									<li><a href="#">CSS3</a></li>
									<li><a href="#">Bootstrap 3</a></li>
									<li><a href="#">Web Design</a></li>
									<li><a href="#">Creative Mind</a></li>
									<li><a href="#">Standing On The Train</a></li>
									<li><a href="#">at 6.00PM</a></li>
								</ul>
							</div>
						</div>
						<div class="line"></div>
						<div class="block">
							<h1 class="block-title">Newsletter</h1>
							<div class="block-body">
								<p>By subscribing you will receive new articles in your email.</p>
								<form class="newsletter">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="ion-ios-email-outline"></i>
										</div>
										<input type="email" class="form-control email" placeholder="Your mail">
									</div>
									<button class="btn btn-primary btn-block white">Subscribe</button>
								</form>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="block">
							<h1 class="block-title">Latest News</h1>
							<div class="block-body">
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/news/img12.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">Donec consequat lorem quis augue pharetra</a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/news/img14.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">eu dapibus risus aliquam etiam ut venenatis</a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/news/img15.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">Nulla facilisis odio quis gravida vestibulum </a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/news/img16.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">Proin venenatis pellentesque arcu vitae </a></h1>
										</div>
									</div>
								</article>
								<a href="#" class="btn btn-magz white btn-block">See All <i class="ion-ios-arrow-thin-right"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="block">
							<h1 class="block-title">Follow Us</h1>
							<div class="block-body">
								<p>Follow us and stay in touch to get the latest news</p>
								<ul class="social trp">
									<li>
										<a href="#" class="facebook">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-facebook"></i>
										</a>
									</li>
									<li>
										<a href="#" class="twitter">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-twitter-outline"></i>
										</a>
									</li>
									<li>
										<a href="#" class="youtube">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-youtube-outline"></i>
										</a>
									</li>
									<li>
										<a href="#" class="googleplus">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-googleplus"></i>
										</a>
									</li>
									<li>
										<a href="#" class="instagram">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-instagram-outline"></i>
										</a>
									</li>
									<li>
										<a href="#" class="tumblr">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-tumblr"></i>
										</a>
									</li>
									<li>
										<a href="#" class="dribbble">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-dribbble"></i>
										</a>
									</li>
									<li>
										<a href="#" class="linkedin">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-linkedin"></i>
										</a>
									</li>
									<li>
										<a href="#" class="skype">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-skype"></i>
										</a>
									</li>
									<li>
										<a href="#" class="rss">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-rss"></i>
										</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="line"></div>
						<div class="block">
							<div class="block-body no-margin">
								<ul class="footer-nav-horizontal">
									<li><a href="index.html">Home</a></li>
									<li><a href="#">Partner</a></li>
									<li><a href="contact.html">Contact</a></li>
									<li><a href="page.html">About</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="copyright">
							COPYRIGHT &copy; MAGZ 2017. ALL RIGHT RESERVED.
							<div>
								Made with <i class="ion-heart"></i> by jq22
							</div>
						</div>
					</div>
				</div>
			</div>
		
		</footer>
		<!-- End Footer -->

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