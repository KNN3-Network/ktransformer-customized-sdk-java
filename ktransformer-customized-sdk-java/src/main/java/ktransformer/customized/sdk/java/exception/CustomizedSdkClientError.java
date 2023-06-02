package ktransformer.customized.sdk.java.exception;

public class CustomizedSdkClientError extends RuntimeException {
    private String error;

    public CustomizedSdkClientError(final String error) {
        super(error);
        this.error = error;
    }
}
