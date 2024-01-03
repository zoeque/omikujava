package zoeque.omikujava.domain.model;

import java.util.Arrays;
import java.util.function.Function;
import lombok.Getter;

/**
 * The model for omikuji.
 */
public class OmikujiModel {
  /**
   * The model of omikuji with kichi or kyou model.
   */
  public enum NewYearModel {
    DAIKYOU(0, "大凶"),
    KYOU(1, "凶"),
    SHOUKICHI(2, "小吉"),
    KICHI(3, "吉"),
    CHUUKICHI(4, "中吉"),
    DAIKICHI(5, "大吉");
    @Getter
    int id;
    @Getter
    String expression;

    NewYearModel(int id, String expression) {
      this.id = id;
      this.expression = expression;
    }
  }

  /**
   * The omikuji expression by ID
   */
  public static final Function<Integer, String> omikujiExpression
          = id -> {
    return Arrays.stream(OmikujiModel.NewYearModel.values())
            .filter(model -> model.getId() == id)
            .findFirst()
            .map(OmikujiModel.NewYearModel::getExpression)
            .orElse(null);
  };
}
