package gwangjang.server.domain.heart.application.mapper;

import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.domain.heart.application.dto.res.HeartRes;
import gwangjang.server.domain.heart.domain.entity.Heart;
import gwangjang.server.global.annotation.Mapper;

@Mapper
public class HeartMapper {


    public HeartRes mapToHeartRes(Heart heart) {
        return HeartRes.builder()
                .pusherId(heart.getPusherId())
                .communityId(heart.getCommunity().getId())
                .build();
    }

    public Heart mapToHeart(String pusherId, Community community, String status) {
        return Heart.builder()
                .pusherId(pusherId)
                .community(community)
                .status(Boolean.parseBoolean(status))
                .build();
    }
}
