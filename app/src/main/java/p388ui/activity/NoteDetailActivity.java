package p388ui.activity;

import android.app.Activity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.NoteListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: NoteDetailActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020%H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006&"}, m23546d2 = {"Lui/activity/NoteDetailActivity;", "Lui/activity/BaseActivity;", "()V", "mContent", "Landroid/widget/TextView;", "getMContent", "()Landroid/widget/TextView;", "setMContent", "(Landroid/widget/TextView;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mNoteTit", "getMNoteTit", "setMNoteTit", "mTvTime", "getMTvTime", "setMTvTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "noteBean", "Lbean/NoteListBean;", "getNoteBean", "()Lbean/NoteListBean;", "setNoteBean", "(Lbean/NoteListBean;)V", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class NoteDetailActivity extends BaseActivity {

    /* renamed from: a */
    @InterfaceC5817e
    private NoteListBean f22584a;

    @BindView(C2113R.id.content)
    @InterfaceC5816d
    public TextView mContent;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.title)
    @InterfaceC5816d
    public TextView mNoteTit;

    @BindView(C2113R.id.time)
    @InterfaceC5816d
    public TextView mTvTime;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    /* compiled from: NoteDetailActivity.kt */
    /* renamed from: ui.activity.NoteDetailActivity$a */
    static final class ViewOnTouchListenerC6395a implements View.OnTouchListener {

        /* renamed from: a */
        public static final ViewOnTouchListenerC6395a f22585a = new ViewOnTouchListenerC6395a();

        ViewOnTouchListenerC6395a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final TextView m25289a() {
        TextView textView = this.mContent;
        if (textView == null) {
            C5544i0.m22554k("mContent");
        }
        return textView;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final TextView m25292b() {
        TextView textView = this.mNoteTit;
        if (textView == null) {
            C5544i0.m22554k("mNoteTit");
        }
        return textView;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final TextView m25294c() {
        TextView textView = this.mTvTime;
        if (textView == null) {
            C5544i0.m22554k("mTvTime");
        }
        return textView;
    }

    @InterfaceC5817e
    /* renamed from: d */
    public final NoteListBean m25296d() {
        return this.f22584a;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        textView.setText("公告详情");
        initView();
    }

    public final void initView() {
        this.f22584a = (NoteListBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        if (this.f22584a != null) {
            TextView textView = this.mTvTime;
            if (textView == null) {
                C5544i0.m22554k("mTvTime");
            }
            NoteListBean noteListBean = this.f22584a;
            textView.setText(noteListBean != null ? noteListBean.getVaildStartTime() : null);
            TextView textView2 = this.mNoteTit;
            if (textView2 == null) {
                C5544i0.m22554k("mNoteTit");
            }
            NoteListBean noteListBean2 = this.f22584a;
            textView2.setText(Html.fromHtml(noteListBean2 != null ? noteListBean2.getTitle() : null));
            TextView textView3 = this.mContent;
            if (textView3 == null) {
                C5544i0.m22554k("mContent");
            }
            NoteListBean noteListBean3 = this.f22584a;
            textView3.setText(Html.fromHtml(noteListBean3 != null ? noteListBean3.getContent() : null));
            TextView textView4 = this.mContent;
            if (textView4 == null) {
                C5544i0.m22554k("mContent");
            }
            textView4.setMovementMethod(new ScrollingMovementMethod());
            TextView textView5 = this.mContent;
            if (textView5 == null) {
                C5544i0.m22554k("mContent");
            }
            textView5.setOnTouchListener(ViewOnTouchListenerC6395a.f22585a);
        }
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_note_detail;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    /* renamed from: a */
    public final void m25290a(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mContent = textView;
    }

    /* renamed from: b */
    public final void m25293b(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mNoteTit = textView;
    }

    /* renamed from: c */
    public final void m25295c(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTime = textView;
    }

    /* renamed from: a */
    public final void m25291a(@InterfaceC5817e NoteListBean noteListBean) {
        this.f22584a = noteListBean;
    }
}
