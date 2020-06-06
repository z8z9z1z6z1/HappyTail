package com.happytail.config.view;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Configuration
public class MembersView {
	
	@Bean
	public View petMemberIndex() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/HappyTailIndex.jsp");
		return view;	
	}
	
	@Bean
	public View petMemberPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/memberRegister.jsp");
		return view;	
	}
	
	@Bean
	public View sendTemporaryPassword() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/sendTemporaryPassword_1.jsp");
		return view;	
	}
	
	@Bean
	public View temporaryPetMemberPage1() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/sendTemporaryPassword_1.jsp");
		return view;	
	}
	
	@Bean
	public View temporaryPetMemberPage2() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/sendTemporaryPassword_2.jsp");
		return view;	
	}
	
	@Bean
	public View redirectTemporaryPetMemberPage2() {
		RedirectView view = new RedirectView("/redirectTemporaryPetMemberPage2",true);		
		return view;	
	}
	
	
	@Bean
	public View changePassword() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/changePassword.jsp");
		return view;	
	}
	
	@Bean
	public View verificationSended() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/verificationSended.jsp");
		return view;	
	}
	
	@Bean
	public View redirectVerificationSended() {
		RedirectView view = new RedirectView("/redirectVerificationSended",true);		
		return view;	
	}
	

	@Bean
	public View verificationResult() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/verificationResult.jsp");
		return view;	
	}

	
	@Bean
	public View memberLogin() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/memberLogin.jsp");
		return view;	
	}
	
	@Bean
	public View accountStop() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/accountStop.jsp");
		return view;	
	}
	
	@Bean
	public View memberCRUD() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/member_CRUD.jsp");
		return view;	
	}

}
