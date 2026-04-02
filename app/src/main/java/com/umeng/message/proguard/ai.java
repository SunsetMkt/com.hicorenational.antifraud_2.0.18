package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.InAppMessageManager;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ai {

    /* JADX INFO: renamed from: b */
    private static boolean f7969b = false;

    /* JADX INFO: renamed from: c */
    private static volatile ai f7970c;
    private final Context a;

    /* JADX INFO: renamed from: com.umeng.message.proguard.ai$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ad a;

        AnonymousClass1(ad adVar) {
            adVar = adVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UInAppMessage uInAppMessage;
            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message begin");
            try {
                JSONObject jSONObjectA = g.a(ai.a(), "https://msg.umengcloud.com/admsg/v3/launch", UMUtils.getAppkey(x.a()), true);
                if (TextUtils.equals(jSONObjectA.getString("success"), ITagManager.SUCCESS)) {
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message success".concat(String.valueOf(jSONObjectA)));
                    JSONObject jSONObject = jSONObjectA.getJSONObject("data");
                    InAppMessageManager.f7890d = jSONObject.getInt("pduration") * 1000;
                    InAppMessageManager.f7891e = jSONObject.getInt("sduration") * 1000;
                    adVar.a(new UInAppMessage(jSONObject.getJSONObject("launch")));
                    InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(ai.this.a);
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    inAppMessageManager.b("KEY_SPLASH_TS", sb.toString());
                    return;
                }
                if (!TextUtils.equals(jSONObjectA.getString("success"), "fail") || !TextUtils.equals(jSONObjectA.getString("error"), "no message")) {
                    adVar.a(null);
                    return;
                }
                String strA = InAppMessageManager.getInstance(ai.this.a).a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                try {
                    uInAppMessage = new UInAppMessage(new JSONObject(strA));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    uInAppMessage = null;
                }
                if (uInAppMessage != null) {
                    InAppMessageManager.getInstance(ai.this.a).a(new File(f.a(ai.this.a, uInAppMessage.msg_id)));
                    InAppMessageManager.getInstance(ai.this.a).a((UInAppMessage) null);
                }
            } catch (Exception e3) {
                UPLog.w("UmengInAppMessageTracker", "getSplashMsg error: ", e3.getMessage());
                adVar.a(null);
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.ai$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ ad f7972b;

        AnonymousClass2(String str, ad adVar) {
            str = str;
            adVar = adVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UInAppMessage uInAppMessage;
            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message begin");
            try {
                JSONObject jSONObjectA = ai.a();
                jSONObjectA.put("label", str);
                JSONObject jSONObjectA2 = g.a(jSONObjectA, "https://msg.umengcloud.com/admsg/v3/getmsg", UMUtils.getAppkey(x.a()), true);
                if (TextUtils.equals(jSONObjectA2.getString("success"), ITagManager.SUCCESS)) {
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message success".concat(String.valueOf(jSONObjectA2)));
                    JSONObject jSONObject = jSONObjectA2.getJSONObject("data");
                    InAppMessageManager.f7890d = jSONObject.getInt("pduration") * 1000;
                    InAppMessageManager.f7891e = jSONObject.getInt("sduration") * 1000;
                    adVar.b(new UInAppMessage(jSONObject.getJSONObject("card")));
                    InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(ai.this.a);
                    String strConcat = "KEY_CARD_TS_".concat(String.valueOf(jSONObjectA.optString("label", "")));
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    inAppMessageManager.b(strConcat, sb.toString());
                    return;
                }
                if (!TextUtils.equals(jSONObjectA2.getString("success"), "fail") || !TextUtils.equals(jSONObjectA2.getString("error"), "no message")) {
                    adVar.b(null);
                    return;
                }
                String strA = InAppMessageManager.getInstance(ai.this.a).a(str);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                try {
                    uInAppMessage = new UInAppMessage(new JSONObject(strA));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    uInAppMessage = null;
                }
                if (uInAppMessage != null) {
                    InAppMessageManager.getInstance(ai.this.a).a(new File(f.a(ai.this.a, uInAppMessage.msg_id)));
                    InAppMessageManager.getInstance(ai.this.a).a((UInAppMessage) null, str);
                }
            } catch (Exception e3) {
                UPLog.w("UmengInAppMessageTracker", "getCardMsg error: ", e3.getMessage());
                adVar.b(null);
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.ai$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f7974b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ int f7975c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ int f7976d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ int f7977e;

        /* JADX INFO: renamed from: f */
        final /* synthetic */ int f7978f;

        /* JADX INFO: renamed from: g */
        final /* synthetic */ int f7979g;

        /* JADX INFO: renamed from: h */
        final /* synthetic */ int f7980h;

        /* JADX INFO: renamed from: i */
        final /* synthetic */ int f7981i;

        AnonymousClass3(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            str = str;
            i = i2;
            i = i3;
            i = i4;
            i = i5;
            i = i6;
            i = i7;
            i = i8;
            i = i9;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.umeng.message.inapp.InAppMessageManager.1.<init>(com.umeng.message.inapp.InAppMessageManager, java.lang.String, int, int, int, int, int, int, int, int):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:298)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
            	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:197)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
            */
        @Override // java.lang.Runnable
        public final void run() {
            /*
                r12 = this;
                java.lang.String r0 = "UmengInAppMessageTracker"
                java.lang.String r1 = "track in app msg begin"
                java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> L3c
                r2 = 2
                com.umeng.commonsdk.debug.UMLog.mutlInfo(r0, r2, r1)     // Catch: java.lang.Exception -> L3c
                java.lang.String r3 = r2     // Catch: java.lang.Exception -> L3c
                int r4 = r3     // Catch: java.lang.Exception -> L3c
                int r5 = r4     // Catch: java.lang.Exception -> L3c
                int r6 = r5     // Catch: java.lang.Exception -> L3c
                int r7 = r6     // Catch: java.lang.Exception -> L3c
                int r8 = r7     // Catch: java.lang.Exception -> L3c
                int r9 = r8     // Catch: java.lang.Exception -> L3c
                int r10 = r9     // Catch: java.lang.Exception -> L3c
                int r11 = r10     // Catch: java.lang.Exception -> L3c
                org.json.JSONObject r1 = com.umeng.message.proguard.ai.b(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L3c
                if (r1 == 0) goto L3b
                java.lang.String r3 = "success"
                java.lang.String r1 = r1.getString(r3)     // Catch: java.lang.Exception -> L3c
                java.lang.String r3 = "ok"
                boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch: java.lang.Exception -> L3c
                if (r1 == 0) goto L3b
                java.lang.String r1 = "track in app msg success"
                java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> L3c
                com.umeng.commonsdk.debug.UMLog.mutlInfo(r0, r2, r1)     // Catch: java.lang.Exception -> L3c
            L3b:
                return
            L3c:
                r1 = move-exception
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "trackInAppMessage error:"
                r4.<init>(r5)
                java.lang.String r1 = r1.getMessage()
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                r2[r3] = r1
                com.umeng.message.common.UPLog.w(r0, r2)
                com.umeng.message.proguard.ai r0 = com.umeng.message.proguard.ai.this
                android.content.Context r0 = com.umeng.message.proguard.ai.a(r0)
                com.umeng.message.inapp.InAppMessageManager r2 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
                java.lang.String r3 = r2
                int r4 = r3
                int r5 = r4
                int r6 = r5
                int r7 = r6
                int r8 = r7
                int r9 = r8
                int r10 = r9
                int r11 = r10
                boolean r0 = android.text.TextUtils.isEmpty(r3)
                if (r0 != 0) goto L83
                com.umeng.message.inapp.InAppMessageManager$1 r0 = new com.umeng.message.inapp.InAppMessageManager$1
                r1 = r0
                r1.<init>()
                com.umeng.message.proguard.b.c(r0)
            L83:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ai.AnonymousClass3.run():void");
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.ai$4 */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                for (ae aeVar : InAppMessageManager.getInstance(ai.this.a).b()) {
                    JSONObject jSONObjectB = ai.b(aeVar.f7947b, aeVar.f7948c, aeVar.f7949d, aeVar.f7950e, aeVar.f7951f, aeVar.f7952g, aeVar.f7953h, aeVar.f7954i, aeVar.f7955j);
                    if (jSONObjectB != null && TextUtils.equals(jSONObjectB.getString("success"), ITagManager.SUCCESS)) {
                        InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(ai.this.a);
                        inAppMessageManager.f7893b.getContentResolver().delete(h.e(inAppMessageManager.f7893b), "MsgId=?", new String[]{aeVar.f7947b});
                    }
                }
            } catch (Exception e2) {
                UPLog.w("UmengInAppMessageTracker", "sendInAppCacheLog error:" + e2.getMessage());
            } finally {
                ai.b();
            }
        }
    }

    private ai(Context context) {
        this.a = context.getApplicationContext();
    }

    static /* synthetic */ boolean b() {
        f7969b = false;
        return false;
    }

    private void c() {
        if (f7969b) {
            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "sendInAppCacheLog\u5df2\u7ecf\u5728\u961f\u5217\u91cc\uff0c\u5ffd\u7565\u8be5\u8bf7\u6c42");
            return;
        }
        f7969b = true;
        UMLog.mutlInfo("UmengInAppMessageTracker", 2, "sendInAppCacheLog\u5f00\u59cb");
        b.c(new Runnable() { // from class: com.umeng.message.proguard.ai.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (ae aeVar : InAppMessageManager.getInstance(ai.this.a).b()) {
                        JSONObject jSONObjectB = ai.b(aeVar.f7947b, aeVar.f7948c, aeVar.f7949d, aeVar.f7950e, aeVar.f7951f, aeVar.f7952g, aeVar.f7953h, aeVar.f7954i, aeVar.f7955j);
                        if (jSONObjectB != null && TextUtils.equals(jSONObjectB.getString("success"), ITagManager.SUCCESS)) {
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(ai.this.a);
                            inAppMessageManager.f7893b.getContentResolver().delete(h.e(inAppMessageManager.f7893b), "MsgId=?", new String[]{aeVar.f7947b});
                        }
                    }
                } catch (Exception e2) {
                    UPLog.w("UmengInAppMessageTracker", "sendInAppCacheLog error:" + e2.getMessage());
                } finally {
                    ai.b();
                }
            }
        });
    }

    public static ai a(Context context) {
        if (f7970c == null) {
            synchronized (ai.class) {
                if (f7970c == null) {
                    f7970c = new ai(context);
                }
            }
        }
        return f7970c;
    }

    static /* synthetic */ JSONObject b(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("msg_id", str);
        jSONObject.put("msg_type", i2);
        jSONObject.put("num_display", i3);
        jSONObject.put("num_open_full", i4);
        jSONObject.put("num_open_top", i5);
        jSONObject.put("num_open_bottom", i6);
        jSONObject.put("num_close", i7);
        jSONObject.put("num_duration", i8);
        jSONObject.put("num_custom", i9);
        return g.a(jSONObject, "https://msg.umengcloud.com/admsg/v3/stats", UMUtils.getAppkey(x.a()), true);
    }

    public final void a(ad adVar) {
        if (f.b()) {
            UPLog.d("UmengInAppMessageTracker", "getSplashMsg failed, silent mode!");
        } else {
            c();
            b.c(new Runnable() { // from class: com.umeng.message.proguard.ai.1
                final /* synthetic */ ad a;

                AnonymousClass1(ad adVar2) {
                    adVar = adVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    UInAppMessage uInAppMessage;
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message begin");
                    try {
                        JSONObject jSONObjectA = g.a(ai.a(), "https://msg.umengcloud.com/admsg/v3/launch", UMUtils.getAppkey(x.a()), true);
                        if (TextUtils.equals(jSONObjectA.getString("success"), ITagManager.SUCCESS)) {
                            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message success".concat(String.valueOf(jSONObjectA)));
                            JSONObject jSONObject = jSONObjectA.getJSONObject("data");
                            InAppMessageManager.f7890d = jSONObject.getInt("pduration") * 1000;
                            InAppMessageManager.f7891e = jSONObject.getInt("sduration") * 1000;
                            adVar.a(new UInAppMessage(jSONObject.getJSONObject("launch")));
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(ai.this.a);
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            inAppMessageManager.b("KEY_SPLASH_TS", sb.toString());
                            return;
                        }
                        if (!TextUtils.equals(jSONObjectA.getString("success"), "fail") || !TextUtils.equals(jSONObjectA.getString("error"), "no message")) {
                            adVar.a(null);
                            return;
                        }
                        String strA = InAppMessageManager.getInstance(ai.this.a).a();
                        if (TextUtils.isEmpty(strA)) {
                            return;
                        }
                        try {
                            uInAppMessage = new UInAppMessage(new JSONObject(strA));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            uInAppMessage = null;
                        }
                        if (uInAppMessage != null) {
                            InAppMessageManager.getInstance(ai.this.a).a(new File(f.a(ai.this.a, uInAppMessage.msg_id)));
                            InAppMessageManager.getInstance(ai.this.a).a((UInAppMessage) null);
                        }
                    } catch (Exception e3) {
                        UPLog.w("UmengInAppMessageTracker", "getSplashMsg error: ", e3.getMessage());
                        adVar.a(null);
                    }
                }
            });
        }
    }

    public final void a(String str, ad adVar) {
        if (f.b()) {
            UPLog.d("UmengInAppMessageTracker", "getCardMsg failed, silent mode!");
        } else {
            c();
            b.c(new Runnable() { // from class: com.umeng.message.proguard.ai.2
                final /* synthetic */ String a;

                /* JADX INFO: renamed from: b */
                final /* synthetic */ ad f7972b;

                AnonymousClass2(String str2, ad adVar2) {
                    str = str2;
                    adVar = adVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    UInAppMessage uInAppMessage;
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message begin");
                    try {
                        JSONObject jSONObjectA = ai.a();
                        jSONObjectA.put("label", str);
                        JSONObject jSONObjectA2 = g.a(jSONObjectA, "https://msg.umengcloud.com/admsg/v3/getmsg", UMUtils.getAppkey(x.a()), true);
                        if (TextUtils.equals(jSONObjectA2.getString("success"), ITagManager.SUCCESS)) {
                            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message success".concat(String.valueOf(jSONObjectA2)));
                            JSONObject jSONObject = jSONObjectA2.getJSONObject("data");
                            InAppMessageManager.f7890d = jSONObject.getInt("pduration") * 1000;
                            InAppMessageManager.f7891e = jSONObject.getInt("sduration") * 1000;
                            adVar.b(new UInAppMessage(jSONObject.getJSONObject("card")));
                            InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(ai.this.a);
                            String strConcat = "KEY_CARD_TS_".concat(String.valueOf(jSONObjectA.optString("label", "")));
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            inAppMessageManager.b(strConcat, sb.toString());
                            return;
                        }
                        if (!TextUtils.equals(jSONObjectA2.getString("success"), "fail") || !TextUtils.equals(jSONObjectA2.getString("error"), "no message")) {
                            adVar.b(null);
                            return;
                        }
                        String strA = InAppMessageManager.getInstance(ai.this.a).a(str);
                        if (TextUtils.isEmpty(strA)) {
                            return;
                        }
                        try {
                            uInAppMessage = new UInAppMessage(new JSONObject(strA));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            uInAppMessage = null;
                        }
                        if (uInAppMessage != null) {
                            InAppMessageManager.getInstance(ai.this.a).a(new File(f.a(ai.this.a, uInAppMessage.msg_id)));
                            InAppMessageManager.getInstance(ai.this.a).a((UInAppMessage) null, str);
                        }
                    } catch (Exception e3) {
                        UPLog.w("UmengInAppMessageTracker", "getCardMsg error: ", e3.getMessage());
                        adVar.b(null);
                    }
                }
            });
        }
    }

    public final void a(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        b.c(new Runnable() { // from class: com.umeng.message.proguard.ai.3
            final /* synthetic */ String a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ int f7974b;

            /* JADX INFO: renamed from: c */
            final /* synthetic */ int f7975c;

            /* JADX INFO: renamed from: d */
            final /* synthetic */ int f7976d;

            /* JADX INFO: renamed from: e */
            final /* synthetic */ int f7977e;

            /* JADX INFO: renamed from: f */
            final /* synthetic */ int f7978f;

            /* JADX INFO: renamed from: g */
            final /* synthetic */ int f7979g;

            /* JADX INFO: renamed from: h */
            final /* synthetic */ int f7980h;

            /* JADX INFO: renamed from: i */
            final /* synthetic */ int f7981i;

            AnonymousClass3(String str2, int i22, int i32, int i42, int i52, int i62, int i72, int i82, int i92) {
                str = str2;
                i = i22;
                i = i32;
                i = i42;
                i = i52;
                i = i62;
                i = i72;
                i = i82;
                i = i92;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
                jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.umeng.message.inapp.InAppMessageManager.1.<init>(com.umeng.message.inapp.InAppMessageManager, java.lang.String, int, int, int, int, int, int, int, int):void, class status: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:298)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
                	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:197)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
                	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
                */
            @Override // java.lang.Runnable
            public final void run() {
                /*
                    r12 = this;
                    java.lang.String r0 = "UmengInAppMessageTracker"
                    java.lang.String r1 = "track in app msg begin"
                    java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> L3c
                    r2 = 2
                    com.umeng.commonsdk.debug.UMLog.mutlInfo(r0, r2, r1)     // Catch: java.lang.Exception -> L3c
                    java.lang.String r3 = r2     // Catch: java.lang.Exception -> L3c
                    int r4 = r3     // Catch: java.lang.Exception -> L3c
                    int r5 = r4     // Catch: java.lang.Exception -> L3c
                    int r6 = r5     // Catch: java.lang.Exception -> L3c
                    int r7 = r6     // Catch: java.lang.Exception -> L3c
                    int r8 = r7     // Catch: java.lang.Exception -> L3c
                    int r9 = r8     // Catch: java.lang.Exception -> L3c
                    int r10 = r9     // Catch: java.lang.Exception -> L3c
                    int r11 = r10     // Catch: java.lang.Exception -> L3c
                    org.json.JSONObject r1 = com.umeng.message.proguard.ai.b(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L3c
                    if (r1 == 0) goto L3b
                    java.lang.String r3 = "success"
                    java.lang.String r1 = r1.getString(r3)     // Catch: java.lang.Exception -> L3c
                    java.lang.String r3 = "ok"
                    boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch: java.lang.Exception -> L3c
                    if (r1 == 0) goto L3b
                    java.lang.String r1 = "track in app msg success"
                    java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> L3c
                    com.umeng.commonsdk.debug.UMLog.mutlInfo(r0, r2, r1)     // Catch: java.lang.Exception -> L3c
                L3b:
                    return
                L3c:
                    r1 = move-exception
                    r2 = 1
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    java.lang.String r5 = "trackInAppMessage error:"
                    r4.<init>(r5)
                    java.lang.String r1 = r1.getMessage()
                    r4.append(r1)
                    java.lang.String r1 = r4.toString()
                    r2[r3] = r1
                    com.umeng.message.common.UPLog.w(r0, r2)
                    com.umeng.message.proguard.ai r0 = com.umeng.message.proguard.ai.this
                    android.content.Context r0 = com.umeng.message.proguard.ai.a(r0)
                    com.umeng.message.inapp.InAppMessageManager r2 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
                    java.lang.String r3 = r2
                    int r4 = r3
                    int r5 = r4
                    int r6 = r5
                    int r7 = r6
                    int r8 = r7
                    int r9 = r8
                    int r10 = r9
                    int r11 = r10
                    boolean r0 = android.text.TextUtils.isEmpty(r3)
                    if (r0 != 0) goto L83
                    com.umeng.message.inapp.InAppMessageManager$1 r0 = new com.umeng.message.inapp.InAppMessageManager$1
                    r1 = r0
                    r1.<init>()
                    com.umeng.message.proguard.b.c(r0)
                L83:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ai.AnonymousClass3.run():void");
            }
        });
    }

    static /* synthetic */ JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("pmode", InAppMessageManager.a ? "0" : "1");
        return jSONObject;
    }
}
