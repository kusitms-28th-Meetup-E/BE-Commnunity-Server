package gwangjang.server.domain.application.service;

import gwangjang.server.domain.application.dto.req.CommunityReq;
import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.application.mapper.CommunityMapper;
import gwangjang.server.domain.domain.entity.Community;
import gwangjang.server.domain.domain.service.CommunityQueryService;
import gwangjang.server.domain.domain.service.CommunitySaveService;
import gwangjang.server.global.annotation.DomainService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class CommunityCreateUseCase {

    private final CommunityQueryService communityQueryService;
    private final CommunitySaveService communitySaveService;

    private final CommunityMapper communityMapper = new CommunityMapper();

    public CommunityRes createCommunity(String userId, CommunityReq communityReq) {

//        Member member = memberGetservice.getUserInfo(userId);
        Long memberId = 1L;

        Community community = communityMapper.mapToCommunity(memberId, communityReq);
        return communityMapper.mapToCommunityRes(communitySaveService.save(community));

    }
}
