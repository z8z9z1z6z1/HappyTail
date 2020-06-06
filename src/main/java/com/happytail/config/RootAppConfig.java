package com.happytail.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.happytail.forum.model", 
		"com.happytail.shopping.model",
		"com.happytail.reservation.model", 
		"com.happytail.admin.model", 
		"com.happytail.member.model",
		"com.happytail.general.model"
		})
@Import(com.happytail.config.SpringWebSocketJavaConfig.class)
public class RootAppConfig {

	@Bean
	public DataSource dataSource() {
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		try {
			jndiBean.setJndiName("java:comp/env/jdbc/happytailDB");
			// server context.xml can find the Jndiname
			jndiBean.setProxyInterface(DataSource.class);
			// interface to use for the JNDI object
//			jndiBean.setLookupOnStartup(false);
			// ProxyInterface default is false
			jndiBean.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		// to look up and save
		DataSource ds = (DataSource) jndiBean.getObject();
		System.out.println("ds:" + ds);
		// to check if null or not
		return ds;
	}

	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		// LocalSessionFactoryBuilder for JAVA
		builder.addProperties(hibernateProperties());
		// setProperties might cover the original setting
		// could happen unknown exception so do not use it!!
		builder.scanPackages(new String[] { "com.happytail.forum.model", 
				"com.happytail.shopping.model",
				"com.happytail.reservation.model", 
				"com.happytail.admin.model", 
				"com.happytail.member.model",
				"com.happytail.general.model"
				});
		return builder.buildSessionFactory();
//		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
//		LocalSessionFactoryBean for xml
//		factory.setDataSource(dataSource());
//		factory.setPackagesToScan(new String[] { "model" });
//		factory.setHibernateProperties(additionalProperties());
//		return factory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2008Dialect");
//		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2012Dialect.class);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);

//		properties.put("hibernate.query.factory_class", org.hibernate.hql.internal.classic.ClassicQueryTranslatorFactory.class);

//		properties.put("hibernate.current_session_context_class", "thread");
//		properties.put("default_batch_fetch_size", 10);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}
