import java.util.ArrayList;

public class Person {
    private String name;
    private Date birthday;
    private Budget giftBudget;
    private ArrayList<Gift> gifts;

    /*
     * Commas are rejected for the same reason as in Gift:
     * the save file is comma-separated.
     */
    public Person(String name, Date birthday, Budget giftBudget) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(name.contains(",")) {
            throw new IllegalArgumentException("Name cannot contain a comma: " + name);
        }
        if(birthday == null || giftBudget == null) {
            throw new IllegalArgumentException("Birthday and gift budget are required");
        }
        this.name = name.trim();
        this.birthday = birthday;
        this.giftBudget = giftBudget;
        this.gifts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Budget getGiftBudget() {
        return giftBudget;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public void addGift(Gift gift) {
        if(gift == null) {
            throw new IllegalArgumentException("Gift cannot be null");
        }
        gifts.add(gift);
    }

    // Returns null if there's no gift with that name (ignores upper/lower case)
    public Gift findGift(String giftName) {
        for(Gift gift : gifts) {
            if(gift.getName().equalsIgnoreCase(giftName)) {
                return gift;
            }
        }
        return null;
    }

    public boolean removeGift(String giftName) {
        Gift found = findGift(giftName);
        if(found == null) {
            return false;
        }
        gifts.remove(found);
        return true;
    }

    public double getTotalGiftCost() {
        return sumPrices(gifts);
    }

    public double getBoughtCost() {
        return sumPrices(filterByBought(true));
    }

    public ArrayList<Gift> getBoughtGifts() {
        return filterByBought(true);
    }

    public ArrayList<Gift> getUnboughtGifts() {
        return filterByBought(false);
    }

    // Budget decides what counts as "over", so rounding rules live in one place
    public boolean isOverBudget() {
        return !giftBudget.canAfford(getTotalGiftCost());
    }

    // Negative means over budget
    public double getRemainingBudget() {
        return giftBudget.remainingAfter(getTotalGiftCost());
    }

    private ArrayList<Gift> filterByBought(boolean wantBought) {
        ArrayList<Gift> result = new ArrayList<>();
        for(Gift gift : gifts) {
            if(gift.isBought() == wantBought) {
                result.add(gift);
            }
        }
        return result;
    }

    private double sumPrices(ArrayList<Gift> list) {
        double total = 0;
        for(Gift gift : list) {
            total += gift.getPrice();
        }
        return total;
    }

    // e.g. "Jordan (05/10/2005) budget $60.00"
    @Override
    public String toString() {
        return name + " (" + birthday + ") budget " + giftBudget;
    }
}