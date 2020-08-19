package com.hillel.flowers.consolework;

import com.hillel.flowers.entity.Accessory;
import com.hillel.flowers.entity.Bouquet;
import com.hillel.flowers.entity.Flower;
import com.hillel.flowers.exception.InvalidStemLengthException;
import com.hillel.flowers.worker.FlowersShop;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleFlowersWorker {

    private FlowersShop flowerShop;
    private Scanner scanner;

    public ConsoleFlowersWorker(FlowersShop flowerShop) {
        this.flowerShop = flowerShop;
        scanner = new java.util.Scanner(System.in);
    }

    public static void main(String[] args) {
        FlowersShop shop = new FlowersShop();
        ConsoleFlowersWorker flowersWorker = new ConsoleFlowersWorker(shop);
        flowersWorker.start();
        flowersWorker.stop();
    }

    public void start() {
        int choice = 0;
        do {
            System.out.println("1. Create bouquet");
            System.out.println("2. Bouquets operations");
            System.out.println("3. Print current bouquets");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            switch (choice) {
            case 1:
                Bouquet createdBouquet = createBouquet();
                flowerShop.addBouquet(createdBouquet);
                System.out.println("Created bouquet price -> " + createdBouquet.getPriceOfBouquet());
                break;
            case 2:
                bouquetChoosing();
                break;
            case 3:
                System.out.println(flowerShop);
                break;
            case 0:
                return;
            }

        } while (choice != 0);
    }

    private Bouquet createBouquet() {
        int choice = 0;
        Bouquet bouquet = new Bouquet();
        do {
            System.out.println("1. Create flowers");
            System.out.println("2. Create accessories");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            switch (choice) {
            case 1:
                createFlowers(bouquet);
                break;
            case 2:
                createAccessories(bouquet);
                break;
            case 0:
                break;
            }
        } while (choice != 0);
        return bouquet;
    }

    private void createFlowers(Bouquet bouquet) {
        int choice = 0;
        do {
            System.out.println("1. New flower");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            if (choice == 1) {
                bouquet.addFlower(createFlower());
            }
        } while (choice != 0);
    }

    private Flower createFlower() {
        String flowerName = null;
        double flowerPrice = 0;
        int flowerDaysToLife = 0;
        int flowerStemLength = 0;

        System.out.println("Name ->");
        flowerName = scanner.next();
        System.out.println("Price ->");
        flowerPrice = scanner.nextDouble();
        System.out.println("Days to life ->");
        flowerDaysToLife = scanner.nextInt();
        System.out.println("Stem length ->");
        flowerStemLength = scanner.nextInt();

        return new Flower(flowerName, flowerDaysToLife, flowerStemLength, flowerPrice);
    }

    private void createAccessories(Bouquet bouquet) {
        int choice = 0;
        do {
            System.out.println("1. New accessory");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            if (choice == 1) {
                bouquet.addAccessory(createAccessory());
            }
        } while (choice != 0);
    }

    private Accessory createAccessory() {
        String accessoryName = null;
        double accessoryPrice = 0;

        System.out.println("Name ->");
        accessoryName = scanner.next();
        System.out.println("Price ->");
        accessoryPrice = scanner.nextDouble();

        return new Accessory(accessoryName, accessoryPrice);
    }

    private void bouquetChoosing() {
        int choice = 0;
        System.out.println("Choose bouquet");
        for (int i = 0; i < flowerShop.getBouquets().length; i++) {
            System.out.println(i + " ->" + "\n" + flowerShop.getBouquets()[i]);
        }
        System.out.println("-1 to exit");
        choice = scanner.nextInt();
        if (choice == -1) {
            return;
        } else {
            flowerShop.getBouquets()[choice] = editBouquet(flowerShop.getBouquets()[choice]);
        }
    }

    private Flower[] findFlowersByStem(Bouquet bouquetToSearch) {
        int minLength = 0;
        int maxLength = 0;
        Flower[] filteredFlowers = null;

        System.out.println("Min legth ->");
        minLength = scanner.nextInt();
        System.out.println("Max length ->");
        maxLength = scanner.nextInt();
        try {
            filteredFlowers = bouquetToSearch.filterFlowersByStemLength(minLength, maxLength);
        } catch (InvalidStemLengthException ex) {
            System.err.println(ex);
        }
        return filteredFlowers;
    }

    private Bouquet editBouquet(Bouquet editedBouquet) {
        int choice = 0;
        do {
            System.out.println("1. Sort flowers by days to live");
            System.out.println("2. Find flowers by stem length");
            System.out.println("3. Bouquet price");
            System.out.println("4. Add flower");
            System.out.println("5. Add accessory");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            switch (choice) {
            case 1:
                editedBouquet.sortFlowers();
                System.out.println(editedBouquet);
                break;
            case 2:
                System.out.println(Arrays.toString(findFlowersByStem(editedBouquet)));
                break;
            case 3:
                System.out.println("Current bouquet price: " + editedBouquet.getPriceOfBouquet());
                break;
            case 4:
                editedBouquet.addFlower(createFlower());
                break;
            case 5:
                editedBouquet.addAccessory(createAccessory());
                break;
            case 0:
                break;
            }

        } while (choice != 0);
        return editedBouquet;
    }

    public void stop() {
        scanner.close();
    }

}
