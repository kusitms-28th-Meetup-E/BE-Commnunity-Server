package gwangjang.server.global.feign.client;

import gwangjang.server.domain.community.application.dto.res.ContentsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="contentsService")
public interface FindContentsFeignClient {

    @GetMapping("/get/{contentsId}")
    ContentsDto getContents(@PathVariable("contentsId") Long contentsId);
}
