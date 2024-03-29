package view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import dbController.StaffController;
import dbController.StudentController;
import model.Staff;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Ismail
 * @project LMD university system
 **/
public class RegisterStaffController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private AnchorPane root;

    @FXML
    private TextField empNoField;

    @FXML
    private TextField teacherNameField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField doaField;

    @FXML
    private JFXRadioButton genderField;

    @FXML
    private ToggleGroup g;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private JFXButton AddStaff;

    @FXML
    private JFXButton reset;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void AddStaff(ActionEvent event) {

        try {

            ValidationController v = new ValidationController();

            if(v.validateEmpty(empNoField)&& v.validateEmpty(teacherNameField)&& v.validateEmpty(dobField)
                    && v.validateEmpty(doaField)&& v.validateEmpty(phoneField)&& v.validateDate(dobField)&& v.validateDate(doaField)&& v.validatePhone(phoneField)&& v.numbersOnly(empNoField)&& v.numbersOnly(phoneField)){

                int empNo = Integer.parseInt(empNoField.getText());
                String teacherName = teacherNameField.getText();
                String dob = dobField.getText();
                String doa = doaField.getText();
                RadioButton selectedRadioButton = (RadioButton) g.getSelectedToggle();
                String gender = selectedRadioButton.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                Staff s = new Staff(empNo, teacherName, dob, doa, gender, email, phone, address);
                int i = StaffController.AddStaff(s);


                if (i > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff Registered Successfully..!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    dobField.setText(null);
                    doaField.setText(null);
                    emailField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPS there is an error adding Staff..!");
                    alert.showAndWait();
                }
            }

    } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void reset(ActionEvent event) {

        empNoField.setText(null);
        teacherNameField.setText(null);
        dobField.setText(null);
        doaField.setText(null);
        emailField.setText(null);
        phoneField.setText(null);
        addressField.setText(null);

    }
}
