package org.secuso.privacyfriendlypasswordgenerator.benchmark;

import org.secuso.privacyfriendlypasswordgenerator.generator.PasswordGenerator;

import br.ufpe.cin.dashbench.api.DefaultBenchmarkEndedCallback;
import br.ufpe.cin.dashbench.api.IBenchmark;
import br.ufpe.cin.dashbench.configuration.BenchmarkConfiguration;

public class PasswordGeneratorBenchmark implements IBenchmark {

    @Override
    public String getName() {
        return "PasswordGenerator";
    }

    @Override
    public void runWarmUp() {
        PasswordGenerator generator = new PasswordGenerator("domain",
                "username",
                "masterpassword_masterpassword_masterpassword_",
                "deviceid",
                BenchmarkConfiguration.getInstance().getNumberOfWarmUpIterations(),
                BenchmarkConfiguration.getInstance().getNumberOfWarmUpIterations(),
                "SHA256");
        String password = generator.getPassword(
                1,
                1,
                1,
                1,
                BenchmarkConfiguration.getInstance().getNumberOfWarmUpIterations());
    }

    @Override
    public void runBenchmark() {
        PasswordGenerator generator = new PasswordGenerator("domain",
                "username",
                "masterpassword_masterpassword_masterpassword_",
                "deviceid",
                BenchmarkConfiguration.getInstance().getNumberOfIterations(),
                BenchmarkConfiguration.getInstance().getNumberOfIterations(),
                "SHA256");
        String password = generator.getPassword(
                1,
                1,
                1,
                1,
                BenchmarkConfiguration.getInstance().getNumberOfIterations());
        (new DefaultBenchmarkEndedCallback()).execute();
    }
}
