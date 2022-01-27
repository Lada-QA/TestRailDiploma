package objects_for_plan;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entries {
    @SerializedName("suite_id")
    int suiteId;
    String name;
    @SerializedName("assignedto_id")
    int assignedtoId;
}
