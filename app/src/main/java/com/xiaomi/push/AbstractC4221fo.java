package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.push.fo */
/* loaded from: classes2.dex */
public abstract class AbstractC4221fo {

    /* renamed from: b */
    private static long f15346b;

    /* renamed from: c */
    private static String f15348c;

    /* renamed from: a */
    public long f15349a;

    /* renamed from: a */
    private C4225fs f15350a;

    /* renamed from: a */
    private List<C4218fl> f15351a;

    /* renamed from: a */
    private final Map<String, Object> f15352a;

    /* renamed from: d */
    private String f15353d;

    /* renamed from: e */
    private String f15354e;

    /* renamed from: f */
    private String f15355f;

    /* renamed from: g */
    private String f15356g;

    /* renamed from: h */
    private String f15357h;

    /* renamed from: i */
    private String f15358i;

    /* renamed from: a */
    protected static final String f15344a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: b */
    private static String f15347b = null;

    /* renamed from: a */
    public static final DateFormat f15345a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static {
        f15345a.setTimeZone(TimeZone.getTimeZone("UTC"));
        f15348c = C4230fx.m14900a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        f15346b = 0L;
    }

    public AbstractC4221fo() {
        this.f15353d = f15347b;
        this.f15354e = null;
        this.f15355f = null;
        this.f15356g = null;
        this.f15357h = null;
        this.f15358i = null;
        this.f15351a = new CopyOnWriteArrayList();
        this.f15352a = new HashMap();
        this.f15350a = null;
    }

