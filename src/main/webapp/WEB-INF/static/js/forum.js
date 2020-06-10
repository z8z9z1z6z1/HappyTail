var topicListTemplate = "";
var topicContentTemplate = "";
var addTopicTemplate = "";
var replyListTemplate = "";
var stageLinkTemplate = "";
var replyListTemplate = "";
var topicListPageNum = 1; // start from page 1
var replyListPageNum = 1; // start from page 1
var isTopicListHasNextPage = true;
var isReplyListHasNextPage = true;

var topicListIndexArray = [];
var topicListLoadLock = false; 
var replyListLoadLock = false; 
var categoryId = null;
var tagType = null;
var topicEditor = null;
var replyEditor = null;
var replyTemplate = "";
var stageLinkTemplate = "";
var stageListTemplate = "";

// TODO : check from API
var hasNotSetFavorateCategory = true;

$(document).ready(function() {

	initTemplate();
	getTopicListData();

	initTopicCKEditor();
	initReplyCKEditor();
	
	getFavorateCategory();
	
    initTemplate();
    
	if(location.href.indexOf("/topicPage/") != -1){
		var topicId = location.href.substring(location.href.indexOf("/topicPage/") + 11);
		openTopicContentDialog(topicId, null);
	}

    $("#sendBtn").click(function(){
            sendReply();
     });
    	console.log("hasNotSetFavorateCategory = "+ hasNotSetFavorateCategory);
    if(($("#loginUserId").text() != "") && hasNotSetFavorateCategory){
        
    	$("#favorateCatgoryDialog").modal('show');
    }
    
    // for topic list pagination
    $(window).scroll(function(){
// 	        	console.log("scrollTop = " + $(this).scrollTop());
// 	        	console.log("current scroll pos = " + ($(this).scrollTop() + $(this).height()));
// 	        	console.log("height = " + $("body").height());
    	
    	var scrollBottomPos = $("body").height(); 
    	var currentScrollPos = $(this).scrollTop() + $(this).height();
    	
    	if((scrollBottomPos - currentScrollPos) < 300 
    			&& !topicListLoadLock // prevent duplicate loading 
    			&& isTopicListHasNextPage
    			){
    		
    		// prevent duplicate loading, lock when execute function
    		topicListLoadLock = true;
    		
    		$("#topiclist-loading-img-area").removeClass("d-none");
    		
    		topicListPageNum++;
    		
    		// wait 1 second to show loading animate
    		setTimeout(function(){
    			getTopicListData();
    			
    			topicListLoadLock = false;
	        	
        		$("#topiclist-loading-img-area").addClass("d-none");
    		}, 1000);
    	}
    });
    
    // for reply content list pagination
    $('#topicContentDialog .modal-body').scroll(function(){
// 	        	console.log("scrollTop = " + $(this).scrollTop());
// 	        	console.log("current scroll pos = " + ($(this).scrollTop() + $(this).height()));	
// 	        	console.log("height = " + ($("#topicContent").height() + $("#replyContentList").height()));
    	
    	var scrollBottomPos = $("#topicContent").height() + $("#replyContentList").height(); 
    	var currentScrollPos = $(this).scrollTop() + $(this).height();
    	
    	// TODO : imitate topic list pagination function above
    	
    	if((scrollBottomPos - currentScrollPos) < 300 
    			&& !replyListLoadLock // prevent duplicate loading 
    			&& isReplyListHasNextPage
    			){
    		
    		// prevent duplicate loading, lock when execute function
    		replyListLoadLock = true;

    		$("#topic-content-loading-img-area").removeClass("d-none");
    			        		
    		replyListPageNum++;
    		
    		// wait 1 second to show loading animate
    		setTimeout(function(){
    			getReplyListData();

        		$("#topic-content-loading-img-area").addClass("d-none");
    			
    			replyListLoadLock = false;
	        	
    		}, 1000);
    	}
    	
    	// TODO : check the function getReplyListData()
    
    });
    
});

function initTemplate() {
	$.ajax({
			url : contextRoot + "/template/topicTemplate.mst",
			type : "GET",
			async : false,
			success : function(template) {
						topicListTemplate = $(template).filter("#topicList").html();
						topicContentTemplate = $(template).filter("#topicContent").html();
						replyListTemplate = $(template).filter("#replyContentList").html();
						stageLinkTemplate = $(template).filter("#stage").html();
		                stageListTemplate = $(template).filter("#stage-list").html();

				}
			});
}


