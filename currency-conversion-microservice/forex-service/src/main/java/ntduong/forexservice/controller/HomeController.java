package ntduong.forexservice.controller;

import ntduong.forexservice.entity.ExchangeValue;
import ntduong.forexservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ExchangeValueRepository exchangeValueRepo;

    @Autowired
    private Environment environment;

    @GetMapping("/exchange-value/from/{from}/to/{to}")
    public ExchangeValue findExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = this.exchangeValueRepo.findByFromAndTo(from, to);

        if(exchangeValue != null) {
            exchangeValue.setPort(Integer.parseInt(this.environment.getProperty("local.server.port")));
        }

        return exchangeValue;
    }
}
