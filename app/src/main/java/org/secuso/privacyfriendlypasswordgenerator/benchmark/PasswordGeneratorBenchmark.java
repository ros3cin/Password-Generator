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
                1,
                1,
                "SHA256");
        int count = BenchmarkConfiguration.getInstance().getNumberOfWarmUpIterations();
        while(count-- > 0) {
            generator.getPassword(1,1,1,1,1);
        }
    }

    @Override
    public void runBenchmark() {
        PasswordGenerator generator = new PasswordGenerator("domain",
                "username",
                "masterpassword_masterpassword_masterpassword_",
                "deviceid",
                1,
                1,
                "SHA256");
        int count = BenchmarkConfiguration.getInstance().getNumberOfIterations();
        while(count-- > 0) {
            generator.getPassword(1,1,1,1,1);
        }
        (new DefaultBenchmarkEndedCallback()).execute();
    }
}
