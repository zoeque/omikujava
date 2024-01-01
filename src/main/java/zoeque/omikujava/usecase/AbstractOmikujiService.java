package zoeque.omikujava.usecase;

import io.vavr.control.Try;
import java.util.Random;
import zoeque.omikujava.domain.model.OmikujiModel;

/**
 * The service class use command runner and execute binary files.
 */
public abstract class AbstractOmikujiService {

  /**
   * Execute drawing the omikuji.
   *
   * @return The ID of the {@link OmikujiModel} with the result {@link Try}.
   */
  protected Try<Integer> execute() {
    try {
      return Try.success(lottery().get());
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
