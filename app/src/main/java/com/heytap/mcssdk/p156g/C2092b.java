package com.heytap.mcssdk.p156g;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.heytap.mcssdk.C2080a;
import com.heytap.mcssdk.constant.C2086c;
import com.heytap.mcssdk.constant.C2087d;
import com.heytap.mcssdk.p159j.C2100a;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.constant.ConfigConstant;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.NotificationSortMessage;
import com.heytap.msp.push.notification.ISortListener;
import com.heytap.msp.push.notification.PushNotification;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p014u.C0052a;

/* renamed from: com.heytap.mcssdk.g.b */
/* loaded from: classes.dex */
public class C2092b {

    /* renamed from: c */
    private int f6224c;

    /* renamed from: d */
    private int f6225d;

    /* renamed from: f */
    private int f6227f;

    /* renamed from: g */
    private int f6228g;

    /* renamed from: h */
    private StatusBarNotification f6229h;

    /* renamed from: a */
    private int f6222a = 3;

    /* renamed from: b */
    private List<NotificationSortMessage> f6223b = new ArrayList();

    /* renamed from: e */
    private List<String> f6226e = new ArrayList();

    /* renamed from: com.heytap.mcssdk.g.b$a */
    private static class a {

        /* renamed from: a */
        private static final C2092b f6230a = new C2092b();

        private a() {
        }
    }

    /* renamed from: a */
    private int m5820a(List<NotificationSortMessage> list, int i2) {
        int size = list == null ? 0 : list.size();
        if (i2 <= 0 || size == 0) {
            return i2;
        }
        if (size < i2) {
            int i3 = i2 - size;
            list.clear();
            return i3;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            list.remove((size - 1) - i4);
        }
        return 0;
    }

    /* renamed from: a */
    public static C2092b m5821a() {
        return a.f6230a;
    }

