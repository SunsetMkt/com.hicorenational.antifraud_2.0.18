package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.ITextCallBackListener;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import manager.AccountManager;
import org.greenrobot.eventbus.C6049c;
import p245d.C4443d;
import p388ui.Hicore;
import p388ui.callview.HandleIDVarfyFaceView;
import p388ui.presenter.HandleIDVarfyFacePresenter;
import p388ui.presenter.HelperPresenter;
import p388ui.view.C7236o;
import util.C7257b1;
import util.C7277f1;
import util.C7286i1;
import util.C7292k1;
import util.C7331w1;
import util.C7333x0;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class HandleIDVerifyActivity extends BaseActivity implements HandleIDVarfyFaceView {

    @BindView(C2113R.id.btn_idvrfy_start)
    Button mConfirm;

    @BindView(C2113R.id.user_name)
    EditText mEtName;

    @BindView(C2113R.id.user_ID)
    EditText mEtUserId;

    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new HandlerC6328d();

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;
    private HelperPresenter mPresent;
    private HandleIDVarfyFacePresenter mPresenter;

    @BindView(C2113R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(C2113R.id.tv_right)
    TextView mTvRight;

    @BindView(C2113R.id.tv_select_tip)
    TextView mTvSelectTips;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    String strIDNumber;
    String strName;
    String verifyId;
    String verifyNameFrid;

    /* renamed from: ui.activity.HandleIDVerifyActivity$a */
    class C6325a implements PermissionsListener {
        C6325a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            HandleIDVerifyActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                HandleIDVerifyActivity.this.intentFace();
            } else if (C7310c.m26526f()) {
                HandleIDVerifyActivity.this.intentFace();
            } else {
                HandleIDVerifyActivity.this.camerPrimssDlg(false);
            }
        }
    }

    /* renamed from: ui.activity.HandleIDVerifyActivity$b */
    class C6326b implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f22379a;

        C6326b(boolean z) {
            this.f22379a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f22379a) {
                C7292k1.m26406j(HandleIDVerifyActivity.this.mActivity);
            } else {
                HandleIDVerifyActivity.this.varCamerPrims();
            }
        }
    }

    /* renamed from: ui.activity.HandleIDVerifyActivity$c */
    class RunnableC6327c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f22381a;

        RunnableC6327c(String str) {
            this.f22381a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HandleIDVerifyActivity.this.confirm(this.f22381a);
        }
    }

    /* renamed from: ui.activity.HandleIDVerifyActivity$d */
    class HandlerC6328d extends Handler {
        HandlerC6328d() {
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
                    C7331w1.m26688a("核验成功");
                    C6049c.m24987f().m25000d(new C7265a(38, null));
                    HandleIDVerifyActivity handleIDVerifyActivity = HandleIDVerifyActivity.this;
                    AccountManager.setVerified(true, handleIDVerifyActivity.strName, handleIDVerifyActivity.strIDNumber);
                    Intent intent = new Intent(HandleIDVerifyActivity.this.mActivity, (Class<?>) IDVarfySuccessActivity.class);
                    intent.putExtra(C7292k1.f25416k0, HandleIDVerifyActivity.this.verifyNameFrid);
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
                    C6049c.m24987f().m25000d(new C7265a(39, null));
                    C7331w1.m26688a("核验数据已过期~");
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
        C7257b1.m26230f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new C6326b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm(String str) {
        if (TextUtils.isEmpty(str)) {
            C7331w1.m26688a("请重拍");
            return;
        }
        if (TextUtils.isEmpty(this.strName) || TextUtils.isEmpty(this.strIDNumber)) {
            C7331w1.m26688a("请重新填入个人信息");
            finish();
        } else {
            C7257b1.m26203a("人脸识别中，请耐心等待...", false, this.mActivity);
            this.mPresenter.verifyAction(str, this.strName, this.strIDNumber, this.verifyId);
        }
    }

    private void getIntentData() {
        this.verifyId = getIntent().getStringExtra(C7292k1.f25392c0);
        this.verifyNameFrid = getIntent().getStringExtra(C7292k1.f25389b0);
    }

    private void initCluse() {
        String str = "您同意通过国家反诈中心APP传达本人身份核实信息给请求方查看协议详情>";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new C7236o(str, new ITextCallBackListener() { // from class: ui.activity.u
            @Override // interfaces.ITextCallBackListener
            public final void onResult(String str2) {
                HandleIDVerifyActivity.this.m25253a(str2);
            }
        }), 28, str.length(), 33);
        this.mTvSelectTips.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTvSelectTips.setText(spannableString);
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                HandleIDVerifyActivity.this.m25252a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        Editable text = this.mEtName.getText();
        this.strName = TextUtils.isEmpty(text) ? "" : text.toString();
        Editable text2 = this.mEtUserId.getText();
        this.strIDNumber = TextUtils.isEmpty(text2) ? "" : text2.toString();
        if (this.strName.length() < 2 || this.strName.length() > 22 || !C7337y1.m26799x(this.strName)) {
            C7331w1.m26688a("姓名格式不正确，请重新输入");
        } else if (C7286i1.m26382b(this.strIDNumber)) {
            this.mPresenter.startLive();
        } else {
            C7331w1.m26688a("身份证号不正确，请重新输入");
        }
    }

    private void pctureTaken(byte[] bArr) {
        Bitmap m26338a = bArr != null ? C7277f1.m26338a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
        if (m26338a != null) {
            ByteArrayOutputStream m26342a = C7277f1.m26342a(m26338a, C4443d.f16919C);
            String m26700a = C7333x0.m26700a(m26342a);
            try {
                m26342a.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            runOnUiThread(new RunnableC6327c(m26700a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z, C7308a.f25524c}, new C6325a());
    }

    /* renamed from: a */
    public /* synthetic */ void m25253a(String str) {
        Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
        intent.putExtra(C7292k1.f25363P, "协议详情");
        intent.putExtra(C7292k1.f25365Q, this.mPresent.getXY_verification());
        startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("身份核实");
        this.mPresent = new HelperPresenter((Activity) this);
        this.mPresenter = new HandleIDVarfyFacePresenter(this.mActivity, this);
        getIntentData();
        initCluse();
        this.mPresent.requestVerificationXY();
    }

    @Override // p388ui.callview.HandleIDVarfyFaceView
    public void onSuccImaggRequest(byte[] bArr) {
        pctureTaken(bArr);
    }

    @Override // p388ui.callview.HandleIDVarfyFaceView
    public void onSuccRequest(Message message) {
        C7257b1.m26191a();
        this.mHandler.sendMessage(message);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_idvrfy_start})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_idvrfy_start) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
        } else if (this.mTCbSelect.isChecked()) {
            varCamerPrims();
        } else {
            C7331w1.m26688a("请先阅读并同意底部协议");
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_id_handle;
    }

    /* renamed from: a */
    public /* synthetic */ void m25252a(CompoundButton compoundButton, boolean z) {
        this.mTCbSelect.setChecked(z);
    }
}
