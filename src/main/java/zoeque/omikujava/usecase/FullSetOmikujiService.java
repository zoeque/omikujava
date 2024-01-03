package zoeque.omikujava.usecase;

import io.vavr.control.Try;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import zoeque.omikujava.domain.model.OmikujiModel;
import zoeque.omikujava.dto.FullFortuneSetDto;
import zoeque.omikujava.dto.ResultDto;

/**
 * The full set omikuji based on {@link FullFortuneSetDto}.
 */
@Service
public class FullSetOmikujiService extends AbstractOmikujiService {
  /**
   * Draw the full fortune and total fortune based on the score.
   *
   * @return The {@link FullFortuneSetDto} with the result {@link Try}
   */
  public Try<FullFortuneSetDto> drawLottery() {
    Integer fortuneIdOfStudying = super.chooseFortune().get();
    Integer fortuneIdOfWorking = super.chooseFortune().get();
    Integer fortuneIdOfLove = super.chooseFortune().get();
    Integer fortuneIdOfMoney = super.chooseFortune().get();
    Integer fortuneIdOfHealth = super.chooseFortune().get();

    return Try.success(
            new FullFortuneSetDto(
                    new ResultDto(OmikujiModel.omikujiExpression
                            .apply(determineAverageFortuneScore(
                                    fortuneIdOfStudying,
                                    fortuneIdOfWorking,
                                    fortuneIdOfLove,
                                    fortuneIdOfMoney,
                                    fortuneIdOfHealth
                            ))),
                    OmikujiModel.omikujiExpression.apply(fortuneIdOfStudying),
                    OmikujiModel.omikujiExpression.apply(fortuneIdOfWorking),
                    OmikujiModel.omikujiExpression.apply(fortuneIdOfLove),
                    OmikujiModel.omikujiExpression.apply(fortuneIdOfMoney),
                    OmikujiModel.omikujiExpression.apply(fortuneIdOfHealth)
            )
    );
  }

  private Integer determineAverageFortuneScore(Integer... fortuneIds) {
    double sum = Arrays.stream(fortuneIds)
            .mapToInt(Integer::intValue)
            .sum();
    double ave = sum / fortuneIds.length;
    BigDecimal decimal = new BigDecimal(ave);
    return decimal.setScale(1, RoundingMode.HALF_UP).intValue();
  }
}
