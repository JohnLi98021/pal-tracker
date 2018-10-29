package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;

    private String memorylimit;

    private String cfinstindex;

    private String cfinsaddr;

   public  EnvController(
            @Value("${PORT:NOT SET}")
            String port,
            @Value("${MEMORY_LIMIT:NOT SET}")
            String memorylimit,
            @Value("${CF_INSTANCE_INDEX:NOT SET}")
            String cfinstindex,
            @Value("${CF_INSTANCE_ADDR:NOT SET}")
            String cfinsaddr
    ) {
        this.port= port;
        this.memorylimit = memorylimit;
        this.cfinstindex = cfinstindex;
        this.cfinsaddr = cfinsaddr;

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {

        Map<String, String> envMap = new HashMap<>();

        envMap.put("PORT", port);
        envMap.put("MEMORY_LIMIT", memorylimit);
        envMap.put("CF_INSTANCE_INDEX", cfinstindex);
        envMap.put("CF_INSTANCE_ADDR", cfinsaddr);

        return envMap;
    }
}
