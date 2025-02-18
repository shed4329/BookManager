package cn.shed4329.bookManager.GUI.Controller;

import cn.shed4329.bookManager.GUI.Frame;
import cn.shed4329.bookManager.Mapper.StudentMapper;
import cn.shed4329.bookManager.SQL.SqlUtil;
import cn.shed4329.bookManager.entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentInfoController {
    @FXML
    private TableView<Student> infoTable;

    @FXML
    private TableColumn<Student,Integer> sidColumn;

    @FXML
    private TableColumn<Student,String> nameColumn;

    @FXML
    private TableColumn<Student,String> sexColumn;

    @FXML
    private TableColumn<Student,Integer> gradeColumn;

    @FXML
    public void initialize(){
        SqlUtil.doSqlWork((StudentMapper mapper)->{
            sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
            gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

            ObservableList<Student> data = FXCollections.observableList(mapper.getStudents());
            infoTable.setItems(data);
        },StudentMapper.class);
    }
    @FXML
    public void backHandler(ActionEvent e){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/MainFrame.fxml")));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
