package ktransformer.customized.sdk.java.model;

import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;

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
