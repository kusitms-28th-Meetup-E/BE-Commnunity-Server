package gwangjang.server.domain.domain.service;

import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.domain.repository.CommunityRepository;
import gwangjang.server.domain.exception.NotFoundCommunityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityQueryService {

    private final CommunityRepository communityRepository;

    public List<CommunityRes> getCommunityByDomain(String domain) {
        return communityRepository.findCommunityByDomain(domain).orElseThrow(NotFoundCommunityException::new);
    }
}
