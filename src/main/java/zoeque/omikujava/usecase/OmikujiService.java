package zoeque.omikujava.usecase;

import io.vavr.control.Try;
import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zoeque.omikujava.domain.model.OmikujiModel;
import zoeque.omikujava.dto.ResultDto;

/**
 * The service class use command runner and execute binary files.
 */
@Service
public class OmikujiService {

  /**
   * The command execution method.
   * The command must be declared in application.properties.
   *
   * @return The success with message or the failure with an exception.
   */
  public Try<ResultDto> execute() {
    try {
      Try<Integer> lotteryTry = lottery();
      return Try.success(
              new ResultDto(OmikujiModel.getOmikujiExpression(lotteryTry.get()))
      );

    } catch (Exception e) {
      return Try.failure(e);
    }
  }

  /**
   * Select the omikuji with random value.
   *
   * @return The id of the omikuji.
   */
  private Try<Integer> lottery() {
    Random random = new Random();
    return Try.success(random.nextInt(OmikujiModel.NewYearModel.values().length));
  }
}
