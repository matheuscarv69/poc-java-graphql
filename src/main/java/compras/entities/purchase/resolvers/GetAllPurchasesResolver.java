package compras.entities.purchase.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import compras.entities.purchase.model.Purchase;
import compras.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllPurchasesResolver implements GraphQLQueryResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases(int page, int size, Sort.Direction direction, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.valueOf(direction.name()), sort);

        return purchaseRepository
                .findAll(pageable)
                .getContent();

    }

}
