package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class SignWebsitDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignWebsitDetialActivity f23159a;

    /* renamed from: b */
    private View f23160b;

    /* renamed from: c */
    private View f23161c;

    /* renamed from: ui.activity.SignWebsitDetialActivity_ViewBinding$a */
    class C6594a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignWebsitDetialActivity f23162a;

        C6594a(SignWebsitDetialActivity signWebsitDetialActivity) {
            this.f23162a = signWebsitDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23162a.onClick(view);
        }
    }

    /* renamed from: ui.activity.SignWebsitDetialActivity_ViewBinding$b */
    class C6595b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignWebsitDetialActivity f23164a;

        C6595b(SignWebsitDetialActivity signWebsitDetialActivity) {
            this.f23164a = signWebsitDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23164a.onClick(view);
        }
    }

    @UiThread
    public SignWebsitDetialActivity_ViewBinding(SignWebsitDetialActivity signWebsitDetialActivity) {
        this(signWebsitDetialActivity, signWebsitDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignWebsitDetialActivity signWebsitDetialActivity = this.f23159a;
        if (signWebsitDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23159a = null;
        signWebsitDetialActivity.mIvBack = null;
        signWebsitDetialActivity.mTvTitle = null;
        signWebsitDetialActivity.mTvWebUrl = null;
        signWebsitDetialActivity.mLlPic = null;
        signWebsitDetialActivity.mRecyView = null;
        this.f23160b.setOnClickListener(null);
        this.f23160b = null;
        this.f23161c.setOnClickListener(null);
        this.f23161c = null;
    }

    @UiThread
    public SignWebsitDetialActivity_ViewBinding(SignWebsitDetialActivity signWebsitDetialActivity, View view) {
        this.f23159a = signWebsitDetialActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signWebsitDetialActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23160b = findRequiredView;
        findRequiredView.setOnClickListener(new C6594a(signWebsitDetialActivity));
        signWebsitDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signWebsitDetialActivity.mTvWebUrl = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_weburl, "field 'mTvWebUrl'", TextView.class);
        signWebsitDetialActivity.mLlPic = Utils.findRequiredView(view, C2113R.id.ll_pic, "field 'mLlPic'");
        signWebsitDetialActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_websit_copy, "method 'onClick'");
        this.f23161c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6595b(signWebsitDetialActivity));
    }
}
