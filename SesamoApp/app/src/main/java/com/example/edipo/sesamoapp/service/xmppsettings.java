package com.example.edipo.sesamoapp.service;

//android features
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//smack API for XMPP-server
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;

import java.io.IOException;

/**
 * Created by Lucas Albuquerque on 03/07/2015.
 */
public class xmppsettings extends Dialog implements android.view.View.OnClickListener{

    private ClientChat chatClient;

    public xmppsettings(ClientChat clientChat){
        super(clientChat);
        this.chatClient = clientChat;
    }

    public void onClick(View view){
        String host = "xmpp.sesamoapp.com";
        int port = 5222;
        String service = "gmail.com";
        String username = "tobias";
        String password = "loxonmybagelthatyoucouldnthandle";

        XMPPTCPConnectionConfiguration.Builder config = XMPPTCPConnectionConfiguration.builder();
        config.setUsernameAndPassword(username+ "@" + service, password);
        config.setServiceName(service);
        config.setHost(host);
        config.setPort(port);

        AbstractXMPPConnection connection = new XMPPTCPConnection(config.build());

        try {
            connection.connect();
        } catch (XMPPException ex) {
            chatClient.setConnection(null);
        } catch (SmackException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.login(username, password);

            // Set status to online / available
            Presence presence = new Presence(Presence.Type.available);
            connection.sendPacket(presence);
            chatClient.setConnection(connection);
        } catch (XMPPException ex) {
            chatClient.setConnection(null);
        } catch (SmackException.NotConnectedException e) {
            e.printStackTrace();
        } catch (SmackException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dismiss();
    }

    private String getText(int id) {
        EditText widget = (EditText) this.findViewById(id);
        return widget.getText().toString();
    }

}
