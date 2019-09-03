package patkunja;

import java.util.ArrayList;

public class InventoryList {
    private ArrayList<Inventory> invList = new ArrayList<>(0);  // Inventory list


    /**
     * Add new inventory into list
     *
     * @param inventory object of inventory item
     */
    public void add(Inventory inventory) {
        invList.add(inventory);
    }

    /**
     * get inventory item from specific index
     *
     * @param index position in inventory list
     * @return Inventory
     */
    public Inventory get(int index) {
        if (index >= length()) {
            return null;
        }
        return invList.get(index);
    }

    /**
     * get inventory list size
     *
     * @return size
     */
    public int length() {
        return invList.size();
    }

}
