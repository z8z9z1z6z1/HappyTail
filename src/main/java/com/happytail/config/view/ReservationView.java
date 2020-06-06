package com.happytail.config.view;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Configuration
public class ReservationView {

	@Bean
	public View reservationPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/reservation/index37.jsp");
		return view;
	}
	
	@Bean
	public View backReservationPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/reservation/backReservation.jsp");
		return view;
	}
	
	@Bean
	public View myReservationPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/reservation/myReservation.jsp");
		return view;
	}
	
	@Bean
	public View evaluationPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/reservation/evaluation37.jsp");
		return view;
	}

}
