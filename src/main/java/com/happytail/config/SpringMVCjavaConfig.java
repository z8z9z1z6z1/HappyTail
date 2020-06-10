package com.happytail.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.happytail.forum.controller",
		"com.happytail.shopping.controller",
		"com.happytail.reservation.controller",
		"com.happytail.admin.controller",
		"com.happytail.member.controller",
		"com.happytail.general.controller"
		})
@Import({com.happytail.config.view.ReservationView.class,
	     com.happytail.config.view.MembersView.class,
	     com.happytail.config.view.AdminView.class,
	     com.happytail.config.view.ShopView.class,
	     com.happytail.config.view.ForumView.class})
public class SpringMVCjavaConfig implements WebMvcConfigurer {

	//Static Resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("test!!");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/static/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/static/img/");
		registry.addResourceHandler("/template/**").addResourceLocations("/WEB-INF/pages/template/");
		registry.addResourceHandler("/shopCss/**").addResourceLocations("/WEB-INF/pages/shop/shopCss/");
		registry.addResourceHandler("/shopJs/**").addResourceLocations("/WEB-INF/pages/shop/shopJs/");
		registry.addResourceHandler("/shopFonts/**").addResourceLocations("/WEB-INF/pages/shop/shopFonts/");
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/pages/shop/images/");
		//後台系統
		registry.addResourceHandler("/admin/**").addResourceLocations("/WEB-INF/static/admin/");
	}
	
	// for file upload
//	@Bean
//	public MultipartResolver multipartResolver() {
//		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//		resolver.setDefaultEncoding("UTF-8");
//		resolver.setMaxUploadSize(81920000);
//		return resolver;
//	}
	
	
	//測試用  暫時先關掉
	@Bean
	public MultipartResolver multipartResolver() {
		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
		

		return resolver;
	}
	
	
	//ViewResolver
	@Bean
	public ViewResolver beanNameViewResolver() {
		BeanNameViewResolver bnvr = new BeanNameViewResolver();
		bnvr.setOrder(0);
		return bnvr;
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("MemberMessage", "ValidationMessages");
		return messageSource;
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.remove(1);
		converters.add(1, new StringHttpMessageConverter(Charset.forName("UTF-8")));
//		WebMvcConfigurer.super.extendMessageConverters(converters);
	}
	
	
	
	
	
//	@Bean 
//	public InternalResourceViewResolver viewResolver() {
////		System.out.println("使用viewResolver() 方法  將網頁前面增加/WEB-INF/pet/");
////		System.out.println("網頁後面增加.jsp");
////		System.out.println("優先度為2，只低於DispatcherServletInitalizer");
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class); //預設就有  JSTL
//		viewResolver.setPrefix("/WEB-INF/pet/");
//		viewResolver.setSuffix(".jsp");
//		viewResolver.setOrder(2);
//		return viewResolver;
//	}
	
	
}