package com.Isaac;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player ike = new Player("Ike", 10, 15);
        System.out.println(ike.toString());
        saveObject(ike);

        ike.setHitPoints(8);
        System.out.println(ike);
        ike.setWeapon("Stormbringer");
        saveObject(ike);
//        loadObject(ike);     // this is what allows us to enter character info in order to make a new profile
        System.out.println(ike);

        ISaveable werewolf = new Monster("Werewolf", 20,40);
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());    // This is some weird casting that is necessary to werewolf.getStrength().
        saveObject(werewolf);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit and print character profile");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for(int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }




}
