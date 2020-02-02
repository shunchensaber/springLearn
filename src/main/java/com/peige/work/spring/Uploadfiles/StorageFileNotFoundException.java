package com.peige.work.spring.Uploadfiles;

public class StorageFileNotFoundException extends  StorageException {
    public StorageFileNotFoundException(String mess) {
        super(mess);
    }

    public StorageFileNotFoundException(String mess, Throwable cause) {
        super(mess, cause);
    }
}
