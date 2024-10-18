package httpclientinterface.photo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebClient
class PhotoControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testGetAll() {
    webTestClient.get()
          .uri("/v1/photos")
          .exchange()
          .expectStatus().is2xxSuccessful()
          .returnResult(Photo.class)
          .getResponseBody()
          .subscribe(photo -> assertNotNull(photo.albumId()));
  }

  @Test
  void testGetById() {
    webTestClient.get()
          .uri("/v1/photos/1")
          .exchange()
          .expectStatus().is2xxSuccessful()
          .returnResult(Photo.class)
          .getResponseBody()
          .subscribe(photo -> {
            assertEquals(1, photo.id());
            assertEquals(1, photo.albumId());
          });
  }

}