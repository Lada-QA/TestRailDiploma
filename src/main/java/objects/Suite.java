package objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    String id;
    String name;
    String description;
}
