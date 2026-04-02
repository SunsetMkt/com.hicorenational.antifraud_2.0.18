package com.taobao.accs.base;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.internal.ServiceImpl;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.v;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class BaseService extends Service {
    private static final String TAG = "BaseService";
    private static boolean isBinded = false;
    IBaseService mBaseService = null;
    private Messenger messenger = new Messenger(new Handler() { // from class: com.taobao.accs.base.BaseService.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                ALog.i(BaseService.TAG, "handleMessage on receive msg", "msg", message.toString());
                Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                if (intent != null) {
                    ALog.i(BaseService.TAG, "handleMessage get intent success", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                    BaseService.this.onStartCommand(intent, 0, 0);
                }
            }
        }
    });

    /* JADX INFO: renamed from: com.taobao.accs.base.BaseService$1 */
    /* JADX INFO: compiled from: Taobao */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                ALog.i(BaseService.TAG, "handleMessage on receive msg", "msg", message.toString());
                Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                if (intent != null) {
                    ALog.i(BaseService.TAG, "handleMessage get intent success", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                    BaseService.this.onStartCommand(intent, 0, 0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.taobao.accs.base.BaseService$2 */
    /* JADX INFO: compiled from: Taobao */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BaseService.this.mBaseService = new ServiceImpl(BaseService.this);
                BaseService.this.mBaseService.onCreate();
            } catch (Exception e2) {
                ALog.e(BaseService.TAG, "create ServiceImpl error", e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.taobao.accs.base.BaseService$3 */
    /* JADX INFO: compiled from: Taobao */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int val$flags;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$startId;

        AnonymousClass3(Intent intent, int i2, int i3) {
            intent = intent;
            i = i2;
            i = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseService baseService = BaseService.this;
            IBaseService iBaseService = baseService.mBaseService;
            if (iBaseService != null) {
                iBaseService.onStartCommand(intent, i, i);
            } else {
                baseService.onCreate();
                BaseService.this.onStartCommand(intent, i, i);
            }
        }
    }

    /* JADX INFO: renamed from: com.taobao.accs.base.BaseService$4 */
    /* JADX INFO: compiled from: Taobao */
    class AnonymousClass4 implements ServiceConnection {
        AnonymousClass4() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: renamed from: com.taobao.accs.base.BaseService$5 */
    /* JADX INFO: compiled from: Taobao */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IBaseService iBaseService = BaseService.this.mBaseService;
            if (iBaseService != null) {
                iBaseService.onDestroy();
                BaseService.this.mBaseService = null;
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ALog.d(TAG, "onBind", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
        try {
            if (v.a(this) && !isBinded) {
                isBinded = true;
                ALog.i(TAG, "onBind bind service", new Object[0]);
                getApplicationContext().bindService(new Intent(this, getClass()), new ServiceConnection() { // from class: com.taobao.accs.base.BaseService.4
                    AnonymousClass4() {
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                }, 1);
            }
        } catch (Throwable th) {
            ALog.i(TAG, "onBind bind service with exception", th.toString());
        }
        return this.messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.base.BaseService.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    BaseService.this.mBaseService = new ServiceImpl(BaseService.this);
                    BaseService.this.mBaseService.onCreate();
                } catch (Exception e2) {
                    ALog.e(BaseService.TAG, "create ServiceImpl error", e2.getMessage());
                }
            }
        });
    }

    @Override // android.app.Service
    public void onDestroy() {
        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.base.BaseService.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IBaseService iBaseService = BaseService.this.mBaseService;
                if (iBaseService != null) {
                    iBaseService.onDestroy();
                    BaseService.this.mBaseService = null;
                }
            }
        });
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.base.BaseService.3
            final /* synthetic */ int val$flags;
            final /* synthetic */ Intent val$intent;
            final /* synthetic */ int val$startId;

            AnonymousClass3(Intent intent2, int i22, int i32) {
                intent = intent2;
                i = i22;
                i = i32;
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseService baseService = BaseService.this;
                IBaseService iBaseService = baseService.mBaseService;
                if (iBaseService != null) {
                    iBaseService.onStartCommand(intent, i, i);
                } else {
                    baseService.onCreate();
                    BaseService.this.onStartCommand(intent, i, i);
                }
            }
        });
        return 2;
    }
}
