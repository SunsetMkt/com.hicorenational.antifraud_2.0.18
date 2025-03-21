package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4172dt;
import com.xiaomi.push.EnumC4183ed;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MessageHandleService extends BaseService {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<C4034a> f14344a = new ConcurrentLinkedQueue<>();

    /* renamed from: a */
    private static ExecutorService f14345a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: com.xiaomi.mipush.sdk.MessageHandleService$a */
    public static class C4034a {

        /* renamed from: a */
        private Intent f14349a;

        /* renamed from: a */
        private PushMessageReceiver f14350a;

        public C4034a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f14350a = pushMessageReceiver;
            this.f14349a = intent;
        }

        /* renamed from: a */
        public PushMessageReceiver m13434a() {
            return this.f14350a;
        }

        /* renamed from: a */
        public Intent m13433a() {
            return this.f14349a;
        }
    }

    public static void addJob(Context context, C4034a c4034a) {
        if (c4034a != null) {
            f14344a.add(c4034a);
            m13431b(context);
            startService(context);
        }
    }

    /* renamed from: b */
    private static void m13431b(final Context context) {
        if (f14345a.isShutdown()) {
            return;
        }
        f14345a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.2
            @Override // java.lang.Runnable
            public void run() {
                MessageHandleService.m13432c(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m13432c(Context context) {
        try {
            m13430a(context, f14344a.poll());
        } catch (RuntimeException e2) {
            AbstractC4022b.m13351a(e2);
        }
    }

    public static void startService(final Context context) {
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    context.startService(intent);
                } catch (Exception e2) {
                    AbstractC4022b.m13347a(e2.getMessage());
                }
            }
        });
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
    }

    /* renamed from: a */
    protected static void m13429a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        m13431b(context);
    }

    /* renamed from: a */
    static void m13430a(Context context, C4034a c4034a) {
        String[] stringArrayExtra;
        if (c4034a == null) {
            return;
        }
        try {
            PushMessageReceiver m13434a = c4034a.m13434a();
            Intent m13433a = c4034a.m13433a();
            int intExtra = m13433a.getIntExtra("message_type", 1);
            if (intExtra != 1) {
                if (intExtra != 3) {
                    if (intExtra == 4 || intExtra != 5 || !PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(m13433a.getStringExtra(PushMessageHelper.ERROR_TYPE)) || (stringArrayExtra = m13433a.getStringArrayExtra(PushMessageHelper.ERROR_MESSAGE)) == null) {
                        return;
                    }
                    AbstractC4022b.m13363e("begin execute onRequirePermissions, lack of necessary permissions");
                    m13434a.onRequirePermissions(context, stringArrayExtra);
                    return;
                }
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) m13433a.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                AbstractC4022b.m13363e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                m13434a.onCommandResult(context, miPushCommandMessage);
                if (TextUtils.equals(miPushCommandMessage.getCommand(), EnumC4183ed.COMMAND_REGISTER.f15082a)) {
                    m13434a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.m13459a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() == 0) {
                        C4052f.m13548b(context);
                        return;
                    }
                    return;
                }
                return;
            }
            PushMessageHandler.InterfaceC4046a m13619a = C4066t.m13606a(context).m13619a(m13433a);
            int intExtra2 = m13433a.getIntExtra("eventMessageType", -1);
            if (m13619a != null) {
                if (m13619a instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) m13619a;
                    if (!miPushMessage.isArrivedMessage()) {
                        m13434a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        C4172dt.m14529a(context.getApplicationContext()).m14532a(context.getPackageName(), m13433a, 2004, (String) null);
                        AbstractC4022b.m13362d("MessageHandleService", "begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        m13434a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    }
                    if (miPushMessage.isNotified()) {
                        if (intExtra2 == 1000) {
                            C4172dt.m14529a(context.getApplicationContext()).m14532a(context.getPackageName(), m13433a, 1007, (String) null);
                        } else {
                            C4172dt.m14529a(context.getApplicationContext()).m14532a(context.getPackageName(), m13433a, 3007, (String) null);
                        }
                        AbstractC4022b.m13362d("MessageHandleService", "begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        m13434a.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                    AbstractC4022b.m13362d("MessageHandleService", "begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                    m13434a.onNotificationMessageArrived(context, miPushMessage);
                    return;
                }
                if (m13619a instanceof MiPushCommandMessage) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) m13619a;
                    AbstractC4022b.m13362d("MessageHandleService", "begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    m13434a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), EnumC4183ed.COMMAND_REGISTER.f15082a)) {
                        m13434a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.m13459a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            C4052f.m13548b(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
                AbstractC4022b.m13362d("MessageHandleService", "unknown raw message: " + m13619a);
                return;
            }
            AbstractC4022b.m13362d("MessageHandleService", "no message from raw for receiver");
        } catch (RuntimeException e2) {
            AbstractC4022b.m13349a("MessageHandleService", e2);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo13419a() {
        ConcurrentLinkedQueue<C4034a> concurrentLinkedQueue = f14344a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }
}
