package com.taller.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;


/**
 * The persistent class for the transactionhistory database table.
 * 
 */
@Entity
@NamedQuery(name="Transactionhistory.findAll", query="SELECT t FROM Transactionhistory t")
public class Transactionhistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSACTIONHISTORY_TRANSACTIONID_GENERATOR",allocationSize = 1, sequenceName="TRANSACTIONHISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSACTIONHISTORY_TRANSACTIONID_GENERATOR")
	private Integer transactionid;

	@Min(value = 1)
	private BigDecimal actualcost;

	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modifieddate;

	@Min(value = 1)
	private Integer quantity;

	private Integer referenceorderid;

	private Integer referenceorderlineid;

	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate transactiondate;

	private String transactiontype;

	//bi-directional many-to-one association to Product
	@NotNull
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	public Transactionhistory() {
	}

	public Integer getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(Integer transactionid) {
		this.transactionid = transactionid;
	}

	public BigDecimal getActualcost() {
		return this.actualcost;
	}

	public void setActualcost(BigDecimal actualcost) {
		this.actualcost = actualcost;
	}

	public LocalDate getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getReferenceorderid() {
		return this.referenceorderid;
	}

	public void setReferenceorderid(Integer referenceorderid) {
		this.referenceorderid = referenceorderid;
	}

	public Integer getReferenceorderlineid() {
		return this.referenceorderlineid;
	}

	public void setReferenceorderlineid(Integer referenceorderlineid) {
		this.referenceorderlineid = referenceorderlineid;
	}

	public LocalDate getTransactiondate() {
		return this.transactiondate;
	}

	public void setTransactiondate(LocalDate transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getTransactiontype() {
		return this.transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}