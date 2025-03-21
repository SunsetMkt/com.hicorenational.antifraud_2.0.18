package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import bean.PushEntity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.core.BasePopupView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import interfaces.IBaseBeanCall;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import java.util.List;
import network.http.AddressHttp;
import p023b.p024a.p025a.p026d.C0906d;
import p023b.p024a.p025a.p026d.C0907e;
import p023b.p024a.p025a.p026d.C0913k;
import p388ui.Hicore;
import p388ui.statusbarcompat.C7160a;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.DialogC7241s;
import p388ui.view.HuaKuaiWindow;
import receiver.C6088e;
import util.C7257b1;
import util.C7292k1;
import util.C7325u1;
import util.C7328v1;
import util.C7331w1;
import util.C7337y1;
import util.UpdateUtil;

/* loaded from: classes2.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public static final int PERMISSION_CODE = 999;
    public static final String PERMISSION_TYPE_NUMBER = "PERMISSION_TYPE_NUMBER";
    public static boolean haveLiuhai;
    public static int liuhaiHeight;
    public Activity mActivity;
    private DialogC7241s mProgressDialogBar;
    public Typeface typ_ME;
    Unbinder unbinder;
    private String mRegionId = "";
    public boolean isPerssionChecking = false;

    /* renamed from: ui.activity.BaseActivity$a */
    class C6137a implements IClickListener {
        C6137a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            C7257b1.m26191a();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + BaseActivity.this.mActivity.getPackageName()));
            BaseActivity.this.startActivity(intent);
        }
    }

    /* renamed from: ui.activity.BaseActivity$b */
    class C6138b extends AddressHttp.MyPicker {

        /* renamed from: a */
        final /* synthetic */ TextView f21865a;

        C6138b(TextView textView) {
            this.f21865a = textView;
        }

        @Override // network.http.AddressHttp.MyPicker, p023b.p024a.p025a.p027e.C0915a.e
        public void onAddressPicked(C0913k c0913k, C0906d c0906d, C0907e c0907e) {
            if (c0913k == null || c0906d == null || c0907e == null) {
                BaseActivity.this.mRegionId = "";
                this.f21865a.setText("");
                C7331w1.m26688a("结果出错！");
                return;
            }
            BaseActivity.this.mRegionId = c0907e.getAreaId();
            this.f21865a.setText(c0913k.getName() + c0906d.getName() + c0907e.getName());
        }

        @Override // network.http.AddressHttp.MyPicker
        public void onClear() {
            super.onClear();
            BaseActivity.this.mRegionId = "";
            this.f21865a.setText("");
        }
    }

    /* renamed from: ui.activity.BaseActivity$c */
    class RunnableC6139c implements Runnable {
        RunnableC6139c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseActivity.this.isPerssionChecking = false;
        }
    }

    private String getTruePath(String str) {
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getAuthority())) {
            return parse.getPath();
        }
        Cursor query = getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            if (query.moveToFirst()) {
                String string = query.getString(columnIndexOrThrow);
                query.close();
                return string;
            }
        }
        return "";
    }

    private void setBlackStatusBar() {
        C7161b.m25694a((Activity) this, getResources().getColor(C2113R.color.black), false);
    }

    private void setWhiteStatusBar() {
        C7161b.m25694a((Activity) this, getResources().getColor(C2113R.color.white), true);
    }

    public void changePath(List<LocalMedia> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(getTruePath(list.get(i2).getPath()));
        }
    }

    public void getPushData() {
        try {
            PushEntity pushEntity = (PushEntity) getIntent().getSerializableExtra(C7292k1.f25391c);
            if (pushEntity != null) {
                C6088e.m25180a(pushEntity.getExtra(), this);
            }
        } catch (Exception unused) {
        }
    }

    public String getmRegionId() {
        return this.mRegionId;
    }

    public void hideProgressDialog() {
        DialogC7241s dialogC7241s = this.mProgressDialogBar;
        if (dialogC7241s == null || !dialogC7241s.isShowing()) {
            return;
        }
        this.mProgressDialogBar.dismiss();
    }

    public void hideSoftInput() {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract void initPage();

    public boolean isDouble() {
        return Hicore.getApp().isDouble();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = this;
        this.typ_ME = Typeface.createFromAsset(getAssets(), "DIN-Medium.otf");
        C7328v1.m26648a((Activity) this);
        if (setLayoutView() != 0) {
            setContentView(setLayoutView());
        }
        this.unbinder = ButterKnife.bind(this);
        setStatusBar();
        initPage();
        PushAgent.getInstance(this).onAppStart();
        haveLiuhai = C7160a.m25678b(this);
        liuhaiHeight = C7160a.m25676a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.unbinder.unbind();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void regionShow(TextView textView, Activity activity) {
        AddressHttp.getAddSint(activity).regionPick(new C6138b(textView));
    }

    public void resetPerssionChecking() {
        C7337y1.f25731b.postDelayed(new RunnableC6139c(), 500L);
    }

    public abstract int setLayoutView();

    public void setRegionId(String str) {
        this.mRegionId = str;
    }

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= 23) {
            setWhiteStatusBar();
        } else {
            setBlackStatusBar();
        }
        C7161b.m25698a((Activity) this, true, true);
    }

    public void showDlogPrimssExcept() {
        C7257b1.m26181a(this.mActivity, "国家反诈中心”未取得权限，这样会导致此功能无法使用", "取消", "去授权", new C6137a());
    }

    public void showProgressDialog() {
        showProgressDialog("加载中...");
    }

    public void showSoftInput(EditText editText) {
        editText.requestFocus();
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(editText, 1);
    }

    public void startActivity(Class<?> cls) {
        startActivity(cls, (Bundle) null);
    }

    public void toYanzheng(IOneClickListener iOneClickListener) {
        hideSoftInput();
        new C2768b.a(this.mActivity).m8310a((BasePopupView) new HuaKuaiWindow(this.mActivity, iOneClickListener)).m8393r();
    }

    public void updateAppWithTime(IBaseBeanCall iBaseBeanCall) {
        if (UpdateUtil.isCheckUpdateAlready) {
            if (iBaseBeanCall != null) {
                iBaseBeanCall.onfail();
                return;
            }
            return;
        }
        if (!TextUtils.equals(C7337y1.m26775d("yyyy-MM-dd"), C7325u1.m26616a("update_home", ""))) {
            UpdateUtil.updateAppOnly(this.mActivity, iBaseBeanCall);
        } else if (iBaseBeanCall != null) {
            iBaseBeanCall.onfail();
        }
    }

    public void showProgressDialog(boolean z) {
        showProgressDialog("加载中...", z);
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void showProgressDialog(String str) {
        showProgressDialog(str, true);
    }

    public void showProgressDialog(String str, boolean z) {
        if (isFinishing()) {
            return;
        }
        DialogC7241s dialogC7241s = this.mProgressDialogBar;
        if (dialogC7241s == null) {
            this.mProgressDialogBar = DialogC7241s.m26028a(this);
        } else if (dialogC7241s.isShowing()) {
            return;
        }
        this.mProgressDialogBar.m26029a(str);
        this.mProgressDialogBar.setCanceledOnTouchOutside(false);
        this.mProgressDialogBar.setCancelable(z);
        this.mProgressDialogBar.show();
    }
}
