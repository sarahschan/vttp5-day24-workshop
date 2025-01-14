package sg.edu.nus.iss.paf_day24_wsA.models.exceptions;

public class UnableToInsertOrderException extends RuntimeException{
    
    public UnableToInsertOrderException(){

    }

    public UnableToInsertOrderException(String message){
        super(message);
    }

    public UnableToInsertOrderException(String message, Throwable throwable){
        super(message, throwable);
    }
}
