package model;

import java.time.LocalDate;

public class Product {
    private int productId;
    private String name;
    private String description;
    private long price;
    private double discountPrice;
    private double stock;
    private int sold;
    private LocalDate date;
    private int status;

    public Product() {
    }

    public Product(int productId, String name, String description, long price, double discountPrice, double stock, int sold, LocalDate date, int status) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.sold = sold;
        this.date = date;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("| %10d | %15s | %15d | %15.2f | %15d | %15.2f | %15s |", getProductId(), getName(), getPrice(), getDiscountPrice(), getSold(), getStock(), getStatus() == 1 ? "stocking" : "Out of stock");
    }
}
