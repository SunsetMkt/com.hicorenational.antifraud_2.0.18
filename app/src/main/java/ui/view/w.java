package ui.view;

import android.text.SpannableStringBuilder;

/* JADX INFO: compiled from: SpannableStringBuilderAllVer.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends SpannableStringBuilder {
    public w() {
        super("");
    }

    public w(CharSequence charSequence) {
        super(charSequence, 0, charSequence.length());
    }

    public w(CharSequence charSequence, int i2, int i3) {
        super(charSequence, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public w append(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        return (w) replace(length, length, charSequence, 0, charSequence.length());
    }

    @Override // android.text.SpannableStringBuilder
    public w append(CharSequence charSequence, Object obj, int i2) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        append(charSequence);
        setSpan(obj, length, length(), i2);
        return this;
    }
}
