package multithreading;
class QuestionAnswer {
    boolean questionAsked = false;

    synchronized void askQuestion(String question) {
        while (questionAsked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Student asks: " + question);
        questionAsked = true;
        notify();
    }

    synchronized void answerQuestion(String answer) {
        while (!questionAsked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Teacher answers: " + answer);
        questionAsked = false;
        notify();
    }
}

class Student extends Thread {
    private QuestionAnswer qa;

    public Student(QuestionAnswer qa) {
        this.qa = qa;
    }

    public void run() {
        String[] questions = { "What is Java?", "What is Thread?", "What is Synchronization?" };
        for (String question : questions) {
            qa.askQuestion(question);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Teacher extends Thread {
    private QuestionAnswer qa;

    public Teacher(QuestionAnswer qa) {
        this.qa = qa;
    }

    public void run() {
        String[] answers = { "Java is a programming language.", "Thread is a unit of execution.",
                "Synchronization avoids data inconsistency." };
        for (String answer : answers) {
            qa.answerQuestion(answer);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class QnAExample {
    public static void main(String[] args) {
        QuestionAnswer qa = new QuestionAnswer();
        new Student(qa).start();
        new Teacher(qa).start();
    }
}
