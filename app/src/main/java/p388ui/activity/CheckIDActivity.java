package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.VerifyHomePointBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.UMShareAPI;
import interfaces.IClickListener;
import p388ui.callview.IDCheckView;
import p388ui.presenter.IDCheckPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CheckIDActivity extends BaseActivity implements IDCheckView {

    @BindView(C2113R.id.et_check_phone)
    EditText mEtCheckPhone;

    @BindView(C2113R.id.idvrfy_list)
    View mIdVrfyList;

    @BindView(C2113R.id.btn_idvrfy_send)
    Button mIdVrfySend;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;
    private IDCheckPresenter mPresenter;

    @BindView(C2113R.id.rl_acept_view)
    View mRlAceptRead;

    @BindView(C2113R.id.tv_acept_read)
    TextView mTvAceptRead;

    @BindView(C2113R.id.tv_no_read)
    TextView mTvNoReadNum;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private VerifyHomePointBean pointBean;

    /* renamed from: ui.activity.CheckIDActivity$a */
    class C6234a implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ String f22138a;

        C6234a(String str) {
            this.f22138a = str;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            Intent intent = new Intent(CheckIDActivity.this.mActivity, (Class<?>) BeforIdVerifyActivity.class);
            intent.putExtra(C7292k1.f25398e0, this.f22138a);
            CheckIDActivity.this.startActivityForResult(intent, 100);
        }
    }

    private void initRedNum() {
        VerifyHomePointBean verifyHomePointBean = this.pointBean;
        if (verifyHomePointBean != null) {
            if (verifyHomePointBean.getToVerificationCount() > 0) {
                this.mRlAceptRead.setVisibility(0);
                this.mTvAceptRead.setVisibility(0);
                this.mTvAceptRead.setText("" + this.pointBean.getToVerificationCount());
            }
            if (this.pointBean.getPendingVerificationCount() > 0) {
                this.mTvNoReadNum.setVisibility(0);
                this.mTvNoReadNum.setText("" + this.pointBean.getPendingVerificationCount());
            }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        C7161b.m25698a((Activity) this, true, true);
        this.mTvTitle.setText("身份核实");
        this.mPresenter = new IDCheckPresenter(this, this);
        try {
            this.pointBean = (VerifyHomePointBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        } catch (Exception unused) {
        }
        initRedNum();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        UMShareAPI.get(this).onActivityResult(i2, i3, intent);
        if (i2 == -1) {
            this.mEtCheckPhone.setText("");
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.getVerifyHomePoint();
    }

    @Override // p388ui.callview.IDCheckView
    public void onSuccCreateCheckRequest() {
        String obj = this.mEtCheckPhone.getText().toString();
        C7257b1.m26183a(this.mActivity, "为确保您本人操作，完成身份认证后即可向该号码发送身份核实请求" + obj, "", "取消", "前往验证", C2113R.color._A8B4F7, C2113R.color.blue_dark, (IClickListener) new C6234a(obj));
    }

    @Override // p388ui.callview.IDCheckView
    public void onSuccCreateRequest(VerifyHomePointBean verifyHomePointBean) {
        this.pointBean = verifyHomePointBean;
        initRedNum();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.rl_acept_view, C2113R.id.btn_idvrfy_send, C2113R.id.idvrfy_list})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_idvrfy_send /* 2131296399 */:
                String obj = this.mEtCheckPhone.getText().toString();
                if (obj.trim().length() >= 11) {
                    this.mPresenter.verifyCreateCheck(obj);
                    break;
                } else {
                    C7331w1.m26688a("请输入正确手机号~");
                    break;
                }
            case C2113R.id.idvrfy_list /* 2131296700 */:
                startActivity(IDVarfyListActivity.class);
                this.mTvNoReadNum.setVisibility(8);
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.rl_acept_view /* 2131297185 */:
                startActivity(IDVarfyAceptListActivity.class);
                this.mTvAceptRead.setVisibility(8);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_id_check;
    }
}
