package gwangjang.server.domain.community.application.dto.res;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityRes {

    private Long id;
    private String title;
    private String talk;
    private String date;

    private String writerId;
    private String nickname;
    private String profileImg;

    private String topic;
    private String issue;
    private String keyword;

    private Long heartsNum;
    private Long commentsNum;

    public CommunityRes(Long id, String title, String talk, LocalDateTime date, String writerId,
                        String topic, String issue, String keyword, Long heartsNum, Long commentsNum) {
        this.id = id;
        this.title = title;
        this.talk = talk;
        this.date = date.toString();
        this.writerId = writerId;
        this.topic = topic;
        this.issue = issue;
        this.keyword = keyword;
        this.heartsNum = heartsNum;
        this.commentsNum = commentsNum;
    }

    public CommunityRes(String nickname, String profileImg) {
        this.nickname = nickname;
        this.profileImg = profileImg;
    }

    public void updateMemberDto(MemberDto memberDto) {
        this.nickname = memberDto.getNickname();
        this.profileImg = memberDto.getProfileImage();
    }
}
