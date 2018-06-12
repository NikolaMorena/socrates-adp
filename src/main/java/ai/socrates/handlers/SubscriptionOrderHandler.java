package ai.socrates.handlers;

import static com.appdirect.sdk.appmarket.events.APIResult.success;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appdirect.sdk.appmarket.AppmarketEventHandler;
import com.appdirect.sdk.appmarket.events.APIResult;
import com.appdirect.sdk.appmarket.events.SubscriptionOrder;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SubscriptionOrderHandler implements AppmarketEventHandler<SubscriptionOrder> {
	private static final Logger logger =LoggerFactory.getLogger(SubscriptionOrderHandler.class);
	@Override
	public APIResult handle(SubscriptionOrder event) {
		ObjectMapper om= new ObjectMapper();
		try {
			String eventSerialized=om.writeValueAsString(event);
			logger.info("New subscription: {}", eventSerialized);
		} catch (IOException e) {
			logger.error("Logging new subscription failed", e);
		}
		APIResult result = success("fake success message");
		result.setAccountIdentifier("fake-account-identifier");
		return result;
	}
}
