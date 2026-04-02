package ui.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import interfaces.ITextCallBackListener;

/* JADX INFO: compiled from: CustomClickableSpan.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends ClickableSpan {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ITextCallBackListener f14790b;

    public q(String str, ITextCallBackListener iTextCallBackListener) {
        this.a = str;
        this.f14790b = iTextCallBackListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(0);
            this.f14790b.onResult(this.a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
