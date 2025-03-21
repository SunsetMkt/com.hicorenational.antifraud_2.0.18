package com.umeng.p221ut.p226b.p229b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.p221ut.p222a.C3796a;
import com.umeng.p221ut.p222a.p225c.C3809d;
import com.umeng.p221ut.p222a.p225c.C3810e;
import com.umeng.p221ut.p226b.p227a.p228a.C3811a;
import com.umeng.p221ut.p226b.p227a.p228a.C3812b;
import com.umeng.p221ut.p226b.p227a.p228a.C3813c;
import com.umeng.p221ut.p226b.p227a.p228a.C3814d;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.Config;

/* renamed from: com.umeng.ut.b.b.d */
/* loaded from: classes2.dex */
public class C3819d {

    /* renamed from: a */
    private static C3819d f13892a;

    /* renamed from: a */
    private Context f13895a;

    /* renamed from: c */
    private String f13896c = null;

    /* renamed from: d */
    private long f13897d = -1;

    /* renamed from: b */
    private static Pattern f13894b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* renamed from: a */
    private static final Object f13893a = new Object();

    private C3819d(Context context) {
        this.f13895a = context.getApplicationContext();
        C3796a.m12755a().m12760a(this.f13895a);
    }

    /* renamed from: a */
    public static C3819d m12808a(Context context) {
        if (context != null && f13892a == null) {
            synchronized (f13893a) {
                if (f13892a == null) {
                    f13892a = new C3819d(context);
                }
            }
        }
        return f13892a;
    }

