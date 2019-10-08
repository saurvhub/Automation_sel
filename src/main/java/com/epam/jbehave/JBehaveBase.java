package com.epam.jbehave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;

/**
 * @author Saurabh_Verma This class extends JunitStores and contains
 *         Configuration related code
 */
public class JBehaveBase extends JUnitStories {

    /*
     * (non-Javadoc)
     *
     * @see org.jbehave.core.ConfigurableEmbedder#configuration()
     */
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().
                useStoryLoader(new LoadFromClasspath(getClass()
                        .getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder().withFormats(
                        Format.CONSOLE, Format.STATS, Format.HTML));

    }

    /*
     * (non-Javadoc)
     *
     * @see org.jbehave.core.ConfigurableEmbedder#stepsFactory()
     */
    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new JBehaveSteps());

        return new InstanceStepsFactory(configuration(), stepFileList);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.jbehave.core.junit.JUnitStories#storyPaths()
     */
    @Override
    protected List<String> storyPaths() {

        return new StoryFinder().findPaths(
                CodeLocations.codeLocationFromClass(this.getClass()),
                Arrays.asList("google.story"), Arrays.asList(""));
    }

}
