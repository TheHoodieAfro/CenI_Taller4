package com.taller.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

/**
 * The persistent class for the product database table.
 *
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCT_PRODUCTID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCTID_GENERATOR")
	private Integer productid;

	@Column(name = "class")
	private String class_;

	private String color;

	private Integer daystomanufacture;

	private Timestamp discontinueddate;

	private String finishedgoodsflag;

	private BigDecimal listprice;

	private String makeflag;

	private Timestamp modifieddate;

	private String name;

	private String productline;
	
	@NotBlank(groups = {info.class})
	private String productnumber;

	private Integer reorderpoint;

	private Integer rowguid;

	private Integer safetystocklevel;

	private Timestamp sellenddate;

	private Timestamp sellstartdate;

	private String size;

	private BigDecimal standardcost;

	private String style;

	private BigDecimal weight;

	// bi-directional many-to-one association to Productsubcategory
	@ManyToOne
	@JoinColumn(name = "productsubcategoryid")
	private Productsubcategory productsubcategory;

	// bi-directional many-to-one association to Unitmeasure
	@ManyToOne
	@JoinColumn(name = "sizeunitmeasurecode")
	private Unitmeasure unitmeasure1;

	// bi-directional many-to-one association to Unitmeasure
	@ManyToOne
	@JoinColumn(name = "weightunitmeasurecode")
	private Unitmeasure unitmeasure2;

	// bi-directional many-to-one association to Productdocument
	@OneToMany(mappedBy = "product")
	private List<Productdocument> productdocuments;

	// bi-directional many-to-one association to Transactionhistory
	@OneToMany(mappedBy = "product")
	private List<Transactionhistory> transactionhistories;

	public Product() {
	}

	public Productdocument addProductdocument(Productdocument productdocument) {
		getProductdocuments().add(productdocument);
		productdocument.setProduct(this);

		return productdocument;
	}

	public Transactionhistory addTransactionhistory(Transactionhistory transactionhistory) {
		getTransactionhistories().add(transactionhistory);
		transactionhistory.setProduct(this);

		return transactionhistory;
	}

	public String getClass_() {
		return this.class_;
	}

	public String getColor() {
		return this.color;
	}

	public Integer getDaystomanufacture() {
		return this.daystomanufacture;
	}

	public Timestamp getDiscontinueddate() {
		return this.discontinueddate;
	}

	public String getFinishedgoodsflag() {
		return this.finishedgoodsflag;
	}

	public BigDecimal getListprice() {
		return this.listprice;
	}

	public String getMakeflag() {
		return this.makeflag;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Productdocument> getProductdocuments() {
		return this.productdocuments;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public String getProductline() {
		return this.productline;
	}

	public String getProductnumber() {
		return this.productnumber;
	}

	public Productsubcategory getProductsubcategory() {
		return this.productsubcategory;
	}

	public Integer getReorderpoint() {
		return this.reorderpoint;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Integer getSafetystocklevel() {
		return this.safetystocklevel;
	}

	public Timestamp getSellenddate() {
		return this.sellenddate;
	}

	public Timestamp getSellstartdate() {
		return this.sellstartdate;
	}

	public String getSize() {
		return this.size;
	}

	public BigDecimal getStandardcost() {
		return this.standardcost;
	}

	public String getStyle() {
		return this.style;
	}

	public List<Transactionhistory> getTransactionhistories() {
		return this.transactionhistories;
	}

	public Unitmeasure getUnitmeasure1() {
		return this.unitmeasure1;
	}

	public Unitmeasure getUnitmeasure2() {
		return this.unitmeasure2;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public Productdocument removeProductdocument(Productdocument productdocument) {
		getProductdocuments().remove(productdocument);
		productdocument.setProduct(null);

		return productdocument;
	}
	
	public Transactionhistory removeTransactionhistory(Transactionhistory transactionhistory) {
		getTransactionhistories().remove(transactionhistory);
		transactionhistory.setProduct(null);

		return transactionhistory;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDaystomanufacture(Integer daystomanufacture) {
		this.daystomanufacture = daystomanufacture;
	}

	public void setDiscontinueddate(Timestamp discontinueddate) {
		this.discontinueddate = discontinueddate;
	}

	public void setFinishedgoodsflag(String finishedgoodsflag) {
		this.finishedgoodsflag = finishedgoodsflag;
	}

	public void setListprice(BigDecimal listprice) {
		this.listprice = listprice;
	}

	public void setMakeflag(String makeflag) {
		this.makeflag = makeflag;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductdocuments(List<Productdocument> productdocuments) {
		this.productdocuments = productdocuments;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public void setProductsubcategory(Productsubcategory productsubcategory) {
		this.productsubcategory = productsubcategory;
	}

	public void setReorderpoint(Integer reorderpoint) {
		this.reorderpoint = reorderpoint;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSafetystocklevel(Integer safetystocklevel) {
		this.safetystocklevel = safetystocklevel;
	}

	public void setSellenddate(Timestamp sellenddate) {
		this.sellenddate = sellenddate;
	}

	public void setSellstartdate(Timestamp sellstartdate) {
		this.sellstartdate = sellstartdate;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setStandardcost(BigDecimal standardcost) {
		this.standardcost = standardcost;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setTransactionhistories(List<Transactionhistory> transactionhistories) {
		this.transactionhistories = transactionhistories;
	}

	public void setUnitmeasure1(Unitmeasure unitmeasure1) {
		this.unitmeasure1 = unitmeasure1;
	}

	public void setUnitmeasure2(Unitmeasure unitmeasure2) {
		this.unitmeasure2 = unitmeasure2;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

}