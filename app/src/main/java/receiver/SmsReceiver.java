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
import com.hicorenational.antifraud.R;
import java.util.List;
import manager.AccountManager;
import manager.FloatingWindow;
import manager.IFloatingWindow;
import ui.Hicore;
import ui.callview.SMSWarnCallView;
import ui.presenter.WarnPresenter;
import util.c2;
import util.d2;
import util.e2;
import util.h2;

/* JADX INFO: loaded from: classes2.dex */
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

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsReceiver.this.showSmsWindowReady(this.a);
        }
    }

    private void createView() {
        if (this.window == null) {
            this.window = new FloatingWindow(this.mContext);
            this.window.setParams(this.window.getSMSWarnLayoutParams());
            View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_sms_intercepte, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.txt_dialog_title)).setTypeface(Typeface.createFromAsset(Hicore.getApp().getAssets(), "DIN-Medium.otf"));
            this.mTvSmsAddress = (TextView) viewInflate.findViewById(R.id.txt_dialog_sms_address);
            this.mTvSmsContent = (TextView) viewInflate.findViewById(R.id.txt_dialog_sms_content);
            this.mTvWarn = (TextView) viewInflate.findViewById(R.id.txt_dialog_sms_warn);
            Button button = (Button) viewInflate.findViewById(R.id.btn_dialog_sms_close);
            Button button2 = (Button) viewInflate.findViewById(R.id.btn_dialog_sms_report);
            button.setOnClickListener(new View.OnClickListener() { // from class: receiver.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(view);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: receiver.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(view);
                }
            });
            this.window.setContentView(viewInflate);
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
            new Handler(Looper.getMainLooper()).post(new a(str));
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

    public /* synthetic */ void a(View view) {
        dismissDlg();
    }

    public /* synthetic */ void b(View view) {
        onRightBtnClick();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (c2.a(c2.G, false)) {
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
                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                        this.senderPhoneNum = smsMessageCreateFromPdu.getDisplayOriginatingAddress();
                        this.crimeTime = d2.d();
                        if (this.senderPhoneNum.contains("+86")) {
                            this.senderPhoneNum = this.senderPhoneNum.substring(3, this.senderPhoneNum.length());
                        }
                        sb.append(smsMessageCreateFromPdu.getMessageBody());
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
            org.greenrobot.eventbus.c.f().d(new util.n2.a(155, null));
            dismissDlg();
            return;
        }
        SmsBean smsBean = new SmsBean(this.senderPhoneNum, this.contentSMS, this.crimeTime, false);
        if (!h2.a(this.mContext).a()) {
            e2.a("\u63d0\u4ea4\u5931\u8d25,\u8fd8\u672a\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1");
        } else {
            this.warnPresenter.oneKeyReportSMS(smsBean, this.mWebUrlList);
            dismissDlg();
        }
    }

    @Override // ui.callview.SMSWarnCallView
    public void onSuccRequest(SMSWarnBean sMSWarnBean) {
        if (sMSWarnBean == null || !sMSWarnBean.earlyWarning) {
            return;
        }
        this.mWebUrlList = sMSWarnBean.urls;
        showSmsWindow(sMSWarnBean.tabText);
    }
}
