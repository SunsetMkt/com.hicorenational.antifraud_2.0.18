package p388ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import manager.BaseDialog;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p023b.p024a.p025a.p027e.C0922h;
import p245d.C4443d;
import p388ui.Hicore;
import p388ui.callview.VerifyFaceCallview;
import p388ui.presenter.VerifyFacePresenter;
import util.C7257b1;
import util.C7277f1;
import util.C7286i1;
import util.C7292k1;
import util.C7331w1;
import util.C7333x0;
import util.C7337y1;
import util.C7340z1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class VerifyFaceActivity extends BaseActivity implements TextWatcher, VerifyFaceCallview {

    @BindView(C2113R.id.confirm)
    TextView mConfirm;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;
    private VerifyFacePresenter mPresenter;

    @BindView(C2113R.id.tv_card_type)
    TextView mTvCardType;

    @BindView(C2113R.id.tv_right)
    TextView mTvRight;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.user_ID)
    EditText mUserID;

    @BindView(C2113R.id.user_name)
    EditText mUserName;
    private boolean isIDCardType = true;
    String strName = "";
    String strIDNumber = "";
    private BaseDialog mDlgRed = null;

    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new HandlerC6646e();
    Dialog dialog = null;

    /* renamed from: ui.activity.VerifyFaceActivity$a */
    class C6642a extends C0922h.a {

        /* renamed from: a */
        final /* synthetic */ TextView f23335a;

        C6642a(TextView textView) {
            this.f23335a = textView;
        }

        @Override // p023b.p024a.p025a.p027e.C0922h.a
        /* renamed from: b */
        public void mo971b(int i2, String str) {
            if (i2 == 0) {
                VerifyFaceActivity.this.isIDCardType = true;
                VerifyFaceActivity.this.mConfirm.setText("去人脸识别");
            } else {
                VerifyFaceActivity.this.isIDCardType = false;
                VerifyFaceActivity.this.mConfirm.setText("去人工审核");
            }
            this.f23335a.setText(str);
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity$b */
    class C6643b implements PermissionsListener {
        C6643b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            VerifyFaceActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                VerifyFaceActivity.this.intentFace();
            } else if (C7310c.m26526f()) {
                VerifyFaceActivity.this.intentFace();
            } else {
                VerifyFaceActivity.this.camerPrimssDlg(false);
            }
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity$c */
    class C6644c implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f23338a;

        C6644c(boolean z) {
            this.f23338a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f23338a) {
                C7292k1.m26406j(VerifyFaceActivity.this.mActivity);
            } else {
                VerifyFaceActivity.this.varCamerPrims();
            }
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity$d */
    class RunnableC6645d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23340a;

        RunnableC6645d(String str) {
            this.f23340a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VerifyFaceActivity.this.confirm(this.f23340a);
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity$e */
    class HandlerC6646e extends Handler {
        HandlerC6646e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (VerifyFaceActivity.this.isFinishing()) {
            }
            int i2 = message.what;
            if (i2 != -2) {
                VerifyFaceActivity.this.hideProgressDialog();
            }
            if (i2 != -2) {
                if (i2 == -1) {
                    VerifyFaceActivity.this.showManualCheck("注册失败,您可通过人工审核提交信息，并联系民警审核");
                    return;
                }
                if (i2 == 30) {
                    VerifyFaceActivity.this.overrunDialog();
                    return;
                }
                if (i2 == 31) {
                    Object obj = message.obj;
                    if (obj != null) {
                        C7257b1.m26210b(VerifyFaceActivity.this.mActivity, obj.toString(), "确定", null);
                        return;
                    }
                    return;
                }
                switch (i2) {
                    case 1:
                        C7331w1.m26688a("实名认证成功");
                        VerifyFacePresenter verifyFacePresenter = VerifyFaceActivity.this.mPresenter;
                        VerifyFaceActivity verifyFaceActivity = VerifyFaceActivity.this;
                        verifyFacePresenter.resultSuccess(verifyFaceActivity.strName, verifyFaceActivity.strIDNumber);
                        break;
                    case 2:
                    case 3:
                        VerifyFaceActivity.this.showManualCheck("人脸识别未通过,您可通过人工审核提交信息，并联系民警审核");
                        break;
                    case 4:
                        VerifyFaceActivity.this.showManualCheck("身份核验不一致,您可通过人工审核提交信息，并联系民警审核");
                        break;
                    case 5:
                    case 6:
                        VerifyFaceActivity.this.showManualCheck("抱歉，您的人脸信息不在公安的人脸库中，您可通过人工审核提交信息，并联系民警审核，或者尝试重新输入");
                        break;
                    case 7:
                        VerifyFaceActivity.this.showManualCheck("人脸拍摄不合格,您可通过人工审核提交信息，并联系民警审核");
                        break;
                    default:
                        VerifyFaceActivity.this.showManualCheck("核验失败,您可通过人工审核提交信息，并联系民警审核");
                        break;
                }
            }
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity$f */
    class C6647f implements IClickListener {
        C6647f() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            VerifyFacePresenter verifyFacePresenter = VerifyFaceActivity.this.mPresenter;
            VerifyFaceActivity verifyFaceActivity = VerifyFaceActivity.this;
            verifyFacePresenter.unbind(verifyFaceActivity.strName, verifyFaceActivity.strIDNumber, "", "");
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity$g */
    class C6648g implements IClickListener {
        C6648g() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            VerifyFaceActivity.this.turnManualPage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        C7257b1.m26230f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new C6644c(z));
    }

    private void clearVeifiedUseData() {
        C7340z1.f25774v = null;
        if (C7340z1.f25775w) {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm(String str) {
        if (isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(this.strName) || TextUtils.isEmpty(this.strIDNumber)) {
            C7331w1.m26688a("请重新填入个人信息");
            finish();
        } else {
            C7257b1.m26203a("人脸识别中，请耐心等待...", false, this.mActivity);
            this.mPresenter.verify(str, this.strName, this.strIDNumber, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.strName = this.mUserName.getText().toString().trim();
        this.strIDNumber = this.mUserID.getText().toString().trim().toUpperCase();
        if (this.isIDCardType) {
            turnFacePage();
        } else {
            turnManualPage(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void overrunDialog() {
        this.mDlgRed = C7257b1.m26219c(this.mActivity, "当前身份信息已实名其他账号，是否换绑新账号？", "注意：换绑后，老账号将被注销！", "取消", "确定", new C6647f());
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
            runOnUiThread(new RunnableC6645d(m26700a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showManualCheck(String str) {
        showManualCheck(str, "重新输入");
    }

    private void turnFacePage() {
        if (this.strName.length() < 2 || this.strName.length() > 22 || !C7337y1.m26799x(this.strName)) {
            C7331w1.m26688a("姓名格式不正确，请重新输入");
        } else if (C7286i1.m26382b(this.strIDNumber)) {
            this.mPresenter.redName(this.strName, this.strIDNumber, "1");
        } else {
            C7331w1.m26688a("身份证号不正确，请重新输入");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnManualPage(boolean z) {
        Intent intent;
        if (this.strName.trim().length() < 1) {
            C7331w1.m26688a("姓名格式不正确，请重新输入");
            return;
        }
        if (this.strIDNumber.trim().length() < 1) {
            C7331w1.m26688a("证件号不正确，请重新输入");
            return;
        }
        if (TextUtils.isEmpty(AccountManager.getVisiblePhone())) {
            intent = new Intent(this.mActivity, (Class<?>) ManualPhoneActivity.class);
        } else {
            intent = new Intent(this.mActivity, (Class<?>) ManualCheckActivity.class);
            intent.putExtra(C7292k1.f25398e0, AccountManager.getVisiblePhone());
        }
        intent.putExtra(C7292k1.f25389b0, this.strName);
        intent.putExtra(C7292k1.f25394d, z);
        intent.putExtra(C7292k1.f25395d0, this.strIDNumber);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z, C7308a.f25524c}, new C6643b());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String trim = this.mUserName.getText().toString().trim();
        String trim2 = this.mUserID.getText().toString().trim();
        if (TextUtils.isEmpty(trim) || TextUtils.isEmpty(trim2)) {
            this.mConfirm.setEnabled(false);
        } else {
            this.mConfirm.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("");
        this.mPresenter = new VerifyFacePresenter(this.mActivity, this);
        this.mUserName.addTextChangedListener(this);
        this.mUserID.addTextChangedListener(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        clearVeifiedUseData();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 200) {
            return;
        }
        finish();
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 211) {
            return;
        }
        finish();
    }

    @Override // p388ui.callview.VerifyFaceCallview
    public void onSuccImaggRequest(byte[] bArr) {
        pctureTaken(bArr);
    }

    @Override // p388ui.callview.VerifyFaceCallview
    public void onSuccRequest(Message message) {
        C7257b1.m26191a();
        this.mHandler.sendMessage(message);
    }

    @Override // p388ui.callview.VerifyFaceCallview
    public void onSuccessRedName(boolean z) {
        if (z) {
            showManualCheck("身份认证不通过", "我知道了");
        } else {
            this.mPresenter.startLive();
        }
    }

    @Override // p388ui.callview.VerifyFaceCallview
    public void onSuccessUnbind() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
        this.mPresenter.resultSuccess(this.strName, this.strIDNumber);
    }

    @Override // p388ui.callview.VerifyFaceCallview
    public void onSuccessUnbindOverrun() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_right, C2113R.id.tv_card_type, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            varCamerPrims();
        } else if (id == C2113R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != C2113R.id.tv_card_type) {
                return;
            }
            showCredentPiker(this.mTvCardType);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_register_personal;
    }

    public void showCredentPiker(TextView textView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("身份证");
        arrayList.add("护照");
        if (arrayList.size() == 0) {
            return;
        }
        C0922h c0922h = new C0922h(this.mActivity, arrayList);
        c0922h.m1017x(3);
        c0922h.m979E(0);
        c0922h.m998C(15);
        c0922h.setOnOptionPickListener(new C6642a(textView));
        c0922h.m1045m();
    }

    private void showManualCheck(String str, String str2) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            this.dialog = C7257b1.m26211b(this.mActivity, str, "", str2, "人工审核", new C6648g());
        }
    }
}
