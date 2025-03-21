package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.IUmengInAppMsgCloseCallback;
import com.umeng.message.inapp.InAppMessageManager;
import com.umeng.message.inapp.UmengCardMessage;
import com.umeng.message.proguard.af;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class ag implements ad, af.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11240a = "com.umeng.message.proguard.ag";

    /* renamed from: b, reason: collision with root package name */
    public Context f11241b;

    /* renamed from: c, reason: collision with root package name */
    public String f11242c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11243d;

    /* renamed from: e, reason: collision with root package name */
    private UInAppMessage f11244e;

    /* renamed from: f, reason: collision with root package name */
    private IUmengInAppMsgCloseCallback f11245f;

    public ag(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        this.f11241b = activity;
        this.f11242c = str;
        this.f11245f = iUmengInAppMsgCloseCallback;
    }

    @Override // com.umeng.message.proguard.ad
    public final void a(UInAppMessage uInAppMessage) {
    }

    public final boolean a(String str) {
        if (!d.a(this.f11241b).equals(InAppMessageManager.getInstance(this.f11241b).a("KEY_LAST_VERSION_CODE", ""))) {
            InAppMessageManager.getInstance(this.f11241b).b("KEY_CARD_LABEL_LIST", "");
        }
        InAppMessageManager.getInstance(this.f11241b).b("KEY_LAST_VERSION_CODE", d.a(this.f11241b));
        String a2 = InAppMessageManager.getInstance(this.f11241b).a("KEY_CARD_LABEL_LIST", "");
        JSONArray jSONArray = null;
        if (!TextUtils.isEmpty(a2)) {
            try {
                jSONArray = new JSONArray(a2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONArray == null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(str);
            InAppMessageManager.getInstance(this.f11241b).b("KEY_CARD_LABEL_LIST", jSONArray2.toString());
            return true;
        }
        if (a(jSONArray, str)) {
            return true;
        }
        if (jSONArray.length() >= 10) {
            return false;
        }
        jSONArray.put(str);
        InAppMessageManager.getInstance(this.f11241b).b("KEY_CARD_LABEL_LIST", jSONArray.toString());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0024  */
    @Override // com.umeng.message.proguard.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.umeng.message.entity.UInAppMessage r5) {
        /*
            r4 = this;
            android.content.Context r0 = r4.f11241b
            com.umeng.message.inapp.InAppMessageManager r0 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
            java.lang.String r1 = r4.f11242c
            java.lang.String r0 = r0.a(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L21
            com.umeng.message.entity.UInAppMessage r1 = new com.umeng.message.entity.UInAppMessage     // Catch: org.json.JSONException -> L1d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L1d
            r2.<init>(r0)     // Catch: org.json.JSONException -> L1d
            r1.<init>(r2)     // Catch: org.json.JSONException -> L1d
            goto L22
        L1d:
            r0 = move-exception
            r0.printStackTrace()
        L21:
            r1 = 0
        L22:
            if (r5 == 0) goto L49
            if (r1 == 0) goto L46
            java.lang.String r0 = r5.msg_id
            java.lang.String r2 = r1.msg_id
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L46
            java.io.File r0 = new java.io.File
            android.content.Context r2 = r4.f11241b
            java.lang.String r1 = r1.msg_id
            java.lang.String r1 = com.umeng.message.proguard.f.a(r2, r1)
            r0.<init>(r1)
            android.content.Context r1 = r4.f11241b
            com.umeng.message.inapp.InAppMessageManager r1 = com.umeng.message.inapp.InAppMessageManager.getInstance(r1)
            r1.a(r0)
        L46:
            r4.f11244e = r5
            goto L4d
        L49:
            if (r1 == 0) goto Lb6
            r4.f11244e = r1
        L4d:
            com.umeng.message.entity.UInAppMessage r5 = r4.f11244e
            int r5 = r5.show_type
            r0 = 0
            r1 = 1
            if (r5 != r1) goto L6a
            java.lang.String r5 = r4.f11242c
            boolean r5 = r4.b(r5)
            if (r5 != 0) goto L6a
            android.content.Context r5 = r4.f11241b
            com.umeng.message.inapp.InAppMessageManager r5 = com.umeng.message.inapp.InAppMessageManager.getInstance(r5)
            com.umeng.message.entity.UInAppMessage r2 = r4.f11244e
            java.lang.String r2 = r2.msg_id
            r5.a(r2, r0)
        L6a:
            android.content.Context r5 = r4.f11241b
            com.umeng.message.inapp.InAppMessageManager.getInstance(r5)
            com.umeng.message.entity.UInAppMessage r5 = r4.f11244e
            boolean r5 = com.umeng.message.inapp.InAppMessageManager.b(r5)
            if (r5 == 0) goto Lb6
            android.content.Context r5 = r4.f11241b
            com.umeng.message.inapp.InAppMessageManager r5 = com.umeng.message.inapp.InAppMessageManager.getInstance(r5)
            com.umeng.message.entity.UInAppMessage r2 = r4.f11244e
            boolean r5 = r5.c(r2)
            if (r5 != 0) goto L86
            goto Lb6
        L86:
            com.umeng.message.entity.UInAppMessage r5 = r4.f11244e
            int r2 = r5.msg_type
            r3 = 5
            if (r2 == r3) goto La6
            r3 = 6
            if (r2 != r3) goto L91
            goto La6
        L91:
            com.umeng.message.proguard.af r2 = new com.umeng.message.proguard.af
            android.content.Context r3 = r4.f11241b
            r2.<init>(r3, r5)
            r2.f11237a = r4
            java.lang.String[] r5 = new java.lang.String[r1]
            com.umeng.message.entity.UInAppMessage r1 = r4.f11244e
            java.lang.String r1 = r1.image_url
            r5[r0] = r1
            r2.execute(r5)
            return
        La6:
            android.content.Context r5 = r4.f11241b
            com.umeng.message.inapp.InAppMessageManager r5 = com.umeng.message.inapp.InAppMessageManager.getInstance(r5)
            com.umeng.message.entity.UInAppMessage r0 = r4.f11244e
            java.lang.String r1 = r4.f11242c
            r5.a(r0, r1)
            r4.a()
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ag.b(com.umeng.message.entity.UInAppMessage):void");
    }

    private boolean b(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(InAppMessageManager.getInstance(this.f11241b).c(str));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    private static boolean a(JSONArray jSONArray, String str) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                if (jSONArray.getString(i2).equals(str)) {
                    return true;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    private void a() {
        try {
            UmengCardMessage umengCardMessage = new UmengCardMessage();
            umengCardMessage.f11173a = this.f11245f;
            Bundle bundle = new Bundle();
            bundle.putString("label", this.f11242c);
            bundle.putString("msg", this.f11244e.getRaw().toString());
            umengCardMessage.setArguments(bundle);
            umengCardMessage.show(((Activity) this.f11241b).getFragmentManager(), this.f11242c);
            InAppMessageManager.getInstance(this.f11241b).a(this.f11244e.msg_id, 1);
            InAppMessageManager.getInstance(this.f11241b).b(this.f11242c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.umeng.message.proguard.af.a
    public final void a(Bitmap[] bitmapArr) {
        Bitmap bitmap;
        if (!this.f11243d && (bitmap = bitmapArr[0]) != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                UmengCardMessage umengCardMessage = new UmengCardMessage();
                umengCardMessage.f11173a = this.f11245f;
                Bundle bundle = new Bundle();
                bundle.putString("label", this.f11242c);
                bundle.putString("msg", this.f11244e.getRaw().toString());
                bundle.putByteArray("bitmapByte", byteArray);
                umengCardMessage.setArguments(bundle);
                umengCardMessage.show(((Activity) this.f11241b).getFragmentManager(), this.f11242c);
                InAppMessageManager.getInstance(this.f11241b).a(this.f11244e.msg_id, 1);
                InAppMessageManager.getInstance(this.f11241b).b(this.f11242c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        InAppMessageManager.getInstance(this.f11241b).a(this.f11244e, this.f11242c);
    }
}
