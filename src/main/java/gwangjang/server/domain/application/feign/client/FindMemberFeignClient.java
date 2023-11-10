package gwangjang.server.domain.application.feign.client;

import gwangjang.server.domain.application.dto.res.MemberDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="MEMBERSERVICE")
public interface FindMemberFeignClient {

    @GetMapping("/auth/feign/{socialId}")
    MemberDto getMemberBySocialId(@PathVariable("socialId") String socialId);

    @GetMapping("/auth/feign/{memberId}")
    MemberDto getMemberByMemberId(@PathVariable("memberId") Long memberId);
}
