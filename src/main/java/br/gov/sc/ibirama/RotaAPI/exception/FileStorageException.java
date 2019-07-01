package br.gov.sc.ibirama.RotaAPI.exception;

public class FileStorageException extends RuntimeException {

    public FileStorageException(String message) {
        super(message);
    }
//i7uiut
    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
