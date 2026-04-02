package ui.activity;

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
import c.a.a.e.h;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import manager.BaseDialog;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.VerifyFaceCallview;
import ui.presenter.VerifyFacePresenter;
import util.e2;
import util.g2;
import util.h2;

/* JADX INFO: loaded from: classes2.dex */
public class VerifyFaceActivity extends BaseActivity implements TextWatcher, VerifyFaceCallview {

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    private VerifyFacePresenter mPresenter;

    @BindView(R.id.tv_card_type)
    TextView mTvCardType;

    @BindView(R.id.tv_right)
    TextView mTvRight;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.user_ID)
    EditText mUserID;

    @BindView(R.id.user_name)
    EditText mUserName;
    private boolean isIDCardType = true;
    String strName = "";
    String strIDNumber = "";
    private BaseDialog mDlgRed = null;

    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new e();
    Dialog dialog = null;

    class a extends h.a {
        final /* synthetic */ TextView a;

        a(TextView textView) {
            this.a = textView;
        }

        @Override // c.a.a.e.h.a
        public void b(int i2, String str) {
            if (i2 == 0) {
                VerifyFaceActivity.this.isIDCardType = true;
                VerifyFaceActivity.this.mConfirm.setText("\u53bb\u4eba\u8138\u8bc6\u522b");
            } else {
                VerifyFaceActivity.this.isIDCardType = false;
                VerifyFaceActivity.this.mConfirm.setText("\u53bb\u4eba\u5de5\u5ba1\u6838");
            }
            this.a.setText(str);
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            VerifyFaceActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                VerifyFaceActivity.this.intentFace();
            } else if (util.permissionutil.c.f()) {
                VerifyFaceActivity.this.intentFace();
            } else {
                VerifyFaceActivity.this.camerPrimssDlg(false);
            }
        }
    }

    class c implements IClickListener {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.a) {
                util.p1.j(VerifyFaceActivity.this.mActivity);
            } else {
                VerifyFaceActivity.this.varCamerPrims();
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VerifyFaceActivity.this.confirm(this.a);
        }
    }

    class e extends Handler {
        e() {
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
                    VerifyFaceActivity.this.showManualCheck("\u6ce8\u518c\u5931\u8d25,\u60a8\u53ef\u901a\u8fc7\u4eba\u5de5\u5ba1\u6838\u63d0\u4ea4\u4fe1\u606f\uff0c\u5e76\u8054\u7cfb\u6c11\u8b66\u5ba1\u6838");
                    return;
                }
                if (i2 == 30) {
                    VerifyFaceActivity.this.overrunDialog();
                    return;
                }
                if (i2 == 31) {
                    Object obj = message.obj;
                    if (obj != null) {
                        util.f1.b(VerifyFaceActivity.this.mActivity, obj.toString(), "\u786e\u5b9a", null);
                        return;
                    }
                    return;
                }
                switch (i2) {
                    case 1:
                        e2.a("\u5b9e\u540d\u8ba4\u8bc1\u6210\u529f");
                        VerifyFacePresenter verifyFacePresenter = VerifyFaceActivity.this.mPresenter;
                        VerifyFaceActivity verifyFaceActivity = VerifyFaceActivity.this;
                        verifyFacePresenter.resultSuccess(verifyFaceActivity.strName, verifyFaceActivity.strIDNumber);
                        break;
                    case 2:
                    case 3:
                        VerifyFaceActivity.this.showManualCheck("\u4eba\u8138\u8bc6\u522b\u672a\u901a\u8fc7,\u60a8\u53ef\u901a\u8fc7\u4eba\u5de5\u5ba1\u6838\u63d0\u4ea4\u4fe1\u606f\uff0c\u5e76\u8054\u7cfb\u6c11\u8b66\u5ba1\u6838");
                        break;
                    case 4:
                        VerifyFaceActivity.this.showManualCheck("\u8eab\u4efd\u6838\u9a8c\u4e0d\u4e00\u81f4,\u60a8\u53ef\u901a\u8fc7\u4eba\u5de5\u5ba1\u6838\u63d0\u4ea4\u4fe1\u606f\uff0c\u5e76\u8054\u7cfb\u6c11\u8b66\u5ba1\u6838");
                        break;
                    case 5:
                    case 6:
                        VerifyFaceActivity.this.showManualCheck("\u62b1\u6b49\uff0c\u60a8\u7684\u4eba\u8138\u4fe1\u606f\u4e0d\u5728\u516c\u5b89\u7684\u4eba\u8138\u5e93\u4e2d\uff0c\u60a8\u53ef\u901a\u8fc7\u4eba\u5de5\u5ba1\u6838\u63d0\u4ea4\u4fe1\u606f\uff0c\u5e76\u8054\u7cfb\u6c11\u8b66\u5ba1\u6838\uff0c\u6216\u8005\u5c1d\u8bd5\u91cd\u65b0\u8f93\u5165");
                        break;
                    case 7:
                        VerifyFaceActivity.this.showManualCheck("\u4eba\u8138\u62cd\u6444\u4e0d\u5408\u683c,\u60a8\u53ef\u901a\u8fc7\u4eba\u5de5\u5ba1\u6838\u63d0\u4ea4\u4fe1\u606f\uff0c\u5e76\u8054\u7cfb\u6c11\u8b66\u5ba1\u6838");
                        break;
                    default:
                        VerifyFaceActivity.this.showManualCheck("\u6838\u9a8c\u5931\u8d25,\u60a8\u53ef\u901a\u8fc7\u4eba\u5de5\u5ba1\u6838\u63d0\u4ea4\u4fe1\u606f\uff0c\u5e76\u8054\u7cfb\u6c11\u8b66\u5ba1\u6838");
                        break;
                }
            }
        }
    }

    class f implements IClickListener {
        f() {
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

    class g implements IClickListener {
        g() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            VerifyFaceActivity.this.turnManualPage(true);
        }
    }

    public void camerPrimssDlg(boolean z) {
        util.f1.f(this.mActivity, "\u6743\u9650\u5f00\u542f", "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3\u672a\u53d6\u5f97\u6743\u9650\uff0c\u8fd9\u6837\u4f1a\u5bfc\u81f4\u6b64\u529f\u80fd\u65e0\u6cd5\u4f7f\u7528\u3002", "\u53d6\u6d88", "\u53bb\u6388\u6743", new c(z));
    }

    private void clearVeifiedUseData() {
        h2.v = null;
        if (h2.w) {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
            finish();
        }
    }

    public void confirm(String str) {
        if (isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(this.strName) || TextUtils.isEmpty(this.strIDNumber)) {
            e2.a("\u8bf7\u91cd\u65b0\u586b\u5165\u4e2a\u4eba\u4fe1\u606f");
            finish();
        } else {
            util.f1.a("\u4eba\u8138\u8bc6\u522b\u4e2d\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", false, this.mActivity);
            this.mPresenter.verify(str, this.strName, this.strIDNumber, "", "");
        }
    }

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

    public void overrunDialog() {
        this.mDlgRed = util.f1.c(this.mActivity, "\u5f53\u524d\u8eab\u4efd\u4fe1\u606f\u5df2\u5b9e\u540d\u5176\u4ed6\u8d26\u53f7\uff0c\u662f\u5426\u6362\u7ed1\u65b0\u8d26\u53f7\uff1f", "\u6ce8\u610f\uff1a\u6362\u7ed1\u540e\uff0c\u8001\u8d26\u53f7\u5c06\u88ab\u6ce8\u9500\uff01", "\u53d6\u6d88", "\u786e\u5b9a", new f());
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
            runOnUiThread(new d(strA));
        }
    }

    public void showManualCheck(String str) {
        showManualCheck(str, "\u91cd\u65b0\u8f93\u5165");
    }

    private void turnFacePage() {
        if (this.strName.length() < 2 || this.strName.length() > 22 || !g2.x(this.strName)) {
            e2.a("\u59d3\u540d\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
        } else if (util.m1.b(this.strIDNumber)) {
            this.mPresenter.redName(this.strName, this.strIDNumber, "1");
        } else {
            e2.a("\u8eab\u4efd\u8bc1\u53f7\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
        }
    }

    public void turnManualPage(boolean z) {
        Intent intent;
        if (this.strName.trim().length() < 1) {
            e2.a("\u59d3\u540d\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        if (this.strIDNumber.trim().length() < 1) {
            e2.a("\u8bc1\u4ef6\u53f7\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        if (TextUtils.isEmpty(AccountManager.getVisiblePhone())) {
            intent = new Intent(this.mActivity, (Class<?>) ManualPhoneActivity.class);
        } else {
            intent = new Intent(this.mActivity, (Class<?>) ManualCheckActivity.class);
            intent.putExtra(util.p1.e0, AccountManager.getVisiblePhone());
        }
        intent.putExtra(util.p1.b0, this.strName);
        intent.putExtra(util.p1.f15012d, z);
        intent.putExtra(util.p1.d0, this.strIDNumber);
        startActivity(intent);
    }

    public void varCamerPrims() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f15026c}, new b());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String strTrim = this.mUserName.getText().toString().trim();
        String strTrim2 = this.mUserID.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2)) {
            this.mConfirm.setEnabled(false);
        } else {
            this.mConfirm.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("");
        this.mPresenter = new VerifyFacePresenter(this.mActivity, this);
        this.mUserName.addTextChangedListener(this);
        this.mUserID.addTextChangedListener(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* JADX INFO: renamed from: onBackPressed */
    public void a() {
        super.a();
        clearVeifiedUseData();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 200) {
            return;
        }
        finish();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 211) {
            return;
        }
        finish();
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccImaggRequest(byte[] bArr) {
        pctureTaken(bArr);
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccRequest(Message message) {
        util.f1.a();
        this.mHandler.sendMessage(message);
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccessRedName(boolean z) {
        if (z) {
            showManualCheck("\u8eab\u4efd\u8ba4\u8bc1\u4e0d\u901a\u8fc7", "\u6211\u77e5\u9053\u4e86");
        } else {
            this.mPresenter.startLive();
        }
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccessUnbind() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
        this.mPresenter.resultSuccess(this.strName, this.strIDNumber);
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccessUnbindOverrun() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({R.id.iv_back, R.id.tv_right, R.id.tv_card_type, R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            varCamerPrims();
        } else if (id == R.id.iv_back) {
            a();
        } else {
            if (id != R.id.tv_card_type) {
                return;
            }
            showCredentPiker(this.mTvCardType);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_register_personal;
    }

    public void showCredentPiker(TextView textView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("\u8eab\u4efd\u8bc1");
        arrayList.add("\u62a4\u7167");
        if (arrayList.size() == 0) {
            return;
        }
        c.a.a.e.h hVar = new c.a.a.e.h(this.mActivity, arrayList);
        hVar.x(3);
        hVar.E(0);
        hVar.C(15);
        hVar.setOnOptionPickListener(new a(textView));
        hVar.m();
    }

    private void showManualCheck(String str, String str2) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            this.dialog = util.f1.b(this.mActivity, str, "", str2, "\u4eba\u5de5\u5ba1\u6838", new g());
        }
    }
}
