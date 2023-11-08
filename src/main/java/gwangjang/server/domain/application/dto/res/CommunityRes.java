package gwangjang.server.domain.application.dto.res;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityRes {

    private Long id;
    private String title;
    private String createdAt;

    private String nickname;
    private String profileImg;

    private String domain;
    private String issue;
    private String keyword;

    public CommunityRes(Long id, String title, String createdAt, String domain, String issue, String keyword) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.domain = domain;
        this.issue = issue;
        this.keyword = keyword;
    }

    public CommunityRes(String nickname, String profileImg) {
        this.nickname = nickname;
        this.profileImg = profileImg;
    }
}