    /* renamed from: i */
    public static synchronized String m14854i() {
        String sb;
        synchronized (AbstractC4221fo.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f15348c);
            long j2 = f15346b;
            f15346b = 1 + j2;
            sb2.append(Long.toString(j2));
            sb = sb2.toString();
        }
        return sb;
    }

    /* renamed from: q */
    public static String m14855q() {
        return f15344a;
    }

    /* renamed from: a */
    public C4225fs m14858a() {
        return this.f15350a;
    }

    /* renamed from: a */
    public abstract String mo14829a();

    /* renamed from: b */
    public synchronized Collection<String> m14863b() {
        if (this.f15352a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f15352a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC4221fo abstractC4221fo = (AbstractC4221fo) obj;
        C4225fs c4225fs = this.f15350a;
        if (c4225fs == null ? abstractC4221fo.f15350a != null : !c4225fs.equals(abstractC4221fo.f15350a)) {
            return false;
        }
        String str = this.f15356g;
        if (str == null ? abstractC4221fo.f15356g != null : !str.equals(abstractC4221fo.f15356g)) {
            return false;
        }
        if (!this.f15351a.equals(abstractC4221fo.f15351a)) {
            return false;
        }
        String str2 = this.f15354e;
        if (str2 == null ? abstractC4221fo.f15354e != null : !str2.equals(abstractC4221fo.f15354e)) {
            return false;
        }
        String str3 = this.f15357h;
        if (str3 == null ? abstractC4221fo.f15357h != null : !str3.equals(abstractC4221fo.f15357h)) {
            return false;
        }
        Map<String, Object> map = this.f15352a;
        if (map == null ? abstractC4221fo.f15352a != null : !map.equals(abstractC4221fo.f15352a)) {
            return false;
        }
        String str4 = this.f15355f;
        if (str4 == null ? abstractC4221fo.f15355f != null : !str4.equals(abstractC4221fo.f15355f)) {
            return false;
        }
        String str5 = this.f15353d;
        String str6 = abstractC4221fo.f15353d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f15353d;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f15354e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f15355f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f15356g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f15357h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f15351a.hashCode()) * 31) + this.f15352a.hashCode()) * 31;
        C4225fs c4225fs = this.f15350a;
        return hashCode5 + (c4225fs != null ? c4225fs.hashCode() : 0);
    }

    /* renamed from: j */
    public String m14864j() {
        if ("ID_NOT_AVAILABLE".equals(this.f15354e)) {
            return null;
        }
        if (this.f15354e == null) {
            this.f15354e = m14854i();
        }
        return this.f15354e;
    }

    /* renamed from: k */
    public void m14866k(String str) {
        this.f15354e = str;
    }

    /* renamed from: l */
    public void m14868l(String str) {
        this.f15357h = str;
    }

    /* renamed from: m */
    public void m14870m(String str) {
        this.f15355f = str;
    }

    /* renamed from: n */
    public void m14872n(String str) {
        this.f15356g = str;
    }

    /* renamed from: o */
    public void m14874o(String str) {
        this.f15358i = str;
    }

    /* renamed from: p */
    public String m14875p() {
        return this.f15353d;
    }

    /* renamed from: a */
    public void m14862a(C4225fs c4225fs) {
        this.f15350a = c4225fs;
    }

    /* renamed from: k */
    public String m14865k() {
        return this.f15357h;
    }

    /* renamed from: l */
    public String m14867l() {
        return this.f15355f;
    }

    /* renamed from: m */
    public String m14869m() {
        return this.f15356g;
    }

    /* renamed from: n */
    public String m14871n() {
        return this.f15358i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:40|41|42|43|44|(4:45|46|48|49)|50|51|53) */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected synchronized java.lang.String m14873o() {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.AbstractC4221fo.m14873o():java.lang.String");
    }

    /* renamed from: a */
    public synchronized Collection<C4218fl> m14860a() {
        if (this.f15351a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f15351a));
    }

    /* renamed from: a */
    public C4218fl m14856a(String str) {
        return m14857a(str, null);
    }

    /* renamed from: a */
    public C4218fl m14857a(String str, String str2) {
        for (C4218fl c4218fl : this.f15351a) {
            if (str2 == null || str2.equals(c4218fl.m14824b())) {
                if (str.equals(c4218fl.m14820a())) {
                    return c4218fl;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m14861a(C4218fl c4218fl) {
        this.f15351a.add(c4218fl);
    }

    public AbstractC4221fo(Bundle bundle) {
        this.f15353d = f15347b;
        this.f15354e = null;
        this.f15355f = null;
        this.f15356g = null;
        this.f15357h = null;
        this.f15358i = null;
        this.f15351a = new CopyOnWriteArrayList();
        this.f15352a = new HashMap();
        this.f15350a = null;
        this.f15355f = bundle.getString("ext_to");
        this.f15356g = bundle.getString("ext_from");
        this.f15357h = bundle.getString("ext_chid");
        this.f15354e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f15351a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C4218fl m14815a = C4218fl.m14815a((Bundle) parcelable);
                if (m14815a != null) {
                    this.f15351a.add(m14815a);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f15350a = new C4225fs(bundle2);
        }
    }

    /* renamed from: a */
    public synchronized Object m14859a(String str) {
        if (this.f15352a == null) {
            return null;
        }
        return this.f15352a.get(str);
    }

    /* renamed from: a */
    public Bundle mo14827a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f15353d)) {
            bundle.putString("ext_ns", this.f15353d);
        }
        if (!TextUtils.isEmpty(this.f15356g)) {
            bundle.putString("ext_from", this.f15356g);
        }
        if (!TextUtils.isEmpty(this.f15355f)) {
            bundle.putString("ext_to", this.f15355f);
        }
        if (!TextUtils.isEmpty(this.f15354e)) {
            bundle.putString("ext_pkt_id", this.f15354e);
        }
        if (!TextUtils.isEmpty(this.f15357h)) {
            bundle.putString("ext_chid", this.f15357h);
        }
        C4225fs c4225fs = this.f15350a;
        if (c4225fs != null) {
            bundle.putBundle("ext_ERROR", c4225fs.m14881a());
        }
        List<C4218fl> list = this.f15351a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            Iterator<C4218fl> it = this.f15351a.iterator();
            while (it.hasNext()) {
                Bundle m14818a = it.next().m14818a();
                if (m14818a != null) {
                    bundleArr[i2] = m14818a;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }
}
