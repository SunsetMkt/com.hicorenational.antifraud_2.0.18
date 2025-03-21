package p358k.p359a.p369b.p373b.p374a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/* compiled from: MessageCodec.java */
/* renamed from: k.a.b.b.a.b */
/* loaded from: classes2.dex */
public class C5871b {
    /* renamed from: a */
    public Bundle m24742a(Object obj, Bundle bundle) {
        for (Class<?> cls = obj.getClass(); cls != null && cls != Object.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    m24740a(obj, field, bundle);
                } catch (IllegalAccessException | IllegalArgumentException unused) {
                    String str = "encode, get value of the field exception, field name: " + field.getName();
                }
            }
        }
        return bundle;
    }

    /* renamed from: a */
    private void m24740a(Object obj, Field field, Bundle bundle) {
        if (Modifier.isTransient(field.getModifiers())) {
            return;
        }
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        m24741a(field.getName(), field.get(obj), bundle);
        field.setAccessible(isAccessible);
    }

    /* renamed from: a */
    private void m24741a(String str, Object obj, Bundle bundle) {
        if (obj != null) {
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
                return;
            }
            if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                bundle.putShort(str, ((Short) obj).shortValue());
                return;
            }
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
                return;
            }
            if (obj instanceof IBinder) {
                C5870a.m24738a(bundle, str, (IBinder) obj);
                return;
            }
            if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
                return;
            }
            if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
                return;
            }
            if (obj instanceof List) {
                m24743a(str, (List) obj, bundle);
                return;
            }
            if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj.getClass() != Object.class) {
                Bundle m24742a = m24742a(obj, new Bundle());
                m24742a.putInt("_val_type_", 0);
                bundle.putBundle(str, m24742a);
            }
        }
    }

    /* renamed from: a */
    protected void m24743a(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            m24741a("_list_item_" + i2, list.get(i2), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
