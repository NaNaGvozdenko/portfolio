package apiTests;

public class LoginViewModel {

    // Имя пользователя
    private String userName;
    // Пароль
    private String password;

    public LoginViewModel() {
    }

    public LoginViewModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
