package org.example.model;
public enum OrderStatus {
    RECEIVED("Received"),
    IN_PROGRESS("In Progress"),
    IN_DELIVERY("In Delivery"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private String state;

    OrderStatus(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "state='" + state + '\'' +
                '}';
    }
}
