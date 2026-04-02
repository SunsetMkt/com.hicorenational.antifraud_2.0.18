package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.Hicore;

/* JADX INFO: loaded from: classes2.dex */
public class RecordHelpVideoActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private void initView() {
        this.mTvTitle.setText("\u5f55\u5236\u5e2e\u52a9");
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (!Hicore.getApp().isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_record_help_video;
    }
}
