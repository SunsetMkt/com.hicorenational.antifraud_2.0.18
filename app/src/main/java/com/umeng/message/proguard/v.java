package com.umeng.message.proguard;

import android.app.Application;
import android.content.ContentProviderOperation;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class v implements UMLogDataProtocol {

    /* renamed from: a, reason: collision with root package name */
    private static final UMLogDataProtocol f11457a = new v();

    private v() {
    }

    public static UMLogDataProtocol a() {
        return f11457a;
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
            Application a2 = x.a();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            JSONArray optJSONArray = optJSONObject.optJSONArray("push");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                    arrayList.add(ContentProviderOperation.newDelete(h.d(a2)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                }
            }
            a2.getContentResolver().applyBatch(h.f(a2), arrayList);
        } catch (Throwable th) {
            UPLog.e("LogDataProtocol", th);
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
                    Application a2 = x.a();
                    JSONObject jSONObject2 = new JSONObject(obj.toString());
                    JSONObject optJSONObject = jSONObject2.optJSONObject("content");
                    if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("push")) == null || optJSONArray.length() <= 0) {
                        i3 = -1;
                    } else {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray.get(0);
                        i3 = jSONObject3.optInt("action_type");
                        if (i3 != 70 && i3 != 71) {
                            if (i3 == 0) {
                                ((aj) PushAgent.getInstance(a2).getMessageNotifyApi()).a(jSONObject3);
                            }
                            ao.a(a2).a(jSONObject3.optString("msg_id"), i3, jSONObject3.optLong("ts"));
                        }
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("header");
                    if (optJSONObject2 == null || optJSONObject == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a2, optJSONObject2, optJSONObject, "umpx_push_logs", bh.aA, MsgConstant.SDK_VERSION)) == null || buildEnvelopeWithExtHeader.has("exception") || i3 == 70 || i3 == 71) {
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
                    Application a3 = x.a();
                    JSONObject jSONObject4 = new JSONObject(obj.toString());
                    JSONObject optJSONObject3 = jSONObject4.optJSONObject("header");
                    JSONObject optJSONObject4 = jSONObject4.optJSONObject("content");
                    if (optJSONObject3 != null && optJSONObject4 != null && (buildEnvelopeWithExtHeader2 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a3, optJSONObject3, optJSONObject4, "umpx_push_launch", bh.aA, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader2.has("exception")) {
                        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a3);
                        messageSharedPrefs.f11128b.a(com.umeng.analytics.pro.d.p, System.currentTimeMillis());
                        try {
                            int parseInt = Integer.parseInt(UMEnvelopeBuild.imprintProperty(a3, "launch_policy", "-1"));
                            UPLog.i("LogDataProtocol", "launch policy:", Integer.valueOf(parseInt));
                            if (parseInt > 0) {
                                messageSharedPrefs.f11128b.a("launch_send_policy", parseInt);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            int parseInt2 = Integer.parseInt(UMEnvelopeBuild.imprintProperty(a3, "tag_policy", "-1"));
                            UPLog.i("LogDataProtocol", "tag policy:", Integer.valueOf(parseInt2));
                            if (parseInt2 > 0) {
                                messageSharedPrefs.f11128b.a("tag_send_policy", parseInt2);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                    y.f11461a = false;
                    break;
                case 16387:
                    Application a4 = x.a();
                    JSONObject jSONObject5 = new JSONObject(obj.toString());
                    JSONObject optJSONObject5 = jSONObject5.optJSONObject("header");
                    JSONObject optJSONObject6 = jSONObject5.optJSONObject("content");
                    if (optJSONObject5 != null && optJSONObject6 != null && (buildEnvelopeWithExtHeader3 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a4, optJSONObject5, optJSONObject6, "umpx_push_register", bh.aA, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader3.has("exception")) {
                        MessageSharedPrefs.getInstance(a4).f11128b.a("has_register", true);
                    }
                    y.f11462b = false;
                    break;
                case 16388:
                    Application a5 = x.a();
                    JSONObject jSONObject6 = new JSONObject(obj.toString());
                    JSONObject optJSONObject7 = jSONObject6.optJSONObject("jsonHeader");
                    JSONObject optJSONObject8 = jSONObject6.optJSONObject("jsonBody");
                    String optString = jSONObject6.optString("um_px_path");
                    if (optJSONObject7 != null && optJSONObject8 != null) {
                        optJSONObject7.put(bh.aO, MsgConstant.SDK_VERSION);
                        optJSONObject7.put("din", d.c(x.a()));
                        optJSONObject7.put("push_switch", d.p(x.a()));
                        JSONArray optJSONArray2 = optJSONObject8.optJSONArray("push");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0 && (i4 = (jSONObject = (JSONObject) optJSONArray2.get(0)).optInt("action_type")) == 0) {
                            ((aj) PushAgent.getInstance(a5).getMessageNotifyApi()).a(jSONObject);
                        }
                        JSONObject buildEnvelopeWithExtHeader6 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a5, optJSONObject7, optJSONObject8, optString, bh.aA, MsgConstant.SDK_VERSION);
                        if (buildEnvelopeWithExtHeader6 != null && !buildEnvelopeWithExtHeader6.has("exception") && i4 != 6 && i4 != 7) {
                            a(a5, optJSONObject8.getJSONArray("push"));
                            break;
                        }
                    }
                    break;
                case 16389:
                    Application a6 = x.a();
                    JSONObject jSONObject7 = new JSONObject(obj.toString());
                    JSONObject optJSONObject9 = jSONObject7.optJSONObject("header");
                    JSONObject optJSONObject10 = jSONObject7.optJSONObject("content");
                    if (optJSONObject9 != null && optJSONObject10 != null && (buildEnvelopeWithExtHeader4 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a6, optJSONObject9, optJSONObject10, "umpx_push_logs", bh.aA, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader4.has("exception")) {
                        y.a();
                        y.a(optJSONObject10.getJSONArray("push"));
                        break;
                    }
                    break;
                case 16390:
                    JSONObject jSONObject8 = new JSONObject(obj.toString());
                    Application a7 = x.a();
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put(bh.aO, MsgConstant.SDK_VERSION);
                    jSONObject9.put("din", d.c(a7));
                    jSONObject9.put("push_switch", d.p(a7));
                    JSONObject jSONObject10 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    jSONObject8.put("pa", "");
                    jSONObject8.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(a7).getRegistrationId());
                    jSONObject8.put("msg_id", "");
                    jSONObject8.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject8);
                    jSONObject10.put("push", jSONArray);
                    JSONObject buildEnvelopeWithExtHeader7 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a7, jSONObject9, jSONObject10, "umpx_push_logs", bh.aA, MsgConstant.SDK_VERSION);
                    if (buildEnvelopeWithExtHeader7 != null) {
                        buildEnvelopeWithExtHeader7.has("exception");
                        break;
                    }
                    break;
                case 16391:
                case 16392:
                    Application a8 = x.a();
                    JSONObject jSONObject11 = new JSONObject(obj.toString());
                    JSONObject optJSONObject11 = jSONObject11.optJSONObject("content");
                    JSONObject optJSONObject12 = jSONObject11.optJSONObject("header");
                    if (optJSONObject12 != null && optJSONObject11 != null && (buildEnvelopeWithExtHeader5 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a8, optJSONObject12, optJSONObject11, "umpx_push_logs", bh.aA, MsgConstant.SDK_VERSION)) != null) {
                        buildEnvelopeWithExtHeader5.has("exception");
                    }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    arrayList.add(ContentProviderOperation.newDelete(h.d(context)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                }
                context.getContentResolver().applyBatch(h.f(context), arrayList);
            } catch (Throwable th) {
                UPLog.e("LogDataProtocol", "remove cache error:" + th.getMessage());
            }
        }
    }
}
