package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IEditAfterListener;
import p388ui.Hicore;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7268d1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ManualPhoneActivity extends BaseActivity {

    /* renamed from: a */
    private String f22558a;

    /* renamed from: b */
    private String f22559b;

    @BindView(C2113R.id.confirm)
    TextView mConfim;

    @BindView(C2113R.id.iv_clear)
    ImageView mIvClean;

    @BindView(C2113R.id.phone_code)
    EditText mPhoneCode;

    @BindView(C2113R.id.phone_label)
    TextView mPhoneLable;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    private void initListener() {
        C7268d1.m26310a(this.mPhoneCode, new IEditAfterListener() { // from class: ui.activity.l0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                ManualPhoneActivity.this.m25288a(i2);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25288a(int i2) {
        if (i2 > 0) {
            this.mConfim.setEnabled(true);
            this.mIvClean.setVisibility(0);
        } else {
            this.mConfim.setEnabled(false);
            this.mIvClean.setVisibility(4);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        C7161b.m25698a((Activity) this, true, true);
        this.mTvTitle.setText("");
        this.mPhoneLable.setTypeface(this.typ_ME);
        this.f22558a = getIntent().getStringExtra(C7292k1.f25389b0);
        this.f22559b = getIntent().getStringExtra(C7292k1.f25395d0);
        initListener();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_clear, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.confirm) {
            if (id == C2113R.id.iv_back) {
                finish();
                return;
            } else {
                if (id != C2113R.id.iv_clear) {
                    return;
                }
                this.mPhoneCode.setText("");
                return;
            }
        }
        String obj = this.mPhoneCode.getText().toString();
        if (obj.length() != 11) {
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) ManualCheckActivity.class);
        intent.putExtra(C7292k1.f25389b0, this.f22558a);
        intent.putExtra(C7292k1.f25398e0, obj);
        intent.putExtra(C7292k1.f25394d, false);
        intent.putExtra(C7292k1.f25395d0, this.f22559b);
        startActivity(intent);
        finish();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_phone_manual;
    }
}
