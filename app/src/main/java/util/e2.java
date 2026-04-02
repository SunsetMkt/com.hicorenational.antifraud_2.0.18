package util;

import android.text.TextUtils;
import android.widget.Toast;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.tools.DoubleUtils;
import ui.Hicore;

/* JADX INFO: compiled from: ToastUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class e2 {
    private static Toast a;

    public static void a(String str) {
        if (TextUtils.isEmpty(str) || Hicore.getApp() == null || DoubleUtils.isFastDoubleClick()) {
            return;
        }
        a = Toast.makeText(Hicore.getApp(), str, 0);
        a.setGravity(17, 0, 0);
        a.show();
    }

    public static void b(int i2) {
        if (Hicore.getApp() == null) {
            return;
        }
        a = Toast.makeText(Hicore.getApp(), a(i2), 0);
        a.setGravity(17, 0, 0);
        a.show();
    }

    public static void c(String str) {
        if (Hicore.getApp() == null) {
            return;
        }
        a = Toast.makeText(Hicore.getApp(), str, 0);
        a.setGravity(17, 0, 0);
        a.show();
    }

    public static void d(int i2) {
        Toast toast = a;
        if (toast == null) {
            a = Toast.makeText(Hicore.getApp(), a(i2), 0);
            a.setGravity(17, 0, 0);
            a.show();
        } else {
            toast.setGravity(17, 0, 0);
            a.setDuration(0);
            a.setText(a(i2));
            a.show();
        }
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Hicore.getApp().getResources().getString(R.string.err_timeout);
        }
        a(str);
    }

    public static void f(String str) {
        Toast toast = a;
        if (toast == null) {
            a = Toast.makeText(Hicore.getApp(), str, 0);
            a.setGravity(17, 0, 0);
            a.show();
        } else {
            toast.setGravity(17, 0, 0);
            a.setDuration(0);
            a.setText(str);
            a.show();
        }
    }

    public static void c(int i2) {
        Toast toast = a;
        if (toast == null) {
            a = Toast.makeText(Hicore.getApp(), a(i2), 1);
            a.setGravity(17, 0, 0);
            a.show();
        } else {
            toast.setGravity(17, 0, 0);
            a.setDuration(1);
            a.setText(a(i2));
            a.show();
        }
    }

    private static CharSequence a(int i2) {
        return Hicore.getApp().getResources().getString(i2);
    }

    public static void b(String str) {
        Toast toast = a;
        if (toast == null) {
            a = Toast.makeText(Hicore.getApp(), str, 0);
            a.setGravity(80, 0, 0);
            a.show();
        } else {
            toast.setGravity(80, 0, 0);
            a.setDuration(0);
            a.setText(str);
            a.show();
        }
    }

    public static void a(String str, int i2, int i3) {
        if (Hicore.getApp() == null) {
            return;
        }
        Toast toast = a;
        if (toast == null) {
            a = Toast.makeText(Hicore.getApp(), str, 0);
            a.setGravity(51, i2, i3);
            a.show();
        } else {
            toast.setGravity(51, i2, i3);
            a.setText(str);
            a.show();
        }
    }

    public static void d(String str) {
        Toast toast = a;
        if (toast == null) {
            a = Toast.makeText(Hicore.getApp(), str, 1);
            a.setGravity(17, 0, 0);
            a.show();
        } else {
            toast.setGravity(17, 0, 0);
            a.setDuration(1);
            a.setText(str);
            a.show();
        }
    }

    public static void a(float f2, float f3, String str) {
        if (Hicore.getApp() == null) {
            return;
        }
        Toast toast = a;
        if (toast == null) {
            a = Toast.makeText(Hicore.getApp(), str, 0);
            a.setMargin(f2, f3);
            a.show();
        } else {
            toast.setMargin(f2, f3);
            a.setText(str);
            a.show();
        }
    }
}
