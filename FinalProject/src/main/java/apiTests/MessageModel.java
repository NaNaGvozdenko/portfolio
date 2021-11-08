package apiTests;

public class MessageModel {

    private int code;

    private String message;


    public MessageModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
