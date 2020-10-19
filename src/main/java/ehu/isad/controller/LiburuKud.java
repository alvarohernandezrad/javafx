package ehu.isad.controller;

import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    private Liburuak mainApp;

    public void setMainApp(Liburuak main){
        this.mainApp = main;
    }

    public void initialize(URL location, ResourceBundle resources) {
        cmbx_aukerak.getItems().add(0,"Blockchain: Blueprint for a New Economy");
        cmbx_aukerak.getItems().add(1,"R for Data Science");
        cmbx_aukerak.getItems().add(2, "Fluent Python");
        cmbx_aukerak.getItems().add(3, "Natural Language Processing with PyTorch");
        cmbx_aukerak.getItems().add(4, "Data Algorithms");

        cmbx_aukerak.getSelectionModel().selectFirst();
    }


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lbl_hautatu;

    @FXML
    private ComboBox<String> cmbx_aukerak;

    @FXML
    private Button btn_ikusi;

    @FXML
    void onClick(ActionEvent event) {
        if(cmbx_aukerak.getValue()!=null){
            String isbn = this.aukeraISBN(cmbx_aukerak.getValue());
            mainApp.xehetasunakEsleitu(isbn);
        }
        else{}
    }
    private String aukeraISBN(String aukera){
        String ISBN = "";
        switch (aukera) {
            case "Blockchain: Blueprint for a New Economy":
                ISBN = "9781491920497";
                break;
            case "R for Data Science":
                ISBN = "1491910399";
                break;
            case "Fluent Python":
                ISBN = "1491946008";
                break;
            case "Natural Language Processing with PyTorch":
                ISBN = "1491978236";
                break;
            case "Data Algorithms":
                ISBN = "9781491906187";
                break;
        }
        return ISBN;
    }

}
