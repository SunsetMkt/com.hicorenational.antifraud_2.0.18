package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import cn.jzvd.JzvdStd;

/* JADX INFO: loaded from: classes2.dex */
public class VideoTouchView extends JzvdStd {
    private b a;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoTouchView.this.a != null) {
                VideoTouchView.this.a.a();
            }
        }
    }

    public interface b {
        void a();
    }

    public VideoTouchView(Context context) {
        super(context);
        c();
    }

    private void c() {
        super.setOnClickListener(new a());
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    public void onAutoCompletion() {
        startVideo();
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b bVar;
        int action = motionEvent.getAction();
        if (action == 0 || action != 1 || (bVar = this.a) == null) {
            return false;
        }
        bVar.a();
        return false;
    }

    public void setCLickOnClickListener(b bVar) {
        this.a = bVar;
    }

    public VideoTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }
}
