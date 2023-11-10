package gwangjang.server.domain.community.domain.repository;

import gwangjang.server.domain.community.application.dto.res.CommunityRes;

import java.util.List;
import java.util.Optional;

public interface CommunityCustomRepository {


    Optional<List<CommunityRes>> findCommunityByDomain(String domain);
}
