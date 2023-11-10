package gwangjang.server.domain.application.feign.client;

import gwangjang.server.domain.application.feign.dto.ContentsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="contentsService")
public interface FindContentsFeignClient {

    @GetMapping("/get/{contentsId}")
    ContentsDto getContents(@PathVariable("contentsId") Long contentsId);
}
