package zoeque.omikujava.adapter;

import io.vavr.control.Try;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zoeque.omikujava.dto.FullFortuneSetDto;
import zoeque.omikujava.dto.ResultDto;
import zoeque.omikujava.usecase.FullSetOmikujiService;
import zoeque.omikujava.usecase.OmikujiService;

@RestController
@CrossOrigin(origins = "*")
public class OmikujiController {
  OmikujiService omikujiService;
  FullSetOmikujiService fullSetOmikujiService;

  public OmikujiController(OmikujiService omikujiService,
                           FullSetOmikujiService fullSetOmikujiService) {
    this.omikujiService = omikujiService;
    this.fullSetOmikujiService = fullSetOmikujiService;
  }

  @GetMapping("/omikuji")
  public ResponseEntity execute() {
    try {
      Try<ResultDto> executionTry = omikujiService.drawLottery();
      if (executionTry.isFailure()) {
        throw new RuntimeException(executionTry.getCause());
      }
      return ResponseEntity.ok().body(executionTry.get());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }

  @GetMapping("/omikuji/full")
  public ResponseEntity executeFullOmikuji() {
    try {
      Try<FullFortuneSetDto> lotteryTry = fullSetOmikujiService.drawLottery();
      if (lotteryTry.isFailure()) {
        throw new RuntimeException(lotteryTry.getCause());
      }
      return ResponseEntity.ok().body(lotteryTry.get());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }
}
