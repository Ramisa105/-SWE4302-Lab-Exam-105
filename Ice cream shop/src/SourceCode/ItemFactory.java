package SourceCode;

class ItemFactory {
    public static IceCreamFlavor createFlavor(String name, double price) {
        return new IceCreamFlavor(name, price);
    }

    public static IceCreamTopping createTopping(String name, double price) {
        return new IceCreamTopping(name, price);
    }
}
