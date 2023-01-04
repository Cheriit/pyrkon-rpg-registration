package com.cherit.callbacks;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AcceptEntryCallback implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("acceptEntryMsg")
                .processInstanceId(execution.getVariable("parentBussinesKey").toString())
                .setVariable("ticket", execution.getVariable("ticket"))
                .setVariable("game_name", execution.getVariable("game_name"))
                .setVariable("inicjator", execution.getVariable("inicjator"))
                .correlateWithResult();
    }

}
