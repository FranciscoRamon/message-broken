package br.com.endoffile;

import br.com.endoffile.model.User;
import br.com.endoffile.model.enums.ActionEnum;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.List;


@ServerEndpoint("/start-websocket/{client}/{action}")
@ApplicationScoped
public class StartWebSocket {

    @Inject
    EntityManager em;

    @OnOpen
    public void onOpen(Session session, @PathParam("client") String client, @PathParam("action") String action) {
        System.out.println("onOpen> " + client);
    }

    @OnClose
    public void onClose(Session session, @PathParam("client") String client, @PathParam("action") String action) {

        System.out.println("onClose> " + client);
    }

    @OnError
    public void onError(Session session,
                        @PathParam("client") String client,
                        @PathParam("action") String action,
                    Throwable throwable) {
        System.out.println("onError> " + client + ": " + throwable);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("client") String client, @PathParam("action") String action) {

        if(ActionEnum.valueOf(action) == ActionEnum.CREATE_USER){
            Jsonb jsonb = JsonbBuilder.create();
            User p = jsonb.fromJson(message, User.class);
            em.persist(p);
        }

        TypedQuery<User> query = em.createNamedQuery("User.findByAddress", User.class);
        List<User> users = query.getResultList();
        if(users.isEmpty()){

        }


        System.out.println("onMessage> " + client + ": " + message);
    }
}
