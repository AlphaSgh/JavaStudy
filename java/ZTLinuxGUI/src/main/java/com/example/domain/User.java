package com.example.domain;

import javafx.beans.property.SimpleStringProperty;

public class User {
    private final SimpleStringProperty userUid;
    private final SimpleStringProperty userDepartment;
    private final SimpleStringProperty userProject;
    private final SimpleStringProperty userLevel;

    public User(String userUid, String userDepartment, String userProject, String userLevel) {
        this.userUid = new SimpleStringProperty(userUid);
        this.userDepartment = new SimpleStringProperty(userDepartment);
        this.userProject = new SimpleStringProperty(userProject);
        this.userLevel = new SimpleStringProperty(userLevel);
    }

    public String getUserUid() {
        return userUid.get();
    }

    public SimpleStringProperty userUidProperty() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid.set(userUid);
    }

    public String getUserDepartment() {
        return userDepartment.get();
    }

    public SimpleStringProperty userDepartmentProperty() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment.set(userDepartment);
    }

    public String getUserProject() {
        return userProject.get();
    }

    public SimpleStringProperty userProjectProperty() {
        return userProject;
    }

    public void setUserProject(String userProject) {
        this.userProject.set(userProject);
    }

    public String getUserLevel() {
        return userLevel.get();
    }

    public SimpleStringProperty userLevelProperty() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel.set(userLevel);
    }

    @Override
    public String toString() {
        return "User{" +
                "userUid=" + userUid +
                ", userDepartment" + userDepartment +
                ", userProject" + userProject +
                ", userLevel" + userLevel +
                "}";
    }
}
