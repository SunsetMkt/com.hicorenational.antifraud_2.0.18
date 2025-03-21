package network;

import android.text.TextUtils;
import com.hicorenational.antifraud.C2113R;
import network.account.APIresult;
import p388ui.Hicore;

/* loaded from: classes2.dex */
public class APIException extends RuntimeException {
    public static final int CODE_TOKEN_INVALID = 401;
    public static final int NO_NETWORK_CODE = -10001;
    private int code;

    private APIException(int i2, String str) {
        super(str);
        this.code = i2;
    }

    public static APIException getApiExcept() {
        return getApiExcept(-102, Hicore.getApp().getResources().getString(C2113R.string.err_timeout));
    }

    public int getCode() {
        return this.code;
    }

    public boolean isNoNetwork() {
        return this.code == -10001;
    }

    public boolean isTokenInvalid() {
        return this.code == 401;
    }

    public static APIException getApiExcept(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Hicore.getApp().getResources().getString(C2113R.string.err_timeout);
        }
        return getApiExcept(-102, str);
    }

    public static APIException getApiExcept(APIresult aPIresult) {
        int i2;
        String string = Hicore.getApp().getString(C2113R.string.err_timeout);
        if (aPIresult != null) {
            i2 = aPIresult.getCode();
            if (!TextUtils.isEmpty(aPIresult.getMsg())) {
                string = aPIresult.getMsg();
            }
        } else {
            i2 = -102;
        }
        return getApiExcept(i2, string);
    }

    public static synchronized APIException getApiExcept(int i2, String str) {
        APIException aPIException;
        synchronized (APIException.class) {
            aPIException = new APIException(i2, str);
        }
        return aPIException;
    }
}
