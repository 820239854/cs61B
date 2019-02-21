package hw2;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {
    boolean[] grid;
    int size,numberOfOpenSites;
    WeightedQuickUnionUF pick;
    public Percolation(int N){
        if(N<=0){
            throw new IndexOutOfBoundsException();
        }
        this.grid = new boolean[N*N];
        this.size = N;
        this.numberOfOpenSites = 0;
        this.pick = new WeightedQuickUnionUF(N*N+2*N);
    }

    public int to1D(int row, int col){
        return row*size + col;
    }

    public void openNeighbor(int row, int col){
        if(row>0){
            if(this.isOpen(row-1,col)){
                pick.union(to1D(row-1,col),to1D(row,col));
            }
        }
        if(row<size-1){
            if(this.isOpen(row+1,col)){
                pick.union(to1D(row+1,col),to1D(row,col));
            }
        }
        if(col>0){
            if(this.isOpen(row,col-1)){
                pick.union(to1D(row,col-1),to1D(row,col));
            }
        }
        if(col < size-1){
            if(this.isOpen(row,col+1)){
                pick.union(to1D(row,col+1),to1D(row,col));
            }
        }
    }

    public void open(int row, int col){
        if(row<0 || row>=size || col<0 || col>=size){
            throw new IndexOutOfBoundsException();
        }
        if(row == 0){
            pick.union(size*size+col,to1D(row,col));
        }
        if(row == size-1){
            pick.union(size*(size+1)+col,to1D(row,col));
        }
        if(grid[to1D(row,col)] == false){
            this.numberOfOpenSites++;
            grid[to1D(row,col)] = true;
        }
        openNeighbor(row,col);
    }

    public boolean isOpen(int row, int col){
        if(row<0 || row>=size || col<0 || col>=size){
            throw new IndexOutOfBoundsException();
        }
        return grid[to1D(row,col)];
    }

    public boolean isFull(int row, int col){
        if(row<0 || row>=size || col<0 || col>=size){
            throw new IndexOutOfBoundsException();
        }
//        return pick.connected(size*size, to1D(row,col));
//        for(int i=0; i<size; i++){
//                if(pick.connected(size*size+i, to1D(row,col)) == true){
//                    return true;
//            }
//        }
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(this.pick.connected(size*size+i, size*(size+1)+j) == true){
                    return true;
                }
            }
        }
        return false;
    }

    public int numberOfOpenSites(){
        return this.numberOfOpenSites;
    }

    public boolean percolates(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(this.pick.connected(size*size+i, size*(size+1)+j) == true){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)  {

    }
}
