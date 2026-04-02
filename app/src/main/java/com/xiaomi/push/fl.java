package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hihonor.honorid.core.data.ChildrenInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class fl implements fp {
    private String a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<fl> f521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String[] f522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8983b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String[] f523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8984c;

    public fl(String str, String str2, String[] strArr, String[] strArr2) {
        this.f522a = null;
        this.f523b = null;
        this.f521a = null;
        this.a = str;
        this.f8983b = str2;
        this.f522a = strArr;
        this.f523b = strArr2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m426a() {
        return this.a;
    }

    public String b() {
        return this.f8983b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.f8984c) ? fx.b(this.f8984c) : this.f8984c;
    }

    @Override // com.xiaomi.push.fp
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.a);
        if (!TextUtils.isEmpty(this.f8983b)) {
            sb.append(d.c.a.b.a.a.f10074g);
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.f8983b);
            sb.append("\"");
        }
        String[] strArr = this.f522a;
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < this.f522a.length; i2++) {
                if (!TextUtils.isEmpty(this.f523b[i2])) {
                    sb.append(d.c.a.b.a.a.f10074g);
                    sb.append(this.f522a[i2]);
                    sb.append("=\"");
                    sb.append(fx.a(this.f523b[i2]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.f8984c)) {
            List<fl> list = this.f521a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
            } else {
                sb.append(">");
                Iterator<fl> it = this.f521a.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().d());
                }
                sb.append("</");
                sb.append(this.a);
                sb.append(">");
            }
        } else {
            sb.append(">");
            sb.append(this.f8984c);
            sb.append("</");
            sb.append(this.a);
            sb.append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return d();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.f8983b);
        bundle.putString("ext_text", this.f8984c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f522a;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.f522a;
                if (i2 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i2], this.f523b[i2]);
                i2++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fl> list = this.f521a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray(ChildrenInfo.o, a(this.f521a));
        }
        return bundle;
    }

    public fl(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fl> list) {
        this.f522a = null;
        this.f523b = null;
        this.f521a = null;
        this.a = str;
        this.f8983b = str2;
        this.f522a = strArr;
        this.f523b = strArr2;
        this.f8984c = str3;
        this.f521a = list;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Parcelable m425a() {
        return a();
    }

    public static Parcelable[] a(fl[] flVarArr) {
        if (flVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[flVarArr.length];
        for (int i2 = 0; i2 < flVarArr.length; i2++) {
            parcelableArr[i2] = flVarArr[i2].m425a();
        }
        return parcelableArr;
    }

    public static Parcelable[] a(List<fl> list) {
        return a((fl[]) list.toArray(new fl[list.size()]));
    }

    public static fl a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> setKeySet = bundle2.keySet();
        String[] strArr = new String[setKeySet.size()];
        String[] strArr2 = new String[setKeySet.size()];
        int i2 = 0;
        for (String str : setKeySet) {
            strArr[i2] = str;
            strArr2[i2] = bundle2.getString(str);
            i2++;
        }
        if (bundle.containsKey(ChildrenInfo.o)) {
            Parcelable[] parcelableArray = bundle.getParcelableArray(ChildrenInfo.o);
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fl(string, string2, strArr, strArr2, string3, arrayList);
    }

    public String a(String str) {
        if (str != null) {
            if (this.f522a == null) {
                return null;
            }
            int i2 = 0;
            while (true) {
                String[] strArr = this.f522a;
                if (i2 >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i2])) {
                    return this.f523b[i2];
                }
                i2++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(fl flVar) {
        if (this.f521a == null) {
            this.f521a = new ArrayList();
        }
        if (this.f521a.contains(flVar)) {
            return;
        }
        this.f521a.add(flVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m427a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8984c = fx.a(str);
        } else {
            this.f8984c = str;
        }
    }
}
