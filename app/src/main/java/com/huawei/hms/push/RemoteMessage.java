package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: c */
    private static final String[] f7699c;

    /* renamed from: d */
    private static final int[] f7700d;

    /* renamed from: e */
    private static final long[] f7701e;

    /* renamed from: f */
    private static final HashMap<String, Object> f7702f;

    /* renamed from: g */
    private static final HashMap<String, Object> f7703g;

    /* renamed from: h */
    private static final HashMap<String, Object> f7704h;

    /* renamed from: i */
    private static final HashMap<String, Object> f7705i;

    /* renamed from: j */
    private static final HashMap<String, Object> f7706j;

    /* renamed from: a */
    private Bundle f7707a;

    /* renamed from: b */
    private Notification f7708b;

    public static class Builder {

        /* renamed from: a */
        private final Bundle f7709a;

        /* renamed from: b */
        private final Map<String, String> f7710b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f7709a = bundle;
            this.f7710b = new HashMap();
            bundle.putString("to", str);
        }

        public Builder addData(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("add data failed, key is null.");
            }
            this.f7710b.put(str, str2);
            return this;
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f7710b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String jSONObject2 = jSONObject.toString();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(RemoteMessageConst.COLLAPSE_KEY, this.f7709a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject3.put(RemoteMessageConst.TTL, this.f7709a.getInt(RemoteMessageConst.TTL));
                    jSONObject3.put(RemoteMessageConst.SEND_MODE, this.f7709a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject3.put(RemoteMessageConst.RECEIPT_MODE, this.f7709a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put("data", jSONObject2);
                    }
                    jSONObject4.put(RemoteMessageConst.MSGID, this.f7709a.getString(RemoteMessageConst.MSGID));
                    jSONObject3.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(C2493m.f7752a));
                    bundle.putString("to", this.f7709a.getString("to"));
                    bundle.putString("message_type", this.f7709a.getString("message_type"));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.m7718w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.m7718w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f7710b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f7709a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f7710b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f7710b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f7709a.putString(RemoteMessageConst.MSGID, str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f7709a.putString("message_type", str);
            return this;
        }

        public Builder setReceiptMode(int i2) {
            if (i2 != 1 && i2 != 0) {
                throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.f7709a.putInt(RemoteMessageConst.RECEIPT_MODE, i2);
            return this;
        }

        public Builder setSendMode(int i2) {
            if (i2 != 0 && i2 != 1) {
                throw new IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.f7709a.putInt(RemoteMessageConst.SEND_MODE, i2);
            return this;
        }

        public Builder setTtl(int i2) {
            if (i2 < 1 || i2 > 1296000) {
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.f7709a.putInt(RemoteMessageConst.TTL, i2);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements Serializable {

        /* renamed from: A */
        private final long[] f7711A;

        /* renamed from: B */
        private final String f7712B;

        /* renamed from: a */
        private final String f7713a;

        /* renamed from: b */
        private final String f7714b;

        /* renamed from: c */
        private final String[] f7715c;

        /* renamed from: d */
        private final String f7716d;

        /* renamed from: e */
        private final String f7717e;

        /* renamed from: f */
        private final String[] f7718f;

        /* renamed from: g */
        private final String f7719g;

        /* renamed from: h */
        private final String f7720h;

        /* renamed from: i */
        private final String f7721i;

        /* renamed from: j */
        private final String f7722j;

        /* renamed from: k */
        private final String f7723k;

        /* renamed from: l */
        private final String f7724l;

        /* renamed from: m */
        private final String f7725m;

        /* renamed from: n */
        private final Uri f7726n;

        /* renamed from: o */
        private final int f7727o;

        /* renamed from: p */
        private final String f7728p;

        /* renamed from: q */
        private final int f7729q;

        /* renamed from: r */
        private final int f7730r;

        /* renamed from: s */
        private final int f7731s;

        /* renamed from: t */
        private final int[] f7732t;

        /* renamed from: u */
        private final String f7733u;

        /* renamed from: v */
        private final int f7734v;

        /* renamed from: w */
        private final String f7735w;

        /* renamed from: x */
        private final int f7736x;

        /* renamed from: y */
        private final String f7737y;

        /* renamed from: z */
        private final String f7738z;

        /* synthetic */ Notification(Bundle bundle, C2480a c2480a) {
            this(bundle);
        }

        /* renamed from: a */
        private Integer m7535a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.m7718w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return m7535a(this.f7735w);
        }

        public String getBody() {
            return this.f7716d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f7718f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f7717e;
        }

        public String getChannelId() {
            return this.f7725m;
        }

        public String getClickAction() {
            return this.f7723k;
        }

        public String getColor() {
            return this.f7722j;
        }

        public String getIcon() {
            return this.f7719g;
        }

        public Uri getImageUrl() {
            String str = this.f7728p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return m7535a(this.f7737y);
        }

        public String getIntentUri() {
            return this.f7724l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.f7732t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f7726n;
        }

        public int getNotifyId() {
            return this.f7727o;
        }

        public String getSound() {
            return this.f7720h;
        }

        public String getTag() {
            return this.f7721i;
        }

        public String getTicker() {
            return this.f7738z;
        }

        public String getTitle() {
            return this.f7713a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f7715c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f7714b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.f7711A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return m7535a(this.f7712B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.f7733u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f7733u));
                } catch (StringIndexOutOfBoundsException unused) {
                    HMSLog.m7718w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (ParseException unused2) {
                    HMSLog.m7718w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.f7736x == 1;
        }

        public boolean isDefaultLight() {
            return this.f7729q == 1;
        }

        public boolean isDefaultSound() {
            return this.f7730r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f7731s == 1;
        }

        public boolean isLocalOnly() {
            return this.f7734v == 1;
        }

        private Notification(Bundle bundle) {
            this.f7713a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f7716d = bundle.getString("content");
            this.f7714b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f7717e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f7715c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f7718f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f7719g = bundle.getString(RemoteMessageConst.Notification.ICON);
            this.f7722j = bundle.getString(RemoteMessageConst.Notification.COLOR);
            this.f7720h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f7721i = bundle.getString("tag");
            this.f7725m = bundle.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f7723k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f7724l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f7727o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.f7726n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f7728p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f7729q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f7730r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f7731s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f7732t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f7733u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f7734v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f7735w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.f7736x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f7737y = bundle.getString(RemoteMessageConst.Notification.PRIORITY, null);
            this.f7738z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.f7711A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.f7712B = bundle.getString(RemoteMessageConst.Notification.VISIBILITY, null);
        }
    }

    /* renamed from: com.huawei.hms.push.RemoteMessage$a */
    class C2480a implements Parcelable.Creator<RemoteMessage> {
        C2480a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage[] newArray(int i2) {
            return new RemoteMessage[i2];
        }
    }

    static {
        String[] strArr = new String[0];
        f7699c = strArr;
        int[] iArr = new int[0];
        f7700d = iArr;
        long[] jArr = new long[0];
        f7701e = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(8);
        f7702f = hashMap;
        hashMap.put("from", "");
        hashMap.put(RemoteMessageConst.COLLAPSE_KEY, "");
        hashMap.put(RemoteMessageConst.SEND_TIME, "");
        hashMap.put(RemoteMessageConst.TTL, Integer.valueOf(RemoteMessageConst.DEFAULT_TTL));
        hashMap.put(RemoteMessageConst.URGENCY, 2);
        hashMap.put(RemoteMessageConst.ORI_URGENCY, 2);
        hashMap.put(RemoteMessageConst.SEND_MODE, 0);
        hashMap.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        f7703g = hashMap2;
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.TICKER, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f7704h = hashMap3;
        hashMap3.put(RemoteMessageConst.Notification.ICON, "");
        hashMap3.put(RemoteMessageConst.Notification.COLOR, "");
        hashMap3.put(RemoteMessageConst.Notification.SOUND, "");
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        f7705i = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put(RemoteMessageConst.Notification.WHEN, "");
        hashMap4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        hashMap4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        hashMap4.put(RemoteMessageConst.Notification.PRIORITY, "");
        hashMap4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        hashMap4.put(RemoteMessageConst.Notification.VISIBILITY, "");
        hashMap4.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        f7706j = hashMap5;
        hashMap5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        hashMap5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        hashMap5.put("url", "");
        CREATOR = new C2480a();
    }

    public RemoteMessage(Bundle bundle) {
        this.f7707a = m7528a(bundle);
    }

    /* renamed from: a */
    private Bundle m7528a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject m7531b = m7531b(bundle);
        JSONObject m7530a = m7530a(m7531b);
        String string = JsonUtil.getString(m7530a, "data", null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(m7530a, RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject m7534d = m7534d(m7530a);
        JSONObject m7532b = m7532b(m7534d);
        JSONObject m7533c = m7533c(m7534d);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && AbstractC2484d.m7545a(m7530a, m7534d, string)) {
            bundle2.putString("data", AbstractC2481a.m7538a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        String string2 = bundle.getString("to");
        String string3 = bundle.getString("message_type");
        String string4 = JsonUtil.getString(m7530a, RemoteMessageConst.MSGID, null);
        bundle2.putString("to", string2);
        bundle2.putString("data", string);
        bundle2.putString(RemoteMessageConst.MSGID, string4);
        bundle2.putString("message_type", string3);
        JsonUtil.transferJsonObjectToBundle(m7531b, bundle2, f7702f);
        bundle2.putBundle("notification", m7529a(m7531b, m7530a, m7534d, m7532b, m7533c));
        return bundle2;
    }

    /* renamed from: b */
    private static JSONObject m7531b(Bundle bundle) {
        try {
            return new JSONObject(AbstractC2481a.m7538a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.m7718w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* renamed from: c */
    private static JSONObject m7533c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    /* renamed from: d */
    private static JSONObject m7534d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f7707a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap hashMap = new HashMap();
        String string = this.f7707a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.m7718w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return hashMap;
    }

    public String getCollapseKey() {
        return this.f7707a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f7707a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.f7707a.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.m7718w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.f7707a.getString("from");
    }

    public String getMessageId() {
        return this.f7707a.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f7707a.getString("message_type");
    }

    public Notification getNotification() {
        Bundle bundle = this.f7707a.getBundle("notification");
        C2480a c2480a = null;
        if (this.f7708b == null && bundle != null) {
            this.f7708b = new Notification(bundle, c2480a);
        }
        if (this.f7708b == null) {
            this.f7708b = new Notification(new Bundle(), c2480a);
        }
        return this.f7708b;
    }

    public int getOriginalUrgency() {
        int i2 = this.f7707a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f7707a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f7707a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f7707a.getString(RemoteMessageConst.SEND_TIME);
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            HMSLog.m7718w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public String getTo() {
        return this.f7707a.getString("to");
    }

    public String getToken() {
        return this.f7707a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f7707a.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i2 = this.f7707a.getInt(RemoteMessageConst.URGENCY);
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f7707a);
        parcel.writeSerializable(this.f7708b);
    }

    public RemoteMessage(Parcel parcel) {
        this.f7707a = parcel.readBundle();
        this.f7708b = (Notification) parcel.readSerializable();
    }

    /* renamed from: b */
    private static JSONObject m7532b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    /* renamed from: a */
    private Bundle m7529a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f7703g);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f7704h);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f7705i);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f7706j);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    /* renamed from: a */
    private static JSONObject m7530a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
