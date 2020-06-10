package com.happytail.forum.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.happytail.forum.model.Favorate;
import com.happytail.forum.model.Follow;
import com.happytail.forum.model.Reply;
import com.happytail.forum.model.ReplylistView;
import com.happytail.forum.model.Report;
import com.happytail.forum.model.ThumbsUp;
import com.happytail.forum.model.ThumbsUpView;
import com.happytail.forum.model.Topic;
import com.happytail.forum.model.TopicImage;
import com.happytail.forum.model.TopiclistView;
import com.happytail.forum.model.dao.TopicImageDAO;
import com.happytail.forum.model.service.ForumService;
import com.happytail.forum.model.service.FourmMemberService;
import com.happytail.forum.model.service.LimitPostService;
import com.happytail.general.model.CodeMap;
import com.happytail.general.model.Notice;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;

@Controller
@SessionAttributes("petMembers")
public class TestController {

	@Autowired
	private ForumService forumService;

	@Autowired
	private FourmMemberService fourmMemberService;

	@Autowired
	private LimitPostService limitPostService;
	
	@GetMapping("/forum/topiclist")
	public String getTopicListPage(@RequestParam(required = false) Integer categoryId,
								   @RequestParam(required = false) String tagType,
								   @RequestParam String isForumArea,
								Model model) {
//		if ("hit".equals(tagType)) {
//			Page<TopiclistView> list = forumService.getHitTopicList(categoryId, new PageInfo(pageSize, pageNum));
//			System.out.println("topiclist"+list.getRecords());
//			model.addAttribute("topiclist",list);
//			return "TopicListPage";
//		} else {
//			Page<TopiclistView> list = forumService.getTopicList(petMembers, categoryId, new PageInfo(pageSize, pageNum));
//			System.out.println("topiclist"+list.getRecords().indexOf(list));
//			System.out.println("topiclist"+list.getRecords());
//			model.addAttribute("topiclist",list);
//			return "TopicListPage";
//		}
		
		model.addAttribute("categoryId",categoryId != null ? categoryId : "null");
		model.addAttribute("tagType",tagType != null ? tagType : "null");
		model.addAttribute("isForumArea", isForumArea != null ? isForumArea : "null");
		
		return "TopicListPage";
	}
	
	@GetMapping("/forum/topicPage/{topicId}")
	public String getTopic(@PathVariable Integer topicId,
			Model model) {
		
		model.addAttribute("isForumArea", true);
		
		return "TopicListPage";
	}
	
	@GetMapping("/topic/topiclist")
	@ResponseBody
	public Page<TopiclistView> getTopicList(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam(required = false) Integer categoryId, @RequestParam Integer pageSize,
			@RequestParam Integer pageNum, @RequestParam(required = false, name = "tagType") String tagType) {
		if ("hit".equals(tagType)) {
			return forumService.getHitTopicList(petMembers, categoryId, new PageInfo(pageSize, pageNum));
		} else {
			return forumService.getTopicList(petMembers, categoryId, new PageInfo(pageSize, pageNum));
		}
	}
	
	
	
	@GetMapping("/forum/topic/{topicId}")
	public String TopicContentPage(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer topicId) {
		return "TopicContentPage";

	}

	@GetMapping("/topic/{topicId}")
	@ResponseBody
	public Topic TopicContent(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer topicId, Model model) {
		model.addAttribute("topicId", topicId != null ? topicId : "null");

		return forumService.getTopicContent(petMembers, topicId);
	}

	
	
	
	
	
	
	
	@GetMapping("/topic/category")
	public List<CodeMap> CategoryList() {
		return forumService.getCategoryList();
	}

	@PostMapping("/insertFavorateCategory")
	@ResponseBody
	public Map<String, String> insertFavorateCategory(@SessionAttribute(required = false) PetMembers petMembers, @RequestBody List<Favorate> list) {
		Map<String, String> map = new HashMap<String, String>();
		forumService.addFavorate(petMembers, list);
		map.put("insert", "success");
		return map;
	}


	
	@GetMapping("/reply")
	@ResponseBody
	public Page<ReplylistView> ReplyList(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam Integer topicId, @RequestParam Integer pageSize, @RequestParam Integer pageNum) {

		return forumService.getReplyList(petMembers, topicId, new PageInfo(pageSize, pageNum));
	}

