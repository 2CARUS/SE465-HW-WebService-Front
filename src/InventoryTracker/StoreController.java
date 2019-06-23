package InventoryTracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreController {

    private String location;

    @FXML
    ChoiceBox storeBox = new ChoiceBox();

    @FXML
    Button storeBackButton = new Button();

    @FXML
    TextField idSearch = new TextField();

    @FXML
    private void loadLocationFXML (ActionEvent event) throws IOException {
        Parent locationViewParent = FXMLLoader.load(getClass().getResource("location.fxml"));
        Scene locationViewScene = new Scene(locationViewParent);

        // Gets stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(locationViewScene);
        window.show();
    }

    @FXML
    private void loadInventoryFXML (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("inventory.fxml"));
        Parent inventoryViewParent = (Parent) loader.load();
        InventoryController inventoryController = loader.getController();
        int is;
        if (idSearch.getText().trim().isEmpty())
            is = 0;
        else
            is = Integer.valueOf(idSearch.getText());
        inventoryController.idSearch(is);
        Scene inventoryViewScene = new Scene(inventoryViewParent);

        // Gets stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(inventoryViewScene);
        window.show();
    }

    protected void setLocation(String location) {
        this.location = location;
        System.out.println(location);

        ObservableList<String> storeList = FXCollections.observableArrayList();
        // Somehow pass in the location selected from location scene to populate
        // the store list with stores in the selected city
        if (location == "Minneapolis") {
            // API requests for locations within the city
            storeList.addAll("Minneapolis Store 1", "Minneapolis Store 2");
        }

        else if (location == "St. Paul") {
            // API requests for locations within the city
            storeList.addAll("St. Paul Store 1", "St. Paul Store 2");
        }

        // Populate the ChoiceBox;
        storeBox.setItems(storeList);
    }
}
