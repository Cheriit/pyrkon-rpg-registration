package com.cherit.requests;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;

public class AcceptDateRequest implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put("parentBussinesKey", execution.getProcessInstanceId());

        processVariables.put("game_organiser",execution.getVariable("game_organiser"));
        processVariables.put("game_name",execution.getVariable("game_name"));
        processVariables.put("inicjator",execution.getVariable("inicjator"));

        runtimeService.startProcessInstanceByMessage("acceptDateMsg", processVariables);
    }
}
