package org.apache.camel.example.salesforce;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.component.salesforce.SalesforceEndpointConfig;
import org.apache.camel.component.salesforce.SalesforceLoginConfig;
import org.apache.camel.component.salesforce.SalesforceComponent;

public class SalesforceExample {

    public static void main(String[] args) throws Exception {

        // create a new Camel context
        CamelContext context = new DefaultCamelContext();

        // create a Salesforce login configuration
 /*       SalesforceLoginConfig loginConfig = new SalesforceLoginConfig();
        loginConfig.setClientId("3MVG9pe2TCoA1Pf71peHr05nNwi9w5dpCqWu7hTfSEeUFTTQcWbA9wBep2jimila6PCjwLAF.g6I0pNN7oBRt");
        loginConfig.setClientSecret("C4BD2C6D16552F16C1607FE4B6A3AA16120B116FBC2AB0ADF2B0AF391D4EAC10");
        loginConfig.setUserName("akm2k8sfl@gmail.com");
        loginConfig.setPassword("Wellsfargo@123456");*/

        // create a Salesforce endpoint configuration
      /*  SalesforceEndpointConfig endpointConfig = new SalesforceEndpointConfig();
        endpointConfig.setApiVersion("42.0");*/

        // create a Salesforce component
        SalesforceComponent component = new SalesforceComponent();
        //component.setLoginConfig(loginConfig);
       // component.setConfig(endpointConfig);
        //component.set
        //component.setEndpointConfig(endpointConfig);
        component.setClientId("3MVG9pe2TCoA1Pf71peHr05nNwi9w5dpCqWu7hTfSEeUFTTQcWbA9wBep2jimila6PCjwLAF.g6I0pNN7oBRt");
        component.setClientSecret("C4BD2C6D16552F16C1607FE4B6A3AA16120B116FBC2AB0ADF2B0AF391D4EAC10");
        component.setUserName("akm2k8sfl@gmail.com");
        component.setPassword("Wells@1234");

        // add the Salesforce component to the Camel context
        context.addComponent("salesforce", component);

        // define a Camel route to retrieve Salesforce account records
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("salesforce:query?sObjectQuery=SELECT Id, Name FROM Account")
                        .log("Received record with Id=${body[0]}, Name=${body[1]}")
                        .to("log:SalesforceAccounts");
            }
        });

        // start the Camel context
        context.start();

        // wait for the route to complete
        Thread.sleep(5000);

        // stop the Camel context
        context.stop();
    }
}
