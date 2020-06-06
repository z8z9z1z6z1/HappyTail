package com.happytail.forum.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.forum.model.Favorate;
import com.happytail.forum.model.Follow;
import com.happytail.forum.model.Topic;
import com.happytail.forum.model.TopiclistView;
import com.happytail.forum.model.dao.FavorateDAO;
import com.happytail.forum.model.dao.FollowDAO;
import com.happytail.forum.model.dao.HistoryDAO;
import com.happytail.forum.model.dao.ThumbsUpDAO;
import com.happytail.forum.model.dao.TopicDAO;
import com.happytail.forum.model.dao.TopiclistViewDAO;
import com.happytail.general.model.CodeMap;
import com.happytail.general.model.Notice;
import com.happytail.general.model.dao.CodeMapDAO;
import com.happytail.general.model.dao.NoticeDAO;
import com.happytail.general.util.Const;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;

@Service
@Transactional
public class FourmMemberService {

	@Autowired
	private PetMembersDAO petMembersDAO;

	@Autowired
	private TopiclistViewDAO topiclistViewDAO;

	@Autowired
	private FollowDAO followDAO;

	@Autowired
	private ThumbsUpDAO thumbsUpDAO;

	@Autowired
	private FavorateDAO favorateDAO;

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private TopicDAO topicDAO;

	@Autowired
	private HistoryDAO historyDAO;
	
	@Autowired
	private CodeMapDAO codeMapDAO;

	// get my topiclist
	public Page<TopiclistView> getMemberIdTopiclist(Integer userId, PageInfo pageInfo) {
		return topiclistViewDAO.getMemberIdTopiclist(userId, pageInfo);
	}

	// get my followlist
	public Page<TopiclistView> getMyFollowlist(Integer userId, PageInfo pageInfo) {

		List<Integer> list = followDAO.selectTopicIdList(userId);
		return topiclistViewDAO.getFollowOrThumbsUpOrHistorylist(list, pageInfo);
	}

	// get my thumbsUplist
	public Page<TopiclistView> getMyThumbsUplist(Integer userId, String type, PageInfo pageInfo) {
		List<Integer> list = thumbsUpDAO.selectTopicIdList(userId);
		return topiclistViewDAO.getFollowOrThumbsUpOrHistorylist(list, pageInfo);
	}

	// get my read history list
	public Page<TopiclistView> getMyReadHistorylist(Integer userId, PageInfo pageInfo) {
		List<Integer> list = historyDAO.selectTopicIdList(userId);
		return topiclistViewDAO.getFollowOrThumbsUpOrHistorylist(list, pageInfo);
	}

	// get my favorate category
	public List<CodeMap> getMyFavorateCategory(Integer userId) {
		 List<Integer> list = favorateDAO.selectCategoryIdList(userId);
		 return codeMapDAO.getMyFavorateCategorylist(list, Const.ModuleType.Forum, Const.CategoryType.topicCategory);
	}
	// get all my forum notice
	public Page<Notice> getAllMyForumNotice(String module, Integer userId, PageInfo pageInfo) {
		return noticeDAO.getAllNoticelist(userId, module, pageInfo);
	}

	// get topic content
	public Topic getTopicContent(PetMembers petMembers, Integer id) {

		return topicDAO.select(id);
	}

	// update topic
	public void updateTopic(Topic topic, Integer topicId) {
		
//		Topic bean = topicDAO.select(topic.getId());
		Topic bean = topicDAO.select(topicId);
		if (bean != null) {
			bean.setCategoryId(topic.getCategoryId());
			bean.setTitle(topic.getTitle());
			bean.setContent(topic.getContent());
			
			topicDAO.update(bean);
			System.out.println("Update topic");
		}else {
		
		System.out.println("Update fail");
		}
	}

	// delete topic
	public void deleteTopic(Integer id) {

		topicDAO.delete(id);
	}

	// update my favorate category(via delete all and save again)
	public void refereshFavorateCategory(List<Favorate> list, PetMembers petMembers,Integer userId) {

//		favorateDAO.delete(petMembers.getId());
		favorateDAO.delete(userId);
		System.out.println("userId="+userId);

		for (Favorate favorate : list) {
			favorateDAO.insert(favorate);
		}
	}

	// delete thumbsUp
	public void removeThumbsUp(String type, Integer topicId, PetMembers petMembers, Integer userId) {

		if (type.equals("topic")) {
//			thumbsUpDAO.deleteTopicThumbsUp(type, petMembers.getId(), topicId);
			thumbsUpDAO.deleteTopicThumbsUp(type, userId, topicId);
			System.out.println("delete topic thumbsUp");
		} 
		System.out.println("delete fail");

	}

	// delete history record
	public void removeHistory(PetMembers petMembers, Integer topicId, Integer userId) {
//		 historyDAO.delete(topicId, petMembers.getId());
		 historyDAO.delete(topicId, userId);
	}

	// update follow status
	public void removeFollow(Integer topicId, PetMembers petMembers, Integer userId) {

//		Follow follow = followDAO.select(topicId, petMembers.getId());
		Follow follow = followDAO.select(topicId, userId);
		if (follow != null) {
			follow.setStatus(false);
			followDAO.update(follow);
			System.out.println("Update follow status");
		}

		System.out.println("Update fail");
	}

	// update per notice isRead status
	public void updateIsReadStatus(Integer noticeId) {
		
		Notice notice = noticeDAO.select(noticeId);
		notice.setIsRead(true);
		noticeDAO.update(notice);
	}

	// update per notice isRead status
	public void updateAllIsReadStatus(PetMembers petMembers, Integer userId) {

//		Notice notice = noticeDAO.selectByUserId(petMembers.getId());
//		Notice notice = noticeDAO.selectByUserId(userId);
		
		List<Notice> noticeList= noticeDAO.selectByModule(userId, Const.ModuleType.Forum);
		System.out.println(userId);
		System.out.println(noticeList);
		for(Notice notice : noticeList) {
		
		notice.setIsRead(true);
		noticeDAO.update(notice);
		
		}
	}


}
