package com.happytail.reservation.model.dao;



import java.util.List;

import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.reservation.model.Evaluation;
import com.happytail.reservation.model.backView;




public interface EvaluationDao {
	
	Object save(Evaluation bean);
	
	List<Evaluation> queryAllEvaluation();
	
//	List<backView> queryAllEvaluationView();
	
	List<Evaluation> queryMyEvaluation(Integer id);
	
	Page<backView> getAllEvaluationlist(PageInfo pageinfo);
	
	
//	List<backView> queryByDateEvaluationView(String createMonth);
	
	Page<backView> queryByDateEvaluationView(String createMonth,PageInfo pageinfo);
	
	Double ScoreAvg();
	
	Evaluation updateEvaluation(Evaluation bean);
	
	Evaluation queryByEvaluationId(Integer evaluationId);
	
	Evaluation deleteByEvaluationId(Integer evaluationId);
	
	List<backView> queryByreservationId(Integer reservationId);
	
}
