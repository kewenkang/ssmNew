package com.smarthouse.operation.dataobject;

public class Sale {
    private Integer id;
    private User saleperson;
    private String town;
    private Integer locksNum;
    private Integer stocksNum;
    private Integer barrelsNum;
    private Integer year;
    private Integer month;

    public Sale() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getSaleperson() {
        return saleperson;
    }

    public void setSaleperson(User saleperson) {
        this.saleperson = saleperson;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getLocksNum() {
        return locksNum;
    }

    public void setLocksNum(Integer locksNum) {
        this.locksNum = locksNum;
    }

    public Integer getStocksNum() {
        return stocksNum;
    }

    public void setStocksNum(Integer stocksNum) {
        this.stocksNum = stocksNum;
    }

    public Integer getBarrelsNum() {
        return barrelsNum;
    }

    public void setBarrelsNum(Integer barrelsNum) {
        this.barrelsNum = barrelsNum;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", saleperson=" + saleperson +
                ", town='" + town + '\'' +
                ", locksNum=" + locksNum +
                ", stocksNum=" + stocksNum +
                ", barrelsNum=" + barrelsNum +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}
