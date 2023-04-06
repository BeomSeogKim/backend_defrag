package practice.restdocs.domain.dto;

import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class PostResponseDto {
    private String name;
    private String content;
}
