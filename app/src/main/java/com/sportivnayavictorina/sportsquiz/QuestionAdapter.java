package com.sportivnayavictorina.sportsquiz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private static final String TAG = "QuestionAdapter";
    private LayoutInflater inflater;
    private List<Question_Model> questions;
    Context context;

    public QuestionAdapter(Context context, List<Question_Model> questions) {
        this.inflater = LayoutInflater.from(context);
        this.questions = questions;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_quiz, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Question_Model current = questions.get(position);
        holder.setQuestion("Вопрос №" + (position+1));
        // holder.setAnswer(current.answer);
        holder.setOptions(current, position);
        Log.e(TAG, position + " :onBindViewHolder: " + current.toString());

    }

    @Override
    public int getItemCount() {
        if (questions == null) {
            return 0;
        } else {
            return questions.size();
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayoutContainer;
        ImageView image_item;
        private TextView txt_item_vop;
        private RadioGroup radioGroupOptions;
        private RadioButton radioButtonOption1, radioButtonOption2;
        private RadioButton radioButtonOption3, radioButtonOption4;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayoutContainer = itemView.findViewById(R.id.linear_layout_container);
            image_item = itemView.findViewById(R.id.image_item);
            txt_item_vop = itemView.findViewById(R.id.txt_item_vop);
            radioGroupOptions = itemView.findViewById(R.id.radio_group_options);
            radioButtonOption1 = itemView.findViewById(R.id.radio_button_option_1);
            radioButtonOption2 = itemView.findViewById(R.id.radio_button_option_2);
            radioButtonOption3 = itemView.findViewById(R.id.radio_button_option_3);
            radioButtonOption4 = itemView.findViewById(R.id.radio_button_option_4);
        }

        public void setQuestion(String question) {
            txt_item_vop.setText(question);
        }

        public void setOptions(Question_Model question, int position) {
            radioGroupOptions.setTag(position);

            int resID = context.getResources().getIdentifier(question.getSrc_image() , "drawable", context.getPackageName());
            image_item.setImageResource(resID);

            radioButtonOption1.setText(question.getOptionA());
            radioButtonOption2.setText(question.getOptionB());
            radioButtonOption3.setText(question.getOptionC());
            radioButtonOption4.setText(question.getOptionD());

            Log.e(TAG, position + " :setOptions: " + question.toString());


            if (question.isAnswered) {
                radioGroupOptions.check(question.getCheckedId());

            } else {
                radioGroupOptions.check(-1);
            }
            radioGroupOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int pos = (int) group.getTag();
                    Question_Model que = questions.get(pos);
                    que.isAnswered = true;
                    que.checkedId = checkedId;
                    Log.e(TAG, pos + " :onCheckedChanged: " + que.toString());
                    if (question.correctOption==1 && radioButtonOption1.getId()==question.getCheckedId() && !QuizActivity.wer[position])
                        QuizActivity.wer[position] = true;
                    else if (question.correctOption==2 && radioButtonOption2.getId()==question.getCheckedId() && !QuizActivity.wer[position])
                        QuizActivity.wer[position] = true;
                    else if (question.correctOption==3 && radioButtonOption3.getId()==question.getCheckedId() && !QuizActivity.wer[position])
                        QuizActivity.wer[position] = true;
                    else if (question.correctOption==4 && radioButtonOption4.getId()==question.getCheckedId() && !QuizActivity.wer[position])
                        QuizActivity.wer[position] = true;
                    if(questions.get(pos).isAnswered)
                    btn_backgruond(que, checkedId, position);


                }
            });
        }
        public void btn_backgruond (  Question_Model que,int checkedId, int pos){
            int t=0;
            if(t<pos)t=pos;
            switch (checkedId) {
                case R.id.radio_button_option_1:
                   // Toast.makeText(context,Integer.toString(QuizActivity.list.size()), LENGTH_SHORT).show();
                    radioButtonOption1.setClickable(false);
                    radioButtonOption2.setClickable(false);
                    radioButtonOption3.setClickable(false);
                    radioButtonOption4.setClickable(false);
                    if (que.correctOption == 1) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);



                    } else if (que.correctOption == 2) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);
                    } else if (que.correctOption == 3) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);
                    } else {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn_radio_true);
                    }
                    break;
                case R.id.radio_button_option_2:
                    radioButtonOption1.setClickable(false);
                    radioButtonOption2.setClickable(false);
                    radioButtonOption3.setClickable(false);
                    radioButtonOption4.setClickable(false);
                    if (que.correctOption == 1) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);

                    } else if (que.correctOption == 2) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);


                    } else if (que.correctOption == 3) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);
                    } else {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn_radio_true);
                    }
                    break;

                case R.id.radio_button_option_3:
                    radioButtonOption1.setClickable(false);
                    radioButtonOption2.setClickable(false);
                    radioButtonOption3.setClickable(false);
                    radioButtonOption4.setClickable(false);
                    if (que.correctOption == 1) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);
                    } else if (que.correctOption == 2) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);

                    } else if (que.correctOption == 3) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn);

                    } else {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn_radio_true);
                    }
                    break;
                case R.id.radio_button_option_4:
                    radioButtonOption1.setClickable(false);
                    radioButtonOption2.setClickable(false);
                    radioButtonOption3.setClickable(false);
                    radioButtonOption4.setClickable(false);
                    if (que.correctOption == 1) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn_radio_false);
                    } else if (que.correctOption == 2) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn_radio_false);

                    } else if (que.correctOption == 3) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn_radio_false);
                    } else {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                        radioButtonOption4.setBackgroundResource(R.drawable.btn_radio_true);


                    }
                    break;

                default:
                    radioButtonOption1.setBackgroundResource(R.drawable.btn);
                    radioButtonOption2.setBackgroundResource(R.drawable.btn);
                    radioButtonOption3.setBackgroundResource(R.drawable.btn);
                    radioButtonOption4.setBackgroundResource(R.drawable.btn);
                    radioButtonOption1.setClickable(true);
                    radioButtonOption2.setClickable(true);
                    radioButtonOption3.setClickable(true);
                    radioButtonOption4.setClickable(true);

                    break;
            }
        }
    }
}