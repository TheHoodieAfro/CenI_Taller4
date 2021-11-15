package com.taller.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the salesorderheadersalesreason database table.
 * 
 */
@Entity
@NamedQuery(name="Salesorderheadersalesreason.findAll", query="SELECT s FROM Salesorderheadersalesreason s")
public class Salesorderheadersalesreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalesorderheadersalesreasonPK id;

	private Timestamp modifieddate;

	//bi-directional many-to-one association to Salesorderheader
	@ManyToOne
	@JoinColumn(name="salesorderid")
	private Salesorderheader salesorderheader;

	//bi-directional many-to-one association to Salesreason
	@ManyToOne
	@JoinColumn(name="salesreasonid")
	private Salesreason salesreason;

	public Salesorderheadersalesreason() {
	}

	public SalesorderheadersalesreasonPK getId() {
		return this.id;
	}

	public void setId(SalesorderheadersalesreasonPK id) {
		this.id = id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Salesorderheader getSalesorderheader() {
		return this.salesorderheader;
	}

	public void setSalesorderheader(Salesorderheader salesorderheader) {
		this.salesorderheader = salesorderheader;
	}

	public Salesreason getSalesreason() {
		return this.salesreason;
	}

	public void setSalesreason(Salesreason salesreason) {
		this.salesreason = salesreason;
	}

}