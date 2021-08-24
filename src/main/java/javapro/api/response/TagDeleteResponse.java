package javapro.api.response;

import javapro.model.dto.TagDeleteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagDeleteResponse {
    @Schema(description = "ошибка", example = "success")
    private String error;

    @Schema(description = "метка времени", example = "2147483648L")
    private Long timestamp;

    @Schema(description = "объект TagDeleteDTO")
    private TagDeleteDTO data;
}
