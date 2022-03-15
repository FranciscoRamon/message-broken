package br.com.endoffile.model.enums;

public enum ActionEnum {

    CREATE_USER("create_user"),
    UPDATE_USER("update_user"),
    DELETE_USER("delete_user"),

    SEND_MAIL("send_mail"),
    RECEIVE_MAIL("receive_mail");


    private String context;

    ActionEnum(String context){
        this.context = context;
    }

    public String getContext() {
        return context;
    }
}

