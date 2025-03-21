package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hihonor.honorid.core.data.ChildrenInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.fl */
/* loaded from: classes2.dex */
public class C4218fl implements InterfaceC4222fp {

    /* renamed from: a */
    private String f15317a;

    /* renamed from: a */
    private List<C4218fl> f15318a;

    /* renamed from: a */
    private String[] f15319a;

    /* renamed from: b */
    private String f15320b;

    /* renamed from: b */
    private String[] f15321b;

    /* renamed from: c */
    private String f15322c;

    public C4218fl(String str, String str2, String[] strArr, String[] strArr2) {
        this.f15319a = null;
        this.f15321b = null;
        this.f15318a = null;
        this.f15317a = str;
        this.f15320b = str2;
        this.f15319a = strArr;
        this.f15321b = strArr2;
    }

    /* renamed from: a */
    public String m14820a() {
        return this.f15317a;
    }

    /* renamed from: b */
    public String m14824b() {
        return this.f15320b;
    }

    /* renamed from: c */
    public String m14825c() {
        return !TextUtils.isEmpty(this.f15322c) ? C4230fx.m14904b(this.f15322c) : this.f15322c;
    }

    @Override // com.xiaomi.push.InterfaceC4222fp
    /* renamed from: d */
    public String mo14826d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.f15317a);
        if (!TextUtils.isEmpty(this.f15320b)) {
            sb.append(AbstractC1191a.f2568g);
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.f15320b);
            sb.append("\"");
        }
        String[] strArr = this.f15319a;
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < this.f15319a.length; i2++) {
                if (!TextUtils.isEmpty(this.f15321b[i2])) {
                    sb.append(AbstractC1191a.f2568g);
                    sb.append(this.f15319a[i2]);
                    sb.append("=\"");
                    sb.append(C4230fx.m14901a(this.f15321b[i2]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.f15322c)) {
            List<C4218fl> list = this.f15318a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
            } else {
                sb.append(">");
                Iterator<C4218fl> it = this.f15318a.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().mo14826d());
                }
                sb.append("</");
                sb.append(this.f15317a);
                sb.append(">");
            }
        } else {
            sb.append(">");
            sb.append(this.f15322c);
            sb.append("</");
            sb.append(this.f15317a);
            sb.append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return mo14826d();
    }

    /* renamed from: a */
    public Bundle m14818a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f15317a);
        bundle.putString("ext_ns", this.f15320b);
        bundle.putString("ext_text", this.f15322c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f15319a;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.f15319a;
                if (i2 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i2], this.f15321b[i2]);
                i2++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<C4218fl> list = this.f15318a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray(ChildrenInfo.f6500o, m14816a(this.f15318a));
        }
        return bundle;
    }

    public C4218fl(String str, String str2, String[] strArr, String[] strArr2, String str3, List<C4218fl> list) {
        this.f15319a = null;
        this.f15321b = null;
        this.f15318a = null;
        this.f15317a = str;
        this.f15320b = str2;
        this.f15319a = strArr;
        this.f15321b = strArr2;
        this.f15322c = str3;
        this.f15318a = list;
    }

    /* renamed from: a */
    public Parcelable m14819a() {
        return m14818a();
    }

    /* renamed from: a */
    public static Parcelable[] m14817a(C4218fl[] c4218flArr) {
        if (c4218flArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[c4218flArr.length];
        for (int i2 = 0; i2 < c4218flArr.length; i2++) {
            parcelableArr[i2] = c4218flArr[i2].m14819a();
        }
        return parcelableArr;
    }

    /* renamed from: a */
    public static Parcelable[] m14816a(List<C4218fl> list) {
        return m14817a((C4218fl[]) list.toArray(new C4218fl[list.size()]));
    }

    /* renamed from: a */
    public static C4218fl m14815a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i2 = 0;
        for (String str : keySet) {
            strArr[i2] = str;
            strArr2[i2] = bundle2.getString(str);
            i2++;
        }
        if (bundle.containsKey(ChildrenInfo.f6500o)) {
            Parcelable[] parcelableArray = bundle.getParcelableArray(ChildrenInfo.f6500o);
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(m14815a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new C4218fl(string, string2, strArr, strArr2, string3, arrayList);
    }

    /* renamed from: a */
    public String m14821a(String str) {
        if (str != null) {
            if (this.f15319a == null) {
                return null;
            }
            int i2 = 0;
            while (true) {
                String[] strArr = this.f15319a;
                if (i2 >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i2])) {
                    return this.f15321b[i2];
                }
                i2++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public void m14822a(C4218fl c4218fl) {
        if (this.f15318a == null) {
            this.f15318a = new ArrayList();
        }
        if (this.f15318a.contains(c4218fl)) {
            return;
        }
        this.f15318a.add(c4218fl);
    }

    /* renamed from: a */
    public void m14823a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15322c = C4230fx.m14901a(str);
        } else {
            this.f15322c = str;
        }
    }
}
