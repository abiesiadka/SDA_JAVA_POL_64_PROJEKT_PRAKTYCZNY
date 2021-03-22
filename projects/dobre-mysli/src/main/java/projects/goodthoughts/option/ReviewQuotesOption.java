package projects.goodthoughts.option;

import projects.goodthoughts.model.Quote;
import projects.goodthoughts.service.QuoteService;

import java.util.Collection;

public class ReviewQuotesOption implements Option{

    private QuoteService quoteService = new QuoteService();

    @Override
    public void showWelcomeMessage() {
        System.out.println("\nTwoje zapisane cytaty:\n");
    }


    @Override
    public void executeOption(String userInput) {
        Collection<Quote> quotes = quoteService.findAll();

        quotes.forEach(quote -> {
            System.out.printf("|(%d) %30s: `%-140s` |%n",
                    quote.getId(),
                    quote.getAuthor(),
                    quote.getContent());
                });



    }
}
