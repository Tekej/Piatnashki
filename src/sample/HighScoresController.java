package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HighScoresController implements Initializable {
    @FXML
    private TableView<ScoreTable> table;
    @FXML
    private TableColumn<ScoreTable, String> name;
    @FXML
    private TableColumn<ScoreTable, String> time;
    @FXML
    private TableColumn<ScoreTable, String> grid;
    private ObservableList<ScoreTable> data;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<ScoreTable> data = null;
        try {
            data = getInitialTableData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        table.setItems(data);

        name.setCellValueFactory(new PropertyValueFactory<ScoreTable, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ScoreTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ScoreTable, String> t) {

                ((ScoreTable) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setName(t.getNewValue());
            }
        });
        time.setCellValueFactory(new PropertyValueFactory<ScoreTable, String>("time"));
        time.setCellFactory(TextFieldTableCell.forTableColumn());
        time.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ScoreTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ScoreTable, String> t) {

                ((ScoreTable) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setTime(t.getNewValue());
            }
        });
        grid.setCellValueFactory(new PropertyValueFactory<ScoreTable, String>("grid"));
        grid.setCellFactory(TextFieldTableCell.forTableColumn());
        grid.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ScoreTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ScoreTable, String> t) {

                ((ScoreTable) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setGrid(t.getNewValue());
            }
        });

        table.setItems(data);


    }
    @FXML
    public void windowPassageMainMenu() throws IOException {
        Main.stage.setScene(new MainMenu().scene);


    }
    public ObservableList<ScoreTable> getInitialTableData() throws FileNotFoundException {

        ArrayList<ScoreTable> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File("HighScore.txt"));
        while (scanner.hasNextLine()) {
            String s [] = scanner.nextLine().split(" ");
            list.add(new ScoreTable(s[0],s[1],s[2]));

        }
        ObservableList<ScoreTable> data = FXCollections.observableList(list);
        scanner.close();
        return data;
    }




}
