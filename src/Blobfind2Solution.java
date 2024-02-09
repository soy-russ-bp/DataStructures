//blobfind tests code to find similar pixels of a minimum size and groups them together for analysis later  
//purpose is to identify color coded objects through the webcam  

//util for ArrayList  

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Blobfind2Solution {

    //width and height of image in pixels
    private int width;
    private int height;
    //hash code for the color being searched for
    private int colorCode;
    //minimum blob size to be added
    private int minPixels;
    //image in form of array of hashcodes for each pixel
    private int[] img;
    //keeping track of which pixels have been added to a blob
    private boolean[] added;
    //keeping track of which pixels have been visited when looking for a new blob
    private boolean[] visited;

    //debugging variable
    private int count;

    public Blobfind2Solution(int inwidth, int inheight, int inCCode, int inminPixels, int[] inimage) {
        width = inwidth;
        height = inheight;
        colorCode = inCCode;
        minPixels = inminPixels;
        img = inimage;
        count = 0;
    }

    //takes hashCodeof color, minimum pixel number, and an image in the form of integer array
    public ArrayList findColor() {
        //makes an arraylist of "blobs"
        ArrayList bloblist = new ArrayList();
        //keep track of which pixels have been added to a blob
        boolean[] added = new boolean[width * height];
        //checks through each pixel
        for (int i = 0; i < img.length; i++) {
            //if it matches and is not part of a blob, we run dfs to collect all the pixels in   that blob
            if ((img[i] == colorCode) && (added[i] == false)) {
                //visited keeps track of which pixels in the blob have been visited
                //refreshed each time a new blob is made
                boolean[] visited = new boolean[width * height];
                Blob currBlob = new Blob();
                dfs(img, currBlob, i, Color.white.hashCode(), added, visited);
                //adds the blob to the bloblist if it is of a certain size
                if (currBlob.mass() >= minPixels) {
                    bloblist.add(currBlob);
                }
            }
        }
        return bloblist;
    }

    //recursive algorithm to find other members of a blob
    public void dfs(int[] img, Blob blob, int startPixel, int colorCode, boolean[] added, boolean[] visited) {
        // Create a stack to perform depth-first search iteratively
        Stack<Integer> stack = new Stack<>();
        stack.push(startPixel);

        while (!stack.isEmpty()) {
            int currPixel = stack.pop();

            if (!visited[currPixel]) {
                blob.add(img[currPixel]);
                added[currPixel] = true;
                visited[currPixel] = true;
            }

            // Check down pixel
            if ((currPixel + width < height * width) && (!visited[currPixel + width])) {
                if (img[currPixel + width] == colorCode) {
                    blob.add(img[currPixel + width]);
                    stack.push(currPixel + width);
                    added[currPixel + width] = true;
                    visited[currPixel + width] = true;
                }
            }

            // Check up pixel
            if ((currPixel - width >= 0) && (!visited[currPixel - width])) {
                if (img[currPixel - width] == colorCode) {
                    blob.add(img[currPixel - width]);
                    stack.push(currPixel - width);
                    added[currPixel - width] = true;
                    visited[currPixel - width] = true;
                }
            }

            // Check right pixel
            if ((currPixel + 1 < width * height) && (((currPixel + 1) % width) != 0) && (!visited[currPixel + 1])) {
                if (img[currPixel + 1] == colorCode) {
                    blob.add(img[currPixel + 1]);
                    stack.push(currPixel + 1);
                    added[currPixel + 1] = true;
                    visited[currPixel + 1] = true;
                }
            }

            // Check left pixel
            if ((currPixel - 1 >= 0) && (((currPixel - 1) % width) != width - 1) && (!visited[currPixel - 1])) {
                if (img[currPixel - 1] == colorCode) {
                    blob.add(img[currPixel - 1]);
                    stack.push(currPixel - 1);
                    added[currPixel - 1] = true;
                    visited[currPixel - 1] = true;
                }
            }
        }
    }

    //test case, makes a new image thats half black and half white
    //should only return one blob of size width*height/2
    public static void main(String[] args) {
        int width = 320;
        int height = 240;
        //builds the image
        int[] img = new int[width * height];
        for (int i = 0; i < img.length; i++) {
            if (i < img.length / 4) {
                img[i] = Color.white.hashCode();
            } else {
                img[i] = Color.black.hashCode();
            }
        }

        //runs blobfind
        Blobfind2Solution bf = new Blobfind2Solution(width, height, Color.white.hashCode(), 1, img);
        ArrayList bloblist = bf.findColor();
        System.out.println(bloblist.size());
        //need to typecast things coming out of arraylists
        Blob firstblob = (Blob) bloblist.get(0);
        System.out.println(firstblob.mass());
    }

    private class Blob {
        private ArrayList pixels = new ArrayList();

        private Blob() {
        }

        private int mass() {
            return pixels.size();
        }

        private void add(int i) {
            pixels.add(i);
        }

        private ArrayList getBlob() {
            return pixels;
        }
    }

}   