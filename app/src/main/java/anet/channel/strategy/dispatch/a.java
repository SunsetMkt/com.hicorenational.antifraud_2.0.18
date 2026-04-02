package anet.channel.strategy.dispatch;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class a {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Random f1593b = new Random();
    private Map<String, Object> a;

    a() {
    }

    /* JADX INFO: renamed from: anet.channel.strategy.dispatch.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    private class RunnableC0011a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, Object> f1594b;

        RunnableC0011a(Map<String, Object> map) {
            this.f1594b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, Object> map;
            try {
                Map<String, Object> map2 = this.f1594b;
                if (map2 == null) {
                    synchronized (a.class) {
                        map = a.this.a;
                        a.this.a = null;
                    }
                    map2 = map;
                }
                if (NetworkStatusHelper.isConnected()) {
                    if (GlobalAppRuntimeInfo.getEnv() != map2.get("Env")) {
                        ALog.w(a.TAG, "task's env changed", null, new Object[0]);
                    } else {
                        b.a(d.a(map2));
                    }
                }
            } catch (Exception e2) {
                ALog.e(a.TAG, "exec amdc task failed.", null, e2, new Object[0]);
            }
        }

        RunnableC0011a() {
        }
    }

    public void a(Map<String, Object> map) {
        try {
            map.put("Env", GlobalAppRuntimeInfo.getEnv());
            synchronized (this) {
                if (this.a == null) {
                    this.a = map;
                    int iNextInt = f1593b.nextInt(PathInterpolatorCompat.MAX_NUM_POINTS) + 2000;
                    ALog.i(TAG, "merge amdc request", null, "delay", Integer.valueOf(iNextInt));
                    anet.channel.strategy.utils.a.a(new RunnableC0011a(), iNextInt);
                } else {
                    Set set = (Set) this.a.get(DispatchConstants.HOSTS);
                    Set set2 = (Set) map.get(DispatchConstants.HOSTS);
                    if (map.get("Env") != this.a.get("Env")) {
                        this.a = map;
                    } else if (set.size() + set2.size() <= 40) {
                        set2.addAll(set);
                        this.a = map;
                    } else {
                        anet.channel.strategy.utils.a.a(new RunnableC0011a(map));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
