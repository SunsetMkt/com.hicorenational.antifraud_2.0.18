package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class QRcodeActivity_ViewBinding implements Unbinder {
    private QRcodeActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13609b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ QRcodeActivity a;

        a(QRcodeActivity qRcodeActivity) {
            this.a = qRcodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public QRcodeActivity_ViewBinding(QRcodeActivity qRcodeActivity) {
        this(qRcodeActivity, qRcodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        QRcodeActivity qRcodeActivity = this.a;
        if (qRcodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        qRcodeActivity.mTvTitle = null;
        qRcodeActivity.mTvCaseName = null;
        qRcodeActivity.mTvNumber = null;
        qRcodeActivity.mIvQrcode = null;
        qRcodeActivity.mTvDate = null;
        qRcodeActivity.mTvCaseCode = null;
        qRcodeActivity.mTvClose = null;
        this.f13609b.setOnClickListener(null);
        this.f13609b = null;
    }

    @UiThread
    public QRcodeActivity_ViewBinding(QRcodeActivity qRcodeActivity, View view) {
        this.a = qRcodeActivity;
        qRcodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        qRcodeActivity.mTvCaseName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_name, "field 'mTvCaseName'", TextView.class);
        qRcodeActivity.mTvNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_number, "field 'mTvNumber'", TextView.class);
        qRcodeActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
        qRcodeActivity.mTvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_date, "field 'mTvDate'", TextView.class);
        qRcodeActivity.mTvCaseCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_code, "field 'mTvCaseCode'", TextView.class);
        qRcodeActivity.mTvClose = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_close, "field 'mTvClose'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13609b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(qRcodeActivity));
    }
}
