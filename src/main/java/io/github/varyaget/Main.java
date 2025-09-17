package io.github.varyaget;

import io.github.artemget.entrys.EntryException;
import io.github.artemget.entrys.file.EVal;
import io.github.varyaget.Domain.Portfolio;
import ru.tinkoff.piapi.core.InvestApi;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws EntryException, ExecutionException, InterruptedException {
        String token = new EVal("dep.tinkoff.token","src/main/resources/application.local.yaml").value();
        InvestApi api = InvestApi.create(token);
        var a = api.getUserService().getAccounts().get();
        for (var account : a) {
            System.out.print(account.getName() + " ");
            System.out.print(new Portfolio(api,account.getId()).money());
            System.out.println();
        }
    }
}