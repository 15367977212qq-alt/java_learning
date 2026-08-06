public class BusinessException extends RuntimeException {

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    private final String code;

    public String getCode() {
        return code;
    }



}

