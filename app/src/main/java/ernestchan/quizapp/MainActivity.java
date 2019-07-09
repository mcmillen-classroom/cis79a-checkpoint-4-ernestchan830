package ernestchan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;

    TextView score_view;
    Button true_button;

    int score = 0;

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mBackButton;
    private Button mHelpButton;


    private Question[] mQuestions;
    private int mIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mBackButton = (ImageButton) findViewById(R.id.back_button);
        mHelpButton = (Button) findViewById(R.id.hintTextResId);

        score_view = (TextView) findViewById(R.id.score_view);
        score_view.setText("Score: " + score);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mBackButton.setOnClickListener(this);
        mHelpButton.setOnClickListener(this);
//when next button is clicked next button runs

        mTextView = (TextView) findViewById(R.id.text_view);

        mQuestions = new Question[5];
        mIndex = 0;

        mQuestions[0] = new TrueFalseQuestion(R.string.question_text1, R.string.question_text1_hint, true);
        mQuestions[1] = new TrueFalseQuestion(R.string.question_text2, R.string.question_text2_hint, false);
        mQuestions[2] = new TrueFalseQuestion(R.string.question_text3, R.string.question_text3_hint, true);
        mQuestions[3] = new TrueFalseQuestion(R.string.question_text4, R.string.question_text4_hint, true);
        mQuestions[4] = new TrueFalseQuestion(R.string.question_text5, R.string.question_text5_hint, false);

        String[] q6Answers = getResources().getStringArray(R.array.question_6_answers);
        mQuestions[5] = new FillTheBlankQuestion(R.string.question_text6, R.string.question_text6_hint, q6Answers);

        mTextView.setText(mQuestions[mIndex].getTextResId());
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.true_button) {
            checkAnswer(true);
            score_view.setText("Score: " + score);

        } else if (view.getId() == R.id.false_button) {
            checkAnswer(false);
            score_view.setText("Score: " + score);

        } else if (view.getId() == R.id.next_button) {
            if (mIndex < 4){
                mIndex++;
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
        } else if (view.getId() == R.id.back_button){
            if (mIndex > 0) {
                mIndex--;
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
        }  if (view.getId() == R.id.hintTextResId) {

            // USING INDEX
            Toast myToast = Toast.makeText(this, mQuestions[mIndex].getHintTextResId(), Toast.LENGTH_LONG);
            myToast.show();
        }
    }

        public boolean checkAnswer(boolean userInput){
            if (mQuestions[mIndex].checkAnswer(userInput)) {
                Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
                myToast.show();
                score++;
                return true;
            } else {
                Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
                myToast.show();
                score--;
                return false;
            }
        }
    }