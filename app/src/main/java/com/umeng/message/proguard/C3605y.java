package com.umeng.message.proguard;

import android.app.Application;
import android.app.Notification;
import android.content.ContentProviderOperation;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C3566ao;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.y */
/* loaded from: classes2.dex */
public final class C3605y extends UTrack {

    /* renamed from: a */
    public static volatile boolean f13389a;

    /* renamed from: d */
    private final AbstractC3552aa f13392d = new C3606z();

    /* renamed from: e */
    private long f13393e;

    /* renamed from: c */
    private static final C3605y f13391c = new C3605y();

    /* renamed from: b */
    public static boolean f13390b = false;

    private C3605y() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m12469b(String str, String str2, String str3) {
        if ("8".equals(str3)) {
            TaobaoRegister.clickMessage(C3604x.m12460a(), str, str2);
        } else {
            TaobaoRegister.dismissMessage(C3604x.m12460a(), str, str2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sendMsgLogForAgoo msgId:");
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" taskId:");
            sb.append(str2);
        }
        sb.append(" status:");
        sb.append(str3);
        UPLog.m12142d("Track", sb);
    }

    /* renamed from: c */
    public static boolean m12470c() {
        if (C3586f.m12389b()) {
            UPLog.m12142d("Track", "track failed, silent mode!");
            return true;
        }
        Application m12460a = C3604x.m12460a();
        if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(m12460a).m12131k())) {
            return true;
        }
        return TextUtils.isEmpty(C3584d.m12371o(m12460a));
    }

    /* renamed from: d */
    static /* synthetic */ JSONObject m12471d() throws JSONException {
        String m12131k = MessageSharedPrefs.getInstance(C3604x.m12460a()).m12131k();
        String m12371o = C3584d.m12371o(C3604x.m12460a());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", C3585e.m12377a());
        jSONObject.put("utdid", m12371o);
        jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, m12131k);
        return jSONObject;
    }

    @Override // com.umeng.message.UTrack
    public final void addAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.y.4
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(C3604x.m12460a());
                try {
                } catch (Exception e2) {
                    UPLog.m12143e("Track", e2);
                }
                if (!messageSharedPrefs.m12119a("alias_add_")) {
                    uPushAliasCallback.onMessage(false, "interval limit.");
                    return;
                }
                String m12468b = C3605y.m12468b(str, str2);
                if (m12468b != null && m12468b.length() > 0) {
                    uPushAliasCallback.onMessage(false, m12468b);
                    return;
                }
                String m12371o = C3584d.m12371o(C3604x.m12460a());
                String m12131k = messageSharedPrefs.m12131k();
                StringBuilder sb = new StringBuilder();
                String str3 = "";
                sb.append("");
                sb.append("utdid:");
                sb.append(m12371o);
                sb.append(", deviceToken:");
                sb.append(m12131k);
                sb.append(";");
                String sb2 = sb.toString();
                boolean z2 = true;
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                    UPLog.m12144e("Track", "addAlias: type or alias empty.");
                    sb2 = sb2 + "addAlias: empty type or alias. ";
                    z = false;
                } else {
                    z = true;
                }
                if (TextUtils.isEmpty(m12371o)) {
                    UPLog.m12144e("Track", "utdid empty. ");
                    sb2 = sb2 + "utdid empty;";
                    z = false;
                }
                if (TextUtils.isEmpty(m12131k)) {
                    UPLog.m12144e("Track", "deviceToken empty.");
                    sb2 = sb2 + "deviceToken empty;";
                    z = false;
                }
                if (messageSharedPrefs.m12118a(0, str, str2)) {
                    String format = String.format("addAlias: <%s, %s> has been synced to the server before. Ignore this request.", str, str2);
                    UPLog.m12142d("Track", format);
                    str3 = "" + format;
                    z = false;
                } else {
                    z2 = false;
                }
                try {
                    JSONObject m12471d = C3605y.m12471d();
                    if (z) {
                        m12471d.put("alias", str);
                        m12471d.put("type", str2);
                        m12471d.put("last_alias", messageSharedPrefs.m12112a(0, str2));
                        m12471d.put("ts", System.currentTimeMillis());
                    } else if (z2) {
                        m12471d.put("success", str3);
                    } else {
                        m12471d.put("fail", sb2);
                    }
                    C3605y.this.f13392d.mo12227a(str, str2, m12471d, uPushAliasCallback);
                } catch (Throwable th) {
                    UPLog.m12143e("Track", th);
                    if (th.getMessage() == null) {
                        UPushAliasCallback uPushAliasCallback2 = uPushAliasCallback;
                        if (uPushAliasCallback2 != null) {
                            uPushAliasCallback2.onMessage(false, "alias:" + str + " add failed");
                            return;
                        }
                        return;
                    }
                    UPushAliasCallback uPushAliasCallback3 = uPushAliasCallback;
                    if (uPushAliasCallback3 != null) {
                        uPushAliasCallback3.onMessage(false, "alias:" + str + " add failed:" + th.getMessage());
                    }
                }
            }
        });
    }

    @Override // com.umeng.message.UTrack
    public final void deleteAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.y.6
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(C3604x.m12460a());
                try {
                } catch (Throwable th) {
                    UPLog.m12143e("Track", th);
                }
                if (!messageSharedPrefs.m12119a("alias_del_")) {
                    uPushAliasCallback.onMessage(false, "interval limit.");
                    return;
                }
                String m12468b = C3605y.m12468b(str, str2);
                if (m12468b != null && m12468b.length() > 0) {
                    uPushAliasCallback.onMessage(false, m12468b);
                    return;
                }
                String str3 = "";
                if (TextUtils.isEmpty(str2)) {
                    UPLog.m12144e("Track", "removeAlias: type empty.");
                    str3 = "removeAlias: type empty. ";
                    z = false;
                } else {
                    z = true;
                }
                if (TextUtils.isEmpty(C3584d.m12371o(C3604x.m12460a()))) {
                    UPLog.m12144e("Track", "removeAlias: utdid empty.");
                    str3 = str3 + "utdid empty. ";
                    z = false;
                }
                if (TextUtils.isEmpty(messageSharedPrefs.m12131k())) {
                    UPLog.m12144e("Track", "removeAlias: deviceToken empty.");
                    str3 = str3 + "deviceToken empty.";
                    z = false;
                }
                try {
                    JSONObject m12471d = C3605y.m12471d();
                    if (z) {
                        m12471d.put("alias", str);
                        m12471d.put("type", str2);
                        m12471d.put("ts", System.currentTimeMillis());
                    } else {
                        m12471d.put("fail", str3);
                    }
                    C3605y.this.f13392d.mo12229c(str, str2, m12471d, uPushAliasCallback);
                } catch (Throwable th2) {
                    UPLog.m12143e("Track", th2);
                    if (th2.getMessage() == null) {
                        uPushAliasCallback.onMessage(false, "alias:" + str + "remove failed.");
                        return;
                    }
                    uPushAliasCallback.onMessage(false, "alias:" + str + "remove failed:" + th2.getMessage());
                }
            }
        });
    }

    @Override // com.umeng.message.UTrack
    public final void setAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.y.5
            @Override // java.lang.Runnable
            public final void run() {
                String str3;
                boolean z;
                String str4;
                boolean z2;
                MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(C3604x.m12460a());
                try {
                } catch (Throwable th) {
                    UPLog.m12143e("Track", th);
                }
                if (!messageSharedPrefs.m12119a("alias_set_")) {
                    uPushAliasCallback.onMessage(false, "interval limit.");
                    return;
                }
                String m12468b = C3605y.m12468b(str, str2);
                if (m12468b != null && m12468b.length() > 0) {
                    uPushAliasCallback.onMessage(false, m12468b);
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    UPLog.m12144e("Track", "addExclusiveAlias: type empty.");
                    str3 = "addExclusiveAlias: type empty. ";
                    z = false;
                } else {
                    str3 = "";
                    z = true;
                }
                if (TextUtils.isEmpty(C3584d.m12371o(C3604x.m12460a()))) {
                    UPLog.m12144e("Track", "addExclusiveAlias: utdid empty.");
                    str3 = str3 + "utdid empty. ";
                    z = false;
                }
                if (TextUtils.isEmpty(messageSharedPrefs.m12131k())) {
                    UPLog.m12144e("Track", "addExclusiveAlias: deviceToken empty.");
                    str3 = str3 + "deviceToken empty.";
                    z = false;
                }
                if (messageSharedPrefs.m12118a(1, str, str2)) {
                    String format = String.format("addExclusiveAlias: <%s, %s> has been synced to the server before. Ignore this request.", str, str2);
                    UPLog.m12142d("Track", format);
                    str4 = "" + format;
                    z2 = true;
                    z = false;
                } else {
                    str4 = "";
                    z2 = false;
                }
                try {
                    JSONObject m12471d = C3605y.m12471d();
                    if (z) {
                        m12471d.put("alias", str);
                        m12471d.put("type", str2);
                        m12471d.put("last_alias", messageSharedPrefs.m12112a(1, str2));
                        m12471d.put("ts", System.currentTimeMillis());
                    } else if (z2) {
                        m12471d.put("success", str4);
                    } else {
                        m12471d.put("fail", str3);
                    }
                    C3605y.this.f13392d.mo12228b(str, str2, m12471d, uPushAliasCallback);
                } catch (Throwable th2) {
                    UPLog.m12143e("Track", th2);
                    if (th2.getMessage() == null) {
                        uPushAliasCallback.onMessage(false, "alias:" + str + "add failed.");
                        return;
                    }
                    uPushAliasCallback.onMessage(false, "alias:" + str + "add failed:" + th2.getMessage());
                }
            }
        });
    }

    @Override // com.umeng.message.UTrack
    public final void trackMfrPushMsgClick(UMessage uMessage) {
        if (uMessage == null || TextUtils.isEmpty(uMessage.getMsgId())) {
            return;
        }
        m12472a(uMessage.getMsgId(), 21);
    }

    @Override // com.umeng.message.UTrack
    public final void trackMsgArrival(UMessage uMessage) {
        if (uMessage == null) {
            return;
        }
        m12472a(uMessage.getMsgId(), 0);
    }

    @Override // com.umeng.message.UTrack
    public final void trackMsgClick(UMessage uMessage) {
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
            m12472a(uMessage.getMsgId(), 1);
        }
        if (uMessage == null || TextUtils.isEmpty(uMessage.getAgooMsgId())) {
            return;
        }
        m12466a(uMessage.getAgooMsgId(), uMessage.getTaskId(), "8");
    }

    @Override // com.umeng.message.UTrack
    public final void trackMsgDismissed(UMessage uMessage) {
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
            m12472a(uMessage.getMsgId(), 2);
        }
        if (uMessage == null || TextUtils.isEmpty(uMessage.getAgooMsgId())) {
            return;
        }
        m12466a(uMessage.getAgooMsgId(), uMessage.getTaskId(), "9");
    }

    @Override // com.umeng.message.UTrack
    public final void trackMsgRepost(UMessage uMessage, Notification notification) {
        if (uMessage == null || TextUtils.isEmpty(uMessage.getMsgId())) {
            return;
        }
        C3554ac m12455a = C3603w.m12454a().m12455a(uMessage.getMsgId());
        if (m12455a == null) {
            UPLog.m12145i("Track", "sendMsgRepost item null, msgId:", uMessage.getMsgId());
            return;
        }
        int i2 = m12455a.f13153d;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 26 && notification != null) {
                str = notification.getChannelId();
            }
            this.f13392d.mo12226a(uMessage.getMsgId(), str, i2);
        } catch (Throwable th) {
            UPLog.m12143e("Track", th);
        }
    }

    @Override // com.umeng.message.UTrack
    public final void trackMsgShow(UMessage uMessage, Notification notification) {
        int i2;
        if (uMessage == null || TextUtils.isEmpty(uMessage.getMsgId())) {
            return;
        }
        if (TextUtils.equals(uMessage.getDisplayType(), "notification")) {
            i2 = 6;
        } else if (!TextUtils.equals(uMessage.getDisplayType(), "custom")) {
            return;
        } else {
            i2 = 7;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 26 && notification != null) {
                str = notification.getChannelId();
            }
            this.f13392d.mo12225a(uMessage.getMsgId(), i2, str);
        } catch (Throwable th) {
            UPLog.m12147w("Track", "trackMsgShow error:", th.getMessage());
        }
    }

    /* renamed from: a */
    public static C3605y m12463a() {
        return f13391c;
    }

    /* renamed from: a */
    public final void m12472a(String str, int i2) {
        if (m12470c()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UPLog.m12144e("Track", "trackMsgLog skipped, msgId empty!");
            return;
        }
        try {
            this.f13392d.mo12224a(str, i2);
        } catch (Throwable th) {
            UPLog.m12143e("Track", th);
        }
    }

    /* renamed from: a */
    private void m12466a(final String str, final String str2, final String str3) {
        C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.y.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C3605y.this.m12469b(str, str2, str3);
                } catch (Throwable th) {
                    UPLog.m12143e("Track", th);
                }
            }
        });
    }

    /* renamed from: b */
    final synchronized void m12473b() {
        ArrayList arrayList;
        if (m12470c()) {
            return;
        }
        try {
            Application m12460a = C3604x.m12460a();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f13393e) >= 30000) {
                this.f13393e = currentTimeMillis;
                if (C3586f.m12390b(m12460a)) {
                    C3566ao m12272a = C3566ao.m12272a(m12460a);
                    Cursor query = m12272a.f13220a.getContentResolver().query(C3588h.m12405d(m12272a.f13220a), null, null, null, "Time Asc ");
                    if (query == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
                            arrayList2.add(new C3566ao.a(query));
                        }
                        query.close();
                        arrayList = arrayList2;
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            C3566ao.a aVar = (C3566ao.a) arrayList.get(i2);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ts", aVar.f13222b);
                            jSONObject.put("pa", "");
                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(m12460a).m12131k());
                            jSONObject.put("msg_id", aVar.f13221a);
                            jSONObject.put("action_type", aVar.f13223c);
                            jSONArray.put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject2.put("header", jSONObject3);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("push", jSONArray);
                        jSONObject2.put("content", jSONObject4);
                        jSONObject3.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
                        jSONObject3.put("din", C3584d.m12351c(m12460a));
                        jSONObject3.put("push_switch", C3584d.m12372p(m12460a));
                        UMWorkDispatch.sendEvent(C3604x.m12460a(), 16389, C3602v.m12452a(), jSONObject2.toString());
                    }
                }
            }
        } catch (Throwable th) {
            UPLog.m12143e("Track", th);
        }
        if (f13389a) {
            return;
        }
        f13389a = true;
        C3578b.m12321a(new Runnable() { // from class: com.umeng.message.proguard.y.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(C3604x.m12460a());
                    if (messageSharedPrefs.f13043b.m12288b("launch_send_policy", -1) == 1) {
                        UPLog.m12142d("Track", "launch policy 1, skipped.");
                    } else {
                        if (messageSharedPrefs.m12117a()) {
                            return;
                        }
                        C3605y.this.f13392d.mo12222a();
                        if (C3586f.m12390b(C3604x.m12460a())) {
                            C3578b.m12321a(this, TimeUnit.DAYS.toMillis(1L), TimeUnit.MILLISECONDS);
                        }
                    }
                } catch (Exception e2) {
                    UPLog.m12143e("Track", e2);
                    C3605y.f13389a = false;
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    static void m12467a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            Application m12460a = C3604x.m12460a();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    arrayList.add(ContentProviderOperation.newDelete(C3588h.m12405d(m12460a)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                }
            }
            m12460a.getContentResolver().applyBatch(C3588h.m12407f(m12460a), arrayList);
        } catch (Throwable th) {
            UPLog.m12143e("Track", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m12468b(String str, String str2) {
        if (C3586f.m12389b()) {
            UPLog.m12142d("Track", "checkAlias failed, silent mode!");
            return "checkAlias failed, silent mode!";
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bytes2 = str2.getBytes("UTF-8");
            boolean z = bytes.length <= 128;
            boolean z2 = bytes2.length <= 64;
            if (z && z2) {
                return null;
            }
            return "alias length must be <= 128 and aliasType length must be <= 64";
        } catch (Throwable th) {
            UPLog.m12143e("Track", th);
            return null;
        }
    }
}
