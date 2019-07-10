package ernestchan.quizapp;

public class MultipleChoiceQuestion extends Question {

    private int mOptionsResId;
    private int mAnswer;

    public MultipleChoiceQuestion(int textResId, int hintTextResId, int optionsResId, int ans) {
        super(textResId, hintTextResId);
        mOptionsResId = optionsResId;
        mAnswer = ans;
    }

    public int getmOptionsResId() {
        return mOptionsResId;
    }

    @Override
    public boolean checkAnswer(int ans) {
        return mAnswer == ans;

    }

    @Override
    public boolean isMultipleChoiceQuestion(){
        return true;
    }


}
