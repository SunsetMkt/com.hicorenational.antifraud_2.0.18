package p388ui.presenter;

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
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.UpdateAppView;
import p388ui.model.ModelPresent;
import util.C7316r1;
import util.C7328v1;
import util.UpdateUtil;

/* loaded from: classes2.dex */
public class UpdateAppPresenter extends ModelPresent<UpdateAppView> {

    /* renamed from: ui.presenter.UpdateAppPresenter$a */
    class C7102a extends MiddleSubscriber<APIresult<DownloadInfo>> {

        /* renamed from: a */
        final /* synthetic */ IBaseBeanCall f24351a;

        C7102a(IBaseBeanCall iBaseBeanCall) {
            this.f24351a = iBaseBeanCall;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return DownloadInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            IBaseBeanCall iBaseBeanCall = this.f24351a;
            if (iBaseBeanCall != null) {
                iBaseBeanCall.onfail();
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<DownloadInfo> aPIresult) {
            ((UpdateAppView) UpdateAppPresenter.this.mvpView).onSuccRequest(aPIresult, this.f24351a);
            UpdateUtil.isCheckUpdateAlready = true;
        }
    }

    public UpdateAppPresenter(Activity activity, UpdateAppView updateAppView) {
        super(activity, updateAppView);
    }

    private void updateApp(HashMap<String, String> hashMap, IBaseBeanCall iBaseBeanCall) {
        updateApp(hashMap, C4440a.f16881c + C4445b.f17067b, new C7102a(iBaseBeanCall));
    }

    public void principalHttp(IBaseBeanCall iBaseBeanCall) {
        String m26674l = C7328v1.m26674l();
        RegisterBody registerBody = new RegisterBody();
        registerBody.setImei(m26674l);
        registerBody.setInnerversion(C7316r1.m26553f() + "");
        updateApp(JNIHandStamp.getInstance().pamramToMap(registerBody), iBaseBeanCall);
    }

    public void requestAppDownload(MiddleSubscriber<APIresult<APIH5Bean>> middleSubscriber) {
        String str = C4440a.f16881c + C4445b.f17099k;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("dictionarykey", "AndroidDownloadURL");
        requestAppConfig(hashMap, str, middleSubscriber);
    }
}
