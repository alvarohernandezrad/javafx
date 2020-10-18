package ehu.isad;

import ehu.isad.controller.AukerakController;
import ehu.isad.controller.XehetasunakController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Liburuak extends Application {

    private Parent aukerakUI;
    private Parent xehetasunakUI;

    private Stage stage;

    private Scene aukerakScene;
    private Scene xehetasunakScene;

    private AukerakController aukerakController;
    private XehetasunakController xehetasunakController;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();
        stage.setTitle("OpenLibrary APIa aztertzen");
        stage.setScene(aukerakScene);
        stage.show();
    }

    private void pantailakKargatu() throws IOException {

        FXMLLoader loaderAukerak = new FXMLLoader(getClass().getResource("/OL_aukerak.fxml"));
        aukerakUI = (Parent) loaderAukerak.load();
        aukerakController = loaderAukerak.getController();
        aukerakController.setMainApp(this);
        aukerakScene = new Scene(aukerakUI);

        FXMLLoader loaderXehetasunak = new FXMLLoader(getClass().getResource("/OL_xehetasunak.fxml"));
        xehetasunakUI = (Parent) loaderXehetasunak.load();
        xehetasunakController = loaderXehetasunak.getController();
        xehetasunakController.setMainApp(this);
        xehetasunakScene = new Scene(xehetasunakUI);
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void mainErakutsi() {
        stage.setScene(aukerakScene);
        stage.show();
    }


    public void xehetasunakEsleitu(String ISBN){
        Book book = new Book();
        book = book.getLiburua(ISBN);
        xehetasunakController.xehetasunakErakutsi(book);
        stage.setScene(xehetasunakScene);
        stage.show();
    }
}
