# ktransformer-customized-sdk-java
This is a Java SDK that K.Transformer team created to retrieve your customized data.

# Install
## install with gradle
```
implementation 'xyz.knn3.ktransformer:ktransformer-customized-sdk-java:1.0.2'
```

## install with maven
```
<dependency>
    <groupId>xyz.knn3.ktransformer</groupId>
    <artifactId>ktransformer-customized-sdk-java</artifactId>
    <version>1.0.2</version>
</dependency>
```

# How to use
1. Register on [K.Transformer](https://transformer.knn3.xyz/) or contact us at builder@knn3.xyz
2. Prepare your data with AI or SQL template
3. Convert your data into API following workflow guide and submit as an assignment
4. Create an API Key for Customized API
5. View your code from Account/Service Control/Lambda-style Workflow
6. Obtain the data

```
import ktransformer.customized.sdk.java.CustomizedSdkClientImpl;
import ktransformer.customized.sdk.java.model.AssignmentResult;
import ktransformer.customized.sdk.java.model.KtransformerGetAssignmentDataRequest;

public static void main(String args[]) {
    CustomizedSdkClientImpl client = new CustomizedSdkClientImpl("{api-key}");
    
    // add your sql parameters
    Map<String, String> sqlParams = new HashMap<>();
    sqlParams.put("key1", "value1");
    sqlParams.put("key2", "value2");
    
    AssignmentResult res = client.getAssignmentResult(KtransformerGetAssignmentDataRequest.builder()
                        .assignmentId("{assignment-id}")
                        .pageSize(10) // default 50
                        .sqlParams(sqlParams)
                .build());
}

```
## pagination
1. You can choose the pagesize in your requests. The default pagesize is 100, and the max is 1000.
2. Each response contains `nextToken` that indicates the offset of the first element on the next page. If its value is null that means no more data.
3. To pull more data you will need to add 2 more query parameters in your request. One is the above-mentioned `nextToken`, the other is the `previousExecutionId` whose value should be the `queryId` returned in the previous response.
