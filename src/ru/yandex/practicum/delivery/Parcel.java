package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    protected final String description;
    protected final double weight;
    protected final String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    protected void deliver() {
        System.out.println("Посылка " + description +" доставлена по адресу " + deliveryAddress);
    }

    protected void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    protected abstract double getCost();

    public double calculateDeliveryCost() {
        return weight * getCost();
    }


}
