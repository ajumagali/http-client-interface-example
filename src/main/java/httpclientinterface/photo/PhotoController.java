package httpclientinterface.photo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/photos")
public class PhotoController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  private final PhotoService photoService;
  private final PhotoClient photoClient;

  public PhotoController(PhotoService photoService,
                         PhotoClient photoClient) {
    this.photoService = photoService;
    this.photoClient = photoClient;
  }

  @GetMapping
  public Flux<Photo> getAll() {
    return photoService.getAll();
  }

  @GetMapping("/{id}")
  public Mono<Photo> getById(@PathVariable("id") String id) {
    return photoService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Photo> add(@RequestBody Photo photo) {
    return photoService.add(photo);
  }

  @GetMapping("/v2")
  public Flux<Photo> getAllV2() {
      logger.info("Getting all photos from v2");
      return photoClient.getAll();
  }

  @GetMapping("/v2/{id}")
  public Mono<Photo> getByIdV2(@PathVariable("id") String id) {
      logger.info("Getting photo by id {} from v2", id);
      return photoClient.getById(id);
    }

}
