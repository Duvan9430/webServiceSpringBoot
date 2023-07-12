package sistemaencuestabackend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaencuestabackend.model.brands;
import sistemaencuestabackend.repository.brandsRepository;
import sistemaencuestabackend.service.brandsService;

import java.util.List;

@Service
public class brandsServiceImpl implements brandsService {

    @Autowired
    brandsRepository brandsRepo;

    @Override
    public List<brands> findAll() {
        return brandsRepo.findAll();
    }
}
