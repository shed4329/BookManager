package cn.shed4329.bookManager.GUI;

import javafx.scene.control.Alert;

public class AlertUtil {
    public static void info(String title,String content){
        alert(Alert.AlertType.INFORMATION,title,content);
    }

    public static void warn(String title,String content){
        alert(Alert.AlertType.WARNING,title,content);
    }

    public static void alert(Alert.AlertType alertType, String title, String content){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.show();
    }
}