function getTopicListData() {
	var url = contextRoot + "/topic/topiclist?pageSize=10&pageNum="
			+ topicListPageNum;

	
	if (tagType != null) {
		url += "&tagType=" + tagType;
	}

	if (categoryId != null) {
		url += "&categoryId=" + categoryId;
	}
	
	if(isTopicListHasNextPage){
		$.ajax({
			url : url,
			type : "GET",
			async : false,
			success : function(data) {

//	 					render(data);
				var resultData = Mustache.render(topicListTemplate, data);
				$("#topicListArea").append(resultData);

				$("#totalNum").text(data.totalNum);
				
				
				refreshTopicListIndexArray();
				
				// check whether has next page or not
				isTopicListHasNextPage = data.isHasNext;

			}
		});
	}
	
}

function render(jsonObj) {
	var data = Mustache.render(topicListTemplate, jsonObj);

	$("#topicListArea").html("");
	$("#topicListArea").append(data);
}

function refreshTopicList(){
	$("#topicListArea").html("");
	getTopicListData();
}

// data prepare for topicContentDialog get next or previous topic
function refreshTopicListIndexArray(){
	topicListIndexArray = [];
	
	$("#topicListArea .topicId").each(function(index,element){
		topicListIndexArray.push({
				index: index, 
				topicId: $(element).text(),
				element: $(element)});
	});
	
// 			console.log(topicListIndexArray);
}

function getPreviousTopic(){
	var currentTopicId = $("#addReplyForm input[name='topicId']").val();
	var targetTopicListObj = null;
	
	for(let i=0 ; i<topicListIndexArray.length ; i++){
		
		if(topicListIndexArray[i].topicId == currentTopicId 
		   && i != 0){ // prevent first topic condition
			targetTopicListObj = topicListIndexArray[i-1];
		}
	}
	
	// check previous topic is found
	if(targetTopicListObj != null){
		openTopicContentDialog(targetTopicListObj.topicId,targetTopicListObj.element);
	}
	
}

function getNextTopic(){
	var currentTopicId = $("#addReplyForm input[name='topicId']").val();
	var targetTopicListObj = null;
	
	for(let i=0 ; i<topicListIndexArray.length ; i++){
		
		if(topicListIndexArray[i].topicId == currentTopicId 
		   && i != (topicListIndexArray.length - 1)){ // prevent last topic condition
			
			targetTopicListObj = topicListIndexArray[i+1];
		}
	}
	
	// check previous topic is found
	if(targetTopicListObj != null){
		openTopicContentDialog(targetTopicListObj.topicId,targetTopicListObj.element);
	}
	
}

function openTopicContentDialog(topicId, targetObj) {
			// every time open dialog reset the reply page
			replyListPageNum = 1;
			
			var likeNum = targetObj != null ? $(targetObj).parentsUntil(".card").find(".likeNum").text() : 0;
			var replyNum = targetObj != null ? $(targetObj).parentsUntil(".card").find(".replyNum").text() : 0;

			var topicurl = contextRoot + "/topic/" + topicId;

			var replyurl = contextRoot + "/reply?pageSize=10&pageNum="
			+ replyListPageNum +"&topicId=" + topicId;

			var stageListObj = { stageList : [] };

		$.ajax({
				url : topicurl,
				type : "GET",
				async : false,
				success : function(data) {
					data.likeNum = likeNum;
					data.replyNum = replyNum;
					data.topicId = topicId;
					
					$("#topicContent").html(Mustache.render(topicContentTemplate, data));
// 					console.log(data);
				}

			});
			
			$.ajax({
				url : replyurl,
				type: "GET",
				async : false,
				success : function(data){

							for(let i=0 ; i<data.records.length ; i++){
								  data.records[i].stage = 'B' + (i + 1);
								  data.records[i].stageValue = i + 1;
								}
											
							$("#replyContentList").html("");
							$("#replyContentList").append(Mustache.render(replyListTemplate, data));
		
							isReplyListHasNextPage = data.isHasNext;
							
						}	

				});

//			initReplyCKEditor();
			
			history.pushState({foo: "Post"},"",contextRoot + "/forum/topicPage/" + topicId);

			$('#topicContentDialog').modal('show');

	}
		
