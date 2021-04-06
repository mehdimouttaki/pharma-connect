package ma.pharmaconnect.app.pharmaconnect.audit;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class EventListenerIntegrator
        implements Integrator {
 
    public static final EventListenerIntegrator INSTANCE =
        new EventListenerIntegrator();
 
    @Override
    public void integrate(
            Metadata metadata,
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry) {
 
        final EventListenerRegistry eventListenerRegistry =
                serviceRegistry.getService(EventListenerRegistry.class);
 
        eventListenerRegistry.appendListeners(
            EventType.POST_INSERT,
            InsertEventListener.INSTANCE
        );
         
        eventListenerRegistry.appendListeners(
            EventType.POST_UPDATE,
            UpdateEventListener.INSTANCE
        );


         
        eventListenerRegistry.appendListeners(
            EventType.PRE_DELETE,
            DeleteEventListener.INSTANCE
        );
    }
 
    @Override
    public void disintegrate(
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry) {

    }
}
