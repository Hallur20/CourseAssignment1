/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hvn15
 */
@Entity
@Table(name = "INFOENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infoentity.findAll", query = "SELECT i FROM Infoentity i")
    , @NamedQuery(name = "Infoentity.findByEmail", query = "SELECT i FROM Infoentity i WHERE i.email = :email")
    , @NamedQuery(name = "Infoentity.findByZip", query = "SELECT i FROM Infoentity i WHERE i.zip = :zip")
    , @NamedQuery(name = "Infoentity.findByPhonenumber", query = "SELECT i FROM Infoentity i WHERE i.phonenumber = :phonenumber")
    , @NamedQuery(name = "Infoentity.findByStreet", query = "SELECT i FROM Infoentity i WHERE i.street = :street")})
public class Infoentity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 45)
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "PHONENUMBER")
    private Integer phonenumber;
    @Size(max = 45)
    @Column(name = "STREET")
    private String street;
    @JoinColumn(name = "COMPANYID", referencedColumnName = "COMPANYID")
    @ManyToOne
    private Company companyid;
    @JoinColumn(name = "PERSONID", referencedColumnName = "PERSONID")
    @ManyToOne
    private Person personid;

    public Infoentity() {
    }

    public Infoentity(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Company getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Company companyid) {
        this.companyid = companyid;
    }

    public Person getPersonid() {
        return personid;
    }

    public void setPersonid(Person personid) {
        this.personid = personid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infoentity)) {
            return false;
        }
        Infoentity other = (Infoentity) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Infoentity[ email=" + email + " ]";
    }
    
}
