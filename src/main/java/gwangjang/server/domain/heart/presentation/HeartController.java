package gwangjang.server.domain.heart.presentation;


import gwangjang.server.domain.comment.application.dto.req.CommentReq;
import gwangjang.server.domain.comment.application.dto.res.CommentRes;
import gwangjang.server.domain.comment.presentation.constant.CommentResponseMessage;
import gwangjang.server.domain.heart.application.dto.res.HeartRes;
import gwangjang.server.domain.heart.application.service.HeartUpdateUseCase;
import gwangjang.server.domain.heart.domain.service.HeartSaveService;
import gwangjang.server.global.response.SuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/contents/{contentsId}/community/{communityId}/heart")
public class HeartController {

    private final HeartUpdateUseCase heartUpdateUseCase;

    @PutMapping("/{heartStatus}")
    public ResponseEntity<SuccessResponse<HeartRes>> pushHeart(@RequestHeader(value = "user-id") String socialId,
                                                               @PathVariable("contentsId") Long contentsId, @PathVariable("communityId") Long communityId,
                                                               @PathVariable("heartStatus") String heartStatus) {
        return ResponseEntity.ok(SuccessResponse.create(CommentResponseMessage.CREATE_COMMENT_SUCCESS.getMessage(), this.heartUpdateUseCase.pushHeart(socialId, communityId,heartStatus)));
    }

}