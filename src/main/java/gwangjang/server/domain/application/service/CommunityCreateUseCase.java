package gwangjang.server.domain.application.service;

import gwangjang.server.domain.application.dto.res.ContentsDto;
import gwangjang.server.domain.application.dto.res.MemberDto;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@DomainService
@RequiredArgsConstructor
public class CommunityCreateUseCase {

    private final CommunityQueryService communityQueryService;
    private final CommunitySaveService communitySaveService;

    private final FindMemberFeignClient findMemberFeignClient;
    private final FindContentsFeignClient findContentsFeignClient;

    private final CommunityMapper communityMapper = new CommunityMapper();

    public CommunityRes createCommunity(String socialId, Long contentsId,CommunityReq communityReq) {

        MemberDto memberDto = findMemberFeignClient.getMemberBySocialId(socialId);
//        ContentsDto contentsDto = findContentsFeignClient.getContents(contentsId);'
        ContentsDto contentsDto = new ContentsDto(contentsId, "hihih","환경","후쿠시마 오염수","방류");

        Community community = communitySaveService.save(
                communityMapper.mapToCommunity(memberDto.getMemberId(), contentsDto, communityReq));

        return communityMapper.mapToCommunityRes(community,memberDto,contentsDto);

    }
}
