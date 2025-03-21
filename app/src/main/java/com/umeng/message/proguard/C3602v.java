package com.umeng.message.proguard;

import android.app.Application;
import android.content.ContentProviderOperation;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.v */
/* loaded from: classes2.dex */
public final class C3602v implements UMLogDataProtocol {

    /* renamed from: a */
    private static final UMLogDataProtocol f13385a = new C3602v();

    private C3602v() {
    }

    /* renamed from: a */
    public static UMLogDataProtocol m12452a() {
        return f13385a;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public final void removeCacheData(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(obj.toString()).optJSONObject("content");
            if (optJSONObject == null) {
                return;
            }
            Application m12460a = C3604x.m12460a();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            JSONArray optJSONArray = optJSONObject.optJSONArray("push");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                    arrayList.add(ContentProviderOperation.newDelete(C3588h.m12405d(m12460a)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                }
            }
            m12460a.getContentResolver().applyBatch(C3588h.m12407f(m12460a), arrayList);
        } catch (Throwable th) {
            UPLog.m12143e("LogDataProtocol", th);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public final JSONObject setupReportData(long j2) {
        return null;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public final void workEvent(Object obj, int i2) {
        int i3;
        JSONObject buildEnvelopeWithExtHeader;
        JSONArray optJSONArray;
        JSONObject buildEnvelopeWithExtHeader2;
        JSONObject buildEnvelopeWithExtHeader3;
        JSONObject jSONObject;
        JSONObject buildEnvelopeWithExtHeader4;
        JSONObject buildEnvelopeWithExtHeader5;
        if (obj == null) {
        }
        int i4 = 0;
        try {
            switch (i2) {
                case 16385:
                    Application m12460a = C3604x.m12460a();
                    JSONObject jSONObject2 = new JSONObject(obj.toString());
                    JSONObject optJSONObject = jSONObject2.optJSONObject("content");
                    if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("push")) == null || optJSONArray.length() <= 0) {
                        i3 = -1;
                    } else {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray.get(0);
                        i3 = jSONObject3.optInt("action_type");
                        if (i3 != 70 && i3 != 71) {
                            if (i3 == 0) {
                                ((C3561aj) PushAgent.getInstance(m12460a).getMessageNotifyApi()).m12253a(jSONObject3);
                            }
                            C3566ao.m12272a(m12460a).m12273a(jSONObject3.optString("msg_id"), i3, jSONObject3.optLong("ts"));
                        }
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("header");
                    if (optJSONObject2 == null || optJSONObject == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(m12460a, optJSONObject2, optJSONObject, "umpx_push_logs", C3351bh.f11576aA, MsgConstant.SDK_VERSION)) == null || buildEnvelopeWithExtHeader.has("exception") || i3 == 70 || i3 == 71) {
                        break;
                    } else {
                        try {
                            removeCacheData(jSONObject2);
                            break;
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return;
                        }
                    }
                    break;
                case InputDeviceCompat.SOURCE_STYLUS /* 16386 */:
                    Application m12460a2 = C3604x.m12460a();
                    JSONObject jSONObject4 = new JSONObject(obj.toString());
                    JSONObject optJSONObject3 = jSONObject4.optJSONObject("header");
                    JSONObject optJSONObject4 = jSONObject4.optJSONObject("content");
                    if (optJSONObject3 != null && optJSONObject4 != null && (buildEnvelopeWithExtHeader2 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(m12460a2, optJSONObject3, optJSONObject4, "umpx_push_launch", C3351bh.f11576aA, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader2.has("exception")) {
                        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a2);
                        messageSharedPrefs.f13043b.m12284a(C3397d.f11950p, System.currentTimeMillis());
                        try {
                            int parseInt = Integer.parseInt(UMEnvelopeBuild.imprintProperty(m12460a2, "launch_policy", "-1"));
                            UPLog.m12145i("LogDataProtocol", "launch policy:", Integer.valueOf(parseInt));
                            if (parseInt > 0) {
                                messageSharedPrefs.f13043b.m12283a("launch_send_policy", parseInt);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            int parseInt2 = Integer.parseInt(UMEnvelopeBuild.imprintProperty(m12460a2, "tag_policy", "-1"));
                            UPLog.m12145i("LogDataProtocol", "tag policy:", Integer.valueOf(parseInt2));
                            if (parseInt2 > 0) {
                                messageSharedPrefs.f13043b.m12283a("tag_send_policy", parseInt2);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                    C3605y.f13389a = false;
                    break;
                case 16387:
                    Application m12460a3 = C3604x.m12460a();
                    JSONObject jSONObject5 = new JSONObject(obj.toString());
                    JSONObject optJSONObject5 = jSONObject5.optJSONObject("header");
                    JSONObject optJSONObject6 = jSONObject5.optJSONObject("content");
                    if (optJSONObject5 != null && optJSONObject6 != null && (buildEnvelopeWithExtHeader3 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(m12460a3, optJSONObject5, optJSONObject6, "umpx_push_register", C3351bh.f11576aA, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader3.has("exception")) {
                        MessageSharedPrefs.getInstance(m12460a3).f13043b.m12287a("has_register", true);
                    }
                    C3605y.f13390b = false;
                    break;
                case 16388:
                    Application m12460a4 = C3604x.m12460a();
                    JSONObject jSONObject6 = new JSONObject(obj.toString());
                    JSONObject optJSONObject7 = jSONObject6.optJSONObject("jsonHeader");
                    JSONObject optJSONObject8 = jSONObject6.optJSONObject("jsonBody");
                    String optString = jSONObject6.optString("um_px_path");
                    if (optJSONObject7 != null && optJSONObject8 != null) {
                        optJSONObject7.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
                        optJSONObject7.put("din", C3584d.m12351c(C3604x.m12460a()));
                        optJSONObject7.put("push_switch", C3584d.m12372p(C3604x.m12460a()));
                        JSONArray optJSONArray2 = optJSONObject8.optJSONArray("push");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0 && (i4 = (jSONObject = (JSONObject) optJSONArray2.get(0)).optInt("action_type")) == 0) {
                            ((C3561aj) PushAgent.getInstance(m12460a4).getMessageNotifyApi()).m12253a(jSONObject);
                        }
                        JSONObject buildEnvelopeWithExtHeader6 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(m12460a4, optJSONObject7, optJSONObject8, optString, C3351bh.f11576aA, MsgConstant.SDK_VERSION);
                        if (buildEnvelopeWithExtHeader6 != null && !buildEnvelopeWithExtHeader6.has("exception") && i4 != 6 && i4 != 7) {
                            m12453a(m12460a4, optJSONObject8.getJSONArray("push"));
                            break;
                        }
                    }
                    break;
                case 16389:
                    Application m12460a5 = C3604x.m12460a();
                    JSONObject jSONObject7 = new JSONObject(obj.toString());
                    JSONObject optJSONObject9 = jSONObject7.optJSONObject("header");
                    JSONObject optJSONObject10 = jSONObject7.optJSONObject("content");
                    if (optJSONObject9 != null && optJSONObject10 != null && (buildEnvelopeWithExtHeader4 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(m12460a5, optJSONObject9, optJSONObject10, "umpx_push_logs", C3351bh.f11576aA, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader4.has("exception")) {
                        C3605y.m12463a();
                        C3605y.m12467a(optJSONObject10.getJSONArray("push"));
                        break;
                    }
                    break;
                case 16390:
                    JSONObject jSONObject8 = new JSONObject(obj.toString());
                    Application m12460a6 = C3604x.m12460a();
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
                    jSONObject9.put("din", C3584d.m12351c(m12460a6));
                    jSONObject9.put("push_switch", C3584d.m12372p(m12460a6));
                    JSONObject jSONObject10 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    jSONObject8.put("pa", "");
                    jSONObject8.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(m12460a6).getRegistrationId());
                    jSONObject8.put("msg_id", "");
                    jSONObject8.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject8);
                    jSONObject10.put("push", jSONArray);
                    JSONObject buildEnvelopeWithExtHeader7 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(m12460a6, jSONObject9, jSONObject10, "umpx_push_logs", C3351bh.f11576aA, MsgConstant.SDK_VERSION);
                    if (buildEnvelopeWithExtHeader7 != null) {
                        buildEnvelopeWithExtHeader7.has("exception");
                        break;
                    }
                    break;
                case 16391:
                case 16392:
                    Application m12460a7 = C3604x.m12460a();
                    JSONObject jSONObject11 = new JSONObject(obj.toString());
                    JSONObject optJSONObject11 = jSONObject11.optJSONObject("content");
                    JSONObject optJSONObject12 = jSONObject11.optJSONObject("header");
                    if (optJSONObject12 != null && optJSONObject11 != null && (buildEnvelopeWithExtHeader5 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(m12460a7, optJSONObject12, optJSONObject11, "umpx_push_logs", C3351bh.f11576aA, MsgConstant.SDK_VERSION)) != null) {
                        buildEnvelopeWithExtHeader5.has("exception");
                    }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private static void m12453a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    arrayList.add(ContentProviderOperation.newDelete(C3588h.m12405d(context)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                }
                context.getContentResolver().applyBatch(C3588h.m12407f(context), arrayList);
            } catch (Throwable th) {
                UPLog.m12144e("LogDataProtocol", "remove cache error:" + th.getMessage());
            }
        }
    }
}
