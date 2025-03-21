package p031c.p035b.p043c;

import java.util.List;

/* compiled from: DecodeHintType.java */
/* renamed from: c.b.c.e */
/* loaded from: classes.dex */
public enum EnumC1044e {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(InterfaceC1110u.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);

    private final Class<?> valueType;

    EnumC1044e(Class cls) {
        this.valueType = cls;
    }

    public Class<?> getValueType() {
        return this.valueType;
    }
}
