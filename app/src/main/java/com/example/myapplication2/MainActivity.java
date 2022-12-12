package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> s;
    ArrayAdapter arrayAdapter;
    int n=0;
    private static final String TAG = "Swipe Position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s=new ArrayList<String>();
        s.add("one");
        s.add("two");
        s.add("three");
        s.add("four");
        s.add("five");

        SwipeFlingAdapterView swipeFlingAdapterView=(SwipeFlingAdapterView) findViewById(R.id.card);
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.details, R.id.textView,s);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter()
            {
                s.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o)
            {
                Toast.makeText(MainActivity.this, "Right is swiped", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Right Swipe");

                try {
                String stringSenderEmail = "gil.arussi@boyar.org.il";
                String stringReceiverEmail = "gil2005.ar@gmail.com";
                String stringPasswordSenderEmail = "pomodoro";
                String stringHost = "smtp.gmail.com";

                Properties properties = System.getProperties();
                properties.put("mail.smtp.host", stringHost);
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");


                javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail);
                    }
                });


                MimeMessage mimeMessage = new MimeMessage(session);

                    mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(stringReceiverEmail));

                    mimeMessage.setSubject("Android App Email");
                    mimeMessage.setText("Hello, I want to work for you");

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                Transport.send(mimeMessage);
                            } catch (MessagingException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();

                } catch (AddressException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });
    }
}