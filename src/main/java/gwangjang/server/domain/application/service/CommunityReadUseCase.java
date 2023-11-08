package gwangjang.server.domain.application.service;


import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.domain.service.CommunityQueryService;
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

        return communityQueryService.getCommunityByDomain(domain);
    }
}
