package patkunja;

import java.util.regex.Pattern;

public class Inventory {
    // Class variables
    private String id;
    private String name;
    private int qoh;    // Quantity On Hand
    private int rop;    // Re-Order Point
    private double sellPrice;

    // Default constructor
    Inventory() {
        this.setId("ABC-1234");
        this.setName("New Item");
        this.setQoh(0);
        this.setRop(25);
        this.setSellPrice(0);
    }

    /**
     * Parameterised constructor
     * @param id
     * @param name
     * @param sellPrice
     */
    Inventory(String id, String name, double sellPrice) {
        this.setId(id);
        this.setName(name);
        this.setSellPrice(sellPrice);
    }

    /**
     * Parameterised constructor
     * @param id
     * @param name
     * @param qoh
     * @param rop
     * @param sellPrice
     */
    Inventory(String id, String name, int qoh, int rop, double sellPrice) {
        this.setId(id);
        this.setName(name);
        this.setQoh(qoh);
        this.setRop(rop);
        this.setSellPrice(sellPrice);
    }

    /**
     * Get current item id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Set new item id
     * @param id
     */
    public void setId(String id) {
        Pattern pattern = Pattern.compile("[a-zA-Z]{3}[-][0-9]{4}");
        if (!pattern.matcher(id).matches()) {
            throw new IllegalArgumentException("ERROR: Invalid Id, expected format : ABC-1234");
        }
        this.id = id;
    }


    /**
     * Get item name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set new item name
     * @param name
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: You must enter an item name.");
        }
        this.name = name;
    }

    /**
     * get quantity on hand
     * @return qoh
     */
    public int getQoh() {
        return qoh;
    }

    /**
     * Set new quantity on hand value
     * @param qoh
     */
    public void setQoh(int qoh) {
        if (qoh < 0) {
            throw new IllegalArgumentException("ERROR: Quantity On Hand must be 0 or more.");
        }
        this.qoh = qoh;
    }

    /**
     * Get re-order point value
     * @return rop
     */
    public int getRop() {
        return rop;
    }

    /**
     * Set new re-order point
     * @param rop
     */
    public void setRop(int rop) {
        if (rop < 1) {
            throw new IllegalArgumentException("ERROR: Re-Order Point must be greater then 0.");
        }
        this.rop = rop;
    }

    /**
     * get current item selling price
     * @return sellPrice
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * Set current item new selling price
     * @param sellPrice
     */
    public void setSellPrice(double sellPrice) {
        if (sellPrice < 0) {
            throw new IllegalArgumentException("ERROR: Selling price nust be greater then 0.");
        }
        this.sellPrice = sellPrice;
    }

    /**
     * print formatted item information
     * @return {String}
     */
    @Override
    public String toString() {
        return String.format("\n%s (%s), QOH: %d Price: $%.2f\n", this.id, this.name, this.qoh, this.sellPrice);
    }
}
