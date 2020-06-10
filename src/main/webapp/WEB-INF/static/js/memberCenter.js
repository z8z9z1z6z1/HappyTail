var myTopicTemplate = "";
var myTopicPage = 1;

var myFollowListTemplate = "";
var myFollowListPage = 1;

var myLikeTopicTemplate = "";
var myLikeTopicPage = 1;

var myReadHistoryTemplate = "";
var myReadHistoryPage = 1;

var myNoticeTemplate = "";
var myNoticePage = 1;

var topicContentTemplate = "";
var replyListTemplate = "";
var replyListPageNum = 1; // start from page 1

var updatTopicTemplate = "";
var updatetopicEditor = null;

var tagType = "";



$(document).ready(function(){
	initTemplate();
	
	// TODO : all the function below
	getTopicListData();
	
// initUpdateTopicCKEditor();
	
// getMyTopicData();
// getMyFollowListData();
// getMyLikeTopicData();
// getMyReadHistoryData();
//getFavorateCategory();
	
	// TODO : all the delete function and update function
	
	if(location.href.indexOf("/topicPage/") != -1){
		var topicId = location.href.substring(location.href.indexOf("/topicPage/") + 11);
		openTopicContentDialog(topicId, null);
	}

	
});

function initTemplate() {
	$.ajax({
		url : contextRoot + "/template/memberCenterTemplate.mst",
		type : "get",
		async : false,
		success : function(template) {
						myTopicTemplate = $(template).filter("#myTopic").html();
						myFollowListTemplate = $(template).filter("#myFollowList").html();
						myLikeTopicTemplate = $(template).filter("#myLikeTopic").html();
						myReadHistoryTemplate = $(template).filter("#myReadHistory").html();
						topicContentTemplate = $(template).filter("#topicContent").html();
						replyListTemplate = $(template).filter("#replyContentList").html();
						updatTopicTemplate = $(template).filter("#updateContent").html();
						myNoticeTemplate = $(template).filter("#noticeList").html();

		}
	});
}



function setTagType(tagTypeSrc) {
	tagType = tagTypeSrc;
	if(tagType == 'favorateCategorylist'){
		$("#topicNum").addClass("d-none");
	}else if(tagType == 'noticelist'){
		
		$("#topicNum").addClass("d-none");

	}else{
		
		$("#topicNum").removeClass("d-none");

	}
	
	pageNum = 1;
	getTopicListData();
}


function getTopicListData() {
	
	// TODO : need to clear list area first
	refreshAllListArea();
	
	var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
	+ myTopicPage +  "&tagType=myTopiclist";	
	
	$.ajax({
		url : url,
		type : "get",
		async : false,
		success : function(data) {
			
			$("#topic").append(Mustache.render(myTopicTemplate, data));

			$("#totalNum").text(data.totalNum);
			// check whether has next page or not
			if (data.hasNext) {
				// to the next page
				myTopicPage++;
				}
			}
	
		});
	
	if (tagType != null) {
		
		if(tagType == "myTopiclist"){
		
		refreshAllListArea();
		
		var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
		+ myTopicPage +  "&tagType=myTopiclist";	
		
		$.ajax({
			url : url,
			type : "get",
			async : false,
			success : function(data) {
				
				$("#topic").append(Mustache.render(myTopicTemplate, data));

				$("#totalNum").text(data.totalNum);
				// check whether has next page or not
				if (data.hasNext) {
					// to the next page
					myTopicPage++;
					}
				}
		
			});
		}else if(tagType == "myFollowlist"){
			
			refreshAllListArea();
			
			var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
			+ myFollowListPage +  "&tagType=myFollowlist";	
			
			$.ajax({
				url : url,
				type : "get",
				async : false,
				success : function(data) {
					
					$("#follow").append(Mustache.render(myFollowListTemplate, data));

					$("#totalNum").text(data.totalNum);
					// check whether has next page or not
					if (data.hasNext) {
						// to the next page
						myFollowListPage++;
						}
					}
			
				});
		}else if(tagType == "myThumbsUplist"){
			
			refreshAllListArea();

				var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
				+ myLikeTopicPage +  "&tagType=myThumbsUplist";	
				
				$.ajax({
					url : url,
					type : "get",
					async : false,
					success : function(data) {
						
						$("#like").append(Mustache.render(myLikeTopicTemplate, data));

						$("#totalNum").text(data.totalNum);
						// check whether has next page or not
						if (data.hasNext) {
							// to the next page
							myLikeTopicPage++;
							}
						}
				
					});
			
		}else if(tagType == "myReadHistorylist") {
			
			refreshAllListArea();
			
			var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
			+ myReadHistoryPage +  "&tagType=myReadHistorylist";	
			
			$.ajax({
				url : url,
				type : "get",
				async : false,
				success : function(data) {
					
					$("#history").append(Mustache.render(myReadHistoryTemplate, data));

					$("#totalNum").text(data.totalNum);
					// check whether has next page or not
					if (data.hasNext) {
						// to the next page
						myReadHistoryPage++;
						}
					}
			
				});
		}else if(tagType == "favorateCategorylist"){
			
			var codeMapList = null;
			var url = contextRoot + "/myPage/favorateCategorylist";

			$.ajax({
				  url: url,
				  type: "GET",
				  async: false,
	   		      contentType: "application/json",
				  success: function(data){
							console.log(data);
							if(data){
								codeMapList = data;
							}
					}
			});
			
			var categoryIdList = []; // need to get from API
			
			// get categoryId from codeMap JSON Object
			for(let i=0 ; i<codeMapList.length ; i++){
				categoryIdList.push(codeMapList[i].key);
			}
			
			console.log(categoryIdList);
			
			$("#favorateCategoryList .list-group-item").each(function(index,element){
				for(let categoryId of categoryIdList){
					if($(element).attr("value") == categoryId){
						$(element).addClass("active");
					}
				}
			});
			
			
		}else{
			
			var url = contextRoot + "/myPage/forumNotice?module=Forum&pageSize=10&pageNum=" + myNoticePage;
			
			$.ajax({
				url : url,
				type : "get",
				async : false,
				success : function(data) {
					
					$("#noticeList").append(Mustache.render(myNoticeTemplate, data));

					$("#totalNum").text(data.totalNum);
					// check whether has next page or not
					if (data.hasNext) {
						// to the next page
						myNoticePage++;
						}
					}
			
				});
			
		}
	}
}
	
	
function refreshAllListArea(){
	// Tip : $(element).html("")
	
	// TODO : clear myTopic area
	// TODO : clear myFollow area
	// TODO : clear myLike area
	// TODO : clear myReadHistory area
	
	
if (tagType != null) {
		
		if(tagType == "myTopiclist"){
		
			$("#topic").html("");
		
		}else if(tagType == "myFollowlist"){
			
			$("#follow").html("");
		}else if(tagType == "myThumbsUplist"){
			
			$("#like").html("");
			
		}else if(tagType == "myReadHistorylist"){
			
			$("#history").html("");
			
		}else{
			$("#noticeList").html("");
		}
	}
	
	console.log("Please clear the list area first");
}



