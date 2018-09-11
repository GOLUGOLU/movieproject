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
		<link rel="stylesheet" href="css/moviepage.css">
	</head>

<style>
.actor1{
		float: left;
	margin-top: 10px;
margin-left: 50px;
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
	<body onload="show()">
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

		<section class="not-found">
	<div class="container"  >
								
					
	<div id="wrapper">
        

        
    <div id="content">
        
    <div id="dale_movie_subject_top_icon"></div>
    <h1>
    <c:forEach var="d" items="${requestScope.director}" varStatus="status">
         <span property="v:itemreviewed">${d.getDirectorName()}</span>
            
  </c:forEach>
      
    </h1>

        <div class="grid-16-8 clearfix">
            

            
            <div class="article">
        <div class="indent clearfix">
            <div class="subjectwrap clearfix" xmlns:v="http://rdf.data-vocabulary.org/#" typeof="v:Movie">
                <div class="subject clearfix">
                    



<div id="mainpic" class="">
   <c:forEach var="d" items="${requestScope.director}" varStatus="status">
    <img src="${d.getDirectorPhoto()}"  height="218" width="180"  title="点击看更多海报" / >
  </c:forEach>
   
</div>

              


<div id="info">
        <span ><span class='pl'>性别</span>: 
         <c:forEach var="d" items="${requestScope.director}" varStatus="status">
  		 <span>${d.getDirectorSex()}</span>
  		 </c:forEach></span>
        <br>
       <span class="actor3"><span class='pl'>星座</span>:
        <c:forEach var="d" items="${requestScope.director}" varStatus="status">
  		 <span>${d.getDirectorSign()}</span> 
  		 </c:forEach></span>
       <br/>
        <span class="pl">生日:</span> 
         <c:forEach var="d" items="${requestScope.director}" varStatus="status">
  		     <span property="v:genre">${d.getDirectorBirthday()}</span> 
  		 </c:forEach>
        <br/>
        
        <span class="pl">职业:</span> 
         <c:forEach var="d" items="${requestScope.director}" varStatus="status">
  		     <span property="v:genre">${d.getDirectorWork()}</span> 
  		 </c:forEach>
        <br/>
        
        
</div>
</div>
</div>
</div>
</div>
</div>
                    


<div id="interest_sectl">
    <div class="rating_wrap clearbox" rel="v:rating">
     


        <div class="ll bigstar bigstar40"></div>
        <div class="rating_sum">
                   <c:forEach var="m" items="${requestScope.movie}" varStatus="status">
  		     <span property="v:genre"><font color="red">${m.getMovieReviewNumber()}</font></span>人评价
  		 </c:forEach>
                
               
        </div>
    </div>
</div>
<div class="ratings-on-weight">
    
      
     
</div>

    </div>
     
</div>


                
            </div>
                




<div id="interest_sect_level" class="clearfix">
        
          
        <div class="ll j a_stars">
            
    
   

</div>

   



<div class="related-info" style="margin-bottom:-10px;">
    <a name="intro"></a>
    
        <br>
        <br>

            
            
    <h2>
        个人简介
             
    </h2>

            <div class="indent" id="link-report">
                    
                        <span property="v:summary" class="">
                               <c:forEach var="d" items="${requestScope.director}" varStatus="status">
  		     <span property="v:genre">${d.getDirectorIntroduction()}</span>
  		 </c:forEach>
                                    <br />
                                　
                        </span>
                    
            </div>
</div>


    








<div id="celebrities" class="celebrities related-celebrities">

<br>
<br>
<br>
  
    <h2>
        影人图片
             
    </h2>
<br>
<br>
  <c:forEach var="d" items="${requestScope.director}" varStatus="status">
  <div class="actor1"><img src="${d.getDirectorPhoto()}" height="218" width="180"><p>${a.getDirectorName()}<p></div>
  
  </c:forEach>
</div>




    
    <div id="related-pic" class="related-pic">
        
    
    
    


        <ul class="related-pic-bd  wide_videos">
        
               
            
        </ul>
    </div>



    
    



<style type="text/css">
.award li { display: inline; margin-right: 5px }
.awards { margin-bottom: 20px }
.awards h2 { background: none; color: #000; font-size: 14px; padding-bottom: 5px; margin-bottom: 8px; border-bottom: 1px dashed #dddddd }
.awards .year { color: #666666; margin-left: -5px }
.mod { margin-bottom: 25px }
.mod .hd { margin-bottom: 10px }
.mod .hd h2 {margin:24px 0 3px 0}
</style>


<div class="mod">
   
        
</div>

    








    <div id="recommendations" class="">
        
 
<section class="topics mod">
   
<section class="subject-topics">
    
    <div id="topic-items"></div>

    <script>
        window.subject_id = 26842702;
        window.join_label_text = '写影评参与';

        window.topic_display_count = 4;
        window.topic_item_display_count = 1;
        window.no_content_fun_call_name = "no_topic";

        window.guideNode = document.getElementById('topic-guide');
        window.guideNodeClose = document.getElementById('topic-guide-close');
    </script>
    
        <link rel="stylesheet" href="https://img3.doubanio.com/f/ithildin/f731c9ea474da58c516290b3a6b1dd1237c07c5e/css/export/subject_topics.css">
        <script src="https://img3.doubanio.com/f/ithildin/d3590fc6ac47b33c804037a1aa7eec49075428c8/js/export/moment-with-locales-only-zh.js"></script>
        <script src="https://img3.doubanio.com/f/ithildin/c600fdbe69e3ffa5a3919c81ae8c8b4140e99a3e/js/export/subject_topics.js"></script>

</section>

    <script>
        function no_topic(){
            $('#content .topics').remove();
        }
    </script>
</section>

<section class="reviews mod movie-content">
	
	

    

<style>
#gallery-topics-selection {
  position: fixed;
  width: 595px;
  padding: 40px 40px 33px 40px;
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 2px 16px 0 rgba(0, 0, 0, 0.2);
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  z-index: 9999;
}
#gallery-topics-selection h1 {
  font-size: 18px;
  color: #007722;
  margin-bottom: 36px;
  padding: 0;
  line-height: 28px;
  font-weight: normal;
}
#gallery-topics-selection .gl_topics {
  border-bottom: 1px solid #dfdfdf;
  max-height: 298px;
  overflow-y: scroll;
}
#gallery-topics-selection .topic {
  margin-bottom: 24px;
}
#gallery-topics-selection .topic_name {
  font-size: 15px;
  color: #333;
  margin: 0;
  line-height: inherit;
}
#gallery-topics-selection .topic_meta {
  font-size: 13px;
  color: #999;
}
#gallery-topics-selection .topics_skip {
  display: block;
  cursor: pointer;
  font-size: 16px;
  color: #3377AA;
  text-align: center;
  margin-top: 33px;
}
#gallery-topics-selection .topics_skip:hover {
  background: transparent;
}
#gallery-topics-selection .close_selection {
  position: absolute;
  width: 30px;
  height: 20px;
  top: 46px;
  right: 40px;
  background: #fff;
  color: #999;
  text-align: right;
}
#gallery-topics-selection .close_selection:hover{
  background: #fff;
  color: #999;
}
</style>



        



