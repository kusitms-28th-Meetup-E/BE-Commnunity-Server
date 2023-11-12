package gwangjang.server.domain.community.application.service;


import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.domain.service.CommunityQueryService;
import gwangjang.server.global.annotation.DomainService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class CommunityReadUseCase {

    private final CommunityQueryService communityQueryService;

//    private final DomainGetService domainGetService;


    public List<CommunityRes> getCommunityList(String domain) {
//        domainGetService.getDomainByName(domain)

        return communityQueryService.getAllCommunityByDomain(domain);
    }
    public List<CommunityRes> getAllCommunityList() {
//        domainGetService.getDomainByName(domain)

        return communityQueryService.getAllCommunity();
    }
    public CommunityRes getCommunityDetail(String domain,Long communityId) {
//        domainGetService.getDomainByName(domain)
        return communityQueryService.getCommunity(communityId);
    }

    public List<CommunityRes> getCommunityTop5ByHeartsAndDomain(String domain) {

        return communityQueryService.getCommunityTop5ByHeartsAndDomain(domain);
    }
}
