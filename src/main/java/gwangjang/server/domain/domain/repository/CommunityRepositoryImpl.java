package gwangjang.server.domain.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.domain.entity.Community;
import gwangjang.server.domain.domain.entity.QCommunity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static gwangjang.server.domain.domain.entity.QCommunity.community;

public class CommunityRepositoryImpl implements CommunityCustomRepository {

    private final JPAQueryFactory queryFactory;

    public CommunityRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Optional<List<CommunityRes>> findCommunityByDomain(String domain) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.constructor(CommunityRes.class,
                                community.id,
                                community.title,
                                community.createdAt,
                                community.domain,
                                community.issue,
                                community.keyword
                        ))
                        .from(community)
                        .where(community.domain.eq(domain))
                        .fetch()
        );
    }
}