<div class="review-list  ">
        
    

        
    
    <div xmlns:v="http://rdf.data-vocabulary.org/#" typeof="v:Review" data-cid="9423311">
        <div class="main review-item" id="9423311">

            
    
    <header class="main-hd">
     

    

         

    </header>
<br>

</section>

<!-- COLLECTED JS -->

    <br/>

      
                
             
                








            


    <script type="text/javascript">
        $(function(){if($.browser.msie && $.browser.version == 6.0){
            var $info = $('#info'),
                maxWidth = parseInt($info.css('max-width'));
            if($info.width() > maxWidth) {
                $info.width(maxWidth);
            }
        }});
    </script>


            
            <div class="aside">
                
    



    





        </div>
    </div>

        
  
    </div>
    <script type="text/javascript" src="https://img3.doubanio.com/misc/mixed_static/5ad5f6f9d9cb7630.js"></script>
        
        
   
    <script type="text/javascript" src="https://img3.doubanio.com/f/shire/77323ae72a612bba8b65f845491513ff3329b1bb/js/do.js" data-cfg-autoload="false"></script>
    <script type="text/javascript" src="https://img3.doubanio.com/f/shire/4ea3216519a6183c7bcd4f7d1a6d4fd57ce1a244/js/ui/dialog.js"></script>
    <script type="text/javascript">
        var HTTPS_DB='https://www.douban.com';
