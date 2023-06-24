
/**
 * A filter that brightens the image by 10 in the RGB value scale up until it hits 255 or is over 255
 *
 * @author Comingupwithnames
 * @version 1
 */
public class LightenFilter implements Filter
{
    /**
     * A method for filter that lightens the image
     *
     * @param  PixelImage image to modify
     * @return    void
     */
    public void filter(PixelImage image)
    {
        Pixel[][] data = image.getData();
        for(int row = 0; row<image.getHeight();row++)
        {
            for(int col = 0; col<image.getWidth();col++)
            {
                Pixel currentPixel = data[row][col];
                int redVal = currentPixel.getRed();//Retrieves the red value RGB of the pixel
                int greenVal = currentPixel.getGreen();//Retrieves the green RGB value of the pixel
                int blueVal = currentPixel.getBlue();//Retrieves the blue RGB value of the pixel
                redVal +=10;//Increments the value for red up by 10
                greenVal += 10;//Increments the value for green up by 10
                blueVal += 10;//Increments the value for blue up by 10
                if(redVal==255||redVal>255)//Checks to see if the value is equal to 255 or if the arithmetic surpassed it, then sets the value to 255
                {
                    redVal = 255;  
                }
                if(greenVal==255||greenVal>255)//Checks to see if the value is equal to 255 or if the arithmetic surpassed it, then sets the value to 255
                {
                    greenVal = 255;   
                }
                if(blueVal==255||blueVal>255)//Checks to see if the value is equal to 255 or if the arithmetic surpassed it, then sets the value to 255
                {
                    blueVal = 255;   
                }
                currentPixel.setAllColors(redVal,greenVal,blueVal);
            }
        }
        image.setData(data); 
    }
}
