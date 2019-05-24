package kr.co.manty.ex.strategypattern.service.decompress;

public class NotSupportCompressExtException extends RuntimeException {
    public NotSupportCompressExtException() {
    }

    public NotSupportCompressExtException(String message) {
        super(message);
    }

    public NotSupportCompressExtException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportCompressExtException(Throwable cause) {
        super(cause);
    }

    public NotSupportCompressExtException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
