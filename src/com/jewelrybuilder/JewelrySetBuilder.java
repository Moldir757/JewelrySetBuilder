package com.jewelrybuilder;

public class JewelrySetBuilder {

    private String necklace;
    private String earrings;
    private String bracelet;
    private String ring;
    private String material;
    private String gemstone;
    private boolean giftBox;

    public JewelrySetBuilder setNecklace(String necklace) {
        this.necklace = necklace;
        return this;
    }

    public JewelrySetBuilder setEarrings(String earrings) {
        this.earrings = earrings;
        return this;
    }

    public JewelrySetBuilder setBracelet(String bracelet) {
        this.bracelet = bracelet;
        return this;
    }

    public JewelrySetBuilder setRing(String ring) {
        this.ring = ring;
        return this;
    }

    public JewelrySetBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public JewelrySetBuilder setGemstone(String gemstone) {
        this.gemstone = gemstone;
        return this;
    }

    public JewelrySetBuilder setGiftBox(boolean giftBox) {
        this.giftBox = giftBox;
        return this;
    }

    public JewelrySet build() {
        validateRequiredFields();

        return new JewelrySet(
                necklace,
                earrings,
                bracelet,
                ring,
                material,
                gemstone,
                giftBox);
    }

    private void validateRequiredFields() {

        if (material == null || material.isBlank()) {
            throw new IllegalStateException("Material must be specified.");
        }

        if (gemstone == null || gemstone.isBlank()) {
            throw new IllegalStateException("Gemstone must be specified.");
        }

        if (allJewelryPiecesAreMissing()) {
            throw new IllegalStateException(
                    "At least one jewelry piece must be specified.");
        }
    }

    private boolean allJewelryPiecesAreMissing() {
        return (necklace == null || necklace.isBlank())
                && (earrings == null || earrings.isBlank())
                && (bracelet == null || bracelet.isBlank())
                && (ring == null || ring.isBlank());
    }
}