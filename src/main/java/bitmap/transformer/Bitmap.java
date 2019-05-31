package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Bitmap {

    private Path filepath;

    public Bitmap(Path filepath) {
        this.filepath = filepath;
    }

    public void grayscaleBMP(){
        BufferedImage img = null;
        File inputFile = null;

        //read image
        try{
            inputFile = new File(String.valueOf(this.filepath));
            img = ImageIO.read(inputFile);
        }catch(IOException e){
            System.out.println(e);
        }

        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to grayscale
        for(int row = 0; row < height; row++){
            for(int column = 0; column < width; column++){
                int RGB = img.getRGB(column,row);

                int a = (RGB>>24)&0xff;
                int r = (RGB>>16)&0xff;
                int g = (RGB>>8)&0xff;
                int b = RGB&0xff;

                //calculate average
                int avg = (r+g+b)/3;

                //replace RGB value with avg
                RGB = (a<<24) | (avg<<16) | (avg<<8) | avg;

                img.setRGB(column, row, RGB);

            }
        }

        //write image
        try{
            inputFile = new File("assets/" + "NEWLAND.bmp");
            ImageIO.write(img, "bmp", inputFile);
        }catch(IOException e){
            System.out.println(e);
        }
    }





}//end of class
