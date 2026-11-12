public class Budget {
    /*
     * Doubles can't store money exactly (0.1 + 0.2 is slightly more
     * than 0.3), so comparisons allow this much wiggle room.
     */
    public static final double EPSILON = 0.001;

    private double amount;

    public Budget(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Budget cannot be negative: " + amount);
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void add(double extra) {
        if(extra < 0) {
            throw new IllegalArgumentException("Cannot add a negative amount: " + extra);
        }
        amount += extra;
    }

    // Takes money out of the budget; refuses if it would go below zero
    public void spend(double cost) {
        if(cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative: " + cost);
        }
        if(!canAfford(cost)) {
            throw new IllegalArgumentException("Cost " + cost + " is more than the budget "
                + amount);
        }
        amount -= cost;
        if(amount < 0) {
            amount = 0; //clears tiny negative leftovers from rounding
        }
    }

    public boolean canAfford(double cost) {
        return cost <= amount + EPSILON;
    }

    /*
     * What would be left if this cost came out of the budget.
     * Negative means over budget. The budget itself is not changed.
     */
    public double remainingAfter(double cost) {
        return amount - cost;
    }

    // Always two decimals, e.g. $45.50
    @Override
    public String toString() {
        return format(amount);
    }

    // The one place money is formatted for display, so every class prints it the same way
    public static String format(double amount) {
        return String.format("$%.2f", amount);
    }
}