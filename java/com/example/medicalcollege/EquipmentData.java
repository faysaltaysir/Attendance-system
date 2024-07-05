package com.example.medicalcollege;

public class EquipmentData {
    private String Name;
    private String DateOfBuy;
    private String ExpiringDate;
    private String Warrenty;

    public EquipmentData(String name, String DateOfBuy, String ExpiringDate, String warrenty) {
        this.Name = name;
        this.DateOfBuy = DateOfBuy;
        this.ExpiringDate = ExpiringDate;
        this.Warrenty = warrenty;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDateOfBuy() {
        return DateOfBuy;
    }

    public void setDateOfBuy(String dateOfBuy) {
        this.DateOfBuy = dateOfBuy;
    }

    public String getExpiringDate() {
        return ExpiringDate;
    }

    public void setExpiringDate(String expiringDate) {
        this.ExpiringDate = expiringDate;
    }

    public String getWarrenty() {
        return Warrenty;
    }

    public void setWarrenty(String warrenty) {
        this.Warrenty = warrenty;
    }
}
