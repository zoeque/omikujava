package zoeque.omikujava.usecase;

import io.vavr.control.Try;
import org.springframework.stereotype.Service;
import zoeque.omikujava.domain.model.OmikujiModel;
import zoeque.omikujava.dto.ResultDto;

/**
 * The extension class of the omikuji service.
 */
@Service
public class OmikujiService extends AbstractOmikujiService {
  public Try<ResultDto> drawLottery() {
    return Try.success(
            new ResultDto(
                    OmikujiModel.omikujiExpression
                            .apply(super.chooseFortune().get())
            )
    );
  }
}
