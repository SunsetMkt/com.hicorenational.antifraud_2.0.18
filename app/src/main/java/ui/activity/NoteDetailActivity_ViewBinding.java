package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class NoteDetailActivity_ViewBinding implements Unbinder {
    private NoteDetailActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13516b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ NoteDetailActivity a;

        a(NoteDetailActivity noteDetailActivity) {
            this.a = noteDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public NoteDetailActivity_ViewBinding(NoteDetailActivity noteDetailActivity) {
        this(noteDetailActivity, noteDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NoteDetailActivity noteDetailActivity = this.a;
        if (noteDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        noteDetailActivity.mIvBack = null;
        noteDetailActivity.mTvTitle = null;
        noteDetailActivity.mTvTime = null;
        noteDetailActivity.mNoteTit = null;
        noteDetailActivity.mContent = null;
        this.f13516b.setOnClickListener(null);
        this.f13516b = null;
    }

    @UiThread
    public NoteDetailActivity_ViewBinding(NoteDetailActivity noteDetailActivity, View view) {
        this.a = noteDetailActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        noteDetailActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13516b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(noteDetailActivity));
        noteDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        noteDetailActivity.mTvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.time, "field 'mTvTime'", TextView.class);
        noteDetailActivity.mNoteTit = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'mNoteTit'", TextView.class);
        noteDetailActivity.mContent = (TextView) Utils.findRequiredViewAsType(view, R.id.content, "field 'mContent'", TextView.class);
    }
}
