package javapro.api.response;

import javapro.model.dto.PersonDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FriendsResponse {

    @Schema(description = "ошибка", example = "invalid_request")
    private String error;

    @Schema(description = "метка времени", example = "2147483648L")
    private Long timestamp;

    @Schema(description = "общее количество постов", example = "45l")
    private Long total;

    @Schema(description = "сдвиг для постраничного вывода", example = "0l")
    private Long offset;

    @Schema(description = "количество постов на страницу", example = "20l")
    private Long perPage;

    @Schema(description = "модель для вывода друзей")
    private List<PersonDTO> data;
}
