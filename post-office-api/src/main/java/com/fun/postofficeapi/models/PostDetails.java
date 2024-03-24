package com.fun.postofficeapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDetails {
    private String postItem;
    private String postStatus;
    private String senderName;
    private String senderSurname;
    private String receiverName;
    private String receiverSurname;

}
