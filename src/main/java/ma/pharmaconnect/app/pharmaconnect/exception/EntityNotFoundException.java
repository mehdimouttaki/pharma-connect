package ma.pharmaconnect.app.pharmaconnect.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String className, Integer resourceId){
        this(className+" with id '"+resourceId+"' not found.");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
