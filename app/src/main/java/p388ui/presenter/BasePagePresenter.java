package p388ui.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IOneClickListener;
import java.util.ArrayList;
import p245d.C4443d;
import p388ui.basemvp.BasePresenter;
import util.C7292k1;
import util.C7331w1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class BasePagePresenter extends BasePresenter {
    private Activity mActivity;

    /* renamed from: ui.presenter.BasePagePresenter$a */
    class RunnableC6931a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ IOneClickListener f23980a;

        /* renamed from: ui.presenter.BasePagePresenter$a$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IOneClickListener iOneClickListener = RunnableC6931a.this.f23980a;
                if (iOneClickListener != null) {
                    iOneClickListener.clickOKBtn();
                }
            }
        }

        RunnableC6931a(IOneClickListener iOneClickListener) {
            this.f23980a = iOneClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 23 || !C7292k1.m26395a((Context) BasePagePresenter.this.mActivity)) {
                return;
            }
            BasePagePresenter.this.mActivity.runOnUiThread(new a());
        }
    }

    public BasePagePresenter(Activity activity) {
        this.mActivity = activity;
    }

    @SuppressLint({"NewApi"})
    public void checkOtherPerssion(String[] strArr) {
        try {
            String str = Build.BRAND;
            String str2 = Build.DEVICE;
            if (str.equalsIgnoreCase("vivo")) {
                if (C7310c.m26511a((Context) this.mActivity) != 0) {
                    this.mActivity.startActivityForResult(C7292k1.m26400d(this.mActivity), 10001);
                    return;
                }
                return;
            }
            if (str2.equalsIgnoreCase("hwH60")) {
                if (strArr != null) {
                    ActivityCompat.requestPermissions(this.mActivity, strArr, C4443d.f16957h);
                }
                if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(this.mActivity)) {
                    return;
                }
                Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS", Uri.parse("package:" + this.mActivity.getPackageName()));
                intent.addFlags(CommonNetImpl.FLAG_AUTH);
                this.mActivity.startActivityForResult(intent, C4443d.f16959i);
                return;
            }
            if (!str.equalsIgnoreCase("oppo") || Build.VERSION.SDK_INT != 22) {
                if (C7292k1.m26395a((Context) this.mActivity)) {
                    return;
                }
                this.mActivity.startActivityForResult(C7292k1.m26400d(this.mActivity), 10001);
                return;
            }
            try {
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.setFlags(CommonNetImpl.FLAG_AUTH);
                intent2.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
                this.mActivity.startActivityForResult(intent2, 10001);
            } catch (Exception e2) {
                e2.printStackTrace();
                C7331w1.m26688a("请去手机管家设置");
            }
        } catch (Exception unused) {
        }
    }

    public String[] checkPermission() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C7308a.f25531j);
        arrayList.add(C7308a.f25533l);
        arrayList.add(C7308a.f25544w);
        arrayList.add(C7308a.f25543v);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(C7308a.f25539r);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] checkPermissionCall() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C7308a.f25531j);
        arrayList.add(C7308a.f25533l);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(C7308a.f25539r);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] checkPermissionSms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C7308a.f25544w);
        arrayList.add(C7308a.f25543v);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @SuppressLint({"NewApi"})
    public boolean isOpenFlowPrim() {
        if (Build.BRAND.equalsIgnoreCase("vivo")) {
            if (C7310c.m26511a((Context) this.mActivity) != 0) {
                return false;
            }
        } else if (!C7292k1.m26395a((Context) this.mActivity)) {
            return false;
        }
        return !Build.DEVICE.equalsIgnoreCase("hwH60") || Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(this.mActivity);
    }

    public void onActivityResult(IOneClickListener iOneClickListener) {
        new Handler().postDelayed(new RunnableC6931a(iOneClickListener), 500L);
    }
}
