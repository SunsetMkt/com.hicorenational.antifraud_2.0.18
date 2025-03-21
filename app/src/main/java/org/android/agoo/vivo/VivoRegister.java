package org.android.agoo.vivo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.android.agoo.control.NotifManager;

/* loaded from: classes2.dex */
public class VivoRegister {
    public static final String TAG = "VivoRegister";
    public static final String VERSION = "2.1.0";

    /* renamed from: org.android.agoo.vivo.VivoRegister$a */
    public class C6038a implements IPushActionListener {

        /* renamed from: a */
        public final /* synthetic */ Context f21515a;

        /* renamed from: org.android.agoo.vivo.VivoRegister$a$a */
        public class a implements IPushQueryActionListener {
            public a() {
            }

            @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
            public void onFail(Integer num) {
            }

            @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
            public void onSuccess(String str) {
                String str2 = str;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    NotifManager notifManager = new NotifManager();
                    notifManager.init(C6038a.this.f21515a);
                    notifManager.reportThirdPushToken(str2, PushMessageReceiverImpl.VIVO_TOKEN, "2.0.0", true);
                } catch (Throwable th) {
                    ALog.m9181e(VivoRegister.TAG, "report token failed:", th, new Object[0]);
                }
            }
        }

        public C6038a(Context context) {
            this.f21515a = context;
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i2) {
            ALog.m9183i(VivoRegister.TAG, "turnOnPush", "state", Integer.valueOf(i2));
            if (i2 == 0) {
                VivoRegister.getToken(this.f21515a, new a());
            }
        }
    }

    /* renamed from: org.android.agoo.vivo.VivoRegister$b */
    public class C6039b implements IPushQueryActionListener {

        /* renamed from: a */
        public final /* synthetic */ IPushQueryActionListener f21517a;

        public C6039b(IPushQueryActionListener iPushQueryActionListener) {
            this.f21517a = iPushQueryActionListener;
        }

        @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onFail(Integer num) {
            ALog.m9182e(VivoRegister.TAG, "getToken failed, code", num);
            IPushQueryActionListener iPushQueryActionListener = this.f21517a;
            if (iPushQueryActionListener != null) {
                iPushQueryActionListener.onFail(num);
            }
        }

        @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            ALog.m9182e(VivoRegister.TAG, "getToken regId", str);
            IPushQueryActionListener iPushQueryActionListener = this.f21517a;
            if (iPushQueryActionListener != null) {
                iPushQueryActionListener.onSuccess(str);
            }
        }
    }

    /* renamed from: org.android.agoo.vivo.VivoRegister$c */
    public class C6040c implements IPushActionListener {
        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i2) {
            ALog.m9183i(VivoRegister.TAG, "turnOffPush", "state", Integer.valueOf(i2));
        }
    }

    public static void getToken(Context context, IPushQueryActionListener iPushQueryActionListener) {
        try {
            PushClient.getInstance(context).getRegId(new C6039b(iPushQueryActionListener));
        } catch (Throwable th) {
            ALog.m9181e(TAG, "getToken failed:", th, new Object[0]);
        }
    }

    public static void register(Context context) {
        if (context == null) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (!UtilityImpl.isMainProcess(applicationContext)) {
                ALog.m9183i(TAG, "not in main process, skipped.", new Object[0]);
                return;
            }
            if (!PushClient.getInstance(applicationContext).isSupport()) {
                ALog.m9183i(TAG, "device check, skipped.", new Object[0]);
                return;
            }
            ALog.m9183i(TAG, "ver:", "2.1.0");
            ALog.m9183i(TAG, "register start", new Object[0]);
            BaseNotifyClickActivity.addNotifyListener(new VivoMsgParseImpl());
            PushClient.getInstance(applicationContext).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());
            PushClient.getInstance(applicationContext).turnOnPush(new C6038a(applicationContext));
        } catch (Throwable th) {
            ALog.m9181e(TAG, "register failed:", th, new Object[0]);
        }
    }

    public static void unregister(Context context) {
        try {
            ALog.m9183i(TAG, MiPushClient.COMMAND_UNREGISTER, new Object[0]);
            PushClient.getInstance(context).turnOffPush(new C6040c());
        } catch (Throwable th) {
            ALog.m9181e(TAG, "unregister failed:", th, new Object[0]);
        }
    }
}
