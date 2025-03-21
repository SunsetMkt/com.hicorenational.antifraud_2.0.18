package anet.channel.strategy.dispatch;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.utils.C0846a;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.dispatch.a */
/* loaded from: classes.dex */
class C0830a {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";

    /* renamed from: b */
    private static Random f1086b = new Random();

    /* renamed from: a */
    private Map<String, Object> f1087a;

    C0830a() {
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.dispatch.a$a */
    private class a implements Runnable {

        /* renamed from: b */
        private Map<String, Object> f1089b;

        a(Map<String, Object> map) {
            this.f1089b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, Object> map;
            try {
                Map<String, Object> map2 = this.f1089b;
                if (map2 == null) {
                    synchronized (C0830a.class) {
                        map = C0830a.this.f1087a;
                        C0830a.this.f1087a = null;
                    }
                    map2 = map;
                }
                if (NetworkStatusHelper.isConnected()) {
                    if (GlobalAppRuntimeInfo.getEnv() != map2.get("Env")) {
                        ALog.m718w(C0830a.TAG, "task's env changed", null, new Object[0]);
                    } else {
                        C0831b.m681a(C0833d.m684a(map2));
                    }
                }
            } catch (Exception e2) {
                ALog.m714e(C0830a.TAG, "exec amdc task failed.", null, e2, new Object[0]);
            }
        }

        a() {
        }
    }

    /* renamed from: a */
    public void m674a(Map<String, Object> map) {
        try {
            map.put("Env", GlobalAppRuntimeInfo.getEnv());
            synchronized (this) {
                if (this.f1087a == null) {
                    this.f1087a = map;
                    int nextInt = f1086b.nextInt(PathInterpolatorCompat.MAX_NUM_POINTS) + 2000;
                    ALog.m716i(TAG, "merge amdc request", null, "delay", Integer.valueOf(nextInt));
                    C0846a.m703a(new a(), nextInt);
                } else {
                    Set set = (Set) this.f1087a.get(DispatchConstants.HOSTS);
                    Set set2 = (Set) map.get(DispatchConstants.HOSTS);
                    if (map.get("Env") != this.f1087a.get("Env")) {
                        this.f1087a = map;
                    } else if (set.size() + set2.size() <= 40) {
                        set2.addAll(set);
                        this.f1087a = map;
                    } else {
                        C0846a.m702a(new a(map));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
