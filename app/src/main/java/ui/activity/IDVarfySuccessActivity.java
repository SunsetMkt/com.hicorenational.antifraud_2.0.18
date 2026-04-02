package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class IDVarfySuccessActivity extends BaseActivity {
    String a;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.tv_tips)
    TextView mTvTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("\u6838\u5b9e\u5b8c\u6210");
        this.a = getIntent().getStringExtra(util.p1.k0);
        this.mTvTips.setText("\u606d\u559c\u60a8\u5b8c\u6210\u201c\u8eab\u4efd\u6838\u5b9e\u201d\n\n\u6838\u5b9e\u7ed3\u679c\u5c06\u4f20\u8fbe\u7ed9\u8bf7\u6c42\u65b9" + this.a);
    }

    @OnClick({R.id.iv_back, R.id.btn_idvrfy_start})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btn_idvrfy_start || id == R.id.iv_back) {
            org.greenrobot.eventbus.c.f().d(new util.n2.a(39, null));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_id_var_ok;
    }
}