var account_pop={open:function(o,e){e?referrer="?referrer="+encodeURIComponent(e):referrer="?referrer="+window.location.href;var n="",i="",t=382;"reg"===o?(n="用户注册",i="https://accounts.douban.com/popup/login?source=movie#popup_register",t=480):"login"===o&&(n="用户登录",i="https://accounts.douban.com/popup/login?source=movie");var r=document.location.protocol+"//"+document.location.hostname,a=dui.Dialog({width:478,title:n,height:t,cls:"account_pop",isHideTitle:!0,modal:!0,content:"<iframe scrolling='no' frameborder='0' width='478' height='"+t+"' src='"+i+"' name='"+r+"'></iframe>"},!0),c=a.node;if(c.undelegate(),c.delegate(".dui-dialog-close","click",function(){var o=$("body");o.find("#login_msk").hide(),o.find(".account_pop").remove()}),$(window).width()<478){var u="";"reg"===o?u=HTTPS_DB+"/accounts/register"+referrer:"login"===o&&(u=HTTPS_DB+"/accounts/login"+referrer),window.location.href=u}else a.open();$(window).bind("message",function(o){"https://accounts.douban.com"===o.originalEvent.origin&&(c.find("iframe").css("height",o.originalEvent.data),c.height(o.originalEvent.data),a.update())})}};Douban&&Douban.init_show_login&&(Douban.init_show_login=function(o){var e=$(o);e.click(function(){var o=e.data("ref")||"";return account_pop.open("login",o),!1})}),Do(function(){$("body").delegate(".pop_register","click",function(o){o.preventDefault();var e=$(this).data("ref")||"";return account_pop.open("reg",e),!1}),$("body").delegate(".pop_login","click",function(o){o.preventDefault();var e=$(this).data("ref")||"";return account_pop.open("login",e),!1})});
    </script>

    
    
    
    




    
<script type="text/javascript">
    (function (global) {
        var newNode = global.document.createElement('script'),
            existingNode = global.document.getElementsByTagName('script')[0],
            adSource = '//erebor.douban.com/',
            userId = '',
            browserId = 'LOLLUpFZ2GE',
            criteria = '7:史蒂文·元|7:村上春树|7:玉子妍|7:崔承浩|7:李沧东|7:韩国电影|7:金秀京|7:电影|7:韩国|7:2018|7:戛纳电影节|7:悬疑|7:剧情|7:刘亚仁|7:全钟瑞|3:/subject/26842702/?tag=%E7%83%AD%E9%97%A8&amp;from=gaia',
            preview = '',
            debug = false,
            adSlots = ['dale_movie_subject_top_icon', 'dale_movie_subject_top_right', 'dale_movie_subject_top_middle', 'dale_movie_subject_inner_middle', 'dale_movie_subject_download_middle'];

        global.DoubanAdRequest = {src: adSource, uid: userId, bid: browserId, crtr: criteria, prv: preview, debug: debug};
        global.DoubanAdSlots = (global.DoubanAdSlots || []).concat(adSlots);

        newNode.setAttribute('type', 'text/javascript');
        newNode.setAttribute('src', 'https://img3.doubanio.com/f/adjs/cdc904d1376a43e44bbf399a0aff51973016cd77/ad.release.js');
        newNode.setAttribute('async', true);
        existingNode.parentNode.insertBefore(newNode, existingNode);
    })(this);
</script>


<script type="text/javascript">
var _paq = _paq || [];
_paq.push(['trackPageView']);
_paq.push(['enableLinkTracking']);
(function() {
    var p=(('https:' == document.location.protocol) ? 'https' : 'http'), u=p+'://fundin.douban.com/';
    _paq.push(['setTrackerUrl', u+'piwik']);
    _paq.push(['setSiteId', '100001']);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
    g.type='text/javascript';
    g.defer=true;
    g.async=true;
    g.src=p+'://img3.doubanio.com/dae/fundin/piwik.js';
    s.parentNode.insertBefore(g,s);
})();
</script>

<script type="text/javascript">
var setMethodWithNs = function(namespace) {
  var ns = namespace ? namespace + '.' : ''
    , fn = function(string) {
        if(!ns) {return string}
        return ns + string
      }
  return fn
}

var gaWithNamespace = function(fn, namespace) {
  var method = setMethodWithNs(namespace)
  fn.call(this, method)
}

