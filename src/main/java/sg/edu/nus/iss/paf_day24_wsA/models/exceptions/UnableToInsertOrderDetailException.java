package sg.edu.nus.iss.paf_day24_wsA.models.exceptions;

public class UnableToInsertOrderDetailException extends RuntimeException{
    
    public UnableToInsertOrderDetailException(){

    }

    public UnableToInsertOrderDetailException(String message){
        super(message);
    }

    public UnableToInsertOrderDetailException(String message, Throwable throwable){
        super(message, throwable);
    }
}
