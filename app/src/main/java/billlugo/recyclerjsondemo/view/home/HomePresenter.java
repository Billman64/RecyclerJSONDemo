package billlugo.recyclerjsondemo.view.home;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import billlugo.recyclerjsondemo.model.Photo;
import billlugo.recyclerjsondemo.rest.api.PhotoAPIHelper;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by User on 6/20/2017.
 */

public class HomePresenter implements HomeContract.Presenter{
    private  static final String TAG = HomePresenter.class.getSimpleName();
    HomeContract.View view;
    List<Photo> photos;

    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getPhotos() {
        photos = new ArrayList<>();
        Observable<List<Photo>> getPhotosObservable = PhotoAPIHelper.createGetPhotosObservable();

        getPhotosObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Photo>>() {
                    @Override
                    public void onCompleted() {
                        view.updatePhotoList(photos);
                        Log.d(TAG, "onCompleted()--" + photos.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showMessage("There was an error trying to fetch the pictures...");
                        Log.e(TAG, "onError()--", e);
                    }

                    @Override
                    public void onNext(List<Photo> photo) {
                        photos.addAll(photo);
                        Log.d(TAG, "onNext()--" + photos.size());

                    }
                });

    }
}
