package com.mycompany;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class Generator extends AbstractMojo {
    @Parameter(name = "packageName", required = true)
    String packageName;
    @Parameter(name = "headerLocation", required = true)
    String headerLocation;
    @Parameter(name = "buildCommand", required = false)
    String buildCommand;

    @Override
    public void execute() throws MojoExecutionException {
        // org.bytedeco.javacpp.tools.Generator
        // getLog().info("Hello, world.");
    }
}
