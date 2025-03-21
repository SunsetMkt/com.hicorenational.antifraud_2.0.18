package p388ui.view;

import android.text.SpannableStringBuilder;

/* compiled from: SpannableStringBuilderAllVer.java */
/* renamed from: ui.view.u */
/* loaded from: classes2.dex */
public class C7245u extends SpannableStringBuilder {
    public C7245u() {
        super("");
    }

    public C7245u(CharSequence charSequence) {
        super(charSequence, 0, charSequence.length());
    }

    public C7245u(CharSequence charSequence, int i2, int i3) {
        super(charSequence, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public C7245u append(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        return (C7245u) replace(length, length, charSequence, 0, charSequence.length());
    }

    @Override // android.text.SpannableStringBuilder
    public C7245u append(CharSequence charSequence, Object obj, int i2) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        append(charSequence);
        setSpan(obj, length, length(), i2);
        return this;
    }
}
