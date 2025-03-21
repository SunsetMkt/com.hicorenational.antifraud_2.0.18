package p388ui.presenter;

import android.app.Activity;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.CriminalPhoneView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* compiled from: CriminalPhonePresenter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e¨\u0006\u0012"}, m23546d2 = {"Lui/presenter/CriminalPhonePresenter;", "Lui/model/ModelPresent;", "Lui/callview/CriminalPhoneView;", "activity", "Landroid/app/Activity;", "callview", "(Landroid/app/Activity;Lui/callview/CriminalPhoneView;)V", "criminalCallSave", "", "bean", "Lbean/CallBean;", "getCriminakTel", "getCriminalCallList", "caseInfoID", "", "getCriminalCallNum", "removecalltel", "callTelInfoID", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CriminalPhonePresenter extends ModelPresent<CriminalPhoneView> {

    /* compiled from: CriminalPhonePresenter.kt */
    /* renamed from: ui.presenter.CriminalPhonePresenter$a */
    public static final class C6955a extends MiddleSubscriber<APIresult<CallBean>> {
        C6955a() {
        }

        @Override // network.MiddleSubscriber
        @InterfaceC5816d
        protected Type getType() {
            return CallBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5817e APIException aPIException) {
            C7331w1.m26688a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5816d APIresult<CallBean> aPIresult) {
            C5544i0.m22546f(aPIresult, "result");
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
                return;
            }
            CriminalPhoneView criminalPhoneView = (CriminalPhoneView) CriminalPhonePresenter.this.mvpView;
            CallBean data = aPIresult.getData();
            C5544i0.m22521a((Object) data, "result?.data");
            criminalPhoneView.onSuccessSave(data);
        }
    }

    /* compiled from: CriminalPhonePresenter.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0014¨\u0006\r"}, m23546d2 = {"ui/presenter/CriminalPhonePresenter$getCriminakTel$1", "Lnetwork/MiddleSubscriber;", "Lnetwork/account/APIresult;", "", "", "getType", "Ljava/lang/reflect/Type;", "onErrorMiddle", "", "e", "Lnetwork/APIException;", "onNextMiddle", "resultInfo", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: ui.presenter.CriminalPhonePresenter$b */
    public static final class C6956b extends MiddleSubscriber<APIresult<List<? extends String>>> {

        /* compiled from: CriminalPhonePresenter.kt */
        /* renamed from: ui.presenter.CriminalPhonePresenter$b$a */
        public static final class a extends C2049a<List<? extends String>> {
            a() {
            }
        }

        C6956b() {
        }

        @Override // network.MiddleSubscriber
        @InterfaceC5816d
        protected Type getType() {
            Type type = new a().getType();
            C5544i0.m22521a((Object) type, "object : TypeToken<List<String>>() {}.type");
            return type;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5816d APIException aPIException) {
            C5544i0.m22546f(aPIException, "e");
            super.onErrorMiddle(aPIException);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5816d APIresult<List<? extends String>> aPIresult) {
            C5544i0.m22546f(aPIresult, "resultInfo");
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                return;
            }
            CriminalPhoneView criminalPhoneView = (CriminalPhoneView) CriminalPhonePresenter.this.mvpView;
            List<? extends String> data = aPIresult.getData();
            C5544i0.m22521a((Object) data, "resultInfo.data");
            criminalPhoneView.onSuccess(data);
        }
    }

    /* compiled from: CriminalPhonePresenter.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u001e\u0010\u000b\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0014¨\u0006\r"}, m23546d2 = {"ui/presenter/CriminalPhonePresenter$getCriminalCallList$1", "Lnetwork/MiddleSubscriber;", "Lnetwork/account/APIresult;", "", "Lbean/CallBean;", "getType", "Ljava/lang/reflect/Type;", "onErrorMiddle", "", "exception", "Lnetwork/APIException;", "onNextMiddle", "result", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: ui.presenter.CriminalPhonePresenter$c */
    public static final class C6957c extends MiddleSubscriber<APIresult<List<? extends CallBean>>> {

        /* compiled from: CriminalPhonePresenter.kt */
        /* renamed from: ui.presenter.CriminalPhonePresenter$c$a */
        public static final class a extends C2049a<List<? extends CallBean>> {
            a() {
            }
        }

        C6957c() {
        }

        @Override // network.MiddleSubscriber
        @InterfaceC5816d
        protected Type getType() {
            Type type = new a().getType();
            C5544i0.m22521a((Object) type, "object : TypeToken<List<CallBean>>() {}.type");
            return type;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5817e APIException aPIException) {
            C7331w1.m26688a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5817e APIresult<List<? extends CallBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
                return;
            }
            CriminalPhoneView criminalPhoneView = (CriminalPhoneView) CriminalPhonePresenter.this.mvpView;
            List<? extends CallBean> data = aPIresult.getData();
            C5544i0.m22521a((Object) data, "result?.data");
            criminalPhoneView.onSuccessList(data);
        }
    }

    /* compiled from: CriminalPhonePresenter.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0018\u0010\n\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¨\u0006\f"}, m23546d2 = {"ui/presenter/CriminalPhonePresenter$getCriminalCallNum$1", "Lnetwork/MiddleSubscriber;", "Lnetwork/account/APIresult;", "Lbean/CriminalPhoneNumBean;", "getType", "Ljava/lang/reflect/Type;", "onErrorMiddle", "", "exception", "Lnetwork/APIException;", "onNextMiddle", "result", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: ui.presenter.CriminalPhonePresenter$d */
    public static final class C6958d extends MiddleSubscriber<APIresult<CriminalPhoneNumBean>> {

        /* compiled from: CriminalPhonePresenter.kt */
        /* renamed from: ui.presenter.CriminalPhonePresenter$d$a */
        public static final class a extends C2049a<CriminalPhoneNumBean> {
            a() {
            }
        }

        C6958d() {
        }

        @Override // network.MiddleSubscriber
        @InterfaceC5816d
        protected Type getType() {
            Type type = new a().getType();
            C5544i0.m22521a((Object) type, "object : TypeToken<CriminalPhoneNumBean>() {}.type");
            return type;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5817e APIException aPIException) {
            C7331w1.m26688a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5817e APIresult<CriminalPhoneNumBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
                return;
            }
            CriminalPhoneView criminalPhoneView = (CriminalPhoneView) CriminalPhonePresenter.this.mvpView;
            CriminalPhoneNumBean data = aPIresult.getData();
            C5544i0.m22521a((Object) data, "result?.data");
            criminalPhoneView.onSuccessPhoneNum(data);
        }
    }

    /* compiled from: CriminalPhonePresenter.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014¨\u0006\f"}, m23546d2 = {"ui/presenter/CriminalPhonePresenter$removecalltel$1", "Lnetwork/MiddleSubscriber;", "Lnetwork/account/APIresult;", "", "getType", "Ljava/lang/reflect/Type;", "onErrorMiddle", "", "e", "Lnetwork/APIException;", "onNextMiddle", "resultInfo", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: ui.presenter.CriminalPhonePresenter$e */
    public static final class C6959e extends MiddleSubscriber<APIresult<String>> {

        /* compiled from: CriminalPhonePresenter.kt */
        /* renamed from: ui.presenter.CriminalPhonePresenter$e$a */
        public static final class a extends C2049a<List<? extends String>> {
            a() {
            }
        }

        C6959e() {
        }

        @Override // network.MiddleSubscriber
        @InterfaceC5816d
        protected Type getType() {
            Type type = new a().getType();
            C5544i0.m22521a((Object) type, "object : TypeToken<List<String>>() {}.type");
            return type;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5816d APIException aPIException) {
            C5544i0.m22546f(aPIException, "e");
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5816d APIresult<String> aPIresult) {
            C5544i0.m22546f(aPIresult, "resultInfo");
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((CriminalPhoneView) CriminalPhonePresenter.this.mvpView).onSuccessRemove();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriminalPhonePresenter(@InterfaceC5816d Activity activity, @InterfaceC5816d CriminalPhoneView criminalPhoneView) {
        super(activity, criminalPhoneView);
        C5544i0.m22546f(activity, "activity");
        C5544i0.m22546f(criminalPhoneView, "callview");
    }

    public final void criminalCallSave(@InterfaceC5816d CallBean callBean) {
        C5544i0.m22546f(callBean, "bean");
        criminalCallSave(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17140x1), callBean, new C6955a());
    }

    public final void getCriminakTel() {
        getsocialtels(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17146z1), new C6956b());
    }

    public final void getCriminalCallList(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "caseInfoID");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getCriminalPhoneList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17137w1), hashMap, new C6957c());
    }

    public final void getCriminalCallNum(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "caseInfoID");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getCriminalCallNum(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17134v1), hashMap, new C6958d());
    }

    public final void removecalltel(@InterfaceC5816d String str, @InterfaceC5816d String str2) {
        C5544i0.m22546f(str, "caseInfoID");
        C5544i0.m22546f(str2, "callTelInfoID");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        hashMap.put("callTelInfoID", str2);
        removecalltel(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17143y1), hashMap, new C6959e());
    }
}
