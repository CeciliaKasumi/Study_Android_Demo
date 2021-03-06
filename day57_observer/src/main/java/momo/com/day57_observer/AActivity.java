package momo.com.day57_observer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 观察者模式
 *
 * 本Demo：通过观察者模式更新A/B Activity的ImageView的图片
 */
public class AActivity extends AppCompatActivity {


    private Button btn;
    private ImageView img;
    private MyObserver observer;

    private MyObserver.Watcher wather = new MyObserver.Watcher(MessageImage.FROM_A) {
        @Override
        public void setImageId(MessageImage messageImage) {
            if (messageImage != null && messageImage.getImgId() != 0) {
                img.setImageResource(messageImage.getImgId());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        initMsg();

        
    }

    private void initMsg() {
        observer = MyObserver.getInstance();
        observer.addWatcher(wather);

    }

    private void setupViews() {
        btn = (Button) findViewById(R.id.btn);
        img = (ImageView) findViewById(R.id.iv);

        btn.setText("跳转到BActivity");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, BActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        observer.removeWatcher(wather);
    }
}
