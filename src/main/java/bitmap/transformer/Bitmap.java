package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Bitmap {

    private String filepath;
    private String outputPath;

    public Bitmap(String filepath, String outputPath) {
        this.filepath = filepath;
        this.outputPath = outputPath;
    }

    public void grayscaleBMP(){
        BufferedImage img = null;
        File inputFile = null;

        //read image
        try{
            inputFile = new File(this.filepath);
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
            inputFile = new File(this.outputPath);
            ImageIO.write(img, "bmp", inputFile);
        }catch(IOException e){
            System.out.println(e);
        }
    }


    public void invertBMP(){
        BufferedImage img = null;
        File inputPath = null;
        //read image
        try{
            inputPath = new File(String.valueOf(this.filepath));
            img = ImageIO.read(inputPath);
        }catch(IOException e){
            System.out.println(e);
        }
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        //convert to negative
        for(int row = 0; row < height; row++){
            for(int column = 0; column < width; column++){
                int RGB = img.getRGB(column,row);
                int a = (RGB>>24)&0xff;
                int r = (RGB>>16)&0xff;
                int g = (RGB>>8)&0xff;
                int b = RGB&0xff;
                //subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                //set new RGB value
                RGB = (a<<24) | (r<<16) | (g<<8) | b;
                img.setRGB(column, row, RGB);
            }
        }
        //write image
        try{
            inputPath = new File(this.outputPath);
            ImageIO.write(img, "bmp", inputPath);
        }catch(IOException e){
            System.out.println(e);
        }


    }


    public void pinkilizedBMP(){
        BufferedImage img = null;
        File inputPath = null;
        //read image
        try{
            inputPath = new File(this.filepath);
            img = ImageIO.read(inputPath);
        }catch(IOException e){
            System.out.println(e);
        }
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        //convert to negative
        for(int row = 0; row < height; row++){
            for(int column = 0; column < width; column++){
                int RGB = img.getRGB(column,row);
                int a = (RGB>>24)&0xff;
                int r = (RGB>>16)&0xff;
                int g = (RGB>>8)&0xff;
                int b = RGB&0xff;
                //subtract RGB from 255
                r = 255 + r;
                g = 105 + g;
                b = 180 + b;
                //set new RGB value
                RGB = (a<<24) | (r<<16) | (g<<8) | b;
                img.setRGB(column, row, RGB);
            }
        }
        //write image
        try{
            inputPath = new File(this.outputPath);
            ImageIO.write(img, "bmp", inputPath);
        }catch(IOException e){
            System.out.println(e);
        }

    }

    public void blueralize(){
        BufferedImage img = null;
        File inputPath = null;
        //read image
        try{
            inputPath = new File(this.filepath);
            img = ImageIO.read(inputPath);
        }catch(IOException e){
            System.out.println(e);
        }
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        //convert to negative
        for(int row = 0; row < height; row++){
            for(int column = 0; column < width; column++){
                int RGB = img.getRGB(column,row);
                int a = (RGB>>24)&0xff;
                int r = (RGB>>16)&0xff;
                int g = (RGB>>8)&0xff;
                int b = RGB&0xff;
                //subtract RGB from 255

                r = 5 + r;
                g = 20 + g;
                b = 120 + b;
                //set new RGB value
                RGB = (a<<24) | (r<<16) | (g<<8) | b;
                img.setRGB(column, row, RGB);
            }
        }
        //write image
        try{
            inputPath = new File(this.outputPath);
            ImageIO.write(img, "bmp", inputPath);
        }catch(IOException e){
            System.out.println(e);
        }

    }


}//end of class
