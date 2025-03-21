package p388ui.presenter;

import android.app.Activity;
import android.os.Message;
import interfaces.IFaceLiveCallBack;
import interfaces.IFaceResultView;
import network.account.VerifyBody;
import p388ui.callview.HandleIDVarfyFaceView;

/* loaded from: classes2.dex */
public class HandleIDVarfyFacePresenter extends YCLicencePresenter<HandleIDVarfyFaceView> {

    /* renamed from: ui.presenter.HandleIDVarfyFacePresenter$a */
    class C6992a implements IFaceLiveCallBack {
        C6992a() {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessFail(int i2) {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessSuccess(byte[] bArr) {
            ((HandleIDVarfyFaceView) HandleIDVarfyFacePresenter.this.mvpView).onSuccImaggRequest(bArr);
        }
    }

    /* renamed from: ui.presenter.HandleIDVarfyFacePresenter$b */
    class C6993b implements IFaceResultView {
        C6993b() {
        }

        @Override // interfaces.IFaceResultView
        public void onSuccRequest(Message message) {
            ((HandleIDVarfyFaceView) HandleIDVarfyFacePresenter.this.mvpView).onSuccRequest(message);
        }
    }

    public HandleIDVarfyFacePresenter(Activity activity, HandleIDVarfyFaceView handleIDVarfyFaceView) {
        super(activity, handleIDVarfyFaceView);
    }

    public void startLive() {
        startLiveFace(new C6992a());
    }

    public void verifyAction(String str, String str2, String str3, String str4) {
        VerifyBody verifyBody = new VerifyBody();
        verifyBody.setVerificationLogID(str4);
        verifyBody.setName(str2);
        verifyBody.setIdentityCardNum(str3);
        verifyBody.setImage(str);
        verifyHttp(JNIHandStamp.getInstance().pamramToMap(verifyBody), true, new C6993b());
    }
}
