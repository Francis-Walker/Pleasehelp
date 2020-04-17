//Francis Walker
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;


public class Map {

    private Scanner m;
    private String[] Map = null;
    private int x;
    private int y;

    private Image grass, wall, red;

    public Map(int x,int y){
        this.x =x;
        this.y = y;
        Map = new String[y];
        //stores icons for painting
        ImageIcon img = new ImageIcon(getClass().getResource("Grass.png"));
        grass = img.getImage();
        img = new ImageIcon(getClass().getResource("Wall.png"));
        wall = img.getImage();

        img = new ImageIcon(getClass().getResource("red.png"));
        red = img.getImage();
        System.out.println("images loaded red grass wall");




        genFile(this.x,this.y);
//        openFile();
//        readFile();
        //closeFile();
    }


    public Image getGrass()
    {
        return grass;
    }

    public Image getWall()
    {
        return wall;
    }
    public Image getRed()
    {
        return red;
    }

    //helper function for painting map tile y tile
    public String getMap(int ox, int oy){
        String index = Map[oy].substring(ox,ox+1);
        //System.out.println(index);
        return (index);

    }


    //open text document where map layout is stored
    public void openFile(){

        try {
            m = new Scanner(new File("resources/Maps/sampleMaps/mostRecentMap"));
        }
        catch (Exception e){
            System.out.println("error loading map:");
        }
    }

    //reads file
    public void readFile(){
        System.out.println(""+m);
        while(m.hasNext())
        {
           //
            for(int i = 0; i <this.y; i++)
            {
                //System.out.println("check"+i);

                Map[i] = m.next();
                //System.out.println(Map[i]);
            }
        }
    }
    public void closeFile(){
    m.close();
    }

    public  void genFile(int width,int height)
    {

        int numBoxes = (int)(Math.random() * 7) + 3;

        //System.out.println("check2");
        int[] arrX =new int[numBoxes];
        int[] arrY =new int[numBoxes];

        char[][] map = new char[height+1][width+1];

        for(int yv = 0; yv <= height; yv++){

            for(int xv = 0; xv <= width; xv++){
                if(xv == 0||xv==width-1||yv==0||yv==height-1)
                {

                    map[yv][xv] = 'w';
                }
                else {
                    map[yv][xv] = 'g';
                }
            }
        }



        width--;
        height--;

        int area = width*height;

        int boxSize = area/(numBoxes*2);
        //System.out.println(""+boxSize);
        for (int i = 0; i<numBoxes;i++)
        {
            int boxY = (int)(Math.random() * 5) + 5;
            int boxX = boxSize/boxY;
            arrX[i] = boxX;
            arrY[i] = boxY;
            //System.out.println(""+i+":"+arrX[i]+":"+arrY[i]);

        }


        int numlaneY = (int)(Math.random()*4);
        int numlaneX = (int)(Math.random()*4);

        boolean[] freelanesY = new boolean[height];
        boolean[] freelanesX = new boolean[width];


        for (int i = 0; i<numlaneY;i++)
        {
            int ranStart = (int)(Math.random()*height-2 +2);
            int ranSize =  (int)(Math.random()*2+1);
            for (int j =ranStart;j<(ranStart+ranSize);j++)
            {
                try{
                    freelanesY[j] = true;
                }
                catch (Exception ignored){

                }

            }
        }

        for (int i = 0; i<numlaneX;i++)
        {
            int ranStart = (int)(Math.random()*width-2 +2);
            int ranSize =  (int)(Math.random()*2+1);
            for (int j =ranStart;j<(ranStart+ranSize);j++)
                try{
                    freelanesX[j] = true;
                }
                catch (Exception ignored){

                }
        }




        for (int i =0; i<numBoxes; i++){

            int randomStartX = (int)(Math.random() * ((width-4)-arrX[i]) + 2);
            int randomStartY = (int)(Math.random() * ((height-4)-arrY[i]) + 2);

            for(int yv = randomStartY; yv<=randomStartY+arrY[i]; yv ++){
                if (!freelanesY[yv]) {
                    for (int xv = randomStartX; xv <= randomStartX + arrX[i]; xv++) {
                        if (!freelanesX[xv]) {
                            map[yv][xv] = 'w';
                        }
                    }
                }
            }

        }




        for(int yv = 0; yv <= height; yv++){
            String show = "";
                for (int xv = 0; xv <= width; xv++) {
                    show=""+show+map[yv][xv];
                }
              Map[yv] = show;

        }

        //System.out.println(show);



//        try {
//            FileWriter myWriter = new FileWriter("resources/Maps/sampleMaps/mostRecentMap");
//            myWriter.write(show.toString());
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }




    }

//    public static void main(String[] args){
//        int dim = 25;
//        genFile(dim,dim);
//    }
}

