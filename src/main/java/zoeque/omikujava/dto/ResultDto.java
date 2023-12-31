package zoeque.omikujava.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The result of omikuji.
 */
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonDeserialize(as = ResultDto.class)
public class ResultDto {
  @Getter
  String result;
}
