package cn.shed4329.bookManager.GUI.Controller;

import cn.shed4329.bookManager.GUI.AlertUtil;
import cn.shed4329.bookManager.GUI.Frame;
import cn.shed4329.bookManager.Mapper.StudentMapper;
import cn.shed4329.bookManager.SQL.SqlUtil;
import cn.shed4329.bookManager.entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;


@Log
public class InsertStudentController {
    @FXML
    private TextField nameField;
    @FXML
    private RadioButton maleRadioBtn;
    @FXML
    private ChoiceBox gradeChoiceBox;
    @FXML
    public void saveHandler(ActionEvent e){
        String name = nameField.getText();
        if(name==null||name.isEmpty()){
            log.warning("姓名不能为空");
            return;
        }

        String sex;
        if(!maleRadioBtn.isSelected()){
            sex = "女";
        } else {
            sex = "男";
        }

        String gradeStr = gradeChoiceBox.getValue().toString();
        int grade = Integer.parseInt(gradeStr);


        SqlUtil.doSqlWork((StudentMapper mapper)->{
            Student student = new Student(name,sex,grade);
            if(mapper.addStudent(student)==1){
                log.info("新增一条学生数据 "+student.toString());
                AlertUtil.info("成功","新增1条学生数据");
            }
        },StudentMapper.class);


    }
    public void backHandler(ActionEvent e){
        try {
            Frame.scene.setRoot(FXMLLoader.load(Resources.getResourceURL("layout/MainFrame.fxml")));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
