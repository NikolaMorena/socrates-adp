package ai.socrates.handlers;

import static com.appdirect.sdk.appmarket.events.APIResult.failure;
import static com.appdirect.sdk.appmarket.events.APIResult.success;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appdirect.sdk.appmarket.AppmarketEventHandler;
import com.appdirect.sdk.appmarket.events.APIResult;
import com.appdirect.sdk.appmarket.events.ErrorCode;
import com.appdirect.sdk.appmarket.events.UserUnassignment;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserUnassignmentHandler implements AppmarketEventHandler<UserUnassignment> {
	private static final Logger logger =LoggerFactory.getLogger(UserUnassignmentHandler.class);
	@Override
	public APIResult handle(UserUnassignment event) {
		ObjectMapper om= new ObjectMapper();
		try {
			String eventSerialized=om.writeValueAsString(event);
			logger.info("User Unassignment: {}", eventSerialized);
		} catch (IOException e) {
			logger.error("Logging User Unassignment failed", e);
		}
		
		return success("fake success message");
		//return failure(ErrorCode.OPERATION_CANCELLED, "This is not yet implemented");
	}
}
