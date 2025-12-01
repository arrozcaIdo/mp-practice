import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class EvacuationSimulation {
    // Agent class
    static class Agent {
        private final int id;
        private double x, y;
        private final double radius;
        private double speed;
        private double panicLevel;
        private boolean evacuated;
        private final java.util.List<double[]> pathHistory;

        public Agent(int id, double x, double y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.radius = 0.3;
            this.speed = 1.0 + (Math.random() * 0.4 - 0.2);
            this.panicLevel = Math.random() * 0.2 + 0.1;
            this.evacuated = false;
            this.pathHistory = new ArrayList<>();
            recordPosition();
        }

        public void moveTowardsExit(double exitX, double exitY, java.util.List<Agent> allAgents) {
            if (evacuated) return;

            double dx = exitX - x;
            double dy = exitY - y;
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance < 0.5) {
                evacuated = true;
                return;
            }

            if (distance > 0.1) {
                dx /= distance;
                dy /= distance;

                double noiseX = (Math.random() * 0.2 - 0.1) * panicLevel;
                double noiseY = (Math.random() * 0.2 - 0.1) * panicLevel;

                double movementX = dx * speed * (1 + panicLevel * 0.5) + noiseX;
                double movementY = dy * speed * (1 + panicLevel * 0.5) + noiseY;

                // Collision avoidance
                for (Agent other : allAgents) {
                    if (other.id != id && !other.evacuated) {
                        double otherDx = x - other.x;
                        double otherDy = y - other.y;
                        double distToOther = Math.sqrt(otherDx * otherDx + otherDy * otherDy);

                        if (distToOther < 1.0) {
                            double avoidX = otherDx / Math.max(distToOther, 0.1);
                            double avoidY = otherDy / Math.max(distToOther, 0.1);
                            movementX += avoidX * 0.3;
                            movementY += avoidY * 0.3;
                        }
                    }
                }

                x += movementX;
                y += movementY;

                x = Math.max(radius, Math.min(49 - radius, x));
                y = Math.max(radius, Math.min(49 - radius, y));

                recordPosition();
            }
        }

        private void recordPosition() {
            pathHistory.add(new double[]{x, y});
        }

        public int getId() { return id; }
        public double getX() { return x; }
        public double getY() { return y; }
        public double getRadius() { return radius; }
        public double getPanicLevel() { return panicLevel; }
        public boolean isEvacuated() { return evacuated; }
        public java.util.List<double[]> getPathHistory() { return new ArrayList<>(pathHistory); }
    }

    // Exit class
    static class Exit {
        private final int id;
        private final double x, y;
        private final double width;
        private int agentsExited;

        public Exit(int id, double x, double y, double width) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.width = width;
            this.agentsExited = 0;
        }

        public void agentExited() {
            agentsExited++;
        }

        public int getId() { return id; }
        public double getX() { return x; }
        public double getY() { return y; }
        public double getWidth() { return width; }
        public int getAgentsExited() { return agentsExited; }
    }

    // Statistics class
    static class SimulationStatistics {
        private final java.util.List<Integer> evacuationProgress;
        private final java.util.List<Double> averagePanicLevels;
        private final Map<String, Object> scenarioMetrics;

        public SimulationStatistics() {
            this.evacuationProgress = new ArrayList<>();
            this.averagePanicLevels = new ArrayList<>();
            this.scenarioMetrics = new HashMap<>();
        }

        public void recordTimestep(int evacuatedCount, double avgPanic) {
            evacuationProgress.add(evacuatedCount);
            averagePanicLevels.add(avgPanic);
        }

        public void calculateFinalMetrics(int totalAgents, int totalSteps) {
            double efficiency = totalAgents > 0 ? (double) totalAgents / totalSteps : 0;
            scenarioMetrics.put("totalEvacuationTime", totalSteps);
            scenarioMetrics.put("efficiency", efficiency);
            scenarioMetrics.put("finalEvacuated", evacuationProgress.isEmpty() ? 0 : evacuationProgress.get(evacuationProgress.size() - 1));
        }

        public java.util.List<Integer> getEvacuationProgress() { return new ArrayList<>(evacuationProgress); }
        public java.util.List<Double> getAveragePanicLevels() { return new ArrayList<>(averagePanicLevels); }
        public Map<String, Object> getScenarioMetrics() { return new HashMap<>(scenarioMetrics); }
    }

    // Visualization panel
    static class SimulationPanel extends JPanel {
        private final EvacuationSimulation simulation;

        public SimulationPanel(EvacuationSimulation simulation) {
            this.simulation = simulation;
            setPreferredSize(new Dimension(600, 600));
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Scale factor for visualization
            double scale = Math.min(getWidth() / 50.0, getHeight() / 50.0);

            // Draw exit
            Exit exit = simulation.exits.get(0);
            g2d.setColor(Color.BLUE);
            int exitX = (int) (exit.getX() * scale - exit.getWidth() * scale / 2);
            int exitY = (int) (exit.getY() * scale);
            g2d.fillRect(exitX, exitY, (int)(exit.getWidth() * scale), 10);
            g2d.setColor(Color.BLACK);
            g2d.drawString("EXIT", exitX, exitY - 5);

            // Draw agents
            for (Agent agent : simulation.agents) {
                if (agent.isEvacuated()) {
                    g2d.setColor(Color.GREEN);
                } else {
                    // Color based on panic level (red = high panic)
                    int red = (int) (agent.getPanicLevel() * 255);
                    int green = (int) ((1 - agent.getPanicLevel()) * 255);
                    g2d.setColor(new Color(red, green, 0));
                }

                int agentX = (int) (agent.getX() * scale);
                int agentY = (int) (agent.getY() * scale);
                int radius = (int) (agent.getRadius() * scale * 2);

                g2d.fillOval(agentX - radius/2, agentY - radius/2, radius, radius);

                // Draw path history
                if (!agent.isEvacuated()) {
                    g2d.setColor(new Color(255, 0, 0, 100));
                    java.util.List<double[]> path = agent.getPathHistory();
                    for (int i = 1; i < path.size(); i++) {
                        double[] prev = path.get(i-1);
                        double[] curr = path.get(i);
                        int x1 = (int) (prev[0] * scale);
                        int y1 = (int) (prev[1] * scale);
                        int x2 = (int) (curr[0] * scale);
                        int y2 = (int) (curr[1] * scale);
                        g2d.drawLine(x1, y1, x2, y2);
                    }
                }
            }

            // Draw info
            g2d.setColor(Color.BLACK);
            g2d.drawString("Time Step: " + simulation.timeStep, 10, 20);
            g2d.drawString("Evacuated: " + simulation.getEvacuatedCount() + "/" + simulation.agents.size(), 10, 40);
            g2d.drawString("Scenario: " + simulation.scenarioName, 10, 60);
        }
    }

    // Main simulation class
    private final int width;
    private final int height;
    private final java.util.List<Agent> agents;
    private final java.util.List<Exit> exits;
    private int timeStep;
    private final SimulationStatistics statistics;
    private final String scenarioName;

    public EvacuationSimulation(int numAgents, String scenarioName) {
        this.width = 50;
        this.height = 50;
        this.agents = new ArrayList<>();
        this.exits = new ArrayList<>();
        this.timeStep = 0;
        this.statistics = new SimulationStatistics();
        this.scenarioName = scenarioName;

        initializeExits();
        initializeAgents(numAgents);
    }

    private void initializeExits() {
        exits.add(new Exit(1, 25, 49, 4.0));
    }

    private void initializeAgents(int numAgents) {
        Random random = new Random();
        for (int i = 0; i < numAgents; i++) {
            double x = 5 + random.nextDouble() * 40;
            double y = 5 + random.nextDouble() * 40;
            agents.add(new Agent(i, x, y));
        }
    }

    public void runStep() {
        timeStep++;
        Exit exit = exits.get(0);

        // Update each agent
        for (Agent agent : agents) {
            if (!agent.isEvacuated()) {
                agent.moveTowardsExit(exit.getX(), exit.getY(), agents);
                if (agent.isEvacuated()) {
                    exit.agentExited();
                }
            }
        }

        // Record statistics
        int evacuatedCount = getEvacuatedCount();
        double avgPanic = agents.stream()
                .filter(a -> !a.isEvacuated())
                .mapToDouble(Agent::getPanicLevel)
                .average()
                .orElse(0.0);

        statistics.recordTimestep(evacuatedCount, avgPanic);
    }

    public int getEvacuatedCount() {
        return (int) agents.stream().filter(Agent::isEvacuated).count();
    }

    public boolean isComplete() {
        return getEvacuatedCount() >= agents.size();
    }

    public void runSimulation(int maxSteps) {
        System.out.println("Starting evacuation simulation: " + scenarioName);
        System.out.println("Initial conditions: " + agents.size() + " agents, " + exits.size() + " exit");

        for (int step = 0; step < maxSteps; step++) {
            runStep();

            if (step % 20 == 0) {
                System.out.printf("Step %d: %d/%d evacuated (%.1f%%)%n",
                        step, getEvacuatedCount(), agents.size(),
                        (getEvacuatedCount() * 100.0 / agents.size()));
            }

            if (isComplete()) {
                System.out.printf("✓ Evacuation complete at step %d!%n", step);
                break;
            }
        }

        if (!isComplete()) {
            System.out.printf("✗ Simulation ended after %d steps%n", maxSteps);
            System.out.printf("Final status: %d/%d evacuated (%.1f%%)%n",
                    getEvacuatedCount(), agents.size(),
                    (getEvacuatedCount() * 100.0 / agents.size()));
        }

        statistics.calculateFinalMetrics(agents.size(), timeStep);
    }

    public void displayResults() {
        Map<String, Object> metrics = statistics.getScenarioMetrics();
        System.out.println("\n" + "=".repeat(50));
        System.out.println("FINAL RESULTS: " + scenarioName);
        System.out.println("=".repeat(50));
        System.out.printf("Total evacuation time: %d steps%n", metrics.get("totalEvacuationTime"));
        System.out.printf("Efficiency: %.2f agents/step%n", metrics.get("efficiency"));
        System.out.printf("Success rate: %.1f%%%n",
                ((Integer)metrics.get("finalEvacuated") * 100.0 / agents.size()));
    }

    // Getters for visualization
    public java.util.List<Agent> getAgents() { return agents; }
    public java.util.List<Exit> getExits() { return exits; }
    public int getTimeStep() { return timeStep; }
    public String getScenarioName() { return scenarioName; }

    // Main method
    public static void main(String[] args) {
        System.out.println("EVACUATION DYNAMICS SIMULATION");
        System.out.println("=".repeat(50));

        // Test different scenarios
        java.util.List<Scenario> scenarios = Arrays.asList(
                new Scenario(30, "Light Crowding"),
                new Scenario(50, "Medium Crowding"),
                new Scenario(80, "Heavy Crowding")
        );

        java.util.List<EvacuationSimulation> simulations = new ArrayList<>();

        // Run simulations
        for (Scenario scenario : scenarios) {
            System.out.println("\n" + "=".repeat(50));

            EvacuationSimulation sim = new EvacuationSimulation(scenario.agentCount, scenario.name);
            simulations.add(sim);

            // Run simulation
            sim.runSimulation(200);
            sim.displayResults();

            // Show visualization for medium scenario
            if (scenario.agentCount == 50) {
                showVisualization(sim);
            }
        }

        // Comparative analysis
        System.out.println("\n" + "=".repeat(50));
        System.out.println("COMPARATIVE ANALYSIS");
        System.out.println("=".repeat(50));

        for (EvacuationSimulation sim : simulations) {
            Map<String, Object> metrics = sim.statistics.getScenarioMetrics();
            System.out.printf("%s:%n", sim.getScenarioName());
            System.out.printf("  Efficiency: %.3f agents/step%n", metrics.get("efficiency"));
            System.out.printf("  Total time: %d steps%n", metrics.get("totalEvacuationTime"));
            System.out.printf("  Agents: %d%n", sim.agents.size());
            System.out.println();
        }
    }

    static void showVisualization(EvacuationSimulation simulation) {
        JFrame frame = new JFrame("Evacuation Simulation - " + simulation.getScenarioName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimulationPanel panel = new SimulationPanel(simulation);
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Animation loop
        Timer timer = new Timer(100, e -> {
            if (!simulation.isComplete()) {
                simulation.runStep();
                panel.repaint();
            }
        });
        timer.start();
    }

    static class Scenario {
        int agentCount;
        String name;

        Scenario(int agentCount, String name) {
            this.agentCount = agentCount;
            this.name = name;
        }
    }
}
