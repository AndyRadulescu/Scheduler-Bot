package ro.schedulerbot.bot_handler.handler;

import com.github.messenger4j.Messenger;
import com.github.messenger4j.exception.MessengerVerificationException;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/webhook")
public class WebHookTest {

    private static final String PAGE_ACCESS_TOEKN = "EAANz1ZAURlqQBACOhmoRy99TZCooAFy9dAxBeyPiEHcYx7Px7u94fEyp3SInE8eNP83mkpk1ph6hZBWobyFdgqalJt4YZBn6dHBHclDM1IfYC4RgpPPx6fIqiVCCc6dk4A9vYfbauH0ZBCgv4jiaBaYsn9SZCLKfAxSzSpZBiaxxQZDZD";

    private static final String APP_SECRET = "338782fe1cd09ed33909bda9aedd68a9";

    private static final String VERIFY_TOKEN = "TOKEN";

    private final Logger logger = Logger.getLogger(this.getClass());

    final Messenger messenger = Messenger.create(PAGE_ACCESS_TOEKN, APP_SECRET, VERIFY_TOKEN);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testMethod(@RequestParam("hub.mode") String mode,
                                     @RequestParam("hub.challenge") String challenge,
                                     @RequestParam("hub.verify_token") String verifyToken){
        try {
            messenger.verifyWebhook(mode, verifyToken);
            System.out.println("Webhook verification successful!");
            System.out.println("Mode: " + mode + " ,Verify Token: " + verifyToken);
            return ResponseEntity.ok(challenge);
        } catch (MessengerVerificationException e) {
            System.out.println("Invalid webhook: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public void testMethodPost(@RequestHeader RequestHeader header, @RequestBody RequestBody body){
        System.out.println("Post Event received");
        System.out.println(header.toString());
        System.out.println(body.toString());
    }







}
