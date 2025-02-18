package cn.shed4329.bookManager.GUI.Controller;

import cn.shed4329.bookManager.GUI.AlertUtil;
import cn.shed4329.bookManager.GUI.Frame;
import cn.shed4329.bookManager.Mapper.BookMapper;
import cn.shed4329.bookManager.SQL.SqlUtil;
import cn.shed4329.bookManager.entity.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;


import java.io.IOException;

@Log
public class InsertBookController {
    @FXML
    private TextField titleField;
    @FXML
    private TextArea descArea;
    @FXML
    private TextField priceField;
    @FXML
    public void saveHandler(ActionEvent e){
        String title = titleField.getText();
        String desc = descArea.getText();
        String priceStr = priceField.getText();
        if(!isValidStr(title)){
            log.warning("标题不能为空");
            AlertUtil.warn("提示","标题不能为空");
        }else if(!isValidStr(desc)){
            log.warning("描述不能为空");
            AlertUtil.warn("提示","描述不能为空");
        }else if(!isValidStr(priceStr)){
            log.warning("价格不能为空");
            AlertUtil.warn("提示","价格不能为空");
        }else{
            try {
                double price = Double.parseDouble(priceStr);

                SqlUtil.doSqlWork((BookMapper mapper) -> {
                    Book book = new Book(title, desc, price);
                    if (mapper.addBook(book) > 0) {
                        log.info("成功添加了一条书籍信息 " + book.toString());
                        AlertUtil.info("成功", "成功添加1本书籍");
                    }
                }, BookMapper.class);
            }catch (NumberFormatException ex){
                log.warning("价格应该是数字 "+ex.getLocalizedMessage());
                AlertUtil.warn("提示","价格应该是数字");
            }
        }

    }
    @FXML
    public void backHandler(ActionEvent e){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/MainFrame.fxml")));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private boolean isValidStr(String str){
        return str != null&&!str.isEmpty();
    }
}
