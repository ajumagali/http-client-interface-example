package httpclientinterface.photo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class PhotoClientProxy {

  @Bean
  public PhotoClient photoClient() {
    final WebClient webClient = WebClient.builder()
          .baseUrl("https://jsonplaceholder.typicode.com/")
          .build();
    final WebClientAdapter webClientAdapter = WebClientAdapter
          .create(webClient);
    return HttpServiceProxyFactory.builderFor(webClientAdapter)
          .build()
          .createClient(PhotoClient.class);
  }
}