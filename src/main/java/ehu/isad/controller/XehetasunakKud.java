package ehu.isad.controller;

import ehu.isad.Book;
import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class XehetasunakKud implements Initializable {

    private Liburuak mainApp;


    public void setMainApp(Liburuak main){
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
    private Text txt_izenburua;

    @FXML
    private Text txt_argitaletxea;

    @FXML
    private Text txt_orriKop;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.mainErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        txt_izenburua.setWrappingWidth(500);
    }

    public void xehetasunakErakutsi(Book book){
        txt_izenburua.setText(book.getDetails().getTitle()+ " " + book.getDetails().getSubtitle());
        txt_argitaletxea.setText(book.getDetails().getPublishers()[0]);
        for (int i=1; i < book.getDetails().getPublishers().length; i++){
            txt_argitaletxea.setText(txt_argitaletxea.getText()+ ", " +  book.getDetails().getPublishers()[i]);
        }
        txt_orriKop.setText(String.valueOf(book.getDetails().getNumber_of_pages()));
    }

}
