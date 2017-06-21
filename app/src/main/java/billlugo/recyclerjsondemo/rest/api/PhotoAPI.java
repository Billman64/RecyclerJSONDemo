package billlugo.recyclerjsondemo.rest.api;

import java.util.List;

import billlugo.recyclerjsondemo.model.Photo;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by User on 6/20/2017.
 */

public interface PhotoAPI {
    @GET("photos")
    Observable<List<Photo>> getPhotos();


}
