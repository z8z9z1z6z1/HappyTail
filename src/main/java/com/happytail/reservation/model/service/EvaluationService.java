package com.happytail.reservation.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
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

	
}
