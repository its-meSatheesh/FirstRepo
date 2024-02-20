package com.gpsk.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IgnoreJsonProps {

//    static String inputJson = "{\"personInfo\":\"Alex\"}";
    static String inputJson = "{\"personInfo\":\"Alex\",\"affiliations\":[{\"type\":\"email\",\"communicationChannels\":{\"emails\":[{\"emailAddress\":\"test1@mailinator.com\"}]}},{\"type\":\"email\",\"communicationChannels\":{\"emails\":[{\"emailAddress\":\"test2@mailinator.com\"}]}}]}";

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Test:::::" + inputJson);
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
                .configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);

        PersonInformation personInformation = mapper.readValue(inputJson, PersonInformation.class);

        System.out.println("Result:::::" +
        personInformation.getPersonInfo().equals("Alex"));


    }
}
