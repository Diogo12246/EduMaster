package pt.diogo12246.Controller;

import pt.diogo12246.Model.User;
import pt.diogo12246.Model_DAO.UserDAO;
import pt.diogo12246.application.EduMasterApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pt.diogo12246.utility.EduExceptionHandler;

public class EduMasterLoginController {

    @FXML
    private Button exitBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private Button bLoginBtn;
    @FXML
    private TextField userRegister;
    @FXML
    private PasswordField userRPassword;
    @FXML
    private Button registerFormBtn;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private AnchorPane registerPane;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField userPassword;
    @FXML
    private Label errorReport;
    private static EduMasterLoginController instance;

    public static String UserInstance;

    public static String getUserInstance() {
        return UserInstance;
    }

    public static EduMasterLoginController getInstance() {
        return instance;
    }

    @FXML
    private void exitAPP() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Login() {
        UserDAO userdao = new UserDAO();

        if (userdao.validateUser(userName.getText(), userPassword.getText())) {
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.close();
            UserInstance = userName.getText();
            new EduMasterApp().start(new Stage());
        } else errorReport.setText("User not found.");
    }

    @FXML
    void Register() {
        try {
            User user = new User();
            UserDAO userDao = new UserDAO();
            user.setUserName(userRegister.getText());
            user.setUserPassword(userRPassword.getText());
            userDao.createUser(user);
            errorReport.setText("Registado com sucesso! Pode fazer login");
        } catch (Exception e) {
            errorReport.setText("Ocorreu um erro. Verifique os logs da aplicação");
            EduExceptionHandler.ThrowEX(e);
        }

    }

    @FXML
    void registerForm() {
        loginPane.setVisible(false);
        loginPane.setDisable(true);
        registerPane.setVisible(true);
        registerPane.setDisable(false);
    }

    @FXML
    void loginForm() {
        loginPane.setVisible(true);
        loginPane.setDisable(false);
        registerPane.setVisible(false);
        registerPane.setDisable(true);
    }


}
