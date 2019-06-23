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
import javafx.stage.Stage;

import java.io.IOException;

public class LocationController {

    private String location;

    @FXML
    ChoiceBox locationBox = new ChoiceBox();

    @FXML
    Button locationButton = new Button();

    // This is method is called on button press
    @FXML
    protected void locationButtonListener(ActionEvent event) throws IOException {
        Object selectedChoice = locationBox.getSelectionModel().getSelectedItem();
        if (selectedChoice == "Minneapolis") {
            location = "Minneapolis";
            System.out.println(location);
        }

        if (selectedChoice == "St. Paul") {
            location = "St. Paul";
            System.out.println(location);
        }
        loadStoreFXML(event);
    }

    // To load the store scene
    private void loadStoreFXML(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));
        Parent storeViewParent = (Parent) loader.load();
        StoreController storeController = loader.getController();
        storeController.setLocation(location);
        Scene storeViewScene = new Scene(storeViewParent);

        // Gets stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(storeViewScene);
        window.show();
    }

    // Initializes the scene
    public void initialize() {
        ObservableList<String> locationList = FXCollections.observableArrayList();
        // Can do API requests for the data here
        locationList.addAll("Minneapolis", "St. Paul");
        // Populate the ChoiceBox;
        locationBox.setItems(locationList);
    }
}
