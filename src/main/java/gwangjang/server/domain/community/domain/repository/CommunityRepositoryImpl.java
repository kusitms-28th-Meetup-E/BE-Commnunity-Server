package gwangjang.server.domain.community.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static gwangjang.server.domain.community.domain.entity.QCommunity.community;

public class CommunityRepositoryImpl implements CommunityCustomRepository {

    private final JPAQueryFactory queryFactory;

    public CommunityRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Optional<List<CommunityRes>> findAllCommunityByDomain(String domain) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.constructor(CommunityRes.class,
                                community.id,
                                community.title,
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.domain,
                                community.issue,
                                community.keyword
                        ))
                        .from(community)
                        .where(community.domain.eq(domain))
                        .orderBy(community.createdAt.desc())
                        .fetch()
        );
    }
    @Override
    public Optional<List<CommunityRes>> findAllCommunity() {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.constructor(CommunityRes.class,
                                community.id,
                                community.title,
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.domain,
                                community.issue,
                                community.keyword
                        ))
                        .from(community)
                        .orderBy(community.createdAt.desc())
                        .fetch()
        );
    }

    @Override
    public Optional<CommunityRes> findCommunity(Long communityId) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.constructor(CommunityRes.class,
                                community.id,
                                community.title,
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.domain,
                                community.issue,
                                community.keyword
                        ))
                        .from(community)
                        .where(community.id.eq(communityId))
                        .fetchFirst()
        );
    }

    @Override
    public Optional<List<CommunityRes>> findCommunityTop5ByHeartsAndDomain(String domain) {

        return Optional.empty();
    }

}
