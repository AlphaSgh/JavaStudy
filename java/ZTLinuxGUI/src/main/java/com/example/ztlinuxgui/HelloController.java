package com.example.ztlinuxgui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void addUser() {
        Dialog<UserResults> dialog = new Dialog<>();
        dialog.setTitle("添加用户属性");
        dialog.setHeaderText("请在下面输入用户属性信息：");
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 60, 10, 10));

        TextField userUid = new TextField();
        TextField userDepartment = new TextField();
        TextField userProject = new TextField();
        TextField userLevel = new TextField();

        gridPane.add(new Label("用户名:"), 0, 0);
        gridPane.add(userUid, 1, 0);
        gridPane.add(new Label("部门:"), 0, 1);
        gridPane.add(userDepartment, 1, 1);
        gridPane.add(new Label("项目:"), 0, 2);
        gridPane.add(userProject, 1, 2);
        gridPane.add(new Label("等级:"), 0, 3);
        gridPane.add(userLevel, 1, 3);

        dialog.getDialogPane().setContent(gridPane);

        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                return new UserResults(userUid.getText(), userDepartment.getText(), userProject.getText(), userLevel.getText());
            }
            return null;
        });

        Optional<UserResults> optionalUserResults = dialog.showAndWait();
        optionalUserResults.ifPresent((UserResults results) -> {

        });
    }

    static void callCMD(String uid, String department, String project, String level, String state){
        try {
            String cmd = "./src/main/java/com/example/ztlinuxgui/hello echo " + uid + " " + department + " " + project + " " + level + " " + state + " /proc/userdb";
            Process process = Runtime.getRuntime().exec(cmd);
            int status = process.waitFor();
            if(status != 0){
                System.err.println("Failed to call shell's command and the return status's is: " + status);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private static class UserResults {
        String userUid;
        String userDepartment;
        String userProject;
        String userLevel;

        public UserResults(String userUid, String userDepartment, String userProject, String userLevel) {
            this.userUid = userUid;
            this.userDepartment = userDepartment;
            this.userProject = userProject;
            this.userLevel = userLevel;
        }
    }
}