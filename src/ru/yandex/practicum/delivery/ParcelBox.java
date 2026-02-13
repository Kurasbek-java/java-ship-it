package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final double maxWeight;
    private final ArrayList<T> parcels = new ArrayList<>();

    public ParcelBox(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (parcel.weight + getCurrentWeight() > maxWeight) {
            System.out.println("Коробка уже полон посылок");
            return;
        }

        parcels.add(parcel);
    }

    public void getAllParcels() {
        for (T parcel : parcels) {
            System.out.println(parcel.description);
        }
    }

    private double getCurrentWeight() {
        double totalWeight = 0;
        for (T parcel: parcels) {
            totalWeight += parcel.weight;
        }
        return totalWeight;
    }

    public int getSize() {
        return parcels.size();
    }
}
