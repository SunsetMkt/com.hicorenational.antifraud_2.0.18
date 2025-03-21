package util;

import android.text.TextUtils;
import android.widget.Toast;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.tools.DoubleUtils;
import p388ui.Hicore;

/* compiled from: ToastUtil.java */
/* renamed from: util.w1 */
/* loaded from: classes2.dex */
public class C7331w1 {

    /* renamed from: a */
    private static Toast f25722a;

    /* renamed from: a */
    public static void m26688a(String str) {
        if (TextUtils.isEmpty(str) || Hicore.getApp() == null || DoubleUtils.isFastDoubleClick()) {
            return;
        }
        f25722a = Toast.makeText(Hicore.getApp(), str, 0);
        f25722a.setGravity(17, 0, 0);
        f25722a.show();
    }

    /* renamed from: b */
    public static void m26690b(int i2) {
        if (Hicore.getApp() == null) {
            return;
        }
        f25722a = Toast.makeText(Hicore.getApp(), m26686a(i2), 0);
        f25722a.setGravity(17, 0, 0);
        f25722a.show();
    }

    /* renamed from: c */
    public static void m26693c(String str) {
        if (Hicore.getApp() == null) {
            return;
        }
        f25722a = Toast.makeText(Hicore.getApp(), str, 0);
        f25722a.setGravity(17, 0, 0);
        f25722a.show();
    }

    /* renamed from: d */
    public static void m26694d(int i2) {
        Toast toast = f25722a;
        if (toast == null) {
            f25722a = Toast.makeText(Hicore.getApp(), m26686a(i2), 0);
            f25722a.setGravity(17, 0, 0);
            f25722a.show();
        } else {
            toast.setGravity(17, 0, 0);
            f25722a.setDuration(0);
            f25722a.setText(m26686a(i2));
            f25722a.show();
        }
    }

    /* renamed from: e */
    public static void m26696e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Hicore.getApp().getResources().getString(C2113R.string.err_timeout);
        }
        m26688a(str);
    }

    /* renamed from: f */
    public static void m26697f(String str) {
        Toast toast = f25722a;
        if (toast == null) {
            f25722a = Toast.makeText(Hicore.getApp(), str, 0);
            f25722a.setGravity(17, 0, 0);
            f25722a.show();
        } else {
            toast.setGravity(17, 0, 0);
            f25722a.setDuration(0);
            f25722a.setText(str);
            f25722a.show();
        }
    }

    /* renamed from: c */
    public static void m26692c(int i2) {
        Toast toast = f25722a;
        if (toast == null) {
            f25722a = Toast.makeText(Hicore.getApp(), m26686a(i2), 1);
            f25722a.setGravity(17, 0, 0);
            f25722a.show();
        } else {
            toast.setGravity(17, 0, 0);
            f25722a.setDuration(1);
            f25722a.setText(m26686a(i2));
            f25722a.show();
        }
    }

    /* renamed from: a */
    private static CharSequence m26686a(int i2) {
        return Hicore.getApp().getResources().getString(i2);
    }

    /* renamed from: b */
    public static void m26691b(String str) {
        Toast toast = f25722a;
        if (toast == null) {
            f25722a = Toast.makeText(Hicore.getApp(), str, 0);
            f25722a.setGravity(80, 0, 0);
            f25722a.show();
        } else {
            toast.setGravity(80, 0, 0);
            f25722a.setDuration(0);
            f25722a.setText(str);
            f25722a.show();
        }
    }

    /* renamed from: a */
    public static void m26689a(String str, int i2, int i3) {
        if (Hicore.getApp() == null) {
            return;
        }
        Toast toast = f25722a;
        if (toast == null) {
            f25722a = Toast.makeText(Hicore.getApp(), str, 0);
            f25722a.setGravity(51, i2, i3);
            f25722a.show();
        } else {
            toast.setGravity(51, i2, i3);
            f25722a.setText(str);
            f25722a.show();
        }
    }

    /* renamed from: d */
    public static void m26695d(String str) {
        Toast toast = f25722a;
        if (toast == null) {
            f25722a = Toast.makeText(Hicore.getApp(), str, 1);
            f25722a.setGravity(17, 0, 0);
            f25722a.show();
        } else {
            toast.setGravity(17, 0, 0);
            f25722a.setDuration(1);
            f25722a.setText(str);
            f25722a.show();
        }
    }

    /* renamed from: a */
    public static void m26687a(float f2, float f3, String str) {
        if (Hicore.getApp() == null) {
            return;
        }
        Toast toast = f25722a;
        if (toast == null) {
            f25722a = Toast.makeText(Hicore.getApp(), str, 0);
            f25722a.setMargin(f2, f3);
            f25722a.show();
        } else {
            toast.setMargin(f2, f3);
            f25722a.setText(str);
            f25722a.show();
        }
    }
}
