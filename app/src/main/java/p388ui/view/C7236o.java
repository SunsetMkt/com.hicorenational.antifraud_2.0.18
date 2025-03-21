package p388ui.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import interfaces.ITextCallBackListener;

/* compiled from: CustomClickableSpan.java */
/* renamed from: ui.view.o */
/* loaded from: classes2.dex */
public class C7236o extends ClickableSpan {

    /* renamed from: a */
    private String f24939a;

    /* renamed from: b */
    private ITextCallBackListener f24940b;

    public C7236o(String str, ITextCallBackListener iTextCallBackListener) {
        this.f24939a = str;
        this.f24940b = iTextCallBackListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(0);
            this.f24940b.onResult(this.f24939a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
