package zoeque.omikujava.usecase;

import io.vavr.control.Try;
import org.springframework.stereotype.Service;
import zoeque.omikujava.domain.model.OmikujiModel;
import zoeque.omikujava.dto.FullFortuneSetDto;
import zoeque.omikujava.dto.ResultDto;

/**
 * The full set omikuji based on
 */
@Service
public class FullSetOmikujiService extends AbstractOmikujiService {
  public Try<FullFortuneSetDto> drawLottery() {
    return Try.success(
            new FullFortuneSetDto(
                    new ResultDto(OmikujiModel.omikujiExpression
                            .apply(super.chooseFortune().get())),
                    OmikujiModel.omikujiExpression.apply(super.chooseFortune().get()),
                    OmikujiModel.omikujiExpression.apply(super.chooseFortune().get()),
                    OmikujiModel.omikujiExpression.apply(super.chooseFortune().get()),
                    OmikujiModel.omikujiExpression.apply(super.chooseFortune().get()),
                    OmikujiModel.omikujiExpression.apply(super.chooseFortune().get()))
    );
  }
}
