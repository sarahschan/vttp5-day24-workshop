package sg.edu.nus.iss.paf_day24_wsA.models.exceptions;

public class UnableToRetrieveFullOrderDetailsException extends RuntimeException{
    
    public UnableToRetrieveFullOrderDetailsException(){

    }

    public UnableToRetrieveFullOrderDetailsException(String message){
        super(message);
    }

    public UnableToRetrieveFullOrderDetailsException(String message, Throwable throwable){
        super(message, throwable);
    }
}
