package ernestchan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;

    private LinearLayout mTrueFalseContainer;
    private LinearLayout mFillTheBlankContainer;

    private EditText mEditText;

    TextView score_view;
   // Button true_button;

    int score = 0;

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mBackButton;
    private Button mHelpButton;
    private Button mCheckButton;

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
        mCheckButton = (Button) findViewById(R.id.check_button);

        mTrueFalseContainer = (LinearLayout) findViewById(R.id.true_false_container);
        mFillTheBlankContainer = (LinearLayout) findViewById(R.id.fill_the_blank_container);

        mEditText = (EditText) findViewById(R.id.edit_text);

        score_view = (TextView) findViewById(R.id.score_view);
        score_view.setText("Score: " + score);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mBackButton.setOnClickListener(this);
        mHelpButton.setOnClickListener(this);
        mCheckButton.setOnClickListener(this);
//when next button is clicked next button runs

        mTextView = (TextView) findViewById(R.id.text_view);

        mQuestions = new Question[6];
        mIndex = 0;

        mQuestions[0] = new TrueFalseQuestion(R.string.question_text1, R.string.question_text1_hint, true);
        mQuestions[1] = new TrueFalseQuestion(R.string.question_text2, R.string.question_text2_hint, false);
        mQuestions[2] = new TrueFalseQuestion(R.string.question_text3, R.string.question_text3_hint, true);
        mQuestions[3] = new TrueFalseQuestion(R.string.question_text4, R.string.question_text4_hint, true);
        mQuestions[4] = new TrueFalseQuestion(R.string.question_text5, R.string.question_text5_hint, false);

        String[] q6Answers = getResources().getStringArray(R.array.question_6_answers);
        mQuestions[5] = new FillTheBlankQuestion(R.string.question_text6, R.string.question_text6_hint, q6Answers);

        setupQuestion();
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
            if (mIndex < 5) {
                mIndex++;
                setupQuestion();
            }
        }
        else if (view.getId() == R.id.check_button) {
            if (mQuestions[mIndex].checkAnswer(mEditText.getText().toString())) {
                checkAnswer(mEditText.getText().toString());
            }
//             else
//            {
//
//            }
        } else if (view.getId() == R.id.back_button) {
            if (mIndex > 0) {
                mIndex--;
                setupQuestion();
            }
        } if (view.getId() == R.id.hintTextResId) {

            // USING INDEX
            Toast myToast = Toast.makeText(this, mQuestions[mIndex].getHintTextResId(), Toast.LENGTH_LONG);
            myToast.show();
        }
    }


    public void setupQuestion() {
        //Setup the first question.
        mTextView.setText(mQuestions[mIndex].getTextResId());

        if (mQuestions[mIndex].isTrueFalseQuestion()) {
            mTrueFalseContainer.setVisibility(View.VISIBLE);
            mFillTheBlankContainer.setVisibility(View.GONE);
        } else if (mQuestions[mIndex].isFillTheBlankQuestion()) {
            mTrueFalseContainer.setVisibility(View.GONE);
            mFillTheBlankContainer.setVisibility(View.VISIBLE);
        }
    }

    public boolean checkAnswer(boolean userInput) {
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

    public boolean checkAnswer(String userInput) {
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