var _gaq = _gaq || []
  , accounts = [
      { id: 'UA-7019765-1', namespace: 'douban' }
    , { id: 'UA-7019765-19', namespace: '' }
    ]
  , gaInit = function(account) {
      gaWithNamespace(function(method) {
        gaInitFn.call(this, method, account)
      }, account.namespace)
    }
  , gaInitFn = function(method, account) {
      _gaq.push([method('_setAccount'), account.id]);
      _gaq.push([method('_setSampleRate'), '5']);

      
  _gaq.push([method('_addOrganic'), 'google', 'q'])
  _gaq.push([method('_addOrganic'), 'baidu', 'wd'])
  _gaq.push([method('_addOrganic'), 'soso', 'w'])
  _gaq.push([method('_addOrganic'), 'youdao', 'q'])
  _gaq.push([method('_addOrganic'), 'so.360.cn', 'q'])
  _gaq.push([method('_addOrganic'), 'sogou', 'query'])
  if (account.namespace) {
    _gaq.push([method('_addIgnoredOrganic'), '豆瓣'])
    _gaq.push([method('_addIgnoredOrganic'), 'douban'])
    _gaq.push([method('_addIgnoredOrganic'), '豆瓣网'])
    _gaq.push([method('_addIgnoredOrganic'), 'www.douban.com'])
  }

      if (account.namespace === 'douban') {
        _gaq.push([method('_setDomainName'), '.douban.com'])
      }

        _gaq.push([method('_setCustomVar'), 1, 'responsive_view_mode', 'desktop', 3])

        _gaq.push([method('_setCustomVar'), 2, 'login_status', '0', 2]);

      _gaq.push([method('_trackPageview')])
    }

for(var i = 0, l = accounts.length; i < l; i++) {
  var account = accounts[i]
  gaInit(account)
}


;(function() {
    var ga = document.createElement('script');
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    ga.setAttribute('async', 'true');
    document.documentElement.firstChild.appendChild(ga);
})()
</script>


			</div>
		</section>
	<!-- Start footer -->
		<footer class="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="block">
							<h1 class="block-title">公司简介</h1>
							<div class="block-body">
								<figure class="foot-logo">
 <img src="images/logo.png">
 	
								</figure>
								<p class="brand-description">
									抽象电影网是由任龙飞同学创建的一个抽象的电影评论网站。
								</p>
								<a href="page.html" class="btn btn-magz white">关于我们<i class="ion-ios-arrow-thin-right"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="block">
							<h1 class="block-title">热门标签<div class="right"><a href="#">全部查看<i class="ion-ios-arrow-thin-right"></i></a></div></h1>
							<div class="block-body">
								<ul class="tags">
									<li><a href="#">动作片</a></li>
									<li><a href="#">动漫</a></li>
									<li><a href="#">纪录片</a></li>
									<li><a href="#">电影剧照</a></li>
									<li><a href="#">评分</a></li>
									<li><a href="#">热门影评</a></li>
									<li><a href="#">影院热映</a></li>
								</ul>
							</div>
						</div>
						<div class="line"></div>
						<div class="block">
							<h1 class="block-title">订阅抽象</h1>
							<div class="block-body">
								<p>告诉我们您的邮箱，您将会收到关于抽象的更多资讯</p>
								<form class="newsletter">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="ion-ios-email-outline"></i>
										</div>
										<input type="email" class="form-control email" placeholder="Your mail">
									</div>
									<button class="btn btn-primary btn-block white">订阅</button>
								</form>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="block">
							<h1 class="block-title">最近新闻</h1>
							<div class="block-body">
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/pic3.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html"> 《狄仁杰》 剧组全国巡演开始，第一站大连 </a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/pic6.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">华谊兄弟入股抽象电影网，双方达成战略协议</a></h1>
										</div>
									</div>
								</article>
								<article class="article-mini">
									<div class="inner">
										<figure>
											<a href="single.html">
												<img src="images/pic7.jpg" alt="Sample Article">
											</a>
										</figure>
										<div class="padding">
											<h1><a href="single.html">抽象影业昨日召开发布会，产业布局重新生态链 </a></h1>
										</div>
									</div>
								</article>
								
								<a href="#" class="btn btn-magz white btn-block">查看 全部<i class="ion-ios-arrow-thin-right"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="block">
							<h1 class="block-title">关注我们</h1>
							<div class="block-body">
								<p>关注我们并了解抽象电影网的最新动态</p>
								<ul class="social trp">
									<li>
										<a href="#" >
											<img src="images/vxlogo.jpg" alt="weixin">
									
										</a>
									</li>
									<li>
										<a href="#" >
										
											<img src="images/weibologo.jpg"alt="weibo">
										</a>
									</li>
									<li>
										<a href="#">
										<img src="images/qqzone.jpg" alt="qqzone">
										</a>
									</li>
										<li>
										<a href="#" class="facebook">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-facebook"></i>
										</a>
									</li>
									
									<li>
										<a href="#" class="youtube">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-youtube-outline"></i>
										</a>
									</li>
									
								
									<li>
										<a href="#" class="twitter">
											<svg><rect width="0" height="0"/></svg>
											<i class="ion-social-twitter-outline"></i>
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
							COPYRIGHT &copy; abstract comypany.
							<div>
								Made with <i class="ion-heart"></i> by wan
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