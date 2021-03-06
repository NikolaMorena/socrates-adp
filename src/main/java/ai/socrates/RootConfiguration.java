package ai.socrates;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.appdirect.sdk.ConnectorSdkConfiguration;
import com.appdirect.sdk.appmarket.DeveloperSpecificAppmarketCredentialsSupplier;
import com.appdirect.sdk.credentials.StringBackedCredentialsSupplier;

import ai.socrates.handlers.EventHandlersConfiguration;

@Configuration
@Import({
		ConnectorSdkConfiguration.class,
		EventHandlersConfiguration.class
})
@EnableAutoConfiguration
@ComponentScan(basePackages = { "ai.socrates" })
public class RootConfiguration {

	@Bean
	public DeveloperSpecificAppmarketCredentialsSupplier environmentCredentialsSupplier(@Value("${connector.allowed.credentials}") String allowedCredentials) {
		return new StringBackedCredentialsSupplier(allowedCredentials);
	}
}
