package com.cherit;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.dmn.engine.DmnDecisionRuleResult;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

import java.util.Map;

@ProcessApplication("Pyrkon RPG Registration")
public class PyrkonRpgRegistration extends ServletProcessApplication {
    @PostDeploy
    public void evaluateDecisionTable(ProcessEngine processEngine) {
        DecisionService decisionService = processEngine.getDecisionService();

        VariableMap variables = Variables.createVariables();
        // TODO

        DmnDecisionTableResult decisionResult = decisionService.evaluateDecisionTableByKey("", variables);
        DmnDecisionRuleResult sr = decisionResult.getSingleResult();

        if (decisionResult.getSingleResult().containsKey("")) {
            // TODO
        }

        for (Map<String, Object> result : decisionResult.getResultList()) {
            for (Map.Entry<String, Object> entry : result.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
        }
    }
}