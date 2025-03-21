package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: -DeprecatedOkio.kt */
@InterfaceC5216c(message = "changed in Okio 2.x")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, m23546d2 = {"Lokio/-DeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: classes2.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    @InterfaceC5816d
    public final Sink appendingSink(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "file");
        return Okio.appendingSink(file);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    @InterfaceC5816d
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "sink.buffer()", imports = {"okio.buffer"}))
    @InterfaceC5816d
    public final BufferedSink buffer(@InterfaceC5816d Sink sink) {
        C5544i0.m22546f(sink, "sink");
        return Okio.buffer(sink);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "file.sink()", imports = {"okio.sink"}))
    @InterfaceC5816d
    public final Sink sink(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "file.source()", imports = {"okio.source"}))
    @InterfaceC5816d
    public final Source source(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "file");
        return Okio.source(file);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "source.buffer()", imports = {"okio.buffer"}))
    @InterfaceC5816d
    public final BufferedSource buffer(@InterfaceC5816d Source source) {
        C5544i0.m22546f(source, "source");
        return Okio.buffer(source);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "outputStream.sink()", imports = {"okio.sink"}))
    @InterfaceC5816d
    public final Sink sink(@InterfaceC5816d OutputStream outputStream) {
        C5544i0.m22546f(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "inputStream.source()", imports = {"okio.source"}))
    @InterfaceC5816d
    public final Source source(@InterfaceC5816d InputStream inputStream) {
        C5544i0.m22546f(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "path.sink(*options)", imports = {"okio.sink"}))
    @InterfaceC5816d
    public final Sink sink(@InterfaceC5816d Path path, @InterfaceC5816d OpenOption... openOptionArr) {
        C5544i0.m22546f(path, "path");
        C5544i0.m22546f(openOptionArr, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "path.source(*options)", imports = {"okio.source"}))
    @InterfaceC5816d
    public final Source source(@InterfaceC5816d Path path, @InterfaceC5816d OpenOption... openOptionArr) {
        C5544i0.m22546f(path, "path");
        C5544i0.m22546f(openOptionArr, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "socket.sink()", imports = {"okio.sink"}))
    @InterfaceC5816d
    public final Sink sink(@InterfaceC5816d Socket socket) {
        C5544i0.m22546f(socket, "socket");
        return Okio.sink(socket);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "socket.source()", imports = {"okio.source"}))
    @InterfaceC5816d
    public final Source source(@InterfaceC5816d Socket socket) {
        C5544i0.m22546f(socket, "socket");
        return Okio.source(socket);
    }
}
