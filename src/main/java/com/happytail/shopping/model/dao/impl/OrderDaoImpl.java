package com.happytail.shopping.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.OrderItemBean;
import com.happytail.shopping.model.dao.OrderDao;

//本類別
//1.新增一筆訂單到orders表格
//2.查詢orders表格內的單筆訂單
//3.查詢orders表格內的所有訂單

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Session s() {
		return sessionFactory.getCurrentSession();
	}

	
	
	
	public OrderDaoImpl() {
		
	}

	//會員查詢自己的訂單
	@Override
	public List<OrderBean> selectOrderByMemberId(Integer Id){

		String hql = "from OrderBean o where o.memberId=:Id order by o.orderId desc";
		List<OrderBean> resultList
		= getSession().createQuery(hql,OrderBean.class).setParameter("Id", Id).getResultList();
		return resultList;
	}
	
	
	@Override
	public List<OrderBean> selectOrderByMemberIdNew(Integer Id){
		String state ="未付款";
		String hql = "from OrderBean o where o.memberId=:Id and o.state = :state order by o.orderId desc";
//		String hql2 = "from OrderBean o where o.memberId=:Id and o.state = :state order by o.orderId desc";
//		Query createQuery2 = s().createQuery(hql2);
		
		 Query<OrderBean> createQuery = getSession().createQuery(hql,OrderBean.class);
		 createQuery.setParameter("Id", Id);
		 createQuery.setParameter("state",  state );
		List<OrderBean> resultList =createQuery.getResultList();
		return resultList;
	}
	
	@Override
	public List<OrderBean> selectOrderByMemberIdOld(Integer Id){
		String state ="已付款";
		String hql = "from OrderBean o where o.memberId=:Id and o.state = :state order by o.orderId desc";
		Query<OrderBean> createQuery = getSession().createQuery(hql,OrderBean.class);
		 createQuery.setParameter("Id", Id);
		 createQuery.setParameter("state",  state );
		List<OrderBean> resultList =createQuery.getResultList();
		return resultList;
	}
	
	@Override
	public List<OrderItemBean> getOrderItemBean(OrderBean orderBean) {
		Integer id =orderBean.getOrderId();
		String hql ="from OrderItemBean where orderId=:id";
		List<OrderItemBean> resultList = s().createQuery(hql, OrderItemBean.class).setParameter("id", id).getResultList();
		
		return resultList;
		
	}
	

	// 查詢訂單 利用訂單編號OrderId
	@Override
	public OrderBean selectOrder(int orderId) {
		
		OrderBean select = getSession().get(OrderBean.class, orderId);

		return select;
	}
	
	//查詢所有訂單
	@Override
	public List<OrderBean> selectAllOrder(){
		String hql ="from OrderBean order by orderId DESC";
		Query<OrderBean> selectAllOrder = getSession().createQuery(hql,OrderBean.class);
				
		return selectAllOrder.list();
	}
	
	
	//查詢訂單 依照單一時間
	@Override
	public List<OrderBean> selectOrderByTime(String time){
		String hql="from OrderBean where orderDate=:time";
		Query<OrderBean> createQuery = s().createQuery(hql,OrderBean.class).setParameter("time", time);
		return createQuery.list();
	}
	
	

	// 取消訂單
	@Override
	public String cancel(int orderId) {
		
		String hql = "from OrderBean where  orderId=:orderId";
		Query<OrderBean> createQuery = getSession().createQuery(hql, OrderBean.class);
		createQuery.setParameter("orderId", orderId);
		OrderBean singleResult = createQuery.getSingleResult();
		OrderBean odBean = (OrderBean) singleResult;
		if (odBean != null) {
			odBean.setState("過期");
			getSession().save(odBean);
			return ("取消成功");
		}
		return "取消失敗";
	}

	// 更新訂單狀態→完成
	@Override
	public String complete(int orderId) {
		String hql = "from OrderBean where state = 未付款  and orderId=:orderId";
		Query<OrderBean> createQuery = getSession().createQuery(hql, OrderBean.class).setParameter("orderId", orderId);
		OrderBean singleResult = createQuery.getSingleResult();
		OrderBean odBean = (OrderBean) singleResult;
		if (odBean != null) {
			odBean.setState("完成");
			getSession().save(odBean);
			return ("訂單已送出");
		}
		return "找不到訂單";
	}

	// 更新訂單狀態→逾時
	@Override
	public String overtime(int orderId) {
		
		Object object = getSession().get("from OrderBean",OrderBean.class);
//		OrderBean singleResult = object.getSingleResult();

		OrderBean odBean = (OrderBean)object;
		if (odBean != null) {
			odBean.setState("過期");
			getSession().save(odBean);
			return ("訂單逾時");
		}
		return "找不到訂單";
	}
	
	
	@Override
	public String payMoney(int orderId) {
		String state="已付款";
		String hql="update OrderBean o set o.state=:state where o.orderId=:orderId";

		Query<?> createQuery = s().createQuery(hql);
		createQuery.setParameter("state", state);
		createQuery.setParameter("orderId", orderId);
		createQuery.executeUpdate();

		return "付款訂單";
	}
	
	//新增訂單
	@Override
	public String insert(OrderBean ob) {
//		OrderBean orderBean = getSession().get(OrderBean.class, ob.getOrderId());
		System.out.println("進入DAO");
		getSession().save(ob);
		
			return "訂單新增成功";
		
	}
	
	
	
	//取得訂單總數
	@Override
	public long selectOrderByCount(Integer memberId) {
		long count=0;
		String hql ="select count(*) from OrderBean where memberId:=memberId";
		Query<?> createQuery = s().createQuery(hql,OrderBean.class);
		Object singleResult = createQuery.getSingleResult();
		count= (long)singleResult;
		
		if(count==0) {
			return 0 ;
		}
		return count;
	}
	
	@Override
	@SuppressWarnings("unchecked") //使用 @SuppressWarnings 來排除警告
	public List<OrderBean> getAllOrderJson()  {
		List<OrderBean> list = new ArrayList<>();
		String hql = "FROM OrderBean";
		
		list = s().createQuery(hql).getResultList();
		return list;
	}
	
	//取得全部的訂單
	@Override
	public List<OrderItemBean> getOib(Integer mId,Integer oId){
		String hql ="from OrderItemBean where orderBean.orderId=:oId and orderBean.memberId=:mId ";
		System.out.println("進入dao");
		System.out.println("mId="+mId+" oId="+oId);
		Query<OrderItemBean> createQuery = s().createQuery(hql,OrderItemBean.class);
		createQuery.setParameter("oId", oId);
		createQuery.setParameter("mId", mId);
//		System.out.println("oId="+oId+" mId="+mId);
		List<OrderItemBean> resultList = createQuery.getResultList();
		System.out.println(resultList.size());
		
		if(resultList.size()==0) {
			return null ;
		}
		return resultList;
	}
	
	
	//取得全部付款的訂單
	@Override
	public List<OrderItemBean> getOibNew(Integer mId,Integer oId){
		String hql =
				"from OrderItemBean "
				+ "where orderBean.orderId=:oId and "
				+ "orderBean.memberId=:mId  order by orderBean.orderId desc";
		System.out.println("進入dao");
		System.out.println("mId="+mId+" oId="+oId);
		Query<OrderItemBean> createQuery = s().createQuery(hql,OrderItemBean.class);
		createQuery.setParameter("oId", oId);
		createQuery.setParameter("mId", mId);
//		System.out.println("oId="+oId+" mId="+mId);
		List<OrderItemBean> resultList = createQuery.getResultList();
		System.out.println(resultList.size());
		
		if(resultList.size()==0) {
			return null ;
		}
		return resultList;
	}
	
	//取得全部付款的訂單
		@Override
		public List<OrderItemBean> getOibOld(Integer mId,Integer oId){
			String hql =
					"from OrderItemBean "
					+ "where orderBean.orderId=:oId and "
					+ "orderBean.memberId=:mId  order by orderBean.orderId desc";
			System.out.println("進入dao");
			System.out.println("mId="+mId+" oId="+oId);
			Query<OrderItemBean> createQuery = s().createQuery(hql,OrderItemBean.class);
			createQuery.setParameter("oId", oId);
			createQuery.setParameter("mId", mId);
//			System.out.println("oId="+oId+" mId="+mId);
			List<OrderItemBean> resultList = createQuery.getResultList();
			System.out.println(resultList.size());
			
			if(resultList.size()==0) {
				return null ;
			}
			return resultList;
		}
	
	
	
	
}
