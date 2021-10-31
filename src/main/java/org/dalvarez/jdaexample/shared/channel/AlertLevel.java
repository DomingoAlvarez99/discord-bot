package org.dalvarez.jdaexample.shared.channel;

public enum AlertLevel {

    INFO(AlertLevel.INFO_VALUE),
    WARNING(AlertLevel.WARNING_VALUE),
    ERROR(AlertLevel.ERROR_VALUE);

    private static final String INFO_VALUE = "INFO";

    private static final String WARNING_VALUE = "WARNING";

    private static final String ERROR_VALUE = "ERROR";

    private final String value;

    AlertLevel(final String value) {
        this.value = value;
    }

    public static AlertLevel fromValue(String value) {
        return AlertLevel.valueOf(value.toUpperCase());
    }

    public String getValue() {
        return value;
    }

}
