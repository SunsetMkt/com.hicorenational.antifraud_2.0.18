package anet.channel.strategy.dispatch;

import android.util.Base64InputStream;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.statist.AmdcStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anet.channel.util.C0857c;
import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.dispatch.b */
/* loaded from: classes.dex */
class C0831b {

    /* renamed from: a */
    static AtomicInteger f1090a = new AtomicInteger(0);

    /* renamed from: b */
    static HostnameVerifier f1091b = new C0832c();

    /* renamed from: c */
    static Random f1092c = new Random();

    C0831b() {
    }

    /* renamed from: a */
    static List<IConnStrategy> m678a(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.isProxy()) {
            list = StrategyCenter.getInstance().getConnStrategyListByHost(DispatchConstants.getAmdcServerDomain());
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (!listIterator.next().getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    /* renamed from: a */
    public static void m681a(Map map) {
        String m677a;
        IConnStrategy iConnStrategy;
        String str;
        if (map == null) {
            return;
        }
        String schemeByHost = AmdcRuntimeInfo.isForceHttps() ? HttpConstant.HTTPS : StrategyCenter.getInstance().getSchemeByHost(DispatchConstants.getAmdcServerDomain(), HttpConstant.HTTP);
        List<IConnStrategy> m678a = m678a(schemeByHost);
        for (int i2 = 0; i2 < 3; i2++) {
            HashMap hashMap = new HashMap(map);
            if (i2 != 2) {
                iConnStrategy = !m678a.isEmpty() ? m678a.remove(0) : null;
                if (iConnStrategy != null) {
                    str = m677a(schemeByHost, iConnStrategy.getIp(), iConnStrategy.getPort(), hashMap, i2);
                } else {
                    str = m677a(schemeByHost, (String) null, 0, hashMap, i2);
                }
            } else {
                String[] amdcServerFixIp = DispatchConstants.getAmdcServerFixIp();
                if (amdcServerFixIp != null && amdcServerFixIp.length > 0) {
                    m677a = m677a(schemeByHost, amdcServerFixIp[f1092c.nextInt(amdcServerFixIp.length)], 0, hashMap, i2);
                } else {
                    m677a = m677a(schemeByHost, (String) null, 0, hashMap, i2);
                }
                String str2 = m677a;
                iConnStrategy = null;
                str = str2;
            }
            int m675a = m675a(str, hashMap, i2);
            if (iConnStrategy != null) {
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = m675a == 0;
                StrategyCenter.getInstance().notifyConnEvent(DispatchConstants.getAmdcServerDomain(), iConnStrategy, connEvent);
            }
            if (m675a == 0 || m675a == 2) {
                return;
            }
        }
    }

    /* renamed from: a */
    private static String m677a(String str, String str2, int i2, Map<String, String> map, int i3) {
        StringBuilder sb = new StringBuilder(64);
        if (!AmdcRuntimeInfo.isForceHttps() && i3 == 2 && HttpConstant.HTTPS.equalsIgnoreCase(str) && f1092c.nextBoolean()) {
            str = HttpConstant.HTTP;
        }
        sb.append(str);
        sb.append(HttpConstant.SCHEME_SPLIT);
        if (str2 != null) {
            if (C0857c.m723a() && C0848c.m707a(str2)) {
                try {
                    str2 = C0857c.m721a(str2);
                } catch (Exception unused) {
                }
            }
            if (C0848c.m708b(str2)) {
                sb.append('[');
                sb.append(str2);
                sb.append(']');
            } else {
                sb.append(str2);
            }
            if (i2 == 0) {
                i2 = HttpConstant.HTTPS.equalsIgnoreCase(str) ? Constants.PORT : 80;
            }
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(i2);
        } else {
            sb.append(DispatchConstants.getAmdcServerDomain());
        }
        sb.append(DispatchConstants.serverPath);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appkey", map.remove("appkey"));
        treeMap.put("v", map.remove("v"));
        treeMap.put("platform", map.remove("platform"));
        sb.append('?');
        sb.append(C0848c.m706a(treeMap, "utf-8"));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02bb A[Catch: all -> 0x02db, TryCatch #13 {all -> 0x02db, blocks: (B:129:0x02b1, B:131:0x02bb, B:132:0x02bf), top: B:128:0x02b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [long] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.net.URL] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m675a(java.lang.String r18, java.util.Map r19, int r20) {
        /*
            Method dump skipped, instructions count: 749
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.dispatch.C0831b.m675a(java.lang.String, java.util.Map, int):int");
    }

    /* renamed from: a */
    static String m676a(InputStream inputStream, boolean z) {
        Throwable th;
        IOException e2;
        FilterInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (z) {
            try {
                try {
                    bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e2 = e3;
                ALog.m714e("awcn.DispatchCore", "", null, e2, new Object[0]);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
                return null;
            }
        }
        FilterInputStream base64InputStream = new Base64InputStream(bufferedInputStream, 0);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = base64InputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
            try {
                base64InputStream.close();
            } catch (IOException unused3) {
            }
            return str;
        } catch (IOException e4) {
            e2 = e4;
            bufferedInputStream = base64InputStream;
            ALog.m714e("awcn.DispatchCore", "", null, e2, new Object[0]);
            bufferedInputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = base64InputStream;
            bufferedInputStream.close();
            throw th;
        }
    }

    /* renamed from: a */
    static void m680a(String str, String str2, URL url, int i2, int i3) {
        if ((i3 != 1 || i2 == 2) && GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                AmdcStatistic amdcStatistic = new AmdcStatistic();
                amdcStatistic.errorCode = str;
                amdcStatistic.errorMsg = str2;
                if (url != null) {
                    amdcStatistic.host = url.getHost();
                    amdcStatistic.url = url.toString();
                }
                amdcStatistic.retryTimes = i2;
                AppMonitor.getInstance().commitStat(amdcStatistic);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    static void m679a(String str, long j2, long j3) {
        try {
            FlowStat flowStat = new FlowStat();
            flowStat.refer = "amdc";
            flowStat.protocoltype = HttpConstant.HTTP;
            flowStat.req_identifier = str;
            flowStat.upstream = j2;
            flowStat.downstream = j3;
            NetworkAnalysis.getInstance().commitFlow(flowStat);
        } catch (Exception e2) {
            ALog.m714e("awcn.DispatchCore", "commit flow info failed!", null, e2, new Object[0]);
        }
    }
}
