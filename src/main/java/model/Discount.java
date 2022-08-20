package model;

import java.time.LocalDate;

public class Discount {
    private int discountId;
    private String title;
    private String type;
    private double discountPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public Discount() {
    }

    public Discount(int discountId, String title, String type, double discountPrice, LocalDate startDate, LocalDate endDate) {
        this.discountId = discountId;
        this.title = title;
        this.type = type;
        this.discountPrice = discountPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
