package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.dt;
import com.xiaomi.push.ed;
import com.xiaomi.push.gj;
import com.xiaomi.push.hp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class PushMessageHandler extends BaseService {
    private static List<MiPushClient.ICallbackResult> a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private static List<MiPushClient.MiPushClientCallback> f8709b = new ArrayList();

    /* JADX INFO: renamed from: a */
    private static ThreadPoolExecutor f104a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.PushMessageHandler$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Intent f105a;

        AnonymousClass1(Context context, Intent intent) {
            context = context;
            intent = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            PushMessageHandler.b(context, intent);
        }
    }

    interface a extends Serializable {
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m49a("PushMessageHandler", e2.getMessage());
        }
    }

    protected static void b() {
        synchronized (a) {
            a.clear();
        }
    }

    private static void c(Context context, Intent intent) {
        if (intent != null && !f104a.isShutdown()) {
            f104a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.PushMessageHandler.1
                final /* synthetic */ Context a;

                /* JADX INFO: renamed from: a */
                final /* synthetic */ Intent f105a;

                AnonymousClass1(Context context2, Intent intent2) {
                    context = context2;
                    intent = intent2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    PushMessageHandler.b(context, intent);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("-->scheduleJob() fail, case");
        sb.append(intent2 == null ? "0" : "1");
        com.xiaomi.channel.commonutils.logger.b.d("PushMessageHandler", sb.toString());
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        c(getApplicationContext(), intent);
    }

    protected static void b(Context context, Intent intent) {
        boolean booleanExtra;
        try {
            booleanExtra = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m49a("PushMessageHandler", "intent unparcel error:" + th);
            booleanExtra = false;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.m50a("PushMessageHandler", "-->onHandleIntent(): action=", intent.getAction());
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                gj gjVar = new gj();
                hp.a(gjVar, intent.getByteArrayExtra("mipush_payload"));
                com.xiaomi.channel.commonutils.logger.b.m53b("PushMessageHandler", "PushMessageHandler.onHandleIntent " + gjVar.d());
                MiTinyDataClient.upload(context, gjVar);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m71b()) {
                    com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler", "receive a message before application calling initialize");
                    if (booleanExtra) {
                        b(context);
                        return;
                    }
                    return;
                }
                a aVarA = t.a(context).a(intent);
                if (aVarA != null) {
                    a(context, aVarA);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    ResolveInfo resolveInfo = null;
                    if (listQueryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ResolveInfo next = it.next();
                            if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.r.a(context, next.activityInfo.name))) {
                                resolveInfo = next;
                                break;
                            }
                        }
                    }
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo, booleanExtra);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler", "cannot find the receiver to handler this message, check your manifest");
                        dt.a(context).a(context.getPackageName(), intent, "11");
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("PushMessageHandler", e2);
                    dt.a(context).a(context.getPackageName(), intent, "9");
                }
            }
            if (!booleanExtra) {
            }
        } catch (Throwable th2) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a("PushMessageHandler", th2);
                dt.a(context).a(context.getPackageName(), intent, "10");
            } finally {
                if (booleanExtra) {
                    b(context);
                }
            }
        }
    }

    public static void a(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.m53b("PushMessageHandler", "addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    protected static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (f8709b) {
            if (!f8709b.contains(miPushClientCallback)) {
                f8709b.add(miPushClientCallback);
            }
        }
    }

    protected static void a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (a) {
            if (!a.contains(iCallbackResult)) {
                a.add(iCallbackResult);
            }
        }
    }

    protected static void a() {
        synchronized (f8709b) {
            f8709b.clear();
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) com.xiaomi.push.r.a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), (Class<?>) MessageHandleService.class));
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* JADX INFO: renamed from: a */
    protected boolean mo72a() {
        ThreadPoolExecutor threadPoolExecutor = f104a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f104a.getQueue().size() <= 0) ? false : true;
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
            return;
        }
        if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (ed.COMMAND_REGISTER.f424a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (!ed.COMMAND_SET_ALIAS.f424a.equals(command) && !ed.COMMAND_UNSET_ALIAS.f424a.equals(command) && !ed.COMMAND_SET_ACCEPT_TIME.f424a.equals(command)) {
                if (ed.COMMAND_SUBSCRIBE_TOPIC.f424a.equals(command)) {
                    List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                        str = commandArguments2.get(0);
                    }
                    a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                if (ed.COMMAND_UNSUBSCRIBE_TOPIC.f424a.equals(command)) {
                    List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                        str = commandArguments3.get(0);
                    }
                    b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                return;
            }
            a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
        }
    }

    private static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, c.a(context));
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m49a("PushMessageHandler", "callback sync error" + e2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m71b() {
        return f8709b.isEmpty();
    }

    protected static void b(Context context, String str, long j2, String str2, String str3) {
        synchronized (f8709b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f8709b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j2, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (f8709b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f8709b) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(long j2, String str, String str2) {
        synchronized (f8709b) {
            Iterator<MiPushClient.MiPushClientCallback> it = f8709b.iterator();
            while (it.hasNext()) {
                it.next().onInitializeResult(j2, str, str2);
            }
        }
    }

    protected static void a(Context context, String str, long j2, String str2, String str3) {
        synchronized (f8709b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f8709b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j2, str2, str3);
                }
            }
        }
    }

    protected static void a(Context context, String str, String str2, long j2, String str3, List<String> list) {
        synchronized (f8709b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f8709b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j2, str3, list);
                }
            }
        }
    }

    protected static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    protected static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (a) {
            for (MiPushClient.ICallbackResult iCallbackResult : a) {
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
