package util.permissionutil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.AttributionReporter;
import com.umeng.analytics.pro.bl;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import ui.Hicore;
import ui.activity.MainActivity;
import ui.presenter.BasePagePresenter;
import util.f1;
import util.j1;
import util.p1;
import util.s1;

/* JADX INFO: compiled from: PermissionUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15046b = "c";
    private PermissionFragment a;

    /* JADX INFO: compiled from: PermissionUtil.java */
    static class a implements util.permissionutil.b {
        final /* synthetic */ PermissionsListener a;

        a(PermissionsListener permissionsListener) {
            this.a = permissionsListener;
        }

        @Override // util.permissionutil.b
        public void a(List<String> list) {
            PermissionsListener permissionsListener = this.a;
            if (permissionsListener != null) {
                permissionsListener.onDenied(list, true);
            }
        }

        @Override // util.permissionutil.b
        public void b(List<String> list) {
            PermissionsListener permissionsListener = this.a;
            if (permissionsListener != null) {
                permissionsListener.onDenied(list, false);
            }
        }

        @Override // util.permissionutil.b
        public void onGranted() {
            PermissionsListener permissionsListener = this.a;
            if (permissionsListener != null) {
                permissionsListener.onGranted();
            }
        }
    }

    /* JADX INFO: compiled from: PermissionUtil.java */
    static class b implements IClickListener {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f15047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f15048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f15049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ PermissionsListener f15050e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f15051f;

        b(boolean z, IOneClickListener iOneClickListener, Activity activity, List list, PermissionsListener permissionsListener, boolean z2) {
            this.a = z;
            this.f15047b = iOneClickListener;
            this.f15048c = activity;
            this.f15049d = list;
            this.f15050e = permissionsListener;
            this.f15051f = z2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (this.f15051f) {
                Activity activity = this.f15048c;
                if ((activity instanceof MainActivity) || activity.isFinishing()) {
                    return;
                }
                this.f15048c.finish();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (!this.a) {
                List list = this.f15049d;
                c.a(this.f15048c, (String[]) list.toArray(new String[list.size()]), this.f15050e);
                return;
            }
            IOneClickListener iOneClickListener = this.f15047b;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + Hicore.getApp().getPackageName()));
            this.f15048c.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: util.permissionutil.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PermissionUtil.java */
    static class C0327c implements IClickListener {
        final /* synthetic */ Activity a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f15052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f15053c;

        C0327c(Activity activity, IOneClickListener iOneClickListener, boolean z) {
            this.a = activity;
            this.f15052b = iOneClickListener;
            this.f15053c = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            IOneClickListener iOneClickListener = this.f15052b;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
                return;
            }
            if (this.f15053c) {
                Activity activity = this.a;
                if ((activity instanceof MainActivity) || activity.isFinishing()) {
                    return;
                }
                this.a.finish();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (!Build.BRAND.equalsIgnoreCase("vivo")) {
                new BasePagePresenter(this.a).checkOtherPerssion(null);
            } else {
                if (p1.c(this.a)) {
                    return;
                }
                p1.e(this.a);
            }
        }
    }

    public c(Activity activity) {
        this.a = a(activity);
    }

    private PermissionFragment a(Activity activity) {
        PermissionFragment permissionFragment = (PermissionFragment) activity.getFragmentManager().findFragmentByTag(f15046b);
        if (permissionFragment == null) {
            try {
                PermissionFragment permissionFragment2 = new PermissionFragment();
                try {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    fragmentManager.beginTransaction().add(permissionFragment2, f15046b).commitAllowingStateLoss();
                    fragmentManager.executePendingTransactions();
                    return permissionFragment2;
                } catch (Exception unused) {
                    return permissionFragment2;
                }
            } catch (Exception unused2) {
            }
        }
        return permissionFragment;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static boolean b() {
        try {
            ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c() {
        try {
            Cursor cursorQuery = Hicore.getApp().getContentResolver().query(Uri.parse("content://sms/failed"), new String[]{bl.f7101d, UserInfo.ADDRESS, "person", "body", "date", "type"}, null, null, "date desc");
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d() {
        File file = new File(j1.b() + "permission.ymt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.flush();
            fileOutputStream.close();
            file.delete();
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean e() {
        try {
            Cursor cursorQuery = Hicore.getApp().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean f() {
        try {
            Camera cameraOpen = Camera.open();
            Field declaredField = cameraOpen.getClass().getDeclaredField("mHasPermission");
            declaredField.setAccessible(true);
            return ((Boolean) declaredField.get(cameraOpen)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static boolean g() {
        s1.b(AttributionReporter.SYSTEM_PERMISSION, "Build.BRAND:" + Build.BRAND);
        return Build.VERSION.SDK_INT <= 23 || Build.BRAND.toLowerCase().equals("smartisan") || Build.BRAND.toLowerCase().equals("xiaomi") || Build.BRAND.toLowerCase().equals("oppo") || Build.BRAND.toLowerCase().equals("vivo") || Build.BRAND.toLowerCase().equals("lenovo") || Build.BRAND.toLowerCase().equals("meizu");
    }

    private static int b(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("currentmode"));
                    cursorQuery.close();
                    return i2;
                }
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        return 1;
    }

    public static boolean a(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public void a(String[] strArr, util.permissionutil.b bVar) {
        PermissionFragment permissionFragment = this.a;
        if (permissionFragment != null) {
            permissionFragment.a(bVar);
            this.a.a(strArr);
        }
    }

    public static void a(Activity activity, String[] strArr, PermissionsListener permissionsListener) {
        new c(activity).a(strArr, new a(permissionsListener));
    }

    public static void a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener) {
        a(activity, list, z, z2, permissionsListener, "", "", "", "", null);
    }

    public static void a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, IOneClickListener iOneClickListener) {
        a(activity, list, z, z2, permissionsListener, "", "", "", "", iOneClickListener);
    }

    public static void a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, String str, String str2, String str3, String str4) {
        a(activity, list, z, z2, permissionsListener, str, str2, str3, str4, null);
    }

    public static void a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, String str, String str2, String str3, String str4, IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        f1.f(activity, TextUtils.isEmpty(str) ? "\u6743\u9650\u5f00\u542f" : str, TextUtils.isEmpty(str2) ? "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3\u672a\u53d6\u5f97\u6743\u9650\uff0c\u8fd9\u6837\u4f1a\u5bfc\u81f4\u6b64\u529f\u80fd\u65e0\u6cd5\u4f7f\u7528\u3002" : str2, TextUtils.isEmpty(str3) ? "\u53d6\u6d88" : str3, TextUtils.isEmpty(str4) ? "\u53bb\u6388\u6743" : str4, new b(z, iOneClickListener, activity, list, permissionsListener, z2));
    }

    public static void a(Activity activity, boolean z, String str, String str2, String str3, String str4, IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "\u6743\u9650\u5f00\u542f";
        }
        String str5 = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "\u5f00\u542fAPP\u9884\u8b66\u9700\u6388\u6743\u3010\u60ac\u6d6e\u6846\u6743\u9650\u3011\n\u5982\u672a\u6388\u6743\u4f1a\u5bfc\u81f4\u529f\u80fd\u65e0\u6cd5\u4f7f\u7528\u3002";
        }
        String str6 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "\u53d6\u6d88";
        }
        String str7 = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = "\u53bb\u6388\u6743";
        }
        f1.f(activity, str5, str6, str7, str4, new C0327c(activity, iOneClickListener, z));
    }

    public static boolean a() {
        try {
            Cursor cursorQuery = Hicore.getApp().getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "type", CommonNetImpl.NAME, "geocoded_location"}, null, null, null);
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(Context context) {
        try {
            if (context != null) {
                Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/allowfloatwindowapp"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
                if (cursorQuery != null) {
                    cursorQuery.getColumnNames();
                    if (cursorQuery.moveToFirst()) {
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("currentlmode"));
                        cursorQuery.close();
                        return i2;
                    }
                    cursorQuery.close();
                    return b(context);
                }
                return b(context);
            }
            throw new IllegalArgumentException("context is null");
        } catch (Exception unused) {
            return b(context);
        }
    }
}