    /* renamed from: b */
    private boolean m12813b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !f13894b.matcher(str).find();
        }
        return false;
    }

    /* renamed from: c */
    private long m12814c() {
        long j2;
        try {
            j2 = m12807a("um_push_ut").getLong("v_i", 604800L);
        } catch (Throwable unused) {
            j2 = 0;
        }
        if (j2 < 600) {
            j2 = 600;
        } else if (j2 > 7776000) {
            j2 = 7776000;
        }
        return j2 * 1000;
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: e */
    private void m12816e() {
        try {
            m12807a("um_push_ut").edit().remove("v_r").commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:2|3|(8:8|(2:10|(2:18|(3:22|23|24))(3:14|15|16))|25|26|(5:28|(1:30)|31|32|33)|35|36|37)|40|(0)|25|26|(0)|35|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006c, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: all -> 0x0072, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:10:0x0017, B:12:0x0025, B:14:0x002d, B:18:0x0031, B:20:0x003f, B:22:0x0047, B:26:0x0050, B:28:0x0056, B:30:0x0064, B:31:0x0067, B:39:0x006c), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056 A[Catch: Exception -> 0x006b, all -> 0x0072, TryCatch #1 {Exception -> 0x006b, blocks: (B:26:0x0050, B:28:0x0056, B:30:0x0064, B:31:0x0067), top: B:25:0x0050, outer: #0 }] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.lang.String m12817j() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.m12815c()     // Catch: java.lang.Throwable -> L72
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L14
            android.content.Context r0 = r4.f13895a     // Catch: java.lang.Throwable -> L72
            boolean r0 = com.umeng.p221ut.p222a.p225c.C3806a.m12770a(r0)     // Catch: java.lang.Throwable -> L72
            if (r0 != 0) goto L12
            goto L14
        L12:
            r0 = 0
            goto L15
        L14:
            r0 = 1
        L15:
            if (r0 == 0) goto L50
            java.lang.String r3 = r4.m12819l()     // Catch: java.lang.Throwable -> L72
            r4.f13896c = r3     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = r4.f13896c     // Catch: java.lang.Throwable -> L72
            boolean r3 = com.umeng.p221ut.p226b.p227a.p228a.C3814d.isEmpty(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 != 0) goto L31
            java.lang.String r3 = r4.f13896c     // Catch: java.lang.Throwable -> L72
            boolean r3 = r4.m12813b(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 == 0) goto L31
            java.lang.String r0 = r4.f13896c     // Catch: java.lang.Throwable -> L72
            monitor-exit(r4)
            return r0
        L31:
            java.lang.String r3 = r4.m12818k()     // Catch: java.lang.Throwable -> L72
            r4.f13896c = r3     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = r4.f13896c     // Catch: java.lang.Throwable -> L72
            boolean r3 = com.umeng.p221ut.p226b.p227a.p228a.C3814d.isEmpty(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 != 0) goto L50
            java.lang.String r3 = r4.f13896c     // Catch: java.lang.Throwable -> L72
            boolean r3 = r4.m12813b(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 == 0) goto L50
            java.lang.String r0 = r4.f13896c     // Catch: java.lang.Throwable -> L72
            r4.m12810a(r0, r1)     // Catch: java.lang.Throwable -> L72
            java.lang.String r0 = r4.f13896c     // Catch: java.lang.Throwable -> L72
            monitor-exit(r4)
            return r0
        L50:
            byte[] r1 = r4.m12811a()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            if (r1 == 0) goto L6f
            r3 = 2
            java.lang.String r1 = com.umeng.p221ut.p226b.p227a.p228a.C3811a.m12790a(r1, r3)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            r4.f13896c = r1     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            java.lang.String r1 = r4.f13896c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            r4.m12810a(r1, r2)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            if (r0 != 0) goto L67
            r4.m12816e()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
        L67:
            java.lang.String r0 = r4.f13896c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            monitor-exit(r4)
            return r0
        L6b:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L72
        L6f:
            r0 = 0
            monitor-exit(r4)
            return r0
        L72:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.p221ut.p226b.p229b.C3819d.m12817j():java.lang.String");
    }

    /* renamed from: k */
    private String m12818k() {
        try {
            SharedPreferences m12807a = m12807a(Config.PREFERENCES);
            String string = m12807a.getString("deviceId", null);
            if (string == null || string.length() <= 0) {
                return null;
            }
            String string2 = m12807a.getString("utdid", null);
            if (string2 != null) {
                try {
                    if (string2.length() == 0) {
                    }
                } catch (Throwable unused) {
                }
                return string2;
            }
            return m12807a(Constants.SP_FILE_NAME).getString("utdid", null);
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* renamed from: l */
    private String m12819l() {
        try {
            return m12807a("um_push_ut").getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: d */
    boolean m12822d() {
        try {
            return m12807a("um_push_ut").getBoolean("t_f", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: f */
    void m12823f() {
        try {
            m12807a("um_push_ut").edit().remove("t_id").remove("t_f").commit();
        } catch (Throwable unused) {
        }
    }

    synchronized String getValue() {
        if (this.f13896c != null) {
            return this.f13896c;
        }
        return m12817j();
    }

    /* renamed from: m */
    String m12824m() {
        String str;
        try {
            str = m12807a("um_push_ut").getString("t_id", null);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null && !"-1".equals(str) && str.length() >= 2 && str.length() <= 128) {
            return str;
        }
        return null;
    }

    /* renamed from: c */
    private boolean m12815c() {
        try {
            return m12807a("um_push_ut").getBoolean("v_r", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: a */
    private void m12810a(String str, boolean z) {
        if (m12813b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24) {
                m12812b(str, z);
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: b */
    public boolean m12821b() {
        try {
            SharedPreferences m12807a = m12807a("um_push_ut");
            if (this.f13897d == -1) {
                this.f13897d = m12807a.getLong("v_ts", 0L);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f13897d) >= m12814c()) {
                this.f13897d = currentTimeMillis;
                m12807a.edit().putLong("v_ts", currentTimeMillis).commit();
                C3810e.m12784a("UTUtdid", "req valid");
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: a */
    private byte[] m12811a() throws Exception {
        String str;
        C3810e.m12784a("UTUtdid", "generate UTDid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = C3812b.getBytes(currentTimeMillis);
        byte[] bytes2 = C3812b.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = C3813c.m12795f();
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(C3812b.getBytes(C3814d.m12798a(str)), 0, 4);
        byteArrayOutputStream.write(C3812b.getBytes(C3814d.m12798a(m12809a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: b */
    private void m12812b(String str, boolean z) {
        try {
            m12807a("um_push_ut").edit().putString("d_id", str).putBoolean("t_f", z).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static String m12809a(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(C3809d.m12779b(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return C3811a.m12790a(mac.doFinal(bArr), 2);
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    void m12820a(String str, long j2) {
        boolean z;
        try {
            SharedPreferences.Editor edit = m12807a("um_push_ut").edit();
            if (j2 > 0) {
                edit.putLong("v_i", j2);
                edit.putLong("v_ts", System.currentTimeMillis());
                z = true;
            } else {
                z = false;
            }
            if (str != null && !"-1".equals(str) && str.length() >= 2 && str.length() <= 128) {
                edit.putString("t_id", str);
                edit.putBoolean("v_r", false);
                z = true;
            }
            if (z) {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private SharedPreferences m12807a(String str) {
        return this.f13895a.getSharedPreferences(str, 0);
    }
}