function getReplyListData(){

	var topicId = $("#addReplyForm input[name='topicId']").val();
	

	var replyurl = contextRoot + "/reply?pageSize=10&pageNum="
	+ replyListPageNum +"&topicId=" + topicId;
	
	var stageListObj = { stageList : [] };

	
	if(isReplyListHasNextPage){
		$.ajax({
			url : replyurl,
			type: "GET",
			async : false,
			success : function(data){

				var maxStage = 0;

				$(".replyList").each(function(index,element){
					maxStage= parseInt($(element).find('.stage-value').text());
				});
				

				for(let i=0 ; i<data.records.length ; i++){
					  data.records[i].stage = 'B' + (maxStage + i + 1);
					  data.records[i].stageValue = maxStage + i + 1;
					}
								
				$("#replyContentList").append(Mustache.render(replyListTemplate, data));

				// check whether has next page or not
				isReplyListHasNextPage = data.isHasNext;
			}

			});

		}

	}

function openAddTopicDialog() {

	console.log("Hello!");

	$('#addTopicDialog').modal('show');
}


function initTopicCKEditor(){
    // topic CKEditor 初始化
//             ClassicEditor
    BalloonEditor
    .create( document.querySelector( '#topicEditor' ),{
        placeholder: '在此輸入內容...',
        ckfinder: {
	                uploadUrl: contextRoot + "/uploadTopicImg"
	              }
    } )
    .then( editorInstance => {
    	topicEditor = editorInstance;
    })
    
    .catch( error => {
        console.error( error );
    });
}

function initReplyCKEditor(){
    // reply CKEditor 初始化
//             ClassicEditor
    BalloonEditor
    .create( document.querySelector( '#replyEditor' ),{
        placeholder: '在此輸入回覆...'
    } )
    .then( editorInstance => {
    	replyEditor = editorInstance;
        
        // 將輸入區綁定change事件(:data為僅限輸入值更動,不包含輸入區中工具列及滑鼠的任何操作)
    	replyEditor.model.document.on( 'change:data', () => {
//    			console.log( 'The Document has changed!' );

		         let lastTagText = getLastOuterTagText($(replyEditor.getData()));
		
		         atSignCheck(lastTagText);
		
		     });
        })
        
        .catch( error => {
            console.error( error );
        });
    }

function getLastOuterTagText(inputElements){
    /*
    * 輸入區中的"最外層"tag數量
    * ex:
    * <p> AAA </p>
    * <p> BBB <b>DDD</b> </p>
    * <p> CCC <b>EEE</b> </p>
    * 
    * 總共數量為3
    */
    let tagTotalNum = inputElements.length;

    let returnStr = "";
    
    // 將輸入區的"最外層"標籤一個一個取出來
    inputElements.each(function(index,element){

        // 只取最後一段標籤內的值檢查
        if((index + 1) == tagTotalNum){
            returnStr = $(element).text();
        }
    });

    return returnStr;
}

 // 檢查@是否出現於輸入區
function atSignCheck(text){
    let strLen = text.length;
    /*
    * 1.檢查輸入字串的長度是否為零(避免裁切字串出問題)
    * 2.檢查輸入字串最後一個字母是否為 '@'
    * 3.檢查倒數第二個字母是否為空白 (需空格後方可使用@功能)
    * 4.檢查輸入字串是否只有一個字母 (解決直接輸入@的情況)
    * 5.第二點為必要條件,三四點則符合其一及可啟動 
    */
    if (strLen != 0) {
        let atCheck = (text.substring(strLen - 1) == "@");
        let emptyCheck = (text.substring(strLen - 2,strLen - 1) == " ");
        let leadCheck = (strLen == 1);

        if (atCheck && (emptyCheck || leadCheck)) {
            showStageSelectDialog();
            
        }
    }

}

function showStageSelectDialog(){
    var stageListObj = { stageList : [] };

    $("#replyContentList .stage").each(function(index,element){
        stageListObj.stageList[index] = {stage : $(element).text()};
    });

    renderStageList(stageListObj);

    $('#stageListDialog').modal('show');
}

function renderStageList(stageListObj){
    $("#stage-list").html(""); // 先清空, 再渲染
    $("#stage-list").append(Mustache.render(stageListTemplate,stageListObj));
}

