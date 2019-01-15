package com.practice;

import java.util.Stack;

/**
 * Created by Uday on 2016-05-19.
 */
public class Graph {

    private final int maxVertices=8;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack theStack;

    public Graph() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount=0;
        for(int i=0;i<vertexCount;i++) {
            for(int j=0;j<vertexCount;j++)
                adjMatrix[i][j]=0;
        }
        theStack = new Stack();

    }

    public void addVertex(char lab) {
        vertexList[vertexCount++]=new Vertex(lab);

    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end]=1;
        adjMatrix[end][start]=1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label+ " ");
    }

    public void depthFirstSearch() {

        vertexList[0].visited=true;
        displayVertex(0);
        theStack.push(0);

        while(!theStack.isEmpty()) {

            int v= getAdjUnvisitedVertex((Integer)theStack.peek());
            if(v==-1)
                theStack.pop();

            else {
                vertexList[v].visited=true;
                displayVertex(v);
                theStack.push(v);
            }

        }

        for(int j=0;j<vertexCount;j++)
            vertexList[j].visited=false;

    }

    public int getAdjUnvisitedVertex(int v) {

        for(int i=0;i<vertexCount;i++)
            if(adjMatrix[v][i]==1 && vertexList[i].visited==false)
                return i;

        return -1;
    }

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('F');
        graph.addVertex('E');
        graph.addVertex('G');
        graph.addVertex('H');

        graph.addEdge(0,1);
        graph.addEdge(1,7);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(2,3);
        graph.addEdge(5,4);
        graph.addEdge(5,6);
        graph.addEdge(7,5);
        graph.addEdge(7,1);

        graph.depthFirstSearch();
    }

}
