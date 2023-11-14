package gwangjang.server.domain.community.application.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentsDto {

    private Long contentsId;
    private String contents;

    private String keyword;
    private String issue;
    private String topic;

}
