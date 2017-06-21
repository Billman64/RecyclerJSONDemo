package billlugo.recyclerjsondemo.view.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import billlugo.recyclerjsondemo.R;
import billlugo.recyclerjsondemo.model.Photo;
import billlugo.recyclerjsondemo.model.adapter.PhotoAdapter;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {
    List<Photo> photos;
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    PhotoAdapter adapter;
    HomeContract.Presenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photos = new ArrayList<>();
        rv = (RecyclerView) findViewById(R.id.rv);
        lm = new GridLayoutManager(this, 2);
        adapter = new PhotoAdapter(photos);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        presenter = new HomePresenter();
        presenter.attachView(this);
        presenter.getPhotos();
    }

    @Override
    public void updatePhotoList(List<Photo> result) {
        this.photos.clear();
        this.photos.addAll(result);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
