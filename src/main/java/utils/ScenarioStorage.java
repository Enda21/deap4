package utils;

import java.util.HashMap;

import io.cucumber.java.Scenario;

public class ScenarioStorage {
    private static final HashMap<Thread, Scenario> map = new HashMap<>();

    public static void putScenario(Scenario scenario) {
        map.put(Thread.currentThread(), scenario);
    }

    public static Scenario getScenario() {
        return map.get(Thread.currentThread());
    }

}