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

/* JADX INFO: loaded from: classes2.dex */
public final class XPermission {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static List<String> f5358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static XPermission f5359l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static d f5360m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static d f5361n;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f5362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f5363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f5364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f5365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f5366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f5367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f5368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f5369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f5370j;

    @RequiresApi(api = 23)
    public static class PermissionActivity extends Activity {
        private static final String a = "TYPE";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f5371b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f5372c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f5373d = 3;

        public static void a(Context context, int i2) {
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
                if (XPermission.f5360m == null) {
                    return;
                }
                if (XPermission.f5359l.c()) {
                    XPermission.f5360m.onGranted();
                } else {
                    XPermission.f5360m.a();
                }
                d unused = XPermission.f5360m = null;
            } else if (i2 == 3) {
                if (XPermission.f5361n == null) {
                    return;
                }
                if (XPermission.f5359l.b()) {
                    XPermission.f5361n.onGranted();
                } else {
                    XPermission.f5361n.a();
                }
                d unused2 = XPermission.f5361n = null;
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
                    XPermission.f5359l.b(this, 2);
                    return;
                } else {
                    if (intExtra == 3) {
                        super.onCreate(bundle);
                        XPermission.f5359l.a(this, 3);
                        return;
                    }
                    return;
                }
            }
            if (XPermission.f5359l == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            if (XPermission.f5359l.f5365e != null) {
                XPermission.f5359l.f5365e.a(this);
            }
            super.onCreate(bundle);
            if (XPermission.f5359l.c(this)) {
                finish();
                return;
            }
            if (XPermission.f5359l.f5367g != null) {
                int size = XPermission.f5359l.f5367g.size();
                if (size <= 0) {
                    finish();
                } else {
                    requestPermissions((String[]) XPermission.f5359l.f5367g.toArray(new String[size]), 1);
                }
            }
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            XPermission.f5359l.b(this);
            finish();
        }
    }

    class a implements c.a {
        a() {
        }

        @Override // com.lxj.xpermission.XPermission.c.a
        public void a(boolean z) {
            if (z) {
                XPermission.this.j();
            } else {
                XPermission.this.i();
            }
        }
    }

    public interface b {
        void a(List<String> list);

        void a(List<String> list, List<String> list2);
    }

    public interface c {

        public interface a {
            void a(boolean z);
        }

        void a(a aVar);
    }

    public interface d {
        void a();

        void onGranted();
    }

    public interface e {
        void a(Activity activity);
    }

    private XPermission(Context context, String... strArr) {
        f5359l = this;
        this.a = context;
        b(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f5363c != null) {
            if (this.f5367g.size() == 0 || this.f5366f.size() == this.f5368h.size()) {
                this.f5363c.onGranted();
            } else if (!this.f5369i.isEmpty()) {
                this.f5363c.a();
            }
            this.f5363c = null;
        }
        if (this.f5364d != null) {
            if (this.f5367g.size() == 0 || this.f5366f.size() == this.f5368h.size()) {
                this.f5364d.a(this.f5368h);
            } else if (!this.f5369i.isEmpty()) {
                this.f5364d.a(this.f5370j, this.f5369i);
            }
            this.f5364d = null;
        }
        this.f5362b = null;
        this.f5365e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    public void j() {
        this.f5369i = new ArrayList();
        this.f5370j = new ArrayList();
        PermissionActivity.a(this.a, 1);
    }

    @RequiresApi(api = 23)
    public boolean c() {
        return Settings.System.canWrite(this.a);
    }

    public void e() {
        this.f5368h = new ArrayList();
        this.f5367g = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            this.f5368h.addAll(this.f5366f);
            i();
            return;
        }
        for (String str : this.f5366f) {
            if (b(str)) {
                this.f5368h.add(str);
            } else {
                this.f5367g.add(str);
            }
        }
        if (this.f5367g.isEmpty()) {
            i();
        } else {
            j();
        }
    }

    @RequiresApi(api = 23)
    public void c(d dVar) {
        if (!c()) {
            f5360m = dVar;
            PermissionActivity.a(this.a, 2);
        } else if (dVar != null) {
            dVar.onGranted();
        }
    }

    public void d() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + this.a.getPackageName()));
        if (a(intent)) {
            this.a.startActivity(intent.addFlags(CommonNetImpl.FLAG_AUTH));
        }
    }

    private boolean b(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this.a, str) == 0;
    }

    public List<String> a() {
        return a(this.a.getPackageName());
    }

    public List<String> a(String str) {
        try {
            String[] strArr = this.a.getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
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
    public void b(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.a.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    public boolean c(Activity activity) {
        boolean z = false;
        if (this.f5362b != null) {
            Iterator<String> it = this.f5367g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (activity.shouldShowRequestPermissionRationale(it.next())) {
                    a(activity);
                    this.f5362b.a(new a());
                    z = true;
                    break;
                }
            }
            this.f5362b = null;
        }
        return z;
    }

    public boolean a(String... strArr) {
        for (String str : strArr) {
            if (!b(str)) {
                return false;
            }
        }
        return true;
    }

    @RequiresApi(api = 23)
    public boolean b() {
        if (Build.VERSION.SDK_INT >= 26) {
            AppOpsManager appOpsManager = (AppOpsManager) this.a.getSystemService("appops");
            if (appOpsManager == null) {
                return false;
            }
            int iCheckOpNoThrow = appOpsManager.checkOpNoThrow("android:system_alert_window", Process.myUid(), this.a.getPackageName());
            return iCheckOpNoThrow == 0 || iCheckOpNoThrow == 1;
        }
        return Settings.canDrawOverlays(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void a(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + this.a.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    @RequiresApi(api = 23)
    public void b(d dVar) {
        if (!b()) {
            f5361n = dVar;
            PermissionActivity.a(this.a, 3);
        } else if (dVar != null) {
            dVar.onGranted();
        }
    }

    public static XPermission a(Context context, String... strArr) {
        XPermission xPermission = f5359l;
        if (xPermission == null) {
            return new XPermission(context, strArr);
        }
        xPermission.b(strArr);
        return f5359l;
    }

    public static XPermission a(Context context) {
        return a(context, (String[]) null);
    }

    private void b(String... strArr) {
        this.f5366f = new LinkedHashSet();
        f5358k = a();
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            for (String str2 : com.lxj.xpermission.b.a(str)) {
                if (f5358k.contains(str2)) {
                    this.f5366f.add(str2);
                }
            }
        }
    }

    private boolean a(Intent intent) {
        return this.a.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public XPermission a(c cVar) {
        this.f5362b = cVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        a(activity);
        i();
    }

    public XPermission a(d dVar) {
        this.f5363c = dVar;
        return this;
    }

    public XPermission a(b bVar) {
        this.f5364d = bVar;
        return this;
    }

    public XPermission a(e eVar) {
        this.f5365e = eVar;
        return this;
    }

    private void a(Activity activity) {
        for (String str : this.f5367g) {
            if (b(str)) {
                this.f5368h.add(str);
            } else {
                this.f5369i.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f5370j.add(str);
                }
            }
        }
    }
}
