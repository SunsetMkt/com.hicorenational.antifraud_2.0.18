package ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.ITextCallBackListener;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import manager.AccountManager;
import ui.Hicore;
import ui.callview.HandleIDVarfyFaceView;
import ui.presenter.HandleIDVarfyFacePresenter;
import ui.presenter.HelperPresenter;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class HandleIDVerifyActivity extends BaseActivity implements HandleIDVarfyFaceView {

    @BindView(R.id.btn_idvrfy_start)
    Button mConfirm;

    @BindView(R.id.user_name)
    EditText mEtName;

    @BindView(R.id.user_ID)
    EditText mEtUserId;

    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new d();

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    private HelperPresenter mPresent;
    private HandleIDVarfyFacePresenter mPresenter;

    @BindView(R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(R.id.tv_right)
    TextView mTvRight;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    String strIDNumber;
    String strName;
    String verifyId;
    String verifyNameFrid;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            HandleIDVerifyActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                HandleIDVerifyActivity.this.intentFace();
            } else if (util.permissionutil.c.f()) {
                HandleIDVerifyActivity.this.intentFace();
            } else {
                HandleIDVerifyActivity.this.camerPrimssDlg(false);
            }
        }
    }

    class b implements IClickListener {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.a) {
                util.p1.j(HandleIDVerifyActivity.this.mActivity);
            } else {
                HandleIDVerifyActivity.this.varCamerPrims();
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HandleIDVerifyActivity.this.confirm(this.a);
        }
    }

    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != -2) {
                HandleIDVerifyActivity.this.hideProgressDialog();
            }
            if (i2 == 999) {
                HandleIDVerifyActivity.this.startActivity(IDVarfyFaceActivity.class);
            }
            switch (i2) {
                case 1:
                    e2.a("\u6838\u9a8c\u6210\u529f");
                    org.greenrobot.eventbus.c.f().d(new util.n2.a(38, null));
                    HandleIDVerifyActivity handleIDVerifyActivity = HandleIDVerifyActivity.this;
                    AccountManager.setVerified(true, handleIDVerifyActivity.strName, handleIDVerifyActivity.strIDNumber);
                    Intent intent = new Intent(HandleIDVerifyActivity.this.mActivity, (Class<?>) IDVarfySuccessActivity.class);
                    intent.putExtra(util.p1.k0, HandleIDVerifyActivity.this.verifyNameFrid);
                    HandleIDVerifyActivity.this.startActivity(intent);
                    HandleIDVerifyActivity.this.mActivity.finish();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    HandleIDVerifyActivity.this.startActivity(IDVarfyFaceActivity.class);
                    break;
                case 8:
                    org.greenrobot.eventbus.c.f().d(new util.n2.a(39, null));
                    e2.a("\u6838\u9a8c\u6570\u636e\u5df2\u8fc7\u671f~");
                    HandleIDVerifyActivity.this.finish();
                    break;
                default:
                    HandleIDVerifyActivity.this.startActivity(IDVarfyFaceActivity.class);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        util.f1.f(this.mActivity, "\u6743\u9650\u5f00\u542f", "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3\u672a\u53d6\u5f97\u6743\u9650\uff0c\u8fd9\u6837\u4f1a\u5bfc\u81f4\u6b64\u529f\u80fd\u65e0\u6cd5\u4f7f\u7528\u3002", "\u53d6\u6d88", "\u53bb\u6388\u6743", new b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm(String str) {
        if (TextUtils.isEmpty(str)) {
            e2.a("\u8bf7\u91cd\u62cd");
            return;
        }
        if (TextUtils.isEmpty(this.strName) || TextUtils.isEmpty(this.strIDNumber)) {
            e2.a("\u8bf7\u91cd\u65b0\u586b\u5165\u4e2a\u4eba\u4fe1\u606f");
            finish();
        } else {
            util.f1.a("\u4eba\u8138\u8bc6\u522b\u4e2d\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", false, this.mActivity);
            this.mPresenter.verifyAction(str, this.strName, this.strIDNumber, this.verifyId);
        }
    }

    private void getIntentData() {
        this.verifyId = getIntent().getStringExtra(util.p1.c0);
        this.verifyNameFrid = getIntent().getStringExtra(util.p1.b0);
    }

    private void initCluse() {
        String str = "\u60a8\u540c\u610f\u901a\u8fc7\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3APP\u4f20\u8fbe\u672c\u4eba\u8eab\u4efd\u6838\u5b9e\u4fe1\u606f\u7ed9\u8bf7\u6c42\u65b9\u67e5\u770b\u534f\u8bae\u8be6\u60c5>";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ui.view.q(str, new ITextCallBackListener() { // from class: ui.activity.w
            @Override // interfaces.ITextCallBackListener
            public final void onResult(String str2) {
                this.a.a(str2);
            }
        }), 28, str.length(), 33);
        this.mTvSelectTips.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTvSelectTips.setText(spannableString);
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.x
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        Editable text = this.mEtName.getText();
        this.strName = TextUtils.isEmpty(text) ? "" : text.toString();
        Editable text2 = this.mEtUserId.getText();
        this.strIDNumber = TextUtils.isEmpty(text2) ? "" : text2.toString();
        if (this.strName.length() < 2 || this.strName.length() > 22 || !g2.x(this.strName)) {
            e2.a("\u59d3\u540d\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
        } else if (util.m1.b(this.strIDNumber)) {
            this.mPresenter.startLive();
        } else {
            e2.a("\u8eab\u4efd\u8bc1\u53f7\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
        }
    }

    private void pctureTaken(byte[] bArr) {
        Bitmap bitmapA = bArr != null ? util.j1.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
        if (bitmapA != null) {
            ByteArrayOutputStream byteArrayOutputStreamA = util.j1.a(bitmapA, e.d.E);
            String strA = util.b1.a(byteArrayOutputStreamA);
            try {
                byteArrayOutputStreamA.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            runOnUiThread(new c(strA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f15026c}, new a());
    }

    public /* synthetic */ void a(String str) {
        Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
        intent.putExtra(util.p1.P, "\u534f\u8bae\u8be6\u60c5");
        intent.putExtra(util.p1.Q, this.mPresent.getXY_verification());
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("\u8eab\u4efd\u6838\u5b9e");
        this.mPresent = new HelperPresenter((Activity) this);
        this.mPresenter = new HandleIDVarfyFacePresenter(this.mActivity, this);
        getIntentData();
        initCluse();
        this.mPresent.requestVerificationXY();
    }

    @Override // ui.callview.HandleIDVarfyFaceView
    public void onSuccImaggRequest(byte[] bArr) {
        pctureTaken(bArr);
    }

    @Override // ui.callview.HandleIDVarfyFaceView
    public void onSuccRequest(Message message) {
        util.f1.a();
        this.mHandler.sendMessage(message);
    }

    @OnClick({R.id.iv_back, R.id.btn_idvrfy_start})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_idvrfy_start) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
        } else if (this.mTCbSelect.isChecked()) {
            varCamerPrims();
        } else {
            e2.a("\u8bf7\u5148\u9605\u8bfb\u5e76\u540c\u610f\u5e95\u90e8\u534f\u8bae");
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_id_handle;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.mTCbSelect.setChecked(z);
    }
}
