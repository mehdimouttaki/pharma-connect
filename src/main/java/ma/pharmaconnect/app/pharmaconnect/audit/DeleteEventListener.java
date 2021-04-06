package ma.pharmaconnect.app.pharmaconnect.audit;

import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.event.spi.PreDeleteEventListener;

public class DeleteEventListener
        implements PreDeleteEventListener {

    public static final DeleteEventListener INSTANCE =
            new DeleteEventListener();


    @Override
    public boolean onPreDelete(PreDeleteEvent preDeleteEvent) {
        return true;
    }
}
