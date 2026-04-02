package anet.channel.util;

import anet.channel.request.Request;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private static Map<String, Integer> a = new HashMap();

    static {
        a.put("tpatch", 3);
        a.put("so", 3);
        a.put("json", 3);
        a.put("html", 4);
        a.put("htm", 4);
        a.put("css", 5);
        a.put("js", 5);
        a.put("webp", 6);
        a.put("png", 6);
        a.put("jpg", 6);
        a.put("do", 6);
        a.put("zip", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        a.put("bin", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        a.put("apk", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
    }

    public static int a(Request request) {
        Integer num;
        if (request == null) {
            throw new NullPointerException("url is null!");
        }
        if (request.getHeaders().containsKey(HttpConstant.X_PV)) {
            return 1;
        }
        String strTrySolveFileExtFromUrlPath = HttpHelper.trySolveFileExtFromUrlPath(request.getHttpUrl().path());
        if (strTrySolveFileExtFromUrlPath == null || (num = a.get(strTrySolveFileExtFromUrlPath)) == null) {
            return 6;
        }
        return num.intValue();
    }
}
