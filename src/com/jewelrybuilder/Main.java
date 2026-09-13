package com.jewelrybuilder;

public class Main {

    public static void main(String[] args) {

        JewelrySet customSet = new JewelrySetBuilder()
                .setNecklace("Rose Gold Pendant")
                .setEarrings("Rose Gold Hoops")
                .setBracelet("Rose Gold Chain Bracelet")
                .setMaterial("Rose Gold")
                .setGemstone("Pink Quartz")
                .setGiftBox(true)
                .build();

        System.out.println("CUSTOM JEWELRY SET");
        System.out.println(customSet);


        JewelrySetDirector director =
                new JewelrySetDirector(new JewelrySetBuilder());

        System.out.println("MINIMALIST SET");
        System.out.println(director.buildMinimalistSet());

        System.out.println("WEDDING SET");
        System.out.println(director.buildWeddingSet());

        System.out.println("LUXURY SET");
        System.out.println(director.buildLuxurySet());


        System.out.println("VALIDATION TEST");

        try {
            new JewelrySetBuilder()
                    .setNecklace("Simple Necklace")
                    .build();

        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
