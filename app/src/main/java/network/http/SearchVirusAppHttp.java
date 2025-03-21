package network.http;

import android.text.TextUtils;
import bean.AppInfoBean;
import bean.AppSignBean;
import bean.SearchVirusAppBean;
import bean.SearchVirusAppResultBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.google.gson.p152d0.C2049a;
import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.SearchVirusAppHttp;
import p245d.C4440a;
import p247e.C4445b;
import p286h.C5629v;
import p286h.EnumC5682x;
import p286h.InterfaceC5604s;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.model.ModelPresent;
import util.C7304o1;
import util.C7316r1;

/* compiled from: SearchVirusAppHttp.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J&\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0015"}, m23546d2 = {"Lnetwork/http/SearchVirusAppHttp;", "", "()V", "getMd5", "", "oldMd5", "filePath", "getSignVirus", "", "virusBean", "Lbean/SearchVirusAppBean;", "installSearchAppHttp", "appInfoBean", "Lbean/AppInfoBean;", "list", "", "callback", "Lnetwork/http/SearchVirusAppHttp$Callback;", "principalHttp", "Callback", "Companion", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SearchVirusAppHttp {
    public static final Companion Companion = new Companion(null);

    @InterfaceC5816d
    private static final InterfaceC5604s instance$delegate;

    /* compiled from: SearchVirusAppHttp.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, m23546d2 = {"Lnetwork/http/SearchVirusAppHttp$Callback;", "", "principalResult", "", "appInfoBean", "Lbean/AppInfoBean;", "result", "", "Lbean/SearchVirusAppResultBean;", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    public interface Callback {
        void principalResult(@InterfaceC5817e AppInfoBean appInfoBean, @InterfaceC5817e List<SearchVirusAppResultBean> list);
    }

    /* compiled from: SearchVirusAppHttp.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m23546d2 = {"Lnetwork/http/SearchVirusAppHttp$Companion;", "", "()V", "instance", "Lnetwork/http/SearchVirusAppHttp;", "getInstance", "()Lnetwork/http/SearchVirusAppHttp;", "instance$delegate", "Lkotlin/Lazy;", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        @InterfaceC5816d
        public final SearchVirusAppHttp getInstance() {
            InterfaceC5604s interfaceC5604s = SearchVirusAppHttp.instance$delegate;
            Companion companion = SearchVirusAppHttp.Companion;
            return (SearchVirusAppHttp) interfaceC5604s.getValue();
        }

        public /* synthetic */ Companion(C5586v c5586v) {
            this();
        }
    }

    static {
        InterfaceC5604s m22991a;
        m22991a = C5629v.m22991a(EnumC5682x.SYNCHRONIZED, (InterfaceC5495a) SearchVirusAppHttp$Companion$instance$2.INSTANCE);
        instance$delegate = m22991a;
    }

    private SearchVirusAppHttp() {
    }

    private final String getMd5(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            String m26466a = C7304o1.m26466a(new File(str2));
            C5544i0.m22521a((Object) m26466a, "MD5Utils.getFileMD5(File(filePath))");
            return m26466a;
        }
        if (str != null) {
            return str;
        }
        C5544i0.m22545f();
        return str;
    }

    private final void getSignVirus(SearchVirusAppBean searchVirusAppBean) {
        AppSignBean m26549d;
        if (searchVirusAppBean == null || (m26549d = C7316r1.m26549d(searchVirusAppBean.getPkgName(), searchVirusAppBean.getFilePath())) == null) {
            return;
        }
        searchVirusAppBean.setSignMd5(m26549d.getSignMD5());
        searchVirusAppBean.setSignSha1(m26549d.getSignSha1());
        searchVirusAppBean.setSignSha256(m26549d.getSignSha256());
    }

    private final void installSearchAppHttp(final AppInfoBean appInfoBean, List<SearchVirusAppBean> list, final Callback callback) {
        RegionMudelBean m16408j = C4440a.m16408j();
        String str = C4445b.f17091h0;
        if (m16408j != null && TextUtils.equals(C4440a.m16398b(ModuelConfig.MODEL_WARN), "1")) {
            str = C4445b.f17094i0;
        }
        ModelPresent.searchVirusApp(C4440a.m16395a(ModuelConfig.MODEL_WARN, 6, str), list, new MiddleSubscriber<APIresult<List<? extends SearchVirusAppResultBean>>>() { // from class: network.http.SearchVirusAppHttp$installSearchAppHttp$1
            @Override // network.MiddleSubscriber
            @InterfaceC5816d
            protected Type getType() {
                Type type = new C2049a<List<? extends SearchVirusAppResultBean>>() { // from class: network.http.SearchVirusAppHttp$installSearchAppHttp$1$getType$1
                }.getType();
                C5544i0.m22521a((Object) type, "object : TypeToken<List<…AppResultBean>>() {}.type");
                return type;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(@InterfaceC5816d APIException aPIException) {
                C5544i0.m22546f(aPIException, "e");
                SearchVirusAppHttp.Callback.this.principalResult(null, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // network.MiddleSubscriber
            protected void onNextMiddle(@InterfaceC5817e APIresult<List<? extends SearchVirusAppResultBean>> aPIresult) {
                if (aPIresult == null) {
                    APIException apiExcept = APIException.getApiExcept();
                    C5544i0.m22521a((Object) apiExcept, "APIException.getApiExcept()");
                    onErrorMiddle(apiExcept);
                    return;
                }
                int code = aPIresult.getCode();
                if (code == -1) {
                    LoginManager.getInstance().exit();
                } else if (code != 0) {
                    SearchVirusAppHttp.Callback.this.principalResult(null, null);
                } else {
                    SearchVirusAppHttp.Callback.this.principalResult(appInfoBean, aPIresult.getData());
                }
            }
        });
    }

    public final void principalHttp(@InterfaceC5816d AppInfoBean appInfoBean, @InterfaceC5816d List<SearchVirusAppBean> list, @InterfaceC5816d Callback callback) {
        C5544i0.m22546f(appInfoBean, "appInfoBean");
        C5544i0.m22546f(list, "list");
        C5544i0.m22546f(callback, "callback");
        if (!list.isEmpty()) {
            for (SearchVirusAppBean searchVirusAppBean : list) {
                getSignVirus(searchVirusAppBean);
                try {
                    if (TextUtils.isEmpty(searchVirusAppBean.getFileMd5())) {
                        searchVirusAppBean.setFileMd5(getMd5(appInfoBean.getAppMD5(), searchVirusAppBean.getFilePath()));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        installSearchAppHttp(appInfoBean, list, callback);
    }

    public /* synthetic */ SearchVirusAppHttp(C5586v c5586v) {
        this();
    }
}
