package billlugo.recyclerjsondemo.view.detail;

/**
 * Created by User on 6/21/2017.
 */

public class DetailPresenter implements DetailContract.Presenter {
    private DetailContract.View view;

    @Override
    public void attachView(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
