package objects;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    int id;
    String name;
    String announcement;
    @SerializedName("show_announcement")
    boolean showAnnouncement;
}