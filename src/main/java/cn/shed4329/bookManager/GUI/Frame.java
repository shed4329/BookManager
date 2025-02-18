package cn.shed4329.bookManager.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.ibatis.io.Resources;


public class Frame extends Application {
    public static Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Resources.getResourceURL("layout/MainFrame.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("学生管理系统");
        stage.show();
    }
}
