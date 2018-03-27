package ro.schedulerbot.bot_handler.handler;

//import com.github.messenger4j.Messenger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/webhook")
public class WebHookTest {

    private static final String PAGE_ACCESS_TOEKN = "";

    private static final String APP_SECRET = "";

    private static final String VERIFY_TOEKN = "";

   // final Messenger messenger = Messenger.create(PAGE_ACCESS_TOEKN, APP_SECRET, VERIFY_TOEKN);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String testMethod(){
        return "Hello World";
    }





}
