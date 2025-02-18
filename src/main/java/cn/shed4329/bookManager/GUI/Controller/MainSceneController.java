package cn.shed4329.bookManager.GUI.Controller;

import cn.shed4329.bookManager.GUI.Frame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;

@Log
public class MainSceneController {
    @FXML
    private VBox box;
    @FXML
    public void initialize(){
        try {
            Image image = new Image(Resources.getResourceURL("background.jpg").toExternalForm());
            BackgroundImage backgroundImage = new BackgroundImage(
                    image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true));
            Background background = new Background(backgroundImage);

            box.setBackground(background);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void LoadInsertBookScene(ActionEvent event)  {
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/insertBook.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void LoadInsertStudentScene(ActionEvent event){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/insertStudent.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void LoadStudentInfoScene(ActionEvent event){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/studentInfo.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void LoadBookInfoScene(ActionEvent event){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/bookInfo.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void LoadBorrowScene(ActionEvent event){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/insertBorrow.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void LoadBorrowInfoScene(ActionEvent event){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/borrowInfo.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
