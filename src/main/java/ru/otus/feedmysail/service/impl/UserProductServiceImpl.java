package ru.otus.feedmysail.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.feedmysail.model.ProductResult;
import ru.otus.feedmysail.model.UserProduct;
import ru.otus.feedmysail.repository.UserProductRepository;
import ru.otus.feedmysail.service.UserProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProductServiceImpl implements UserProductService {
    private final UserProductRepository userProductRepositoryJpa;

    public UserProductServiceImpl(UserProductRepository userProductRepositoryJpa) {
        this.userProductRepositoryJpa = userProductRepositoryJpa;
    }

    @Override
    public List<UserProduct> findAll() {
        return userProductRepositoryJpa.findAll();
    }

    @Override
    public List<UserProduct> findByUserId(long userId) {
        return userProductRepositoryJpa.findByUserId(userId);
    }

    @Override
    public Optional<UserProduct> findByUserIdAndProductId(long userId, long productId) {
        return userProductRepositoryJpa.findByUserIdAndProductId(userId, productId);
    }

    @Override
    public UserProduct save(UserProduct userProduct) {
        UserProduct userProductRepo = findByUserIdAndProductId(userProduct.getUserId(), userProduct.getProductId()).orElse(userProduct);
        userProductRepo.setVote(userProduct.getVote());
        return userProductRepositoryJpa.save(userProductRepo);
    }

    @Override
    public List<ProductResult> getProductAvgByTeamId(long teamId) {
        return userProductRepositoryJpa.getProductAvgByTeamId(teamId);
    }

    @Override
    public List<ProductResult> getFilteredProductAvgByTeamId(long teamId, long minResult) {
        List<ProductResult> results = userProductRepositoryJpa.getProductAvgByTeamId(teamId);
        return results.stream().filter(avg -> avg.getCalcResult() >= minResult).collect(Collectors.toList());
    }
}
