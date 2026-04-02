package ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.Hicore;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class EvidenceDiscActivity extends BaseActivity {

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.ed_describe)
    EditText mEtCaseDescribe;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private void initView() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("disc");
        this.mTvTitle.setText(stringExtra);
        this.mEtCaseDescribe.setText(stringExtra2);
        if (TextUtils.equals("\u6848\u60c5\u63cf\u8ff0", stringExtra)) {
            this.mEtCaseDescribe.setHint("\u8bf7\u8be6\u7ec6\u63cf\u8ff0\u6848\u4ef6\u7ecf\u8fc7\uff08\u65f6\u95f4\u3001\u5730\u70b9\u3001\u4eba\u7269\u3001\u539f\u56e0\u3001\u7ecf\u8fc7\u3001\u7ed3\u679c\uff09... ");
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        String string = this.mEtCaseDescribe.getText().toString();
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            org.greenrobot.eventbus.c.f().d(new util.n2.a(2, string));
            finish();
            return;
        }
        if (TextUtils.isEmpty(string)) {
            e2.a("\u8bf7\u586b\u5199\u4e3e\u62a5\u4fe1\u606f");
        } else {
            org.greenrobot.eventbus.c.f().d(new util.n2.a(2, string));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_evidence;
    }
}
