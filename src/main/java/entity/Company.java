/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author hvn15
 */
@Entity
public class Company extends Infoentity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int cvr;
    private String name;
    private String description;
    private int numEmployees;
    private double marketValue;

    public Company(Long cvr, String name, String description, int numEmployees, double marketValue) {
        this.name = name;
        this.description = description;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public Company() {
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Company{" + "cvr=" + cvr + ", name=" + name + ", description=" + description + ", numEmployees=" + numEmployees + ", marketValue=" + marketValue + '}';
    }

}
