package com.happytail.reservation.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;
import com.happytail.reservation.model.Evaluation;
import com.happytail.reservation.model.backView;
import com.happytail.reservation.model.dao.EvaluationDao_impl;




@Service
@Transactional
public class EvaluationService {
	@Autowired
	private EvaluationDao_impl daoImpl;
	
	public Object save(Evaluation bean) {
		return daoImpl.save(bean);
	}
	
	public List<Evaluation> queryAllEvaluation(){
		return daoImpl.queryAllEvaluation();
	}
	
	public List<Evaluation> queryMyEvaluation(Integer id){
		return daoImpl.queryMyEvaluation(id);
	}
	
//	public List<backView> queryAllEvaluationView(){
//		return daoImpl.queryAllEvaluationView();
//	}
	
//	public List<backView> queryByDateEvaluationView(String createMonth){
//		return daoImpl.queryByDateEvaluationView(createMonth);
//	}
	
	public Double ScoreAvg() {
		return daoImpl.ScoreAvg();
	}
	
	public Page<backView> getAllEvaluationlist(PageInfo pageinfo){
		return daoImpl.getAllEvaluationlist(pageinfo);
	}
	
	public Page<backView> queryByDateEvaluationView(String createMonth, PageInfo pageinfo){
		return daoImpl.queryByDateEvaluationView(createMonth, pageinfo);
	}

	public Evaluation updateEvaluation(Evaluation bean) {
		return daoImpl.updateEvaluation(bean);
	}

	public Evaluation queryByEvaluationId(Integer evaluationId) {
		return daoImpl.queryByEvaluationId(evaluationId);
	}
	
	public Evaluation deleteByEvaluationId(Integer evaluationId) {
		return daoImpl.deleteByEvaluationId(evaluationId);
	}
	
	public List<backView> queryByreservationId(Integer reservationId){
		return daoImpl.queryByreservationId(reservationId);
	}
}
