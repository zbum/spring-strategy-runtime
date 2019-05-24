package kr.co.manty.ex.strategypattern.service.decompress;

public class UncompressFailedException extends RuntimeException {
    public UncompressFailedException() {
    }

    public UncompressFailedException(String message) {
        super(message);
    }

    public UncompressFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncompressFailedException(Throwable cause) {
        super(cause);
    }

    public UncompressFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
