package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SpannableStringBuilder.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\b\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a?\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¢\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0019"}, m23546d2 = {"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "backgroundColor", RemoteMessageConst.Notification.COLOR, "", "bold", "inSpans", "span", "", "spans", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "scale", "proportion", "", "strikeThrough", "subscript", "superscript", "underline", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SpannableStringBuilderKt {
    @InterfaceC5816d
    public static final SpannableStringBuilder backgroundColor(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i2);
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder bold(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannedString buildSpannedString(@InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        interfaceC5506l.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder color(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i2);
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder inSpans(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @InterfaceC5816d Object[] objArr, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(objArr, "spans");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        for (Object obj : objArr) {
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder italic(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder scale(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, float f2, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f2);
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder strikeThrough(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder subscript(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder superscript(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder underline(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @InterfaceC5816d
    public static final SpannableStringBuilder inSpans(@InterfaceC5816d SpannableStringBuilder spannableStringBuilder, @InterfaceC5816d Object obj, @InterfaceC5816d InterfaceC5506l<? super SpannableStringBuilder, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(spannableStringBuilder, "$receiver");
        C5544i0.m22546f(obj, "span");
        C5544i0.m22546f(interfaceC5506l, "builderAction");
        int length = spannableStringBuilder.length();
        interfaceC5506l.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
