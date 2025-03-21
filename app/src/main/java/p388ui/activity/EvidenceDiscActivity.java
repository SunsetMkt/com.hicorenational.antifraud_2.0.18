package p388ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import org.greenrobot.eventbus.C6049c;
import p388ui.Hicore;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class EvidenceDiscActivity extends BaseActivity {

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.ed_describe)
    EditText mEtCaseDescribe;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    private void initView() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("disc");
        this.mTvTitle.setText(stringExtra);
        this.mEtCaseDescribe.setText(stringExtra2);
        if (TextUtils.equals("案情描述", stringExtra)) {
            this.mEtCaseDescribe.setHint("请详细描述案件经过（时间、地点、人物、原因、经过、结果）... ");
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        String obj = this.mEtCaseDescribe.getText().toString();
        int id = view.getId();
        if (id != C2113R.id.btn_commit) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            C6049c.m24987f().m25000d(new C7265a(2, obj));
            finish();
            return;
        }
        if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请填写举报信息");
        } else {
            C6049c.m24987f().m25000d(new C7265a(2, obj));
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_evidence;
    }
}
