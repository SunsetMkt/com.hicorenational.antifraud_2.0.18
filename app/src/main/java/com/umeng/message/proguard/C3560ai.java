package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.InAppMessageManager;
import com.umeng.message.proguard.C3556ae;
import com.umeng.message.proguard.C3588h;
import java.io.File;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.ai */
/* loaded from: classes2.dex */
public class C3560ai {

    /* renamed from: b */
    private static boolean f13181b = false;

    /* renamed from: c */
    private static volatile C3560ai f13182c;

    /* renamed from: a */
    private final Context f13183a;

    private C3560ai(Context context) {
        this.f13183a = context.getApplicationContext();
    }

    /* renamed from: b */
    static /* synthetic */ boolean m12246b() {
        f13181b = false;
        return false;
    }

    /* renamed from: c */
    private void m12247c() {
        if (f13181b) {
            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "sendInAppCacheLog已经在队列里，忽略该请求");
            return;
        }
        f13181b = true;
        UMLog.mutlInfo("UmengInAppMessageTracker", 2, "sendInAppCacheLog开始");
        C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.ai.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Iterator<C3556ae> it = InAppMessageManager.getInstance(C3560ai.this.f13183a).m12165b().iterator();
                    while (it.hasNext()) {
                        C3556ae next = it.next();
                        JSONObject m12245b = C3560ai.m12245b(next.f13155b, next.f13156c, next.f13157d, next.f13158e, next.f13159f, next.f13160g, next.f13161h, next.f13162i, next.f13163j);
                        if (m12245b != null && TextUtils.equals(m12245b.getString("success"), ITagManager.SUCCESS)) {
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(C3560ai.this.f13183a);
                            inAppMessageManager.f13068b.getContentResolver().delete(C3588h.m12406e(inAppMessageManager.f13068b), "MsgId=?", new String[]{next.f13155b});
                        }
                    }
                } catch (Exception e2) {
                    UPLog.m12147w("UmengInAppMessageTracker", "sendInAppCacheLog error:" + e2.getMessage());
                } finally {
                    C3560ai.m12246b();
                }
            }
        });
    }

    /* renamed from: a */
    public static C3560ai m12243a(Context context) {
        if (f13182c == null) {
            synchronized (C3560ai.class) {
                if (f13182c == null) {
                    f13182c = new C3560ai(context);
                }
            }
        }
        return f13182c;
    }

    /* renamed from: b */
    static /* synthetic */ JSONObject m12245b(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", C3585e.m12377a());
        jSONObject.put("msg_id", str);
        jSONObject.put("msg_type", i2);
        jSONObject.put("num_display", i3);
        jSONObject.put("num_open_full", i4);
        jSONObject.put("num_open_top", i5);
        jSONObject.put("num_open_bottom", i6);
        jSONObject.put("num_close", i7);
        jSONObject.put("num_duration", i8);
        jSONObject.put("num_custom", i9);
        return C3587g.m12400a(jSONObject, "https://msg.umengcloud.com/admsg/v3/stats", UMUtils.getAppkey(C3604x.m12460a()), true);
    }

    /* renamed from: a */
    public final void m12248a(final InterfaceC3555ad interfaceC3555ad) {
        if (C3586f.m12389b()) {
            UPLog.m12142d("UmengInAppMessageTracker", "getSplashMsg failed, silent mode!");
        } else {
            m12247c();
            C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.ai.1
                @Override // java.lang.Runnable
                public final void run() {
                    UInAppMessage uInAppMessage;
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message begin");
                    try {
                        JSONObject m12400a = C3587g.m12400a(C3560ai.m12244a(), "https://msg.umengcloud.com/admsg/v3/launch", UMUtils.getAppkey(C3604x.m12460a()), true);
                        if (TextUtils.equals(m12400a.getString("success"), ITagManager.SUCCESS)) {
                            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message success".concat(String.valueOf(m12400a)));
                            JSONObject jSONObject = m12400a.getJSONObject("data");
                            InAppMessageManager.f13065d = jSONObject.getInt("pduration") * 1000;
                            InAppMessageManager.f13066e = jSONObject.getInt("sduration") * 1000;
                            interfaceC3555ad.mo12212a(new UInAppMessage(jSONObject.getJSONObject("launch")));
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(C3560ai.this.f13183a);
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            inAppMessageManager.m12167b("KEY_SPLASH_TS", sb.toString());
                            return;
                        }
                        if (!TextUtils.equals(m12400a.getString("success"), "fail") || !TextUtils.equals(m12400a.getString("error"), "no message")) {
                            interfaceC3555ad.mo12212a(null);
                            return;
                        }
                        String m12158a = InAppMessageManager.getInstance(C3560ai.this.f13183a).m12158a();
                        if (TextUtils.isEmpty(m12158a)) {
                            return;
                        }
                        try {
                            uInAppMessage = new UInAppMessage(new JSONObject(m12158a));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            uInAppMessage = null;
                        }
                        if (uInAppMessage != null) {
                            InAppMessageManager.getInstance(C3560ai.this.f13183a).m12163a(new File(C3586f.m12382a(C3560ai.this.f13183a, uInAppMessage.msg_id)));
                            InAppMessageManager.getInstance(C3560ai.this.f13183a).m12161a((UInAppMessage) null);
                        }
                    } catch (Exception e3) {
                        UPLog.m12147w("UmengInAppMessageTracker", "getSplashMsg error: ", e3.getMessage());
                        interfaceC3555ad.mo12212a(null);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public final void m12250a(final String str, final InterfaceC3555ad interfaceC3555ad) {
        if (C3586f.m12389b()) {
            UPLog.m12142d("UmengInAppMessageTracker", "getCardMsg failed, silent mode!");
        } else {
            m12247c();
            C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.ai.2
                @Override // java.lang.Runnable
                public final void run() {
                    UInAppMessage uInAppMessage;
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message begin");
                    try {
                        JSONObject m12244a = C3560ai.m12244a();
                        m12244a.put("label", str);
                        JSONObject m12400a = C3587g.m12400a(m12244a, "https://msg.umengcloud.com/admsg/v3/getmsg", UMUtils.getAppkey(C3604x.m12460a()), true);
                        if (TextUtils.equals(m12400a.getString("success"), ITagManager.SUCCESS)) {
                            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message success".concat(String.valueOf(m12400a)));
                            JSONObject jSONObject = m12400a.getJSONObject("data");
                            InAppMessageManager.f13065d = jSONObject.getInt("pduration") * 1000;
                            InAppMessageManager.f13066e = jSONObject.getInt("sduration") * 1000;
                            interfaceC3555ad.mo12213b(new UInAppMessage(jSONObject.getJSONObject("card")));
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(C3560ai.this.f13183a);
                            String concat = "KEY_CARD_TS_".concat(String.valueOf(m12244a.optString("label", "")));
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            inAppMessageManager.m12167b(concat, sb.toString());
                            return;
                        }
                        if (!TextUtils.equals(m12400a.getString("success"), "fail") || !TextUtils.equals(m12400a.getString("error"), "no message")) {
                            interfaceC3555ad.mo12213b(null);
                            return;
                        }
                        String m12159a = InAppMessageManager.getInstance(C3560ai.this.f13183a).m12159a(str);
                        if (TextUtils.isEmpty(m12159a)) {
                            return;
                        }
                        try {
                            uInAppMessage = new UInAppMessage(new JSONObject(m12159a));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            uInAppMessage = null;
                        }
                        if (uInAppMessage != null) {
                            InAppMessageManager.getInstance(C3560ai.this.f13183a).m12163a(new File(C3586f.m12382a(C3560ai.this.f13183a, uInAppMessage.msg_id)));
                            InAppMessageManager.getInstance(C3560ai.this.f13183a).m12162a((UInAppMessage) null, str);
                        }
                    } catch (Exception e3) {
                        UPLog.m12147w("UmengInAppMessageTracker", "getCardMsg error: ", e3.getMessage());
                        interfaceC3555ad.mo12213b(null);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public final void m12249a(final String str, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7, final int i8, final int i9) {
        C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.ai.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "track in app msg begin");
                    JSONObject m12245b = C3560ai.m12245b(str, i2, i3, i4, i5, i6, i7, i8, i9);
                    if (m12245b == null || !TextUtils.equals(m12245b.getString("success"), ITagManager.SUCCESS)) {
                        return;
                    }
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "track in app msg success");
                } catch (Exception e2) {
                    UPLog.m12147w("UmengInAppMessageTracker", "trackInAppMessage error:" + e2.getMessage());
                    final InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(C3560ai.this.f13183a);
                    final String str2 = str;
                    final int i10 = i2;
                    final int i11 = i3;
                    final int i12 = i4;
                    final int i13 = i5;
                    final int i14 = i6;
                    final int i15 = i7;
                    final int i16 = i8;
                    final int i17 = i9;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    C3578b.m12327c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                C3556ae m12154a = InAppMessageManager.m12154a(InAppMessageManager.this, str2);
                                if (m12154a != null) {
                                    InAppMessageManager.this.f13068b.getContentResolver().update(C3588h.m12406e(InAppMessageManager.this.f13068b), new C3556ae(str2, i10, m12154a.f13157d + i11, m12154a.f13158e + i12, m12154a.f13159f + i13, m12154a.f13160g + i14, m12154a.f13161h + i15, m12154a.f13162i + i16, m12154a.f13163j).m12230a(), "MsgId=?", new String[]{str2});
                                } else {
                                    InAppMessageManager.this.f13068b.getContentResolver().insert(C3588h.m12406e(InAppMessageManager.this.f13068b), new C3556ae(str2, i10, i11, i12, i13, i14, i15, i16, i17).m12230a());
                                }
                                UMLog.mutlInfo("InAppMessageManager", 2, "store in app cache log success");
                            } catch (Exception e3) {
                                UMLog.mutlInfo("InAppMessageManager", 0, "store in app cache log fail");
                                e3.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ JSONObject m12244a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", C3585e.m12377a());
        jSONObject.put("pmode", InAppMessageManager.f13064a ? "0" : "1");
        return jSONObject;
    }
}
