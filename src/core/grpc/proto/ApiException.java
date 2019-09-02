package core.grpc.proto;

public class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
}
