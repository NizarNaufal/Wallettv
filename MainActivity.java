package id.wallet.walletapk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    final String Email = "nizarnfl21@gmail.com"; //

    GridView grid; //Grid
    GridAdapter adapter; //grid
    String[] Judul; // grid
    int[] image; // grid
    private TextView messageView;

    SliderLayout sliderLayout ;

    HashMap<String, String> HashMapForURL ;

    HashMap<String, Integer> HashMapForLocalRes ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Deklarasi button



        // slide view gambar

        sliderLayout = (SliderLayout) findViewById(R.id.slider);

        //Call this method if you want to add images from URL .
        AddImagesUrlOnline();

        //Call this method to add images from local drawable folder .
        //AddImageUrlFormLocalRes();

        //Memanggil otomatis sliding menu.
        //sliderLayout.stopAutoCycle();

        for (String name : HashMapForURL.keySet()) {

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);

            textSliderView
                    .description(name)
                    .image(HashMapForURL.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderLayout.setCustomAnimation(new DescriptionAnimation());

        sliderLayout.setDuration(3000);

        sliderLayout.addOnPageChangeListener(MainActivity.this);
    }

    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void AddImagesUrlOnline() {

        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put("Bein Sports", "http://www.matrixtv.co.id/ualf/homeSlideshow/14/0_o_1471506866.jpg");
        HashMapForURL.put("Cara TOP-UP", "http://www.matrixtv.co.id/ualf/homeSlideshow/17/0_o_1477470568.jpg");
        HashMapForURL.put("Petunjuk Penggunaan", "http://www.matrixtv.co.id/ualf/homeSlideshow/20/0_o_1478922318.jpg");

        // GridView Awal

        Judul = new String[]{"Saluran", "Scan", "Lokasi Toko", "Shop", "Berita",};
        image = new int[]{R.mipmap.saluran, R.mipmap.berita, R.mipmap.location, R.mipmap.shop, R.mipmap.berita,};

        grid = (GridView) findViewById(R.id.gridview);
        adapter = new GridAdapter(getApplicationContext(), Judul, image);
        grid.setAdapter(adapter);

        // kasih fungsi jika diklik
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                /* KETERANGAN!!

                kalo di gridview mau dikasih activity / intent pake kodingan ini :

                    myIntent = new Intent(view.getContext(), SitusSekolah.class);

                cuma kalo mau main ACTION_VIEW silahkan pake ini :

                    myIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://twitter.com/official_Tels"));

                    sesuain kebutuhan aja..

                   --> image & judul bisa kalian ubah, intinya 1 gridview itu 1 judul & image.

                 */

                Intent myIntent = null;
                if (position == 0) {
                    //myIntent = new Intent(view.getContext(), SitusSekolah.class); <!-- contoh Kalo Mau Kasih Intent -->
                    myIntent = new Intent(view.getContext(), Saluran.class);
                }
                if (position == 1) {
                    //myIntent = new Intent(view.getContext(), LetakSekolah.class); <!-- contoh Kalo Mau Kasih Intent -->
                    myIntent = new Intent(view.getContext(), Saluran.class);
                }
                if (position == 2) {
                    myIntent = new Intent(view.getContext(), Saluran.class);
                }
                if (position == 3) {
                    myIntent = new Intent(view.getContext(), Saluran.class);
                }
                if (position == 4) {
                    myIntent = new Intent(view.getContext(), Saluran.class);
                }
                startActivity(myIntent);

            }

        });

    }

    //GridView Akhir

    public void onBackPressed() {
        finish();//Pergi ke method exit
    }
}