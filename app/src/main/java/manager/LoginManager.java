package manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hicorenational.antifraud.C2113R;
import network.account.AccountInfo;
import org.greenrobot.eventbus.C6049c;
import p245d.C4441b;
import p388ui.C6813c;
import p388ui.Hicore;
import p388ui.activity.LoginActivity;
import p388ui.activity.MainActivity;
import p388ui.activity.PoliceLoginActivity;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class LoginManager {
    private static Activity activity;

    private static class SingletonHolder {
        private static final LoginManager managerLogin = new LoginManager();

        private SingletonHolder() {
        }
    }

    /* synthetic */ LoginManager(C59381 c59381) {
        this();
    }

    private void exitToLoginSimple() {
        C6813c.m25437i().m25450e();
        C7337y1.m26748a((Context) activity, (Class<?>) LoginActivity.class);
        activity.finish();
    }

    public static LoginManager getInstance() {
        activity = C6813c.m25437i().m25446c();
        return SingletonHolder.managerLogin;
    }

    public void cleanLoginMsg() {
        C6049c.m24987f().m24998c();
        AccountManager.loginOut();
        C4441b.m16417e();
    }

    public void exit() {
        exit("");
    }

    public void exitToLogin() {
        if (AccountManager.isLogin() || !(C6813c.m25437i().m25446c() instanceof LoginActivity)) {
            String visiblePhone = AccountManager.getVisiblePhone();
            cleanLoginMsg();
            AccountManager.saveAccount(new AccountInfo(), visiblePhone);
            exitToLoginSimple();
        }
    }

    public void exitToPoliceLogin() {
        C4441b.m16417e();
        C6813c.m25437i().m25451f();
        Activity activity2 = activity;
        activity2.startActivity(new Intent(activity2, (Class<?>) PoliceLoginActivity.class));
        activity.finish();
    }

    public void exitoLoginNoPhone() {
        if (AccountManager.isLogin() || !(C6813c.m25437i().m25446c() instanceof LoginActivity)) {
            cleanLoginMsg();
            exitToLoginSimple();
        }
    }

    public boolean isLogOut() {
        if (AccountManager.isLogin()) {
            return false;
        }
        C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.login_exit));
        exitToLoginSimple();
        return true;
    }

    public void turnFocusMainPage() {
        C6813c.m25437i().m25451f();
        Bundle bundle = new Bundle();
        bundle.putInt(C7292k1.f25394d, 480);
        C7337y1.m26749a(activity, (Class<?>) MainActivity.class, bundle);
    }

    private LoginManager() {
    }

    public void exit(String str) {
        if (AccountManager.isLogin() || !(C6813c.m25437i().m25446c() instanceof LoginActivity)) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = Hicore.getApp().getResources().getString(C2113R.string.login_exit);
                }
                C7331w1.m26688a(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            exitToLogin();
        }
    }
}
