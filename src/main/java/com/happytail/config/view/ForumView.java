package com.happytail.config.view;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Configuration
public class ForumView {

	@Bean
	public View TopicListPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/forum/forumTop.jsp");
		return view;
	}
	
	
	@Bean
	public View TopicContentPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/forum/topicContent.jsp");
		return view;
	}
	


}

