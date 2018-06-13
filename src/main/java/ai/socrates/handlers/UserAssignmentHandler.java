package ai.socrates.handlers;

import static com.appdirect.sdk.appmarket.events.APIResult.failure;
import static com.appdirect.sdk.appmarket.events.APIResult.success;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appdirect.sdk.appmarket.AppmarketEventHandler;
import com.appdirect.sdk.appmarket.events.APIResult;
import com.appdirect.sdk.appmarket.events.UserAssignment;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserAssignmentHandler implements AppmarketEventHandler<UserAssignment> {
	private static final Logger logger =LoggerFactory.getLogger(UserAssignmentHandler.class);
	@Override
	public APIResult handle(UserAssignment event) {
		ObjectMapper om= new ObjectMapper();
		try {
			String eventSerialized=om.writeValueAsString(event);
			logger.info("User Assignment: {}", eventSerialized);
		} catch (IOException e) {
			logger.error("Logging User Assignment failed", e);
		}
		return success("fake success message");
		//return failure(ErrorCode.OPERATION_CANCELLED, "This is not yet implemented");
	}
}
