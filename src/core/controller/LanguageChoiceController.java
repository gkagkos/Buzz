package core.controller;


import core.MainApp;
import javafx.fxml.FXML;

public class LanguageChoiceController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    private void handleGreekButton(){
        mainApp.showMainMenu();
    }

    @FXML
    private void handleEnglishButton(){
        mainApp.showMainMenu();
    }

}
