package p388ui.activity;

import android.os.Handler;
import android.widget.ImageView;
import butterknife.BindView;
import com.hicorenational.antifraud.C2113R;
import com.umeng.analytics.MobclickAgent;

/* loaded from: classes2.dex */
public class PreviewShotScreenActivity extends BaseActivity {

    @BindView(C2113R.id.iv_shot_screen_preview)
    ImageView ivShotScreenPreview;

    /* renamed from: ui.activity.PreviewShotScreenActivity$a */
    class RunnableC6442a implements Runnable {
        RunnableC6442a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PreviewShotScreenActivity.this.finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.ivShotScreenPreview.setImageURI(getIntent().getData());
        new Handler().postDelayed(new RunnableC6442a(), 2000L);
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        getWindow().setFlags(1024, 1024);
        return C2113R.layout.activity_preview_shot_screen;
    }
}
