package com.happytail.reservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Evaluation")
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer evaluationId;
	private Integer reservationId; 
	private Integer Id;
	private Double score;
	private String content;
	
	public Integer getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(Integer evaluationId) {
		this.evaluationId = evaluationId;
	}
	public Integer getReservationId() {
		return reservationId;
	}
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
