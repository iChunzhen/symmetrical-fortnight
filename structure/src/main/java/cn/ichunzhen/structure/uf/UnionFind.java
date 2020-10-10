package cn.ichunzhen.structure.uf;

/**
 *
 */
class UnionFind implements UF {
    private int[] rank;
    private int[] parent;

    public UnionFind(int size) {
        rank = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p])
            p = find(parent[p]);
        return parent[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[p] < rank[q]) {
            parent[p] = qRoot;
        } else if (rank[p] > rank[q]) {
            parent[q] = pRoot;
        } else {
            parent[q] = pRoot;
            rank[p] += 1;
        }

    }
}
