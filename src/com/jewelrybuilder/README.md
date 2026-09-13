# Jewelry Set Builder

## Project Description

For this project, I chose a jewelry store as the domain and implemented the Builder Design Pattern in Java.

The main idea is that a customer can create a jewelry set by choosing different pieces and options. A set can contain a necklace, earrings, bracelet, ring, material, gemstone, and a gift box.

The Builder Pattern is useful here because not every jewelry set has to contain the same pieces. For example, a minimalist set may only have a necklace and earrings, while a luxury set can contain all four jewelry pieces.

Instead of passing many values directly to a constructor, the Builder allows the object to be created step-by-step. This makes the code easier to read and gives us more flexibility when creating different jewelry sets.

## Builder Pattern

The project has four main parts: Product, Builder, Director, and Client.

### Product: JewelrySet

JewelrySet is the Product of the Builder Pattern.

It represents the final jewelry set after all the selected options have been added. The class stores information about the necklace, earrings, bracelet, ring, material, gemstone, and gift box.

The fields are final because after the jewelry set is created, its values should not be changed.

### Builder: JewelrySetBuilder

JewelrySetBuilder is responsible for creating a JewelrySet.

Each method adds one option to the jewelry set and then returns the same builder. This allows method chaining.

For example:

```java
JewelrySet jewelrySet = new JewelrySetBuilder()
        .setNecklace("Rose Gold Pendant")
        .setEarrings("Rose Gold Hoops")
        .setBracelet("Rose Gold Chain Bracelet")
        .setMaterial("Rose Gold")
        .setGemstone("Pink Quartz")
        .setGiftBox(true)
        .build();

This is easier to read than passing all the values directly into a constructor.

The build() method is also responsible for checking whether the required information has been provided before creating the final object.

Director: JewelrySetDirector

JewelrySetDirector is used for jewelry sets that have a predefined configuration.

I created three configurations:

Minimalist Set
Wedding Set
Luxury Set

For example, instead of writing all the Builder methods every time, we can simply use:

director.buildWeddingSet();

The Director already knows which pieces and options are needed for a wedding set.

This is useful when the same configuration may need to be created more than once.

Client: Main

Main is the Client of the Builder Pattern.

It is used to test the project. In the main() method, I create one custom jewelry set and also use the Director to create the three predefined sets.

I also included a validation test. It tries to create a jewelry set without specifying the required material, so the program shows an error message instead of creating an incomplete object.

Why I Used the Builder Pattern

A jewelry set has several parts that can be different from one set to another.

For example, one customer may want:

new JewelrySet(
        necklace,
        earrings,
        bracelet,
        ring,
        material,
        gemstone,
        giftBox
);

The problem with this approach is that it is not immediately clear which value belongs to which parameter. It also becomes harder to use when more options are added.

With the Builder Pattern, the same idea is much easier to understand:

new JewelrySetBuilder()
        .setNecklace("Pearl Necklace")
        .setEarrings("Pearl Earrings")
        .setMaterial("White Gold")
        .setGemstone("Pearl")
        .setGiftBox(true)
        .build();

We can see what each value represents, and we can leave out optional pieces when they are not needed.

Clean Code Principles

I applied several Clean Code principles while creating the project.

1. Meaningful Names

I used names that describe what the class, method, or variable is used for.

For example, instead of unclear names:

JS js = new JS();
B b = new B();

I used:

JewelrySet jewelrySet = new JewelrySetBuilder();

The class and variable names make it easier to understand the purpose of the code without needing additional comments.

Methods such as buildWeddingSet() and validateRequiredFields() also describe what they do.

2. Small Methods

I tried to keep methods focused on one task instead of putting everything into one large method.

For example, the build() method is responsible for creating the final product:

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

The validation itself is handled by a separate method:

private void validateRequiredFields() {
    if (material == null || material.isBlank()) {
        throw new IllegalStateException("Material must be specified.");
    }

    if (gemstone == null || gemstone.isBlank()) {
        throw new IllegalStateException("Gemstone must be specified.");
    }
}

This makes each method easier to read and understand.

3. Single Responsibility

I separated the project into different classes instead of putting all the code into one class.

JewelrySet represents the product.

JewelrySetBuilder is responsible for building the product.

JewelrySetDirector creates predefined configurations.

Main is used to test the program.

For example, the Director does not contain the product data itself. It only controls how the Builder should be used for predefined sets.

This separation makes the project easier to maintain.

4. Validated Construction

I added validation before the final JewelrySet object is created.

For example:

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

If the required material or gemstone is missing, an exception is thrown.

There is also a check that at least one jewelry piece is selected.

For example, this incomplete construction:

new JewelrySetBuilder()
        .setNecklace("Simple Necklace")
        .build();

does not create the object because the required material and gemstone were not provided.

This helps prevent invalid jewelry sets from being created.

5. Avoiding Repeated Code

I used a helper method called getValueOrDefault() when displaying optional jewelry pieces.

Without a helper method, I could have repeated the same check for every piece:

if (necklace == null || necklace.isBlank()) {
    // show "Not included"
}

Then I would need to repeat the same code for earrings, bracelet, and ring.

Instead, I created one method:

private String getValueOrDefault(String value) {
    return value == null || value.isBlank()
            ? "Not included"
            : value;
}

Then I can use it for different jewelry pieces:

getValueOrDefault(necklace),
getValueOrDefault(earrings),
getValueOrDefault(bracelet),
getValueOrDefault(ring)

This avoids repeating the same logic several times.

Project Structure
JewelrySetBuilder
|
|-- src
|   |-- com.jewelrybuilder
|       |-- JewelrySet.java
|       |-- JewelrySetBuilder.java
|       |-- JewelrySetDirector.java
|       |-- Main.java
|
|-- README.md
|-- .gitignore

Each Java file has a specific role in the Builder Pattern.

How to Run the Project
Open the project in IntelliJ IDEA.
Make sure a Java SDK is configured.
Open Main.java.
Run the main() method.
The results will appear in the console.

The program displays a custom jewelry set, three predefined sets, and a validation test.

Example Configurations
Custom Jewelry Set

The custom set is created directly with the Builder.

Necklace: Rose Gold Pendant
Earrings: Rose Gold Hoops
Bracelet: Rose Gold Chain Bracelet
Ring: Not included
Material: Rose Gold
Gemstone: Pink Quartz
Gift Box: Yes
Minimalist Set

The minimalist set contains only the basic jewelry pieces.

Necklace: Thin Gold Necklace
Earrings: Small Gold Studs
Bracelet: Not included
Ring: Not included
Material: Gold
Gemstone: None
Gift Box: No
Wedding Set

The wedding set contains several matching jewelry pieces and includes a gift box.

Necklace: Pearl Necklace
Earrings: Pearl Drop Earrings
Bracelet: Pearl Bracelet
Ring: Classic Gold Ring
Material: White Gold
Gemstone: Pearl
Gift Box: Yes
Luxury Set

The luxury set contains all four jewelry pieces and uses platinum and diamonds.

Necklace: Diamond Pendant Necklace
Earrings: Diamond Earrings
Bracelet: Diamond Bracelet
Ring: Diamond Ring
Material: Platinum
Gemstone: Diamond
Gift Box: Yes
Git Commit History

The project should be developed using at least three incremental commits.

My planned commit history is:

Commit 1: Create project and Product class

Commit 2: Implement Builder and Director

Commit 3: Add Client, validation, and README

This shows the development of the project step-by-step instead of making only one final commit.

Conclusion

The project demonstrates how the Builder Design Pattern can be used to create a jewelry set with different combinations of optional components.

The Builder makes the construction process easier to read, while the Director provides reusable configurations for common types of jewelry sets.

The project also uses Clean Code principles such as meaningful names, small methods, single responsibility, validated construction, and avoiding repeated code.