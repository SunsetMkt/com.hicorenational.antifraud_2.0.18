package p388ui.presenter;

import android.app.Activity;
import bean.IDVarfyBean;
import bean.VerifyAcceptBean;
import com.google.gson.p152d0.C2049a;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.callview.IdVartyCallView;
import p388ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class IDVarfyPresenter extends ModelPresent<IdVartyCallView> {

    /* renamed from: ui.presenter.IDVarfyPresenter$a */
    class C7009a extends MiddleSubscriber<APIresult<IDVarfyBean>> {

        /* renamed from: ui.presenter.IDVarfyPresenter$a$a */
        class a extends C2049a<IDVarfyBean> {
            a() {
            }
        }

        C7009a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((IdVartyCallView) IDVarfyPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<IDVarfyBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((IdVartyCallView) IDVarfyPresenter.this.mvpView).onSuccessRequest(aPIresult.getData().rows);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            super.onStartMiddle(interfaceC4552c);
        }
    }

    /* renamed from: ui.presenter.IDVarfyPresenter$b */
    class C7010b extends MiddleSubscriber<APIresult<List<VerifyAcceptBean>>> {

        /* renamed from: ui.presenter.IDVarfyPresenter$b$a */
        class a extends C2049a<List<VerifyAcceptBean>> {
            a() {
            }
        }

        C7010b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((IdVartyCallView) IDVarfyPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<VerifyAcceptBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((IdVartyCallView) IDVarfyPresenter.this.mvpView).onSuccessAccRequest(aPIresult.getData());
            }
        }
    }

    public IDVarfyPresenter(Activity activity, IdVartyCallView idVartyCallView) {
        super(activity, idVartyCallView);
    }

    public void ListPrincipalHttp(int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", i2 + "");
        hashMap.put("rows", i3 + "");
        hashMap.put("sort", "updateTime");
        hashMap.put("order", SocialConstants.PARAM_APP_DESC);
        getVerifyList(hashMap);
    }

    public void getVerifyAcceptList() {
        getVerifyAcceptList(C4440a.f16881c + C4445b.f17118q0, new C7010b());
    }

    public void getVerifyList(HashMap hashMap) {
        getVerifyList(hashMap, C4440a.f16881c + C4445b.f17121r0, new C7009a());
    }
}