/*
 * 好友名單點擊某位好友後執行以下動作:
 * 1.將選擇的好友名稱回寫到輸入區域的尾端
 * 2.關閉好友名單
 */
function setStage(stageNum){
     let tagTotalNum = $(replyEditor.getData()).length;
             
     // 用於儲存輸入區的標籤
     // 並在最後一段標籤中偵測並修改
     let input = "";

     // 檢查是否有偵測到輸入@的事件
     let changeFlag = false;

     $(replyEditor.getData()).each(function(index,element){

         // 只取最後一段標籤內的值檢查
         if((index + 1) == tagTotalNum){

             let targetElement = $(element); 
             let originalText = targetElement.text();
             let strLen = originalText.length;

             let hasAtSign = originalText.lastIndexOf("@") == (strLen - 1);
             let modifiedText = hasAtSign ? originalText.substring(0,strLen - 1) : originalText; 
             modifiedText += getStageLink(stageNum);

             targetElement.html(modifiedText);

             input += targetElement.prop('outerHTML');
         } else {
             input += $(element).prop('outerHTML');
         }

     });

     replyEditor.setData(input);

     $('#stageListDialog').modal('hide');
}

function getStageLink(stageStr){
    return Mustache.render(stageLinkTemplate,{stage : stageStr});
}

function setCategoryId(catId, targetObj) {
	$(".list-group-item").removeClass("active");
	$(targetObj).addClass("active");

	categoryId = catId;
	topicListPageNum = 1;
	isTopicListHasNextPage = true;
	
	refreshTopicList();
}

function setTagType(tagTypeSrc) {
	tagType = tagTypeSrc;
	topicListPageNum = 1;
	isTopicListHasNextPage = true;
	
	refreshTopicList();
}

function clickAddTopic(){

	var url = contextRoot + "/topicPost";
	
	var content = topicEditor.getData();
	
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
	console.log($("#addTopicForm input[name='content']").val()); 
	console.log($(addTopicForm).serialize());

	var form = $(addTopicForm);
	console.log(form);
	

	$.ajax({
		url : url,
		type : "POST",
		async : false,
		data: form.serialize(),
		success : function(data) {
			console.log("data="+data);

			window.location.reload();
			

		}

	});

// 	        $("#content").val("");
// 	        topicEditor.setData("");
// 			$("input[name='title']").val("");
// 			$("input[name='isCover']").val("");
// 			$("input[name='categoryId']").val("");
    
    
	console.log("GoodBye!");

// 			$('#addTopicDialog').modal('hide')

	}

function clickAddReply(){

	var content = replyEditor.getData();
	
	var atStageList = [];
	var atUserIdListStr = "";
	$(content).find("a").each(function(index,element){
		if($(element).attr("href").indexOf("#B") != -1){
			// #B10 -> B10
			atStageList.push($(element).attr("href").substring(1));
		}
	});
	
	$(".replyList").each(function(index,element){
        for(let i=0 ; i<atStageList.length ; i++){
        	if($(element).find(".stage").text() == atStageList[i]){
        		atUserIdListStr += $(element).find(".reply-userId").text() + ",";
        	}
        }
    });
	
	
	
	if(atUserIdListStr.length != 0){
		atUserIdListStr = atUserIdListStr.substring(0,atUserIdListStr.length - 1);//cut the comma				
	}
	
	console.log(atUserIdListStr);
	
//	console.log($("#loginUsername"));
//	console.log($("#loginUserId"));
//	console.log("text = " + $("#loginUsername").text());
//	console.log("text = " + $("#loginUserId").text());
//	console.log("val = " + $("#loginUsername").val());
//	console.log("val = " + $("#loginUserId").val());
	
	$("#addReplyForm input[name='username']").val($("#loginUsername").text());
	$("#addReplyForm input[name='userId']").val($("#loginUserId").text());
	$("#addReplyForm input[name='replyContent']").val(content);
	$("#addReplyForm input[name='atUserIdList']").val(atUserIdListStr);
//	console.log($(addReplyForm).serialize());

	var url = contextRoot + "/replyPost";
	var form = $(addReplyForm);
	console.log($(addReplyForm).serialize());
	

	$.ajax({
		url : url,
		type : "POST",
		async : false,
		data: form.serialize(),
		success : function(data) {
				
				data.replyId = data.id;
				data.likeNum = 0;
				
				var maxStageValue = 0
				$(".stage-value").each(function(index, element){
					maxStageValue = parseInt($(element).text());
				})
				
				data.stageValue	= maxStageValue + 1;
				data.stage = "B" + (maxStageValue + 1);

				var replyListObj = {
						records : [data]
				};

				console.log(data);
					
			$("#replyContentList").append(Mustache.render(replyListTemplate, replyListObj));

		}

	});


    $("#replyContent").val("");
    replyEditor.setData("");
    
	console.log("GoodBye!");
	}

