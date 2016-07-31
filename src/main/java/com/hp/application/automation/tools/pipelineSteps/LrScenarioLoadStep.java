package com.hp.application.automation.tools.pipelineSteps;


import com.hp.application.automation.tools.model.EnumDescription;
import com.hp.application.automation.tools.model.ResultsPublisherModel;
import hudson.Extension;
import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.Nonnull;
import java.util.List;

public class LrScenarioLoadStep extends AbstractStepImpl {
    @DataBoundConstructor
    public LrScenarioLoadStep() {
    }

    @Extension
    public static class DescriptorImpl extends AbstractStepDescriptorImpl {
        public DescriptorImpl() { super(LrScenarioLoadStepExecutor.class); }

        @Override
        public String getFunctionName() {
            return "RunLoadRunnerScenario";
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return "Run LoadRunner scenario";
        }

        public List<EnumDescription> getReportArchiveModes() {

            return ResultsPublisherModel.archiveModes;
        }
    }

}
