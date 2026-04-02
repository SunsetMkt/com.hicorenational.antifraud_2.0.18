package com.heytap.mcssdk.g;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.c;
import com.heytap.mcssdk.constant.d;
import com.heytap.mcssdk.k.g;
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

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3935d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private StatusBarNotification f3939h;
    private int a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<NotificationSortMessage> f3933b = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f3936e = new ArrayList();

    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    private int a(List<NotificationSortMessage> list, int i2) {
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

    public static b a() {
        return a.a;
    }

    private DataMessage a(Context context, NotificationSortMessage notificationSortMessage) {
        DataMessage dataMessage = new DataMessage(context.getPackageName(), notificationSortMessage.getMessageId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.b.a, b.a.u.a.f1909k);
            String statisticData = notificationSortMessage.getStatisticData();
            if (!TextUtils.isEmpty(statisticData)) {
                jSONObject.put(d.b.f3911b, statisticData);
            }
            dataMessage.setStatisticsExtra(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return dataMessage;
    }

    private void a(int i2) {
        if (i2 == 7) {
            this.f3934c++;
        } else if (i2 == 5) {
            this.f3935d++;
        }
    }

    private void a(NotificationManager notificationManager, Context context, int i2) {
        a(com.heytap.mcssdk.g.a.a(notificationManager, context.getPackageName()), i2);
    }

    private void a(Context context, NotificationManager notificationManager, int i2) {
        a(this.f3933b, i2);
        a(context, notificationManager, this.f3933b);
    }

    private void a(Context context, NotificationManager notificationManager, List<NotificationSortMessage> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        a(context, notificationManager, jSONArray, list, arrayList);
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(d.b.f3912c, jSONArray);
                HeytapPushManager.cancelNotification(jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (arrayList.size() != 0) {
            HashMap map = new HashMap();
            map.put(c.a.f3908g, arrayList);
            StatisticUtils.statisticEvent(context, map);
        }
    }

    private void a(Context context, NotificationManager notificationManager, JSONArray jSONArray, List<NotificationSortMessage> list, List<DataMessage> list2) {
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
                list2.add(a(context, notificationSortMessage));
                this.f3936e.add(notificationSortMessage.getMessageId());
            }
            notificationManager.cancel(notificationSortMessage.getNotifyId());
        }
    }

    private void a(NotificationSortMessage notificationSortMessage) {
        if (notificationSortMessage.getAutoDelete() != 1) {
            return;
        }
        if (this.f3933b.size() != 0) {
            for (int size = this.f3933b.size() - 1; size >= 0; size--) {
                NotificationSortMessage notificationSortMessage2 = this.f3933b.get(size);
                if (notificationSortMessage.getImportantLevel() >= notificationSortMessage2.getImportantLevel() && notificationSortMessage.getPostTime() >= notificationSortMessage2.getPostTime()) {
                    this.f3933b.add(size + 1, notificationSortMessage2);
                    return;
                }
            }
        }
        this.f3933b.add(0, notificationSortMessage);
    }

    private void a(ISortListener iSortListener, boolean z, PushNotification.Builder builder) {
        if (iSortListener != null) {
            iSortListener.buildCompleted(z, builder, this.f3936e);
        }
    }

    private void a(PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
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

    private void a(StatusBarNotification[] statusBarNotificationArr, int i2) {
        b();
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
                    this.f3939h = statusBarNotification;
                    return;
                }
                NotificationSortMessage notificationSortMessage = new NotificationSortMessage(string, i4, i3, z, j2, id, string2);
                b(i3);
                a(i4);
                a(notificationSortMessage);
            }
        }
        if (g.g()) {
            g.b("initParams : notDelete:" + this.f3938g + " canDelete : " + this.f3937f + "\n highSize : " + this.f3934c + " normalSize :" + this.f3935d + '\n');
            StringBuilder sb = new StringBuilder();
            sb.append("canDeleteList size : ");
            sb.append(this.f3933b.size());
            g.b(sb.toString());
            for (int i5 = 0; i5 < this.f3933b.size(); i5++) {
                NotificationSortMessage notificationSortMessage2 = this.f3933b.get(i5);
                g.b("\u7b2c" + i5 + "\u6761\u6d88\u606f messageId : " + notificationSortMessage2.getMessageId() + " importanceLevel : " + notificationSortMessage2.getImportantLevel() + " autoDelete : " + notificationSortMessage2.getAutoDelete() + " notifyId: " + notificationSortMessage2.getNotifyId() + " postTime:" + notificationSortMessage2.getPostTime());
            }
        }
    }

    private boolean a(NotificationManager notificationManager, Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        StringBuilder sb;
        if (g.g()) {
            g.b("dealCurrentMessage : deleteNumber" + (this.f3937f + this.f3938g) + " keepNumber : " + this.a);
        }
        boolean zA = true;
        if (this.f3937f + this.f3938g < this.a) {
            if (notificationSortMessage.getAutoDelete() == -1) {
                sb = new StringBuilder();
                sb.append(d.a.f3909b);
            } else {
                sb = new StringBuilder();
                sb.append(d.a.f3910c);
            }
            sb.append(context.getPackageName());
            notificationSortMessage.setGroup(sb.toString());
        } else if (notificationSortMessage.getAutoDelete() == -1) {
            notificationSortMessage.setGroup(d.a.f3909b + context.getPackageName());
            int i2 = this.a - this.f3938g;
            if (g.g()) {
                g.b("dealCurrentMessage : allowDelete :" + i2);
            }
            if (i2 > 0) {
                a(context, notificationManager, i2 - 1);
            } else {
                Notification notificationA = com.heytap.mcssdk.g.a.a(context, notificationSortMessage.getGroup(), builder);
                if (notificationA != null) {
                    notificationManager.notify(4096, notificationA);
                }
            }
        } else {
            zA = a(context, notificationManager, notificationSortMessage);
        }
        if (g.g()) {
            g.b("dealCurrentMessage : needPost :" + zA);
        }
        if (zA) {
            a(builder, notificationSortMessage);
        } else {
            com.heytap.mcssdk.j.a.a(context, c.a.f3907f, a(context, notificationSortMessage));
        }
        return zA;
    }

    private boolean a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage) {
        int i2 = this.f3938g;
        int i3 = this.a;
        boolean z = false;
        if (i2 >= i3) {
            return false;
        }
        int i4 = i3 - i2;
        if (g.g()) {
            g.b("judgeShowCurrentMessage : allowDelete" + i4);
        }
        if (notificationSortMessage.getImportantLevel() == 7 || (notificationSortMessage.getImportantLevel() != 5 ? this.f3934c + this.f3935d < i4 : this.f3934c < i4)) {
            z = true;
        }
        if (z) {
            a(context, notificationManager, i4 - 1);
        }
        return z;
    }

    private boolean a(Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Notification notification;
        StringBuilder sb;
        String str;
        int verifyNotifyId = builder.getVerifyNotifyId();
        StatusBarNotification statusBarNotification = this.f3939h;
        if (statusBarNotification == null || verifyNotifyId == -1 || (notification = statusBarNotification.getNotification()) == null) {
            return false;
        }
        if (notificationSortMessage.getAutoDelete() == 1) {
            sb = new StringBuilder();
            str = d.a.f3910c;
        } else {
            sb = new StringBuilder();
            str = d.a.f3909b;
        }
        sb.append(str);
        sb.append(context.getPackageName());
        notificationSortMessage.setGroup(sb.toString());
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
        a(builder, notificationSortMessage);
        this.f3936e.add(string);
        return true;
    }

    private boolean a(PushNotification.Builder builder, int i2, int i3, String str, String str2) {
        Context contextK = com.heytap.mcssdk.a.w().k();
        if (builder == null || contextK == null) {
            return false;
        }
        NotificationManager notificationManagerA = com.heytap.mcssdk.g.a.a(contextK);
        NotificationSortMessage notificationSortMessage = new NotificationSortMessage(str, i3, i2, false, System.currentTimeMillis(), str2);
        if (!a(contextK, notificationManagerA, notificationSortMessage, builder)) {
            return true;
        }
        a(notificationManagerA, contextK, builder.getVerifyNotifyId());
        if (a(contextK, builder, notificationSortMessage)) {
            return true;
        }
        return a(notificationManagerA, contextK, builder, notificationSortMessage);
    }

    private void b() {
        this.f3937f = 0;
        this.f3938g = 0;
        this.f3934c = 0;
        this.f3935d = 0;
        this.f3933b.clear();
        this.f3936e.clear();
        this.f3939h = null;
    }

    private void b(int i2) {
        if (i2 == -1) {
            this.f3938g++;
        } else if (i2 == 1) {
            this.f3937f++;
        }
    }

    public void a(PushNotification.Builder builder, ISortListener iSortListener) {
        if (builder == null) {
            return;
        }
        a(iSortListener, a(builder, builder.getAutoDelete(), builder.getImportantLevel(), builder.getMessageId(), builder.getStatisticData()), builder);
    }

    public boolean a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage, PushNotification.Builder builder) {
        int i2;
        if (notificationSortMessage.getAutoDelete() == 0 || (i2 = Build.VERSION.SDK_INT) < 24 || i2 >= 30) {
            return false;
        }
        if (!com.heytap.mcssdk.g.a.a(notificationManager, context.getPackageName(), 4096)) {
            return true;
        }
        notificationSortMessage.setGroup(d.a.f3909b + context.getPackageName());
        a(builder, notificationSortMessage);
        return false;
    }
}
