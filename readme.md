# ktransformer-customized-sdk-java
This is a Java SDK that Knn3 team create for conviniently retrieve your customized workflow data.

## install with gradle
`	implementation 'xyz.knn3.ktransformer:ktransformer-customized-sdk-java:1.0.0'`

## install with maven
```
<dependency>
    <groupId>xyz.knn3.ktransformer</groupId>
    <artifactId>ktransformer-customized-sdk-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## usage
```
import ktransformer.customized.sdk.java.CustomizedSdkClientImpl;
import ktransformer.customized.sdk.java.model.AssignmentResult;
import ktransformer.customized.sdk.java.model.KtransformerGetAssignmentDataRequest;

public static void main(String args[]) {
    CustomizedSdkClientImpl client = new CustomizedSdkClientImpl("{api-key}");
    AssignmentResult res = client.getAssignmentResult(KtransformerGetAssignmentDataRequest.builder()
                        .assignmentId("{assignment-id}")
                        .pageSize(10) // default 50
                .build());
}

```
