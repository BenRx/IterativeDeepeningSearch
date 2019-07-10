// Benjamin Roux - bsar3

public class Edge {
    private Vertex mV1;
    private Vertex mV2;

    public Edge(Vertex v1, Vertex v2) {
        mV1 = v1;
        mV2 = v2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            return (((Edge) obj).mV1.equals(mV1) && ((Edge) obj).mV2.equals(mV2)) || (((Edge) obj).mV1.equals(mV2) && ((Edge) obj).mV2.equals(mV1));
        }
        return false;
    }

    public Vertex getV1() {
        return mV1;
    }

    public Vertex getV2() {
        return mV2;
    }
}
