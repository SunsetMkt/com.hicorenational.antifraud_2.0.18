package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SignWebsitDetialActivity_ViewBinding implements Unbinder {
    private SignWebsitDetialActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13834c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignWebsitDetialActivity a;

        a(SignWebsitDetialActivity signWebsitDetialActivity) {
            this.a = signWebsitDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SignWebsitDetialActivity a;

        b(SignWebsitDetialActivity signWebsitDetialActivity) {
            this.a = signWebsitDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SignWebsitDetialActivity_ViewBinding(SignWebsitDetialActivity signWebsitDetialActivity) {
        this(signWebsitDetialActivity, signWebsitDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignWebsitDetialActivity signWebsitDetialActivity = this.a;
        if (signWebsitDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signWebsitDetialActivity.mIvBack = null;
        signWebsitDetialActivity.mTvTitle = null;
        signWebsitDetialActivity.mTvWebUrl = null;
        signWebsitDetialActivity.mLlPic = null;
        signWebsitDetialActivity.mRecyView = null;
        this.f13833b.setOnClickListener(null);
        this.f13833b = null;
        this.f13834c.setOnClickListener(null);
        this.f13834c = null;
    }

    @UiThread
    public SignWebsitDetialActivity_ViewBinding(SignWebsitDetialActivity signWebsitDetialActivity, View view) {
        this.a = signWebsitDetialActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signWebsitDetialActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13833b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signWebsitDetialActivity));
        signWebsitDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signWebsitDetialActivity.mTvWebUrl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weburl, "field 'mTvWebUrl'", TextView.class);
        signWebsitDetialActivity.mLlPic = Utils.findRequiredView(view, R.id.ll_pic, "field 'mLlPic'");
        signWebsitDetialActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_websit_copy, "method 'onClick'");
        this.f13834c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(signWebsitDetialActivity));
    }
}
