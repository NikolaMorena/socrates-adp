package ai.socrates.handlers;

import static com.appdirect.sdk.appmarket.events.APIResult.success;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appdirect.sdk.appmarket.AppmarketEventHandler;
import com.appdirect.sdk.appmarket.events.APIResult;
import com.appdirect.sdk.appmarket.events.SubscriptionCancel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SubscriptionCancelHandler implements AppmarketEventHandler<SubscriptionCancel> {
	private static final Logger logger =LoggerFactory.getLogger(SubscriptionCancelHandler.class);
	
	@Override
	public APIResult handle(SubscriptionCancel event) {
		logger.info("Subscription accountId={} canceled", event.getAccountIdentifier());
		
		ObjectMapper om= new ObjectMapper();
		try {
			String eventSerialized=om.writeValueAsString(event);
			logger.info(eventSerialized);
		} catch (IOException e) {
			logger.error("Logging new subscription failed", e);
		}
		return success("fake success message");
	}
}
