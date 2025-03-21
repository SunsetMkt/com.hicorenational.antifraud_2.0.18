package bean.module;

import bean.WhiteTelBean;
import com.google.gson.C2051e;
import com.google.gson.p152d0.C2049a;
import interfaces.IResultCallback;
import interfaces.IResultMuCallback;
import java.util.List;
import manager.AccountManager;
import p245d.C4440a;
import p388ui.presenter.WelocmPresenter;
import util.C7277f1;
import util.C7307p1;

/* loaded from: classes.dex */
public class LocalModuelConfig extends ModuelConfig {
    public static String ISHAVE_LOCAL = "sucess_get_config";
    public static String LASTCONFIG = "lastConfig";

    private static class SingleHodle {
        private static final LocalModuelConfig mConfig = new LocalModuelConfig();

        private SingleHodle() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        RegionMudelBean regionMudelBean = (RegionMudelBean) new C2051e().m5570a(C7277f1.m26347a("config.json", "UTF-8"), new C2049a<RegionMudelBean>() { // from class: bean.module.LocalModuelConfig.1
        }.getType());
        C7307p1.m26486b(ISHAVE_LOCAL, 1);
        C7307p1.m26478a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
        C7307p1.m26478a(LASTCONFIG, regionMudelBean);
        C4440a.m16400c();
        C4440a.m16402d();
        collectWhiteList(regionMudelBean);
        return regionMudelBean;
    }

    public void getConfigMude(String str, final IResultCallback iResultCallback) {
        getConfigMude(str, new IResultMuCallback() { // from class: bean.module.LocalModuelConfig.2
            @Override // interfaces.IResultMuCallback
            public void onIRFail() {
            }

            @Override // interfaces.IResultMuCallback
            public void onIRSuccess(RegionMudelBean regionMudelBean, boolean z) {
                if (z) {
                    C7307p1.m26486b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    C7307p1.m26478a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                } else {
                    C7307p1.m26486b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    C7307p1.m26478a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
                    C7307p1.m26478a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                }
                C4440a.m16400c();
                C4440a.m16402d();
                iResultCallback.onIRSuccess(regionMudelBean);
                LocalModuelConfig.this.collectWhiteList(regionMudelBean);
            }
        });
    }

    private LocalModuelConfig() {
    }

    public void getConfigMude(boolean z, final IResultCallback iResultCallback) {
        getConfigMude(z, AccountManager.getRegisterRegionCode(), new IResultMuCallback() { // from class: bean.module.LocalModuelConfig.3
            @Override // interfaces.IResultMuCallback
            public void onIRFail() {
            }

            @Override // interfaces.IResultMuCallback
            public void onIRSuccess(RegionMudelBean regionMudelBean, boolean z2) {
                if (z2) {
                    C7307p1.m26486b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    C7307p1.m26478a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                } else {
                    C7307p1.m26486b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    C7307p1.m26478a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
                    C7307p1.m26478a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                }
                C4440a.m16400c();
                C4440a.m16402d();
                iResultCallback.onIRSuccess(regionMudelBean);
                LocalModuelConfig.this.collectWhiteList(regionMudelBean);
            }
        });
    }
}
