/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librarium.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

/**
 *
 * @author Marcos
 */
public class ConnectionCheck {

    public static boolean isConnected() {
        try {
            // URL do destino escolhido
            URL url = new URL("http://www.youtube.com");
            // abre a conexão
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            // tenta buscar conteúdo da URL
            // se não tiver conexão, essa linha irá falhar
            Object objData = urlConnect.getContent();
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
