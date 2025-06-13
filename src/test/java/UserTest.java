import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cl.benavidesgonzalo.globallogic.desafiobci.model.Phone;
import cl.benavidesgonzalo.globallogic.desafiobci.model.User;


public class UserTest extends AbstractTest {

    @Test
    public void signUpTest() throws Exception {
        String uri = "/sign-up";
        User user = getUtilUser();
        String inputJson = super.mapToJson(user);

//        when(service.addUser(user)).thenReturn(user);

        MvcResult result = mock.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andDo(MockMvcResultHandlers.print()).andReturn();

        int status = result.getResponse().getStatus();

        assertEquals(201, status);

        String content = result.getResponse().getContentAsString();
        assertEquals(content, "User valid");

    }

    @Test
    public void loginTest() throws Exception {
        String uri = "/login";
        String token = "1234-1234-1234-1234-1234-1234-1234-1234";
        
        when(service.findUserByToken(token)).thenReturn(this.getUtilUser());
        
        String inputJson = super.mapToJson(token);

        MvcResult result = mock.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andDo(MockMvcResultHandlers.print()).andReturn();

        int status = result.getResponse().getStatus();

        assertEquals(201, status);

        String content = result.getResponse().getContentAsString();
        assertEquals(content, "Token valid");
        
    }

    public User getUtilUser(){
        List<Phone> phones = new ArrayList<>();
        
        for(int i = 1; i <= 3; i++){
            Phone p = new Phone();
            p.setNumber(Long.valueOf(i*111111111));
            p.setCityCode(9);
            p.setCountryCode("+56");
            phones.add(p);
        }
        User user = new User("Admin","aaaa@bbb.ccc","Password12", phones);
        return user;
    }

}
