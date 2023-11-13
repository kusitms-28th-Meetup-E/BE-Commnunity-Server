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


    /**
     * 커뮤니티 글 작성 (인용글 연결된 버튼 통해서만)
     * @param socialId 유저 정보
     * @param contentsId 인용글 정보
     * @param communityReq 커뮤니티 글 내용
     * @return
     */
    @PostMapping("/contents/{contentsId}")
    public ResponseEntity<SuccessResponse<CommunityRes>> createCommunity(@RequestHeader(value = "user-id") String socialId, @PathVariable("contentsId") Long contentsId, @RequestBody CommunityReq communityReq) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.CREATE_COMMUNITY_SUCCESS.getMessage(), this.communityCreateUseCase.create(socialId, contentsId, communityReq)));
    }


    /**
     * 커뮤니티 글 리스트업(전체)
     *ㄷㄱㄷ
     * @return
     */
    @GetMapping("")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getCommunityList() {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getAllCommunityList()));
    }


    /**
     * 커뮤니티 글 리스트업(영역별)
     * @param domain 영역 정보
     * @return
     */
    @GetMapping("/domain/{domain}")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getCommunityListByDomain(@PathVariable String domain) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityList(domain)));
    }

    /**
     * 커뮤니티 글 리스트텁(상세)
     * @param domain 영역 정보
     * @return
     */
    @GetMapping("/domain/{domain}/community/{communityId}")
    public ResponseEntity<SuccessResponse<CommunityRes>> getCommunityDetail(@PathVariable("domain") String domain, @PathVariable("communityId") Long communityId) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityDetail(domain,communityId)));
    }


}


