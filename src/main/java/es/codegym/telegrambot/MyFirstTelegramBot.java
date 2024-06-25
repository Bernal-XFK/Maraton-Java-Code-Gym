package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "MaratonCodeGymGato_bot";
    public static final String TOKEN = "7357374910:AAEQNuaqOUPMm2JVx49rI-C_r8y-jHTRAvE";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if(getMessageText().equals("/start")){
            sendPhotoMessageAsync("step_1_pic");
        setUserGlory(0);
        sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera","step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            sendPhotoMessageAsync("step_2_pic");
        setUserGlory(20);
        sendTextMessageAsync(STEP_2_TEXT,Map.of(
                "Tomar una salchicha! +20 de fama","step_2_btn",
                "Tomar un pescado! +20 de fama","step_2_btn",
                "Tirar una lata de pepinillos! +20 de fama","step_2_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            sendPhotoMessageAsync("step_3_pic");
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,Map.of(
                    "Hackear al robot aspiradora!!! +20 de fama","step_3_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            sendPhotoMessageAsync("step_4_pic");
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,Map.of(
                    "Envia al robot aspiradora por comida +30 de fama","step_4_btn",
                    "Da un paseo en el robot aspiradora! +30 de fama","step_4_btn",
                    "Huir del robot aspiradora!!!! +30 de fama","step_4_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            sendPhotoMessageAsync("step_5_pic");
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,Map.of("Usa la GoPro y enciendela!!!! +30 de fama","step_5_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            sendPhotoMessageAsync("step_6_pic");
            setUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,Map.of(
                    "Unas gafas de gato fachero +30 de fama","step_6_btn",
                    "Un sombrero elegante para gato +30 de fama","step_6_btn"
                    ));
        }
        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            sendPhotoMessageAsync("step_7_pic");
            setUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT,Map.of(
                    "Hackea la contraseña de la computadora ","step_7_btn"
            )); 
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            sendPhotoMessageAsync("step_8_pic");
            setUserGlory(50);
            sendTextMessageAsync(STEP_8_TEXT,Map.of(
                    "*TERMINA EL JUEGO!* ","step_8_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}
