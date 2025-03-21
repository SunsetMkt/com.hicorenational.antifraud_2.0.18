package ui.view.drag;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: ReflectUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        Method method;
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        while (true) {
            if (cls == Object.class) {
                method = null;
                break;
            }
            try {
                method = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (Exception unused) {
                cls = cls.getSuperclass();
            }
        }
        if (method == null) {
            return null;
        }
        method.setAccessible(true);
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
