<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet Forum</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp"%>

<script src="<c:url value='/js/forum.js'/>"></script>
<link href="<c:url value="/css/Forum.css"/> " rel="stylesheet">

</head>
<body>

	<%@include file="/HappytailHeader.jsp"%>

	<div class="container">

		<div class="row">
			<div class="col-sm-2" style="margin-top: 60px;">
				<div class="list-group" id="list-tab" role="tablist">
					<button type="button"
						class="list-group-item list-group-item-action active"
						onclick="setCategoryId(null,this)">所有文章</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(1,this)">生活</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(2,this)">資訊</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(3,this)">新聞</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(4,this)">發問</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(5,this)">認養</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(6,this)">其他</button>
				</div>
			</div>
			<div class="col-sm-10" style="margin-top: 60px;">
				<div class="row">

					<div class="col-sm-2">
						<blockquote class="blockquote">
							<span class="mb-0">總文章數量：<span id="totalNum"></span></span>

						</blockquote>
					</div>

					<div class="col-sm-8"></div>

					<div class="col-sm-2">
						<ul class="nav nav-pills">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-haspopup="true" aria-expanded="false">文章排序</a>
								<div class="dropdown-menu">
									<button type="button" class="dropdown-item"
										onclick="setTagType(null)">最新</button>
									<div class="dropdown-divider"></div>
									<button type="button" class="dropdown-item"
										onclick="setTagType('hit')">熱門</button>
								</div></li>
						</ul>
					</div>
				</div>

<!-- 				<div class="row justify-content-around"> -->

<!-- 					<div class=" col-md-2"> -->
<%-- 						<img src="<c:url value='/img/story2.png'/>" class="card-img" --%>
<!-- 							alt="..."> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-2"> -->
<%-- 						<img src="<c:url value='/img/story2.png'/>" class="card-img" --%>
<!-- 							alt="..."> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-2"> -->
<%-- 						<img src="<c:url value='/img/story2.png'/>" class="card-img" --%>
<!-- 							alt="..."> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-2"> -->
<%-- 						<img src="<c:url value='/img/story2.png'/>" class="card-img" --%>
<!-- 							alt="..."> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-2"> -->
<%-- 						<img src="<c:url value='/img/story2.png'/>" class="card-img" --%>
<!-- 							alt="..."> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-2"> -->
<%-- 						<img src="<c:url value='/img/story2.png'/>" class="card-img" --%>
<!-- 							alt="..."> -->
<!-- 					</div> -->
<!-- 				</div> -->
				<article class="all-browsers">
					<article id="topicListArea" class="browser bg-transparent">
					</article>
				</article>
				<div id="topiclist-loading-img-area" class="container mt-5 mb-5 d-none">
					<div class="row">
						<div class="col-12">
							<img class="mx-auto d-block" style="width: 50px" src="<c:url value="/img/loading.gif"/>"/>						
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


	<%@include file="/HappytailFooter.jsp"%>

	<div id="topicContentDialog" class="modal vh-100" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-dialog-scrollable modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div id="topicContent"></div>
					<div id="replyContentList"></div>
					<div id="topic-content-loading-img-area" class="container mt-5 mb-5 d-none">
					<div class="row">
						<div class="col-12">
							<img class="mx-auto d-block" style="width: 50px" src="<c:url value="/img/loading.gif"/>"/>						
						</div>
					</div>
				</div>
				</div>
				<div class="modal-footer" id="addReply">
					<div class="row  w-100">
						<div class="col-md-1">
                            <i class="fas fa-paw fa-2x"></i>
                        </div>
                         <div class="col-md-10">
     						<div id="replyEditor"></div>
                        </div>
                        <div class="col-md-1">
                        	<button type="button" class="btn btn-primary" onclick="clickAddReply()">送出</button>
                        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="stageListDialog" tabindex="-1" role="dialog" aria-labelledby="stageListModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="stageListModalLabel">樓層清單</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div id="stage-list" class="list-group">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

	<div id="addTopicDialog" class="modal" tabindex="-1" role="dialog">
	
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-body" id="addTopic">
					<div class="row justify-content-md-center">
						<div class="col-2">
							<blockquote class="flow-text left">發表文章</blockquote>
						</div>
						<div class="col-9"></div>
						<div class="col-1">
							<i class="fas fa-times fa-2x" onclick="closeAddTopicDialog()"></i>
						</div>
					</div>
					<form id="addTopicForm">
						<div class="form-group">

							<div class="row justify-content-md-center">
								<div class="col-12">
									<div class="form-check" style="margin-top: 15px;">
										<input class="form-check-input" type="radio" name="categoryId"
											id="life" value="1" required="required"> <label
											class="form-check-label" for="life"> 生活 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="knowledge" value="2"> <label
											class="form-check-label" for="knowledge"> 資訊 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="news" value="3"> <label class="form-check-label"
											for="news"> 新聞 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="question" value="4"> <label
											class="form-check-label" for="question"> 發問 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="adopt" value="5"> <label class="form-check-label"
											for="adopt"> 認養 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="other" value="6"> <label
											class="form-check-label" for="other"> 其他 </label>
									</div>
								</div>
							</div>

							<div class="row justify-content-md-center">
								<div class="col-12" style="margin-top: 15px;">
									<input name="title" class="form-control form-control-lg" type="text"
										placeholder="標題">
								</div>
							</div>
							<div class="row justify-content-md-center">
								<div class="col-12" style="margin-top: 15px;">
									 <div id="topicEditor"></div>
								</div>
							</div>
							<div class="row justify-content-md-center">
								<div class="col-12" style="margin-top: 15px;">
									<div class="form-check">
 										 <input class="form-check-input" type="checkbox" value="true" id="isCover" name="isCover">
  											<label class="form-check-label" for="isCover">是否顯示封面圖片
  											</label>
								</div>
							</div>
							</div>
							
        					  <input type="hidden" name="content"/>
        					  <input type="hidden" name="imgList"/>
         					  <input type="hidden" name="username" value="${petMembers.username}" />
         					  <input type="hidden" name="userId" value="${petMembers.id}" />

