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
import com.umeng.analytics.pro.C3355bl;
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
import p388ui.Hicore;
import p388ui.activity.MainActivity;
import p388ui.presenter.BasePagePresenter;
import util.C7257b1;
import util.C7277f1;
import util.C7292k1;
import util.C7301n1;

/* compiled from: PermissionUtil.java */
/* renamed from: util.permissionutil.c */
/* loaded from: classes2.dex */
public class C7310c {

    /* renamed from: b */
    private static final String f25557b = "c";

    /* renamed from: a */
    private PermissionFragment f25558a;

    /* compiled from: PermissionUtil.java */
    /* renamed from: util.permissionutil.c$a */
    static class a implements InterfaceC7309b {

        /* renamed from: a */
        final /* synthetic */ PermissionsListener f25559a;

        a(PermissionsListener permissionsListener) {
            this.f25559a = permissionsListener;
        }

        @Override // util.permissionutil.InterfaceC7309b
        /* renamed from: a */
        public void mo26509a(List<String> list) {
            PermissionsListener permissionsListener = this.f25559a;
            if (permissionsListener != null) {
                permissionsListener.onDenied(list, true);
            }
        }

        @Override // util.permissionutil.InterfaceC7309b
        /* renamed from: b */
        public void mo26510b(List<String> list) {
            PermissionsListener permissionsListener = this.f25559a;
            if (permissionsListener != null) {
                permissionsListener.onDenied(list, false);
            }
        }

        @Override // util.permissionutil.InterfaceC7309b
        public void onGranted() {
            PermissionsListener permissionsListener = this.f25559a;
            if (permissionsListener != null) {
                permissionsListener.onGranted();
            }
        }
    }

    /* compiled from: PermissionUtil.java */
    /* renamed from: util.permissionutil.c$b */
    static class b implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f25560a;

        /* renamed from: b */
        final /* synthetic */ IOneClickListener f25561b;

        /* renamed from: c */
        final /* synthetic */ Activity f25562c;

        /* renamed from: d */
        final /* synthetic */ List f25563d;

        /* renamed from: e */
        final /* synthetic */ PermissionsListener f25564e;

        /* renamed from: f */
        final /* synthetic */ boolean f25565f;

