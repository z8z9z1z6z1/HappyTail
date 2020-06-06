package com.happytail.shopping.model.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductBeanImageData;
import com.happytail.shopping.model.dao.ProductDao;


@Service
@Transactional
public class ProductService {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductDao dao;
	
	public ProductBean selectOne(int ProductId) {
		
		return dao.selectOne( ProductId);
	}
	
	public  List<ProductBean> selectAll(){
		return dao.selectAll();
	}
	
	public List<ProductBean> selectCategory(Integer categoryId){
		return dao.selectCategory(categoryId);
	}
	
	public List<ProductBean> selectSales(){
		return dao.selectSales();
	}
	
	public List<ProductBean> selectName(String name){
		return dao.selectName(name);
	}
	
	public List<ProductBean> selectPriceUp(){
		return dao.selectPriceUp();
	}
	
	public List<ProductBean> selectPriceDown(){
		return dao.selectPriceDown();
	}
	public long getRecordCounts() {
		return dao.getRecordCounts();
	}
	
	public String insert(ProductBean productBean){		
		return dao.insert(productBean);
	}
	
	public List<ProductBean> getAllProductsJson() {
		return dao.getAllProductsJson();
	}
	
	public List<ProductBeanImageData> getAllProductsImageDatasByCategory(int categoryId) {
		return dao.getAllProductsImageDatasByCategory(categoryId);
	}
	
	public List<ProductBeanImageData> getAllProductsImageDatas(){
		return dao.getAllProductsImageDatas();
	}
	
	public List<ProductBeanImageData> getAllProductsImageDatasByID(Integer productId){
		return dao.getAllProductsImageDatasByID(productId);
	}
	
	
}
