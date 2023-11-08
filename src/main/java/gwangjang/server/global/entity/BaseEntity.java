package gwangjang.server.global.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    private Long createdBy;
    private LocalDateTime createdAt;
    private Long lastModifiedBy;
    private LocalDateTime lastModifiedAt;
}
