package ui.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import bean.YcLicenceBean;
import cn.cloudwalk.libproject.Builder;
import cn.cloudwalk.libproject.LiveActivity;
import cn.cloudwalk.libproject.callback.FrontDetectCallback;
import interfaces.IFaceLiveCallBack;
import interfaces.IFaceResultView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.RegisterInfo;
import ui.activity.IDVarfyFaceActivity;
import ui.basemvp.BaseView;
import ui.callview.HandleIDVarfyFaceView;
import ui.callview.VerifyFaceCallview;
import ui.model.ModelPresent;
import util.r1;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class YCLicencePresenter<V extends BaseView> extends ModelPresent<V> {
    public static final String TAG = YCLicencePresenter.class.getSimpleName();
    private final int liveCount;
    private String publicFilePath;

    class a extends MiddleSubscriber<APIresult<YcLicenceBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return YcLicenceBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<YcLicenceBean> aPIresult) {
            YcLicenceBean data = aPIresult.getData();
            if (data == null || TextUtils.isEmpty(data.getAppLicenceCode())) {
                return;
            }
            r1.u.b(data.getAppLicenceCode());
            r1.u.a(data.getAppLicenceVersion());
        }
    }

    class b implements FrontDetectCallback {
        final /* synthetic */ Builder a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ IFaceLiveCallBack f14447b;

        b(Builder builder, IFaceLiveCallBack iFaceLiveCallBack) {
            this.a = builder;
            this.f14447b = iFaceLiveCallBack;
        }

        @Override // cn.cloudwalk.libproject.callback.FrontDetectCallback
        public void onLivenessCancel() {
        }

        @Override // cn.cloudwalk.libproject.callback.FrontDetectCallback
        public void onLivenessFail(int i2) {
            Activity activity = YCLicencePresenter.this.mActivity;
            activity.startActivity(new Intent(activity, (Class<?>) IDVarfyFaceActivity.class));
        }

        @Override // cn.cloudwalk.libproject.callback.FrontDetectCallback
        public void onLivenessSuccess(byte[] bArr, String str, byte[] bArr2, String str2, byte[] bArr3) {
            String str3 = YCLicencePresenter.TAG;
            this.a.setFaceResult(YCLicencePresenter.this.mActivity, 5, 0.0d, "", "");
            this.f14447b.onLivenessSuccess(bArr);
        }
    }

    class c extends MiddleSubscriber<APIresult<RegisterInfo>> {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ IFaceResultView f14449b;

        c(boolean z, IFaceResultView iFaceResultView) {
            this.a = z;
            this.f14449b = iFaceResultView;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return RegisterInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            s1.a("register", "-->onError");
            this.f14449b.onSuccRequest(new Message());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<RegisterInfo> aPIresult) {
            s1.a("register", "-->onNext");
            Message message = new Message();
            if (aPIresult == null) {
                message.what = -1;
            } else {
                int code = aPIresult.getCode();
                if (code == 0) {
                    RegisterInfo data = aPIresult.getData();
                    int responseCode = data.getResponseCode();
                    if (responseCode == 100) {
                        message.what = data.getResult();
                    } else {
                        message.what = responseCode;
                    }
                } else if (code == 3) {
                    if (this.a) {
                        message.what = 8;
                    } else {
                        message.what = 30;
                    }
                } else if (code == 4) {
                    if (!this.a) {
                        message.what = 31;
                    }
                    String msg = aPIresult.getMsg();
                    if (!TextUtils.isEmpty(msg)) {
                        message.obj = msg;
                    }
                } else {
                    String msg2 = aPIresult.getMsg();
                    if (!TextUtils.isEmpty(msg2)) {
                        message.obj = msg2;
                    }
                    message.what = aPIresult.getCode();
                }
            }
            this.f14449b.onSuccRequest(message);
        }
    }

    public YCLicencePresenter(Activity activity) {
        super(activity, (BaseView) null);
        this.liveCount = 3;
        getYCLicence();
    }

    private void getYCLicence() {
        String str = e.a.f10139c + f.b.f10194m;
        HashMap<String, String> map = new HashMap<>();
        map.put("appversion", r1.u.d());
        getYCLicence(map, str, new a());
    }

    public void startLiveFace(IFaceLiveCallBack iFaceLiveCallBack) {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(1004);
        arrayList.add(1005);
        arrayList.add(1000);
        arrayList.add(1001);
        Builder builder = new Builder();
        builder.setLicence(r1.u.t()).setFrontDetectCallback(new b(builder, iFaceLiveCallBack)).isServerLive(false).isFrontHack(true).isResultPage(false).setPublicFilePath(this.publicFilePath).setLives(arrayList, 3, true, false, Builder.liveLevel).startActivity(this.mActivity, LiveActivity.class);
    }

    public void verifyHttp(HashMap<String, String> map, boolean z, IFaceResultView iFaceResultView) {
        String strB = e.a.b("", 3, f.b.N);
        if (z) {
            strB = e.a.f10139c + f.b.t0;
        }
        requessVerifyHttp(strB, map, new c(z, iFaceResultView));
    }

    protected YCLicencePresenter(Activity activity, HandleIDVarfyFaceView handleIDVarfyFaceView) {
        super(activity, handleIDVarfyFaceView);
        this.liveCount = 3;
        getYCLicence();
    }

    protected YCLicencePresenter(Activity activity, VerifyFaceCallview verifyFaceCallview) {
        super(activity, verifyFaceCallview);
        this.liveCount = 3;
        getYCLicence();
    }
}
