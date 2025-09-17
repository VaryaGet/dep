package io.github.varyaget.Domain;

import ru.tinkoff.piapi.core.InvestApi;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

public final class Portfolio {
    private final InvestApi api;
    private final String id;

    public Portfolio(final InvestApi api, final String id) {
        this.api = api;
        this.id = id;
    }

    public BigDecimal money() throws ExecutionException, InterruptedException {
        return api.getOperationsService().getPortfolio(this.id).get()
                .getTotalAmountPortfolio().getValue();
    }
}