<!-- 							<div class="form-group" style="margin-top: 15px;"> -->
<!-- 								<label for="exampleFormControlTextarea1">Content:</label> -->
								
<!-- 								<textarea name="content" class="form-control" -->
<!-- 									id="exampleFormControlTextarea1" rows="20" cols="40" -->
<!-- 									required="required"></textarea> -->
<!-- 							</div> -->
						</div>
					</form>
					<div class="row">
						<div class="col-md-2 offset-md-5">
							<button type="button" class="btn btn-info" name="add" onclick="clickAddTopic()">發表</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="addReportDialog" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-body" id="addReport">
					<div class="row justify-content-md-center">
						<div class="col-2">
							<blockquote class="flow-text">檢舉文章</blockquote>
						</div>
						<div class="col-9"></div>
						<div class="col-1">
							<i class="fas fa-times fa-2x" onclick="closeAddReportDialog()"></i>
						</div>
					</div>
					<form id="addReportForm">
						<div class="form-group">
						<div>
							<blockquote class="flow-text">檢舉這篇文章的原因？</blockquote>
						</div>
						

							<div class="custom-control custom-radio">
        						<input type="radio" class="custom-control-input" id="report1" name="categoryId" value="1">
       							 <label class="custom-control-label" for="report1">中傷、歧視、挑釁或謾罵他人</label>
   							 </div>

   							 <div class="custom-control custom-radio">
      							  <input type="radio" class="custom-control-input" id="report2" name="categoryId" value="2">
     							   <label class="custom-control-label" for="report2">惡意洗板、重複張貼</label>
   							 </div>

    						<div class="custom-control custom-radio">
      							  <input type="radio" class="custom-control-input" id="report3" name="categoryId" value="3">
      							  <label class="custom-control-label" for="report3">包含色情、露點、性騷擾或血腥恐怖等讓人不舒服之內容</label>
    						</div>
    						<div class="custom-control custom-radio">
        						<input type="radio" class="custom-control-input" id="report4" name="categoryId" value="4">
      							  <label class="custom-control-label" for="report4">包含鼓吹暴力、犯罪之內容</label>
						    </div>
						    <div class="custom-control custom-radio">
						        <input type="radio" class="custom-control-input" id="report5" name="categoryId" value="5">
						        <label class="custom-control-label" for="report5">包含廣告、商業宣傳之內容</label>
						    </div>
						    <div class="custom-control custom-radio">
						        <input type="radio" class="custom-control-input" id="report6" name="categoryId" value="6">
						        <label class="custom-control-label" for="report6">文章發表在不適當的看板</label>
						    </div>
						    <div class="custom-control custom-radio">
						        <input type="radio" class="custom-control-input" id="report7" name="categoryId" value="7">
						        <label class="custom-control-label" for="report7">使用者名稱內含不適當的字詞</label>
						    </div>
						    <div class="custom-control custom-radio">
						        <input type="radio" class="custom-control-input" id="report8" name="categoryId" value="8">
						        <label class="custom-control-label" for="report8">其他原因</label>
						    </div>
                         	  <input type="hidden" name="topicId"/>
          					  <input type="hidden" name="username" value="${petMembers.username}" />
          					  <input type="hidden" name="userId" value="${petMembers.id}" />
						</div>
					</form>
					<div class="row">
						<div class="col-md-2 offset-md-5">
							<button type="button" class="btn btn-info" name="add" onclick="clickAddReport()">送出</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="favorateCatgoryDialog" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row ml-3 mr-3 mt-3 mb-3">
						<div class="col-12">
							<div id="favorateCategoryList" class="list-group">
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="1"><h5>生活</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="2"><h5>資訊</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="3"><h5>新聞</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="4"><h5>發問</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="5"><h5>認養</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="6"><h5>其他</h5></button>
			  					  <input type="hidden" name="userId" value="${petMembers.id}" />
			                
			                </div>
			                <button type="button" class="btn btn-primary btn-lg btn-block mt-3" onclick="updateFavorateCategory()">
			                 	 選擇喜好類別
			                </button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>

</html>