package gwangjang.server.domain.community.domain.service;

import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.application.dto.res.MemberDto;
import gwangjang.server.domain.community.application.mapper.CommunityMapper;
import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.domain.community.domain.repository.CommunityRepository;
import gwangjang.server.domain.community.exception.NotFoundCommunityException;
import gwangjang.server.global.feign.client.FindMemberFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityQueryService {

    private final CommunityRepository communityRepository;
    private final FindMemberFeignClient findMemberFeignClient;

    private final CommunityMapper communityMapper = new CommunityMapper();

    public Community getCommunityById(Long communityId) {
        return communityRepository.findById(communityId).orElseThrow(NotFoundCommunityException::new
        );
    }
    public List<CommunityRes> getAllCommunityByDomain(String domain) {
        List<CommunityRes> communityRes = communityRepository.findAllCommunityByDomain(domain).orElseThrow(NotFoundCommunityException::new);
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
    public List<CommunityRes> getAllCommunity() {
        List<CommunityRes> communityRes = communityRepository.findAllCommunity().orElseThrow(NotFoundCommunityException::new);
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


    public CommunityRes getCommunity(Long communityId) {
        return communityRepository.findCommunity(communityId).orElseThrow(NotFoundCommunityException::new);
    }

    public List<CommunityRes> getCommunityTop5ByHeartsAndDomain(String domain) {
        return communityRepository.findCommunityTop5ByHeartsAndDomain(domain).orElseThrow(NotFoundCommunityException::new);
    }
}
