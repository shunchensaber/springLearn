package com.peige.work.spring.Uploadfiles;

public class StorageException extends RuntimeException {
    public StorageException(String mess)
    {
        super(mess);
    }

    //不太了解Throwable
    public StorageException(String mess,Throwable cause)
    {
        super(mess,cause)   ;
    }


}
