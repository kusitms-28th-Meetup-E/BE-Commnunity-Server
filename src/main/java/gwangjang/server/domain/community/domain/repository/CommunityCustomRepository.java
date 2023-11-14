package gwangjang.server.domain.community.domain.repository;

import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.domain.entity.constant.CommunityOrderCondition;

import java.util.List;
import java.util.Optional;

public interface CommunityCustomRepository {


    Optional<List<CommunityRes>> findAllCommunityByTopic(String topic);
    Optional<List<CommunityRes>> findAllCommunity();
    Optional<CommunityRes> findCommunity(Long communityId);
    Optional<List<CommunityRes>> findCommunityTop5ByHeartsAndTopic(String topic);

    Optional<List<CommunityRes>> findCommunityTop5(CommunityOrderCondition orderCondition, String word);

}
