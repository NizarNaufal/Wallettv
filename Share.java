package id.wallet.walletapk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Share extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);

        findViewById(R.id.btn_aboutactivity).setOnClickListener(this);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub

        if (v.getId() == R.id.btn_aboutactivity) {
            Intent sendInt = new Intent(Intent.ACTION_SEND);
            sendInt.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            sendInt.putExtra(Intent.EXTRA_TEXT, "Text");
            sendInt.setType("text/plain");
            startActivity(Intent.createChooser(sendInt, "Bagikan Ke : "));

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
