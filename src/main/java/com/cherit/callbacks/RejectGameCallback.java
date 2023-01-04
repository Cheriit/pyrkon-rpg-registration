package com.cherit.callbacks;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RejectGameCallback implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("rejectGameMsg")
                .processInstanceId(execution.getProcessInstanceId())
                .setVariable("game_name", execution.getVariable("game_name"))
                .setVariable("inicjator", execution.getVariable("inicjator"))
                .correlateWithResult();    }
}
