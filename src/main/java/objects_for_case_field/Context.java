package objects_for_case_field;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Context {
    @SerializedName("is_global")
    boolean isGlobal;
    @SerializedName("project_ids")
    String projectIds;
}
