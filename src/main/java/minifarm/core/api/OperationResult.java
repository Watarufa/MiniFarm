package minifarm.core.api;

import java.util.Objects;
import java.util.Optional;

/**
 * Representasi hasil operasi yang atomik dan terstruktur.
 * Digunakan agar penanganan kegagalan bisnis tidak mengandalkan unhandled exception.
 *
 * @param <T> tipe data nilai kembalian (jika ada)
 */
public final class OperationResult<T> {
    private final boolean success;
    private final ResultCode code;
    private final String message;
    private final T value;

    private OperationResult(boolean success, ResultCode code, String message, T value) {
        this.success = success;
        this.code = Objects.requireNonNull(code, "code tidak boleh null");
        this.message = message != null ? message : "";
        this.value = value;
    }

    public static <T> OperationResult<T> ok(String message, T value) {
        return new OperationResult<>(true, ResultCode.SUCCESS, message, value);
    }

    public static <T> OperationResult<T> ok(T value) {
        return new OperationResult<>(true, ResultCode.SUCCESS, "Operasi berhasil", value);
    }

    public static OperationResult<Void> ok() {
        return new OperationResult<>(true, ResultCode.SUCCESS, "Operasi berhasil", null);
    }

    public static <T> OperationResult<T> failed(ResultCode code, String message) {
        if (code == ResultCode.SUCCESS) {
            throw new IllegalArgumentException("Kode gagal tidak boleh SUCCESS");
        }
        return new OperationResult<>(false, code, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isFailure() {
        return !success;
    }

    public ResultCode getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Optional<T> getValue() {
        return Optional.ofNullable(value);
    }

    public T getOrNull() {
        return value;
    }

    @Override
    public String toString() {
        return "OperationResult{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", value=" + value +
                '}';
    }
}

