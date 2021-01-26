package com.hcl.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name= "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Double price;

    @Column(name = "date_added")
    Date dateAdded;

    public Product() {}
    public Product(Long id, String name, Double price, Date dateAdded) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateAdded = dateAdded;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
    public void setId(Double price) {
        this.price = price;
    }

    public Date getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public static int compareByName(Product a, Product b) {
        return a.name.compareTo(b.name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
