package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    final FileChooser fileChooser = new FileChooser();

    @FXML
    TextArea textArea = new TextArea();

    @FXML
    TextField label = new TextField();

    public void import_images(ActionEvent event){

        Detectron.label = label.getText();
        textArea.clear();
        List<File> files = fileChooser.showOpenMultipleDialog(Tmp.addLabel);
        printLog(textArea, files);
    }

    private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath()+"\n");
        }
    }

    public void addLabel(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddLabel.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        Tmp.addLabel = primaryStage;
        primaryStage.show();
    }

    public void cancel(ActionEvent event) throws IOException {
        Tmp.addLabel.close();
    }

    public void close(ActionEvent event){
        Tmp.addLabel.close();
    }

}
