package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import ui.Hicore;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class ManualPhoneActivity extends BaseActivity {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13501b;

    @BindView(R.id.confirm)
    TextView mConfim;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.phone_code)
    EditText mPhoneCode;

    @BindView(R.id.phone_label)
    TextView mPhoneLable;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private void initListener() {
        util.h1.a(this.mPhoneCode, new IEditAfterListener() { // from class: ui.activity.n0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                this.a.a(i2);
            }
        });
    }

    public /* synthetic */ void a(int i2) {
        if (i2 > 0) {
            this.mConfim.setEnabled(true);
            this.mIvClean.setVisibility(0);
        } else {
            this.mConfim.setEnabled(false);
            this.mIvClean.setVisibility(4);
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        this.mTvTitle.setText("");
        this.mPhoneLable.setTypeface(this.typ_ME);
        this.a = getIntent().getStringExtra(util.p1.b0);
        this.f13501b = getIntent().getStringExtra(util.p1.d0);
        initListener();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.iv_back, R.id.iv_clear, R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.confirm) {
            if (id == R.id.iv_back) {
                finish();
                return;
            } else {
                if (id != R.id.iv_clear) {
                    return;
                }
                this.mPhoneCode.setText("");
                return;
            }
        }
        String string = this.mPhoneCode.getText().toString();
        if (string.length() != 11) {
            e2.a("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) ManualCheckActivity.class);
        intent.putExtra(util.p1.b0, this.a);
        intent.putExtra(util.p1.e0, string);
        intent.putExtra(util.p1.f15012d, false);
        intent.putExtra(util.p1.d0, this.f13501b);
        startActivity(intent);
        finish();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_phone_manual;
    }
}
