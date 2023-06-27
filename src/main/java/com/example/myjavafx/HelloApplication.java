package com.example.myjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;

public class HelloApplication extends Application {
    TableView<Movie> tableView = new TableView<>();

    @Override
    public void start(Stage stage) throws IOException, SQLException {

        setUpTableView();
        Connection con = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            con = DBCon.connect();
            statement = con.createStatement();
            System.out.println("con");

            String query = "SELECT * from movies";
            result = statement.executeQuery(query);
            while (result.next()) {
                String title = result.getString("title");
                String director = result.getString("director");
                Movie movie = new Movie(title, director);
                tableView.getItems().add(movie);
            }

        } catch (SQLException e) {
            System.out.println("no con");
        }

        Scene scene = new Scene(tableView);
        stage.setScene(scene);
        stage.show();
    }

    private void setUpTableView() {
        TableColumn<Movie, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitle());

        TableColumn<Movie, String> directorColumn = new TableColumn<>("Director");
        directorColumn.setCellValueFactory(cellData -> cellData.getValue().getDirector());

        tableView.getColumns().addAll(titleColumn, directorColumn);
    }

    public static void main(String[] args) {
        launch();
    }
}