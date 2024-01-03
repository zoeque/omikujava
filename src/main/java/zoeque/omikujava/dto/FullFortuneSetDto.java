package zoeque.omikujava.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The full set of the omikuji fortunes.
 * this DTO includes your each fortune in this year.
 */
@JsonDeserialize(as = FullFortuneSetDto.class)
@AllArgsConstructor
@Getter
public class FullFortuneSetDto {
  ResultDto fortuneInThisYear;
  String fortuneInStudying;
  String fortuneInWorking;
  String fortuneOfLove;
  String fortuneOfMoney;
  String fortuneOfHealth;
}
