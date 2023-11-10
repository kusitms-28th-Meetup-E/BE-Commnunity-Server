package gwangjang.server.domain.application.service;

import gwangjang.server.domain.application.feign.dto.ContentsDto;
import gwangjang.server.domain.application.feign.dto.MemberDto;
import gwangjang.server.domain.application.feign.client.FindMemberFeignClient;
import gwangjang.server.domain.application.feign.client.FindContentsFeignClient;
import gwangjang.server.domain.application.dto.req.CommunityReq;
import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.application.mapper.CommunityMapper;
import gwangjang.server.domain.domain.entity.Community;
import gwangjang.server.domain.domain.service.CommunityQueryService;
import gwangjang.server.domain.domain.service.CommunitySaveService;
import gwangjang.server.global.annotation.DomainService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@DomainService
@RequiredArgsConstructor
public class CommunityCreateUseCase {

    private final CommunityQueryService communityQueryService;
    private final CommunitySaveService communitySaveService;

    private final FindMemberFeignClient findMemberFeignClient;
    private final FindContentsFeignClient findContentsFeignClient;

    private final CommunityMapper communityMapper = new CommunityMapper();

    public CommunityRes createCommunity(String socialId, Long contentsId, CommunityReq communityReq) {

        MemberDto memberDto = findMemberFeignClient.getMember(socialId);
//        ContentsDto contentsDto = findContentsFeignClient.getContents(contentsId);
        ContentsDto contentsDto = new ContentsDto(1L, "hihih");

        Community community = communitySaveService.save(
                communityMapper.mapToCommunity(memberDto.getMemberId(), contentsDto, communityReq));

        return communityMapper.mapToCommunityRes(community,memberDto);

    }
}