	@GetMapping("/thumbsUp")
	public List<ThumbsUpView> ThumbsUpList(@RequestParam Integer topicId) {
		return forumService.getThumbsUpList(topicId);
	}

	@PostMapping("/topicPost")
	@ResponseBody
	public Topic addTopic(@ModelAttribute Topic topic,@RequestParam(required = false) List<String> imgList, @RequestParam(defaultValue = "false") Boolean isCover) {
		// TODO : Add image source to TopicImage
//		topic = forumService.addTopic(topic);
//
//		for(String imgSrc : imgList) {
//			System.out.println("imgSrc=" + imgSrc);
//
//			TopicImage topicImage = new TopicImage();
//			topicImage.setTopidId(topic.getId());
//			topicImage.setImageUrl(imgSrc);
//			forumService.addTopicImage(topicImage);
//			
		
		
//		}
		
		System.out.println(topic);
		return forumService.addTopic(topic, imgList, isCover);
	}

	@PostMapping("/replyPost")
	@ResponseBody
	public Reply addReply(@ModelAttribute Reply reply) {
		return forumService.addReply(reply);
	}

	@PostMapping("/thumbsUpPost")
	@ResponseBody
	public ThumbsUp addThumbsUp(@RequestBody ThumbsUp thumbsUp) {
		return forumService.addThumbsUp(thumbsUp, thumbsUp.getReplyId());
	}

	@PostMapping("/followPost")
	@ResponseBody
	public Follow addFollowTopic(@RequestBody Follow follow) {
		return forumService.addFollowTopic(follow);
	}

	@PostMapping("/reportPost")
	@ResponseBody
	public Report addReport(@ModelAttribute Report report) {
		return forumService.addReport(report);
	}

	@DeleteMapping("/thumbsUp/{type}/{userId}/{targetId}")
	@ResponseBody
	public Boolean removeThumbsUp(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer targetId, @PathVariable String type, @PathVariable Integer userId) {
		forumService.removeThumbsUp(type, targetId, userId);
		return true;
	}

	@DeleteMapping("/follow/{userId}/{topicId}")
	@ResponseBody
	public Boolean removeFollow(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer topicId, @PathVariable Integer userId) {
		forumService.removeFollow(topicId, userId);
		return true;
	}

	@PutMapping("/notice/{noticeId}")
	@ResponseBody
	public Boolean updateIsReadStatus(@PathVariable Integer noticeId) {
		forumService.updateIsReadStatus(noticeId);
		return true;

	}

	@GetMapping("/myPage/topiclist")
	@ResponseBody
	public Page<TopiclistView> getMyTopiclist(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam Integer pageSize, @RequestParam Integer pageNum,
			@RequestParam(required = false) String type, @RequestParam(name = "tagType") String tagType) {

		if ("myTopiclist".equals(tagType)) {

			return fourmMemberService.getMemberIdTopiclist(petMembers.getId(), new PageInfo(pageSize, pageNum));

		} else if ("myFollowlist".equals(tagType)) {

			return fourmMemberService.getMyFollowlist(petMembers.getId(), new PageInfo(pageSize, pageNum));

		} else if ("myThumbsUplist".equals(tagType)) {

			return fourmMemberService.getMyThumbsUplist(petMembers.getId(), type, new PageInfo(pageSize, pageNum));

		} else if ("myReadHistorylist".equals(tagType)) {
			return fourmMemberService.getMyReadHistorylist(petMembers.getId(), new PageInfo(pageSize, pageNum));
		}

		return new Page<TopiclistView>();
	}

