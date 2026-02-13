package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    private static final int BASE_PRICE = 3;

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected double getCost() {
        return BASE_PRICE;
    }

    @Override
    protected void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }
}
