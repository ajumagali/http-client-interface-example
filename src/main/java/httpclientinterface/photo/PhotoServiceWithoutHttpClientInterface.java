package httpclientinterface.photo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PhotoServiceWithoutHttpClientInterface {

  private final WebClient photoWebClient;

  public PhotoServiceWithoutHttpClientInterface() {
    photoWebClient = WebClient.builder()
          .baseUrl("https://jsonplaceholder.typicode.com")
          .build();
  }

  public Mono<Photo> getById(String id) {
    return photoWebClient.get()
          .uri(uriBuilder -> uriBuilder.path("photos/{photoId}").build(id))
          .retrieve()
          .bodyToMono(Photo.class);
  }

  public Flux<Photo> getAll() {
    return photoWebClient.get()
          .uri("photos")
          .retrieve()
          .bodyToFlux(Photo.class);
  }

  public Mono<Photo> add(Photo photo) {
    return photoWebClient.post()
          .uri("photos")
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
          .bodyValue(photo)
          .retrieve()
          .bodyToMono(Photo.class);
  }
}
