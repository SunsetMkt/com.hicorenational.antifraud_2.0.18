package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4300j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.service.ac */
/* loaded from: classes2.dex */
public class C4351ac {

    /* renamed from: a */
    private static final boolean f16495a = Log.isLoggable("NCHelper", 3);

    @TargetApi(26)
    /* renamed from: a */
    private static void m15836a(C4354af c4354af, NotificationChannel notificationChannel, String str) {
        int i2;
        char c2;
        int i3;
        char c3;
        Context m15887a = c4354af.m15887a();
        String id = notificationChannel.getId();
        String m15877a = C4354af.m15877a(id, c4354af.m15888a());
        if (f16495a) {
            m15837a("appChannelId:" + id + " oldChannelId:" + m15877a);
        }
        boolean z = true;
        if (C4300j.m15681a(m15887a) && !TextUtils.equals(id, m15877a)) {
            NotificationManager notificationManager = (NotificationManager) m15887a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(m15877a);
            NotificationChannel m15886a = c4354af.m15886a(id);
            if (f16495a) {
                m15837a("xmsfChannel:" + notificationChannel2);
                m15837a("appChannel:" + m15886a);
            }
            if (notificationChannel2 != null) {
                NotificationChannel m15829a = m15829a(id, notificationChannel2);
                if (f16495a) {
                    m15837a("copyXmsf copyXmsfChannel:" + m15829a);
                }
                if (m15886a != null) {
                    i3 = m15828a(m15886a);
                    c4354af.m15894a(m15829a, i3 == 0);
                    c3 = 3;
                } else {
                    int m15828a = m15828a(notificationChannel2);
                    m15832a(m15887a, c4354af, m15829a, m15828a, notificationChannel2.getId());
                    i3 = m15828a;
                    c3 = 4;
                }
                m15840b(m15887a, id);
                notificationManager.deleteNotificationChannel(m15877a);
                i2 = i3;
                c2 = c3;
            } else if (m15886a == null) {
                if (f16495a) {
                    m15837a("appHack createNotificationChannel:" + notificationChannel);
                }
                c4354af.m15893a(notificationChannel);
                i2 = 0;
                c2 = 1;
            } else if (!m15839a(m15887a, id) && m15838a(notificationChannel, m15886a)) {
                if (f16495a) {
                    m15837a("appHack updateNotificationChannel:" + notificationChannel);
                }
                i2 = m15828a(m15886a);
                c4354af.m15894a(notificationChannel, i2 == 0);
                c2 = 2;
            }
            if (c2 != 1 && c2 != 4 && c2 != 3) {
                z = false;
            }
            C4383f.m16086a(c4354af.m15887a(), c4354af.m15888a(), id, notificationChannel.getImportance(), str, z, i2);
        }
        NotificationChannel m15886a2 = c4354af.m15886a(id);
        if (f16495a) {
            m15837a("elseLogic getNotificationChannel:" + m15886a2);
        }
        if (m15886a2 == null) {
            c4354af.m15893a(notificationChannel);
        }
        i2 = 0;
        c2 = 0;
        if (c2 != 1) {
            z = false;
        }
        C4383f.m16086a(c4354af.m15887a(), c4354af.m15888a(), id, notificationChannel.getImportance(), str, z, i2);
    }

    /* renamed from: b */
    private static void m15840b(Context context, String str) {
        if (f16495a) {
            m15837a("recordCopiedChannel:" + str);
        }
        m15830a(context).edit().putBoolean(str, true).apply();
    }

