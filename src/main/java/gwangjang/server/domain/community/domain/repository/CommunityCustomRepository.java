package gwangjang.server.domain.community.domain.repository;

import gwangjang.server.domain.community.application.dto.res.CommunityRes;

import java.util.List;
import java.util.Optional;

public interface CommunityCustomRepository {


    Optional<List<CommunityRes>> findAllCommunityByDomain(String domain);
    Optional<List<CommunityRes>> findAllCommunity();
    Optional<CommunityRes> findCommunity(Long communityId);
    Optional<List<CommunityRes>> findCommunityTop5ByHeartsAndDomain(String domain);

}
