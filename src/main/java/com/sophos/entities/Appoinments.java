package com.sophos.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Appoinments")
public class Appoinments {
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="day_date",nullable=false)
	private LocalDate dayDate;
	
	@JsonFormat(pattern = "HH:mm")
	@Column(name = "HOUR")
	private LocalTime hour;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false,cascade=CascadeType.MERGE)
	@JoinColumn(name = "ID_TEST", nullable= true)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Test idTest;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false,cascade=CascadeType.MERGE)
	@JoinColumn(name = "ID_AFFILIATE", nullable= true)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Affiliates idAffiliate;
	
	
	
	public Appoinments() {
		super();
	}
	public Appoinments(Integer id, LocalDate dayDate, LocalTime hour, Test idTest, Affiliates idAffiliate) {
		super();
		this.id = id;
		this.dayDate = dayDate;
		this.hour = hour;
		this.idTest = idTest;
		this.idAffiliate = idAffiliate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDayDate() {
		return dayDate;
	}
	public void setDayDate(LocalDate dayDate) {
		this.dayDate = dayDate;
	}
	public LocalTime getHour() {
		return hour;
	}
	public void setHour(LocalTime hour) {
		this.hour = hour;
	}
	public Test getIdTest() {
		return idTest;
	}
	public void setIdTest(Test idTest) {
		this.idTest = idTest;
	}
	public Affiliates getIdAffiliate() {
		return idAffiliate;
	}
	public void setIdAffiliate(Affiliates idAffiliate) {
		this.idAffiliate = idAffiliate;
	}

	

	

	
	
}
