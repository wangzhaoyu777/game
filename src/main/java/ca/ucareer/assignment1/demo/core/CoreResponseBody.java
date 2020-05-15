package ca.ucareer.assignment1.demo.core;

public class CoreResponseBody<T> {
    // pass response to controller
    private T result;
    private Exception error;
    private String message;

    public CoreResponseBody(T result, Exception error, String message) {
        this.result = result;
        this.error = error;
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
