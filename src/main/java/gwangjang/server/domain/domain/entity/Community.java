package gwangjang.server.domain.domain.entity;

import gwangjang.server.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Community extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String title;
    private String talk;

    private Long memberId;
    private Long contentsId;

    private String keyword;
    private String issue;
    private String domain; //keyWORD에서 가져오기
}
