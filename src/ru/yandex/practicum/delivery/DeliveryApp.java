package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static ArrayList<Parcel> allParcels = new ArrayList<>();
    private static ArrayList<Trackable> trackableParcels = new ArrayList<>();

    private static ParcelBox<StandardParcel> standardParcelParcelBox = new ParcelBox<>(100);
    private static ParcelBox<FragileParcel> fragileParcelParcelBox = new ParcelBox<>(70);
    private static ParcelBox<PerishableParcel> perishableParcelParcelBox = new ParcelBox<>(50);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    showBoxContents();
                    break;
                case 5:
                    reportTracking();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Показать содержимое коробки");
        System.out.println("5 — Обновить местоположение");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Кратко опишите посылку, которую хотите отправить:");
        String description = scanner.nextLine();

        System.out.println("Укажите вес:");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.println("Укажите адрес доставки:");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Когда нужно отправить?");
        int sendDay = Integer.parseInt(scanner.nextLine());

        System.out.println("Какой тип посылки хотите отправить?");
        parcelTypes();
        int cmd = Integer.parseInt(scanner.nextLine());

        switch (cmd) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standardParcelParcelBox.addParcel(standardParcel);
                allParcels.add(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                fragileParcelParcelBox.addParcel(fragileParcel);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                break;
            case 3:
                System.out.println("Укажите срок хранения посылки: ");
                int timeToLive = Integer.parseInt(scanner.nextLine());

                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                perishableParcelParcelBox.addParcel(perishableParcel);
                allParcels.add(perishableParcel);
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double totalCost = 0;

        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }

        System.out.println("Общая стоимость доставки: " + totalCost);
    }

    private static void reportTracking() {
        System.out.println("Укажите новое местоположение:");
        String newLocation = scanner.nextLine();

        for (Trackable trackableParcel : trackableParcels) {
            trackableParcel.reportStatus(newLocation);
        }
    }

    private static void showBoxContents() {
        parcelTypes();
        int cmd = Integer.parseInt(scanner.nextLine());

        switch (cmd) {
            case 1:
                standardParcelParcelBox.getAllParcels();
                break;
            case 2:
                fragileParcelParcelBox.getAllParcels();
                break;
            case 3:
                perishableParcelParcelBox.getAllParcels();
                break;
            default:
                System.out.println("Неправильная команда");
        }

    }

    private static void parcelTypes() {
        System.out.println("1 — Стандартный");
        System.out.println("2 — Хрупкый");
        System.out.println("3 — Скоропортящийся");
    }
}

