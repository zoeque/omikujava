package zoeque.omikujava.usecase;

import io.vavr.control.Try;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import zoeque.omikujava.dto.ResultDto;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OmikujiServiceTest {

  @Autowired
  OmikujiService omikujiService;

  @Test
  public void attemptToLottery_thenReturnResult() {
    Try<ResultDto> resultDtoTry = omikujiService.drawLottery();
    Assertions.assertTrue(resultDtoTry.isSuccess());
  }
}
