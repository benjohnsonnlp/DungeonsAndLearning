package com.docbenjohnson;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Character {
    Map<String, Integer> stats;
    String name;
    String race;
    String profession;

    static List<String> attributes = List.of("Strength", "Dexterity", "Wisdom", "Charisma", "Intelligence", "Constitution");
    static List<String> professions = List.of("Bard", "Wizard", "Fighter", "Barbarian", "Druid", "Thief");
    static List<String> races = List.of("Elf", "Gnome", "Human", "Dwarf");
    static Map<String, Map<String, Integer>> mods;
    static {
        Map<String, Integer> elfMods = Map.of(
                "strength", -1,
                "dexterity", 1
        );
        Map<String, Integer> gnomeMods = Map.of(
                "strength", -1,
                "intelligence", 1
        );
        Map<String, Integer> dwarfModes = Map.of(
                "strength", 1,
                "dexterity", -1
        );
        Map<String, Integer> humanMods = Map.of();
        mods = Map.of(
                "elf", elfMods,
                "gnome", gnomeMods,
                "human", humanMods,
                "dwarf", dwarfModes
        );
    }

    static Character roll() {
        String profession = professions.get(rand(professions));
        String race = races.get(rand(races));
        System.out.println("Class: " + profession);
        System.out.println("Race: " + race);

        System.out.println("Attributes:");
        Map<String, Integer> stats = new HashMap<>();
        for (String stat : attributes) {
            int minRoll = D6();
            LinkedList<Integer> rolls = new LinkedList<>();
            rolls.add(minRoll);
            for (int i = 0; i < 3; i++) {
                int roll = D6();
                if (roll < minRoll) {
                    minRoll = roll;
                }
                rolls.add(roll);
            }
            rolls.removeFirstOccurrence(minRoll);
            System.out.print("\t" + stat + " -- ");
            int sum = 0;
            for (int roll : rolls) {
                sum += roll;
                System.out.print(roll + " ");
            }
            System.out.print("(Dropped " + minRoll + ")  ");
            if (mods.containsKey(race.toLowerCase()) && mods.get(race.toLowerCase()).containsKey(stat.toLowerCase())) {
                int modifier = mods.get(race.toLowerCase()).get(stat.toLowerCase());
                sum += modifier;
                System.out.print("Racial Modifier:  ");
                if (modifier > 0) {
                    System.out.print("+");
                }
                System.out.print(modifier + " as " + race + " ");
            }
            System.out.println("Total: " + sum);
        }
        return null;
    }

    public static void main(String[] args) {
        roll();
        System.out.println("");
        roll();
        System.out.println("");
        roll();
        System.out.println("");
        roll();
    }

    private static int D6() {
        return (int) (Math.random() * 6 + 1);
    }

    static int rand(List l) {
        return (int) (Math.random() * l.size());
    }
}
