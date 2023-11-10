package gwangjang.server.domain.application.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private Long memberId;
    private String nickname;;
    private String profileImage;;

}
