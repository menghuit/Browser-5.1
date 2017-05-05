package imports.android.net;

public class ParseException extends RuntimeException {
    public String response;

    public ParseException(String response) {
        this.response = response;
    }
}