package com.matrimony.soul.sync.unsync.domain;

public class Services {
    private int id;
    private String service_name;
    private String description;
    private float price;
    private int organizer_id;

    public Services(){}

    public Services(int id, String service_name, String description, float price, int organizer_id) {
        this.id = id;
        this.service_name = service_name;
        this.description = description;
        this.price = price;
        this.organizer_id = organizer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", service_name='" + service_name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", organizer_id=" + organizer_id +
                '}';
    }
}
