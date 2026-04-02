package ui.presenter;

import android.app.Activity;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import interfaces.IOssPicCallback;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.model.OSSModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class HandleFilePresenter extends OSSModelPresent {

    class a implements IOssPicCallback {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            this.a.onfail();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.a.onSuccess(ossFileInfo);
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e("\u5220\u9664\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            this.a.onSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
        }
    }

    public interface c {
        void onSuccRequest(APIresult aPIresult);
    }

    public interface d {
        void onSuccess(OssFileInfo ossFileInfo);

        void onfail();
    }

    public HandleFilePresenter(Activity activity) {
        super(activity, null);
    }

    public void cancelUpdateHttp(HashMap<String, String> map, c cVar) {
        cancelUpdateHttp(map, e.a.b(ModuelConfig.MODEL_REPORT, 5, f.b.d0), new b(cVar));
    }

    public void ossUpload(String str, d dVar) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("1");
        ossFileRequest.setFilePath(str);
        upFileToOss(ossFileRequest, new a(dVar));
    }
}