function clickTopicThumbsUp(topicId, targetObj){

	if($(targetObj).hasClass("checked")){

		var url = contextRoot + "/thumbsUp/topic/" + $("#loginUserId").text()+ "/" + topicId;
		
		console.log($(targetObj).hasClass("checked"));
		
		$.ajax({
			url : url,
			type : "DELETE",
			async : false,
			success : function(data) {
					$(targetObj).attr("class", "far fa-thumbs-up fa-2x");
					
					// stop working at topic content area
					if($(targetObj).attr("id") != "like"){
						var likeValue = parseInt($(targetObj).next().text());
						 likeValue--;
						 $(targetObj).next().text(likeValue);
					}
			
				}
			});
		
	}else{
		
		var url = contextRoot + "/thumbsUpPost";
		var dataObj = {
					type : "topic",
					topicId : topicId, 
					replyId : null,
					userId : $("#loginUserId").text(),
					username : $("#loginUsername").text(),	
					categoryId :1
				}
		console.log(dataObj);
		console.log($(targetObj).hasClass("checked"));
		
		$.ajax({
			url : url,
			type : "POST",
			async : false,
			data : JSON.stringify(dataObj),
			contentType : "application/json",
			success : function(data) {
						$(targetObj).attr("class", "fas checked  fa-thumbs-up fa-2x");
						
						// stop working at topic content area
						if($(targetObj).attr("id") != "like"){
							var likeValue = parseInt($(targetObj).next().text());
							 likeValue++;
							 $(targetObj).next().text(likeValue);
						}
				
					}
			});
			
		}
		
}

	function clickReplyThumbsUp(topicId, replyId, targetObj){

		if($(targetObj).hasClass("checked")){

		var url = contextRoot + "/thumbsUp/reply/" + $("#loginUserId").text()+ "/" + replyId;
		
		console.log($(targetObj).hasClass("checked"));
		
		$.ajax({
			url : url,
			type : "DELETE",
			async : false,
			success : function(data) {
				$(targetObj).attr("class", "far fa-heart fa-3x");
				 var likeValue = parseInt($(targetObj).next().text());
				 likeValue--;
				 $(targetObj).next().text(likeValue);
			
				}
			});
		
	}else{
		
		var url = contextRoot + "/thumbsUpPost";
		var dataObj = {
					type : "reply",
					topicId : topicId, 
					replyId : replyId,
					userId : $("#loginUserId").text(),
					username : $("#loginUsername").text(),	
					categoryId :1
				}
		console.log(dataObj);
		console.log($(targetObj).hasClass("checked"));
		
		$.ajax({
			url : url,
			type : "POST",
			async : false,
			data : JSON.stringify(dataObj),
			contentType : "application/json",
			success : function(data) {
					$(targetObj).attr("class", "fas checked  fa-heart fa-3x");
						 var likeValue = parseInt($(targetObj).next().text());
						 likeValue++;
						 $(targetObj).next().text(likeValue);
				
					}
			});
			
		}
		
}

	function clickTopicFollowed(topicId,targetObj){

		if($(targetObj).hasClass("checked")){

		var url = contextRoot + "/follow/" + $("#loginUserId").text()+ "/" + topicId;
		
		console.log($(targetObj).hasClass("checked"));
		
		$.ajax({
			url : url,
			type : "DELETE",
			async : false,
			success : function(data) {
				$(targetObj).attr("class", "far fa-bookmark fa-2x");
			
				}
			});
		}else{
			var url = contextRoot + "/followPost";
			var dataObj = {
					topicId : topicId, 
					userId : $("#loginUserId").text(),
					username :$("#loginUsername").text(),	
					}
			console.log(dataObj);

			console.log($(targetObj).hasClass("checked"));
	
			$.ajax({
				url : url,
				type : "POST",
				async : false,
				data : JSON.stringify(dataObj),
				contentType : "application/json",
				success : function(data) {
					$(targetObj).attr("class", "fas checked fa-bookmark fa-2x");
		
				}
		});
	}
		
}


