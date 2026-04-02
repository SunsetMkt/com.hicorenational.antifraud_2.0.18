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
import java.io.File;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ag implements ad, af.a {
    public static final String a = "com.umeng.message.proguard.ag";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f7959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private UInAppMessage f7962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IUmengInAppMsgCloseCallback f7963f;

    public ag(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        this.f7959b = activity;
        this.f7960c = str;
        this.f7963f = iUmengInAppMsgCloseCallback;
    }

    @Override // com.umeng.message.proguard.ad
    public final void a(UInAppMessage uInAppMessage) {
    }

    public final boolean a(String str) {
        if (!d.a(this.f7959b).equals(InAppMessageManager.getInstance(this.f7959b).a("KEY_LAST_VERSION_CODE", ""))) {
            InAppMessageManager.getInstance(this.f7959b).b("KEY_CARD_LABEL_LIST", "");
        }
        InAppMessageManager.getInstance(this.f7959b).b("KEY_LAST_VERSION_CODE", d.a(this.f7959b));
        String strA = InAppMessageManager.getInstance(this.f7959b).a("KEY_CARD_LABEL_LIST", "");
        JSONArray jSONArray = null;
        if (!TextUtils.isEmpty(strA)) {
            try {
                jSONArray = new JSONArray(strA);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONArray == null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(str);
            InAppMessageManager.getInstance(this.f7959b).b("KEY_CARD_LABEL_LIST", jSONArray2.toString());
            return true;
        }
        if (a(jSONArray, str)) {
            return true;
        }
        if (jSONArray.length() >= 10) {
            return false;
        }
        jSONArray.put(str);
        InAppMessageManager.getInstance(this.f7959b).b("KEY_CARD_LABEL_LIST", jSONArray.toString());
        return true;
    }

    @Override // com.umeng.message.proguard.ad
    public final void b(UInAppMessage uInAppMessage) {
        UInAppMessage uInAppMessage2;
        String strA = InAppMessageManager.getInstance(this.f7959b).a(this.f7960c);
        if (TextUtils.isEmpty(strA)) {
            uInAppMessage2 = null;
        } else {
            try {
                uInAppMessage2 = new UInAppMessage(new JSONObject(strA));
            } catch (JSONException e2) {
                e2.printStackTrace();
                uInAppMessage2 = null;
            }
        }
        if (uInAppMessage != null) {
            if (uInAppMessage2 != null && !uInAppMessage.msg_id.equals(uInAppMessage2.msg_id)) {
                InAppMessageManager.getInstance(this.f7959b).a(new File(f.a(this.f7959b, uInAppMessage2.msg_id)));
            }
            this.f7962e = uInAppMessage;
        } else if (uInAppMessage2 == null) {
            return;
        } else {
            this.f7962e = uInAppMessage2;
        }
        if (this.f7962e.show_type == 1 && !b(this.f7960c)) {
            InAppMessageManager.getInstance(this.f7959b).a(this.f7962e.msg_id, 0);
        }
        InAppMessageManager.getInstance(this.f7959b);
        if (InAppMessageManager.b(this.f7962e) && InAppMessageManager.getInstance(this.f7959b).c(this.f7962e)) {
            UInAppMessage uInAppMessage3 = this.f7962e;
            int i2 = uInAppMessage3.msg_type;
            if (i2 == 5 || i2 == 6) {
                InAppMessageManager.getInstance(this.f7959b).a(this.f7962e, this.f7960c);
                a();
            } else {
                af afVar = new af(this.f7959b, uInAppMessage3);
                afVar.a = this;
                afVar.execute(this.f7962e.image_url);
            }
        }
    }

    private boolean b(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(InAppMessageManager.getInstance(this.f7959b).c(str));
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
            umengCardMessage.a = this.f7963f;
            Bundle bundle = new Bundle();
            bundle.putString("label", this.f7960c);
            bundle.putString("msg", this.f7962e.getRaw().toString());
            umengCardMessage.setArguments(bundle);
            umengCardMessage.show(((Activity) this.f7959b).getFragmentManager(), this.f7960c);
            InAppMessageManager.getInstance(this.f7959b).a(this.f7962e.msg_id, 1);
            InAppMessageManager.getInstance(this.f7959b).b(this.f7960c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.umeng.message.proguard.af.a
    public final void a(Bitmap[] bitmapArr) {
        Bitmap bitmap;
        if (!this.f7961d && (bitmap = bitmapArr[0]) != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                UmengCardMessage umengCardMessage = new UmengCardMessage();
                umengCardMessage.a = this.f7963f;
                Bundle bundle = new Bundle();
                bundle.putString("label", this.f7960c);
                bundle.putString("msg", this.f7962e.getRaw().toString());
                bundle.putByteArray("bitmapByte", byteArray);
                umengCardMessage.setArguments(bundle);
                umengCardMessage.show(((Activity) this.f7959b).getFragmentManager(), this.f7960c);
                InAppMessageManager.getInstance(this.f7959b).a(this.f7962e.msg_id, 1);
                InAppMessageManager.getInstance(this.f7959b).b(this.f7960c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        InAppMessageManager.getInstance(this.f7959b).a(this.f7962e, this.f7960c);
    }
}
