package cn.shed4329.bookManager.GUI.Controller;

import cn.shed4329.bookManager.GUI.Frame;
import cn.shed4329.bookManager.Mapper.BookMapper;
import cn.shed4329.bookManager.Mapper.StudentMapper;
import cn.shed4329.bookManager.SQL.SqlUtil;
import cn.shed4329.bookManager.entity.Book;
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

public class BookInfoController {
    @FXML
    private TableView<Book> infoTable;

    @FXML
    private TableColumn<Book,Integer> bidColumn;

    @FXML
    private TableColumn<Book,String> titleColumn;

    @FXML
    private TableColumn<Book,String> descColumn;

    @FXML
    private TableColumn<Book,Double> priceColumn;
    @FXML
    public void initialize(){
        SqlUtil.doSqlWork((BookMapper mapper)->{
            bidColumn.setCellValueFactory(new PropertyValueFactory<>("bid"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            descColumn.setCellValueFactory(new PropertyValueFactory<>("desc"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

            ObservableList<Book> data = FXCollections.observableList(mapper.getBooks());
            infoTable.setItems(data);
        },BookMapper.class);
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
