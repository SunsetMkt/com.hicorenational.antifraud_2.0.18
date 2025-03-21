package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.AbstractC4302l;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4085an;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4287i;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4411z;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4244gk;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.service.C4356ah;
import com.xiaomi.push.service.C4358aj;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.w */
/* loaded from: classes2.dex */
public class C4069w {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static String m13685c(List<String> list) {
        String m13879a = C4100bb.m13879a(m13686d(list));
        return (TextUtils.isEmpty(m13879a) || m13879a.length() <= 4) ? "" : m13879a.substring(0, 4).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m13686d(List<String> list) {
        String str = "";
        if (C4411z.m16370a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str + str2;
        }
        return str;
    }

    /* renamed from: a */
    public static void m13681a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j2 = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long m15927a = C4356ah.m15923a(context).m15927a(EnumC4244gk.SyncInfoFrequency.m15014a(), 1209600);
        if (j2 == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j2) > m15927a) {
            m13683a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    /* renamed from: a */
    public static void m13683a(final Context context, final boolean z) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.mipush.sdk.w.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC4022b.m13347a("do sync info");
                C4265he c4265he = new C4265he(C4358aj.m15941a(), false);
                C4048b m13476a = C4048b.m13476a(context);
                c4265he.m15318c(EnumC4249gp.SyncInfo.f15769a);
                c4265he.m15314b(m13476a.m13480a());
                c4265he.m15322d(context.getPackageName());
                c4265he.f16034a = new HashMap();
                Map<String, String> map = c4265he.f16034a;
                Context context2 = context;
                AbstractC4302l.m15697a(map, "app_version", C4233g.m14931a(context2, context2.getPackageName()));
                Map<String, String> map2 = c4265he.f16034a;
                Context context3 = context;
                AbstractC4302l.m15697a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C4233g.m14925a(context3, context3.getPackageName())));
                AbstractC4302l.m15697a(c4265he.f16034a, "push_sdk_vn", BuildConfig.VERSION_NAME);
                AbstractC4302l.m15697a(c4265he.f16034a, "push_sdk_vc", Integer.toString(BuildConfig.VERSION_CODE));
                AbstractC4302l.m15697a(c4265he.f16034a, "token", m13476a.m13490b());
                if (!C4300j.m15691d()) {
                    String m13879a = C4100bb.m13879a(C4287i.m15647c(context));
                    String m15651e = C4287i.m15651e(context);
                    if (!TextUtils.isEmpty(m15651e)) {
                        m13879a = m13879a + Constants.ACCEPT_TIME_SEPARATOR_SP + m15651e;
                    }
                    if (!TextUtils.isEmpty(m13879a)) {
                        AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_IMEI_MD5, m13879a);
                    }
                }
                C4085an.m13755a(context).m13758a(c4265he.f16034a);
                AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_REG_ID, m13476a.m13495c());
                AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_REG_SECRET, m13476a.m13497d());
                AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(context).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
                if (z) {
                    AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_ALIASES_MD5, C4069w.m13685c(MiPushClient.getAllAlias(context)));
                    AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_TOPICS_MD5, C4069w.m13685c(MiPushClient.getAllTopic(context)));
                    AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_ACCOUNTS_MD5, C4069w.m13685c(MiPushClient.getAllUserAccount(context)));
                } else {
                    AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_ALIASES, C4069w.m13686d(MiPushClient.getAllAlias(context)));
                    AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_TOPICS, C4069w.m13686d(MiPushClient.getAllTopic(context)));
                    AbstractC4302l.m15697a(c4265he.f16034a, Constants.EXTRA_KEY_ACCOUNTS, C4069w.m13686d(MiPushClient.getAllUserAccount(context)));
                }
                C4067u.m13627a(context).m13661a((C4067u) c4265he, EnumC4239gf.Notification, false, (C4252gs) null);
            }
        });
    }

    /* renamed from: a */
    public static void m13682a(Context context, C4265he c4265he) {
        AbstractC4022b.m13347a("need to update local info with: " + c4265he.m15307a());
        String str = c4265he.m15307a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    C4048b.m13476a(context).m13486a(true);
                } else {
                    C4048b.m13476a(context).m13486a(false);
                }
            }
        }
        String str2 = c4265he.m15307a().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAlias(context, str3);
                }
            }
        }
        String str4 = c4265he.m15307a().get(Constants.EXTRA_KEY_TOPICS);
        if (str4 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addTopic(context, str5);
                }
            }
        }
        String str6 = c4265he.m15307a().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str6 != null) {
            MiPushClient.removeAllAccounts(context);
            if ("".equals(str6)) {
                return;
            }
            for (String str7 : str6.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                MiPushClient.addAccount(context, str7);
            }
        }
    }
}
