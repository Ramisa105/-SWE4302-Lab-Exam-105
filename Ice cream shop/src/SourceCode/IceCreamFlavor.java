package SourceCode;

class IceCreamFlavor implements Item {
    private final String name;
    private final double price;

    public IceCreamFlavor(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
