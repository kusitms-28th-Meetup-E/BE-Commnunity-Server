package gwangjang.server.domain.application.mapper;

import gwangjang.server.domain.application.feign.dto.ContentsDto;
import gwangjang.server.domain.application.feign.dto.MemberDto;
import gwangjang.server.domain.application.dto.req.CommunityReq;
import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.domain.entity.Community;
import gwangjang.server.global.annotation.Mapper;

@Mapper
public class CommunityMapper {

    public Community mapToCommunity(Long memberId, ContentsDto contentsDto,CommunityReq communityReq){
        return Community.builder()
                .title(communityReq.getTitle())
                .talk(communityReq.getTalk())
                .contentsId(contentsDto.getContentsId())
                .contents(contentsDto.getContents())
                .writerId(memberId)
                .build();
    }

    public CommunityRes mapToCommunityRes(Community community, MemberDto memberDto) {
        return CommunityRes.builder()
                .id(community.getId())
                .title(community.getTitle())
                .talk(community.getTalk())
                .createdAt(community.getCreatedAt().toString())
                .nickname(memberDto.getNickname())
                .profileImg(memberDto.getProfileImage())
                .build();
    }

}
