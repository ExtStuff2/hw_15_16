package com.fun.postofficeapi.models;

import java.util.UUID;

public class Client {

  private UUID clientId;
  private String clientName;

  private String clientSurname;

  public UUID getClientId() {
    return clientId;
  }

  public void setClientId(UUID clientId) {
    this.clientId = clientId;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getClientSurname() {
    return clientSurname;
  }

  public void setClientSurname(String clientSurname) {
    this.clientSurname = clientSurname;
  }
}
