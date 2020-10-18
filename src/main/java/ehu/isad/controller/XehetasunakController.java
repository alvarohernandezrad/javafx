package ehu.isad.controller;

import ehu.isad.Liburua;
import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class XehetasunakController {

    private Main mainApp;


    public void setMainApp(Main main){
        this.mainApp = main;
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lbl_xehetasunak;

    @FXML
    private Label lbl_izenburua;

    @FXML
    private Label lbl_argitaletxea;

    @FXML
    private Label lbl_orriKop;

    @FXML
    private Label lbl_irudia;

    @FXML
    private Button btn_atzera;

    @FXML
    private TextField txt_izenburua;

    @FXML
    private TextField txt_argitaletxea;

    @FXML
    private TextField txt_orriKop;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.mainErakutsi();
    }

    public void xehetasunakErakutsi(Liburua liburua){
        txt_izenburua.setText(liburua.getTitle()+ " " + liburua.getSubtitle());
        txt_argitaletxea.setText(liburua.getPublishers()[0]);
        for (int i=1; i < liburua.getPublishers().length; i++){
            txt_argitaletxea.setText(txt_argitaletxea.getText()+ ", " +  liburua.getPublishers()[i]);
        }
        txt_orriKop.setText(String.valueOf(liburua.getNumber_of_pages()));
    }

}