    /* renamed from: a */
    private DataMessage m5822a(Context context, NotificationSortMessage notificationSortMessage) {
        DataMessage dataMessage = new DataMessage(context.getPackageName(), notificationSortMessage.getMessageId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C2087d.b.f6193a, C0052a.f159k);
            String statisticData = notificationSortMessage.getStatisticData();
            if (!TextUtils.isEmpty(statisticData)) {
                jSONObject.put(C2087d.b.f6194b, statisticData);
            }
            dataMessage.setStatisticsExtra(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return dataMessage;
    }

    /* renamed from: a */
    private void m5823a(int i2) {
        if (i2 == 7) {
            this.f6224c++;
        } else if (i2 == 5) {
            this.f6225d++;
        }
    }

    /* renamed from: a */
    private void m5824a(NotificationManager notificationManager, Context context, int i2) {
        m5831a(C2091a.m5819a(notificationManager, context.getPackageName()), i2);
    }

    /* renamed from: a */
    private void m5825a(Context context, NotificationManager notificationManager, int i2) {
        m5820a(this.f6223b, i2);
        m5826a(context, notificationManager, this.f6223b);
    }

    /* renamed from: a */
    private void m5826a(Context context, NotificationManager notificationManager, List<NotificationSortMessage> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        m5827a(context, notificationManager, jSONArray, list, arrayList);
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(C2087d.b.f6195c, jSONArray);
                HeytapPushManager.cancelNotification(jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (arrayList.size() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(C2086c.a.f6189g, arrayList);
            StatisticUtils.statisticEvent(context, hashMap);
        }
    }

    /* renamed from: a */
    private void m5827a(Context context, NotificationManager notificationManager, JSONArray jSONArray, List<NotificationSortMessage> list, List<DataMessage> list2) {
        for (NotificationSortMessage notificationSortMessage : list) {
            if (notificationSortMessage.isMcs()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_NOTIFY_ID, notificationSortMessage.getNotifyId());
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            } else {
                list2.add(m5822a(context, notificationSortMessage));
                this.f6226e.add(notificationSortMessage.getMessageId());
            }
            notificationManager.cancel(notificationSortMessage.getNotifyId());
        }
    }

    /* renamed from: a */
    private void m5828a(NotificationSortMessage notificationSortMessage) {
        if (notificationSortMessage.getAutoDelete() != 1) {
            return;
        }
        if (this.f6223b.size() != 0) {
            for (int size = this.f6223b.size() - 1; size >= 0; size--) {
                NotificationSortMessage notificationSortMessage2 = this.f6223b.get(size);
                if (notificationSortMessage.getImportantLevel() >= notificationSortMessage2.getImportantLevel() && notificationSortMessage.getPostTime() >= notificationSortMessage2.getPostTime()) {
                    this.f6223b.add(size + 1, notificationSortMessage2);
                    return;
                }
            }
        }
        this.f6223b.add(0, notificationSortMessage);
    }

    /* renamed from: a */
    private void m5829a(ISortListener iSortListener, boolean z, PushNotification.Builder builder) {
        if (iSortListener != null) {
            iSortListener.buildCompleted(z, builder, this.f6226e);
        }
    }

    /* renamed from: a */
    private void m5830a(PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, notificationSortMessage.getAutoDelete());
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, notificationSortMessage.getImportantLevel());
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
        bundle.putLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, System.currentTimeMillis());
        bundle.putBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, false);
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA, notificationSortMessage.getStatisticData());
        if (Build.VERSION.SDK_INT >= 20) {
            builder.addExtras(bundle);
            builder.setGroup(notificationSortMessage.getGroup());
        }
    }

    /* renamed from: a */
    private void m5831a(StatusBarNotification[] statusBarNotificationArr, int i2) {
        m5836b();
        if (statusBarNotificationArr != null && statusBarNotificationArr.length != 0) {
            for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
                Bundle bundle = statusBarNotification.getNotification().extras;
                boolean z = bundle.getBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, true);
                long j2 = bundle.getLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, statusBarNotification.getPostTime());
                String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
                int i3 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, 1);
                int i4 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, 5);
                String string2 = bundle.getString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA);
                int id = statusBarNotification.getId();
                if (i2 == id) {
                    this.f6229h = statusBarNotification;
                    return;
                }
                NotificationSortMessage notificationSortMessage = new NotificationSortMessage(string, i4, i3, z, j2, id, string2);
                m5837b(i3);
                m5823a(i4);
                m5828a(notificationSortMessage);
            }
        }
        if (C2107g.m5904g()) {
            C2107g.m5884b("initParams : notDelete:" + this.f6228g + " canDelete : " + this.f6227f + "\n highSize : " + this.f6224c + " normalSize :" + this.f6225d + '\n');
            StringBuilder sb = new StringBuilder();
            sb.append("canDeleteList size : ");
            sb.append(this.f6223b.size());
            C2107g.m5884b(sb.toString());
            for (int i5 = 0; i5 < this.f6223b.size(); i5++) {
                NotificationSortMessage notificationSortMessage2 = this.f6223b.get(i5);
                C2107g.m5884b("第" + i5 + "条消息 messageId : " + notificationSortMessage2.getMessageId() + " importanceLevel : " + notificationSortMessage2.getImportantLevel() + " autoDelete : " + notificationSortMessage2.getAutoDelete() + " notifyId: " + notificationSortMessage2.getNotifyId() + " postTime:" + notificationSortMessage2.getPostTime());
            }
        }
    }

    /* renamed from: a */
    private boolean m5832a(NotificationManager notificationManager, Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        StringBuilder sb;
        if (C2107g.m5904g()) {
            C2107g.m5884b("dealCurrentMessage : deleteNumber" + (this.f6227f + this.f6228g) + " keepNumber : " + this.f6222a);
        }
        boolean z = true;
        if (this.f6227f + this.f6228g < this.f6222a) {
            if (notificationSortMessage.getAutoDelete() == -1) {
                sb = new StringBuilder();
                sb.append(C2087d.a.f6191b);
            } else {
                sb = new StringBuilder();
                sb.append(C2087d.a.f6192c);
            }
            sb.append(context.getPackageName());
            notificationSortMessage.setGroup(sb.toString());
        } else if (notificationSortMessage.getAutoDelete() == -1) {
            notificationSortMessage.setGroup(C2087d.a.f6191b + context.getPackageName());
            int i2 = this.f6222a - this.f6228g;
            if (C2107g.m5904g()) {
                C2107g.m5884b("dealCurrentMessage : allowDelete :" + i2);
            }
            if (i2 > 0) {
                m5825a(context, notificationManager, i2 - 1);
            } else {
                Notification m5815a = C2091a.m5815a(context, notificationSortMessage.getGroup(), builder);
                if (m5815a != null) {
                    notificationManager.notify(4096, m5815a);
                }
            }
        } else {
            z = m5833a(context, notificationManager, notificationSortMessage);
        }
        if (C2107g.m5904g()) {
            C2107g.m5884b("dealCurrentMessage : needPost :" + z);
        }
        if (z) {
            m5830a(builder, notificationSortMessage);
        } else {
            C2100a.m5852a(context, C2086c.a.f6188f, m5822a(context, notificationSortMessage));
        }
        return z;
    }

    /* renamed from: a */
    private boolean m5833a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage) {
        int i2 = this.f6228g;
        int i3 = this.f6222a;
        boolean z = false;
        if (i2 >= i3) {
            return false;
        }
        int i4 = i3 - i2;
        if (C2107g.m5904g()) {
            C2107g.m5884b("judgeShowCurrentMessage : allowDelete" + i4);
        }
        if (notificationSortMessage.getImportantLevel() == 7 || (notificationSortMessage.getImportantLevel() != 5 ? this.f6224c + this.f6225d < i4 : this.f6224c < i4)) {
            z = true;
        }
        if (z) {
            m5825a(context, notificationManager, i4 - 1);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m5834a(Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Notification notification;
        StringBuilder sb;
        String str;
        int verifyNotifyId = builder.getVerifyNotifyId();
        StatusBarNotification statusBarNotification = this.f6229h;
        if (statusBarNotification == null || verifyNotifyId == -1 || (notification = statusBarNotification.getNotification()) == null) {
            return false;
        }
        if (notificationSortMessage.getAutoDelete() == 1) {
            sb = new StringBuilder();
            str = C2087d.a.f6192c;
        } else {
            sb = new StringBuilder();
            str = C2087d.a.f6191b;
        }
        sb.append(str);
        sb.append(context.getPackageName());
        notificationSortMessage.setGroup(sb.toString());
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
        m5830a(builder, notificationSortMessage);
        this.f6226e.add(string);
        return true;
    }

    /* renamed from: a */
    private boolean m5835a(PushNotification.Builder builder, int i2, int i3, String str, String str2) {
        Context m5742k = C2080a.m5698w().m5742k();
        if (builder == null || m5742k == null) {
            return false;
        }
        NotificationManager m5816a = C2091a.m5816a(m5742k);
        NotificationSortMessage notificationSortMessage = new NotificationSortMessage(str, i3, i2, false, System.currentTimeMillis(), str2);
        if (!m5839a(m5742k, m5816a, notificationSortMessage, builder)) {
            return true;
        }
        m5824a(m5816a, m5742k, builder.getVerifyNotifyId());
        if (m5834a(m5742k, builder, notificationSortMessage)) {
            return true;
        }
        return m5832a(m5816a, m5742k, builder, notificationSortMessage);
    }

    /* renamed from: b */
    private void m5836b() {
        this.f6227f = 0;
        this.f6228g = 0;
        this.f6224c = 0;
        this.f6225d = 0;
        this.f6223b.clear();
        this.f6226e.clear();
        this.f6229h = null;
    }

    /* renamed from: b */
    private void m5837b(int i2) {
        if (i2 == -1) {
            this.f6228g++;
        } else if (i2 == 1) {
            this.f6227f++;
        }
    }

    /* renamed from: a */
    public void m5838a(PushNotification.Builder builder, ISortListener iSortListener) {
        if (builder == null) {
            return;
        }
        m5829a(iSortListener, m5835a(builder, builder.getAutoDelete(), builder.getImportantLevel(), builder.getMessageId(), builder.getStatisticData()), builder);
    }

    /* renamed from: a */
    public boolean m5839a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage, PushNotification.Builder builder) {
        int i2;
        if (notificationSortMessage.getAutoDelete() == 0 || (i2 = Build.VERSION.SDK_INT) < 24 || i2 >= 30) {
            return false;
        }
        if (!C2091a.m5818a(notificationManager, context.getPackageName(), 4096)) {
            return true;
        }
        notificationSortMessage.setGroup(C2087d.a.f6191b + context.getPackageName());
        m5830a(builder, notificationSortMessage);
        return false;
    }
}
