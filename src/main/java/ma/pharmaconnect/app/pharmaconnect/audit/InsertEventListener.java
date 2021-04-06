package ma.pharmaconnect.app.pharmaconnect.audit;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class InsertEventListener
        implements PostInsertEventListener {

    public static final InsertEventListener INSTANCE =
            new InsertEventListener();

    @Override
    public void onPostInsert(
            PostInsertEvent event)
            throws HibernateException {
        final Object entity = event.getEntity();

        Optional<AuditedEntity> haveAuditedEntity = Arrays
                .stream(entity.getClass().getAnnotationsByType(AuditedEntity.class))
                .findFirst();

        if (haveAuditedEntity.isPresent()) {
            Arrays
                    .stream(entity.getClass().getDeclaredFields())
                    .filter(field -> Arrays.stream(field.getAnnotationsByType(AuditedField.class)).findFirst().isPresent())
                    .collect(Collectors.toList());

            /*if (entity instanceof Pharmacy) {
                Pharmacy pharmacy = (Pharmacy) entity;

                event.getSession().createNativeQuery(
                        "INSERT INTO old_post (id, title, version) " +
                                "VALUES (:id, :title, :version)")
                        .setParameter("id", pharmacy.getId())
                        .setFlushMode(FlushMode.MANUAL)
                        .executeUpdate();
            }*/
        }

    }

    @Override
    public boolean requiresPostCommitHanding(
            EntityPersister persister) {
        return false;
    }

}
