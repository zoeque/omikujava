package zoeque.omikujava.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OmikujiControllerTest {
  private MockMvc mvc;
  @Autowired
  OmikujiController controller;

  @BeforeEach
  public void setup() {
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void sendRequestToTheMockMvcController_thenReturnResult() throws Exception {
    mvc.perform(get("/omikuji")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(""))
            .andExpect(status().isOk());
  }
}
