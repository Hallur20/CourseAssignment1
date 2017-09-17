/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author hvn15
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AdressId")
    private Long AdressId;
    private String street;
    private String additionalInfo;

   @ManyToOne(optional=false) 
     @JoinColumn(name="zip", referencedColumnName="zip")
     public Cityinfo cityinfo;

    public Address(Long AdressId, String street, String additionalInfo, Cityinfo cityinfo) {
        this.AdressId = AdressId;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.cityinfo = cityinfo;
    }

   
   
    public Long getAdressId() {
        return AdressId;
    }

    public void setAdressId(Long AdressId) {
        this.AdressId = AdressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    
    
    public Cityinfo getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(Cityinfo cityinfo) {
        this.cityinfo = cityinfo;
    }
    
   
    
    
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Long getId() {
        return AdressId;
    }

    public void setId(Long id) {
        this.AdressId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (AdressId != null ? AdressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        return !((this.AdressId == null && other.AdressId != null) || (this.AdressId != null && !this.AdressId.equals(other.AdressId)));
    }

    @Override
    public String toString() {
        return "entity.Address[ id=" + AdressId + " ]";
    }

}
