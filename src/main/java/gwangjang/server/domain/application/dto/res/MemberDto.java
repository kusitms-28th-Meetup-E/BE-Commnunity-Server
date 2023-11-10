package gwangjang.server.domain.application.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private String memberId;
    private String nickname;;
    private String profileImage;;

}
