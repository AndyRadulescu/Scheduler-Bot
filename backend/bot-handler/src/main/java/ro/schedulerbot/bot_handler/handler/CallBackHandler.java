package ro.schedulerbot.bot_handler.handler;

import com.github.messenger4j.Messenger;
import com.github.messenger4j.exception.MessengerApiException;
import com.github.messenger4j.exception.MessengerIOException;
import com.github.messenger4j.exception.MessengerVerificationException;
import com.github.messenger4j.send.MessagePayload;
import com.github.messenger4j.send.MessagingType;
import com.github.messenger4j.send.message.TextMessage;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.Optional;

@RestController
@RequestMapping("/webhook")
public class CallBackHandler implements ICallbackHandler{

    private static final String PAGE_ACCESS_TOKEN = "EAANz1ZAURlqQBACOhmoRy99TZCooAFy9dAxBeyPiEHcYx7Px7u94fEyp3SInE8eNP83mkpk1ph6hZBWobyFdgqalJt4YZBn6dHBHclDM1IfYC4RgpPPx6fIqiVCCc6dk4A9vYfbauH0ZBCgv4jiaBaYsn9SZCLKfAxSzSpZBiaxxQZDZD";

    private static final String APP_SECRET = "338782fe1cd09ed33909bda9aedd68a9";

    private static final String VERIFY_TOKEN = "TOKEN";

    final Messenger messenger = Messenger.create(PAGE_ACCESS_TOKEN, APP_SECRET, VERIFY_TOKEN);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> verifyWebhook(@RequestParam("hub.mode") String mode,
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
    public void handleCallback(@RequestBody final String payload, @RequestHeader(SIGNATURE_HEADER_NAME) final String signature){
        System.out.println("Post Event received");
        System.out.println(payload);
        System.out.println(signature);
        try {
            messenger.onReceiveEvents(payload, Optional.of(signature), event -> {
                final String senderId = event.senderId();
                if (event.isTextMessageEvent()) {
                    final String text = event.asTextMessageEvent().text();
                    final TextMessage textMessage = TextMessage.create(text);
                    final MessagePayload messagePayload = MessagePayload.create(senderId,
                            MessagingType.RESPONSE, textMessage);
                    try {
                        messenger.send(messagePayload);
                    } catch (MessengerApiException | MessengerIOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch(MessengerVerificationException e){
            e.printStackTrace();
        }
    }







}
