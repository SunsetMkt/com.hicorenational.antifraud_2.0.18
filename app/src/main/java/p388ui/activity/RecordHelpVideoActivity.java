package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import p388ui.Hicore;

/* loaded from: classes2.dex */
public class RecordHelpVideoActivity extends BaseActivity {

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    private void initView() {
        this.mTvTitle.setText("录制帮助");
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @OnClick({C2113R.id.iv_back})
    public void onViewClicked(View view) {
        if (!Hicore.getApp().isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_record_help_video;
    }
}
