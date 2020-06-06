package com.happytail.reservation.model.dao;


import java.util.List;

import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;
import com.happytail.reservation.model.MyReservationView;
import com.happytail.reservation.model.ReservationBean;





public interface ReservationDao {

	ReservationBean save(ReservationBean bean);
	
	ReservationBean UpdateStatuss(ReservationBean bean);
	
	ReservationBean UpdateEvaluationStatus(ReservationBean bean);
	
//	List<MyReservationView> query(Integer Id);
	
	Page<MyReservationView> query(Integer Id,PageInfo pageinfo);
	
	List<MyReservationView> queryAllView();
	
	ReservationBean queryReservationBean(Integer reservationId);

	ReservationBean select(Integer reservationId);
}
