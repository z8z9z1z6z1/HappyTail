package com.happytail.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.happytail.admin.model.service.AdminForumService;
import com.happytail.forum.model.ReportlistView;
import com.happytail.forum.model.Topic;
import com.happytail.forum.model.service.FourmMemberService;

@Controller
public class AdminForumController {
	
	@Autowired
	AdminForumService forumService;
	
	@Autowired
	FourmMemberService fourmMemberService;	
	
	//討論區管理
	@GetMapping(value = "admin-forum")
	public String adminForum() {
		return "adminForum";
	}
	
	//所有檢舉Json
	@GetMapping(value = "admin-allReportJson")
	public ResponseEntity<List<ReportlistView>> allReportJson() {
		List<ReportlistView> list = forumService.allReportlist();
		ResponseEntity<List<ReportlistView>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	//單一文章
	@GetMapping(value = "admin-singleTopic/{id}", produces= {"application/json"})
	public ResponseEntity<List<Topic>> singleTopic(@PathVariable Integer id, Topic topic) {
		List<Topic> list = forumService.singleTopic(id);
		ResponseEntity<List<Topic>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	//刪除文章
	@PostMapping(value =  "admin-deleteTopic/{id}")
	public ResponseEntity<String> deleteTopic(@PathVariable Integer id) {
		ResponseEntity<String> re = new ResponseEntity<>("1", HttpStatus.OK);
		fourmMemberService.deleteTopic(id);
		return re;		
	}
	

}
