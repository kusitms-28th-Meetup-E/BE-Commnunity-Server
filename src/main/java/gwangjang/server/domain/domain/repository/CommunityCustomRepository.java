package gwangjang.server.domain.domain.repository;

import gwangjang.server.domain.application.dto.res.CommunityRes;

import java.util.List;
import java.util.Optional;

public interface CommunityCustomRepository {


    Optional<List<CommunityRes>> findCommunityByDomain(String domain);
}
