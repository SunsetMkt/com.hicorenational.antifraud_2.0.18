package network;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import com.hicorenational.antifraud.C2114a;
import interfaces.IOneClickListener;
import java.lang.reflect.Type;
import manager.AccountManager;
import manager.LoginManager;
import network.account.APIresult;
import p245d.C4441b;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p375l.C5879h;
import p388ui.C6813c;
import p388ui.Hicore;
import p388ui.activity.PoliceLoginActivity;
import p388ui.presenter.JNIHandStamp;
import util.C7257b1;
import util.C7301n1;

/* loaded from: classes2.dex */
public abstract class MiddleSubscriber<T extends APIresult> implements InterfaceC4514i0<T> {
    private static final String TAG = "MiddleSubscriber";
    private Context mContext = Hicore.getApp();

    private APIException accept(Throwable th) {
        if (C2114a.f6317n.booleanValue()) {
            if (th instanceof C5879h) {
                C5879h c5879h = (C5879h) th;
                if (c5879h.code() == 401) {
                    LoginManager.getInstance().exit("授权已过期,请重新登录");
                    return APIException.getApiExcept(401, "");
                }
                if (c5879h.code() == 402) {
                    return APIException.getApiExcept(c5879h.code(), "请求已提交，请勿重复提交。");
                }
            }
            return APIException.getApiExcept(-102, th.getMessage());
        }
        try {
            if (th instanceof APIException) {
                return (APIException) th;
            }
            if (!(th instanceof C5879h)) {
                return APIException.getApiExcept(-102, this.mContext.getResources().getString(C2113R.string.err_timeout));
            }
            if (((C5879h) th).code() != 401) {
                return ((C5879h) th).code() == 402 ? APIException.getApiExcept(((C5879h) th).code(), "请求已提交，请勿重复提交。") : ((C5879h) th).code() == 480 ? APIException.getApiExcept(((C5879h) th).code(), this.mContext.getResources().getString(C2113R.string.err_timeout)) : APIException.getApiExcept(((C5879h) th).code(), this.mContext.getResources().getString(C2113R.string.err_timeout));
            }
            LoginManager.getInstance().exit("授权已过期,请重新登录");
            return APIException.getApiExcept(401, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return APIException.getApiExcept(-102, this.mContext.getResources().getString(C2113R.string.err_timeout));
        }
    }

    protected boolean dealPoliceExit(APIException aPIException) {
        int code = aPIException.getCode();
        if (code == -3) {
            C7257b1.m26210b(C6813c.m25437i().m25446c(), aPIException.getMessage(), "确定", new IOneClickListener() { // from class: network.MiddleSubscriber.4
                @Override // interfaces.IOneClickListener
                public void clickOKBtn() {
                    String m16414b = C4441b.m16414b();
                    if (TextUtils.equals(AccountManager.getAccountPhone(), m16414b) || (TextUtils.isEmpty(m16414b) && (C6813c.m25437i().m25446c() instanceof PoliceLoginActivity))) {
                        LoginManager.getInstance().exitToLogin();
                    } else {
                        LoginManager.getInstance().exitToPoliceLogin();
                    }
                }
            });
            return true;
        }
        if (code == -2) {
            C7257b1.m26210b(C6813c.m25437i().m25446c(), aPIException.getMessage(), "确定", new IOneClickListener() { // from class: network.MiddleSubscriber.3
                @Override // interfaces.IOneClickListener
                public void clickOKBtn() {
                    LoginManager.getInstance().exitToPoliceLogin();
                }
            });
            return true;
        }
        if (code != 401) {
            C7301n1.m26456b("onErrorMiddle switch dealPoliceExit");
            return false;
        }
        C7257b1.m26210b(C6813c.m25437i().m25446c(), aPIException.getMessage(), "确定", new IOneClickListener() { // from class: network.MiddleSubscriber.2
            @Override // interfaces.IOneClickListener
            public void clickOKBtn() {
                LoginManager.getInstance().exitToLogin();
            }
        });
        return true;
    }

    protected Type getType() {
        return new C2049a<String>() { // from class: network.MiddleSubscriber.1
        }.getType();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onComplete() {
        try {
            C7257b1.m26191a();
            onCompleteMiddle();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onCompleteMiddle() {
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onError(Throwable th) {
        C7257b1.m26191a();
        try {
            onErrorMiddle(accept(th));
            C7301n1.m26454a(TAG, "onError: " + th.getMessage());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onErrorMiddle(APIException aPIException) {
    }

    protected void onNextMiddle(T t) {
    }

    protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        onStartMiddle(interfaceC4552c);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onNext(T t) {
        C7257b1.m26191a();
        try {
            int code = t.getCode();
            if (code == 999) {
                t.setMsg(Hicore.getApp().getResources().getString(C2113R.string.err_system));
            } else if (code == -102) {
                t = (T) JNIHandStamp.getInstance().analyzeParam(t, getType());
            }
            onNextMiddle(t);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
