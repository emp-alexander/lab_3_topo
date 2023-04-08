package com.example.millionairegame;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GameController {
    @FXML
    private Label questionText, winText, sumText;

    @FXML
    private Button giveAnsBtn, goBtn, btnHint1, btnHint2, btnHint3;

    @FXML
    private CheckBox answ1, answ2, answ3, answ4;

    private Question q1, q2, q3, q4, q5, q6; //вопросы
    private ArrayList<Question> questions; //пул вопросов
    private List<String> answer1; //вар-ты ответов к первому вопросу
    private List<String> answer2; //вар-ты ответов к второму вопросу
    private List<String> answer3;
    private List<String> answer4;
    private List<String> answer5;
    private List<String> answer6;
    private int[] hint501, hint502, hint503, hint504, hint505, hint506; //подсказки 50/50 к 1 и 2 вопросу

    private Game game;

    @FXML
    public void initialize() {
        questionText.setText("Кто хочет стать миллионером?");
        giveAnsBtn.setText("Дать ответ");
        hint501 = new int[]{3, 2};
        hint502 = new int[]{4, 2};
        hint503 = new int[]{4, 2};
        answer1 = new ArrayList<>();
        answer2 = new ArrayList<>();
        answer3 = new ArrayList<>();
        Collections.addAll(answer1, "тесто", "золото", "сено", "каша");
        Collections.addAll(answer2, "Питсбург", "Москва", "Санкт-Петербург", "Киров");
        Collections.addAll(answer3, "Пушкин", "Лермонтов", "Есенин", "Блок");
        q1 = new Question("Из чего сделан колобок?", 0,  answer1, 0, hint501, 1);
        q2 = new Question("Культурная столица России?", 1,  answer2, 2, hint502, 2);
        q3 = new Question("Поэт деревни?", 2,  answer3, 2, hint503, 2);
        hint504 = new int[]{3, 2};
        hint505 = new int[]{4, 2};
        hint506 = new int[]{4, 2};
        answer4 = new ArrayList<>();
        answer5 = new ArrayList<>();
        answer6 = new ArrayList<>();
        Collections.addAll(answer4, "Антананариву", "Тиват", "Каир", "Александрия");
        Collections.addAll(answer5, "Плёс", "Сочи", "Барнаул", "Саратов");
        Collections.addAll(answer6, "1702", "1700", "1703", "1704");
        q4 = new Question("Столица Мадагаскара?", 3,  answer4, 0, hint504, 1);
        q5 = new Question("В каком городе останавливался Левитан?", 4,  answer5, 0, hint505, 3);
        q6 = new Question("Дата основания Санкт-Петербуга?", 5,  answer6, 2, hint506, 3);
        questions = new ArrayList<>();
        Collections.addAll(questions, q1, q2, q3, q4, q5, q6);

    }

    @FXML
    public void start(){
        if(goBtn.getText() == "Забрать деньги"){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы решили забрать деньги");
            alert.setHeaderText(null);
            alert.setContentText("Ваш выйгрышь: " + game.getScore());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                Platform.exit();
            }
        }
        goBtn.setText("Забрать деньги");
        play();

    }

    @FXML
    private void play() {
        game = new Game(questions);

        showNextQuestion(game.getCurrentQuestionIndex());
        boolean[] hint = game.getHint();

        btnHint1.setOnAction(event -> {
            boolean[] newHint = new boolean[]{false, hint[1], hint[2]};
            game.setHint(newHint);
            btnHint1.setVisible(false);
        });
//        btnHint2.setOnAction(event -> {
//            boolean[] newHint = new boolean[]{hint[0], false, hint[2]};
//            game.setHint(newHint);
//            btnHint2.setVisible(false);
//            //showNextQuestion(game.getNextQuestion().getId());
//            showNextQuestion(game.getRandomQuestion(questions, game.getQuestions().get(game.getCurrentQuestionIndex()).getDifficulty()).getId());
//
//        });
        btnHint3.setOnAction(event -> {
            boolean[] newHint = new boolean[]{hint[0], hint[1], false};
            game.setHint(newHint);
            btnHint3.setVisible(false);
            int[] hint50 = game.getQuestions().get(game.getCurrentQuestionIndex()).getHint50();
            int fDel = hint50[0];
            int sDel = hint50[1];
            if(fDel == 1 || sDel == 1)
                answ1.setVisible(false);
            if(fDel == 2 || sDel == 2)
                answ2.setVisible(false);
            if(fDel == 3 || sDel == 3)
                answ3.setVisible(false);
            if(fDel == 4 || sDel == 4)
                answ4.setVisible(false);
        });

        giveAnsBtn.setOnAction(event -> {
            giveAnswer(game);
            boolean[] newHint = new boolean[]{true, true, true}; //подсказки все сбрасываются, кнопки изчезают, пользоваетель не сможет уже в любом случае изменить подсказку, а в методе giveAnswer возникают проблемы
            game.setHint(newHint);
            answ1.setVisible(true);
            answ2.setVisible(true);
            answ3.setVisible(true);
            answ4.setVisible(true);
        });


    }

    private void showNextQuestion(int currentQuestion) {
        sumTextFunc(currentQuestion);
        questionText.setText(game.getQuestions().get(currentQuestion).getQuastionsText());
        answ1.setText(game.getQuestions().get(currentQuestion).getAnswerOptions().get(0));
        answ2.setText(game.getQuestions().get(currentQuestion).getAnswerOptions().get(1));
        answ3.setText(game.getQuestions().get(currentQuestion).getAnswerOptions().get(2));
        answ4.setText(game.getQuestions().get(currentQuestion).getAnswerOptions().get(3));

    }

    private void sumTextFunc(int currentQuestion) {
        switch (game.getQuestions().get(currentQuestion).getDifficulty()){
            case (1) :
                sumText.setText("500");
                break;
            case (2) :
                sumText.setText("1000");
                break;
            case (3) :
                sumText.setText("5000");
                break;
            case (6) :
                sumText.setText("10000");
                break;
            case (7) :
                sumText.setText("50000");
                break;
        }

    }

    private void giveAnswer(Game game){
        try {
            boolean[] hintArray = game.getHint();
            int hint1 = 0;
            if(answ1.isSelected()) {
                if(game.checkAnswer(0, game.getQuestions().get(game.getCurrentQuestionIndex()))) {
                    game.addScore(game.getQuestions().get(game.getCurrentQuestionIndex()));
                    winText.setText("Текущий выйгрышь:" + Integer.toString(game.getScore()));
                    showNextQuestion(game.getRandomQuestion(questions, game.getQuestions().get(game.getCurrentQuestionIndex()).getPlusOneDifficulty()).getId());
                }
                else {
                    if (hintArray[0] == false && hint1 == 0) {
                        noTrueAnsw();
                        hint1 = 1;
                    }
                    else {
                        lose();
                    }
                }
            }
            if(answ2.isSelected()) {
                if(game.checkAnswer(1, game.getQuestions().get(game.getCurrentQuestionIndex()))) {
                    game.addScore(game.getQuestions().get(game.getCurrentQuestionIndex()));
                    winText.setText("Текущий выйгрышь:" + Integer.toString(game.getScore()));
                    //showNextQuestion(game.getNextQuestion().getId());
                    showNextQuestion(game.getRandomQuestion(questions, game.getQuestions().get(game.getCurrentQuestionIndex()).getPlusOneDifficulty()).getId());
                }
                else {
                    if (hintArray[0] == false && hint1 == 0) {
                        noTrueAnsw();
                        hint1 = 1;
                    }
                    else {
                        lose();
                    }
                }
            }
            if(answ3.isSelected()) {
                if(game.checkAnswer(2, game.getQuestions().get(game.getCurrentQuestionIndex()))) {
                    game.addScore(game.getQuestions().get(game.getCurrentQuestionIndex()));
                    winText.setText("Текущий выйгрышь:" + Integer.toString(game.getScore()));
//                    showNextQuestion(game.getNextQuestion().getId());
                    showNextQuestion(game.getRandomQuestion(questions, game.getQuestions().get(game.getCurrentQuestionIndex()).getPlusOneDifficulty()).getId());
                }
                else {
                    if (hintArray[0] == false && hint1 == 0) {

                        noTrueAnsw();
                        hint1 = 1;
                    }
                    else {
                        lose();
                    }
                }
            }
            if(answ4.isSelected()) {
                if(game.checkAnswer(3, game.getQuestions().get(game.getCurrentQuestionIndex()))) {
                    game.addScore(game.getQuestions().get(game.getCurrentQuestionIndex()));
                    winText.setText("Текущий выйгрышь:" + Integer.toString(game.getScore()));
//                    showNextQuestion(game.getNextQuestion().getId());
                    showNextQuestion(game.getRandomQuestion(questions, game.getQuestions().get(game.getCurrentQuestionIndex()).getPlusOneDifficulty()).getId());
                }
                else {
                    if (hintArray[0] == false && hint1 == 0) {
                        noTrueAnsw();
                        hint1 = 1;
                    }
                    else {
                        lose();
                    }
                }
            }
        }
        catch (NullPointerException e){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Победа!");
            alert.setHeaderText(null);
            alert.setContentText("Ваш выйгрышь: " + game.getScore());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                Platform.exit();
            }

        }
    }

    private void noTrueAnsw() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Не верно!");
        alert.setHeaderText(null);
        alert.setContentText("Не верный ответ, выберете другой");
        alert.showAndWait();
    }

    public void lose(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Поражение!");
        alert.setHeaderText(null);
        alert.setContentText("Вы проиграли");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            Platform.exit();
        }
    }
}