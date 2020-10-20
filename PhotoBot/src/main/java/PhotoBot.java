import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import com.vdurmont.emoji.EmojiParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class PhotoBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

          String [] chunmadm = {"tushunmadim!", "uzur tushunmadim", "men hali uzbek tilini zo'r bilmayman", ":-("};

        String [] sukishlar = {"blya", "suka", "jalab", "blyaaa", "jinni", "axmoq", "ahmoq", "tupoy", "durak",
                "loh", "lox", "boq", "blyaa", "kot", "kut", "zaybal", "zayebal", "zayibal"};
        String [] ozinchi = {"ozinchi", "ozinchi?", "ozingizchi", "ozingizchi?", "o'zinchi", "o'zingizchi", "o'zinchi?",
                "o'zingizchi?", "uzinchi", "uzingizchi", "uzinchi"};
        String [] mahtash = {"gap yo", "gap yo lekn", "qoyil", "qoyil e", "daxshad", "daxshadku", "zor bot ekan san",
                "zor bot", "zur bot ekan siz", "zor bot ekan siz", "gap yo!", "ux ti", "ux", "uh ti", "waw", "wow", "uxti", "uhti"};
        String [] nma = {"nmani", "nima", "nma", "nimani", "nmani?", "nima?", "nimani boshli", "nmani boshli"};
        String [] blmadim = {"blmadim", "bilmadim", "blmadm", "bilmadm", "bilmiman", "blmiman"};
        String [] urgan = {"urgan", "o'rgan", "organ"};
        String [] tillar = {"uzbek", "russ", "ingliz", "tojik", "qozoq", "kirgiz", "xitoy", "nemis",
                "fransuz", "ispan", "uzbek tilini", "uzbekcha", "uzbekcha faqat", "uzbek tilini faqat",
                "uzbek tilini"};

        List<String> sukinish = new ArrayList<>(Arrays.asList(sukishlar));
        List<String> ozinchilist = new ArrayList<>(Arrays.asList(ozinchi));
        List<String> nmalist = new ArrayList<>(Arrays.asList(nma));
        List<String> blmadmlist = new ArrayList<>(Arrays.asList(blmadim));
        List<String> urganlist = new ArrayList<>(Arrays.asList(urgan)) ;
        List<String> maqtashlist = new ArrayList<>(Arrays.asList(mahtash));
        List<String > tillarlist = new ArrayList<>(Arrays.asList(tillar));


        if(update.hasMessage() && update.getMessage().hasText()){
            String user_first_name = update.getMessage().getChat().getFirstName();
            String user_last_name = update.getMessage().getChat().getLastName();
            String user_username = update.getMessage().getChat().getUserName();
            long user_id = update.getMessage().getChat().getId();
            String message = update.getMessage().getText().toLowerCase();
            String newmsg;
            if(message.equals("/help")){
                newmsg = "Sizga qanday yordam bera olaman?";
            }else if(message.equals("/start")){
                newmsg = "Assalomu aleykum " + update.getMessage().getChat().getFirstName() + ". Keling siz bilan Uzbek tilida suhbatlashamiz. Faqat Uzbek alifbosida yozing chunki men Russ tilida o'qishni bilmiman.";
            }else if(message.matches(".*ismin(g)?.*")){
                newmsg = "Mening ismim Test bot. Meni Azizbek Rasulmetov yaratgan Java dasturlash tilida. Sizning ismingiz " + update.getMessage().getChat().getFirstName() + ". Buni blaman :-)";
            }else if(message.equalsIgnoreCase("Ha") || message.equalsIgnoreCase("Hmm") || message.equalsIgnoreCase("Xa") || message.equalsIgnoreCase("Hm") || message.equalsIgnoreCase("xmm") || message.equalsIgnoreCase("chunarli") || message.equalsIgnoreCase("chundim") || message.equalsIgnoreCase("tushunarli") || message.equalsIgnoreCase("tushundim") || message.equalsIgnoreCase("chundim sani")){
                newmsg = "Shunaqa.";
            }else if(message.equalsIgnoreCase("Nega chunmisan") || message.equalsIgnoreCase("Nimaga chunmisan") || message.equalsIgnoreCase("Nmaga chunmisan") || message.equalsIgnoreCase("Nimaga chunmisan?") || message.equalsIgnoreCase("Nega chunmisan?") || message.equalsIgnoreCase("Nega blmisan") || message.equalsIgnoreCase("Nega bilmisan") || message.equalsIgnoreCase("Nega tushunmisan") || message.equalsIgnoreCase("Nmaga tushunmisan")|| message.equalsIgnoreCase("Nimaga tushunmisan") || message.equalsIgnoreCase("Ne chunmisan")){
                newmsg = "Sababi hali yaxshi bilmiman Uzbek tilini! :-(";
            }else if(message.equalsIgnoreCase("Qattan blasan?") || message.equalsIgnoreCase("Qattan bilasan?") || message.equalsIgnoreCase("Qatdan bilasan?") || message.equalsIgnoreCase("Qatdan blasan?") || message.equalsIgnoreCase("Qatdan blasan") || message.equalsIgnoreCase("Qatdan bilasan") || message.equalsIgnoreCase("Qattan bilasan") || message.equalsIgnoreCase("Qattan blasan") || message.equalsIgnoreCase("Qatdan bldin") || message.equalsIgnoreCase("Qattan bldin")){
                newmsg = "Bu narsa sir bola qosin. Axir man aqilliy bot manku";
            }else if(message.equalsIgnoreCase("Yozmisanmi") || message.equalsIgnoreCase("yoz") || message.equalsIgnoreCase("Yozmisanmi?") || message.equalsIgnoreCase("Gapir") || message.equalsIgnoreCase("Gapirin") || message.equalsIgnoreCase("Gapirmisanmi") || message.equalsIgnoreCase("Gapirmisanmi?") || message.equalsIgnoreCase("Gapir e")){
                newmsg = "Ha nima deyishni ham bilmayamman. Chunki Uzbek tilini hali yaxshi bilmiman.";
            }else if(message.equalsIgnoreCase("Hop") || message.equalsIgnoreCase("Ok") || message.equalsIgnoreCase("boldi")){
                newmsg = "Boshlen bomasam";
            }else if(message.matches(".*assalom.*") || message.matches(".*salom.*")){
                newmsg = "Assalomu aleykum! O'ziz qaleysiz?";
            }else if(message.matches(".*aziz.*")){
                newmsg = "Azizbek Rasulmetov bu meni yaratgan inson. Bu kishiga juda minnadorman. :-)";
            }else if (message.matches(".*n(i)?ma q(i)?(l)?v[0a]+s(s)?an.*")){
                newmsg = "Men hozir siz blan gaplashvommanku. Bilib turib so'risiz a!";
            }else if(message.contains(sukinish.toString())){
                newmsg = "Sukinmang iltimos!";
            }else if(ozinchilist.contains(message)){
                newmsg = "Zor albatta!";
            }else if(nmalist.contains(message)){
                newmsg = "Suhbatlashni boshladik";
            }else if(blmadmlist.contains(message)){
                newmsg = "Hop yaxshi.";
            }else if(maqtashlist.contains(message)){
                newmsg = "Rahmat. Hursand qildingiz!";
            }else if(tillarlist.contains(message) || message.matches(".*uzbek.*")){
                newmsg = "Zor ko'pro o'rganishda davom eting! Til bilganga ming tanga, ish bilganga bir tanga digan gap bor";
            }else if(message.matches(".*haha.*")){
                newmsg = "Hahaha";
            }else if(message.matches(".*togri.*") || message.matches(".*tugri.*")){
                newmsg = "Ha to'gri boladida.";
            }else if(message.matches(".*arzi.*")){
                newmsg = ":-)"; //TODO smile
            }else if(sukinish.contains(message) ){
                newmsg = "Iltimos sukinmang!!!! :-|";
            }else if(message.matches(".*yarat.*")){
                newmsg = "Azizbek Rasulmetov meni yaratgan inson. Kotta rahmat ularga!";
            }else if(message.matches(".*hayr.*") || message.matches(".*hayir.*")){
                newmsg = "Hop hayir. Omon bo'lin. Agar yozgiz kelsa manga Salom dib yozing.";
            }else if(message.matches(".*qal[eysan]+.*")){
                newmsg = "Yaxshi rahmat. O'ziz qanaqasiz " + update.getMessage().getChat().getFirstName() + "?";
            }else if(message.matches(".*q(i)?l[ao]?lasan.*") || message.matches(".*b(i)?lasan.*")){
                newmsg = "Men faqat Uzbek tilida suhbatlasha olaman. Sizchi?";
            }else if(message.matches("z[ouo'r]+.*") || message.matches(".*ya[xh]?shi.*")
                    || message.toLowerCase().matches(".*tinch.*") || message.matches(".*m[ae]+n(a)?(m)?[\\s]?(h)?(a)?(m)?")){
                newmsg = "Ha zo'r unda.";
            }else if(message.matches(".*n(i)?ma gap.*")){
                newmsg = "Hech gap yo'q. O'zizda nima gap?";
            }else if(message.matches(".*mayli.*")){
                newmsg = "Ho'p mayli.";
            }else if(message.matches(".*[tush[ch]]+unmadin.*")){
                newmsg = "Yoq. Sizni yaxshi tushunmadim to'grisi.";
            }else if(message.matches(".*lox.*")){
                newmsg = "blya sukinma ddimu!";
            }else {
                Random r = new Random();
                newmsg = chunmadm[r.nextInt(chunmadm.length)];
            }
            SendMessage msg = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(newmsg);
            //Log function
            log(user_first_name, user_last_name, Long.toString(user_id), message, newmsg);
            try {
                execute(msg);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if(update.hasMessage() && update.getMessage().hasPhoto()){
            long chat_id = update.getMessage().getChatId();
            List<PhotoSize> photos = update.getMessage().getPhoto();
            String f_id = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();
            SendPhoto msg = new SendPhoto()
                    .setChatId(chat_id)
                    .setPhoto(f_id)
                    .setCaption("Bu nimasi yana!");
            try{
                sendPhoto(msg);
            }catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
        System.out.println("Bot is run successfully");
    }


    public String getBotUsername() {
        return "TestBot";
    }

    public String getBotToken() {
        return "1150156139:AAFs2R9VUlMK6uEWDsdnvv6niqBGSMVgIh4";
    }

    private void log(String first_name, String last_name, String user_id, String txt, String bot_answer) {
        System.out.println("\n ----------------------------");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Message from " + first_name + " " + last_name + ". (id = " + user_id + ") \n Text - " + txt);
        System.out.println("Bot answer: \n Text - " + bot_answer);
    }
}