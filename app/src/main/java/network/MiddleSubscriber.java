package network;

import android.content.Context;
import android.text.TextUtils;
import com.hicorenational.antifraud.R;
import h.a.i0;
import interfaces.IOneClickListener;
import java.lang.reflect.Type;
import m.h;
import manager.AccountManager;
import manager.LoginManager;
import network.account.APIresult;
import ui.Hicore;
import ui.activity.PoliceLoginActivity;
import ui.c;
import ui.presenter.JNIHandStamp;
import util.f1;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MiddleSubscriber<T extends APIresult> implements i0<T> {
    private static final String TAG = "MiddleSubscriber";
    private Context mContext = Hicore.getApp();

    /* JADX INFO: renamed from: network.MiddleSubscriber$1 */
    class AnonymousClass1 extends com.google.gson.d0.a<String> {
        AnonymousClass1() {
        }
    }

    /* JADX INFO: renamed from: network.MiddleSubscriber$2 */
    class AnonymousClass2 implements IOneClickListener {
        AnonymousClass2() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            LoginManager.getInstance().exitToLogin();
        }
    }

    /* JADX INFO: renamed from: network.MiddleSubscriber$3 */
    class AnonymousClass3 implements IOneClickListener {
        AnonymousClass3() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            LoginManager.getInstance().exitToPoliceLogin();
        }
    }

    /* JADX INFO: renamed from: network.MiddleSubscriber$4 */
    class AnonymousClass4 implements IOneClickListener {
        AnonymousClass4() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            String strB = e.b.b();
            if (TextUtils.equals(AccountManager.getAccountPhone(), strB) || (TextUtils.isEmpty(strB) && (c.i().c() instanceof PoliceLoginActivity))) {
                LoginManager.getInstance().exitToLogin();
            } else {
                LoginManager.getInstance().exitToPoliceLogin();
            }
        }
    }

    private APIException accept(Throwable th) {
        if (com.hicorenational.antifraud.a.f3991n.booleanValue()) {
            if (th instanceof h) {
                h hVar = (h) th;
                if (hVar.code() == 401) {
                    LoginManager.getInstance().exit("\u6388\u6743\u5df2\u8fc7\u671f,\u8bf7\u91cd\u65b0\u767b\u5f55");
                    return APIException.getApiExcept(401, "");
                }
                if (hVar.code() == 402) {
                    return APIException.getApiExcept(hVar.code(), "\u8bf7\u6c42\u5df2\u63d0\u4ea4\uff0c\u8bf7\u52ff\u91cd\u590d\u63d0\u4ea4\u3002");
                }
            }
            return APIException.getApiExcept(-102, th.getMessage());
        }
        try {
            if (th instanceof APIException) {
                return (APIException) th;
            }
            if (!(th instanceof h)) {
                return APIException.getApiExcept(-102, this.mContext.getResources().getString(R.string.err_timeout));
            }
            if (((h) th).code() != 401) {
                return ((h) th).code() == 402 ? APIException.getApiExcept(((h) th).code(), "\u8bf7\u6c42\u5df2\u63d0\u4ea4\uff0c\u8bf7\u52ff\u91cd\u590d\u63d0\u4ea4\u3002") : ((h) th).code() == 480 ? APIException.getApiExcept(((h) th).code(), this.mContext.getResources().getString(R.string.err_timeout)) : APIException.getApiExcept(((h) th).code(), this.mContext.getResources().getString(R.string.err_timeout));
            }
            LoginManager.getInstance().exit("\u6388\u6743\u5df2\u8fc7\u671f,\u8bf7\u91cd\u65b0\u767b\u5f55");
            return APIException.getApiExcept(401, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return APIException.getApiExcept(-102, this.mContext.getResources().getString(R.string.err_timeout));
        }
    }

    protected boolean dealPoliceExit(APIException aPIException) {
        int code = aPIException.getCode();
        if (code == -3) {
            f1.b(c.i().c(), aPIException.getMessage(), "\u786e\u5b9a", new IOneClickListener() { // from class: network.MiddleSubscriber.4
                AnonymousClass4() {
                }

                @Override // interfaces.IOneClickListener
                public void clickOKBtn() {
                    String strB = e.b.b();
                    if (TextUtils.equals(AccountManager.getAccountPhone(), strB) || (TextUtils.isEmpty(strB) && (c.i().c() instanceof PoliceLoginActivity))) {
                        LoginManager.getInstance().exitToLogin();
                    } else {
                        LoginManager.getInstance().exitToPoliceLogin();
                    }
                }
            });
            return true;
        }
        if (code == -2) {
            f1.b(c.i().c(), aPIException.getMessage(), "\u786e\u5b9a", new IOneClickListener() { // from class: network.MiddleSubscriber.3
                AnonymousClass3() {
                }

                @Override // interfaces.IOneClickListener
                public void clickOKBtn() {
                    LoginManager.getInstance().exitToPoliceLogin();
                }
            });
            return true;
        }
        if (code != 401) {
            s1.b("onErrorMiddle switch dealPoliceExit");
            return false;
        }
        f1.b(c.i().c(), aPIException.getMessage(), "\u786e\u5b9a", new IOneClickListener() { // from class: network.MiddleSubscriber.2
            AnonymousClass2() {
            }

            @Override // interfaces.IOneClickListener
            public void clickOKBtn() {
                LoginManager.getInstance().exitToLogin();
            }
        });
        return true;
    }

    protected Type getType() {
        return new com.google.gson.d0.a<String>() { // from class: network.MiddleSubscriber.1
            AnonymousClass1() {
            }
        }.getType();
    }

    @Override // h.a.i0
    public final void onComplete() {
        try {
            f1.a();
            onCompleteMiddle();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onCompleteMiddle() {
    }

    @Override // h.a.i0
    public final void onError(Throwable th) {
        f1.a();
        try {
            onErrorMiddle(accept(th));
            s1.a(TAG, "onError: " + th.getMessage());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onErrorMiddle(APIException aPIException) {
    }

    protected void onNextMiddle(T t) {
    }

    protected void onStartMiddle(h.a.u0.c cVar) {
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        onStartMiddle(cVar);
    }

    @Override // h.a.i0
    public final void onNext(T t) {
        f1.a();
        try {
            int code = t.getCode();
            if (code == 999) {
                t.setMsg(Hicore.getApp().getResources().getString(R.string.err_system));
            } else if (code == -102) {
                t = (T) JNIHandStamp.getInstance().analyzeParam(t, getType());
            }
            onNextMiddle(t);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
