package ktransformer.customized.sdk.java.model;

import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;

/**
 * Data model for the get data request.
 */
@Data
@Builder
public class KtransformerGetAssignmentDataRequest {
    private String assignmentId;
    @Nullable
    private String previousExecutionId;
    @Nullable
    private String nextToken;
    private Integer pageSize;
}
