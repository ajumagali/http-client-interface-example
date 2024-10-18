package httpclientinterface.photo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@HttpExchange("/photos")
public interface PhotoClient {
  @GetExchange
  Flux<Photo> getAll();

  @GetExchange("{id}")
  Mono<Photo> getById(@PathVariable("id") String id);

  @PostExchange
  Mono<Photo> add(
        @RequestBody Photo photo,
        @RequestHeader(value = HttpHeaders.CONTENT_TYPE,
              defaultValue = MediaType.APPLICATION_JSON_VALUE) String contentType);
}