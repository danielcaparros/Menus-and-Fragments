package com.caparros.daniel.mascotas.JavaMail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.caparros.daniel.mascotas.JavaMail.ConfiguracionEmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by daniel on 16/12/2016.
 */

public class EnviarEmail extends AsyncTask<Void,Void,Void>{

    //Declaracion variables
    private Context context;
    private Session session;

    //Informacion to send email
    private String email;
    private String contacto;
    private String mensaje;

    //DialogProgress to show while sending email
    private ProgressDialog progressDialog;

    //Class Constructor
    public EnviarEmail(Context context, String email, String contacto, String mensaje){


        this.context=context;
        this.email=email;
        this.contacto=contacto;
        this.mensaje=mensaje;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //showing progress dialog while sending email
        progressDialog=ProgressDialog.show(context,"Enviando comentario","Por favor, espere...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dimissing the progress dialog
        progressDialog.dismiss();;
        //Showing a success message
        Toast.makeText(context,"Mensaje enviado",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        //Creating properties
        Properties properties = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

        //Creating a new session
        session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
            //Authenticating the password
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ConfiguracionEmail.EMAIL, ConfiguracionEmail.PASSWORD);
            }
        });
        try{
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(ConfiguracionEmail.EMAIL));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Adding subject
            mm.setSubject(contacto);
            //Adding message
            mm.setText(mensaje);

            //Sending email
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        return null;
    }
}
