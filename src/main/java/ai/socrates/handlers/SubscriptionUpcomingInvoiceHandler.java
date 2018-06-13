package ai.socrates.handlers;

import static com.appdirect.sdk.appmarket.events.APIResult.success;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appdirect.sdk.appmarket.AppmarketEventHandler;
import com.appdirect.sdk.appmarket.events.APIResult;
import com.appdirect.sdk.appmarket.events.SubscriptionUpcomingInvoice;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SubscriptionUpcomingInvoiceHandler implements AppmarketEventHandler<SubscriptionUpcomingInvoice> {
	private static final Logger logger =LoggerFactory.getLogger(SubscriptionUpcomingInvoiceHandler.class);
	@Override
	public APIResult handle(SubscriptionUpcomingInvoice event) {
		ObjectMapper om= new ObjectMapper();
		try {
			String eventSerialized=om.writeValueAsString(event);
			logger.info("SubscriptionUpcomingInvoiceHandler: {}", eventSerialized);
		} catch (IOException e) {
			logger.error("Logging new subscription failed", e);
		}

		return success("fake success message");
	}
}
