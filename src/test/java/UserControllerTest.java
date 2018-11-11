import com.gareth.userappws.ui.controller.UserController;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

public class UserControllerTest {

    private static Dispatcher dispatcher;
    private static POJOResourceFactory noDefaults;

    @BeforeClass
    public static void setup() {
        dispatcher = MockDispatcherFactory.createDispatcher();
        noDefaults = new POJOResourceFactory(UserController.class);
        dispatcher.getRegistry().addResourceFactory(noDefaults);
    }

    @Test
    public void testUrlShouldReturnHello() {
        try {
            MockHttpRequest request = MockHttpRequest.get("/hello");
            MockHttpResponse response = new MockHttpResponse();

            dispatcher.invoke(request, response);

            Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

            Assert.assertEquals("hello", response.getContentAsString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}