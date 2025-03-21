package anet.channel.detect;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.MtuDetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;
import org.android.netutil.PingEntry;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.k */
/* loaded from: classes.dex */
class C0769k {

    /* renamed from: a */
    private static HashMap<String, Long> f805a = new HashMap<>();

    C0769k() {
    }

    /* renamed from: a */
    public void m481a() {
        NetworkStatusHelper.addStatusChangeListener(new C0770l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m480a(String str) {
        PingResponse pingResponse;
        if (!AwcnConfig.isNetworkDetectEnable()) {
            ALog.m716i("anet.MTUDetector", "network detect closed.", null, new Object[0]);
            return;
        }
        ALog.m716i("anet.MTUDetector", "mtuDetectTask start", null, new Object[0]);
        SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l2 = f805a.get(str);
        if (l2 == null || currentTimeMillis >= l2.longValue()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            long j2 = defaultSharedPreferences.getLong("sp_mtu_" + str, 0L);
            if (currentTimeMillis < j2) {
                f805a.put(str, Long.valueOf(j2));
                ALog.m716i("anet.MTUDetector", "mtuDetectTask in period of validity", null, new Object[0]);
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost("guide-acs.m.taobao.com");
            String ip = (connStrategyListByHost == null || connStrategyListByHost.isEmpty()) ? null : connStrategyListByHost.get(0).getIp();
            if (TextUtils.isEmpty(ip)) {
                return;
            }
            String str2 = ip;
            Future launch = new PingTask(str2, 1000, 3, 0, 0).launch();
            Future<PingResponse> launch2 = new PingTask(str2, 1000, 3, 1172, 0).launch();
            Future<PingResponse> launch3 = new PingTask(str2, 1000, 3, 1272, 0).launch();
            Future<PingResponse> launch4 = new PingTask(str2, 1000, 3, 1372, 0).launch();
            Future<PingResponse> launch5 = new PingTask(str2, 1000, 3, 1432, 0).launch();
            try {
                pingResponse = (PingResponse) launch.get();
            } catch (Exception unused) {
                pingResponse = null;
            }
            if (pingResponse == null) {
                return;
            }
            if (pingResponse.getSuccessCnt() < 2) {
                ALog.m715e("anet.MTUDetector", "MTU detect preTask error", null, "errCode", Integer.valueOf(pingResponse.getErrcode()), "successCount", Integer.valueOf(pingResponse.getSuccessCnt()));
                return;
            }
            m478a(1200, launch2);
            m478a(1300, launch3);
            m478a(1400, launch4);
            m478a(1460, launch5);
            long j3 = currentTimeMillis + 432000000;
            f805a.put(str, Long.valueOf(j3));
            defaultSharedPreferences.edit().putLong("sp_mtu_" + str, j3).apply();
        }
    }

    /* renamed from: a */
    private void m478a(int i2, Future<PingResponse> future) {
        PingResponse pingResponse;
        try {
            pingResponse = future.get();
        } catch (Exception unused) {
            pingResponse = null;
        }
        if (pingResponse == null) {
            return;
        }
        int successCnt = pingResponse.getSuccessCnt();
        int i3 = 3 - successCnt;
        StringBuilder sb = new StringBuilder();
        PingEntry[] results = pingResponse.getResults();
        int length = results.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(results[i4].rtt);
            if (i4 != length - 1) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        ALog.m716i("anet.MTUDetector", "MTU detect result", null, "mtu", Integer.valueOf(i2), "successCount", Integer.valueOf(successCnt), "timeoutCount", Integer.valueOf(i3));
        MtuDetectStat mtuDetectStat = new MtuDetectStat();
        mtuDetectStat.mtu = i2;
        mtuDetectStat.pingSuccessCount = successCnt;
        mtuDetectStat.pingTimeoutCount = i3;
        mtuDetectStat.rtt = sb.toString();
        mtuDetectStat.errCode = pingResponse.getErrcode();
        AppMonitor.getInstance().commitStat(mtuDetectStat);
    }
}
