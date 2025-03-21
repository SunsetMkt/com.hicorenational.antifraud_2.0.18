package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.C3556ae;
import com.umeng.message.proguard.C3558ag;
import com.umeng.message.proguard.C3560ai;
import com.umeng.message.proguard.C3568aq;
import com.umeng.message.proguard.C3578b;
import com.umeng.message.proguard.C3586f;
import com.umeng.message.proguard.C3588h;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class InAppMessageManager {

    /* renamed from: a */
    public static boolean f13064a = false;

    /* renamed from: d */
    public static int f13065d = 1800000;

    /* renamed from: e */
    public static int f13066e = 1000;

    /* renamed from: f */
    private static InAppMessageManager f13067f;

    /* renamed from: b */
    public final Context f13068b;

    /* renamed from: c */
    String f13069c;

    /* renamed from: h */
    private final C3568aq f13071h = new C3568aq("in_app");

    /* renamed from: g */
    private UInAppHandler f13070g = new UmengInAppClickHandler();

    private InAppMessageManager(Context context) {
        this.f13068b = context.getApplicationContext();
    }

    /* renamed from: d */
    private int m12157d(String str) {
        return Integer.parseInt(m12160a(str, "0"));
    }

    public static InAppMessageManager getInstance(Context context) {
        if (f13067f == null) {
            synchronized (InAppMessageManager.class) {
                if (f13067f == null) {
                    f13067f = new InAppMessageManager(context);
                }
            }
        }
        return f13067f;
    }

    /* renamed from: c */
    public final long m12168c(String str) {
        return Long.parseLong(m12160a("KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str)), "0"));
    }

    public UInAppHandler getInAppHandler() {
        return this.f13070g;
    }

    public void setInAppHandler(UInAppHandler uInAppHandler) {
        this.f13070g = uInAppHandler;
    }

    public void setInAppMsgDebugMode(boolean z) {
        f13064a = z;
    }

    public void setMainActivityPath(String str) {
        this.f13069c = str;
    }

    public void setPlainTextSize(int i2, int i3, int i4) {
        if (i2 <= 0 || i3 <= 0 || i4 <= 0) {
            UMLog.mutlInfo("InAppMessageManager", 0, "纯文本字体大小不能小于0");
            return;
        }
        m12167b("KEY_PLAIN_TEXT_SIZE", i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i3 + Constants.ACCEPT_TIME_SEPARATOR_SP + i4);
    }

    public void showCardMessage(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        if (C3586f.m12389b()) {
            UPLog.m12142d("InAppMessageManager", "showCardMessage failed, silent mode!");
            return;
        }
        C3558ag c3558ag = new C3558ag(activity, str, iUmengInAppMsgCloseCallback);
        if (TextUtils.isEmpty(c3558ag.f13170c.trim())) {
            UMLog.mutlInfo(C3558ag.f13168a, 0, "插屏消息的标签不能为空");
            return;
        }
        if (!c3558ag.m12237a(c3558ag.f13170c)) {
            UMLog.mutlInfo(C3558ag.f13168a, 0, "插屏消息的最大标签数为 10");
            return;
        }
        if (f13064a) {
            C3560ai.m12243a(c3558ag.f13169b).m12250a(c3558ag.f13170c, c3558ag);
        } else if (System.currentTimeMillis() - Long.parseLong(getInstance(c3558ag.f13169b).m12160a("KEY_CARD_TS_".concat(String.valueOf(c3558ag.f13170c)), "0")) > f13065d) {
            C3560ai.m12243a(c3558ag.f13169b).m12250a(c3558ag.f13170c, c3558ag);
        } else {
            c3558ag.mo12213b((UInAppMessage) null);
        }
    }

    /* renamed from: a */
    public final void m12161a(UInAppMessage uInAppMessage) {
        if (uInAppMessage == null) {
            m12167b("KEY_LAST_SPLASH_ID", "");
        } else if (uInAppMessage.getRaw() != null) {
            m12167b("KEY_LAST_SPLASH_ID", uInAppMessage.getRaw().toString());
        }
    }

    /* renamed from: b */
    public final void m12166b(String str) {
        String concat = "KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str));
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        m12167b(concat, sb.toString());
    }

    /* renamed from: c */
    public final boolean m12169c(UInAppMessage uInAppMessage) {
        return uInAppMessage.show_times == 0 || m12157d(uInAppMessage.msg_id) < uInAppMessage.show_times;
    }

    /* renamed from: b */
    public static boolean m12156b(UInAppMessage uInAppMessage) {
        try {
            return System.currentTimeMillis() < new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(uInAppMessage.expire_time).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final String m12158a() {
        return m12160a("KEY_LAST_SPLASH_ID", "");
    }

    /* renamed from: a */
    public final void m12162a(UInAppMessage uInAppMessage, String str) {
        if (uInAppMessage == null) {
            m12167b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
        } else if (uInAppMessage.getRaw() != null) {
            m12167b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), uInAppMessage.getRaw().toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r1 == null) goto L17;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.ArrayList<com.umeng.message.proguard.C3556ae> m12165b() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r9.f13068b     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            android.content.Context r2 = r9.f13068b     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            android.net.Uri r4 = com.umeng.message.proguard.C3588h.m12406e(r2)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r2 = 0
            if (r1 == 0) goto L21
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
        L21:
            if (r2 == 0) goto L30
            com.umeng.message.proguard.ae r2 = new com.umeng.message.proguard.ae     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r0.add(r2)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            goto L21
        L30:
            if (r1 == 0) goto L3e
            goto L3b
        L33:
            r0 = move-exception
            goto L3f
        L35:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L3e
        L3b:
            r1.close()
        L3e:
            return r0
        L3f:
            if (r1 == 0) goto L44
            r1.close()
        L44:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.inapp.InAppMessageManager.m12165b():java.util.ArrayList");
    }

    /* renamed from: a */
    public final String m12159a(String str) {
        return m12160a("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
    }

    /* renamed from: a */
    public final void m12164a(String str, int i2) {
        if (i2 == 0) {
            m12167b(str, "0");
        }
        if (i2 == 1) {
            m12167b(str, String.valueOf(m12157d(str) + 1));
        }
    }

    /* renamed from: a */
    public final String m12160a(String str, String str2) {
        return this.f13071h.m12290b(str, str2);
    }

    /* renamed from: a */
    public final void m12163a(final File file) {
        C3578b.m12327c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.3
            @Override // java.lang.Runnable
            public final void run() {
                File file2 = file;
                if (file2 != null && file2.exists() && file.canWrite() && file.isDirectory()) {
                    for (File file3 : file.listFiles()) {
                        if (!file3.isDirectory()) {
                            file3.delete();
                        }
                    }
                    file.delete();
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ C3556ae m12154a(InAppMessageManager inAppMessageManager, String str) {
        Cursor query = inAppMessageManager.f13068b.getContentResolver().query(C3588h.m12406e(inAppMessageManager.f13068b), null, "MsgId=?", new String[]{str}, null);
        C3556ae c3556ae = query != null ? query.moveToFirst() : false ? new C3556ae(query) : null;
        if (query != null) {
            query.close();
        }
        return c3556ae;
    }

    /* renamed from: b */
    public final void m12167b(final String str, final String str2) {
        C3578b.m12327c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    InAppMessageManager.this.f13071h.m12285a(str, str2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