        b(boolean z, IOneClickListener iOneClickListener, Activity activity, List list, PermissionsListener permissionsListener, boolean z2) {
            this.f25560a = z;
            this.f25561b = iOneClickListener;
            this.f25562c = activity;
            this.f25563d = list;
            this.f25564e = permissionsListener;
            this.f25565f = z2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (this.f25565f) {
                Activity activity = this.f25562c;
                if ((activity instanceof MainActivity) || activity.isFinishing()) {
                    return;
                }
                this.f25562c.finish();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (!this.f25560a) {
                List list = this.f25563d;
                C7310c.m26518a(this.f25562c, (String[]) list.toArray(new String[list.size()]), this.f25564e);
                return;
            }
            IOneClickListener iOneClickListener = this.f25561b;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + Hicore.getApp().getPackageName()));
            this.f25562c.startActivity(intent);
        }
    }

    /* compiled from: PermissionUtil.java */
    /* renamed from: util.permissionutil.c$c */
    static class c implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ Activity f25566a;

        /* renamed from: b */
        final /* synthetic */ IOneClickListener f25567b;

        /* renamed from: c */
        final /* synthetic */ boolean f25568c;

        c(Activity activity, IOneClickListener iOneClickListener, boolean z) {
            this.f25566a = activity;
            this.f25567b = iOneClickListener;
            this.f25568c = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            IOneClickListener iOneClickListener = this.f25567b;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
                return;
            }
            if (this.f25568c) {
                Activity activity = this.f25566a;
                if ((activity instanceof MainActivity) || activity.isFinishing()) {
                    return;
                }
                this.f25566a.finish();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (!Build.BRAND.equalsIgnoreCase("vivo")) {
                new BasePagePresenter(this.f25566a).checkOtherPerssion(null);
            } else {
                if (C7292k1.m26399c(this.f25566a)) {
                    return;
                }
                C7292k1.m26401e(this.f25566a);
            }
        }
    }

    public C7310c(Activity activity) {
        this.f25558a = m26512a(activity);
    }

    /* renamed from: a */
    private PermissionFragment m26512a(Activity activity) {
        PermissionFragment permissionFragment = (PermissionFragment) activity.getFragmentManager().findFragmentByTag(f25557b);
        if (permissionFragment == null) {
            try {
                PermissionFragment permissionFragment2 = new PermissionFragment();
                try {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    fragmentManager.beginTransaction().add(permissionFragment2, f25557b).commitAllowingStateLoss();
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
    /* renamed from: b */
    public static boolean m26522b() {
        try {
            ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m26523c() {
        try {
            Cursor query = Hicore.getApp().getContentResolver().query(Uri.parse("content://sms/failed"), new String[]{C3355bl.f11732d, UserInfo.ADDRESS, "person", "body", "date", "type"}, null, null, "date desc");
            if (query == null) {
                return true;
            }
            query.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m26524d() {
        File file = new File(C7277f1.m26357b() + "permission.ymt");
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

    /* renamed from: e */
    public static boolean m26525e() {
        try {
            Cursor query = Hicore.getApp().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (query == null) {
                return true;
            }
            query.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m26526f() {
        try {
            Camera open = Camera.open();
            Field declaredField = open.getClass().getDeclaredField("mHasPermission");
            declaredField.setAccessible(true);
            return ((Boolean) declaredField.get(open)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* renamed from: g */
    public static boolean m26527g() {
        C7301n1.m26457b(AttributionReporter.SYSTEM_PERMISSION, "Build.BRAND:" + Build.BRAND);
        return Build.VERSION.SDK_INT <= 23 || Build.BRAND.toLowerCase().equals("smartisan") || Build.BRAND.toLowerCase().equals("xiaomi") || Build.BRAND.toLowerCase().equals("oppo") || Build.BRAND.toLowerCase().equals("vivo") || Build.BRAND.toLowerCase().equals("lenovo") || Build.BRAND.toLowerCase().equals("meizu");
    }

    /* renamed from: b */
    private static int m26521b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i2 = query.getInt(query.getColumnIndex("currentmode"));
                    query.close();
                    return i2;
                }
                query.close();
            }
        } catch (Exception unused) {
        }
        return 1;
    }

    /* renamed from: a */
    public static boolean m26520a(Context context, String... strArr) {
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

    /* renamed from: a */
    public void m26528a(String[] strArr, InterfaceC7309b interfaceC7309b) {
        PermissionFragment permissionFragment = this.f25558a;
        if (permissionFragment != null) {
            permissionFragment.m26494a(interfaceC7309b);
            this.f25558a.m26495a(strArr);
        }
    }

    /* renamed from: a */
    public static void m26518a(Activity activity, String[] strArr, PermissionsListener permissionsListener) {
        new C7310c(activity).m26528a(strArr, new a(permissionsListener));
    }

    /* renamed from: a */
    public static void m26513a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener) {
        m26516a(activity, list, z, z2, permissionsListener, "", "", "", "", null);
    }

    /* renamed from: a */
    public static void m26514a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, IOneClickListener iOneClickListener) {
        m26516a(activity, list, z, z2, permissionsListener, "", "", "", "", iOneClickListener);
    }

    /* renamed from: a */
    public static void m26515a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, String str, String str2, String str3, String str4) {
        m26516a(activity, list, z, z2, permissionsListener, str, str2, str3, str4, null);
    }

    /* renamed from: a */
    public static void m26516a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, String str, String str2, String str3, String str4, IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        C7257b1.m26230f(activity, TextUtils.isEmpty(str) ? "权限开启" : str, TextUtils.isEmpty(str2) ? "国家反诈中心未取得权限，这样会导致此功能无法使用。" : str2, TextUtils.isEmpty(str3) ? "取消" : str3, TextUtils.isEmpty(str4) ? "去授权" : str4, new b(z, iOneClickListener, activity, list, permissionsListener, z2));
    }

    /* renamed from: a */
    public static void m26517a(Activity activity, boolean z, String str, String str2, String str3, String str4, IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "权限开启";
        }
        String str5 = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "开启APP预警需授权【悬浮框权限】\n如未授权会导致功能无法使用。";
        }
        String str6 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "取消";
        }
        String str7 = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = "去授权";
        }
        C7257b1.m26230f(activity, str5, str6, str7, str4, new c(activity, iOneClickListener, z));
    }

    /* renamed from: a */
    public static boolean m26519a() {
        try {
            Cursor query = Hicore.getApp().getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "type", CommonNetImpl.NAME, "geocoded_location"}, null, null, null);
            if (query == null) {
                return true;
            }
            query.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static int m26511a(Context context) {
        try {
            if (context != null) {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/allowfloatwindowapp"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
                if (query != null) {
                    query.getColumnNames();
                    if (query.moveToFirst()) {
                        int i2 = query.getInt(query.getColumnIndex("currentlmode"));
                        query.close();
                        return i2;
                    }
                    query.close();
                    return m26521b(context);
                }
                return m26521b(context);
            }
            throw new IllegalArgumentException("context is null");
        } catch (Exception unused) {
            return m26521b(context);
        }
    }
}
