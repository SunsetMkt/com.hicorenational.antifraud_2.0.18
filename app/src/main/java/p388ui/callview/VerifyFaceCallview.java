package p388ui.callview;

import android.os.Message;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface VerifyFaceCallview extends BaseView {
    void onSuccImaggRequest(byte[] bArr);

    void onSuccRequest(Message message);

    void onSuccessRedName(boolean z);

    void onSuccessUnbind();

    void onSuccessUnbindOverrun();
}
