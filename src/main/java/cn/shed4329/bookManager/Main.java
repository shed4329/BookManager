package cn.shed4329.bookManager;


import cn.shed4329.bookManager.GUI.Frame;
import javafx.application.Application;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;

@Log
public class Main {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        try {
            logManager.readConfiguration(Resources.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            log.log(Level.SEVERE,e.getMessage());
        }
        Application.launch(Frame.class,args);
    }
}
