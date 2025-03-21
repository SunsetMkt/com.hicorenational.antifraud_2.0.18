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
import com.umeng.message.proguard.AsyncTaskC3557af;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.umeng.message.proguard.ag */
/* loaded from: classes2.dex */
public final class C3558ag implements InterfaceC3555ad, AsyncTaskC3557af.a {

    /* renamed from: a */
    public static final String f13168a = "com.umeng.message.proguard.ag";

    /* renamed from: b */
    public Context f13169b;

    /* renamed from: c */
    public String f13170c;

    /* renamed from: d */
    private boolean f13171d;

    /* renamed from: e */
    private UInAppMessage f13172e;

    /* renamed from: f */
    private IUmengInAppMsgCloseCallback f13173f;

    public C3558ag(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        this.f13169b = activity;
        this.f13170c = str;
        this.f13173f = iUmengInAppMsgCloseCallback;
    }

    @Override // com.umeng.message.proguard.InterfaceC3555ad
    /* renamed from: a */
    public final void mo12212a(UInAppMessage uInAppMessage) {
    }

    /* renamed from: a */
    public final boolean m12237a(String str) {
        if (!C3584d.m12345a(this.f13169b).equals(InAppMessageManager.getInstance(this.f13169b).m12160a("KEY_LAST_VERSION_CODE", ""))) {
            InAppMessageManager.getInstance(this.f13169b).m12167b("KEY_CARD_LABEL_LIST", "");
        }
        InAppMessageManager.getInstance(this.f13169b).m12167b("KEY_LAST_VERSION_CODE", C3584d.m12345a(this.f13169b));
        String m12160a = InAppMessageManager.getInstance(this.f13169b).m12160a("KEY_CARD_LABEL_LIST", "");
        JSONArray jSONArray = null;
        if (!TextUtils.isEmpty(m12160a)) {
            try {
                jSONArray = new JSONArray(m12160a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONArray == null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(str);
            InAppMessageManager.getInstance(this.f13169b).m12167b("KEY_CARD_LABEL_LIST", jSONArray2.toString());
            return true;
        }
        if (m12235a(jSONArray, str)) {
            return true;
        }
        if (jSONArray.length() >= 10) {
            return false;
        }
        jSONArray.put(str);
        InAppMessageManager.getInstance(this.f13169b).m12167b("KEY_CARD_LABEL_LIST", jSONArray.toString());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0024  */
    @Override // com.umeng.message.proguard.InterfaceC3555ad
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo12213b(com.umeng.message.entity.UInAppMessage r5) {
        /*
            r4 = this;
            android.content.Context r0 = r4.f13169b
            com.umeng.message.inapp.InAppMessageManager r0 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
            java.lang.String r1 = r4.f13170c
            java.lang.String r0 = r0.m12159a(r1)
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
            android.content.Context r2 = r4.f13169b
            java.lang.String r1 = r1.msg_id
            java.lang.String r1 = com.umeng.message.proguard.C3586f.m12382a(r2, r1)
            r0.<init>(r1)
            android.content.Context r1 = r4.f13169b
            com.umeng.message.inapp.InAppMessageManager r1 = com.umeng.message.inapp.InAppMessageManager.getInstance(r1)
            r1.m12163a(r0)
        L46:
            r4.f13172e = r5
            goto L4d
        L49:
            if (r1 == 0) goto Lb6
            r4.f13172e = r1
        L4d:
            com.umeng.message.entity.UInAppMessage r5 = r4.f13172e
            int r5 = r5.show_type
            r0 = 0
            r1 = 1
            if (r5 != r1) goto L6a
            java.lang.String r5 = r4.f13170c
            boolean r5 = r4.m12236b(r5)
            if (r5 != 0) goto L6a
            android.content.Context r5 = r4.f13169b
            com.umeng.message.inapp.InAppMessageManager r5 = com.umeng.message.inapp.InAppMessageManager.getInstance(r5)
            com.umeng.message.entity.UInAppMessage r2 = r4.f13172e
            java.lang.String r2 = r2.msg_id
            r5.m12164a(r2, r0)
        L6a:
            android.content.Context r5 = r4.f13169b
            com.umeng.message.inapp.InAppMessageManager.getInstance(r5)
            com.umeng.message.entity.UInAppMessage r5 = r4.f13172e
            boolean r5 = com.umeng.message.inapp.InAppMessageManager.m12156b(r5)
            if (r5 == 0) goto Lb6
            android.content.Context r5 = r4.f13169b
            com.umeng.message.inapp.InAppMessageManager r5 = com.umeng.message.inapp.InAppMessageManager.getInstance(r5)
            com.umeng.message.entity.UInAppMessage r2 = r4.f13172e
            boolean r5 = r5.m12169c(r2)
            if (r5 != 0) goto L86
            goto Lb6
        L86:
            com.umeng.message.entity.UInAppMessage r5 = r4.f13172e
            int r2 = r5.msg_type
            r3 = 5
            if (r2 == r3) goto La6
            r3 = 6
            if (r2 != r3) goto L91
            goto La6
        L91:
            com.umeng.message.proguard.af r2 = new com.umeng.message.proguard.af
            android.content.Context r3 = r4.f13169b
            r2.<init>(r3, r5)
            r2.f13165a = r4
            java.lang.String[] r5 = new java.lang.String[r1]
            com.umeng.message.entity.UInAppMessage r1 = r4.f13172e
            java.lang.String r1 = r1.image_url
            r5[r0] = r1
            r2.execute(r5)
            return
        La6:
            android.content.Context r5 = r4.f13169b
            com.umeng.message.inapp.InAppMessageManager r5 = com.umeng.message.inapp.InAppMessageManager.getInstance(r5)
            com.umeng.message.entity.UInAppMessage r0 = r4.f13172e
            java.lang.String r1 = r4.f13170c
            r5.m12162a(r0, r1)
            r4.m12234a()
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.C3558ag.mo12213b(com.umeng.message.entity.UInAppMessage):void");
    }

    /* renamed from: b */
    private boolean m12236b(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(InAppMessageManager.getInstance(this.f13169b).m12168c(str));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    /* renamed from: a */
    private static boolean m12235a(JSONArray jSONArray, String str) {
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

    /* renamed from: a */
    private void m12234a() {
        try {
            UmengCardMessage umengCardMessage = new UmengCardMessage();
            umengCardMessage.f13088a = this.f13173f;
            Bundle bundle = new Bundle();
            bundle.putString("label", this.f13170c);
            bundle.putString("msg", this.f13172e.getRaw().toString());
            umengCardMessage.setArguments(bundle);
            umengCardMessage.show(((Activity) this.f13169b).getFragmentManager(), this.f13170c);
            InAppMessageManager.getInstance(this.f13169b).m12164a(this.f13172e.msg_id, 1);
            InAppMessageManager.getInstance(this.f13169b).m12166b(this.f13170c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.umeng.message.proguard.AsyncTaskC3557af.a
    /* renamed from: a */
    public final void mo12211a(Bitmap[] bitmapArr) {
        Bitmap bitmap;
        if (!this.f13171d && (bitmap = bitmapArr[0]) != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                UmengCardMessage umengCardMessage = new UmengCardMessage();
                umengCardMessage.f13088a = this.f13173f;
                Bundle bundle = new Bundle();
                bundle.putString("label", this.f13170c);
                bundle.putString("msg", this.f13172e.getRaw().toString());
                bundle.putByteArray("bitmapByte", byteArray);
                umengCardMessage.setArguments(bundle);
                umengCardMessage.show(((Activity) this.f13169b).getFragmentManager(), this.f13170c);
                InAppMessageManager.getInstance(this.f13169b).m12164a(this.f13172e.msg_id, 1);
                InAppMessageManager.getInstance(this.f13169b).m12166b(this.f13170c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        InAppMessageManager.getInstance(this.f13169b).m12162a(this.f13172e, this.f13170c);
    }
}
