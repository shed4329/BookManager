package cn.shed4329.bookManager.GUI.Controller;

import cn.shed4329.bookManager.GUI.Frame;
import cn.shed4329.bookManager.Mapper.BorrowMapper;
import cn.shed4329.bookManager.SQL.SqlUtil;
import cn.shed4329.bookManager.entity.Borrow;
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

public class BorrowInfoController {
    @FXML
    private TableView<Borrow> infoTable;

    @FXML
    private TableColumn<Borrow,Integer> bidColumn;

    @FXML
    private TableColumn<Borrow,Integer> sidColumn;

    @FXML
    private TableColumn<Borrow,Integer> idColumn;
    @FXML
    private TableColumn<Borrow,String> bookNameColumn;
    @FXML
    private TableColumn<Borrow,String> studentNameColumn;

    
    @FXML
    public void initialize(){
        SqlUtil.doSqlWork((BorrowMapper mapper)->{
            bidColumn.setCellValueFactory(new PropertyValueFactory<>("bid"));
            sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
            studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));

            ObservableList<Borrow> data = FXCollections.observableList(mapper.getBorrow());
            infoTable.setItems(data);
        },BorrowMapper.class);
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
