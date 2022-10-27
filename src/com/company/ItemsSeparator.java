package com.company;

public class ItemsSeparator {
    private static String name;
    private static double price;
    private static int quantity;

    public static void main() {
        String stdln = "Bread$$##12.5$$##10"; //ItemName$$##ItemPrice$$##ItemQuantity
        ItemsSeparator constructor = new ItemsSeparator(stdln);

        System.out.println("Item Name: " + name);
        System.out.println("Item price: " + price);
        System.out.println("Quantity: " + quantity);

    }

    /**
     * Constructor vacio de la clase
     */
    public ItemsSeparator() {
    }

    /**
     * @param rawInput Entrada de prueba
     *                 <p>
     *                 Constructor de la clase
     */
    public ItemsSeparator(String rawInput) {
        String[] datos = rawInput.split("\\$\\$##");
        this.name = datos[0];
        this.price = Double.parseDouble(datos[1]);
        this.quantity = Integer.parseInt(datos[2]);
    }

    public static String getName() {
        return name;
    }

    public static double getPrice() {
        return price;
    }

    public static int getQuantity() {
        return quantity;
    }
}
