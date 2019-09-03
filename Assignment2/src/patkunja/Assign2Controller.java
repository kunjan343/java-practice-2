package patkunja;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import javax.swing.*;

public class Assign2Controller {
    // inventory list class object to perform operations
    private InventoryList _ivList = new InventoryList();

    @FXML
    public TextField txtItemId; // item id text field reference
    @FXML
    public TextField txtItemName;   // item name text field reference
    @FXML
    public TextField txtQOH;    // item quantity-on-hand text field reference
    @FXML
    public TextField txtROP;    // item re-order-point text field reference
    @FXML
    public TextField txtSellingPrice;   // item selling price text field reference
    @FXML
    public TextArea txtAreaResult;  // result area field reference
    @FXML
    public Label lblError;  // error message label reference
    @FXML
    public Button btnAdd;   // add button reference
    @FXML
    public Button btnSave;  // save button reference
    @FXML
    public Button btnOrders;    // orders button reference
    @FXML
    public Button btnExit;  // application exit button reference

    /**
     * Main initialisation method for this controller
     * It set all action for javafx application controls
     */
    @FXML
    private void initialize() {
        btnAdd.setOnAction(e -> onbtnAddClicked());   // add button event binder
        btnSave.setOnAction(e -> onbtnSaveClicked());   // save item button event binder
        btnOrders.setOnAction(e -> onbtnOrdersClicked());   // orders item button event binder
        btnExit.setOnAction(e -> onbtnExitClicked());   // exit application button event binder
    }

    /**
     * clear all form fields and reset for new item to insert
     */
    private void onbtnAddClicked() {
        clearForm();
    }

    /**
     * Add new item to inventory list if the data is valid
     */
    private void onbtnSaveClicked() {
        try {
            Inventory _iv = new Inventory();    // create new inventory object to insert data

            _iv.setId(txtItemId.getText()); // set item id to inventory object
            _iv.setName(txtItemName.getText()); // set item name to inventory object

            String qoh = txtQOH.getText();  // read QOH value from form
            if (qoh.isEmpty() || hasInteger(qoh)) { // Check and throw error if QOH is invalid
                throw new IllegalArgumentException("Error: Invalid Q-O-H value");
            }
            _iv.setQoh(Integer.parseInt(qoh)); // set QOH to inventory object

            String rop = txtROP.getText();  // read ROP value from form
            if (rop.isEmpty() || hasInteger(rop)) { // Check and throw error if ROP is invalid
                throw new IllegalArgumentException("Error: Invalid R-O-P value");
            }
            _iv.setRop(Integer.parseInt(rop));  // set ROP to inventory object

            String sellingPrice = txtSellingPrice.getText();    // read selling price value from form
            if (sellingPrice.isEmpty() || !hasDouble(sellingPrice)) {   // Check and throw error if selling price is invalid
                throw new IllegalArgumentException("Error: Invalid Selling price");
            }
            _iv.setSellPrice(Double.parseDouble(sellingPrice)); // set selling price to inventory object

            _ivList.add(_iv);   // Save new inventory to inventory list
            clearForm();    // reset form data

            // Display success message to user
            lblError.setTextFill(Color.web("#28a745"));
            lblError.setText("Item added successfully");
        } catch (Exception ex) {
            // clear label message
            lblError.setText(null);
            String message = "ERROR: Invalid form details"; // default error message
            if (ex instanceof IllegalArgumentException) {   // check if error is coming from inventory class and set message
                message = ex.getMessage();
            }
            // Display error dialog for user
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * check list of items which are needed to reorder
     */
    private void onbtnOrdersClicked() {
        clearForm();
        int size = _ivList.length();    // get size of current inventory list
        if (size <= 0) {    // check if there is no item in list and display error message
            lblError.setTextFill(Color.web("#eb0000"));
            lblError.setText("No item to list. Add some!");
            return;
        }
        Inventory _iv;  // inventory object reference
        StringBuilder items = new StringBuilder();  // create string to display list of items in text area
        for (int i = 0; i < size; i++) {
            _iv = _ivList.get(i);   // get each inventory object from list
            if (_iv.getQoh() <= _iv.getRop()) { // check if item needs to be re-order and add in list
                items.append(_iv.toString());
            }
        }
        if (items.toString().equals("")) {  // display message if no item needs to be reorder
            txtAreaResult.setText("No items to re-order.");
            return;
        }
        txtAreaResult.setText(items.toString());    // display list of re-order items in text area
    }

    /**
     * exit application button handler
     */
    private void onbtnExitClicked() {
        // ask user if they wants to quit or not
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Quit?", "Error", JOptionPane.OK_CANCEL_OPTION);
        if (choice == 0) {  // close application if user confirm
            Platform.exit();
        }
    }

    /**
     * Clear all form detail and label messages
     */
    private void clearForm() {
        txtItemId.setText(null);    // clear item id field
        txtItemName.setText(null);  // clear item name field
        txtQOH.setText(null);   // clear item QOH field
        txtROP.setText(null);   // clear item ROP field
        txtSellingPrice.setText(null);  // clear item selling price field
        txtAreaResult.setText(null);    // clear result area
        lblError.setText(null); // clear label message
    }

    /**
     * Function check if input is valid string to convert into number or not and return boolean value
     *
     * @param input input string to check if its number(integer) or not
     * @return boolean
     */
    private boolean hasInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }

    /**
     * Function check if input is valid string to convert into number or not and return boolean value
     *
     * @param input input string to check if its number(double) or not
     * @return boolean
     */
    private boolean hasDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
