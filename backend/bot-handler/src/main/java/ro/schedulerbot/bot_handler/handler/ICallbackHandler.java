package ro.schedulerbot.bot_handler.handler;

import org.springframework.http.ResponseEntity;

public interface ICallbackHandler {

    ResponseEntity<String> verifyWebhook(String mode, String challenge, String verifyToken);

    void handleCallback(String payload, String signature);

    public static final String SIGNATURE_HEADER_NAME = "X-Hub-Signature";



}
