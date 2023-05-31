package ktransformer.customized.sdk.java;

import ktransformer.customized.sdk.java.model.AssignmentResult;
import ktransformer.customized.sdk.java.model.GetAssignmentDataRequest;

public interface CustomizedSdkClient {
    AssignmentResult getAssignmentResult(final GetAssignmentDataRequest request);
}
