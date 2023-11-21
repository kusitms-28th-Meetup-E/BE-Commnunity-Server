package gwangjang.server.domain.community.application.service;


import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.domain.entity.constant.CommunityOrderCondition;
import gwangjang.server.domain.community.domain.service.CommunityQueryService;
import gwangjang.server.global.annotation.DomainService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class CommunityReadUseCase {

    private final CommunityQueryService communityQueryService;

//    private final DomainGetService domainGetService;


    public List<CommunityRes> getCommunityList(String memberId,Long topicId) {
//        domainGetService.getDomainByName(domain)

        String topic = "환경"; //topicId to topicString
        return communityQueryService.getAllCommunityByTopic(memberId,topic);
    }
    public List<CommunityRes> getAllCommunityList(String memberId) {
//        domainGetService.getDomainByName(domain)

        return communityQueryService.getAllCommunity(memberId);
    }
    public CommunityRes getCommunityDetail(String memberId,Long topicId,Long communityId) {
//        domainGetService.getDomainByName(domain)

        return communityQueryService.getCommunity(memberId,communityId);
    }

    public List<CommunityRes> getCommunityTop5ByHearts(String memberId,String orderBy, Long wordId) {

//        orderBy + word -> string
        String word = "환경";

        return communityQueryService.getCommunityTop5(memberId,CommunityOrderCondition.valueOf(orderBy), word);
    }


    public List<CommunityRes> getCommunityByMyHearts(String memberId) {
        return communityQueryService.getCommunityByMyHearts(memberId);
    }
}
