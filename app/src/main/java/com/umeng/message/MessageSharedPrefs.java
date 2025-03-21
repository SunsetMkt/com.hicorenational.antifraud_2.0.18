package com.umeng.message;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.C3568aq;
import com.umeng.message.proguard.C3586f;
import com.umeng.message.proguard.C3588h;
import com.umeng.message.proguard.C3604x;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.p215a.C3615a;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public class MessageSharedPrefs {

    /* renamed from: d */
    private static volatile MessageSharedPrefs f13041d;

    /* renamed from: a */
    public final Context f13042a;

    /* renamed from: b */
    public final C3568aq f13043b = new C3568aq("push");

    /* renamed from: c */
    public Boolean f13044c = null;

    private MessageSharedPrefs(Context context) {
        this.f13042a = context.getApplicationContext();
    }

    public static MessageSharedPrefs getInstance(Context context) {
        if (f13041d == null) {
            synchronized (MessageSharedPrefs.class) {
                if (f13041d == null) {
                    f13041d = new MessageSharedPrefs(context);
                }
            }
        }
        return f13041d;
    }

    private void setMessageAppKey(String str) {
        if (C3586f.m12390b(this.f13042a)) {
            if (TextUtils.isEmpty(str)) {
                UPLog.m12144e("Prefs", "appkey is empty!");
            } else {
                this.f13043b.m12285a("appkey", str);
            }
        }
    }

    private void setMessageAppSecret(String str) {
        if (C3586f.m12390b(this.f13042a)) {
            if (TextUtils.isEmpty(str)) {
                UPLog.m12144e("Prefs", "message secret is empty!");
            } else {
                this.f13043b.m12285a("message_secret", str);
            }
        }
    }

    private void setMessageChannel(String str) {
        if (C3586f.m12390b(this.f13042a)) {
            this.f13043b.m12285a("channel", str);
        }
    }

    /* renamed from: a */
    public final boolean m12117a() {
        Throwable th;
        long j2;
        try {
            j2 = this.f13043b.m12289b(C3397d.f11950p, 0L);
            if (j2 > 0) {
                try {
                    UPLog.m12142d("Prefs", "today first start:", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2)));
                } catch (Throwable th2) {
                    th = th2;
                    UPLog.m12143e("Prefs", th);
                    return C3586f.m12387a(j2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            j2 = 0;
        }
        return C3586f.m12387a(j2);
    }

    /* renamed from: b */
    public final int m12120b() {
        return this.f13043b.m12288b("notification_number", 1);
    }

    /* renamed from: c */
    public final String m12122c() {
        return this.f13043b.m12290b("appkey", "");
    }

    /* renamed from: d */
    public final int m12124d() {
        return this.f13043b.m12288b("tag_remain", 64);
    }

    /* renamed from: e */
    public final String m12125e() {
        String m12290b = this.f13043b.m12290b("service_class", "");
        if (!TextUtils.isEmpty(m12290b)) {
            try {
                Class.forName(m12290b);
                return m12290b;
            } catch (Throwable unused) {
                UPLog.m12144e("Prefs", "custom service not exist:", m12290b, "if has removed. pls invoke PushAgent.setPushIntentServiceClass(null)");
            }
        }
        return "";
    }

    /* renamed from: f */
    public final String m12126f() {
        return this.f13043b.m12290b("last_click_msg_id", "");
    }

    /* renamed from: g */
    public final int m12127g() {
        return this.f13043b.m12288b("mute_duration", 60);
    }

    /* renamed from: h */
    public final int m12128h() {
        return this.f13043b.m12288b("notification_vibrate", 0);
    }

    /* renamed from: i */
    public final int m12129i() {
        return this.f13043b.m12288b("notification_light", 0);
    }

    /* renamed from: j */
    public final int m12130j() {
        return this.f13043b.m12288b("notification_sound", 0);
    }

    /* renamed from: k */
    public final String m12131k() {
        return this.f13043b.m12290b(RemoteMessageConst.DEVICE_TOKEN, "");
    }

    /* renamed from: l */
    public final boolean m12132l() {
        return this.f13043b.m12292b("l_u_e", false);
    }

    /* renamed from: m */
    public final long m12133m() {
        return this.f13043b.m12289b(C3615a.f13471d, 0L);
    }

    /* renamed from: n */
    public final int m12134n() {
        return this.f13043b.m12288b("re_pop_cfg", 0);
    }

    /* renamed from: o */
    public final int m12135o() {
        Calendar calendar = Calendar.getInstance();
        String format = String.format(Locale.getDefault(), "%d.%d.", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)));
        String m12290b = this.f13043b.m12290b("re_pop_times", "");
        if (m12290b.startsWith(format)) {
            try {
                return Integer.parseInt(m12290b.replace(format, ""));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* renamed from: b */
    public final void m12121b(String str) {
        this.f13043b.m12282a(str + C3351bh.f11599aX);
        this.f13043b.m12282a(str + "ts");
    }

    /* renamed from: c */
    public final void m12123c(String str) {
        this.f13043b.m12285a("last_click_msg_id", str);
    }

    /* renamed from: a */
    public final void m12115a(String str, String str2, int i2, long j2) {
        Cursor cursor = null;
        try {
            Application m12460a = C3604x.m12460a();
            try {
                this.f13042a.getContentResolver().delete(C3588h.m12402a(this.f13042a), "type=?", new String[]{str2});
            } catch (Exception e2) {
                UPLog.m12143e("Prefs", e2);
            }
            String[] strArr = {str, str2, String.valueOf(i2)};
            cursor = m12460a.getContentResolver().query(C3588h.m12402a(m12460a), null, "alias=? and type=? and exclusive=?", strArr, "time desc");
            ContentValues contentValues = new ContentValues();
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put(RemoteMessageConst.TTL, Long.valueOf(j2));
            contentValues.put("type", str2);
            contentValues.put("alias", str);
            contentValues.put("exclusive", Integer.valueOf(i2));
            if (cursor != null && cursor.getCount() > 0) {
                this.f13042a.getContentResolver().update(C3588h.m12402a(m12460a), contentValues, "alias=? and type=? and exclusive=?", strArr);
            } else {
                this.f13042a.getContentResolver().insert(C3588h.m12402a(m12460a), contentValues);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                UPLog.m12143e("Prefs", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m12112a(int r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "alias"
            java.lang.String r1 = "Prefs"
            r2 = 0
            java.lang.String r6 = "type=? and exclusive=?"
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r3 = 0
            r7[r3] = r11     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r11 = 1
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r7[r11] = r10     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r8 = "time desc"
            android.content.Context r10 = r9.f13042a     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.content.Context r10 = r9.f13042a     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.net.Uri r4 = com.umeng.message.proguard.C3588h.m12402a(r10)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r10 == 0) goto L4b
            int r11 = r10.getCount()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L68
            if (r11 > 0) goto L33
            goto L4b
        L33:
            r10.moveToFirst()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L68
            int r11 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L68
            java.lang.String r11 = r10.getString(r11)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L68
            if (r10 == 0) goto L48
            r10.close()     // Catch: java.lang.Throwable -> L44
            goto L48
        L44:
            r10 = move-exception
            com.umeng.message.common.UPLog.m12143e(r1, r10)
        L48:
            return r11
        L49:
            r11 = move-exception
            goto L5a
        L4b:
            if (r10 == 0) goto L55
            r10.close()     // Catch: java.lang.Throwable -> L51
            goto L55
        L51:
            r10 = move-exception
            com.umeng.message.common.UPLog.m12143e(r1, r10)
        L55:
            return r2
        L56:
            r11 = move-exception
            goto L6a
        L58:
            r11 = move-exception
            r10 = r2
        L5a:
            com.umeng.message.common.UPLog.m12143e(r1, r11)     // Catch: java.lang.Throwable -> L68
            if (r10 == 0) goto L67
            r10.close()     // Catch: java.lang.Throwable -> L63
            goto L67
        L63:
            r10 = move-exception
            com.umeng.message.common.UPLog.m12143e(r1, r10)
        L67:
            return r2
        L68:
            r11 = move-exception
            r2 = r10
        L6a:
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.lang.Throwable -> L70
            goto L74
        L70:
            r10 = move-exception
            com.umeng.message.common.UPLog.m12143e(r1, r10)
        L74:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.m12112a(int, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m12118a(int r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.m12118a(int, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public final void m12116a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        Set<String> m12291b = this.f13043b.m12291b(SocializeProtocolConstants.TAGS, new HashSet());
        m12291b.addAll(Arrays.asList(strArr));
        this.f13043b.m12286a(SocializeProtocolConstants.TAGS, m12291b);
    }

    /* renamed from: a */
    public final void m12114a(String str, long j2) {
        this.f13043b.m12284a(str + C3351bh.f11599aX, j2);
        this.f13043b.m12284a(str + "ts", System.currentTimeMillis());
    }

    /* renamed from: a */
    public final boolean m12119a(String str) {
        long m12289b = this.f13043b.m12289b(str + C3351bh.f11599aX, 0L);
        if (m12289b <= 0) {
            return true;
        }
        C3568aq c3568aq = this.f13043b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("ts");
        return Math.abs(System.currentTimeMillis() - c3568aq.m12289b(sb.toString(), 0L)) / 1000 >= m12289b;
    }

    /* renamed from: a */
    public final void m12113a(int i2) {
        this.f13043b.m12283a("tag_remain", i2);
    }
}
