package gwangjang.server.domain.community.domain.service;

import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.application.dto.res.MemberDto;
import gwangjang.server.domain.community.application.mapper.CommunityMapper;
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

    public List<CommunityRes> getCommunityByDomain(String domain) {
        List<CommunityRes> communityRes = communityRepository.findCommunityByDomain(domain).orElseThrow(NotFoundCommunityException::new);
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
