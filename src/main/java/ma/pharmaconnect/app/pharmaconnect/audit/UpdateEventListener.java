package ma.pharmaconnect.app.pharmaconnect.audit;

import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

public class UpdateEventListener
        implements PostUpdateEventListener {

    public static final UpdateEventListener INSTANCE =
            new UpdateEventListener();


    @Override
    public boolean requiresPostCommitHanding(
            EntityPersister persister) {
        return false;
    }

    @Override
    public void onPostUpdate(PostUpdateEvent postUpdateEvent) {
    }
}
