package com.jewelrybuilder;

public class JewelrySetDirector {

    private final JewelrySetBuilder builder;

    public JewelrySetDirector(JewelrySetBuilder builder) {
        this.builder = builder;
    }

    public JewelrySet buildMinimalistSet() {
        return builder
                .setNecklace("Thin Gold Necklace")
                .setEarrings("Small Gold Studs")
                .setMaterial("Gold")
                .setGemstone("None")
                .setGiftBox(false)
                .build();
    }

    public JewelrySet buildWeddingSet() {
        return builder
                .setNecklace("Pearl Necklace")
                .setEarrings("Pearl Drop Earrings")
                .setBracelet("Pearl Bracelet")
                .setRing("Classic Gold Ring")
                .setMaterial("White Gold")
                .setGemstone("Pearl")
                .setGiftBox(true)
                .build();
    }

    public JewelrySet buildLuxurySet() {
        return builder
                .setNecklace("Diamond Pendant Necklace")
                .setEarrings("Diamond Earrings")
                .setBracelet("Diamond Bracelet")
                .setRing("Diamond Ring")
                .setMaterial("Platinum")
                .setGemstone("Diamond")
                .setGiftBox(true)
                .build();
    }
}
