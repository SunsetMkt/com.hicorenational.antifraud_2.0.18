package anet.channel.util;

import anet.channel.request.Request;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.h */
/* loaded from: classes.dex */
public class C0862h {

    /* renamed from: a */
    private static Map<String, Integer> f1187a = new HashMap();

    static {
        f1187a.put("tpatch", 3);
        f1187a.put("so", 3);
        f1187a.put("json", 3);
        f1187a.put("html", 4);
        f1187a.put("htm", 4);
        f1187a.put("css", 5);
        f1187a.put("js", 5);
        f1187a.put("webp", 6);
        f1187a.put("png", 6);
        f1187a.put("jpg", 6);
        f1187a.put("do", 6);
        f1187a.put("zip", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f1187a.put("bin", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f1187a.put("apk", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
    }

    /* renamed from: a */
    public static int m739a(Request request) {
        Integer num;
        if (request == null) {
            throw new NullPointerException("url is null!");
        }
        if (request.getHeaders().containsKey(HttpConstant.X_PV)) {
            return 1;
        }
        String trySolveFileExtFromUrlPath = HttpHelper.trySolveFileExtFromUrlPath(request.getHttpUrl().path());
        if (trySolveFileExtFromUrlPath == null || (num = f1187a.get(trySolveFileExtFromUrlPath)) == null) {
            return 6;
        }
        return num.intValue();
    }
}
