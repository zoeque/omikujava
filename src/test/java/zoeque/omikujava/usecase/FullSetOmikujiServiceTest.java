package zoeque.omikujava.usecase;

import io.vavr.control.Try;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import zoeque.omikujava.dto.FullFortuneSetDto;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FullSetOmikujiServiceTest {
  @Autowired
  FullSetOmikujiService service;

  @Test
  public void givenService_attemptLottery_returnSuccess() {
    Try<FullFortuneSetDto> serviceTry = service.drawLottery();
    Assertions.assertTrue(serviceTry.isSuccess());
  }
}
