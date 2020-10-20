import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainClass {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        // Create the TelegramBotsApi object to register your bots
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try{
            TelegramBot bot = new TelegramBot();
            botsApi.registerBot(bot);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }

    }
}
