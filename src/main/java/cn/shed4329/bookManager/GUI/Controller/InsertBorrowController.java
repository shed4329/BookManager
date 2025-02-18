package cn.shed4329.bookManager.GUI.Controller;

import cn.shed4329.bookManager.GUI.AlertUtil;
import cn.shed4329.bookManager.GUI.Frame;
import cn.shed4329.bookManager.Mapper.BorrowMapper;
import cn.shed4329.bookManager.SQL.SqlUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;

@Log
public class InsertBorrowController {
    @FXML
    private TextField bidField;
    @FXML
    private TextField sidField;
    @FXML
    public void backHandler(ActionEvent e){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/MainFrame.fxml")));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @FXML
    public void saveHandler(ActionEvent e){
        String bidStr = bidField.getText();
        int bid = Integer.parseInt(bidStr);
        String sidStr = sidField.getText();
        int sid = Integer.parseInt(sidStr);

        SqlUtil.doSqlWork((BorrowMapper mapper)->{
            if(mapper.addBorrow(bid,sid)==1){
                log.info("成功添加一条借阅信息");
                AlertUtil.info("成功","成功借阅1本书籍");
            }else{
                log.warning("借阅失败");
                AlertUtil.warn("提示","这本书已被借阅");
            }
        }, BorrowMapper.class);
    }
}
