package billlugo.recyclerjsondemo.view.detail;

/**
 * Created by User on 6/21/2017.
 */

public class DetailContract {
    public interface View {

    }

    public interface  Presenter<V extends View> {
        void attachView(V view);
        void detachView();

    }
}
