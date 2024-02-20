package com.gpsk.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonInformation {
    @JsonProperty("personInfo")
    private String personInfo;

    private List<Affiliation> affiliations;

    @SuppressWarnings("unchecked")
        @JsonIgnoreProperties({ "communicationChannels", "personNames" })
    @JsonProperty("affiliations")
    private void unpackNestedAffiliations(List<Map<String, String>> affilaitions) {
        this.affiliations = affilaitions.stream()
                .map(affilation -> new Affiliation(affilation.get("type")))
                .collect(Collectors.toList());

    }


}

//{
//        "personInfo" : "Alex",
//        "communication" : [
//        {
//        "type" : "email",
//        "emails" : [
//        {
//        "emailAddress": "test1@mailinator.com"
//        }
//        ]
//        },
//        {
//        "type" : "email",
//        "emails" : [
//        {
//        "emailAddress": "test2@mailinator.com"
//        }
//        ]
//        }
//        ]
//
// }