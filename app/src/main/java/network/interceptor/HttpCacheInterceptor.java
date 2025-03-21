package network.interceptor;

import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import util.C7313q1;

/* loaded from: classes2.dex */
public class HttpCacheInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (!C7313q1.m26534f()) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }
        Response proceed = chain.proceed(request);
        if (C7313q1.m26534f()) {
            proceed.newBuilder().removeHeader("Pragma").header("Cache-Control", "public, max-age=3600").build();
        } else {
            proceed.newBuilder().removeHeader("Pragma").header("Cache-Control", "public, only-if-cached, max-stale=2419200").build();
        }
        return proceed;
    }
}
