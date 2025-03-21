package network;

import java.util.concurrent.TimeUnit;
import network.interceptor.RequestParamInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import p245d.C4440a;
import p375l.C5885n;
import p375l.p376q.p377a.C5895h;
import p375l.p378r.p379a.C5897a;
import util.C7301n1;
import util.C7307p1;
import util.C7325u1;

/* loaded from: classes2.dex */
public class Api {
    private static final int TIMEOUT_IDVAR = 300;
    private static final int TIMEOUT_NOR = 6;
    private static String mHost = null;
    private static Api mImeiApi = null;
    private static int timeOut = 6;
    HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: network.a
        @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
        public final void log(String str) {
            C7301n1.m26457b("RetrofitLog", "retrofitBack = " + str);
        }
    });
    RequestParamInterceptor paramInterceptor = new RequestParamInterceptor();
    private C5885n mRetrofit = new C5885n.b().m24814a(C4440a.m16407i()).m24817a(C5897a.m24871a()).m24816a(C5895h.m24868a()).m24820a(createClient()).m24822a();
    private C5885n mRetrofitUnHeader = new C5885n.b().m24814a(C4440a.m16407i()).m24817a(C5897a.m24871a()).m24816a(C5895h.m24868a()).m24820a(createClientUnHeader()).m24822a();

    private static class SingleHodle {
        private static final Api mApi = new Api();

        private SingleHodle() {
        }
    }

    private OkHttpClient createClient() {
        this.mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true).connectTimeout(timeOut, TimeUnit.SECONDS).readTimeout(timeOut, TimeUnit.SECONDS).writeTimeout(timeOut, TimeUnit.SECONDS).addInterceptor(this.mLoggingInterceptor);
        builder.addInterceptor(this.paramInterceptor);
        return builder.build();
    }

    private OkHttpClient createClientUnHeader() {
        this.mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true).connectTimeout(timeOut, TimeUnit.SECONDS).readTimeout(timeOut, TimeUnit.SECONDS).writeTimeout(timeOut, TimeUnit.SECONDS).addInterceptor(this.mLoggingInterceptor);
        return builder.build();
    }

    public static synchronized Api getInstance() {
        Api api;
        synchronized (Api.class) {
            timeOut = 6;
            api = SingleHodle.mApi;
        }
        return api;
    }

    public static synchronized Api getInstanceImei() {
        synchronized (Api.class) {
            if (!C7325u1.m26623a(C7307p1.f25516y, true)) {
                return SingleHodle.mApi;
            }
            if (mImeiApi == null) {
                synchronized (Api.class) {
                    if (mImeiApi == null) {
                        mImeiApi = new Api();
                    }
                }
            }
            return mImeiApi;
        }
    }

    public static synchronized Api getInstanceMode() {
        Api api;
        synchronized (Api.class) {
            timeOut = 300;
            api = new Api();
        }
        return api;
    }

    public static String getmHost() {
        return mHost;
    }

    public static void setHost(String str) {
        mHost = str;
    }

    public IReportService getReportService() {
        return (IReportService) this.mRetrofit.m24799a(IReportService.class);
    }

    public IReportService getReportServiceUnHeader() {
        return (IReportService) this.mRetrofitUnHeader.m24799a(IReportService.class);
    }
}
