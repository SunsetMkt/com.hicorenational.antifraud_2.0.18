package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.C4172dt;
import com.xiaomi.push.C4243gj;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.EnumC4183ed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PushMessageHandler extends BaseService {

    /* renamed from: a */
    private static List<MiPushClient.ICallbackResult> f14369a = new ArrayList();

    /* renamed from: b */
    private static List<MiPushClient.MiPushClientCallback> f14371b = new ArrayList();

    /* renamed from: a */
    private static ThreadPoolExecutor f14370a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: com.xiaomi.mipush.sdk.PushMessageHandler$a */
    interface InterfaceC4046a extends Serializable {
    }

    /* renamed from: a */
    public static void m13456a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e2) {
            AbstractC4022b.m13348a("PushMessageHandler", e2.getMessage());
        }
    }

    /* renamed from: b */
    protected static void m13467b() {
        synchronized (f14369a) {
            f14369a.clear();
        }
    }

    /* renamed from: c */
    private static void m13472c(final Context context, final Intent intent) {
        if (intent != null && !f14370a.isShutdown()) {
            f14370a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.PushMessageHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    PushMessageHandler.m13469b(context, intent);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("-->scheduleJob() fail, case");
        sb.append(intent == null ? "0" : "1");
        AbstractC4022b.m13362d("PushMessageHandler", sb.toString());
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        m13472c(getApplicationContext(), intent);
    }

    /* renamed from: b */
    protected static void m13469b(Context context, Intent intent) {
        boolean z;
        try {
            z = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th) {
            AbstractC4022b.m13348a("PushMessageHandler", "intent unparcel error:" + th);
            z = false;
        }
        try {
            AbstractC4022b.m13350a("PushMessageHandler", "-->onHandleIntent(): action=", intent.getAction());
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                C4243gj c4243gj = new C4243gj();
                C4276hp.m15566a(c4243gj, intent.getByteArrayExtra("mipush_payload"));
                AbstractC4022b.m13357b("PushMessageHandler", "PushMessageHandler.onHandleIntent " + c4243gj.m15001d());
                MiTinyDataClient.upload(context, c4243gj);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m13471b()) {
                    AbstractC4022b.m13360c("PushMessageHandler", "receive a message before application calling initialize");
                    if (z) {
                        m13468b(context);
                        return;
                    }
                    return;
                }
                InterfaceC4046a m13619a = C4066t.m13606a(context).m13619a(intent);
                if (m13619a != null) {
                    m13461a(context, m13619a);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    ResolveInfo resolveInfo = null;
                    if (queryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ResolveInfo next = it.next();
                            if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(C4309r.m15716a(context, next.activityInfo.name))) {
                                resolveInfo = next;
                                break;
                            }
                        }
                    }
                    if (resolveInfo != null) {
                        m13458a(context, intent2, resolveInfo, z);
                    } else {
                        AbstractC4022b.m13360c("PushMessageHandler", "cannot find the receiver to handler this message, check your manifest");
                        C4172dt.m14529a(context).m14533a(context.getPackageName(), intent, "11");
                    }
                } catch (Exception e2) {
                    AbstractC4022b.m13349a("PushMessageHandler", e2);
                    C4172dt.m14529a(context).m14533a(context.getPackageName(), intent, "9");
                }
            }
            if (!z) {
            }
        } catch (Throwable th2) {
            try {
                AbstractC4022b.m13349a("PushMessageHandler", th2);
                C4172dt.m14529a(context).m14533a(context.getPackageName(), intent, "10");
            } finally {
                if (z) {
                    m13468b(context);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m13457a(Context context, Intent intent) {
        AbstractC4022b.m13357b("PushMessageHandler", "addjob PushMessageHandler " + intent);
        if (intent != null) {
            m13472c(context, intent);
            m13456a(context);
        }
    }

    /* renamed from: a */
    protected static void m13465a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (f14371b) {
            if (!f14371b.contains(miPushClientCallback)) {
                f14371b.add(miPushClientCallback);
            }
        }
    }

    /* renamed from: a */
    protected static void m13464a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (f14369a) {
            if (!f14369a.contains(iCallbackResult)) {
                f14369a.add(iCallbackResult);
            }
        }
    }

    /* renamed from: a */
    protected static void m13454a() {
        synchronized (f14371b) {
            f14371b.clear();
        }
    }

    /* renamed from: a */
    private static void m13458a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.C4034a c4034a = new MessageHandleService.C4034a(intent, (PushMessageReceiver) C4309r.m15716a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.m13430a(context.getApplicationContext(), c4034a);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), c4034a);
            }
            MessageHandleService.m13429a(context, new Intent(context.getApplicationContext(), (Class<?>) MessageHandleService.class));
        } catch (Throwable th) {
            AbstractC4022b.m13351a(th);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo13419a() {
        ThreadPoolExecutor threadPoolExecutor = f14370a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f14370a.getQueue().size() <= 0) ? false : true;
    }

    /* renamed from: a */
    public static void m13461a(Context context, InterfaceC4046a interfaceC4046a) {
        if (interfaceC4046a instanceof MiPushMessage) {
            m13460a(context, (MiPushMessage) interfaceC4046a);
            return;
        }
        if (interfaceC4046a instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) interfaceC4046a;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (EnumC4183ed.COMMAND_REGISTER.f15082a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                m13455a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (!EnumC4183ed.COMMAND_SET_ALIAS.f15082a.equals(command) && !EnumC4183ed.COMMAND_UNSET_ALIAS.f15082a.equals(command) && !EnumC4183ed.COMMAND_SET_ACCEPT_TIME.f15082a.equals(command)) {
                if (EnumC4183ed.COMMAND_SUBSCRIBE_TOPIC.f15082a.equals(command)) {
                    List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                        str = commandArguments2.get(0);
                    }
                    m13462a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                if (EnumC4183ed.COMMAND_UNSUBSCRIBE_TOPIC.f15082a.equals(command)) {
                    List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                        str = commandArguments3.get(0);
                    }
                    m13470b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                return;
            }
            m13463a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
        }
    }

    /* renamed from: b */
    private static void m13468b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, C4049c.m13516a(context));
        } catch (Exception e2) {
            AbstractC4022b.m13348a("PushMessageHandler", "callback sync error" + e2);
        }
    }

    /* renamed from: b */
    public static boolean m13471b() {
        return f14371b.isEmpty();
    }

    /* renamed from: b */
    protected static void m13470b(Context context, String str, long j2, String str2, String str3) {
        synchronized (f14371b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f14371b) {
                if (m13466a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j2, str2, str3);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m13460a(Context context, MiPushMessage miPushMessage) {
        synchronized (f14371b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f14371b) {
                if (m13466a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m13455a(long j2, String str, String str2) {
        synchronized (f14371b) {
            Iterator<MiPushClient.MiPushClientCallback> it = f14371b.iterator();
            while (it.hasNext()) {
                it.next().onInitializeResult(j2, str, str2);
            }
        }
    }

    /* renamed from: a */
    protected static void m13462a(Context context, String str, long j2, String str2, String str3) {
        synchronized (f14371b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f14371b) {
                if (m13466a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j2, str2, str3);
                }
            }
        }
    }

    /* renamed from: a */
    protected static void m13463a(Context context, String str, String str2, long j2, String str3, List<String> list) {
        synchronized (f14371b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f14371b) {
                if (m13466a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j2, str3, list);
                }
            }
        }
    }

    /* renamed from: a */
    protected static boolean m13466a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* renamed from: a */
    protected static void m13459a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f14369a) {
            for (MiPushClient.ICallbackResult iCallbackResult : f14369a) {
                if (iCallbackResult instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (miPushCommandMessage != null && miPushCommandMessage.getCommandArguments() != null && miPushCommandMessage.getCommandArguments().size() > 0) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    iCallbackResult.onResult(tokenResult);
                }
            }
        }
    }
}
