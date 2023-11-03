package com.ikkat.los.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "runningnumber", schema = "public")
public class RunningNumberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long number;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "RunningNumberEntity [id=" + id + ", number=" + number + "]";
	}
	
	
	
	
}
