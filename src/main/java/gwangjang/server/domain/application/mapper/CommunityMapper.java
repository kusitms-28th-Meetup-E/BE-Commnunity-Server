package gwangjang.server.domain.application.mapper;

import gwangjang.server.domain.application.dto.req.CommunityReq;
import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.domain.entity.Community;
import gwangjang.server.global.annotation.Mapper;
import gwangjang.server.global.security.dto.User;

@Mapper
public class CommunityMapper {

    public Community mapToCommunity(Long memberId, CommunityReq communityReq){
        return Community.builder()
                .title(communityReq.getTitle())
                .talk(communityReq.getTalk())
                .contentsId(communityReq.getContentsId())
                .memberId(memberId)
                .build();
    }

    public CommunityRes mapToCommunityRes(Community community) {
        return CommunityRes.builder()
                .id(community.getId())
                .title(community.getTitle())
                .createdAt(community.getCreatedAt().toString())
                .nickname(community.getMemberId().toString())
                .profileImg(community.getMemberId().toString())
                .build();
    }

}
