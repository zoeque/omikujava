package zoeque.omikujava.domain.model;

import java.util.Arrays;
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
   * Returns the omikuji expression by ID
   *
   * @param id The omikuji expression ID with int value
   * @return String expression. If there is no value mapping with the value, return null.
   */
  public static String getOmikujiExpression(int id) {
    return Arrays.stream(OmikujiModel.NewYearModel.values())
            .filter(model -> model.getId() == id)
            .findFirst()
            .map(OmikujiModel.NewYearModel::getExpression)
            .orElse(null);
  }
}
