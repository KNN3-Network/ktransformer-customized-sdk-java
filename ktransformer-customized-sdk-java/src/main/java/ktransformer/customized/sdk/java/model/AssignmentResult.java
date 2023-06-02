package ktransformer.customized.sdk.java.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignmentResult {
    private List<Map<String, Object>> data;
    private String queryId;
    private String nextToken;
    private Integer pageSize;
    private String status;
    private String error;
}
