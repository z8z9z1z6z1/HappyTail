<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" id="topic-tab" data-toggle="tab" href="#topic" role="tab" aria-controls="topic" aria-selected="true" onclick="setTagType('myTopiclist')">我的文章</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="follow-tab" data-toggle="tab" href="#follow" role="tab" aria-controls="follow" aria-selected="false" onclick="setTagType('myFollowlist')">追蹤文章</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="like-tab" data-toggle="tab" href="#like" role="tab" aria-controls="like" aria-selected="false" onclick="setTagType('myThumbsUplist')">按讚文章</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="history-tab" data-toggle="tab" href="#history" role="tab" aria-controls="history" aria-selected="false" onclick="setTagType('myReadHistorylist')">閱讀歷史</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="favorate-tab" data-toggle="tab" href="#favorate" role="tab" aria-controls="favorate" aria-selected="false" onclick="setTagType('favorateCategorylist')">喜好看板類別</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="notice-tab" data-toggle="tab" href="#notice" role="tab" aria-controls="notice" aria-selected="false" onclick="setTagType('noticelist')">討論區通知</a>
  </li>
</ul>

<div class="row" style="margin-top: 15px">
<div class="col-sm-3"  id="topicNum">	
	<blockquote class="blockquote">
		<span class="mb-0">總文章數量：<span id="totalNum"></span></span>
	</blockquote>
</div>
</div>

<div class="tab-content" id="forum-tab-content">

  <div class="tab-pane fade show active" id="topic" role="tabpanel" aria-labelledby="topic-tab">
	<!--   TODO : use memberCenterTemplate[id="myTopic"] here -->
  </div>
  <div class="tab-pane fade" id="follow" role="tabpanel" aria-labelledby="follow-tab">
  	<!--   TODO : use memberCenterTemplate[id="myFollowList"] here -->
  </div>
  <div class="tab-pane fade" id="like" role="tabpanel" aria-labelledby="like-tab">
	<!--   TODO : use memberCenterTemplate[id="myLikeTopic"] here -->
  </div>
  <div class="tab-pane fade" id="history" role="tabpanel" aria-labelledby="history-tab">
	<!--   TODO : use memberCenterTemplate[id="myReadHistory"] here -->
  </div>
  <div class="tab-pane fade" id="favorate" role="tabpanel" aria-labelledby="favorate-tab">
      <div class="row mt-5">
          <div class="col-4"></div>
          <div class="col-4">
              <div id="favorateCategoryList" class="list-group">
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="1"><h5>生活</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="2"><h5>資訊</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="3"><h5>新聞</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="4"><h5>發問</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="5"><h5>認養</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="6"><h5>其他</h5></button>
              </div>
              <button type="button" class="btn btn-primary btn-lg btn-block mt-3" onclick="updateFavorateCategory()">
                 	 更新喜好類別
              </button>
          </div>

          <div class="col-4"></div>
      </div>
  </div>
  <div class="tab-pane fade" id="notice" role="tabpanel" aria-labelledby="notice-tab">
      <div class="row mt-5">
          <div class="col-12">
              <div id="noticeList" class="list-group">
              	<!--   TODO : use memberCenterTemplate[id="noticeList"] here -->
              </div>
              <!--   TODO : function readAllNotice() -->
              <button type="button" class="btn btn-primary btn-lg btn-block mt-3" onclick="readAllNotice()">
                  	設定全部已讀
              </button>
              <div class="row mt-3">
                  <div class="col-12 d-flex justify-content-center">
                      <nav aria-label="Page navigation example">
                          <ul id="noticeListPagination" class="pagination">
                          		<!--   TODO : use memberCenterTemplate[id="noticeListPagination"] here -->
                          </ul>
                      </nav>
                  </div>
              </div>
              
          </div>

      </div>
  </div>
  
</div>

	<div id="topicContentDialog" class="modal vh-100" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-body" id="topicContent"></div>
				<div class="modal-body" id="replyContentList"></div>
			</div>
		</div>
	</div>
	
		<div id="UpdateDialog" class="modal vh-100" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-body" id="updateTopicContent">
				</div>
			</div>
		</div>
	</div>