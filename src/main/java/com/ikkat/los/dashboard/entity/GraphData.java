package com.ikkat.los.dashboard.entity;



import java.util.List;

public class GraphData {
    private List<GraphBarByMonths> graph;
    private DoghnutChartData donuts;

    public List<GraphBarByMonths> getGraph() {
        return graph;
    }

    public void setGraph(List<GraphBarByMonths> graph) {
        this.graph = graph;
    }

    public DoghnutChartData getDonuts() {
        return donuts;
    }

    public void setDonuts(DoghnutChartData donuts) {
        this.donuts = donuts;
    }
}
