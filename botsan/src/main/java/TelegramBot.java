import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        try{
            SendMessage ms = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            execute(ms);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "Zayob";
    }

    public String getBotToken() {
        return "1361245437:AAHBAH12bEHSr7M2Gnsg4UVhN0DL0dKqFY4";
    }
}
