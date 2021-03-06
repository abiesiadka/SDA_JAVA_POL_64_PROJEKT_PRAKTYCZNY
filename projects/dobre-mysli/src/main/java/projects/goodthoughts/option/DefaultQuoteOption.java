package projects.goodthoughts.option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.goodthoughts.model.Quote;
import projects.goodthoughts.service.QuoteService;


import java.util.Scanner;

public class DefaultQuoteOption implements Option{

    private static final Logger logger = LoggerFactory.getLogger(DefaultQuoteOption.class);

    private final QuoteService quoteService = new QuoteService();


    public static void main(String[] args) {
        DefaultQuoteOption option = new DefaultQuoteOption();
        option.run();
    }



    @Override
    public void executeOption(String userInput) {
        Quote defaultQuote = quoteService.getDefaultQuote();
        logger.debug("Pobrany cytat: {}", defaultQuote);

        System.out.printf("Cytat na dzis: %n\t  \"%s\")%n", defaultQuote.getContent(), defaultQuote.getAuthor());

        if(!quoteService.exist(defaultQuote)){
            System.out.print("\nCzy zapisac? (tak dla zapisu): ");
            String input = new Scanner (System.in).nextLine();

            if("tak".equals(input)){
                Quote savedQuote = quoteService.save(defaultQuote);
                logger.info("Zapisano cytat : {}", savedQuote);
            }
        }

    }

}

