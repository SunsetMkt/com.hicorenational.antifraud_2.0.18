package bean;

import network.BaseBean;
import p286h.InterfaceC5713y;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: StopPaymentBean.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, m23546d2 = {"Lbean/StopPaymentBean;", "Lnetwork/BaseBean;", "()V", "paymentTime", "", "getPaymentTime", "()Ljava/lang/String;", "setPaymentTime", "(Ljava/lang/String;)V", "suspectAccount", "getSuspectAccount", "setSuspectAccount", "suspectAccountType", "getSuspectAccountType", "setSuspectAccountType", "suspectAccountTypeText", "getSuspectAccountTypeText", "setSuspectAccountTypeText", "suspectName", "getSuspectName", "setSuspectName", "transferAmount", "getTransferAmount", "setTransferAmount", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class StopPaymentBean extends BaseBean {

    @InterfaceC5817e
    private String paymentTime = "";

    @InterfaceC5817e
    private String suspectAccountType = "";

    @InterfaceC5817e
    private String suspectAccountTypeText = "";

    @InterfaceC5817e
    private String suspectAccount = "";

    @InterfaceC5817e
    private String suspectName = "";

    @InterfaceC5817e
    private String transferAmount = "";

    @InterfaceC5817e
    public final String getPaymentTime() {
        return this.paymentTime;
    }

    @InterfaceC5817e
    public final String getSuspectAccount() {
        return this.suspectAccount;
    }

    @InterfaceC5817e
    public final String getSuspectAccountType() {
        return this.suspectAccountType;
    }

    @InterfaceC5817e
    public final String getSuspectAccountTypeText() {
        return this.suspectAccountTypeText;
    }

    @InterfaceC5817e
    public final String getSuspectName() {
        return this.suspectName;
    }

    @InterfaceC5817e
    public final String getTransferAmount() {
        return this.transferAmount;
    }

    public final void setPaymentTime(@InterfaceC5817e String str) {
        this.paymentTime = str;
    }

    public final void setSuspectAccount(@InterfaceC5817e String str) {
        this.suspectAccount = str;
    }

    public final void setSuspectAccountType(@InterfaceC5817e String str) {
        this.suspectAccountType = str;
    }

    public final void setSuspectAccountTypeText(@InterfaceC5817e String str) {
        this.suspectAccountTypeText = str;
    }

    public final void setSuspectName(@InterfaceC5817e String str) {
        this.suspectName = str;
    }

    public final void setTransferAmount(@InterfaceC5817e String str) {
        this.transferAmount = str;
    }
}
