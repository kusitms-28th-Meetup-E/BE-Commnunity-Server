package gwangjang.server.domain.application.dto.req;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityReq {


    private Long contentsId;
    private String title;
    private String talk;

}
