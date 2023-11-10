package gwangjang.server.domain.domain.service;

import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.application.feign.client.FindMemberFeignClient;
import gwangjang.server.domain.application.dto.res.MemberDto;
import gwangjang.server.domain.application.mapper.CommunityMapper;
import gwangjang.server.domain.domain.repository.CommunityRepository;
import gwangjang.server.domain.exception.NotFoundCommunityException;
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
