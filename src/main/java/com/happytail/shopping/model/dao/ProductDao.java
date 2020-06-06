package com.happytail.shopping.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductBeanImageData;



public interface ProductDao {

	Session getSession();

	void setId(Integer id);

	ProductBean selectOne(int ProductId);

	List<ProductBean> selectAll();

	List<ProductBean> selectCategory(Integer categoryId);

	List<ProductBean> selectSales();

	List<ProductBean> selectName(String name);

	List<ProductBean> selectPriceUp();
	//用價格去選  從低到高

	List<ProductBean> selectPriceDown();

	long getRecordCounts();

	String insert(ProductBean productBean);
	//取得ArrayList

	List<ProductBean> getAllProductsJson();

	//取得有照片的產品
	List<ProductBeanImageData> getAllProductsImageDatasByCategory(int categoryId);

	

	List<ProductBeanImageData> getAllProductsImageDatas();

	List<ProductBeanImageData> getAllProductsImageDatasByID(Integer productId);

}