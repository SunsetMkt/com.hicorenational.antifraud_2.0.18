package bean.module;

import bean.WhiteTelBean;
import com.google.gson.d0.a;
import com.google.gson.e;
import interfaces.IResultCallback;
import interfaces.IResultMuCallback;
import java.util.List;
import manager.AccountManager;
import ui.presenter.WelocmPresenter;
import util.j1;
import util.u1;

/* JADX INFO: loaded from: classes.dex */
public class LocalModuelConfig extends ModuelConfig {
    public static String ISHAVE_LOCAL = "sucess_get_config";
    public static String LASTCONFIG = "lastConfig";

    /* JADX INFO: renamed from: bean.module.LocalModuelConfig$1 */
    class AnonymousClass1 extends a<RegionMudelBean> {
        AnonymousClass1() {
        }
    }

    /* JADX INFO: renamed from: bean.module.LocalModuelConfig$2 */
    class AnonymousClass2 implements IResultMuCallback {
        final /* synthetic */ IResultCallback val$iResult;

        AnonymousClass2(IResultCallback iResultCallback) {
            iResultCallback = iResultCallback;
        }

        @Override // interfaces.IResultMuCallback
        public void onIRFail() {
        }

        @Override // interfaces.IResultMuCallback
        public void onIRSuccess(RegionMudelBean regionMudelBean, boolean z) {
            if (z) {
                u1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                u1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
            } else {
                u1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                u1.a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
                u1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
            }
            e.a.c();
            e.a.d();
            iResultCallback.onIRSuccess(regionMudelBean);
            LocalModuelConfig.this.collectWhiteList(regionMudelBean);
        }
    }

    /* JADX INFO: renamed from: bean.module.LocalModuelConfig$3 */
    class AnonymousClass3 implements IResultMuCallback {
        final /* synthetic */ IResultCallback val$iResult;

        AnonymousClass3(IResultCallback iResultCallback) {
            iResultCallback = iResultCallback;
        }

        @Override // interfaces.IResultMuCallback
        public void onIRFail() {
        }

        @Override // interfaces.IResultMuCallback
        public void onIRSuccess(RegionMudelBean regionMudelBean, boolean z) {
            if (z) {
                u1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                u1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
            } else {
                u1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                u1.a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
                u1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
            }
            e.a.c();
            e.a.d();
            iResultCallback.onIRSuccess(regionMudelBean);
            LocalModuelConfig.this.collectWhiteList(regionMudelBean);
        }
    }

    private static class SingleHodle {
        private static final LocalModuelConfig mConfig = new LocalModuelConfig();

        private SingleHodle() {
        }
    }

    /* synthetic */ LocalModuelConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void collectWhiteList(RegionMudelBean regionMudelBean) {
        List<WhiteTelBean> whiteTelList;
        if (regionMudelBean == null || (whiteTelList = regionMudelBean.getWhiteTelList()) == null || whiteTelList.size() <= 0) {
            return;
        }
        List<WhiteTelBean> list = WelocmPresenter.whiteTelList;
        if (list == null) {
            WelocmPresenter.whiteTelList = whiteTelList;
            return;
        }
        list.clear();
        WelocmPresenter.whiteTelList.addAll(WelocmPresenter.whiteList);
        WelocmPresenter.whiteTelList.addAll(whiteTelList);
    }

    public static LocalModuelConfig getInstance() {
        return SingleHodle.mConfig;
    }

    public RegionMudelBean getConfigJson() {
        RegionMudelBean regionMudelBean = (RegionMudelBean) new e().a(j1.a("config.json", "UTF-8"), new a<RegionMudelBean>() { // from class: bean.module.LocalModuelConfig.1
            AnonymousClass1() {
            }
        }.getType());
        u1.b(ISHAVE_LOCAL, 1);
        u1.a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
        u1.a(LASTCONFIG, regionMudelBean);
        e.a.c();
        e.a.d();
        collectWhiteList(regionMudelBean);
        return regionMudelBean;
    }

    public void getConfigMude(String str, IResultCallback iResultCallback) {
        getConfigMude(str, new IResultMuCallback() { // from class: bean.module.LocalModuelConfig.2
            final /* synthetic */ IResultCallback val$iResult;

            AnonymousClass2(IResultCallback iResultCallback2) {
                iResultCallback = iResultCallback2;
            }

            @Override // interfaces.IResultMuCallback
            public void onIRFail() {
            }

            @Override // interfaces.IResultMuCallback
            public void onIRSuccess(RegionMudelBean regionMudelBean, boolean z) {
                if (z) {
                    u1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    u1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                } else {
                    u1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    u1.a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
                    u1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                }
                e.a.c();
                e.a.d();
                iResultCallback.onIRSuccess(regionMudelBean);
                LocalModuelConfig.this.collectWhiteList(regionMudelBean);
            }
        });
    }

    private LocalModuelConfig() {
    }

    public void getConfigMude(boolean z, IResultCallback iResultCallback) {
        getConfigMude(z, AccountManager.getRegisterRegionCode(), new IResultMuCallback() { // from class: bean.module.LocalModuelConfig.3
            final /* synthetic */ IResultCallback val$iResult;

            AnonymousClass3(IResultCallback iResultCallback2) {
                iResultCallback = iResultCallback2;
            }

            @Override // interfaces.IResultMuCallback
            public void onIRFail() {
            }

            @Override // interfaces.IResultMuCallback
            public void onIRSuccess(RegionMudelBean regionMudelBean, boolean z2) {
                if (z2) {
                    u1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    u1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                } else {
                    u1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    u1.a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
                    u1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                }
                e.a.c();
                e.a.d();
                iResultCallback.onIRSuccess(regionMudelBean);
                LocalModuelConfig.this.collectWhiteList(regionMudelBean);
            }
        });
    }
}
