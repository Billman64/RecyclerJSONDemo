package billlugo.recyclerjsondemo.view.home;

import java.util.List;

import billlugo.recyclerjsondemo.model.Photo;

/**
 * Created by User on 6/20/2017.
 */

public class HomeContract {
    public interface View {
        void updatePhotoList(List<Photo> result);
        void showMessage(String msg);
    }

    public interface  Presenter<V extends View> {
        void attachView(V view);
        void detachView();
        void getPhotos();
    }
}