function closeTopicContentDialog(topicId,targetObj){
	$('#topicContentDialog').modal('hide')
	}

function closeAddTopicDialog(topicId,targetObj){
	$('#addTopicDialog').modal('hide')
	}

function closeAddReportDialog(topicId,targetObj){
	$('#addReportDialog').modal('hide')
	}

function shareLine(){
	var shareUrl = "https://social-plugins.line.me/lineit/share?url=" + location.href;
    window.open(shareUrl,"_blank","left=400,top=200,width=750,height=500");
	}

function openAddReportDialog(topicId) {

	console.log("Hello!");
	$("#addReportForm input[name='topicId']").val(topicId);
	

	$('#addReportDialog').modal('show');
}

function clickAddReport(){

	var url = contextRoot + "/reportPost";
	var form = $(addReportForm);
	
	console.log($(addReportForm).serialize());

	

	$.ajax({
		url : url,
		type : "POST",
		async : false,
		data: form.serialize(),
		success : function(data) {
			console.log(data);

		}

	});
	console.log("GoodBye!");

	$('#addReportDialog').modal('hide')

}

function toggleActive(targetObj){
    $(targetObj).toggleClass("active");
}

function getFavorateCategory(){
	var userId =  parseInt($("#loginUserId").text());
	var categoryList = [];
	
	var url =contextRoot + "/myPage/favorateCategorylist";

	$.ajax({
		url: url,
	   type: "GET",
	   async: false,
	success: function(data){
			console.log(data)
		if(data.length==0){
			hasNotSetFavorateCategory=true;
		}else{
			hasNotSetFavorateCategory=false;
				
			}
		}
	});
}

function updateFavorateCategory(){
	var userId =  parseInt($("#loginUserId").text());
	var categoryList = [];
	
	$("#favorateCategoryList .active").each(function(index,element){
		categoryList.push({ userId: userId, categoryId: parseInt($(element).attr("value"))});
	});
	
	
	// TODO : need to defined
	var url =contextRoot + "/insertFavorateCategory";

	$.ajax({
		url: url,
	   type: "POST",
	   data: JSON.stringify(categoryList),
	   contentType: "application/json",
	success: function(data){
				alert("更新成功 !");
			}
	});
	$('#favorateCatgoryDialog').modal('hide');
	
}

function chooseLike(topicId,categoryId,targetObj){
	
	if($("#like").hasClass("checked")){
		// delete before insert
		var url = contextRoot + "/thumbsUp/topic/" + $("#loginUserId").text()+ "/" + topicId;
		
		$.ajax({
			url : url,
			type : "DELETE",
			async : false,
			success : function(data) {
						url = contextRoot + "/thumbsUpPost";
						var dataObj = {
									type : "topic",
									topicId : topicId, 
									replyId : null,
									userId : $("#loginUserId").text(),
									username : $("#loginUsername").text(),	
									categoryId : categoryId
								}
						
						$.ajax({
							url : url,
							type : "POST",
							async : false,
							data : JSON.stringify(dataObj),
							contentType : "application/json",
							success : function(data) {
								
										// show chosen like on #like
										$("#like").attr("class",$(targetObj).attr("class") + " checked");
									}
						});
					}
		});
	} else {
		var url = contextRoot + "/thumbsUpPost";
		var dataObj = {
					type : "topic",
					topicId : topicId, 
					replyId : null,
					userId : $("#loginUserId").text(),
					username : $("#loginUsername").text(),	
					categoryId : categoryId
				}
		
		$.ajax({
			url : url,
			type : "POST",
			async : false,
			data : JSON.stringify(dataObj),
			contentType : "application/json",
			success : function(data) {
				
						// show chosen like on #like
						$("#like").attr("class",$(targetObj).attr("class") + " checked");
					}
		});
	}
	
    
}

function showLikeArea(){
    $("#like-area").addClass("d-inline-block");
}

function hideLikeArea(){
    $("#like-area").removeClass("d-inline-block",3000);
}

