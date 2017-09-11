/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hallur
 */
@Entity
@Table(name = "COMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findByCompanyid", query = "SELECT c FROM Company c WHERE c.companyid = :companyid")
    , @NamedQuery(name = "Company.findByCompanyname", query = "SELECT c FROM Company c WHERE c.companyname = :companyname")
    , @NamedQuery(name = "Company.findByCompanydescription", query = "SELECT c FROM Company c WHERE c.companydescription = :companydescription")
    , @NamedQuery(name = "Company.findByCvr", query = "SELECT c FROM Company c WHERE c.cvr = :cvr")
    , @NamedQuery(name = "Company.findByNumemployees", query = "SELECT c FROM Company c WHERE c.numemployees = :numemployees")
    , @NamedQuery(name = "Company.findByMarketvalue", query = "SELECT c FROM Company c WHERE c.marketvalue = :marketvalue")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPANYID")
    private Integer companyid;
    @Size(max = 45)
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Size(max = 80)
    @Column(name = "COMPANYDESCRIPTION")
    private String companydescription;
    @Column(name = "CVR")
    private Integer cvr;
    @Column(name = "NUMEMPLOYEES")
    private Integer numemployees;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MARKETVALUE")
    private Double marketvalue;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "company")
    private Infoentity infoentity;

    public Company() {
    }

    public Company(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanydescription() {
        return companydescription;
    }

    public void setCompanydescription(String companydescription) {
        this.companydescription = companydescription;
    }

    public Integer getCvr() {
        return cvr;
    }

    public void setCvr(Integer cvr) {
        this.cvr = cvr;
    }

    public Integer getNumemployees() {
        return numemployees;
    }

    public void setNumemployees(Integer numemployees) {
        this.numemployees = numemployees;
    }

    public Double getMarketvalue() {
        return marketvalue;
    }

    public void setMarketvalue(Double marketvalue) {
        this.marketvalue = marketvalue;
    }

    public Infoentity getInfoentity() {
        return infoentity;
    }

    public void setInfoentity(Infoentity infoentity) {
        this.infoentity = infoentity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyid != null ? companyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyid == null && other.companyid != null) || (this.companyid != null && !this.companyid.equals(other.companyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Company[ companyid=" + companyid + " ]";
    }
    
}
