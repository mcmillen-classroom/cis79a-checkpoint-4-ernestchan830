package ernestchan.quizapp;

public class Question {
    private int mTextResId;
    private int mHintTextResId;

    public Question(int textResId, int hintTextResId) {
        mTextResId = textResId;
        mHintTextResId = hintTextResId;
    }

    public int getHintTextResId() {
        return mHintTextResId;
    }

    public void setHintTextResId(int hintTextResId) {
        mHintTextResId = hintTextResId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }


    //stb `method
    public boolean checkAnswer(boolean boolResponse) {
        return false;
    }
    //stub method
    public boolean checkAnswer(String answer) {
        return false;
    }

    public boolean isTrueFalseQuestion(){
        return false;
    }
    public boolean isFillTheBlankQuestion(){
        return false;
    }
    public boolean isMultipleChoiceQuestion(){
        return false;
    }
    public boolean checkAnswer(int ans){
    return false;

    }
}
