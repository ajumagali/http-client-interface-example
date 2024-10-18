package httpclientinterface.photo;

public record Photo(
      Integer albumId,
      Integer id,
      String title,
      String url,
      String thumbnailUrl
) {
}
