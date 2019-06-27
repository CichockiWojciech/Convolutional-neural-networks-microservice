package pl.messages;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
    private final int age;
    private final String job;
    private final String martial;
    private final String education;
    private final String creditDefault;
    private final int balance;
    private final String housing;
    private final String loan;
    private final String contact;
    private final String day;
    private final String month;
    private final long duration;
    private final int campaign;
    private final int pdays;
    private final int previous;
    private final String poutcome;

    @Override
    public String toString() {
        return age + "\n" +
                job + "\n" +
                martial + "\n" +
                education + "\n" +
                creditDefault + "\n" +
                balance + "\n" +
                housing + "\n" +
                loan + "\n" +
                contact + "\n" +
                day + "\n" +
                month + "\n" +
                duration + "\n" +
                campaign + "\n" +
                pdays + "\n" +
                previous + "\n" +
                poutcome;
    }
}
