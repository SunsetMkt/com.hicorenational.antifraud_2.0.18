package p023b.p024a.p025a.p026d;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import p023b.p024a.p025a.p029g.C0931d;

/* compiled from: JavaBean.java */
/* renamed from: b.a.a.d.f */
/* loaded from: classes.dex */
public class C0908f implements Serializable {
    private static final long serialVersionUID = -6111323241670458039L;

    public String toString() {
        int i2;
        ArrayList arrayList = new ArrayList();
        Class<?> cls = getClass();
        arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            i2 = 0;
            if (cls == Object.class) {
                break;
            }
            cls = cls.getSuperclass();
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            while (i2 < length) {
                Field field = declaredFields[i2];
                int modifiers = field.getModifiers();
                if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                    arrayList.add(field);
                }
                i2++;
            }
        }
        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[arrayList.size()]);
        int length2 = fieldArr.length;
        while (i2 < length2) {
            Field field2 = fieldArr[i2];
            String name = field2.getName();
            try {
                Object obj = field2.get(this);
                sb.append(name);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(obj);
                sb.append("\n");
            } catch (IllegalAccessException e2) {
                C0931d.m1148a(e2);
            }
            i2++;
        }
        return sb.toString();
    }
}
