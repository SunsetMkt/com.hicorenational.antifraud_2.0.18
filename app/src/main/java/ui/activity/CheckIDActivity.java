package ui.activity;

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
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMShareAPI;
import interfaces.IClickListener;
import ui.callview.IDCheckView;
import ui.presenter.IDCheckPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class CheckIDActivity extends BaseActivity implements IDCheckView {

    @BindView(R.id.et_check_phone)
    EditText mEtCheckPhone;

    @BindView(R.id.idvrfy_list)
    View mIdVrfyList;

    @BindView(R.id.btn_idvrfy_send)
    Button mIdVrfySend;

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    private IDCheckPresenter mPresenter;

    @BindView(R.id.rl_acept_view)
    View mRlAceptRead;

    @BindView(R.id.tv_acept_read)
    TextView mTvAceptRead;

    @BindView(R.id.tv_no_read)
    TextView mTvNoReadNum;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private VerifyHomePointBean pointBean;

    class a implements IClickListener {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            Intent intent = new Intent(CheckIDActivity.this.mActivity, (Class<?>) BeforIdVerifyActivity.class);
            intent.putExtra(util.p1.e0, this.a);
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

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        this.mTvTitle.setText("\u8eab\u4efd\u6838\u5b9e");
        this.mPresenter = new IDCheckPresenter(this, this);
        try {
            this.pointBean = (VerifyHomePointBean) getIntent().getSerializableExtra(util.p1.f15011c);
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

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.getVerifyHomePoint();
    }

    @Override // ui.callview.IDCheckView
    public void onSuccCreateCheckRequest() {
        String string = this.mEtCheckPhone.getText().toString();
        util.f1.a(this.mActivity, "\u4e3a\u786e\u4fdd\u60a8\u672c\u4eba\u64cd\u4f5c\uff0c\u5b8c\u6210\u8eab\u4efd\u8ba4\u8bc1\u540e\u5373\u53ef\u5411\u8be5\u53f7\u7801\u53d1\u9001\u8eab\u4efd\u6838\u5b9e\u8bf7\u6c42" + string, "", "\u53d6\u6d88", "\u524d\u5f80\u9a8c\u8bc1", R.color._A8B4F7, R.color.blue_dark, (IClickListener) new a(string));
    }

    @Override // ui.callview.IDCheckView
    public void onSuccCreateRequest(VerifyHomePointBean verifyHomePointBean) {
        this.pointBean = verifyHomePointBean;
        initRedNum();
    }

    @OnClick({R.id.iv_back, R.id.rl_acept_view, R.id.btn_idvrfy_send, R.id.idvrfy_list})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_idvrfy_send /* 2131296411 */:
                String string = this.mEtCheckPhone.getText().toString();
                if (string.trim().length() >= 11) {
                    this.mPresenter.verifyCreateCheck(string);
                } else {
                    e2.a("\u8bf7\u8f93\u5165\u6b63\u786e\u624b\u673a\u53f7~");
                }
                break;
            case R.id.idvrfy_list /* 2131296741 */:
                startActivity(IDVarfyListActivity.class);
                this.mTvNoReadNum.setVisibility(8);
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.rl_acept_view /* 2131297326 */:
                startActivity(IDVarfyAceptListActivity.class);
                this.mTvAceptRead.setVisibility(8);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_id_check;
    }
}
