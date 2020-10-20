package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class KautotuKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private ComboBox comboZerbitzua;

    @FXML
    private Label lbl_zerbitzua;

    @FXML
    private Label lbl_erabiltzailea;

    @FXML
    private TextField txtfld_erabiltzailea;

    @FXML
    private TextField txtfld_pasahitza;

    @FXML
    private Label lbl_pasahitza;

    @FXML
    private Button btn_kautotu;

    @FXML
    private Button btn_ezabatu;




    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClickKautotu(ActionEvent actionEvent) {
        System.out.println(txtfld_erabiltzailea.getText() + ":" + txtfld_pasahitza.getText());
        System.out.println(comboZerbitzua.getValue());

        if ("Flickr".equals(comboZerbitzua.getValue()) &&
                "juanan".equals(txtfld_erabiltzailea.getText()) &&
                "pereira".equals(txtfld_pasahitza.getText())) {

            mainApp.mainErakutsi();
        }
    }
    @FXML
    public void onClickEzabatu(ActionEvent actionEvent) {
        ZerbitzuKud.getInstance().kenduZerbitzua((String)comboZerbitzua.getValue());
        this.eguneratu();
    }

    private void eguneratu(){
        ObservableList<String> zerbitzuak = comboZerbitzua.getItems();
        zerbitzuak.remove(comboZerbitzua.getValue());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> zerbitzuakList = ZerbitzuKud.getInstance().lortuZerbitzuak();
        ObservableList<String> zerbitzuak = FXCollections.observableArrayList(zerbitzuakList);

        comboZerbitzua.setItems( zerbitzuak );

    }

}
