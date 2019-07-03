package ernestchan.quizapp;

public class FillTheBlankQuestion extends Question {

    private String[] mFillAnswer;

    public FillTheBlankQuestion(int textResId, int hintTextResId, String[] fillAnswers) {
        super(textResId, hintTextResId);
    }

    @Override
    public boolean checkAnswer(String userAnswer)
    {
        for (String ans : mFillAnswers())
        {
            if (ans.equalsIgnoreCase(userAnswer))
            {
                return true;
            }
        }

        return false;
    }
//    @Override
//    public boolean isFillTheBlankQuestion(){
//        return true;
//    }
}
