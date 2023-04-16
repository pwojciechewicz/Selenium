package enums;

public enum MessageSubject {
    CUSTOMER_SERVICE("Customer service"), WEBMASTER("Webmaster");

    private String value;

    public String getValue() {
        return value;
    }

    MessageSubject(String value) {
        this.value = value;
    }
}
