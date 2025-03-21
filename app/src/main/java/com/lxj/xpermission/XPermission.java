package com.lxj.xpermission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class XPermission {

    /* renamed from: k */
    private static List<String> f8508k;

    /* renamed from: l */
    private static XPermission f8509l;

    /* renamed from: m */
    private static InterfaceC2762d f8510m;

    /* renamed from: n */
    private static InterfaceC2762d f8511n;

    /* renamed from: a */
    private Context f8512a;

    /* renamed from: b */
    private InterfaceC2761c f8513b;

    /* renamed from: c */
    private InterfaceC2762d f8514c;

    /* renamed from: d */
    private InterfaceC2760b f8515d;

    /* renamed from: e */
    private InterfaceC2763e f8516e;

    /* renamed from: f */
    private Set<String> f8517f;

    /* renamed from: g */
    private List<String> f8518g;

    /* renamed from: h */
    private List<String> f8519h;

    /* renamed from: i */
    private List<String> f8520i;

    /* renamed from: j */
    private List<String> f8521j;

    @RequiresApi(api = 23)
    public static class PermissionActivity extends Activity {

        /* renamed from: a */
        private static final String f8522a = "TYPE";

        /* renamed from: b */
        public static final int f8523b = 1;

        /* renamed from: c */
        public static final int f8524c = 2;

        /* renamed from: d */
        public static final int f8525d = 3;

        /* renamed from: a */
        public static void m8286a(Context context, int i2) {
            Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            intent.putExtra("TYPE", i2);
            context.startActivity(intent);
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            finish();
            return true;
        }

        @Override // android.app.Activity
        protected void onActivityResult(int i2, int i3, Intent intent) {
            if (i2 == 2) {
                if (XPermission.f8510m == null) {
                    return;
                }
                if (XPermission.f8509l.m8283c()) {
                    XPermission.f8510m.onGranted();
                } else {
                    XPermission.f8510m.mo8291a();
                }
                InterfaceC2762d unused = XPermission.f8510m = null;
            } else if (i2 == 3) {
                if (XPermission.f8511n == null) {
                    return;
                }
                if (XPermission.f8509l.m8281b()) {
                    XPermission.f8511n.onGranted();
                } else {
                    XPermission.f8511n.mo8291a();
                }
                InterfaceC2762d unused2 = XPermission.f8511n = null;
            }
            finish();
        }

        @Override // android.app.Activity
        protected void onCreate(@Nullable Bundle bundle) {
            getWindow().addFlags(262672);
            getWindow().getAttributes().alpha = 0.0f;
            int intExtra = getIntent().getIntExtra("TYPE", 1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    super.onCreate(bundle);
                    XPermission.f8509l.m8257b(this, 2);
                    return;
                } else {
                    if (intExtra == 3) {
                        super.onCreate(bundle);
                        XPermission.f8509l.m8251a(this, 3);
                        return;
                    }
                    return;
                }
            }
            if (XPermission.f8509l == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            if (XPermission.f8509l.f8516e != null) {
                XPermission.f8509l.f8516e.m8292a(this);
            }
            super.onCreate(bundle);
            if (XPermission.f8509l.m8264c(this)) {
                finish();
                return;
            }
            if (XPermission.f8509l.f8518g != null) {
                int size = XPermission.f8509l.f8518g.size();
                if (size <= 0) {
                    finish();
                } else {
                    requestPermissions((String[]) XPermission.f8509l.f8518g.toArray(new String[size]), 1);
                }
            }
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            XPermission.f8509l.m8256b(this);
            finish();
        }
    }

    /* renamed from: com.lxj.xpermission.XPermission$a */
    class C2759a implements InterfaceC2761c.a {
        C2759a() {
        }

        @Override // com.lxj.xpermission.XPermission.InterfaceC2761c.a
        /* renamed from: a */
        public void mo8287a(boolean z) {
            if (z) {
                XPermission.this.m8272j();
            } else {
                XPermission.this.m8271i();
            }
        }
    }

    /* renamed from: com.lxj.xpermission.XPermission$b */
    public interface InterfaceC2760b {
        /* renamed from: a */
        void m8288a(List<String> list);

        /* renamed from: a */
        void m8289a(List<String> list, List<String> list2);
    }

    /* renamed from: com.lxj.xpermission.XPermission$c */
    public interface InterfaceC2761c {

        /* renamed from: com.lxj.xpermission.XPermission$c$a */
        public interface a {
            /* renamed from: a */
            void mo8287a(boolean z);
        }

        /* renamed from: a */
        void m8290a(a aVar);
    }

    /* renamed from: com.lxj.xpermission.XPermission$d */
    public interface InterfaceC2762d {
        /* renamed from: a */
        void mo8291a();

        void onGranted();
    }

    /* renamed from: com.lxj.xpermission.XPermission$e */
    public interface InterfaceC2763e {
        /* renamed from: a */
        void m8292a(Activity activity);
    }

    private XPermission(Context context, String... strArr) {
        f8509l = this;
        this.f8512a = context;
        m8261b(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m8271i() {
        if (this.f8514c != null) {
            if (this.f8518g.size() == 0 || this.f8517f.size() == this.f8519h.size()) {
                this.f8514c.onGranted();
            } else if (!this.f8520i.isEmpty()) {
                this.f8514c.mo8291a();
            }
            this.f8514c = null;
        }
        if (this.f8515d != null) {
            if (this.f8518g.size() == 0 || this.f8517f.size() == this.f8519h.size()) {
                this.f8515d.m8288a(this.f8519h);
            } else if (!this.f8520i.isEmpty()) {
                this.f8515d.m8289a(this.f8521j, this.f8520i);
            }
            this.f8515d = null;
        }
        this.f8513b = null;
        this.f8516e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    /* renamed from: j */
    public void m8272j() {
        this.f8520i = new ArrayList();
        this.f8521j = new ArrayList();
        PermissionActivity.m8286a(this.f8512a, 1);
    }

    @RequiresApi(api = 23)
    /* renamed from: c */
    public boolean m8283c() {
        return Settings.System.canWrite(this.f8512a);
    }

    /* renamed from: e */
    public void m8285e() {
        this.f8519h = new ArrayList();
        this.f8518g = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            this.f8519h.addAll(this.f8517f);
            m8271i();
            return;
        }
        for (String str : this.f8517f) {
            if (m8262b(str)) {
                this.f8519h.add(str);
            } else {
                this.f8518g.add(str);
            }
        }
        if (this.f8518g.isEmpty()) {
            m8271i();
        } else {
            m8272j();
        }
    }

    @RequiresApi(api = 23)
    /* renamed from: c */
    public void m8282c(InterfaceC2762d interfaceC2762d) {
        if (!m8283c()) {
            f8510m = interfaceC2762d;
            PermissionActivity.m8286a(this.f8512a, 2);
        } else if (interfaceC2762d != null) {
            interfaceC2762d.onGranted();
        }
    }

    /* renamed from: d */
    public void m8284d() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f8512a.getPackageName()));
        if (m8254a(intent)) {
            this.f8512a.startActivity(intent.addFlags(CommonNetImpl.FLAG_AUTH));
        }
    }

    /* renamed from: b */
    private boolean m8262b(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this.f8512a, str) == 0;
    }

    /* renamed from: a */
    public List<String> m8277a() {
        return m8278a(this.f8512a.getPackageName());
    }

    /* renamed from: a */
    public List<String> m8278a(String str) {
        try {
            String[] strArr = this.f8512a.getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* renamed from: b */
    public void m8257b(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f8512a.getPackageName()));
        if (!m8254a(intent)) {
            m8284d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    /* renamed from: c */
    public boolean m8264c(Activity activity) {
        boolean z = false;
        if (this.f8513b != null) {
            Iterator<String> it = this.f8518g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (activity.shouldShowRequestPermissionRationale(it.next())) {
                    m8250a(activity);
                    this.f8513b.m8290a(new C2759a());
                    z = true;
                    break;
                }
            }
            this.f8513b = null;
        }
        return z;
    }

    /* renamed from: a */
    public boolean m8279a(String... strArr) {
        for (String str : strArr) {
            if (!m8262b(str)) {
                return false;
            }
        }
        return true;
    }

    @RequiresApi(api = 23)
    /* renamed from: b */
    public boolean m8281b() {
        if (Build.VERSION.SDK_INT >= 26) {
            AppOpsManager appOpsManager = (AppOpsManager) this.f8512a.getSystemService("appops");
            if (appOpsManager == null) {
                return false;
            }
            int checkOpNoThrow = appOpsManager.checkOpNoThrow("android:system_alert_window", Process.myUid(), this.f8512a.getPackageName());
            return checkOpNoThrow == 0 || checkOpNoThrow == 1;
        }
        return Settings.canDrawOverlays(this.f8512a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* renamed from: a */
    public void m8251a(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + this.f8512a.getPackageName()));
        if (!m8254a(intent)) {
            m8284d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    @RequiresApi(api = 23)
    /* renamed from: b */
    public void m8280b(InterfaceC2762d interfaceC2762d) {
        if (!m8281b()) {
            f8511n = interfaceC2762d;
            PermissionActivity.m8286a(this.f8512a, 3);
        } else if (interfaceC2762d != null) {
            interfaceC2762d.onGranted();
        }
    }

    /* renamed from: a */
    public static XPermission m8249a(Context context, String... strArr) {
        XPermission xPermission = f8509l;
        if (xPermission == null) {
            return new XPermission(context, strArr);
        }
        xPermission.m8261b(strArr);
        return f8509l;
    }

    /* renamed from: a */
    public static XPermission m8248a(Context context) {
        return m8249a(context, (String[]) null);
    }

    /* renamed from: b */
    private void m8261b(String... strArr) {
        this.f8517f = new LinkedHashSet();
        f8508k = m8277a();
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            for (String str2 : C2765b.m8293a(str)) {
                if (f8508k.contains(str2)) {
                    this.f8517f.add(str2);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m8254a(Intent intent) {
        return this.f8512a.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* renamed from: a */
    public XPermission m8274a(InterfaceC2761c interfaceC2761c) {
        this.f8513b = interfaceC2761c;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8256b(Activity activity) {
        m8250a(activity);
        m8271i();
    }

    /* renamed from: a */
    public XPermission m8275a(InterfaceC2762d interfaceC2762d) {
        this.f8514c = interfaceC2762d;
        return this;
    }

    /* renamed from: a */
    public XPermission m8273a(InterfaceC2760b interfaceC2760b) {
        this.f8515d = interfaceC2760b;
        return this;
    }

    /* renamed from: a */
    public XPermission m8276a(InterfaceC2763e interfaceC2763e) {
        this.f8516e = interfaceC2763e;
        return this;
    }

    /* renamed from: a */
    private void m8250a(Activity activity) {
        for (String str : this.f8518g) {
            if (m8262b(str)) {
                this.f8519h.add(str);
            } else {
                this.f8520i.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f8521j.add(str);
                }
            }
        }
    }
}
