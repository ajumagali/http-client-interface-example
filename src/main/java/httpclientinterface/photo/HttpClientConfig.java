package httpclientinterface.photo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration(proxyBeanMethods = false)
@ImportHttpServices(PhotoClient.class)
public class HttpClientConfig {
}
