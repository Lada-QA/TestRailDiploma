package objects_for_case_field;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;


@Data
@Builder
public class CaseField {
    String type;
    String name;
    String label;
    String description;
    @SerializedName("include_all")
    boolean includeAll;
    ArrayList<Configs> configs;
}
