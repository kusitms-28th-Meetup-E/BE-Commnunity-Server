package gwangjang.server.domain.community.domain.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.domain.entity.constant.CommunityOrderCondition;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static gwangjang.server.domain.community.domain.entity.QCommunity.community;

public class CommunityRepositoryImpl implements CommunityCustomRepository {

    private final JPAQueryFactory queryFactory;

    public CommunityRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Optional<List<CommunityRes>> findAllCommunityByTopic(String topic) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.constructor(CommunityRes.class,
                                community.id,
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.topic,
                                community.issue,
                                community.keyword,
                                community.hearts.size().longValue(),
                                community.comments.size().longValue(),
                                community.contentsId
                        ))
                        .from(community)
                        .where(community.topic.eq(topic))
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
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.topic,
                                community.issue,
                                community.keyword,
                                community.hearts.size().longValue(),
                                community.comments.size().longValue(),
                                community.contentsId
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
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.topic,
                                community.issue,
                                community.keyword,
                                community.hearts.size().longValue(),
                                community.comments.size().longValue(),
                                community.contentsId
                        ))
                        .from(community)
                        .where(community.id.eq(communityId))
                        .fetchFirst()
        );
    }

    @Override
    public Optional<List<CommunityRes>> findCommunityTop5ByHeartsAndTopic(String topic) {

        return Optional.empty();
    }

    @Override
    public Optional<List<CommunityRes>> findCommunityTop5(CommunityOrderCondition orderCondition, String word) {

        return Optional.ofNullable(queryFactory
                .select(Projections.constructor(CommunityRes.class,
                        community.id,
                        community.talk,
                        community.createdAt,
                        community.writerId,
                        community.topic,
                        community.issue,
                        community.keyword,
                        community.hearts.size().longValue(),
                        community.comments.size().longValue(),
                        community.contentsId
                ))
                .from(community)
                .where(
                        orderByColumn(orderCondition,word)

                ).orderBy(community.hearts.size().desc()) // hearts의 크기에 따라 내림차순 정렬
                .limit(5) // 상위 5개 결과만 선택
                .fetch());


    }


    private BooleanExpression orderByColumn(CommunityOrderCondition orderCondition, String word) {
        if (orderCondition.equals(CommunityOrderCondition.KEYWORD)) {
            return community.keyword.eq(word);
        } else if (orderCondition.equals(CommunityOrderCondition.ISSUE)) {
            return community.issue.eq(word);
        } else if (orderCondition.equals(CommunityOrderCondition.ALL)) {
            return null;
        } else{
            return community.topic.eq(word);
        }
    }


}
