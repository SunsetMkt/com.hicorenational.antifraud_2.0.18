package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class NoteDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private NoteDetailActivity f22586a;

    /* renamed from: b */
    private View f22587b;

    /* renamed from: ui.activity.NoteDetailActivity_ViewBinding$a */
    class C6396a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ NoteDetailActivity f22588a;

        C6396a(NoteDetailActivity noteDetailActivity) {
            this.f22588a = noteDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22588a.onClick(view);
        }
    }

    @UiThread
    public NoteDetailActivity_ViewBinding(NoteDetailActivity noteDetailActivity) {
        this(noteDetailActivity, noteDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NoteDetailActivity noteDetailActivity = this.f22586a;
        if (noteDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22586a = null;
        noteDetailActivity.mIvBack = null;
        noteDetailActivity.mTvTitle = null;
        noteDetailActivity.mTvTime = null;
        noteDetailActivity.mNoteTit = null;
        noteDetailActivity.mContent = null;
        this.f22587b.setOnClickListener(null);
        this.f22587b = null;
    }

    @UiThread
    public NoteDetailActivity_ViewBinding(NoteDetailActivity noteDetailActivity, View view) {
        this.f22586a = noteDetailActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        noteDetailActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22587b = findRequiredView;
        findRequiredView.setOnClickListener(new C6396a(noteDetailActivity));
        noteDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        noteDetailActivity.mTvTime = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.time, "field 'mTvTime'", TextView.class);
        noteDetailActivity.mNoteTit = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.title, "field 'mNoteTit'", TextView.class);
        noteDetailActivity.mContent = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.content, "field 'mContent'", TextView.class);
    }
}
