package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final int BASE_PRICE = 2;

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected double getCost() {
        return BASE_PRICE;
    }
}
