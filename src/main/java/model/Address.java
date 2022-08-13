package model;

public class Address {
    private  int addressId;
    private  String city;
    private  String district;
    private  String subDistrict;
    private  String postalCode;
    private  long   deliveryFree;

    public Address() {
    }

    public Address(int addressId, String city, String district, String subDistrict, String postalCode, long deliveryFree) {
        this.addressId = addressId;
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
        this.deliveryFree = deliveryFree;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public long getDeliveryFree() {
        return deliveryFree;
    }

    public void setDeliveryFree(long deliveryFree) {
        this.deliveryFree = deliveryFree;
    }

    @Override
    public String toString() {
        return String.format("| %6d | %10s | %10d |",getAddressId(),getCity(),getDeliveryFree());
    }
}
