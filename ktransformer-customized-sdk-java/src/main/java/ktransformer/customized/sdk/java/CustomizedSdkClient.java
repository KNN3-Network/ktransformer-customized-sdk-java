package ktransformer.customized.sdk.java;

import ktransformer.customized.sdk.java.model.AssignmentResult;
import ktransformer.customized.sdk.java.model.KtransformerGetAssignmentDataRequest;

public interface CustomizedSdkClient {
    AssignmentResult getAssignmentResult(final KtransformerGetAssignmentDataRequest request);
}
