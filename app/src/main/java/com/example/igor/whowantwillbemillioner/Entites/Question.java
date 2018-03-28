package com.example.igor.whowantwillbemillioner.Entites;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {


    private int id;
    private String questionText;
    private String[] answer = new String[4];
    private int trueAnswer;

    private static final ArrayList<Question> questions = new ArrayList<>(Arrays.asList(new Question[] {
            new Question(0, "Когда родился Иван Грозный?", new String[]{"1234","1345", "1242", "1531"}, 3),
            new Question(1, "Когда родился Иваныч?", new String[]{"1234", "1531","1345", "1242"}, 1),
            new Question(2, "Сколько пальцев на руке?", new String[]{"4", "1","5", "2"}, 2),
            new Question(3, "Характерные особенности этого стиля стрельчатые арки, огромные окна и витражи", new String[]{"Романский стиль", "Готический стиль","Барокко", "Классицизм"}, 1),
            new Question(4, "Этот стиль в переводе означает «причудливый, вычурный»", new String[]{"Готический", "Ампир","Модерн", "Барокко"}, 3),
            new Question(5, "Кто является выдающимся собирателем русской живописи", new String[]{"П. Третьяков", "С. Мамонтов","П. Рябушинский", "Е. Лансере"}, 0),
            new Question(6, "Отличительной чертой греческого скульптурного изображения является:", new String[]{"передача портретных сходств модели", "идеализация (каноничность) образа","исполнение в дереве", "изображение богов"}, 1),
            new Question(7, "Кто из художников написал картину «Рождение Венеры»?", new String[]{"Леонардо да Винчи", "Караваджо","Сандро Боттичелли", "Перуджино"}, 3)

    }));
    public Question(int id, String questionText, String[] answer, int trueAnswer) {
        this.id = id;
        this.questionText = questionText;
        this.answer = answer;
        this.trueAnswer = trueAnswer;
    }

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getAnswer() {
        return answer;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }
}