package gwangjang.server.domain.community.domain.service;

import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.application.dto.res.MemberDto;
import gwangjang.server.domain.community.application.mapper.CommunityMapper;
import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.domain.community.domain.entity.constant.CommunityOrderCondition;
import gwangjang.server.domain.community.domain.repository.CommunityRepository;
import gwangjang.server.domain.community.exception.NotFoundCommunityException;
import gwangjang.server.global.annotation.DomainService;
import gwangjang.server.global.feign.client.FindMemberFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@DomainService
@Service
@RequiredArgsConstructor
public class CommunityQueryService {

    private final CommunityRepository communityRepository;
    private final FindMemberFeignClient findMemberFeignClient;

    public Community getCommunityById(Long communityId) {
        return communityRepository.findById(communityId).orElseThrow(NotFoundCommunityException::new
        );
    }
    public List<CommunityRes> getAllCommunityByTopic(String memberId,String topic) {
        List<CommunityRes> communityRes = communityRepository.findAllCommunityByTopic(memberId,topic).orElseThrow(NotFoundCommunityException::new);
        communityRes.stream().forEach(
                communityRes1 ->
                {
                    String writerId = communityRes1.getWriterId();
                    MemberDto memberDto = findMemberFeignClient.getMemberBySocialId(writerId);
                    communityRes1.updateMemberDto(memberDto);
                }
        );

        return communityRes;
    }
    public List<CommunityRes> getAllCommunity(String memberId) {
        List<CommunityRes> communityRes = communityRepository.findAllCommunity(memberId).orElseThrow(NotFoundCommunityException::new);
        communityRes.stream().forEach(
                communityRes1 ->
                {
                    String writerId = communityRes1.getWriterId();
                    MemberDto memberDto = findMemberFeignClient.getMemberBySocialId(writerId);
                    communityRes1.updateMemberDto(memberDto);
                }
        );

        return communityRes;
    }


    public CommunityRes getCommunity(String memberId,Long communityId) {
        CommunityRes communityRes = communityRepository.findCommunity(memberId, communityId).orElseThrow(NotFoundCommunityException::new);

        String writerId = communityRes.getWriterId();
        MemberDto memberDto = findMemberFeignClient.getMemberBySocialId(writerId);
        communityRes.updateMemberDto(memberDto);

        return communityRes;
    }


    public List<CommunityRes> getCommunityTop5(String memberId,CommunityOrderCondition communityOrderCondition, String with) {
        List<CommunityRes> communityRes = communityRepository.findCommunityTop5(memberId,communityOrderCondition, with).orElseThrow(NotFoundCommunityException::new);

        communityRes.stream().forEach(
                communityRes1 ->
                {
                    String writerId = communityRes1.getWriterId();
                    MemberDto memberDto = findMemberFeignClient.getMemberBySocialId(writerId);
                    communityRes1.updateMemberDto(memberDto);
                }
        );

        return communityRes;
    }
}
