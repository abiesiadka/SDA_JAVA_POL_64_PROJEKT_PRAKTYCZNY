package project.goodthoughts.option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.goodthoughts.model.Quote;
import project.goodthoughts.service.QuoteService;

public class DefaultQuoteOption {
    private static final Logger logger = LoggerFactory.getLogger(DefaultQuoteOption.class);
    private final QuoteService quoteService = new QuoteService();


    public static void main(String[] args) {
        DefaultQuoteOption option = new DefaultQuoteOption();
        option.run();
    }
    public void run(Object... args) {
        logger.info("Uruchamianie opcji DefaultQuoteOption...");



        showWelcomeMessage();
        while (true) {
            showMenu();
            String userInput = getUserInput();
            boolean isValidOption = validateOption(userInput);
            if (isValidOption) {
                executeOption(userInput);
                boolean isExitOption = checkIsExitOption(userInput);
                if (isExitOption) {
                    break;
                }
            } else {
                showInvalidOptionMessage(userInput);
            }
        }
        showGoodbyeMessage();
        logger.info("Zakończono pracę z aplikacją");
    }

    private boolean checkIsExitOption(String userInput) {
        return true;
    }

    private void executeOption(String userInput) {
        Quote defaultQuote = quoteService.getDefaultQuote();
        logger.debug("Pobrany cytat: {}", defaultQuote);
        System.out.printf("C\t Cytat na dzis: \"%s\" (%s)%n", defaultQuote.getContent(),defaultQuote.getAuthor());
    }

    private void showGoodbyeMessage() {
        //nothing
    }

    private void showInvalidOptionMessage(String userInput) {
        //nothing

    }

    private boolean validateOption(String userInput) {
        return true;
    }

    private String getUserInput() {
        return "";
    }

    private void showMenu() {
        //nothing
    }

    private void showWelcomeMessage() {
        System.out.println("Pobieram cytat dla Ciebie.");
    }
}

