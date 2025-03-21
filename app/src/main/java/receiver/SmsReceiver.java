package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.SmsMessage;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import bean.SMSWarnBean;
import bean.SmsBean;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import manager.AccountManager;
import manager.FloatingWindow;
import manager.IFloatingWindow;
import org.greenrobot.eventbus.C6049c;
import p388ui.Hicore;
import p388ui.callview.SMSWarnCallView;
import p388ui.presenter.WarnPresenter;
import util.C7325u1;
import util.C7328v1;
import util.C7331w1;
import util.C7340z1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class SmsReceiver extends BroadcastReceiver implements SMSWarnCallView {
    private static final String TAG = SmsReceiver.class.getSimpleName();
    private String contentSMS;
    private Context mContext;
    private TextView mTvSmsAddress;
    private TextView mTvSmsContent;
    private TextView mTvWarn;
    private String senderPhoneNum;
    private WarnPresenter warnPresenter;
    private IFloatingWindow window;
    private String crimeTime = "";
    private List<String> mWebUrlList = null;

    /* renamed from: receiver.SmsReceiver$a */
    class RunnableC6082a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21704a;

        RunnableC6082a(String str) {
            this.f21704a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsReceiver.this.showSmsWindowReady(this.f21704a);
        }
    }

    private void createView() {
        if (this.window == null) {
            this.window = new FloatingWindow(this.mContext);
            this.window.setParams(this.window.getSMSWarnLayoutParams());
            View inflate = LayoutInflater.from(this.mContext).inflate(C2113R.layout.dialog_sms_intercepte, (ViewGroup) null);
            ((TextView) inflate.findViewById(C2113R.id.txt_dialog_title)).setTypeface(Typeface.createFromAsset(Hicore.getApp().getAssets(), "DIN-Medium.otf"));
            this.mTvSmsAddress = (TextView) inflate.findViewById(C2113R.id.txt_dialog_sms_address);
            this.mTvSmsContent = (TextView) inflate.findViewById(C2113R.id.txt_dialog_sms_content);
            this.mTvWarn = (TextView) inflate.findViewById(C2113R.id.txt_dialog_sms_warn);
            Button button = (Button) inflate.findViewById(C2113R.id.btn_dialog_sms_close);
            Button button2 = (Button) inflate.findViewById(C2113R.id.btn_dialog_sms_report);
            button.setOnClickListener(new View.OnClickListener() { // from class: receiver.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmsReceiver.this.m25173a(view);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: receiver.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmsReceiver.this.m25174b(view);
                }
            });
            this.window.setContentView(inflate);
        }
    }

    private void dismissDlg() {
        IFloatingWindow iFloatingWindow = this.window;
        if (iFloatingWindow != null) {
            iFloatingWindow.dismiss();
        }
    }

    private void showSmsWindow(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new RunnableC6082a(str));
        } else {
            showSmsWindowReady(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSmsWindowReady(String str) {
        createView();
        this.window.show();
        this.mTvSmsContent.setText(this.contentSMS);
        this.mTvSmsAddress.setText(this.senderPhoneNum);
        this.mTvWarn.setText(str);
    }

    /* renamed from: a */
    public /* synthetic */ void m25173a(View view) {
        dismissDlg();
    }

    /* renamed from: b */
    public /* synthetic */ void m25174b(View view) {
        onRightBtnClick();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C7325u1.m26623a(C7325u1.f25635G, false)) {
            this.mContext = context;
            if (this.warnPresenter == null) {
                this.warnPresenter = new WarnPresenter(context, this);
            }
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Object[] objArr = (Object[]) extras.get("pdus");
                    StringBuilder sb = new StringBuilder();
                    for (Object obj : objArr) {
                        SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                        this.senderPhoneNum = createFromPdu.getDisplayOriginatingAddress();
                        this.crimeTime = C7328v1.m26658d();
                        if (this.senderPhoneNum.contains("+86")) {
                            this.senderPhoneNum = this.senderPhoneNum.substring(3, this.senderPhoneNum.length());
                        }
                        sb.append(createFromPdu.getMessageBody());
                    }
                    this.contentSMS = sb.toString();
                    this.warnPresenter.requestSMSHttp(this.senderPhoneNum, this.contentSMS);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onRightBtnClick() {
        if (!AccountManager.isLogin()) {
            C6049c.m24987f().m25000d(new C7265a(155, null));
            dismissDlg();
            return;
        }
        SmsBean smsBean = new SmsBean(this.senderPhoneNum, this.contentSMS, this.crimeTime, false);
        if (!C7340z1.m26805a(this.mContext).m26814a()) {
            C7331w1.m26688a("提交失败,还未完成实名认证");
        } else {
            this.warnPresenter.oneKeyReportSMS(smsBean, this.mWebUrlList);
            dismissDlg();
        }
    }

    @Override // p388ui.callview.SMSWarnCallView
    public void onSuccRequest(SMSWarnBean sMSWarnBean) {
        if (sMSWarnBean == null || !sMSWarnBean.earlyWarning) {
            return;
        }
        this.mWebUrlList = sMSWarnBean.urls;
        showSmsWindow(sMSWarnBean.tabText);
    }
}
