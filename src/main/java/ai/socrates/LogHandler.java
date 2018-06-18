package ai.socrates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogHandler {
	private static final Logger logger =LoggerFactory.getLogger(LogHandler.class);
	
	@Value("${ADP_MARKETPLACE_LOG_FILE}")
	String logFilePath;
	
	@RequestMapping(value="/get-log", method = {RequestMethod.GET}, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> initiateLogin(){
		try {
			String content = new String(Files.readAllBytes(Paths.get(logFilePath)));
			return new ResponseEntity<String>(content, HttpStatus.OK);
		} catch (IOException e) {
			logger.error("Failed to get log file ", e);
			return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
