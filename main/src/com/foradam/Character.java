package com.adamagic;

public class Character {
    int strength;
    int dex;
    int charisma;
    int constitution;
    int wisdom;
    int intelligence;
    String name;

    public Character() {
        strength = 0;
        dex = 0;
        charisma = 0;
        constitution = 0;
        wisdom = 0;
        intelligence = 0;
        name = "";
    }

    public Character(int strength, int dex, int charisma,
                     int constitution, int wisdom, int intelligence, String name) {
        this.strength = strength;
        this.dex = dex;
        this.charisma = charisma;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.name = name;
    }

    public Character(int allStats, String name) {
        this.name = name;
        this.strength = allStats;
        this.dex = allStats;
        this.charisma = allStats;
        this.constitution = allStats;
        this.wisdom = allStats;
        this.intelligence = allStats;
    }

    public boolean strengthCheck(int difficulty) {
        if (this.strength > difficulty) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Character ben = new Character();
        System.out.println("ben: " + ben.strength);
        ben.strength = 5;
        System.out.println("ben: " + ben.strength);
        Character adam = new Character();
        System.out.println("Adam:  " + adam.strength);

        Character meech = new Character(18, 18, 18, 18, 18, 18, "Meech");
        Character natalie = new Character(18, "Natalie");

        int challenge = 5;
        System.out.println(ben.strengthCheck(challenge));
        System.out.println(adam.strengthCheck(challenge));
        System.out.println(meech.strengthCheck(challenge));
        System.out.println(natalie.strengthCheck(challenge));
        if (adam.strengthCheck(5)) {
            System.out.println("you are acceptable");
        } else {
            System.out.println("Wow, way to suck.");
        }
    }
}
