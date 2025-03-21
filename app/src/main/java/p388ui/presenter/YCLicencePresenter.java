package p388ui.presenter;

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
import p245d.C4440a;
import p247e.C4445b;
import p388ui.activity.IDVarfyFaceActivity;
import p388ui.basemvp.BaseView;
import p388ui.callview.HandleIDVarfyFaceView;
import p388ui.callview.VerifyFaceCallview;
import p388ui.model.ModelPresent;
import util.C7298m1;
import util.C7301n1;

/* loaded from: classes2.dex */
public class YCLicencePresenter<V extends BaseView> extends ModelPresent<V> {
    public static final String TAG = YCLicencePresenter.class.getSimpleName();
    private final int liveCount;
    private String publicFilePath;

    /* renamed from: ui.presenter.YCLicencePresenter$a */
    class C7125a extends MiddleSubscriber<APIresult<YcLicenceBean>> {
        C7125a() {
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
            C7298m1.f25474u.m26434b(data.getAppLicenceCode());
            C7298m1.f25474u.m26432a(data.getAppLicenceVersion());
        }
    }

    /* renamed from: ui.presenter.YCLicencePresenter$b */
    class C7126b implements FrontDetectCallback {

        /* renamed from: a */
        final /* synthetic */ Builder f24384a;

        /* renamed from: b */
        final /* synthetic */ IFaceLiveCallBack f24385b;

        C7126b(Builder builder, IFaceLiveCallBack iFaceLiveCallBack) {
            this.f24384a = builder;
            this.f24385b = iFaceLiveCallBack;
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
            this.f24384a.setFaceResult(YCLicencePresenter.this.mActivity, 5, 0.0d, "", "");
            this.f24385b.onLivenessSuccess(bArr);
        }
    }

    /* renamed from: ui.presenter.YCLicencePresenter$c */
    class C7127c extends MiddleSubscriber<APIresult<RegisterInfo>> {

        /* renamed from: a */
        final /* synthetic */ boolean f24387a;

        /* renamed from: b */
        final /* synthetic */ IFaceResultView f24388b;

        C7127c(boolean z, IFaceResultView iFaceResultView) {
            this.f24387a = z;
            this.f24388b = iFaceResultView;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return RegisterInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7301n1.m26454a("register", "-->onError");
            this.f24388b.onSuccRequest(new Message());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<RegisterInfo> aPIresult) {
            C7301n1.m26454a("register", "-->onNext");
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
                    if (this.f24387a) {
                        message.what = 8;
                    } else {
                        message.what = 30;
                    }
                } else if (code == 4) {
                    if (!this.f24387a) {
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
            this.f24388b.onSuccRequest(message);
        }
    }

    public YCLicencePresenter(Activity activity) {
        super(activity, (BaseView) null);
        this.liveCount = 3;
        getYCLicence();
    }

    private void getYCLicence() {
        String str = C4440a.f16881c + C4445b.f17102l;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appversion", C7298m1.f25474u.m26436d());
        getYCLicence(hashMap, str, new C7125a());
    }

    public void startLiveFace(IFaceLiveCallBack iFaceLiveCallBack) {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(1004);
        arrayList.add(1005);
        arrayList.add(1000);
        arrayList.add(1001);
        Builder builder = new Builder();
        builder.setLicence(C7298m1.f25474u.m26452t()).setFrontDetectCallback(new C7126b(builder, iFaceLiveCallBack)).isServerLive(false).isFrontHack(true).isResultPage(false).setPublicFilePath(this.publicFilePath).setLives(arrayList, 3, true, false, Builder.liveLevel).startActivity(this.mActivity, LiveActivity.class);
    }

    public void verifyHttp(HashMap<String, String> hashMap, boolean z, IFaceResultView iFaceResultView) {
        String m16395a = C4440a.m16395a("", 3, C4445b.f17021M);
        if (z) {
            m16395a = C4440a.f16881c + C4445b.f17124s0;
        }
        requessVerifyHttp(m16395a, hashMap, new C7127c(z, iFaceResultView));
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
