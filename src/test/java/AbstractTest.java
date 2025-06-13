import java.io.IOException;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.benavidesgonzalo.globallogic.desafiobci.controller.LoginController;
import cl.benavidesgonzalo.globallogic.desafiobci.controller.SignController;
import cl.benavidesgonzalo.globallogic.desafiobci.service.UserService;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(classes = {LoginController.class, SignController.class})
class AbstractTest {

    protected MockMvc mock;

    @MockBean
    UserService service;

    @Autowired
    WebApplicationContext context;

    @BeforeAll
    public void setUp() {
        mock = MockMvcBuilders.webAppContextSetup(context).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

}
