package com.example.edipo.sesamoapp.service;

//data structures
import java.util.ArrayList;

//android features
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

//smack api for XMPP-server
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;

import static org.jivesoftware.smack.packet.Message.*;

/**
 * A ClientChat is a definition of the chat's client side. It has a connection
 * with the server and holds the client's connection status. It also manages
 * the request answers returned by the server.
 * Created by Mateus de Freitas on 30/06/2015.
 */

public class ClientChat extends Activity {
    private ArrayList<String> messages = new ArrayList();
    private Handler handler = new Handler();
    private xmppsettings settings;
    private XMPPConnection connection;
    private ListView list;
    private EditText sender;
    private EditText recipient;

    @Override
    public void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        recipient = (EditText) this.findViewById(R.id.recipient);
        sender = (EditText) this.findViewById(R.id.text);
        list = (ListView) this.findViewById(R.id.messageList);
        setListAdapter();

        //Window for getting settings
        settings = new xmppsettings(this);

        //Listener for chat message
        Button send = (Button) this.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String to = recipient.getText().toString();
                String text1 = sender.getText().toString();

                Message msg = new Message(to, Type.chat);
                msg.setBody(text1);
                connection.sendPacket(msg);
                messages.add(connection.getUser() + ":");
                messages.add(text1);
                setListAdapter();
            }
        });

    }

    public void setConnection (XMPPConnection connection) {
        this.connection = connection;
        if (connection != null) {
            Message m = new Message("null", Type.chat);
            PacketFilter filter = new MessageTypeFilter(m.getType());
            connection.addPacketListener(new PacketListener() {

                public void processPacket(Packet packet) {
                    Message message = (Message) packet;
                    if (null != message.getBody()) {
                        String fromName = message.getFrom();
                        messages.add(fromName + ":");
                        messages.add(message.getBody());
                        handler.post(new Runnable() {
                            public void run() {
                                setListAdapter();
                            }
                        });
                    }
                }
            }, filter);
        }
    }

    private void setListAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, R.layout.list, messages);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        /*inflater.inflate(R.menu.menu, menu);*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.settings:
                settings.show();
                return true;
            case R.id.quit:
                finish();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
