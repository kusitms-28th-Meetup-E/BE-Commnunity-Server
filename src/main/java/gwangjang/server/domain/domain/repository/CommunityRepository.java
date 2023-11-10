package gwangjang.server.domain.domain.repository;

import gwangjang.server.domain.domain.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long>, CommunityCustomRepository {


}
