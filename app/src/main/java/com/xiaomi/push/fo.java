package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
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

/* JADX INFO: loaded from: classes2.dex */
public abstract class fo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f9000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f9001c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fs f530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<fl> f531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f532a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f9005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9007i;
    protected static final String a = Locale.getDefault().getLanguage().toLowerCase();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f528b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final DateFormat f527a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static {
        f527a.setTimeZone(TimeZone.getTimeZone("UTC"));
        f9001c = fx.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        f9000b = 0L;
    }

    public fo() {
        this.f9002d = f528b;
        this.f9003e = null;
        this.f9004f = null;
        this.f9005g = null;
        this.f9006h = null;
        this.f9007i = null;
        this.f531a = new CopyOnWriteArrayList();
        this.f532a = new HashMap();
        this.f530a = null;
    }

    public static synchronized String i() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(f9001c);
        long j2 = f9000b;
        f9000b = 1 + j2;
        sb.append(Long.toString(j2));
        return sb.toString();
    }

    public static String q() {
        return a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fs m430a() {
        return this.f530a;
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo429a();

    public synchronized Collection<String> b() {
        if (this.f532a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f532a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fo foVar = (fo) obj;
        fs fsVar = this.f530a;
        if (fsVar == null ? foVar.f530a != null : !fsVar.equals(foVar.f530a)) {
            return false;
        }
        String str = this.f9005g;
        if (str == null ? foVar.f9005g != null : !str.equals(foVar.f9005g)) {
            return false;
        }
        if (!this.f531a.equals(foVar.f531a)) {
            return false;
        }
        String str2 = this.f9003e;
        if (str2 == null ? foVar.f9003e != null : !str2.equals(foVar.f9003e)) {
            return false;
        }
        String str3 = this.f9006h;
        if (str3 == null ? foVar.f9006h != null : !str3.equals(foVar.f9006h)) {
            return false;
        }
        Map<String, Object> map = this.f532a;
        if (map == null ? foVar.f532a != null : !map.equals(foVar.f532a)) {
            return false;
        }
        String str4 = this.f9004f;
        if (str4 == null ? foVar.f9004f != null : !str4.equals(foVar.f9004f)) {
            return false;
        }
        String str5 = this.f9002d;
        String str6 = foVar.f9002d;
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
        String str = this.f9002d;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f9003e;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9004f;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f9005g;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f9006h;
        int iHashCode5 = (((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f531a.hashCode()) * 31) + this.f532a.hashCode()) * 31;
        fs fsVar = this.f530a;
        return iHashCode5 + (fsVar != null ? fsVar.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f9003e)) {
            return null;
        }
        if (this.f9003e == null) {
            this.f9003e = i();
        }
        return this.f9003e;
    }

    public void k(String str) {
        this.f9003e = str;
    }

    public void l(String str) {
        this.f9006h = str;
    }

    public void m(String str) {
        this.f9004f = str;
    }

    public void n(String str) {
        this.f9005g = str;
    }

    public void o(String str) {
        this.f9007i = str;
    }

    public String p() {
        return this.f9002d;
    }

    public void a(fs fsVar) {
        this.f530a = fsVar;
    }

    public String k() {
        return this.f9006h;
    }

    public String l() {
        return this.f9004f;
    }

    public String m() {
        return this.f9005g;
    }

    public String n() {
        return this.f9007i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:33|93|34|91|35|(4:80|36|85|37)|82|38|104) */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected synchronized String o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e2;
        sb = new StringBuilder();
        Iterator<fl> it = m432a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        if (this.f532a != null && !this.f532a.isEmpty()) {
            sb.append(ay.b("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));
            for (String str : b()) {
                Object objM431a = m431a(str);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(fx.a(str));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (objM431a instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(objM431a);
                    sb.append("</value>");
                } else if (objM431a instanceof Long) {
                    sb.append("long\">");
                    sb.append(objM431a);
                    sb.append("</value>");
                } else if (objM431a instanceof Float) {
                    sb.append("float\">");
                    sb.append(objM431a);
                    sb.append("</value>");
                } else if (objM431a instanceof Double) {
                    sb.append("double\">");
                    sb.append(objM431a);
                    sb.append("</value>");
                } else if (objM431a instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(objM431a);
                    sb.append("</value>");
                } else if (objM431a instanceof String) {
                    sb.append("string\">");
                    sb.append(fx.a((String) objM431a));
                    sb.append("</value>");
                } else {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                    }
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    } catch (Exception e4) {
                        e = e4;
                        objectOutputStream = null;
                        e2 = e;
                        e2.printStackTrace();
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        sb.append("</property>");
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = null;
                    }
                    try {
                        try {
                            objectOutputStream.writeObject(objM431a);
                            sb.append("java-object\">");
                            sb.append(fx.a(byteArrayOutputStream.toByteArray()));
                            sb.append("</value>");
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (byteArrayOutputStream == null) {
                                throw th;
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        e2.printStackTrace();
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        sb.append("</property>");
                    }
                    byteArrayOutputStream.close();
                }
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Collection<fl> m432a() {
        if (this.f531a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f531a));
    }

    public fl a(String str) {
        return a(str, null);
    }

    public fl a(String str, String str2) {
        for (fl flVar : this.f531a) {
            if (str2 == null || str2.equals(flVar.b())) {
                if (str.equals(flVar.m426a())) {
                    return flVar;
                }
            }
        }
        return null;
    }

    public void a(fl flVar) {
        this.f531a.add(flVar);
    }

    public fo(Bundle bundle) {
        this.f9002d = f528b;
        this.f9003e = null;
        this.f9004f = null;
        this.f9005g = null;
        this.f9006h = null;
        this.f9007i = null;
        this.f531a = new CopyOnWriteArrayList();
        this.f532a = new HashMap();
        this.f530a = null;
        this.f9004f = bundle.getString("ext_to");
        this.f9005g = bundle.getString("ext_from");
        this.f9006h = bundle.getString("ext_chid");
        this.f9003e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f531a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fl flVarA = fl.a((Bundle) parcelable);
                if (flVarA != null) {
                    this.f531a.add(flVarA);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f530a = new fs(bundle2);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Object m431a(String str) {
        if (this.f532a == null) {
            return null;
        }
        return this.f532a.get(str);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f9002d)) {
            bundle.putString("ext_ns", this.f9002d);
        }
        if (!TextUtils.isEmpty(this.f9005g)) {
            bundle.putString("ext_from", this.f9005g);
        }
        if (!TextUtils.isEmpty(this.f9004f)) {
            bundle.putString("ext_to", this.f9004f);
        }
        if (!TextUtils.isEmpty(this.f9003e)) {
            bundle.putString("ext_pkt_id", this.f9003e);
        }
        if (!TextUtils.isEmpty(this.f9006h)) {
            bundle.putString("ext_chid", this.f9006h);
        }
        fs fsVar = this.f530a;
        if (fsVar != null) {
            bundle.putBundle("ext_ERROR", fsVar.a());
        }
        List<fl> list = this.f531a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            Iterator<fl> it = this.f531a.iterator();
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i2] = bundleA;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }
}
