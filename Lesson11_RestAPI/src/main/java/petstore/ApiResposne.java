package petstore;

public class ApiResposne {

    private int code;
    private String type;
    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ApiResposne{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
