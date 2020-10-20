import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            try{
                SendMessage msg = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText(update.getMessage().toString());
                execute(msg);
            }catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "TestBot";
    }

    public String getBotToken() {
        return "1150156139:AAFs2R9VUlMK6uEWDsdnvv6niqBGSMVgIh4";
    }
}
