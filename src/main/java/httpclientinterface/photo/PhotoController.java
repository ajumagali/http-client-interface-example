package httpclientinterface.photo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/photos")
public class PhotoController {

  private final PhotoService photoService;

  public PhotoController(PhotoService photoService) {
    this.photoService = photoService;
  }

  @GetMapping
  public Flux<Photo> getAll() {
    return photoService.getAll();
  }

  @GetMapping("/{id}")
  public Mono<Photo> getById(@PathVariable("id") String id) {
    return photoService.getById(id);
  }
}
