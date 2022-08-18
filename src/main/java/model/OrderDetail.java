package model;

import java.util.Objects;

public class OrderDetail {
    private  int cardId;
    private  int quantity;
    private  long total;
    private  int orderId;
    private  int productId;

    public OrderDetail() {
    }
    public OrderDetail(int productId){
        this.productId=productId;
    }

    public OrderDetail(int cardId, int quantity, long total, int orderId, int productId) {
        this.cardId = cardId;
        this.quantity = quantity;
        this.total = total;
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "cardId=" + cardId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", orderId=" + orderId +
                ", productId=" + productId +
                '}';
    }
}
