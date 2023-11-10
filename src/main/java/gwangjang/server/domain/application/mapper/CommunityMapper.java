package gwangjang.server.domain.application.mapper;

import gwangjang.server.domain.application.dto.res.ContentsDto;
import gwangjang.server.domain.application.dto.res.MemberDto;
import gwangjang.server.domain.application.dto.req.CommunityReq;
import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.domain.entity.Community;
import gwangjang.server.global.annotation.Mapper;

@Mapper
public class CommunityMapper {

    public Community mapToCommunity(String memberId, ContentsDto contentsDto,CommunityReq communityReq){
        return Community.builder()
                .title(communityReq.getTitle())
                .talk(communityReq.getTalk())
                .contentsId(contentsDto.getContentsId())
                .contents(contentsDto.getContents())
                .writerId(memberId)
                .keyword(contentsDto.getKeyword())
                .issue(contentsDto.getIssue())
                .domain(contentsDto.getDomain())
                .build();
    }

    public CommunityRes mapToCommunityRes(Community community, MemberDto memberDto, ContentsDto contentsDto) {
        return CommunityRes.builder()
                .id(community.getId())
                .title(community.getTitle())
                .talk(community.getTalk())
                .createdAt(community.getCreatedAt().toString())
                .writerId(memberDto.getMemberId())
                .nickname(memberDto.getNickname())
                .profileImg(memberDto.getProfileImage())

                .keyword(contentsDto.getKeyword())
                .issue(contentsDto.getIssue())
                .domain(contentsDto.getDomain())
                .build();
    }

    public CommunityRes mapToCommunityResByMemberDto(MemberDto memberDto) {
        return CommunityRes.builder()
                .nickname(memberDto.getNickname())
                .profileImg(memberDto.getProfileImage())
                .build();
    }

}
