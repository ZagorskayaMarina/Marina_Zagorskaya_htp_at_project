package application_items.WS;

public class ResponseObject {
    public String code;
    public UserFromResponse[] data;

    public ResponseObject(String code, UserFromResponse[] data) {
        this.code = code;
        this.data = data;
    }

    public ResponseObject() {}
}
