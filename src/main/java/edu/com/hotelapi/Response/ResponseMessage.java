package edu.com.hotelapi.Response;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ResponseMessage {

    SUCCESSFUL_ADDITION("Added successfully"),
    SUCCESSFUL_MODIFICATION("Modification completed successfully"),
    SUCCESSFUL_DELETION("Deletion completed successfully");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }
}
