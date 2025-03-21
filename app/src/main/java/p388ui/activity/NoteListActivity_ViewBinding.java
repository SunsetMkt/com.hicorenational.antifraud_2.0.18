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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public final class NoteListActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private NoteListActivity f22591a;

    /* renamed from: b */
    private View f22592b;

    /* renamed from: ui.activity.NoteListActivity_ViewBinding$a */
    class C6398a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ NoteListActivity f22593a;

        C6398a(NoteListActivity noteListActivity) {
            this.f22593a = noteListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22593a.onClick(view);
        }
    }

    @UiThread
    public NoteListActivity_ViewBinding(NoteListActivity noteListActivity) {
        this(noteListActivity, noteListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NoteListActivity noteListActivity = this.f22591a;
        if (noteListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22591a = null;
        noteListActivity.mIvBack = null;
        noteListActivity.mTvTitle = null;
        noteListActivity.mRefreshLayout = null;
        noteListActivity.mRecycle = null;
        noteListActivity.noDateView = null;
        noteListActivity.mNoImg = null;
        noteListActivity.mNoTxt = null;
        this.f22592b.setOnClickListener(null);
        this.f22592b = null;
    }

    @UiThread
    public NoteListActivity_ViewBinding(NoteListActivity noteListActivity, View view) {
        this.f22591a = noteListActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        noteListActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22592b = findRequiredView;
        findRequiredView.setOnClickListener(new C6398a(noteListActivity));
        noteListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        noteListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        noteListActivity.mRecycle = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycle'", RecyclerView.class);
        noteListActivity.noDateView = Utils.findRequiredView(view, C2113R.id.cl_no_data, "field 'noDateView'");
        noteListActivity.mNoImg = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_img, "field 'mNoImg'", ImageView.class);
        noteListActivity.mNoTxt = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip, "field 'mNoTxt'", TextView.class);
    }
}
