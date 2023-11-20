package gwangjang.server.domain.community.application.mapper;

import gwangjang.server.domain.community.application.dto.res.ContentsDto;
import gwangjang.server.domain.community.application.dto.res.MemberDto;
import gwangjang.server.domain.community.application.dto.req.CommunityReq;
import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.global.annotation.Mapper;

@Mapper
public class CommunityMapper {

    public Community mapToCommunity(String memberId, ContentsDto contentsDto, CommunityReq communityReq){
        return Community.builder()
                .talk(communityReq.getCommunityText())
                .contentsId(contentsDto.getContents_id())
                .writerId(memberId)
                .keyword(contentsDto.getKeyword())
                .issue(contentsDto.getIssueTitle())
                .topic(contentsDto.getTopicTitle())
                .build();
    }

    public CommunityRes mapToCommunityRes(Community community, MemberDto memberDto, ContentsDto contentsDto) {
        return CommunityRes.builder()
                .id(community.getId())
                .communityText(community.getTalk())
                .date(community.getCreatedAt().toString())
                .writerId(memberDto.getMemberId())
                .nickname(memberDto.getNickname())
                .profileImg(memberDto.getProfileImage())
                .contents(contentsDto.getUrl())
                .keyword(contentsDto.getKeyword())
                .subject(contentsDto.getIssueTitle())
                .area(contentsDto.getTopicTitle())
                .build();
    }

    public CommunityRes mapToCommunityResByMemberDto(MemberDto memberDto) {
        return CommunityRes.builder()
                .nickname(memberDto.getNickname())
                .profileImg(memberDto.getProfileImage())
                .build();
    }

}
