package gwangjang.server.domain.presentation;

import gwangjang.server.domain.application.dto.req.CommunityReq;
import gwangjang.server.domain.application.dto.res.CommunityRes;
import gwangjang.server.domain.application.service.CommunityCreateUseCase;
import gwangjang.server.domain.application.service.CommunityReadUseCase;
import gwangjang.server.global.response.SuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static gwangjang.server.domain.presentation.constant.CommunityResponseMessage.CREATE_COMMUNITY_SUCCESS;
import static gwangjang.server.domain.presentation.constant.CommunityResponseMessage.GET_COMMUNITY_SUCCESS;

@RestController
@AllArgsConstructor
public class CommunityController {

    private final CommunityCreateUseCase communityCreateUseCase;
    private final CommunityReadUseCase communityReadUseCase;


    @PostMapping("/{contentsId}")

    public ResponseEntity<SuccessResponse<CommunityRes>> createCommunity(@RequestHeader(value = "user-id") String socialId, @PathVariable("contentsId") Long contentsId, @RequestBody CommunityReq communityReq) {
        return ResponseEntity.ok(SuccessResponse.create(CREATE_COMMUNITY_SUCCESS.getMessage(), this.communityCreateUseCase.createCommunity(socialId, contentsId, communityReq)));
    }

    @GetMapping("/{domain}")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getCommunityList(@PathVariable String domain) {
        return ResponseEntity.ok(SuccessResponse.create(GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityList(domain)));
    }

}


