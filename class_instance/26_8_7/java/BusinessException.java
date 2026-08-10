public class BusinessException extends RuntimeException {

    private final String code;

    public String getCode() {
        return code;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

}

