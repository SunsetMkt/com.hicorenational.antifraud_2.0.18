package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class QRcodeActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private QRcodeActivity f22754a;

    /* renamed from: b */
    private View f22755b;

    /* renamed from: ui.activity.QRcodeActivity_ViewBinding$a */
    class C6454a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ QRcodeActivity f22756a;

        C6454a(QRcodeActivity qRcodeActivity) {
            this.f22756a = qRcodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22756a.onViewClicked(view);
        }
    }

    @UiThread
    public QRcodeActivity_ViewBinding(QRcodeActivity qRcodeActivity) {
        this(qRcodeActivity, qRcodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        QRcodeActivity qRcodeActivity = this.f22754a;
        if (qRcodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22754a = null;
        qRcodeActivity.mTvTitle = null;
        qRcodeActivity.mTvCaseName = null;
        qRcodeActivity.mTvNumber = null;
        qRcodeActivity.mIvQrcode = null;
        qRcodeActivity.mTvDate = null;
        qRcodeActivity.mTvCaseCode = null;
        qRcodeActivity.mTvClose = null;
        this.f22755b.setOnClickListener(null);
        this.f22755b = null;
    }

    @UiThread
    public QRcodeActivity_ViewBinding(QRcodeActivity qRcodeActivity, View view) {
        this.f22754a = qRcodeActivity;
        qRcodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        qRcodeActivity.mTvCaseName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_case_name, "field 'mTvCaseName'", TextView.class);
        qRcodeActivity.mTvNumber = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_number, "field 'mTvNumber'", TextView.class);
        qRcodeActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
        qRcodeActivity.mTvDate = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_date, "field 'mTvDate'", TextView.class);
        qRcodeActivity.mTvCaseCode = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_case_code, "field 'mTvCaseCode'", TextView.class);
        qRcodeActivity.mTvClose = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_close, "field 'mTvClose'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22755b = findRequiredView;
        findRequiredView.setOnClickListener(new C6454a(qRcodeActivity));
    }
}
