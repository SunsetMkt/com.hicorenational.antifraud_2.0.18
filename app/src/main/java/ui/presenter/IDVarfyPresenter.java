package ui.presenter;

import android.app.Activity;
import bean.IDVarfyBean;
import bean.VerifyAcceptBean;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.IdVartyCallView;
import ui.model.ModelPresent;

/* JADX INFO: loaded from: classes2.dex */
public class IDVarfyPresenter extends ModelPresent<IdVartyCallView> {

    class a extends MiddleSubscriber<APIresult<IDVarfyBean>> {

        /* JADX INFO: renamed from: ui.presenter.IDVarfyPresenter$a$a, reason: collision with other inner class name */
        class C0305a extends com.google.gson.d0.a<IDVarfyBean> {
            C0305a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0305a().getType();
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
        protected void onStartMiddle(h.a.u0.c cVar) {
            super.onStartMiddle(cVar);
        }
    }

    class b extends MiddleSubscriber<APIresult<List<VerifyAcceptBean>>> {

        class a extends com.google.gson.d0.a<List<VerifyAcceptBean>> {
            a() {
            }
        }

        b() {
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
        HashMap map = new HashMap();
        map.put("page", i2 + "");
        map.put("rows", i3 + "");
        map.put("sort", "updateTime");
        map.put("order", SocialConstants.PARAM_APP_DESC);
        getVerifyList(map);
    }

    public void getVerifyAcceptList() {
        getVerifyAcceptList(e.a.f10139c + f.b.r0, new b());
    }

    public void getVerifyList(HashMap map) {
        getVerifyList(map, e.a.f10139c + f.b.s0, new a());
    }
}