	@GetMapping("/myPage/favorateCategorylist")
	@ResponseBody
	public List<CodeMap> getFavorateCategory(@SessionAttribute(required = false) PetMembers petMembers) {

		return fourmMemberService.getMyFavorateCategory(petMembers.getId());
	}

	@GetMapping("/myPage/forumNotice")
	@ResponseBody
	public Page<Notice> getMyForumNotice(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam String module,  @RequestParam Integer pageSize,
			@RequestParam Integer pageNum) {

		return fourmMemberService.getAllMyForumNotice(petMembers.getId(), module, new PageInfo(pageSize, pageNum));
	}
	
	@GetMapping("/myPage/topicContent/{topicId}")
	public Topic getTopicContent(@SessionAttribute(required = false) PetMembers petMembers
							, @PathVariable Integer topicId) {
		return fourmMemberService.getTopicContent(petMembers, topicId);
	}
	
	
	
	
	@PostMapping("/myPage/UpdateOrDeleteTopic/{topicId}")
	@ResponseBody
	public Topic UpdateOrDeleteTopic(@SessionAttribute(required = false) PetMembers petMembers
							,  @PathVariable Integer topicId
							, @ModelAttribute Topic topic
							,@RequestParam (name = "action") String action
							) {
		System.out.println("Update start");
		System.out.println("action=" + action);
		System.out.println("topicId=" + topicId);
		System.out.println("topic.getCategoryId=" + topic.getCategoryId());
		System.out.println("topic=" + topic);
		
		topic.setId(topicId);
		

		if("delete".equals(action)){
			fourmMemberService.deleteTopic(topicId);

		}else if("update".equals(action)){
	
			return fourmMemberService.updateTopic(topic);
		}
		
		return	null;

	}
	
	@PostMapping("/myPage/UpdateFavorateCategory/{userId}")
	@ResponseBody
	public void UpdateFavorateCategory(@SessionAttribute(required = false) PetMembers petMembers
			, @RequestBody List<Favorate> list, @PathVariable Integer userId) {
		fourmMemberService.refereshFavorateCategory(list, petMembers, userId);
	}
	
	@DeleteMapping("/myPage/removeThumbsUp/{type}/{userId}/{topicId}")
	@ResponseBody
	public Map<String,String> removeThumbsUpViaMyPage(@SessionAttribute PetMembers petMembers,
			@PathVariable Integer topicId, @PathVariable String type, @PathVariable Integer userId) {
		fourmMemberService.removeThumbsUp(type, topicId, petMembers, userId);
		
		return Collections.singletonMap("status", "delete success");
	}
	
	@DeleteMapping("/myPage/removeHistory/{userId}/{topicId}")
	@ResponseBody
	public void removeThumbsUpViaMyPage(@SessionAttribute PetMembers petMembers,
			@PathVariable Integer topicId, @PathVariable Integer userId) {
		fourmMemberService.removeHistory(petMembers, topicId, userId);
	}
	
	@DeleteMapping("/myPage/removeFollow/{userId}/{topicId}")
	@ResponseBody
	public void removeFollowViaMyPage(@SessionAttribute PetMembers petMembers,
			@PathVariable Integer topicId, @PathVariable Integer userId) {
	fourmMemberService.removeFollow(topicId, petMembers, userId);
	}
	
	@PostMapping("/myPage/notice/{noticeId}")
	@ResponseBody
	public void updateIsReadStatusViaMyPage(@SessionAttribute(required = false) PetMembers petMembers, @PathVariable Integer noticeId) {
		fourmMemberService.updateIsReadStatus(noticeId);

	}
	
	@PostMapping("/myPage/notice")
	@ResponseBody
	public void updateAllIsReadStatusViaMyPage(@SessionAttribute(required = false) PetMembers petMembers) {
		fourmMemberService.updateAllIsReadStatus(petMembers);

	}
	
	@GetMapping("/topNotice/{userId}")
	@ResponseBody
	public List<Notice> NoticeList(@SessionAttribute(required = false) PetMembers petMembers, @PathVariable Integer userId ){
		return forumService.getMemberNoticeList(userId);
	}
	
	
}
