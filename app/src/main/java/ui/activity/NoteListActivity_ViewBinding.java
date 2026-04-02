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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class NoteListActivity_ViewBinding implements Unbinder {
    private NoteListActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13518b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ NoteListActivity a;

        a(NoteListActivity noteListActivity) {
            this.a = noteListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public NoteListActivity_ViewBinding(NoteListActivity noteListActivity) {
        this(noteListActivity, noteListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NoteListActivity noteListActivity = this.a;
        if (noteListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        noteListActivity.mIvBack = null;
        noteListActivity.mTvTitle = null;
        noteListActivity.mRefreshLayout = null;
        noteListActivity.mRecycle = null;
        noteListActivity.noDateView = null;
        noteListActivity.mNoImg = null;
        noteListActivity.mNoTxt = null;
        this.f13518b.setOnClickListener(null);
        this.f13518b = null;
    }

    @UiThread
    public NoteListActivity_ViewBinding(NoteListActivity noteListActivity, View view) {
        this.a = noteListActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        noteListActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13518b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(noteListActivity));
        noteListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        noteListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        noteListActivity.mRecycle = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycle'", RecyclerView.class);
        noteListActivity.noDateView = Utils.findRequiredView(view, R.id.cl_no_data, "field 'noDateView'");
        noteListActivity.mNoImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_img, "field 'mNoImg'", ImageView.class);
        noteListActivity.mNoTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mNoTxt'", TextView.class);
    }
}
