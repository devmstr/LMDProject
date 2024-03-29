package view.controller;

import com.jfoenix.controls.JFXButton;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author ismail 2020
 */
public class MainDashboardController implements Initializable{

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
        @FXML
        private ImageView StudentMgmt;

        @FXML
        private JFXButton btnSchoolInfo;

        @FXML
        private JFXButton btnStudentMgmt;

        @FXML
        private JFXButton btnStaffMgmt;

        @FXML
        private JFXButton btnExamMgmt;

        @FXML
        private JFXButton btnLibraryMgmt;

        @FXML
        private JFXButton btnEventMgmt;

        @FXML
        private JFXButton btnInventory;

        @FXML
        private JFXButton btnNoticeMgmt;

        @FXML
        private JFXButton btnUserSettings;

        @FXML
        private AnchorPane root;

        @FXML
        void setBtnUserSettings(ActionEvent event) {

                try {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/view/fxml/UserAccount.fxml")));
                        root.getChildren().setAll(user);
                }catch(IOException e){
                        System.out.println(e);
                }

        }

        @FXML
        void setBtnSchoolInfo(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Management System");
                alert.setHeaderText(null);
                alert.setContentText("Sorry..! This feature currently Unavailable for this Version.");
                alert.showAndWait();
        }

        @FXML
        void setBtnStudentMgmt(ActionEvent event) {

                try {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/view/fxml/StudentManagement.fxml")));
                        root.getChildren().setAll(user);
                }catch(IOException e){
                        System.out.println(e);
                }

        }
        @FXML
        void btnStaffMgmt(ActionEvent event){

                try {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/view/fxml/StaffManagement.fxml")));
                        root.getChildren().setAll(user);
                }catch(IOException e){
                        System.out.println(e);
                }
        }

        @FXML
        void btnExamMgmt(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Management System");
                alert.setHeaderText(null);
                alert.setContentText("Sorry..! This feature currently Unavailable for this Version.");
                alert.showAndWait();
        }

}

