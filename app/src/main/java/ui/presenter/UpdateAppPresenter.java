package ui.presenter;

import android.app.Activity;
import bean.APIH5Bean;
import interfaces.IBaseBeanCall;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.DownloadInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.RegisterBody;
import ui.callview.UpdateAppView;
import ui.model.ModelPresent;
import util.UpdateUtil;
import util.d2;
import util.x1;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateAppPresenter extends ModelPresent<UpdateAppView> {

    class a extends MiddleSubscriber<APIresult<DownloadInfo>> {
        final /* synthetic */ IBaseBeanCall a;

        a(IBaseBeanCall iBaseBeanCall) {
            this.a = iBaseBeanCall;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return DownloadInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            IBaseBeanCall iBaseBeanCall = this.a;
            if (iBaseBeanCall != null) {
                iBaseBeanCall.onfail();
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<DownloadInfo> aPIresult) {
            ((UpdateAppView) UpdateAppPresenter.this.mvpView).onSuccRequest(aPIresult, this.a);
            UpdateUtil.isCheckUpdateAlready = true;
        }
    }

    public UpdateAppPresenter(Activity activity, UpdateAppView updateAppView) {
        super(activity, updateAppView);
    }

    private void updateApp(HashMap<String, String> map, IBaseBeanCall iBaseBeanCall) {
        updateApp(map, e.a.f10139c + f.b.f10183b, new a(iBaseBeanCall));
    }

    public void principalHttp(IBaseBeanCall iBaseBeanCall) {
        String strL = d2.l();
        RegisterBody registerBody = new RegisterBody();
        registerBody.setImei(strL);
        registerBody.setInnerversion(x1.f() + "");
        updateApp(JNIHandStamp.getInstance().pamramToMap(registerBody), iBaseBeanCall);
    }

    public void requestAppDownload(MiddleSubscriber<APIresult<APIH5Bean>> middleSubscriber) {
        String str = e.a.f10139c + f.b.f10192k;
        HashMap<String, String> map = new HashMap<>();
        map.put("dictionarykey", "AndroidDownloadURL");
        requestAppConfig(map, str, middleSubscriber);
    }
}
