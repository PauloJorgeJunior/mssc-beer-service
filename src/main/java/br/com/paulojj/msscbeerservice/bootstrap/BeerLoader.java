package br.com.paulojj.msscbeerservice.bootstrap;

import br.com.paulojj.msscbeerservice.domain.Beer;
import br.com.paulojj.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Paulo Jorge Junior on 18/02/2020
 */
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(324984613484L)
                    .price(new BigDecimal("12.95"))
                    .quantityOnHand(12)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(324984613488L)
                    .price(new BigDecimal("10.95"))
                    .quantityOnHand(12)
                    .build());
        }
    }
}
