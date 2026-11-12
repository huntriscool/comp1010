public class Gift {
    private String name;
    private double price;
    private boolean isBought;

    /*
     * Commas are rejected because the save file is comma-separated,
     * so a comma in a name would split it into two fields.
     */
    public Gift(String name, double price) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Gift name cannot be empty");
        }
        if(name.contains(",")) {
            throw new IllegalArgumentException("Gift name cannot contain a comma: " + name);
        }
        if(price < 0) {
            throw new IllegalArgumentException("Gift price cannot be negative: " + price);
        }
        this.name = name.trim();
        this.price = price;
        this.isBought = false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBought() {
        return isBought;
    }

    public void markBought() {
        isBought = true;
    }

    // e.g. "Headphones ($72.50) [bought]"
    @Override
    public String toString() {
        String status = "to buy";
        if(isBought) {
            status = "bought";
        }
        return name + " (" + Budget.format(price) + ") [" + status + "]";
    }
}