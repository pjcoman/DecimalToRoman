package comapps.com.decimaltoroman;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import comapps.com.decimaltoroman.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {


    private SystemUiHider mSystemUiHider;

    private EditText decimalNumber;
    private TextView romanNumber;
    private int input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);


        decimalNumber = (EditText) findViewById(R.id.editText);
        romanNumber = (TextView) findViewById(R.id.textView);
        romanNumber.setText("");

        decimalNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    input = Integer.parseInt(decimalNumber.getText().toString());
                } catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }


            //    String stringRoman = "";

            String stringRoman = RomanConvert.IntegerToRomanNumeral(input);



                romanNumber.setText(stringRoman);

            }

            @Override
            public void afterTextChanged(Editable s) {

                String finalStringRoman = String.valueOf(romanNumber.getText());

                int counter = finalStringRoman.length() - finalStringRoman.replace("M", "").length();



                finalStringRoman = finalStringRoman.replace("M", "");

                String numberOfMs = String.valueOf(counter);



                switch (counter) {

                    case (0): {
                        romanNumber.setText(finalStringRoman);
                        break;


                    }

                    case (1): {


                        int x = Integer.parseInt(decimalNumber.getText().toString());

                        if ( x < 1000 ) {

                            romanNumber.setText(finalStringRoman + "M");
                        } else {

                            romanNumber.setText("M" + finalStringRoman);

                        }


                        break;


                    }

                    default: {

                        int thousands = counter * 1000;
                        int x = Integer.parseInt(decimalNumber.getText().toString());



                       if (x < thousands){

                            numberOfMs = String.valueOf(counter - 1);

                           switch (counter) {

                               case (2):
                                   romanNumber.setText("M" + finalStringRoman.charAt(0) + "M" + finalStringRoman.substring(1));
                                   break;
                               default:
                                   romanNumber.setText(numberOfMs + "!M" + finalStringRoman.charAt(0) + "M" + finalStringRoman.substring(1));
                                   break;

                           }

                        } else {

                            romanNumber.setText(numberOfMs + "!M" + finalStringRoman);


                        }


                    }

                }
            }
        });
    }
}
