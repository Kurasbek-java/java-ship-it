package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private static final int BASE_PRICE = 4;
    private final int timeToLive;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    protected double getCost() {
        return BASE_PRICE;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }
}
