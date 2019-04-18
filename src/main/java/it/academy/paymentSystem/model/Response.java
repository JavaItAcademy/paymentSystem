package it.academy.paymentSystem.model;

public class Response {
    private boolean success;
    private String message;
    private Object json;

    public Response() {
    }

    public Response(boolean success, String message, Object json) {
        this.success = success;
        this.message = message;
        this.json = json;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getJson() {
        return json;
    }

    public void setJson(Object json) {
        this.json = json;
    }
}
