package ma.pharmaconnect.app.pharmaconnect.audit;

import org.hibernate.integrator.spi.Integrator;
import org.hibernate.jpa.boot.spi.IntegratorProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuditIntegratorProvider
        implements IntegratorProvider {

    @Override
    public List<Integrator> getIntegrators() {
        return new ArrayList<>(
                Collections.singletonList(
                        new EventListenerIntegrator()
                ));
    }
}
