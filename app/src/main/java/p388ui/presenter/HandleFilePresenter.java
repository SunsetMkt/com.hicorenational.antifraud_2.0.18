package p388ui.presenter;

import android.app.Activity;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import interfaces.IOssPicCallback;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.model.OSSModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class HandleFilePresenter extends OSSModelPresent {

    /* renamed from: ui.presenter.HandleFilePresenter$a */
    class C6988a implements IOssPicCallback {

        /* renamed from: a */
        final /* synthetic */ InterfaceC6991d f24102a;

        C6988a(InterfaceC6991d interfaceC6991d) {
            this.f24102a = interfaceC6991d;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            this.f24102a.onfail();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.f24102a.onSuccess(ossFileInfo);
        }
    }

    /* renamed from: ui.presenter.HandleFilePresenter$b */
    class C6989b extends MiddleSubscriber<APIresult> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC6990c f24104a;

        C6989b(InterfaceC6990c interfaceC6990c) {
            this.f24104a = interfaceC6990c;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e("删除失败，请重试");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            this.f24104a.onSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
        }
    }

    /* renamed from: ui.presenter.HandleFilePresenter$c */
    public interface InterfaceC6990c {
        void onSuccRequest(APIresult aPIresult);
    }

    /* renamed from: ui.presenter.HandleFilePresenter$d */
    public interface InterfaceC6991d {
        void onSuccess(OssFileInfo ossFileInfo);

        void onfail();
    }

    public HandleFilePresenter(Activity activity) {
        super(activity, null);
    }

    public void cancelUpdateHttp(HashMap<String, String> hashMap, InterfaceC6990c interfaceC6990c) {
        cancelUpdateHttp(hashMap, C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17072c0), new C6989b(interfaceC6990c));
    }

    public void ossUpload(String str, InterfaceC6991d interfaceC6991d) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("1");
        ossFileRequest.setFilePath(str);
        upFileToOss(ossFileRequest, new C6988a(interfaceC6991d));
    }
}