function openTopicContentDialog(topicId, targetObj) {

	
	var likeNum = targetObj != null ? $(targetObj).parentsUntil(".card").find(".likeNum").text() : 0;
	var replyNum = targetObj != null ? $(targetObj).parentsUntil(".card").find(".replyNum").text() : 0;

	var topicurl = contextRoot + "/topic/" + topicId;

	var replyurl = contextRoot + "/reply?pageSize=10&pageNum="
	+ replyListPageNum +"&topicId=" + topicId;

	var stageListObj = { stageList : [] };
	
	$.ajax({
		url : topicurl,
		type : "get",
		async : false,
		success : function(data) {
			data.likeNum = likeNum;
			data.replyNum = replyNum;
			data.topicId = topicId;
			
			$("#topicContent").html(
					Mustache.render(topicContentTemplate, data));
			console.log(data);
		}

	});
	
	$.ajax({
		url : replyurl,
		type: "get",
		async : false,
		success : function(data){

			for(let i=0 ; i<data.records.length ; i++){
				  data.records[i].stage = 'B' + (i + 1);
				  data.records[i].stageValue = i + 1;
				}
							
			$("#replyContentList").html("");
			$("#replyContentList").append(Mustache.render(replyListTemplate, data));

			// check whether has next page or not
			if (data.hasNext) {
				// to the next page
				replyListPageNum++;
			}
		}

		});

	$('#topicContentDialog').modal('show');
}
	
	function closeTopicContentDialog(topicId,targetObj){
		$('#topicContentDialog').modal('hide')
		}
	
	function openUpdateDialog(topicId, targetObj){
// console.log($("#articleContent input[name='content']").val());
// var content = updatetopicEditor.getData();

		var topicurl = contextRoot + "/topic/" + topicId;
		
		$.ajax({
			url : topicurl,
			type : "get",
			async : false,
			success : function(data) {
				
				data.topicId = topicId;
				console.log(data.topicId);

				$("#updateTopicContent").html(
						Mustache.render(updatTopicTemplate, data));
				console.log(data);
			}

		});
		
		initUpdateTopicCKEditor();

		console.log($("#addTopicForm input[type='hidden']"));
		console.log($("#addTopicForm input[type='hidden']").find("input[name='categoryId']"));
		
		var categoryId = ""; 
			
		$("#addTopicForm input[type='hidden']").each(function(index,element){
			if($(element).attr("name") == "categoryId"){
				categoryId = $(element).val();
			}
		});
		
		console.log(categoryId);
		$(".categoryArea input[name='categoryId']").each(function(index,element){
			if($(element).val() == categoryId){
				$(element).attr('checked','checked');
			}
		});

		$('#UpdateDialog').modal('show');
		
	}
	
	function clickUpdateTopic(topicId, targetObj){
		
		console.log("topicId=" +topicId);
		
		var content = updatetopicEditor.getData();
		console.log("content=" +content);

		var imgListStr = "";
		$(content).find("img").each(function(index,element){
			console.log("index = " + index);// number of picture
			console.log("src = " + $(element).attr("src"));
			
			imgListStr += $(element).attr("src") + ",";
		});
		
		if(imgListStr.length != 0){
			imgListStr = imgListStr.substring(0,imgListStr.length - 1);//cut the ,
		}
		
		$("#addTopicForm input[name='imgList']").val(imgListStr);
		$("#addTopicForm input[name='content']").val(content);
		console.log("updatecontent=" + $("#addTopicForm input[name='content']").val()); 
		console.log("form=" + $(addTopicForm).serialize());

		var url = contextRoot + "/myPage/UpdateOrDeleteTopic/" + topicId + "?action=update";
		var form = $(addTopicForm);
		console.log(form);
		
		$.ajax({
			url : url,
			type : "POST",
			async : false,
			data: form.serialize(),
			success : function(data) {
						console.log("data="+data);
						alert("更新成功 !");
						
						window.location.reload();
						
					}
			});
		
		console.log("GoodBye!");

	}
	
	
	
	function closeUpdateTopicDialog(topicId,targetObj){
		$('#UpdateDialog').modal('hide')
		}
	
	function initUpdateTopicCKEditor(){

        BalloonEditor
        .create( document.querySelector( '#updatetopicEditor' ),{
        	
            ckfinder: {
		                uploadUrl: contextRoot + "/uploadTopicImg"
		              }
        } )
        .then( editorInstance => {
        	updatetopicEditor = editorInstance;
            
        })
        
        .catch( error => {
            console.error( error );
        });
    }
	
	function deleteTopic(topicId, targetObj){
		
		var url = contextRoot + "/myPage/UpdateOrDeleteTopic/" + topicId + "?action=delete";
		
		$.ajax({
			url : url,
			type : "POST",
			async : false,
			success : function(data) {
						console.log($(targetObj).parentsUntil(".myTopicItem").parent());
						$(targetObj).parentsUntil(".myTopicItem").parent().hide();
						alert("刪除成功 !");
					}
			});
		
		
	}
	
	function deleteThumbsUp(topicId, targetObj){
		var userId =  parseInt($("#loginUserId").text());
		var url = contextRoot + "/thumbsUp/topic/" + userId + "/" +  topicId;
		
		// can't get type now, fixed this function, 
		// just delete the topic which shown on the browser 
		
//		$.ajax({
//			url : url,
//			type : "DELETE",
//			async : false,
//			success : function(data) {
//				console.log($(targetObj).parentsUntil(".myTopicItem").parent());
				$(targetObj).parentsUntil(".myTopicItem").parent().hide();
				alert("刪除成功 !");
//			}
//		});
		
		
	}
	
	function deleteFollow(topicId, targetObj){
		var userId =  parseInt($("#loginUserId").text());
		var url = contextRoot + "/follow/" + userId + "/" +  topicId;
		
		$.ajax({
			url : url,
			type : "DELETE",
			async : false,
			success : function(data) {
				console.log($(targetObj).parentsUntil(".myTopicItem").parent());
				$(targetObj).parentsUntil(".myTopicItem").parent().hide();
				alert("刪除成功 !");
			}
		});
		
		
	}
	
	function deleteHistory(topicId, targetObj){
		var userId =  parseInt($("#loginUserId").text());
		var url = contextRoot + "/myPage/removeHistory/" + userId + "/" +  topicId;
		
		$.ajax({
			url : url,
			type : "DELETE",
			async : false,
			success : function(data) {
				console.log($(targetObj).parentsUntil(".myTopicItem").parent());
				$(targetObj).parentsUntil(".myTopicItem").parent().hide();
				alert("刪除成功 !");
			}
		});
		
		
	}


// for favorate
function toggleActive(targetObj){
    $(targetObj).toggleClass("active");
}

function updateFavorateCategory(){
	var userId =  parseInt($("#loginUserId").text());
	var categoryList = [];
	
	$("#favorateCategoryList .active").each(function(index,element){
		categoryList.push({ userId: userId, categoryId: parseInt($(element).attr("value"))});
	});
	
	
	// TODO : need to defined
	var url = contextRoot + "/myPage/UpdateFavorateCategory/" + userId;
	
	$.ajax({
		url: url,
	   type: "POST",
	   data: JSON.stringify(categoryList),
	   contentType: "application/json",
	success: function(data){
				alert("更新成功 !");
			}
	});
	
}

function readAllNotice(){
	//all read 
	var userId =  parseInt($("#loginUserId").text());
	var url = contextRoot + "/myPage/notice";
	var noticeList = [];

	$("#noticeList").each(function(index,element){
		noticeList.push({ userId: userId});
	});
	
	$.ajax({
		url: url,
	   type: "POST",
	   data: JSON.stringify(noticeList),
	   contentType: "application/json",
	success: function(data){
			window.location.reload();
	
			}
	});
	

	
}


