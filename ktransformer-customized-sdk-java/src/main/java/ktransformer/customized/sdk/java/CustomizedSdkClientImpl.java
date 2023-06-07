package ktransformer.customized.sdk.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import ktransformer.customized.sdk.java.exception.CustomizedSdkClientError;
import ktransformer.customized.sdk.java.model.AssignmentResult;
import ktransformer.customized.sdk.java.model.KtransformerGetAssignmentDataRequest;
import okhttp3.*;

import java.io.IOException;

public class CustomizedSdkClientImpl implements CustomizedSdkClient {
    private static final String GET_ASSIGNMENT_RESULT_API_BASE_URL = "https://knn3-gateway.knn3.xyz/transformer/api/customizedApi";
    private static final String DEFAULT_PAGESIZE = "50";
    private final String apiKey;
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    public CustomizedSdkClientImpl(final String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public AssignmentResult getAssignmentResult(final KtransformerGetAssignmentDataRequest request) {
        final HttpUrl.Builder urlBuilder = HttpUrl
                .parse(GET_ASSIGNMENT_RESULT_API_BASE_URL + "/assignment/" + request.getAssignmentId() + "/data")
                .newBuilder();
        if (null != request.getPreviousExecutionId()) {
            urlBuilder.addQueryParameter("previousExecutionId", request.getPreviousExecutionId());
        }
        if (null != request.getNextToken()) {
            urlBuilder.addQueryParameter("nextToken", request.getNextToken());
        }
        if (null == request.getPageSize()) {
            urlBuilder.addQueryParameter("pageSize", DEFAULT_PAGESIZE);
        } else {
            urlBuilder.addQueryParameter("pageSize", request.getPageSize().toString());
        }

        final String url = urlBuilder.build().toString();
        final Request httpRequest = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("auth-key", this.apiKey)
                .build();

        final Call call = client.newCall(httpRequest);
        try {
            final Response response = call.execute();
            if (!response.isSuccessful() || null == response.body()) {
                throw new CustomizedSdkClientError("Failed to query assignment data, error code: " + response.code());
            }

            return this.objectMapper.readValue(response.body().bytes(), AssignmentResult.class);
        } catch (final IOException e) {
            throw new CustomizedSdkClientError(e.getMessage());
        }
    }
}
