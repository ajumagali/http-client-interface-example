package httpclientinterface.photo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PhotoService {
  private final PhotoClient photoClient;

  public PhotoService(PhotoClient photoClient) {
    this.photoClient = photoClient;
  }

  public Mono<Photo> getById(String id) {
    return photoClient.getById(id);
  }

  public Flux<Photo> getAll() {
    return photoClient.getAll();
  }

  public Mono<Photo> add(Photo photo) {
    return photoClient.add(photo,  null);
  }
}
