package InventoryTracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    private TableView<Item> inventoryTableView;

    @FXML
    public TableColumn<Item, Integer> idColumn;

    @FXML
    public TableColumn<Item, String> nameColumn;

    @FXML
    public TableColumn<Item, Integer> quantityColumn;

    @FXML
    public TableColumn<Item, String> descriptionColumn;

    // Populate the data (where the API requests will go)
    // populate with different data depending on the store
    private ObservableList<Item> items = FXCollections.observableArrayList(
            // Sample data
            new Item(1, "Object1", 6, "Does stuff"),
            new Item(2, "Object2", 11, "Does more stuff")
    );

    public void idSearch(int idItemSearch) {
        if (idItemSearch == 0) {
            inventoryTableView.setItems(items);
        }

        else{
            // Search array for matching IDs
            // Somehow search for matching ids in the observable list
            // inventoryTableView.setItems(items);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));

        // Adds data to table
        inventoryTableView.setItems(items);
    }
}
