package com.example.domain;

import javafx.beans.property.SimpleStringProperty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Policy {
    private final SimpleStringProperty policyUid;
    private final SimpleStringProperty policyDepartment;
    private final SimpleStringProperty policyProject;
    private final SimpleStringProperty policyLevel;

    public Policy(String  policyUid, String policyDepartment, String policyProject, String policyLevel) {
        this.policyUid = new SimpleStringProperty(policyUid);
        this.policyDepartment = new SimpleStringProperty(policyDepartment);
        this.policyProject = new SimpleStringProperty(policyProject);
        this.policyLevel = new SimpleStringProperty(policyLevel);
    }

    public String getPolicyUid() {
        return policyUid.get();
    }

    public SimpleStringProperty policyUidProperty() {
        return policyUid;
    }

    public void setPolicyUid(String policyUid) {
        this.policyUid.set(policyUid);
    }

    public String getPolicyDepartment() {
        return policyDepartment.get();
    }

    public SimpleStringProperty policyDepartmentProperty() {
        return policyDepartment;
    }

    public void setPolicyDepartment(String policyDepartment) {
        this.policyDepartment.set(policyDepartment);
    }

    public String getPolicyProject() {
        return policyProject.get();
    }

    public SimpleStringProperty policyProjectProperty() {
        return policyProject;
    }

    public void setPolicyProject(String policyProject) {
        this.policyProject.set(policyProject);
    }

    public String getPolicyLevel() {
        return policyLevel.get();
    }

    public SimpleStringProperty policyLevelProperty() {
        return policyLevel;
    }

    public void setPolicyLevel(String policyLevel) {
        this.policyLevel.set(policyLevel);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyUid=" + policyUid +
                ", policyDepartment=" + policyDepartment +
                ", policyProject=" + policyProject +
                ", policyLevel=" + policyLevel +
                "}";
    }
}
