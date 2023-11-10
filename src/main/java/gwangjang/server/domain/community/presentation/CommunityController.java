package gwangjang.server.domain.community.presentation;

import gwangjang.server.domain.community.application.dto.req.CommunityReq;
import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.application.service.CommunityCreateUseCase;
import gwangjang.server.domain.community.application.service.CommunityReadUseCase;
import gwangjang.server.domain.community.presentation.constant.CommunityResponseMessage;
import gwangjang.server.global.response.SuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommunityController {

    private final CommunityCreateUseCase communityCreateUseCase;
    private final CommunityReadUseCase communityReadUseCase;


    @PostMapping("contents/{contentsId}")
    public ResponseEntity<SuccessResponse<CommunityRes>> createCommunity(@RequestHeader(value = "user-id") String socialId, @PathVariable("contentsId") Long contentsId, @RequestBody CommunityReq communityReq) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.CREATE_COMMUNITY_SUCCESS.getMessage(), this.communityCreateUseCase.createCommunity(socialId, contentsId, communityReq)));
    }

    @GetMapping("/{domain}")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getCommunityList(@PathVariable String domain) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityList(domain)));
    }

}


