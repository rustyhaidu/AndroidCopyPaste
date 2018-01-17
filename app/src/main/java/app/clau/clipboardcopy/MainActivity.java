package app.clau.clipboardcopy;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.hello);
        // final ClipData myClip = null;


        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData cData = ClipData.newPlainText("text", tv.getText());
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                clipboard.setPrimaryClip(cData);
                Toast.makeText(MainActivity.this, "Copied to clipboard" + clipboard.getPrimaryClip()
                        , Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
