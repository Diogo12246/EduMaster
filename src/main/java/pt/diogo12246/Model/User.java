package pt.diogo12246.Model;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String userName;
    private String userPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}


/*
    THIS IS THE OBJECT ON ITS PUREST FORM
    CONTAINS ALL GETTERS AND SETTERS AND THE CONSTRUCTORS
    NEEDED FOR THE OBJECT TO BE USED IN THE PROGRAM
 */