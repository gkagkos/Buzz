package core;

import core.controller.LanguageChoiceController;
import core.controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application{

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Buzz!");

        initRootLayout();
        showLanguageScreen();
    }

    private void initRootLayout() {
        try{
            // Load root layout file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootView.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLanguageScreen() {
        try{
            // Load person overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LanguageChoice.fxml"));
            AnchorPane languageChoice = (AnchorPane) loader.load();

            // Hide the menu bar
            MenuBar menuBar = (MenuBar) rootLayout.lookup("#menubar");
            menuBar.setVisible(false);
            menuBar.setManaged(false);

            // Set person overview into the centre of root layout
            rootLayout.setCenter(languageChoice);

            // Give the controller access to the main app.
            LanguageChoiceController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showMainMenu(){
        try {
            // Load person overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainMenu.fxml"));
            GridPane languageChoice = (GridPane) loader.load();

            // Hide the menu bar
            MenuBar menuBar = (MenuBar) rootLayout.lookup("#menubar");
            menuBar.setVisible(false);
            menuBar.setManaged(false);

            // Set person overview into the centre of root layout
            rootLayout.setCenter(languageChoice);

            // Give the controller access to the main app.
            MainMenuController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
