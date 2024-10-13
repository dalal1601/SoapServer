package com.example.soapserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @Id
    private Integer code;
    private String name;
    private double price;
    @XmlTransient
    private Date date;

}
