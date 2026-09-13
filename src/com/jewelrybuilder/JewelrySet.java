package com.jewelrybuilder;

public class JewelrySet {

    private final String necklace;
    private final String earrings;
    private final String bracelet;
    private final String ring;
    private final String material;
    private final String gemstone;
    private final boolean giftBox;

    public JewelrySet(
            String necklace,
            String earrings,
            String bracelet,
            String ring,
            String material,
            String gemstone,
            boolean giftBox) {

        this.necklace = necklace;
        this.earrings = earrings;
        this.bracelet = bracelet;
        this.ring = ring;
        this.material = material;
        this.gemstone = gemstone;
        this.giftBox = giftBox;
    }

    public String getNecklace() {
        return necklace;
    }

    public String getEarrings() {
        return earrings;
    }

    public String getBracelet() {
        return bracelet;
    }

    public String getRing() {
        return ring;
    }

    public String getMaterial() {
        return material;
    }

    public String getGemstone() {
        return gemstone;
    }

    public boolean hasGiftBox() {
        return giftBox;
    }

    @Override
    public String toString() {
        return """
            Jewelry Set
            Necklace: %s
            Earrings: %s
            Bracelet: %s
            Ring: %s
            Material: %s
            Gemstone: %s
            Gift Box: %s
            """.formatted(
                getValueOrDefault(necklace),
                getValueOrDefault(earrings),
                getValueOrDefault(bracelet),
                getValueOrDefault(ring),
                material,
                gemstone,
                giftBox ? "Yes" : "No");
    }

    private String getValueOrDefault(String value) {
        return value == null || value.isBlank() ? "Not included" : value;
    }
}