    /* renamed from: c */
    private static void m15841c(Context context, String str) {
        try {
            C4354af m15874a = C4354af.m15874a(context, str);
            Set<String> keySet = m15830a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (m15874a.m15895a(str2)) {
                    arrayList.add(str2);
                    if (f16495a) {
                        m15837a("delete channel copy record:" + str2);
                    }
                }
            }
            m15834a(context, arrayList);
        } catch (Exception unused) {
        }
    }

    @TargetApi(26)
    /* renamed from: a */
    private static boolean m15838a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (f16495a) {
                m15837a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f16495a) {
                m15837a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f16495a) {
                m15837a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + AbstractC1191a.f2568g + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f16495a) {
                m15837a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f16495a) {
                m15837a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (f16495a) {
                m15837a("appHack channelConfigLowerCompare:setSound");
            }
            z = true;
        }
        if (f16495a) {
            m15837a("appHack channelConfigLowerCompare:isDifferent:" + z);
        }
        return z;
    }

    /* renamed from: a */
    private static int m15828a(NotificationChannel notificationChannel) {
        int i2 = 0;
        try {
            i2 = ((Integer) C4094aw.m13831b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (f16495a) {
                m15837a("isUserLockedChannel:" + i2 + AbstractC1191a.f2568g + notificationChannel);
            }
        } catch (Exception e2) {
            AbstractC4022b.m13348a("NCHelper", "is user locked error" + e2);
        }
        return i2;
    }

    @TargetApi(26)
    /* renamed from: a */
    private static NotificationChannel m15829a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    /* renamed from: a */
    private static boolean m15839a(Context context, String str) {
        if (f16495a) {
            m15837a("checkCopeidChannel:newFullChannelId:" + str + "  " + m15830a(context).getBoolean(str, false));
        }
        return m15830a(context).getBoolean(str, false);
    }

    /* renamed from: a */
    private static void m15834a(Context context, List<String> list) {
        if (f16495a) {
            m15837a("deleteCopiedChannelRecord:" + list);
        }
        if (list.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = m15830a(context).edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.apply();
    }

    /* renamed from: a */
    private static SharedPreferences m15830a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    /* renamed from: a */
    public static String m15831a(C4354af c4354af, String str, CharSequence charSequence, String str2, int i2, int i3, String str3, String str4) {
        String m15889a = c4354af.m15889a(str);
        if (f16495a) {
            m15837a("createChannel: appChannelId:" + m15889a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i2 + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i3 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(m15889a, charSequence, i3);
        notificationChannel.setDescription(str2);
        notificationChannel.enableVibration((i2 & 2) != 0);
        notificationChannel.enableLights((i2 & 4) != 0);
        if ((i2 & 1) != 0) {
            if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("android.resource://" + c4354af.m15888a())) {
                    notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
        } else {
            notificationChannel.setSound(null, null);
        }
        if (f16495a) {
            m15837a("create channel:" + notificationChannel);
        }
        m15836a(c4354af, notificationChannel, str4);
        return m15889a;
    }

    /* renamed from: a */
    private static void m15837a(String str) {
        AbstractC4022b.m13348a("NCHelper", str);
    }

    /* renamed from: a */
    public static void m15833a(Context context, String str) {
        if (!C4300j.m15681a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        m15841c(context, str);
        C4383f.m16085a(context, str);
    }

    /* renamed from: a */
    static void m15835a(C4252gs c4252gs) {
        Map<String, String> map;
        if (c4252gs == null || (map = c4252gs.f15842a) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        c4252gs.f15838a = 0;
        c4252gs.f15842a.remove("channel_id");
        c4252gs.f15842a.remove("channel_importance");
        c4252gs.f15842a.remove("channel_name");
        c4252gs.f15842a.remove("channel_description");
        c4252gs.f15842a.remove("channel_perm");
        AbstractC4022b.m13347a("delete channel info by:" + c4252gs.f15842a.get("REMOVE_CHANNEL_MARK"));
        c4252gs.f15842a.remove("REMOVE_CHANNEL_MARK");
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    /* renamed from: a */
    static void m15832a(Context context, C4354af c4354af, NotificationChannel notificationChannel, int i2, String str) {
        if (i2 > 0) {
            int m16081a = C4233g.m14924a(context) >= 2 ? C4383f.m16081a(context.getPackageName(), str) : 0;
            NotificationChannel m15829a = m15829a(notificationChannel.getId(), notificationChannel);
            if ((i2 & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    m15829a.setSound(null, null);
                } else {
                    m15829a.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i2 & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    m15829a.enableVibration(false);
                } else {
                    m15829a.enableVibration(true);
                }
            }
            if ((i2 & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    m15829a.enableLights(false);
                } else {
                    m15829a.enableLights(true);
                }
            }
            if ((i2 & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                m15829a.setImportance(importance);
            }
            if ((i2 & 2) != 0) {
                m15829a.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            c4354af.m15893a(m15829a);
            c4354af.m15894a(notificationChannel, true);
            C4383f.m16091a(c4354af.m15888a(), notificationChannel.getId(), m16081a, 0);
            return;
        }
        c4354af.m15893a(notificationChannel);
    }
}
